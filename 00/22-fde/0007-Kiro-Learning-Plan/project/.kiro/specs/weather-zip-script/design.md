# Design Document

## Overview

`weather.js` is a single-file Node.js CLI script that resolves a zip code to geographic coordinates via the Open-Meteo geocoding API, then fetches hourly weather data via the Open-Meteo forecast API, and prints a JSON result to stdout. The entire implementation lives in one file with no dependencies beyond Node.js built-ins (`https`, `process`).

---

## Architecture

The script follows a linear, sequential pipeline:

```
CLI args → Zip Code Resolution → Geocoding Request → Weather Request → JSON Output
                                        ↓ (error)            ↓ (error)
                                   JSON error + exit(1)   JSON error + exit(1)
```

All HTTP I/O is handled through callback-based `https.get`. There are no classes or module boundaries — the script is structured as a set of pure helper functions composed by a top-level `main()` async function.

---

## Components

### 1. Argument Parser

Reads `process.argv[2]` and returns the zip code string. Falls back to a hardcoded default when the argument is absent.

```js
const DEFAULT_ZIP = '10001';

function getZipCode(argv) {
  return argv[2] || DEFAULT_ZIP;
}
```

**Responsibilities:**
- Extract positional CLI argument at index 2
- Return default zip code when argument is missing

---

### 2. HTTP Helper (`httpsGet`)

A promisified wrapper around `https.get` that accumulates response chunks and resolves with the parsed JSON body. Rejects on network error or non-2xx status.

```js
function httpsGet(url) {
  return new Promise((resolve, reject) => {
    https.get(url, (res) => {
      if (res.statusCode < 200 || res.statusCode >= 300) {
        return reject(new Error(`HTTP ${res.statusCode}: ${url}`));
      }
      let data = '';
      res.on('data', (chunk) => { data += chunk; });
      res.on('end', () => {
        try { resolve(JSON.parse(data)); }
        catch (e) { reject(new Error('Invalid JSON response')); }
      });
    }).on('error', reject);
  });
}
```

**Responsibilities:**
- Wrap `https.get` as a Promise
- Accumulate streamed response body
- Parse and return JSON
- Reject on network error or bad status

---

### 3. Geocoding Resolver (`resolveCoordinates`)

Constructs the geocoding API URL, calls `httpsGet`, validates the response, and returns `{ latitude, longitude }`.

```js
const GEOCODING_API = 'https://geocoding-api.open-meteo.com/v1/search';

async function resolveCoordinates(zipCode) {
  const url = `${GEOCODING_API}?name=${encodeURIComponent(zipCode)}&count=1`;
  const data = await httpsGet(url);
  if (!data.results || data.results.length === 0) {
    throw new Error(`No geocoding results for zip code: ${zipCode}`);
  }
  const { latitude, longitude } = data.results[0];
  return { latitude, longitude };
}
```

**Responsibilities:**
- Build geocoding URL with `name` and `count=1` parameters
- Validate that at least one result is returned
- Extract `latitude` and `longitude` from the first result

---

### 4. Weather Fetcher (`fetchWeather`)

Constructs the forecast API URL, calls `httpsGet`, validates the response shape, and extracts the values at the current UTC hour index.

```js
const WEATHER_API = 'https://api.open-meteo.com/v1/forecast';

async function fetchWeather(latitude, longitude) {
  const url = `${WEATHER_API}?latitude=${latitude}&longitude=${longitude}` +
              `&hourly=temperature_2m,precipitation_probability&forecast_days=1`;
  const data = await httpsGet(url);

  const hourly = data.hourly;
  if (!hourly || !Array.isArray(hourly.temperature_2m) || !Array.isArray(hourly.precipitation_probability)) {
    throw new Error('Weather API response is missing expected hourly fields');
  }

  const hourIndex = new Date().getUTCHours();
  const temperature_c = hourly.temperature_2m[hourIndex];
  const precipitation_probability_percent = hourly.precipitation_probability[hourIndex];

  if (temperature_c === undefined || precipitation_probability_percent === undefined) {
    throw new Error(`No weather data available for hour index ${hourIndex}`);
  }

  return { temperature_c, precipitation_probability_percent };
}
```

**Responsibilities:**
- Build forecast URL with all required query parameters
- Validate presence of `hourly.temperature_2m` and `hourly.precipitation_probability` arrays
- Compute current UTC hour index via `new Date().getUTCHours()`
- Extract values at the current hour index

---

### 5. Output Formatter

Two pure functions for formatting the success and error outputs.

```js
function formatSuccess(zipCode, temperature_c, precipitation_probability_percent) {
  return JSON.stringify({ zipCode, temperature_c, precipitation_probability_percent });
}

function formatError(message) {
  return JSON.stringify({ error: message });
}
```

**Responsibilities:**
- Produce clean JSON strings with no extra prose
- Keep stdout output deterministic and machine-parseable

---

### 6. Main Entry Point (`main`)

Orchestrates the pipeline, catches all errors, and handles process exit codes.

```js
async function main() {
  const zipCode = getZipCode(process.argv);
  try {
    const { latitude, longitude } = await resolveCoordinates(zipCode);
    const { temperature_c, precipitation_probability_percent } = await fetchWeather(latitude, longitude);
    process.stdout.write(formatSuccess(zipCode, temperature_c, precipitation_probability_percent) + '\n');
  } catch (err) {
    process.stdout.write(formatError(err.message) + '\n');
    process.exit(1);
  }
}

main();
```

**Responsibilities:**
- Coordinate all components in order
- Catch any thrown error from any stage and route to error output
- Exit with code 1 on any failure; exit with code 0 on success

---

## Data Models

### Geocoding API Response (relevant fields)

```js
{
  results: [
    {
      latitude: number,   // e.g. 40.7128
      longitude: number   // e.g. -74.0060
    }
    // ...additional results ignored
  ]
}
```

### Weather API Response (relevant fields)

```js
{
  hourly: {
    temperature_2m: number[],              // 24 values, one per UTC hour
    precipitation_probability: number[]   // 24 values, one per UTC hour
  }
}
```

### Success Output

```js
{
  zipCode: string,                           // e.g. "10001"
  temperature_c: number,                    // e.g. 22.4
  precipitation_probability_percent: number  // e.g. 15
}
```

### Error Output

```js
{
  error: string  // human-readable error description
}
```

---

## Error Handling

All errors are funneled through the `catch` block in `main()`. Every error path:

1. Prints a JSON object with an `error` string field to stdout
2. Exits the process with code 1

| Failure Condition | Source | Error Message |
|---|---|---|
| Geocoding API returns zero results | `resolveCoordinates` | `"No geocoding results for zip code: <zip>"` |
| Geocoding API network error | `httpsGet` | Node.js network error message |
| Geocoding API non-2xx status | `httpsGet` | `"HTTP <status>: <url>"` |
| Weather API network error | `httpsGet` | Node.js network error message |
| Weather API non-2xx status | `httpsGet` | `"HTTP <status>: <url>"` |
| Weather API missing hourly fields | `fetchWeather` | `"Weather API response is missing expected hourly fields"` |
| Weather API missing hour index | `fetchWeather` | `"No weather data available for hour index <N>"` |

No errors are swallowed silently. No stack traces or debug output go to stdout — only the JSON error object.

---

## Cross-Platform Considerations

- Only `https` and `process` are imported — both are Node.js built-ins available on all platforms.
- No `child_process`, no `fs`, no shell commands, no platform-specific path separators.
- `new Date().getUTCHours()` is used for hour index (not local time), ensuring consistent behavior across time zones.
- `process.stdout.write` is used instead of `console.log` to avoid any console formatting differences.
- The shebang line is omitted to keep the script invocation as `node weather.js`, which works uniformly on all platforms.

---

## Correctness Properties

*A property is a characteristic or behavior that should hold true across all valid executions of a system — essentially, a formal statement about what the system should do. Properties serve as the bridge between human-readable specifications and machine-verifiable correctness guarantees.*

### Property 1: Argument parsing uses argv[2] when present

*For any* non-empty string passed as `argv[2]`, the `getZipCode` function SHALL return that exact string as the zip code.

**Validates: Requirements 1.1, 1.3**

---

### Property 2: Geocoding URL encodes zip code and required parameters

*For any* zip code string, the URL constructed by `resolveCoordinates` SHALL contain `name=<encodedZipCode>` and `count=1` as query parameters.

**Validates: Requirements 2.1**

---

### Property 3: Coordinate extraction uses the first result

*For any* non-empty geocoding results array, the coordinates extracted by `resolveCoordinates` SHALL equal the `latitude` and `longitude` values from the element at index 0.

**Validates: Requirements 2.2**

---

### Property 4: Weather URL contains all required parameters

*For any* latitude and longitude pair, the URL constructed by `fetchWeather` SHALL contain `latitude=<lat>`, `longitude=<lon>`, `hourly=temperature_2m,precipitation_probability`, and `forecast_days=1` as query parameters.

**Validates: Requirements 3.1**

---

### Property 5: Hourly data extraction uses current UTC hour index

*For any* valid hourly arrays of length ≥ 24 and any UTC hour index between 0 and 23, the values extracted by `fetchWeather` SHALL equal the elements at that index in `temperature_2m` and `precipitation_probability` respectively.

**Validates: Requirements 3.2**

---

### Property 6: Weather API response validation rejects malformed data

*For any* response object where `hourly`, `hourly.temperature_2m`, or `hourly.precipitation_probability` is absent or not an array, `fetchWeather` SHALL throw an error describing the missing field.

**Validates: Requirements 3.4**

---

### Property 7: Success output contains exactly the required fields with correct values

*For any* combination of zip code string, temperature number, and precipitation probability number, `formatSuccess` SHALL produce a string that is valid JSON and whose parsed form contains exactly `zipCode`, `temperature_c`, and `precipitation_probability_percent` with values matching the inputs.

**Validates: Requirements 4.1, 4.2**

---

### Property 8: Error output is always valid JSON with an `error` string field

*For any* error message string, `formatError` SHALL produce a string that is valid JSON and whose parsed form contains an `error` field whose value equals the input message string.

**Validates: Requirements 4.3**

# Requirements Document

## Introduction

A cross-platform Node.js CLI script that fetches the current temperature and chance of rain for a given zip code. The script uses Open-Meteo's free API (no API key required) with a two-step flow: zip code → geocoding coordinates → weather data. Results are printed to stdout as JSON. The script runs on macOS, Windows, and Linux with no platform-specific changes.

## Glossary

- **Script**: The Node.js CLI program (`weather.js`) that accepts a zip code and outputs weather data.
- **Zip Code**: A postal code string used to identify a geographic location. Defaults to a built-in value when not provided via CLI.
- **Geocoding API**: The Open-Meteo geocoding endpoint (`https://geocoding-api.open-meteo.com/v1/search`) that resolves a zip code to latitude and longitude coordinates.
- **Weather API**: The Open-Meteo forecast endpoint (`https://api.open-meteo.com/v1/forecast`) that returns weather data for given coordinates.
- **Current Temperature**: The temperature value in Celsius returned by the Weather API for the current hour.
- **Chance of Rain**: The precipitation probability percentage for the current hour, as returned by the Weather API.
- **JSON Output**: A JSON object printed to stdout containing at minimum `zipCode`, `temperature_c`, and `precipitation_probability_percent` fields.
- **Default Zip Code**: The zip code used when no CLI argument is provided; hardcoded in the Script.
- **CLI Argument**: A positional command-line argument passed when invoking the Script (e.g., `node weather.js 10001`).

## Requirements

### Requirement 1: CLI Argument Handling

**User Story:** As a developer, I want to pass a zip code as a command-line argument, so that I can query weather for any location without modifying the script.

#### Acceptance Criteria

1. WHEN the Script is invoked with a positional CLI argument, THE Script SHALL use that argument as the zip code for the weather lookup.
2. WHEN the Script is invoked without a CLI argument, THE Script SHALL use the Default Zip Code for the weather lookup.
3. THE Script SHALL accept the zip code argument at `process.argv[2]` without requiring any flags or option names.

---

### Requirement 2: Geocoding Lookup

**User Story:** As a developer, I want the script to resolve a zip code to coordinates, so that the weather API can be queried with latitude and longitude.

#### Acceptance Criteria

1. WHEN a zip code is resolved, THE Script SHALL send an HTTP GET request to the Geocoding API with the zip code as the `name` query parameter and `count=1`.
2. WHEN the Geocoding API returns one or more results, THE Script SHALL use the `latitude` and `longitude` values from the first result.
3. IF the Geocoding API returns zero results, THEN THE Script SHALL print a JSON error object to stdout with a `error` field describing the failure and exit with a non-zero exit code.
4. IF the Geocoding API request fails with a network error, THEN THE Script SHALL print a JSON error object to stdout with a `error` field describing the failure and exit with a non-zero exit code.

---

### Requirement 3: Weather Data Retrieval

**User Story:** As a developer, I want the script to fetch current temperature and precipitation probability, so that I get actionable weather information for the resolved location.

#### Acceptance Criteria

1. WHEN coordinates are resolved, THE Script SHALL send an HTTP GET request to the Weather API with `latitude`, `longitude`, `hourly=temperature_2m,precipitation_probability`, and `forecast_days=1` as query parameters.
2. WHEN the Weather API returns a successful response, THE Script SHALL extract the temperature and precipitation probability value at the index corresponding to the current UTC hour.
3. IF the Weather API request fails with a network error, THEN THE Script SHALL print a JSON error object to stdout with a `error` field describing the failure and exit with a non-zero exit code.
4. IF the Weather API response is missing expected fields, THEN THE Script SHALL print a JSON error object to stdout with a `error` field describing the failure and exit with a non-zero exit code.

---

### Requirement 4: JSON Output

**User Story:** As a developer, I want weather results printed as JSON to stdout, so that the script output can be consumed programmatically or piped to other tools.

#### Acceptance Criteria

1. WHEN weather data is successfully retrieved, THE Script SHALL print a single JSON object to stdout containing `zipCode`, `temperature_c`, and `precipitation_probability_percent` fields.
2. THE Script SHALL print JSON using `JSON.stringify` with no additional prose, banners, or log messages mixed into stdout.
3. WHEN an error occurs at any stage, THE Script SHALL print a JSON object containing an `error` string field to stdout and exit with a non-zero exit code.

---

### Requirement 5: Cross-Platform Compatibility

**User Story:** As a developer, I want the script to run on macOS, Windows, and Linux without modification, so that it works in any standard Node.js environment.

#### Acceptance Criteria

1. THE Script SHALL use only Node.js built-in modules (`https`, `process`) and no third-party npm packages, so that no `npm install` step is required.
2. THE Script SHALL use `https.get` from Node.js core for all HTTP requests.
3. THE Script SHALL not use any platform-specific shell commands, file paths, or environment assumptions.
4. WHERE Node.js version 18 or later is available, THE Script SHALL rely solely on built-in `https` without requiring a polyfill for `fetch`.

# Implementation Plan: Weather ZIP Script

## Overview

Implement `weather.js` as a single-file Node.js CLI script using only built-in modules. The script resolves a zip code to coordinates via the Open-Meteo geocoding API, fetches current hourly weather data, and prints a JSON result to stdout.

## Tasks

- [ ] 1. Set up the script file and argument parser
  - [ ] 1.1 Create `weather.js` with the argument parser
    - Create `weather.js` in the project root
    - Define the `DEFAULT_ZIP` constant (`'10001'`)
    - Implement `getZipCode(argv)` that returns `argv[2]` or the default
    - _Requirements: 1.1, 1.2, 1.3_
  - [ ]* 1.2 Write property test for argument parsing (Property 1)
    - **Property 1: Argument parsing uses argv[2] when present**
    - **Validates: Requirements 1.1, 1.3**

- [ ] 2. Implement the HTTP helper
  - [ ] 2.1 Implement `httpsGet(url)` promisified wrapper
    - Import `https` from Node.js built-ins
    - Accumulate response chunks and resolve with parsed JSON
    - Reject on network error or non-2xx HTTP status
    - _Requirements: 5.1, 5.2_
  - [ ]* 2.2 Write unit tests for `httpsGet`
    - Test non-2xx status rejection
    - Test network error rejection
    - Test invalid JSON rejection
    - _Requirements: 2.4, 3.3_

- [ ] 3. Implement the geocoding resolver
  - [ ] 3.1 Implement `resolveCoordinates(zipCode)`
    - Define `GEOCODING_API` constant
    - Build URL with `name=<encodedZipCode>` and `count=1` query parameters
    - Validate that `data.results` is non-empty; throw descriptive error if not
    - Return `{ latitude, longitude }` from `data.results[0]`
    - _Requirements: 2.1, 2.2, 2.3_
  - [ ]* 3.2 Write property test for geocoding URL construction (Property 2)
    - **Property 2: Geocoding URL encodes zip code and required parameters**
    - **Validates: Requirements 2.1**
  - [ ]* 3.3 Write property test for coordinate extraction (Property 3)
    - **Property 3: Coordinate extraction uses the first result**
    - **Validates: Requirements 2.2**

- [ ] 4. Checkpoint — Ensure argument parser, HTTP helper, and geocoding resolver all work together
  - Ensure all tests pass, ask the user if questions arise.

- [ ] 5. Implement the weather fetcher
  - [ ] 5.1 Implement `fetchWeather(latitude, longitude)`
    - Define `WEATHER_API` constant
    - Build forecast URL with `latitude`, `longitude`, `hourly=temperature_2m,precipitation_probability`, and `forecast_days=1`
    - Validate presence of `hourly.temperature_2m` and `hourly.precipitation_probability` arrays; throw if missing
    - Compute `hourIndex` via `new Date().getUTCHours()`
    - Extract values at `hourIndex`; throw if either value is `undefined`
    - Return `{ temperature_c, precipitation_probability_percent }`
    - _Requirements: 3.1, 3.2, 3.3, 3.4_
  - [ ]* 5.2 Write property test for weather URL construction (Property 4)
    - **Property 4: Weather URL contains all required parameters**
    - **Validates: Requirements 3.1**
  - [ ]* 5.3 Write property test for hourly data extraction (Property 5)
    - **Property 5: Hourly data extraction uses current UTC hour index**
    - **Validates: Requirements 3.2**
  - [ ]* 5.4 Write property test for malformed response validation (Property 6)
    - **Property 6: Weather API response validation rejects malformed data**
    - **Validates: Requirements 3.4**

- [ ] 6. Implement output formatters
  - [ ] 6.1 Implement `formatSuccess` and `formatError`
    - `formatSuccess(zipCode, temperature_c, precipitation_probability_percent)` returns `JSON.stringify` of the three fields
    - `formatError(message)` returns `JSON.stringify({ error: message })`
    - _Requirements: 4.1, 4.2, 4.3_
  - [ ]* 6.2 Write property test for success output (Property 7)
    - **Property 7: Success output contains exactly the required fields with correct values**
    - **Validates: Requirements 4.1, 4.2**
  - [ ]* 6.3 Write property test for error output (Property 8)
    - **Property 8: Error output is always valid JSON with an `error` string field**
    - **Validates: Requirements 4.3**

- [ ] 7. Implement the main entry point and wire everything together
  - [ ] 7.1 Implement `main()` and call it
    - Import `https` and `process` at the top of the file (no other imports)
    - Implement `async function main()` that calls `getZipCode`, `resolveCoordinates`, `fetchWeather`, and writes the result via `process.stdout.write`
    - Wrap in `try/catch`: on error, write `formatError` output and call `process.exit(1)`
    - On success, exit with code 0 (default)
    - Call `main()` at the bottom of the file
    - _Requirements: 1.1, 1.2, 2.1, 2.2, 2.3, 2.4, 3.1, 3.2, 3.3, 3.4, 4.1, 4.2, 4.3, 5.1, 5.2, 5.3, 5.4_
  - [ ]* 7.2 Write integration tests for `main()`
    - Test successful end-to-end flow with mocked HTTP responses
    - Test error path when geocoding returns zero results
    - Test error path when weather API returns malformed data
    - _Requirements: 4.1, 4.2, 4.3_

- [ ] 8. Final checkpoint — Ensure all tests pass
  - Ensure all tests pass, ask the user if questions arise.

## Notes

- Tasks marked with `*` are optional and can be skipped for faster MVP
- Each task references specific requirements for traceability
- Checkpoints ensure incremental validation
- Property tests validate universal correctness properties defined in the design
- Unit tests validate specific examples and edge cases
- The entire implementation lives in a single file (`weather.js`) with no npm dependencies

## Task Dependency Graph

```json
{
  "waves": [
    { "id": 0, "tasks": ["1.1"] },
    { "id": 1, "tasks": ["1.2", "2.1"] },
    { "id": 2, "tasks": ["2.2", "3.1"] },
    { "id": 3, "tasks": ["3.2", "3.3", "5.1"] },
    { "id": 4, "tasks": ["5.2", "5.3", "5.4", "6.1"] },
    { "id": 5, "tasks": ["6.2", "6.3", "7.1"] },
    { "id": 6, "tasks": ["7.2"] }
  ]
}
```

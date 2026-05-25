# Architecture

## Endpoints

### Get First Day of Year

*   **URL:** `/api/date/firstDayOfYear`
*   **Method:** `GET`
*   **Description:** Returns the first day of the year for a given date.
*   **Parameters:**
    *   `date` (query parameter): The input date in `YYYY-MM-DD` format.
*   **Response:**
    *   `200 OK`: A string representing the first day of the year in `YYYY-MM-DD` format.
*   **Example:**
    *   Request: `GET /api/date/firstDayOfYear?date=2023-10-26`
    *   Response: `2023-01-01`

## Services

### DateService

*   **Description:** Provides business logic related to date operations.
*   **Methods:**
    *   `getFirstDayOfYear(String dateString)`: Calculates and returns the first day of the year for a given date string.

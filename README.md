# TestTaskForAmazon
Implementation of a test task from Amazon

This document provides information about the endpoints available in the Sales and Traffic Report API.

 # Table of Contents
1) Get All Stats
2) Get Stats by Date
3) Get Stats Between Dates
4) Get All Stats by ASIN
5) Get Stats by ASIN
6) Get Stats Between ASINs
7) Create Authentication Token
8) Create New User

### 1. Get All Stats <a name="get-all-stats"></a>
Endpoint: GET /api/stats/allDates

Description: Retrieves all sales and traffic statistics.

Response:

- 200 OK: List of SalesAndTrafficByDataEntity entities.
- 204 No Content: If no data is available.

### 2. Get Stats by Date <a name="get-stats-by-date"></a>
Endpoint: GET /api/stats/{date}

Description: Retrieves sales and traffic statistics for a specific date.

Parameters:

{date}: Date in the format specified by the application.
Response:

200 OK: SalesAndTrafficByDataEntity.SalesAndTrafficByDate entity.
404 Not Found: If no data is available for the given date.

### 3. Get Stats Between Dates <a name="get-stats-between-dates"></a>
Endpoint: GET /api/stats/between-dates

Description: Retrieves sales and traffic statistics for a range of dates.

Parameters:

dates: Array of date strings representing the range.
Response:

200 OK: List of SalesAndTrafficByDataEntity.SalesAndTrafficByDate entities.
204 No Content: If no data is available.

### 4. Get All Stats by ASIN <a name="get-all-stats-by-asin"></a>
Endpoint: GET /api/stats/allAsin

Description: Retrieves all sales and traffic statistics grouped by ASIN.

Response:

200 OK: List of SalesAndTrafficByASINEntity entities.
204 No Content: If no data is available.

### 5. Get Stats by ASIN <a name="get-stats-by-asin"></a>
Endpoint: GET /api/stats/Asin/{asin}

Description: Retrieves sales and traffic statistics for a specific ASIN.

Parameters:

{asin}: ASIN (Amazon Standard Identification Number) of the product.
Response:

200 OK: SalesAndTrafficByASINEntity.SalesAndTrafficByAsin entity.
404 Not Found: If no data is available for the given ASIN.

### 6. Get Stats Between ASINs <a name="get-stats-between-asins"></a>
Endpoint: GET /api/stats/Asin/between-asins

Description: Retrieves sales and traffic statistics for a range of ASINs.

Parameters:

asins: Array of ASIN strings representing the range.
Response:

200 OK: List of SalesAndTrafficByASINEntity.SalesAndTrafficByAsin entities.

### 7. Create Authentication Token <a name="create-authentication-token"></a>
Endpoint: POST /api/stats/auth

Description: Creates an authentication token for the user.

Request Body:
{
  "login": "exampleUser",
  "password": "examplePassword"
}

Response:

200 OK: JWT authentication token.
401 Unauthorized: If the provided credentials are invalid.

### 8. Create New User <a name="create-new-user"></a>
Endpoint: POST /api/stats/regUser

Description: Creates a new user.

Request Body:
{
  "login": "newUser",
  "password": "newPassword",
}

Response:

201 Created: User created successfully.
400 Bad Request: If the request is malformed or the user already exists.



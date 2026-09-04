# Personal Finance REST API

A Spring Boot-based RESTful web service designed to manage and track personal financial records. The project demonstrates core backend engineering practices, including stateless API design, data validation, global exception handling, and custom JPQL-based data aggregation.

## Technical Architecture

* **Language:** Java 17
* **Framework:** Spring Boot 3.x
* **Data Access:** Spring Data JPA / Hibernate
* **Database:** H2 In-Memory Database
* **Validation:** Jakarta Bean Validation
* **Build Tool:** Maven

## Core Features

### Transaction Management

Create and retrieve personal financial transactions, including both income and expense records.

### Data Aggregation

Custom JPQL queries dynamically calculate:

* Total income.
* Total expenses.
* Current financial balance.

### Data Validation

Incoming API requests are validated using Jakarta Bean Validation to ensure:

* Transaction amounts are greater than zero.
* Descriptions are not empty.
* Invalid request data is rejected before being persisted.

### Global Exception Handling

A centralized exception handling mechanism using `@ControllerAdvice` intercepts invalid requests and returns structured, actionable JSON error responses.

### Rapid Local Development

The application uses an H2 in-memory database, allowing the project to run locally without requiring external database configuration.

## API Reference

### Endpoints

| HTTP Method | Endpoint                        | Description                                               |
| ----------- | ------------------------------- | --------------------------------------------------------- |
| `GET`       | `/api/transactions`             | Retrieve all historical transactions                      |
| `POST`      | `/api/transactions`             | Create and persist a new transaction                      |
| `GET`       | `/api/transactions/type/{type}` | Retrieve transactions filtered by `INCOME` or `EXPENSE`   |
| `GET`       | `/api/transactions/summary`     | Retrieve aggregated income, expenses, and current balance |

## API Usage

### Create a Transaction

**Endpoint**

```text
POST /api/transactions
```

**Request Body**

```json
{
  "description": "Monthly Salary",
  "amount": 2500.00,
  "type": "INCOME",
  "date": "2023-10-26"
}
```

### Retrieve All Transactions

**Endpoint**

```text
GET /api/transactions
```

### Retrieve Transactions by Type

**Endpoint**

```text
GET /api/transactions/type/{type}
```

Replace `{type}` with one of the following values:

```text
INCOME
EXPENSE
```

Example:

```text
GET /api/transactions/type/INCOME
```

### Retrieve Financial Summary

**Endpoint**

```text
GET /api/transactions/summary
```

This endpoint returns aggregated financial information, including total income, total expenses, and the calculated current balance.

## Validation and Error Handling

Invalid request payloads are handled through centralized exception handling.

### Example Validation Error Response

**HTTP Status: `400 Bad Request`**

```json
{
  "amount": "Amount must be greater than zero",
  "description": "Description cannot be empty"
}
```

## Local Development Setup

### Prerequisites

Ensure the following are installed:

* Java 17 or higher
* Maven

### Clone the Repository

```bash
git clone <your-github-repository-url>
```

### Navigate to the Project Directory

```bash
cd personal-finance-rest-api
```

### Run the Application

```bash
mvn spring-boot:run
```

The application will start on:

```text
http://localhost:8080
```

## Database

The project uses the H2 in-memory database.

Because the database is in memory, data is temporary and will be reset when the application is restarted.

This configuration allows the application to run without requiring an external database server.

## Project Highlights

This project demonstrates:

* RESTful API design.
* Spring Boot application development.
* Spring Data JPA and Hibernate.
* Custom JPQL queries.
* Request payload validation.
* Global exception handling with `@ControllerAdvice`.
* Structured API error responses.
* Financial data aggregation.
* In-memory database integration.

## Future Improvements

Potential enhancements include:

* User authentication and authorization.
* JWT-based security.
* Persistent database integration using PostgreSQL or MySQL.
* Pagination and sorting for transactions.
* Date range filtering.
* Transaction categories.
* Budget management.
* Unit and integration testing.
* Docker containerization.
* API documentation using Swagger or OpenAPI.


# Personal Finance REST API

A Spring Boot-based RESTful web service designed to manage and track personal financial records. The project demonstrates core backend engineering practices, including RESTful API design, data validation, global exception handling, and custom JPQL-based data aggregation.

## Technical Architecture

* **Language:** Java 17
* **Framework:** Spring Boot 3.x
* **Data Access:** Spring Data JPA / Hibernate
* **Database:** H2 In-Memory Database
* **Validation:** Jakarta Bean Validation
* **Build Tool:** Maven

## Core Features

* **Transaction Management:** Create and retrieve income and expense transactions.
* **Data Aggregation:** Custom JPQL queries calculate total income, total expenses, and current balance.
* **Data Validation:** Prevents invalid amounts and empty descriptions using Jakarta Bean Validation.
* **Global Exception Handling:** Uses `@ControllerAdvice` to return structured JSON error responses.
* **Rapid Local Development:** Uses an H2 in-memory database with no external database configuration required.

## API Reference

| HTTP Method | Endpoint                        | Description                                             |
| ----------- | ------------------------------- | ------------------------------------------------------- |
| `GET`       | `/api/transactions`             | Retrieve all transactions                               |
| `POST`      | `/api/transactions`             | Create a new transaction                                |
| `GET`       | `/api/transactions/type/{type}` | Retrieve transactions filtered by `INCOME` or `EXPENSE` |
| `GET`       | `/api/transactions/summary`     | Retrieve total income, expenses, and current balance    |

## Request Example

### Create a Transaction

```json
{
  "description": "Monthly Salary",
  "amount": 2500.00,
  "type": "INCOME",
  "date": "2023-10-26"
}
```

## Error Response Example

**HTTP Status: `400 Bad Request`**

```json
{
  "amount": "Amount must be greater than zero",
  "description": "Description cannot be empty"
}
```

## Local Development Setup

### Prerequisites

* Java 17 or higher
* Maven

### Run the Application

Navigate to the project directory and run:

```bash
mvn spring-boot:run
```

The application will start at:

```text
http://localhost:8080
```

## Database

The project uses an H2 in-memory database for local development. Data is temporary and resets when the application restarts.



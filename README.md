# Personal Finance REST API

A Spring Boot-based RESTful web service designed to manage and track personal financial records. This project serves as a demonstration of core backend engineering practices, including stateless API design, object-relational mapping (ORM), and dependency injection.

## Technical Architecture

* **Language:** Java 17
* **Framework:** Spring Boot 3.x
* **Data Access:** Spring Data JPA / Hibernate
* **Database:** H2 (In-Memory)
* **Build Tool:** Maven

## Core Features

* **Transaction Management:** Persist and retrieve financial records (Income/Expenses).
* **Data Filtering:** Query isolation based on transaction typologies.
* **Rapid Prototyping:** Utilizes an ephemeral H2 database, allowing reviewers to clone and run the service instantly without local database configuration.

## API Reference

### Endpoints

| HTTP Method | Endpoint | Description |
|---|---|---|
| `GET` | `/api/transactions` | Retrieve a list of all historical transactions |
| `POST` | `/api/transactions` | Persist a new transaction record |
| `GET` | `/api/transactions/type/{type}` | Retrieve transactions filtered by `INCOME` or `EXPENSE` |

### Payload Example (POST)

```json
{
  "description": "Monthly Salary",
  "amount": 2500.00,
  "type": "INCOME",
  "date": "2023-10-26"
}
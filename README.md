# JavaChallenge

## Overview

This project is a **Java Spring Boot application** that provides a REST API for arithmetic operations such as addition, subtraction, multiplication, and division. It is built with a **modular design**, separating responsibilities into two main modules:

* **REST Module** – Handles HTTP requests and responses, exposing endpoints for calculator operations.
* **Calculator Module** – Contains the logic for performing calculations, with support for very large numbers using `BigDecimal`.

The application uses **Kafka** for asynchronous message processing and is packaged with **Docker** for easy deployment across different environments.

---

## Prerequisites

* [Docker](https://docs.docker.com/get-docker/) installed
* [Docker Compose](https://docs.docker.com/compose/install/) installed

---

## Steps

### Clone the repository

```bash
 https://github.com/Diogobfer/JavaChallenge.git

```

### Build and start the services

```bash
docker-compose up --build
```

Once all containers are running, you can access the REST API at:

```
http://localhost:8080
```

---

## Example Requests

### Sum

```bash
curl "http://localhost:8080/sum?a=2&b=5"
```

**Response:**

```
7
```

### Division (error handling)

```bash
curl "http://localhost:8080/division?a=20&b=0"
```

**Response:**

```
Error: Division by zero
```

### Division

```bash
curl "http://localhost:8080/division?a=20&b=5.1"
```

**Response:**

```
3.921568627450980392156862745098
```

### Multiplication

```bash
curl "http://localhost:8080/multiplication?a=200&b=2"
```

**Response:**

```
400
```

### Subtraction

```bash
curl "http://localhost:8080/subtraction?a=10&b=5"
```

**Response:**

```
5
```

---

## Notes

*  Accepts numbers in **scientific notation** (e.g., `1.2e10`, `45E34`).
*  Rejects invalid inputs such as letters (`abc`) or symbols (`$`, `#`, `%`).
*  Rejects division by zero, returning a clear error message.

To stop the services:

```bash
docker-compose down
```

---

## Docker Build Notes

The project uses a **multi-stage Dockerfile** with different targets:

* **`restimagetesting`** → includes everything required to **run tests inside the container**.
  After building this target, you can run the tests with:

  ```bash
  docker-compose run rest mvn test -pl rest
  ```

* **`restimageslim`** → lightweight image containing **only the REST application**, ideal for deployment.

When building with Docker Compose, specify the desired target:

* To build and run with tests:

  ```bash
  docker-compose build --build-arg target=restimagetesting
  ```

* To build a slim production-ready image:

  ```bash
  docker-compose build --build-arg target=restimageslim
  ```

---

# todo-api

A RESTful task management API built with Spring Boot. Supports full CRUD operations, task status filtering, and includes Swagger UI for interactive API documentation. Built as a learning project to practise Spring Boot, JPA, and REST API design.

**Stack:** Java 11 · Spring Boot 2.5.8 · Spring Data JPA · H2 · Swagger · Lombok

---

## Features

- Create, read, update, and delete tasks
- Filter tasks by status (`PENDING`, `IN_PROGRESS`, `COMPLETED`)
- Mark task as finished endpoint
- H2 in-memory database (no setup required)
- Swagger UI for interactive API documentation
- DTO pattern with custom mapper
- Global exception handling

---

## API Endpoints

| Method | Path | Description |
|--------|------|-------------|
| `POST` | `/v1/tasks` | Create task |
| `GET` | `/v1/tasks` | Get all tasks |
| `GET` | `/v1/tasks/{id}` | Get task by ID |
| `GET` | `/v1/tasks/status/{status}` | Filter by status |
| `PATCH` | `/v1/tasks/mark_as_finished/{id}` | Mark as completed |
| `PUT` | `/v1/tasks/{id}` | Update task |
| `DELETE` | `/v1/tasks/{id}` | Delete task |

---

## Running locally

```bash
mvn clean install
mvn spring-boot:run
```

| Resource | URL |
|----------|-----|
| Swagger UI | http://localhost:8080/swagger-ui.html |
| H2 Console | http://localhost:8080/h2-console |

H2 credentials: user `a` / password `a`

---

## Project structure

```
todo_api/
└── src/main/java/com/orbedeveloper/todoapi/
    ├── controller/       ← REST endpoints
    ├── service/          ← business logic
    ├── persistence/
    │   ├── entity/       ← Task, TaskStatus
    │   └── repository/   ← JPA repository
    ├── dto/              ← TaskInDTO
    ├── mapper/           ← DTO to entity mapping
    └── exceptions/       ← global exception handler
```

# Hospital Management Microservices System (In Progress)

This project is a professional, real-world microservices-based Hospital Management System built using Spring Boot. 
Currently focused on the core backend architecture for the **Patient Service**,
this implementation lays the foundation for a scalable, secure, 
and maintainable healthcare application.

## Objectives

- Apply enterprise-grade layered architecture using Spring Boot
- Build production-level REST APIs with input validation and error handling
- Prepare services for future integration with gRPC, Kafka, and containerized deployment

## Technologies & Patterns Covered (So Far)

- **Spring Boot** – Application configuration, layered architecture
- **Spring Data JPA** – In-memory data persistence using H2
- **DTO Pattern** – Separate request/response models
- **Validation** – Field-level and global request validation using `@Valid`, `@NotNull`, `@Pattern`, etc.
- **Exception Handling** – Custom exception classes, centralized exception handler
- **Service and Repository Layers** – Clean separation of concerns with dependency injection
- **Controller Testing** – Manual and mock-based endpoint testing

## Tech Stack

- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 Database
- Jakarta Validation
- Lombok
- RESTful API design

- 
## Current Functionality

- **Domain-Driven Entity Design**
  - `Patient` entity includes:
    - `id` (UUID, auto-generated)
    - `name`, `email`, `address`, `phone` (optional), `dateOfBirth`, `registeredDate`
  - Email is enforced to be unique via `@Column(unique = true)`
- Robust validation error messages with meaningful business logic exceptions


## 📄 API Documentation (Swagger)

The complete API documentation is available in the Swagger YAML file:

➡️ [View Swagger.yaml](./Docs/Swagger.yaml)

You can open it in the [Swagger Editor](https://editor.swagger.io/) to explore and test the API.



# Sample content from Swagger.yaml
openapi: 3.1.0
info:
  title: Patient Management API
  version: 1.0.0



## Learning Outcomes (To This Stage)

- Designed and implemented real-world layered architecture in a healthcare context
- Built and tested secure and clean REST endpoints using DTOs
- Created reusable exception handling patterns for request and business errors
- Learned foundational practices for scaling towards microservices, gRPC, and Kafka integration

---

## Next Milestone (Planned)

- Add update and delete endpoints with additional business rules  
- Dockerize the patient service  
- Start gRPC service-to-service communication  
- Kafka integration for event publishing  
- Implement token-based security with Spring Security and JWT

> This project is being developed in iterative milestones,
> following industry-standard backend practices including layered architecture,
> DTO patterns, validation, and modular service design.

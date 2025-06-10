# Patient Management Microservices System (In Progress)

This project is a professional, real-world microservices-based Patient Management System built using Spring Boot. 
Currently focused on the core backend architecture for the **Patient Service**,
this implementation lays the foundation for a scalable, secure, 
and maintainable healthcare application.

## Objectives

- Apply enterprise-grade layered architecture using Spring Boot
- Build production-level REST APIs with input validation and error handling
- Prepare services for future integration with gRPC, Kafka, and containerized deployment


---

## Technologies Used

| Category         | Technology                  |
|------------------|-----------------------------|
| Language         | Java 17                     |
| Framework        | Spring Boot 3               |
| Data Access      | Spring Data JPA             |
| Database         | H2 (in-memory)              |
| Validation       | Jakarta Bean Validation     |
| Messaging        | Apache Kafka                |
| Inter-Service    | gRPC (Protocol Buffers)     |
| API Docs         | Swagger / OpenAPI           |
| Containerization | Docker                      |
| Code Reduction   | Lombok                      |
| Security         | Spring Security + JWT (Upcoming) |

---


- 


## 📄 API Documentation (Swagger)

The complete API documentation is available in the Swagger YAML file:

➡️ [View Swagger.yaml](./Docs/Swagger.yaml)

You can open it in the [Swagger Editor](https://editor.swagger.io/) to explore and test the API.

You can also see images  in the [Swagger Images](./Docs/Swagger_Images) to explore API.



# Sample content from Swagger.yaml
openapi: 3.1.0
info:
  title: Patient Management API
  version: 1.0.0



## Microservices Overview

### Patient Service
- Handles full CRUD operations for patients.
- Enforces unique email validation and field-level constraints.
- Emits patient registration events via Kafka using Protobuf.
- Invokes Billing Service through gRPC client call.
- Containerized for portability and exposes documented REST endpoints.

### Billing Service
- Exposed as a gRPC server.
- Listens and responds to patient registration requests.
- Designed to be extendable for financial processing.
- Fully Docker-integrated.

### Analytics Service
- Kafka consumer listening on the `patient-events` topic.
- Processes and logs patient event data.
- Future scope includes analytics dashboards or data lakes.
- Docker-enabled for local and CI environments.

---

## Kafka Integration

- Kafka is used for decoupled, event-driven communication.
- Patient Service publishes serialized Protobuf messages on `patient-events` topic.
- Analytics Service consumes these events for processing/logging.
- Kafka and Zookeeper are configured through Docker Compose for ease of use.

---

## gRPC Communication

- Patient Service functions as the gRPC client.
- Billing Service is implemented as the gRPC server.
- Protobuf message contracts define the communication schema.
- Ensures efficient binary communication for internal RPC-style requests.

---

## API Documentation

- OpenAPI Specification (Swagger) is available.
- YAML spec included in the documentation directory.
- Easily testable using Swagger UI or Postman.



## Testing Strategy

- Unit tests written using JUnit and Mockito.
- Manual testing supported via Postman and Swagger UI.
- Integration tests planned with Docker Compose for end-to-end coverage.

---

## Learning Outcomes

This project simulates industry-level backend development and covers:

- Microservices design patterns and inter-service communication
- Asynchronous workflows using Kafka
- Efficient and scalable data handling with gRPC
- REST API best practices and Swagger documentation
- DevOps fundamentals via Docker and CI/CD planning

---


---


## Next Milestone (Planned)

- Implementation of Spring Security and JWT-based authentication.
- Dedicated Auth microservice for secure token generation and validation.
- Introduction of API Gateway for routing and load balancing.
- Deployment setup using AWS (via LocalStack or native services).
- Monitoring and alerting with Prometheus and Grafana.
- CI/CD pipelines using GitHub Actions or Jenkins.

---


> This project is under active development and structured to grow into a fully secure and cloud-deployable enterprise system. Contributions, suggestions, and feedback are welcome.






# E-Commerce Microservices Project

This repository contains a microservices-based e-commerce platform built with Java and Spring Boot. The project leverages various Spring modules and tools, including Eureka Discovery, Config Server, MongoDB, PostgreSQL, Spring Web, Maildev, and Docker for managing dependencies.

## Table of Contents

- [Architecture](#architecture)
- [Microservices](#microservices)
- [Tech Stack](#tech-stack)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Configuration](#configuration)
- [Running the Services](#running-the-services)
- [License](#license)

## Architecture

The platform follows a microservices architecture, where each service is responsible for a specific domain:

- **Customer Service**: Manages customer information and profiles.
- **Order Service**: Handles order creation, management, and tracking.
- **Payment Service**: Processes payments and manages payment records.
- **Product Service**: Manages product details and inventory.
- **Config Server**: Centralized configuration management.
- **Eureka Discovery Server**: Service discovery for dynamic load balancing and failover.
- **Mail Service**: Sends transactional emails using Maildev.
- **Keycloak**: Identity and access management.
- **Zipkin**: Distributed tracing for microservices.

## Microservices

### Customer Service
- **Description**: Manages customer profiles and authentication.
- **Database**: MongoDB

### Order Service
- **Description**: Handles customer orders, including order creation and status updates.
- **Database**: PostgreSQL

### Payment Service
- **Description**: Processes customer payments and manages payment records.
- **Database**: PostgreSQL

### Product Service
- **Description**: Manages product catalog and inventory.
- **Database**: MongoDB

### Config Server
- **Description**: Provides centralized configuration management.
- **Database**: N/A

### Eureka Discovery Server
- **Description**: Manages service registration and discovery.
- **Database**: N/A

### Mail Service
- **Description**: Sends transactional emails using Maildev.
- **Database**: N/A

### Zipkin
- **Description**: Provides distributed tracing for microservices.
- **Database**: N/A

### Keycloak
- **Description**: Provides identity and access management.
- **Database**: N/A

## Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Cloud Netflix Eureka**
- **Spring Cloud Config**
- **Spring Data MongoDB**
- **Spring Data JPA (PostgreSQL)**
- **Spring Web**
- **Spring Mail**
- **Thymeleaf**
- **Maildev**
- **Keycloak**
- **Zipkin**
- **Docker**
- **Maven**

## Prerequisites

- Java 17
- Maven
- Docker
- Docker Compose

## Getting Started

### Clone the Repository

```bash
git clone https://github.com/dHRvBiyAn1/e-commerce-microservices.git
cd e-commerce-microservices
```
### Configuration
Configure the application properties for each service as needed.

### Running the Services
Use Docker Compose to start all the services and their dependencies, The `docker-compose.yml` file is used to set up the necessary infrastructure for the microservices, including databases, Kafka, Zookeeper, Maildev, Keycloak, and Zipkin.
```bash
docker compose up -d
```
This command will start the following containers:
- **Config Server**
- **Eureka Discovery Server**
- **Maildev**
- **MongoDB**
- **PostgreSQL**
- **Kafka**
- **Zookeeper**
- **PgAdmin**
- **Mongo Express**
- **Keycloak**
- **Zipkin**

### Accessing the Services
- **Eureka Dashboard: `http://localhost:8761`**
- **Config Server: `http://localhost:8888`**
- **Maildev UI: `http://localhost:1080`**
- **PgAdmin: `http://localhost:5050`**
- **Mongo Express: `http://localhost:8081`**
- **Keycloak: `http://localhost:9098`**
- **Zipkin: `http://localhost:9411`**

## License
### This project is licensed under the MIT License. See the LICENSE file for details.

`https://github.com/dHRvBiyAn1/e-commerce-microservices.git`. This `README.md` provides a comprehensive overview and instructions for setting up and running your e-commerce microservices project.

# 🎬 embd REST API

This repository hosts a REST API based in Spring Boot that stores the movies trailers where users can comment and rate different movies.

# Installation and Getting Started

### Requirements needed
- Java SDK Amazon Corretto 11.0.12 
- Apache Maven 3.6.3
- Docker 20.10.8, build 3967b7d28e
- docker-compose 1.29.2, build 5becea4c

### Setting up the project

1. Define environment variables renaming `.env-example` into `.env`.
2. Rename the `sample.yml` file located in  `/main/resources` as `application.yml`.
3. In order to build the application with its dependencies (run it just once): `./mvnw clean install`
4. In order to run the API: `./mvnw spring-boot:run`
5. In order to run the API in debug mode: `./mvnw spring-boot:run -X`

## Interact with the API

Open `http://localhost:8080/swagger-ui.html` to launch swagger webpage.
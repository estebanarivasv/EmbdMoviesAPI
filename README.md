# 🎬 embd REST API

This repository hosts a REST API based in Spring Boot that stores the movies trailers where users can comment and rate different movies.

# Installation and Getting Started

### Software needed
- Java SDK 11
- Maven 3.8.1
- Docker 20.10.5, build 55c4c88

### Steps

1. Rename the `properties` file located in  `/main/resources` as `application.properties.
2. In order to build the application with its dependencies (run it just once): `./mvnw clean install`
3. In order to run the API: `./mvnw spring-boot:run`
4. In order to run the API in debug mode: `./mvnw spring-boot:run -X`

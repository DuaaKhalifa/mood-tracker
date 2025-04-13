# Mood Tracker API 🧠

A simple RESTful API to track your mood, stress level, notes, and emotional tags daily.  
Built with Spring Boot, Spring Data JPA, and documented via Swagger/OpenAPI.

## Features
- Submit mood entries with mood score, stress level, notes, and tags
- Filter entries by date and tag
- Input validation with user-friendly error messages
- API docs available at `/swagger-ui.html`

## Tech Stack
- Java 17
- Spring Boot 3.2.5
- H2 (in-memory database)
- Spring Data JPA
- Lombok
- SpringDoc (Swagger)

## Getting Started
1. Clone the repo
2. Run the app:
   ```bash
   ./mvnw spring-boot:run

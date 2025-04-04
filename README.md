# Hazard Microservice (ccte-api-hazard)

## Overview
The ccte-api-hazard is a RESTful API designed to manage and provide hazard data. It interacts with a database and offers various endpoints for hazard-related operations.

## Technologies Used
- **Java**: Programming language used for the development of the application.
- **Spring Boot**: Framework used to create stand-alone, production-grade Spring-based applications.
- **Spring Data JPA**: Part of the Spring Data family, used to simplify data access and persistence.
- **Maven**: Build automation tool used for managing project dependencies and build lifecycle.
- **Swagger/OpenAPI**: Used for API documentation and testing.

## Configuration
The application configuration is managed through properties files. The main configuration file is `application.properties`, and environment-specific configurations can be added as needed.

## Build and Deployment
The project uses Maven for build and deployment processes. Continuous integration and deployment can be set up using tools like GitHub Actions.

## Getting Started
To build and run the project locally, use the following Maven commands:

```sh
mvn clean install
mvn spring-boot:run
```

## Project Structure
```plaintext
src/
├── main/
│   ├── java/
│   │   └── gov/epa/ccte/api/hazard/
│   │       ├── domain/
│   │       ├── repository/
│   │       ├── service/
│   │       └── web/
│   │           └── rest/
│   └── resources/
│       └── application.properties
└── test/
```

## Dependencies
- `spring-boot-starter-web`
- `spring-boot-starter-data-jpa`
- `lombok`
- `springdoc-openapi-starter-webmvc-ui`
- `spring-boot-starter-test`
- `jackson-datatype-hibernate6`

## Contributing
Contributions are welcome! Please read the `CONTRIBUTING.md` file for guidelines.

## Contact
For any inquiries, please contact the project maintainers.
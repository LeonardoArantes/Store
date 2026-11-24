# Product Management Service

## Overview

Product Management is a microservice responsible for managing product information and persistence.

This project uses **Hexagonal Architecture (Ports and Adapters)** to separate business logic from external dependencies.

The initial MVP provides the product creation functionality. Additional operations will be implemented in future versions.

## Technologies

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- SLF4J

## Architecture

The application follows Hexagonal Architecture.

```text
product-management/
└── src/
    ├── main/
    │   ├── java/
    │   │   └── br/com/back/product/management/
    │   │       ├── adapter/
    │   │       │   ├── input/
    │   │       │   │   └── controller/
    │   │       │   │       ├── dto/
    │   │       │   │       └── mapper/
    │   │       │   └── output/
    │   │       │       ├── logger/
    │   │       │       ├── mapper/
    │   │       │       └── repository/
    │   │       ├── config/
    │   │       ├── core/
    │   │       │   ├── exception/
    │   │       │   ├── model/
    │   │       │   └── usecase/
    │   │       └── port/
    │   │           ├── input/
    │   │           └── output/
    │   └── resources/
    │       └── application.properties
    └── test/
```

### Layer responsibilities

| Layer | Responsibility |
|---|---|
| `adapter.input` | Handles incoming HTTP requests. |
| `adapter.output` | Implements external integrations, such as persistence and logging. |
| `core.model` | Contains domain models. |
| `core.usecase` | Contains application business operations. |
| `port.input` | Defines application input contracts. |
| `port.output` | Defines external dependency contracts. |
| `config` | Configures application beans. |

## Current Features

- Product creation.
- REST API endpoint.
- PostgreSQL integration.
- Product persistence using Spring Data JPA.
- DTO and domain mapping.
- Persistence entity mapping.
- Database-generated product ID.
- SKU uniqueness constraint.
- Execution and error logging.
- Environment configuration using `.env`.

## Product Model

The current product model contains:

| Attribute | Type |
|---|---|
| id | Long |
| sku | String |
| nome | String |
| description | String |
| category | String |
| brand | String |
| barCode | String |
| costPrice | BigDecimal |
| sellPrice | BigDecimal |
| measurementUnit | String |

Category and brand are stored as simple string attributes. No entity relationships are implemented at this stage.

## API

### Create Product

**Endpoint**

`POST /product/create`

**Request Body**

```json
{
  "sku": "SKU-001",
  "nome": "Produto exemplo",
  "description": "Descrição do produto",
  "category": "Eletrônicos",
  "brand": "Samsung",
  "barCode": "7891234567890",
  "costPrice": 100.50,
  "sellPrice": 149.90,
  "measurementUnit": "UN"
}
```

**Success Response**

```json
{
  "code": "0001",
  "message": "Product Created"
}
```

## Database

The application uses PostgreSQL as its relational database.

Persistence is implemented through:

- Spring Data JPA.
- Hibernate ORM.
- `JpaRepository`.
- Database-generated identifiers using `GenerationType.IDENTITY`.

The current database schema is created manually using SQL.

### JPA Configuration

The application uses the following Hibernate configuration:

```properties
spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

The `validate` option checks whether the database schema matches the entity mappings. It does not create or update tables.

## Environment Configuration

Database configuration is managed through environment variables loaded from a `.env` file.

A `.env.example` file is planned to document the required variables and simplify environment setup.

Do not commit credentials or sensitive configuration values.

## Logging

The application uses a dedicated logging adapter.

Current logging responsibilities:

- Execution tracing.
- Error logging.

The logging implementation is decoupled through `LoggerOutputPort`.

## Current Limitations

The following features are not implemented yet:

- Centralized exception handling.
- Request and business validation.
- Automated tests.
- Product update.
- Product deactivation.
- Swagger/OpenAPI documentation.
- Database migrations.
- Docker support.
- Authentication and authorization.

## Development Roadmap

See [TODO.md](TODO.md) for the planned implementation tasks.
# Product Management — TODO

## 1. Exception Handling and Validation

- [X] Implement `GlobalExceptionHandler` using `@RestControllerAdvice`.
- [X] Create custom exceptions.
- [X] Implement request validations using Jakarta Bean Validation (`@Valid`, `@NotBlank`, `@NotNull`, `@Positive`, etc.).
- [X] Validate required fields.
- [X] Validate prices (cost and selling price).
- [X] Handle duplicate SKU exceptions.
- [X] Standardize API error responses.

## 2. Automated Tests

- [X] Create Use Case unit tests.
- [X] Create Controller tests.
- [X] Create Repository tests.
- [ ] Create PostgreSQL integration tests.

## 3. Product Operations

- [ ] Implement product update.
- [ ] Implement product deactivation (soft delete).
- [ ] Implement product search by SKU.
- [ ] Implement product listing.

## 4. Database Management

- [ ] Add Flyway.
- [ ] Create the initial database migration.
- [ ] Version future database changes.

## 5. Documentation and Configuration

- [X] Create `.env.example`.
- [X] Implement Swagger/OpenAPI.
- [ ] Document environment setup.
- [ ] Document API endpoints.

## 6. Infrastructure and Security

- [ ] Add Docker support.
- [ ] Create Docker Compose configuration.
- [ ] Implement authentication.
- [ ] Implement authorization.

---

**Note:** Physical product deletion is not planned. Product records must be preserved for historical purposes.
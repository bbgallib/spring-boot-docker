# Repository Guidelines

## Project Structure & Module Organization
- `src/main/java` contains Spring Boot application code (controllers, services, repositories).
- `src/main/resources` holds configuration and MyBatis mappers (e.g., `application.yml`, `mapper/*.xml`).
- `src/test/java` contains JUnit tests.
- `docker/` and `docker-compose.yml` define the app and MySQL containers.
- `sql/` contains initialization scripts mounted into the MySQL container.

## Build, Test, and Development Commands
- `./gradlew build` builds the project and runs tests.
- `./gradlew test` runs the JUnit 5 test suite only.
- `./gradlew bootRun` starts the app locally (debug port 5005 is enabled in Gradle).
- `docker-compose up` starts the app and MySQL containers using the Dockerfile under `docker/`.

## Coding Style & Naming Conventions
- Use 4-space indentation and standard Java naming: `PascalCase` for classes, `camelCase` for methods/fields, `UPPER_SNAKE_CASE` for constants.
- Keep packages aligned with `com.example.sbdocker` and feature-based subpackages (`controller`, `domain`, `infrastructure`).
- MyBatis mapper XML files live in `src/main/resources/mapper` and should mirror their mapper interfaces by name.

## Testing Guidelines
- Tests use JUnit 5 via `spring-boot-starter-test`.
- Place tests under `src/test/java` and name them `*Tests` or `*Test` (e.g., `SbDockerApplicationTests`).
- Prefer lightweight unit tests; use `@SpringBootTest` only when the full context is required.

## Commit & Pull Request Guidelines
- Recent commits are short, descriptive, and often in Japanese (e.g., “Spring Bootバージョンアップ対応”). Keep messages concise and imperative.
- PRs should include a summary, testing steps (`./gradlew test` or `docker-compose up`), and any relevant screenshots/logs for UI/API changes.

## Configuration & Profiles
- Profiles are defined in `src/main/resources/application.yml` (`localhost` and `docker`).
- For local DB usage, set `SPRING_PROFILES_ACTIVE=localhost`; Docker runs with `docker` via container env.

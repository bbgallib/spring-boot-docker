FROM eclipse-temurin:21-jdk

ENV APP_ROOT /app

COPY . $APP_ROOT
WORKDIR $APP_ROOT

ENTRYPOINT ["sh", "./gradlew", "bootRun"]

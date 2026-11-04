# Java Spark App

Simple Spark Java web server for CI/CD demonstration.

## Install & Run

```bash
./mvnw exec:java
```

## Test

```bash
./mvnw test
```

## Docker

```bash
docker build -t java-app .
docker run -p 4567:4567 java-app
```

## Endpoints

- `GET /` - Home
- `GET /health` - Health check
- `GET /greet` - Default greeting
- `GET /greet/:name` - Personalized greeting

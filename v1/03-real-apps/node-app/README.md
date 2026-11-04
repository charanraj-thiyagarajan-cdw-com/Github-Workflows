# Node.js Express App

Simple Express web server for CI/CD demonstration.

## Install & Run

```bash
npm install
npm start
```

## Test

```bash
npm test
```

## Docker

```bash
docker build -t node-app .
docker run -p 3000:3000 node-app
```

## Endpoints

- `GET /` - Home
- `GET /health` - Health check
- `GET /greet` - Default greeting
- `GET /greet/:name` - Personalized greeting

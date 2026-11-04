# Python FastAPI App

Simple FastAPI web server for CI/CD demonstration.

## Install & Run

```bash
pip install -r requirements.txt
uvicorn app:app --reload
```

## Test

```bash
pytest
```

## Docker

```bash
docker build -t python-app .
docker run -p 8000:8000 python-app
```

## Endpoints

- `GET /` - Home
- `GET /health` - Health check
- `GET /greet` - Default greeting
- `GET /greet/{name}` - Personalized greeting

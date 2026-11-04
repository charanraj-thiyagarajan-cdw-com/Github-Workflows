from fastapi import FastAPI

app = FastAPI(title="Simple Python FastAPI", version="1.0.0")

@app.get("/")
def home():
    """Home endpoint"""
    return {
        "message": "Simple Python FastAPI App",
        "greeting": "Hello, GitHub Actions!"
    }

@app.get("/health")
def health():
    """Health check endpoint"""
    return {"status": "healthy"}

@app.get("/greet")
@app.get("/greet/{name}")
def greet_endpoint(name: str = "World"):
    """Greeting endpoint"""
    if not name or name.strip() == "":
        greeting = "Hello, World!"
    else:
        greeting = f"Hello, {name}!"
    return {"greeting": greeting}

if __name__ == '__main__':
    import uvicorn
    uvicorn.run(app, host="0.0.0.0", port=8000)

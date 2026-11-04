from fastapi.testclient import TestClient
from app import app

client = TestClient(app)

def test_home_endpoint():
    """Test home endpoint"""
    response = client.get("/")
    assert response.status_code == 200
    data = response.json()
    assert data["message"] == "Simple Python FastAPI App"
    assert data["greeting"] == "Hello, GitHub Actions!"

def test_health_endpoint():
    """Test health endpoint"""
    response = client.get("/health")
    assert response.status_code == 200
    data = response.json()
    assert data["status"] == "healthy"

def test_greet_endpoint():
    """Test greet endpoint"""
    response = client.get("/greet")
    assert response.status_code == 200
    data = response.json()
    assert data["greeting"] == "Hello, World!"
    
    response = client.get("/greet/GitHub")
    assert response.status_code == 200
    data = response.json()
    assert data["greeting"] == "Hello, GitHub!"

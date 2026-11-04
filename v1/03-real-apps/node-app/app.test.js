const request = require("supertest");
const app = require("./app");

describe("Express App Tests", () => {
  test("GET / should return home message", async () => {
    const response = await request(app).get("/");

    expect(response.status).toBe(200);
    expect(response.body.message).toBe("Simple Node.js Express App");
    expect(response.body.greeting).toBe("Hello, GitHub Actions!");
  });

  test("GET /health should return healthy status", async () => {
    const response = await request(app).get("/health");

    expect(response.status).toBe(200);
    expect(response.body.status).toBe("healthy");
  });

  test("GET /greet should return default greeting", async () => {
    const response = await request(app).get("/greet");

    expect(response.status).toBe(200);
    expect(response.body.greeting).toBe("Hello, World!");
  });

  test("GET /greet/:name should return personalized greeting", async () => {
    const response = await request(app).get("/greet/GitHub");

    expect(response.status).toBe(200);
    expect(response.body.greeting).toBe("Hello, GitHub!");
  });
});

const express = require("express");
const app = express();
const PORT = process.env.PORT || 3000;

// Home endpoint
app.get("/", (req, res) => {
  res.json({
    message: "Simple Node.js Express App",
    greeting: "Hello, GitHub Actions!",
  });
});

// Health endpoint
app.get("/health", (req, res) => {
  res.json({ status: "healthy" });
});

// Greeting endpoints
app.get("/greet", (req, res) => {
  res.json({ greeting: "Hello, World!" });
});

app.get("/greet/:name", (req, res) => {
  const name = req.params.name;
  const greeting = name ? `Hello, ${name}!` : "Hello, user!";
  res.json({ greeting });
});

module.exports = app;

if (require.main === module) {
  app.listen(PORT, () => {
    console.log(`Server running on port ${PORT}`);
  });
}

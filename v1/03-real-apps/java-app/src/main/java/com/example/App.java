package com.example;

import static spark.Spark.*;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.Map;

public class App {
    private static final Gson gson = new Gson();

    public static void main(String[] args) {
        // Set port
        port(getPort());

        // Home endpoint
        get("/", (req, res) -> {
            res.type("application/json");
            Map<String, String> response = new HashMap<>();
            response.put("message", "Simple Java Spark App");
            response.put("greeting", "Hello, GitHub Actions!");
            return gson.toJson(response);
        });

        // Health endpoint
        get("/health", (req, res) -> {
            res.type("application/json");
            Map<String, String> response = new HashMap<>();
            response.put("status", "healthy");
            return gson.toJson(response);
        });

        // Greeting endpoints
        get("/greet", (req, res) -> {
            res.type("application/json");
            Map<String, String> response = new HashMap<>();
            response.put("greeting", "Hello, World!");
            return gson.toJson(response);
        });

        get("/greet/:name", (req, res) -> {
            res.type("application/json");
            String name = req.params(":name");
            String greeting = name != null ? "Hello, " + name + "!" : "Hello, World!";
            Map<String, String> response = new HashMap<>();
            response.put("greeting", greeting);
            return gson.toJson(response);
        });

        System.out.println("Server running on port " + getPort());
    }

    private static int getPort() {
        String port = System.getenv("PORT");
        return port != null ? Integer.parseInt(port) : 4567;
    }
}

package com.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import spark.Spark;

public class AppTest {

    private static final String BASE_URL = "http://localhost:4567";

    @BeforeAll
    public static void setUp() {
        // Start the application
        App.main(new String[] {});
        Spark.awaitInitialization();
    }

    @AfterAll
    public static void tearDown() {
        Spark.stop();
    }

    @Test
    public void testHomeEndpoint() throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(BASE_URL + "/");
            try (CloseableHttpResponse response = client.execute(request)) {
                assertEquals(200, response.getCode());
                String content = EntityUtils.toString(response.getEntity());
                assertTrue(content.contains("Simple Java Spark App"));
                assertTrue(content.contains("Hello, GitHub Actions!"));
            }
        }
    }

    @Test
    public void testHealthEndpoint() throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(BASE_URL + "/health");
            try (CloseableHttpResponse response = client.execute(request)) {
                assertEquals(200, response.getCode());
                String content = EntityUtils.toString(response.getEntity());
                assertTrue(content.contains("healthy"));
            }
        }
    }

    @Test
    public void testGreetEndpoint() throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(BASE_URL + "/greet");
            try (CloseableHttpResponse response = client.execute(request)) {
                assertEquals(200, response.getCode());
                String content = EntityUtils.toString(response.getEntity());
                assertTrue(content.contains("Hello, World!"));
            }
        }
    }

    @Test
    public void testGreetWithNameEndpoint() throws Exception {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(BASE_URL + "/greet/GitHub");
            try (CloseableHttpResponse response = client.execute(request)) {
                assertEquals(200, response.getCode());
                String content = EntityUtils.toString(response.getEntity());
                assertTrue(content.contains("Hello, GitHub!"));
            }
        }
    }
}

package com.fertavora.testing.tests;

import com.fertavora.testing.clients.FilmsEndpoint;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SwapiFilmsTests implements BasicChecks {
    private ValidatableResponse response;

    @BeforeClass
    public void getRequest() {
        response = FilmsEndpoint.getFilms();
    }

    @Test
    public void checkStatusCode() {
        Assert.assertEquals(response.extract().statusCode(), 200, "The response status code is wrong!");
    }

    @Test
    public void checkContentType() {
        Assert.assertEquals(response.extract().contentType(), ContentType.JSON.toString(), "The response content type is wrong!");
    }

    @Test
    public void checkResponseTime() {
        Long expectedTime = 5000L;
        Long responseTime = response.extract().time();
        Assert.assertTrue(responseTime <= expectedTime, "Response time threshold\nExpected: " + expectedTime + "\nActual: " + responseTime + "\n");
    }
}


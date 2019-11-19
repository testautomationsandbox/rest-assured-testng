package com.fertavora.testing.tests;

import com.fertavora.testing.clients.FilmsEndpoint;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SwapiFilmsTests implements BasicChecks {
    private Response response;

    @BeforeClass
    public void getRequest() {
        response = FilmsEndpoint.getFilms();
    }

    @Test
    public void checkStatusCode() {
        Assert.assertEquals(response.getStatusCode(), 200, "The response status code is wrong!");
    }

    @Test
    public void checkContentType() {
        Assert.assertEquals(response.getContentType(), ContentType.JSON.toString(), "The response content type is wrong!");
    }

    @Test
    public void checkResponseTime() {
        Long expectedTime = 5000L;
        Long responseTime = response.getTime();
        Assert.assertTrue(responseTime <= expectedTime, "Response time threshold\nExpected: " + expectedTime + "\nActual: " + responseTime + "\n");
    }
}


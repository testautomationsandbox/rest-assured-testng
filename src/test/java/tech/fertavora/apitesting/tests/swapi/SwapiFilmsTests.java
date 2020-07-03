package tech.fertavora.apitesting.tests.swapi;

import tech.fertavora.apitesting.clients.swapi.endpoints.FilmsEndpoint;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SwapiFilmsTests {
    private ValidatableResponse response;

    @BeforeClass
    public void getRequest() {
        response = FilmsEndpoint.getFilms();
    }

    // todo add try catch for assertion custom
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

    @Test
    public void getFilmById(){
        ValidatableResponse responseById = FilmsEndpoint.getFilmById(3).spec(FilmsEndpoint.getRespSpec(200, ContentType.JSON));
        Assert.assertEquals(responseById.extract().statusCode(), 200, "The response status code is wrong!");
    }
}


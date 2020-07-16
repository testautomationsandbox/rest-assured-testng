package tech.fertavora.apitesting.tests.swapi;

import tech.fertavora.apitesting.clients.swapi.dtos.FilmDTO;
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

    @Test
    public void checkStatusCodeAndContentType() {
        try {
            response.spec(FilmsEndpoint.getRespSpec(200, ContentType.JSON));
        } catch (AssertionError assertionError) {
            throw new AssertionError(
                    FilmsEndpoint.getFailedRequestErrorMessage(
                            FilmsEndpoint.getCustomRequest(),
                            assertionError.getMessage(),
                            response
                    ),
                    assertionError);
        }

    }

    @Test
    public void checkResponseTime() {
        try {
            Long expectedTime = 5000L;
            Long responseTime = response.extract().time();
            Assert.assertTrue(responseTime <= expectedTime,
                    "Response time threshold\nExpected: " + expectedTime + "\nActual: " + responseTime + "\n");
        } catch (AssertionError assertionError) {
            throw new AssertionError(
                    FilmsEndpoint.getFailedRequestErrorMessage(
                            FilmsEndpoint.getCustomRequest(),
                            assertionError.getMessage(),
                            response
                    ),
                    assertionError);
        }
    }

    @Test
    public void getFilmById() {
        try {
            ValidatableResponse responseById = FilmsEndpoint.getFilmById(3)
                    .spec(FilmsEndpoint.getRespSpec(200, ContentType.JSON));
            FilmDTO film = responseById.extract().as(FilmDTO.class);
            Assert.assertNotEquals(film.getTitle(), "");
        } catch (AssertionError assertionError) {
            throw new AssertionError(
                    FilmsEndpoint.getFailedRequestErrorMessage(
                            FilmsEndpoint.getCustomRequest(),
                            assertionError.getMessage(),
                            response
                    ),
                    assertionError);
        }
    }
}


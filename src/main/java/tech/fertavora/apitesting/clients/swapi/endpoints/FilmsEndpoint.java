package tech.fertavora.apitesting.clients.swapi.endpoints;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import tech.fertavora.apitesting.clients.swapi.SwapiService;

import static io.restassured.RestAssured.given;

public class FilmsEndpoint extends SwapiService {

    protected static RequestSpecification filmsEndpoint = setEndpoint("/films", swapiServiceBaseSpec);

    /**
     * A Request to /films to find a film by Id as path param
     * @param filmId The id of the film to find
     * @return ValidatableResponse Response to be validated
     */
    public static ValidatableResponse getFilmById(int filmId) {
        return given()
                .spec(filmsEndpoint)
                .pathParam("filmId", filmId)
                .when()
                .get("/{filmId}")
                .then();
    }

    /**
     * A Request to /films that returns all the films
     * @return ValidatableResponse Response to be validated
     */
    public static ValidatableResponse getFilms() {
        return getRequestNoHeadersNoParamsNoBody(filmsEndpoint);
    }
}

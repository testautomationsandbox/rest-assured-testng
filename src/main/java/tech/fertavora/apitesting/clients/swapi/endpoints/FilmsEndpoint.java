package tech.fertavora.apitesting.clients.swapi.endpoints;

import io.restassured.response.ValidatableResponse;
import tech.fertavora.apitesting.clients.swapi.SwapiService;

import static io.restassured.RestAssured.given;

public class FilmsEndpoint extends SwapiService {

    public static ValidatableResponse getFilmById(int filmId) {
        return given()
                .spec(filmsEndpoint)
                .pathParam("filmId", filmId)
                .when()
                .get("/{filmId}")
                .then();
    }

    public static ValidatableResponse getFilms() {
        return given()
                .spec(filmsEndpoint)
                .when()
                .get()
                .then();
    }
}

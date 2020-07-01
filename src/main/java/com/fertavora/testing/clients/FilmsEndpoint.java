package com.fertavora.testing.clients;

import io.restassured.response.ValidatableResponse;
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

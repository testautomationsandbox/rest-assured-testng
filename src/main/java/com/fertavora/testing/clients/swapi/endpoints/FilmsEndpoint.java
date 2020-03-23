package com.fertavora.testing.clients.swapi.endpoints;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class FilmsEndpoint extends SwapiService {
    private static RequestSpecification filmsRequest = given()
            .spec(createRequestSpecification("/films", swapiServiceSpec))
            .when();

    public static Response getFilmById(int id) {
        return filmsRequest.get("/" + id);
    }

    public static Response getFilms() {
        return filmsRequest.get("/");
    }
}

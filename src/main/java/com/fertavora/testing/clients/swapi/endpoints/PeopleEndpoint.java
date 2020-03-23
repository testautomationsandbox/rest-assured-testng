package com.fertavora.testing.clients.swapi.endpoints;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PeopleEndpoint extends SwapiService {

    private static RequestSpecification peopleRequest = given()
            .spec(createRequestSpecification("/people", swapiServiceSpec))
            .when();

    public static Response getPeopleById(int id) {
        return peopleRequest.get("/" + id);
    }

    public static Response getPeople() {
        return peopleRequest.get("/");
    }

}

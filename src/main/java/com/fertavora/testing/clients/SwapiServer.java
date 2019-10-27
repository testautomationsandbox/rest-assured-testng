package com.fertavora.testing.clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class SwapiServer {

    private static RequestSpecification requestSpec;
    private static RequestSpecification createRequestSpecification(String endpoint) {
        return new RequestSpecBuilder().
                setBaseUri("https://swapi.co/api/" + endpoint).
                build();
    }

    public static ValidatableResponse getPeopleById(int id) {
        return given()
                .spec(SwapiServer.createRequestSpecification("people"))
            .when()
                .get("/" + id)
            .then();
    }

}

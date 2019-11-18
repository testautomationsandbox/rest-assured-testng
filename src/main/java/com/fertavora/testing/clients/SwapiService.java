package com.fertavora.testing.clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class SwapiService {

    protected static RequestSpecBuilder defaultSpec = new RequestSpecBuilder().
            setBaseUri("https://swapi.co/api/");

    protected static RequestSpecification requestSpec;
    protected static RequestSpecification createRequestSpecification(String basePath) {
        return defaultSpec.
                setBasePath(basePath).
                build();
    }



}

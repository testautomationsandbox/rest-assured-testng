package com.fertavora.testing.clients.worldtimeapi.endpoints;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class TimezoneEndpoint extends WorldTimeAPI {

    private static RequestSpecification timezoneRequest = given()
            .spec(createRequestSpecification("/timezone", worldTimeApiSpec))
            .when();
}

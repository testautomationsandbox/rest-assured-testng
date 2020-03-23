package com.fertavora.testing.clients.swapi.endpoints;

import com.fertavora.testing.clients.BaseService;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class SwapiService extends BaseService {

    protected static RequestSpecBuilder swapiServiceSpec = new RequestSpecBuilder().
            setBaseUri("https://swapi.co/api/");

}

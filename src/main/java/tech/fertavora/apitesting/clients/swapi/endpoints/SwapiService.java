package tech.fertavora.apitesting.clients.swapi.endpoints;

import tech.fertavora.apitesting.clients.BaseService;
import io.restassured.builder.RequestSpecBuilder;

import static io.restassured.RestAssured.given;

public class SwapiService extends BaseService {

    protected static RequestSpecBuilder swapiServiceSpec = new RequestSpecBuilder().
            setBaseUri("https://swapi.co/api/");

}

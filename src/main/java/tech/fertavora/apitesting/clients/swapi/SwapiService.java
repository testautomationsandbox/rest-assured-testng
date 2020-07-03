package tech.fertavora.apitesting.clients.swapi;

import io.restassured.specification.RequestSpecification;
import tech.fertavora.apitesting.clients.BaseService;

public class SwapiService extends BaseService {

    protected static RequestSpecification swapiServiceBaseSpec = setBaseUrlSpec(System.getenv("SWAPI_BASE_URL"));

}

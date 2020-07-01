package tech.fertavora.apitesting.clients.swapi;

import io.restassured.specification.RequestSpecification;
import tech.fertavora.apitesting.clients.BaseService;

public class SwapiService extends BaseService {

    protected static RequestSpecification swapiServiceBaseSpec = setBaseUrlSpec("https://swapi.dev/api/");
    protected static RequestSpecification filmsEndpoint = setEndpoint("/films", swapiServiceBaseSpec);
    protected static RequestSpecification peopleEndpoint = setEndpoint("/people", swapiServiceBaseSpec);
}

package com.fertavora.testing.clients;

import io.restassured.specification.RequestSpecification;

public class SwapiService extends BaseService {

    protected static RequestSpecification swapiServiceBaseSpec = setBaseUrlSpec("https://swapi.dev/api/");
    protected static RequestSpecification filmsEndpoint = setEndpoint("/films", swapiServiceBaseSpec);
    protected static RequestSpecification peopleEndpoint = setEndpoint("/people", swapiServiceBaseSpec);

}

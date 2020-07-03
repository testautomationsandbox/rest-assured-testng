package tech.fertavora.apitesting.clients.swapi.endpoints;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import tech.fertavora.apitesting.clients.swapi.SwapiService;

public class StarshipsEndpoint extends SwapiService {

    protected static RequestSpecification starshipsEndpoint = setEndpoint("/starships", swapiServiceBaseSpec);

    /**
     * A Request to /starships that returns all the starships
     * @return ValidatableResponse Response to be validated
     */
    public static ValidatableResponse getSpecies() {
        return getRequest(starshipsEndpoint);
    }
}

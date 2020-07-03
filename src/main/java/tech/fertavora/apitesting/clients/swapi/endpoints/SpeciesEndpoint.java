package tech.fertavora.apitesting.clients.swapi.endpoints;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import tech.fertavora.apitesting.clients.swapi.SwapiService;

public class SpeciesEndpoint extends SwapiService {

    protected static RequestSpecification speciesEndpoint = setEndpoint("/species", swapiServiceBaseSpec);

    /**
     * A Request to /species that returns all the species
     * @return ValidatableResponse Response to be validated
     */
    public static ValidatableResponse getSpecies() {
        return getRequest(speciesEndpoint);
    }
}

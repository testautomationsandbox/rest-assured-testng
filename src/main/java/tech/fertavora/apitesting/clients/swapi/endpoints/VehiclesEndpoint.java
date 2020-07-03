package tech.fertavora.apitesting.clients.swapi.endpoints;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import tech.fertavora.apitesting.clients.swapi.SwapiService;

public class VehiclesEndpoint extends SwapiService {

    protected static RequestSpecification vehiclesEndpoint = setEndpoint("/vehicles", swapiServiceBaseSpec);

    /**
     * A Request to /vehicles that returns all the vehicles
     * @return ValidatableResponse Response to be validated
     */
    public static ValidatableResponse getSpecies() {
        return getRequest(vehiclesEndpoint);
    }
}

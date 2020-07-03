package tech.fertavora.apitesting.clients.swapi.endpoints;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import tech.fertavora.apitesting.clients.swapi.SwapiService;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PlanetsEndpoint extends SwapiService {

    protected static RequestSpecification planetsEndpoint = setEndpoint("/planets", swapiServiceBaseSpec);

    /**
     * A Request to /planets that returns all the planets
     * @return ValidatableResponse Response to be validated
     */
    public static ValidatableResponse getPlanets() {
        return getRequestNoHeadersNoParamsNoBody(planetsEndpoint);
    }

    public static ValidatableResponse getPlanetById(Integer planeId){
        Map<String, Integer> pathParamsMap = new HashMap<>();
        pathParamsMap.put("planeId", planeId);

        String pathFormat = "/{planeId}";
        return getRequestWithParamsNoHeadersNoBody(pathParamsMap, planetsEndpoint, pathFormat);
    }

    //todo move to interface?
    public static RequestSpecification getEndpoint() {
        return planetsEndpoint;
    }
}

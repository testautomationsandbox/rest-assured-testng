package tech.fertavora.apitesting.clients.swapi.endpoints;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
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
        return getRequest(planetsEndpoint);
    }

    public static ValidatableResponse getPlanetById(Integer planeId){
        Map<String, Integer> pathParamsMap = new HashMap<>();
        pathParamsMap.put("planetId", planeId);

        QueryableRequestSpecification queryRequest = SpecificationQuerier.query(planetsEndpoint);
        customRequest = new RequestSpecBuilder()
                .addRequestSpecification(planetsEndpoint)
                .addPathParams(pathParamsMap)
                .setBasePath(queryRequest.getBasePath() + "/{planetId}")
                .build();

        return getRequest(customRequest); // todo if works, rename to simple get request
    }

    //todo move to interface?
    public static RequestSpecification getCustomRequest() {
        return customRequest;
    }

}

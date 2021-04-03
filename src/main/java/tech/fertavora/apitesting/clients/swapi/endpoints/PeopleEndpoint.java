package tech.fertavora.apitesting.clients.swapi.endpoints;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import tech.fertavora.apitesting.clients.swapi.SwapiService;

import java.util.HashMap;
import java.util.Map;

public class PeopleEndpoint extends SwapiService {

    protected static RequestSpecification peopleEndpoint = setEndpoint("/people", swapiServiceBaseSpec);

    /**
     * A Request to /people to find a person by Id as path param
     * @param peopleId The id of the person to find
     * @return ValidatableResponse Response to be validated
     */
    public static ValidatableResponse getPeopleById(int peopleId) {
        Map<String, Integer> pathParamsMap = new HashMap<>();
        pathParamsMap.put("peopleId", peopleId);

        QueryableRequestSpecification queryRequest = SpecificationQuerier.query(peopleEndpoint);
        customRequest = new RequestSpecBuilder()
            .addRequestSpecification(peopleEndpoint)
            .addPathParams(pathParamsMap)
            .setBasePath(queryRequest.getBasePath() + "/{peopleId}")
            .build();
        return getRequest(customRequest);
    }

    /**
     * A Request to /people that returns all the characters
     * @return ValidatableResponse Response to be validated
     */
    public static ValidatableResponse getPeople() {
        customRequest = peopleEndpoint;
        return getRequest(customRequest);
    }

}

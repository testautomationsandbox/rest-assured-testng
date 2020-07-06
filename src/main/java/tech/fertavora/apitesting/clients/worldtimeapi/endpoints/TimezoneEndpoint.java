package tech.fertavora.apitesting.clients.worldtimeapi.endpoints;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import tech.fertavora.apitesting.clients.worldtimeapi.WorldTimeAPI;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

/**
 * Wrapper for the /timezone endpoint exposed by the Worldtime API.
 */
public class TimezoneEndpoint extends WorldTimeAPI {

    protected static RequestSpecification timezoneEndpoint = setEndpoint("/timezone", worldtimeServiceBaseSpec);

    /**
     * Performs a GET request to /timezone
     * @return The request response
     */
    public static ValidatableResponse getTimezones(){
        customRequest = timezoneEndpoint;
        return getRequest(timezoneEndpoint);
    }

    /**
     * Performs a GET request to /timezone/{timezoneName}
     * @param timezoneName The timezone name to be requested
     * @return The timezone response JSON object
     */
    public static ValidatableResponse getTimezoneByName(String timezoneName) {
        Map<String, String> pathParamsMap = new HashMap<>();
        pathParamsMap.put("timezoneName", timezoneName);

        QueryableRequestSpecification queryRequest = SpecificationQuerier.query(timezoneEndpoint);
        customRequest = new RequestSpecBuilder()
                .addRequestSpecification(timezoneEndpoint)
                .addPathParams(pathParamsMap)
                .setBasePath(queryRequest.getBasePath() + "/{timezoneName}")
                .build();

        return getRequest(customRequest);
    }
}

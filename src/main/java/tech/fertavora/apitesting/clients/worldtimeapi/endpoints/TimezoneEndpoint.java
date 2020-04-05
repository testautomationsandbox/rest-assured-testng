package tech.fertavora.apitesting.clients.worldtimeapi.endpoints;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

/**
 * Wrapper for the /timezone endpoint exposed by the Worldtime API.
 */
public class TimezoneEndpoint extends WorldTimeAPI {

    private static RequestSpecification timezoneRequest = given()
            .spec(createRequestSpecification("/timezone", worldTimeApiSpec))
            .when();

    /**
     * Performs a GET request to /timezone
     * @return The request response
     */
    public static Response getTimezones(){
        return timezoneRequest.get();
    }

    /**
     * Performs a GET request to /timezone/{timezoneName}
     * @param timezoneName The timezone name to be requested
     * @return The timezone response JSON object
     */
    public static Response getTimezone(String timezoneName) {
        return timezoneRequest.get(timezoneName);
    }
}

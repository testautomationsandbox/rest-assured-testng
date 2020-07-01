package tech.fertavora.apitesting.clients.worldtimeapi.endpoints;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import tech.fertavora.apitesting.clients.worldtimeapi.WorldTimeAPI;

import static io.restassured.RestAssured.given;

/**
 * Wrapper for the /timezone endpoint exposed by the Worldtime API.
 */
public class TimezoneEndpoint extends WorldTimeAPI {

    /**
     * Performs a GET request to /timezone
     * @return The request response
     */
    public static ValidatableResponse getTimezones(){
        return given()
                .spec(timezoneEndpoint)
                .when()
                .get()
                .then();
    }

    /**
     * Performs a GET request to /timezone/{timezoneName}
     * @param timezoneName The timezone name to be requested
     * @return The timezone response JSON object
     */
    public static ValidatableResponse getTimezone(String timezoneName) {
        return given()
                .spec(timezoneEndpoint)
                .pathParam("timezoneName", timezoneName)
                .when()
                .get("/{timezoneName}")
                .then();
    }
}

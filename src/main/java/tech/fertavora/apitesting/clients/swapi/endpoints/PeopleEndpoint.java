package tech.fertavora.apitesting.clients.swapi.endpoints;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import tech.fertavora.apitesting.clients.swapi.SwapiService;

import static io.restassured.RestAssured.given;

public class PeopleEndpoint extends SwapiService {

    protected static RequestSpecification peopleEndpoint = setEndpoint("/people", swapiServiceBaseSpec);

    /**
     * A Request to /people to find a person by Id as path param
     * @param peopleId The id of the person to find
     * @return ValidatableResponse Response to be validated
     */
    public static ValidatableResponse getPeopleById(int peopleId) {
        return given()
                .spec(peopleEndpoint)
                .pathParam("peopleId", peopleId)
                .when()
                .get("/{peopleId}")
                .then();
    }

    /**
     * A Request to /people that returns all the characters
     * @return ValidatableResponse Response to be validated
     */
    public static ValidatableResponse getPeople() {
        return getRequest(peopleEndpoint);
    }

}

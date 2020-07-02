package tech.fertavora.apitesting.clients.swapi.endpoints;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import tech.fertavora.apitesting.clients.swapi.SwapiService;

import static io.restassured.RestAssured.given;

public class PeopleEndpoint extends SwapiService {

    protected static RequestSpecification peopleEndpoint = setEndpoint("/people", swapiServiceBaseSpec);

    public static ValidatableResponse getPeopleById(int peopleId) {
        return given()
                .spec(peopleEndpoint)
                .pathParam("peopleId", peopleId)
                .when()
                .get("/{peopleId}")
                .then();
    }

    public static ValidatableResponse getPeople() {
        return given()
                .spec(peopleEndpoint)
                .when()
                .get()
                .then();
    }

}

package tech.fertavora.apitesting.clients.swapi.endpoints;

import io.restassured.response.ValidatableResponse;
import tech.fertavora.apitesting.clients.swapi.SwapiService;

import static io.restassured.RestAssured.given;

public class PeopleEndpoint extends SwapiService {

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

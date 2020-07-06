package tech.fertavora.apitesting.tests.swapi;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tech.fertavora.apitesting.clients.swapi.constants.PeopleResponseErrors;
import tech.fertavora.apitesting.clients.swapi.endpoints.PeopleEndpoint;
import tech.fertavora.apitesting.clients.swapi.dtos.PeopleDTO;
import tech.fertavora.apitesting.clients.swapi.endpoints.PlanetsEndpoint;

public class SwapiPeopleTests {

    @DataProvider(name = "PeopleDataProvider")
    public Object[][] peopleData() {
        return new Object[][]{
                {1, "Luke Skywalker", "male"},
                {2, "C-3PO", "n/a"},
                {3, "R2-D2", "n/a"}
        };
    }

    @Test(dataProvider = "PeopleDataProvider")
    public void requestPeopleById_checkResponseValues(int id, String name, String gender) {
        ValidatableResponse response = PeopleEndpoint.getPeopleById(id);
        try {
            response.spec(PeopleEndpoint.getRespSpec(200, ContentType.JSON));
            PeopleDTO peopleDTO = response.extract().as(PeopleDTO.class);
            Assert.assertEquals(peopleDTO.getName(), name, PeopleResponseErrors.NAME_IS_NOT_CORRECT);
            Assert.assertEquals(peopleDTO.getGender(), gender, PeopleResponseErrors.GENDER_IS_NOT_CORRECT);
        } catch (AssertionError assertionError) {
            throw new AssertionError(
                    PeopleEndpoint.getFailedRequestErrorMessage(
                            PeopleEndpoint.getCustomRequest(),
                            assertionError.getMessage(),
                            response
                    ),
                    assertionError);
        }

    }

}

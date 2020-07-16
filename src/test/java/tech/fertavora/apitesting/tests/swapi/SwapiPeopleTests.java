package tech.fertavora.apitesting.tests.swapi;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tech.fertavora.apitesting.clients.swapi.constants.PeopleResponseErrors;
import tech.fertavora.apitesting.clients.swapi.dtos.PeopleListDTO;
import tech.fertavora.apitesting.clients.swapi.endpoints.PeopleEndpoint;
import tech.fertavora.apitesting.clients.swapi.dtos.PeopleDTO;

public class SwapiPeopleTests {

    @DataProvider(name = "PeopleDataProvider")
    public Object[][] peopleData() {
        return new Object[][]{
                {1, "Luke Skywalker", "male"},
                {2, "C-3PO", "n/a"},
                {3, "R2-D2", "n/a"},
                {4, "Darth Vader", "male"},
                {5, "Leia Organa", "female"}
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

    @Test
    public void requestPeoplePage1_checkPreviousNull() {
        ValidatableResponse response = PeopleEndpoint.getPeople();
        try {
            response.spec(PeopleEndpoint.getRespSpec(200, ContentType.JSON));
            PeopleListDTO peopleList = response.extract().as(PeopleListDTO.class);
            Assert.assertNull(peopleList.getPrevious());
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

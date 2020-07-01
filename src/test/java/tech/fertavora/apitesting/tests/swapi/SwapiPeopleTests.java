package tech.fertavora.apitesting.tests.swapi;

import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tech.fertavora.apitesting.clients.swapi.constants.PeopleResponseErrors;
import tech.fertavora.apitesting.clients.swapi.endpoints.PeopleEndpoint;
import tech.fertavora.apitesting.clients.swapi.responses.PeopleResponse;
import tech.fertavora.apitesting.tests.ServiceTests;

public class SwapiPeopleTests extends ServiceTests {

    @DataProvider(name = "PeopleDataProvider")
    public Object[][] peopleData() {
        return new Object[][] {
                { 1, "Luke Skywalker", "male" },
                { 2, "C-3PO", "n/a" },
                { 3, "R2-D2", "n/a"}
        };
    }

    @Test(dataProvider = "PeopleDataProvider")
    public void requestPeopleById_checkResponseTimeAndValues(int id, String name, String gender) {
        ValidatableResponse response = PeopleEndpoint.getPeopleById(id).spec(responseSpecValid);
        PeopleResponse peopleResponse = response.extract().as(PeopleResponse.class);
        Assert.assertEquals(peopleResponse.getName(), name, PeopleResponseErrors.NAME_IS_NOT_CORRECT);
        Assert.assertEquals(peopleResponse.getGender(), gender, PeopleResponseErrors.GENDER_IS_NOT_CORRECT);
    }

}

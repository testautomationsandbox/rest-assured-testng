package com.fertavora.testing.tests;

import com.fertavora.testing.clients.swapi.endpoints.PeopleEndpoint;
import com.fertavora.testing.clients.swapi.constants.PeopleResponseErrors;
import com.fertavora.testing.clients.swapi.responses.PeopleResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
        Response res = PeopleEndpoint.getPeopleById(id);
        response = res.then();
        response.spec(responseSpecValid);
        PeopleResponse peopleResponse = response.extract().as(PeopleResponse.class);
        Assert.assertEquals(peopleResponse.getName(), name, PeopleResponseErrors.NAME_IS_NOT_CORRECT);
        Assert.assertEquals(peopleResponse.getGender(), gender, PeopleResponseErrors.GENDER_IS_NOT_CORRECT);
    }

}

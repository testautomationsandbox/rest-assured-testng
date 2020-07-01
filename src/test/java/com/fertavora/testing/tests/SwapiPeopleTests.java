package com.fertavora.testing.tests;

import com.fertavora.testing.clients.PeopleEndpoint;
import com.fertavora.testing.constants.PeopleResponseErrors;
import com.fertavora.testing.responses.PeopleResponse;
import io.restassured.response.ValidatableResponse;
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
        ValidatableResponse response = PeopleEndpoint.getPeopleById(id).spec(responseSpecValid);
        PeopleResponse peopleResponse = response.extract().as(PeopleResponse.class);
        Assert.assertEquals(peopleResponse.getName(), name, PeopleResponseErrors.NAME_IS_NOT_CORRECT);
        Assert.assertEquals(peopleResponse.getGender(), gender, PeopleResponseErrors.GENDER_IS_NOT_CORRECT);
    }

}

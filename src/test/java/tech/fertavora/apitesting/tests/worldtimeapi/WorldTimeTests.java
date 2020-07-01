package tech.fertavora.apitesting.tests.worldtimeapi;

import io.restassured.response.ValidatableResponse;
import tech.fertavora.apitesting.clients.worldtimeapi.endpoints.TimezoneEndpoint;
import tech.fertavora.apitesting.clients.worldtimeapi.responses.Timezone;
import tech.fertavora.apitesting.tests.ServiceTests;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WorldTimeTests extends ServiceTests {

    @DataProvider(name = "TimezonesDataProvider")
    public Object[][] timezonesDataSet() {
        return new Object[][] {
                { "America/Argentina/Buenos_Aires" },
                { "America/New_York" },
                { "America/Los_Angeles" },
                { "Europe/Rome" },
                { "Europe/Madrid" }
        };
    }

    @Test(priority = 1)
    public void requestTimezones(){
        ValidatableResponse response = TimezoneEndpoint.getTimezones().spec(responseSpecValid);
        String[] timezones = response.extract().as(String[].class);
        Assert.assertTrue(timezones.length > 10);
    }

    @Test(priority = 2, dataProvider = "TimezonesDataProvider")
    public void requestTimezone(String timezoneParam){
        ValidatableResponse response = TimezoneEndpoint.getTimezone(timezoneParam).spec(responseSpecValid);
        Timezone timezone = response.extract().as(Timezone.class);
        Assert.assertEquals(timezone.getTimezone(), timezoneParam);
    }

    @Test(priority = 3)
    public void failedRequest(){
        ValidatableResponse response = TimezoneEndpoint.getTimezone("sarasa");
        response.spec(failedResponse(404));
    }
}

package tech.fertavora.apitesting.tests.worldtimeapi;

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
        Response res = TimezoneEndpoint.getTimezones();
        response = res.then();
        response.spec(responseSpecValid);
        String[] timezones = response.extract().as(String[].class);
        Assert.assertTrue(timezones.length > 10);
    }

    @Test(priority = 2, dataProvider = "TimezonesDataProvider")
    public void requestTimezone(String timezoneParam){
        Response res = TimezoneEndpoint.getTimezone(timezoneParam);
        response = res.then();
        response.spec(responseSpecValid);
        Timezone timezone = response.extract().as(Timezone.class);
        Assert.assertEquals(timezone.getTimezone(), timezoneParam);
    }

    @Test(priority = 3)
    public void failedRequest(){
        Response res = TimezoneEndpoint.getTimezone("sarasa");
        response = res.then();
        response.spec(failedResponse(404));
    }
}
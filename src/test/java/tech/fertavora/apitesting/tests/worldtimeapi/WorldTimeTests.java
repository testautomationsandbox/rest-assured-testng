package tech.fertavora.apitesting.tests.worldtimeapi;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import tech.fertavora.apitesting.clients.worldtimeapi.endpoints.TimezoneEndpoint;
import tech.fertavora.apitesting.clients.worldtimeapi.responses.Timezone;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WorldTimeTests {
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
        ValidatableResponse response = TimezoneEndpoint.getTimezones();
        try{
            response.spec(TimezoneEndpoint.getRespSpec(200, ContentType.JSON));
            String[] timezones = response.extract().as(String[].class);
            Assert.assertTrue(timezones.length > 10);
        } catch (AssertionError assertionError) {
            throw new AssertionError(
                    TimezoneEndpoint.getFailedRequestErrorMessage(
                            TimezoneEndpoint.getCustomRequest(),
                            assertionError.getMessage(),
                            response
                    ),
                    assertionError);
        }
    }

    @Test(priority = 2, dataProvider = "TimezonesDataProvider")
    public void requestTimezone(String timezoneParam){
        ValidatableResponse response = TimezoneEndpoint.getTimezoneByName(timezoneParam);
        try {
            response.spec(TimezoneEndpoint.getRespSpec(200, ContentType.JSON));
            Timezone timezone = response.extract().as(Timezone.class);
            Assert.assertEquals(timezone.getTimezone(), timezoneParam);
        } catch (AssertionError assertionError) {
            throw new AssertionError(
                    TimezoneEndpoint.getFailedRequestErrorMessage(
                            TimezoneEndpoint.getCustomRequest(),
                            assertionError.getMessage(),
                            response
                    ),
                    assertionError);
        }
    }

    @Test(priority = 3)
    public void failedRequest(){
        ValidatableResponse response = TimezoneEndpoint.getTimezoneByName("mustfail");
        try {
            response.spec(TimezoneEndpoint.getRespSpec(404, ContentType.JSON));
        } catch (AssertionError assertionError) {
            throw new AssertionError(
                    TimezoneEndpoint.getFailedRequestErrorMessage(
                            TimezoneEndpoint.getCustomRequest(),
                            assertionError.getMessage(),
                            response
                    ),
                    assertionError);
        }
    }
}

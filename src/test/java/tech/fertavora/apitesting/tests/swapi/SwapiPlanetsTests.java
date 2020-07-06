package tech.fertavora.apitesting.tests.swapi;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.Assert;
import org.testng.annotations.Test;
import tech.fertavora.apitesting.clients.swapi.dtos.PlanetDTO;
import tech.fertavora.apitesting.clients.swapi.dtos.PlanetsListDTO;
import tech.fertavora.apitesting.clients.swapi.endpoints.PlanetsEndpoint;

public class SwapiPlanetsTests {

    @Test
    public void requestPlanetById_checkResponseValues(){
        ValidatableResponse response = PlanetsEndpoint.getPlanetById(4);
        try {
            response.spec(PlanetsEndpoint.getRespSpec(200, ContentType.JSON));
            PlanetDTO planet = response.extract().as(PlanetDTO.class);
            Assert.assertEquals(planet.getName(), "Hoth");
        } catch(AssertionError assertionError) {
            throw new AssertionError(
                PlanetsEndpoint.getFailedRequestErrorMessage(
                    PlanetsEndpoint.getCustomRequest(),
                    assertionError.getMessage(),
                    response
                ),
                assertionError);
        }
    }

    @Test
    public void requestPlanets_checkResponseFormatAndNotEmptyList() {
        ValidatableResponse response = PlanetsEndpoint.getPlanets();
        try {
            response.spec(PlanetsEndpoint.getRespSpec(200, ContentType.JSON));
            PlanetsListDTO planetsList = response.extract().as(PlanetsListDTO.class);
            Assert.assertTrue(planetsList.getResults().size() > 0);
        }catch (AssertionError assertionError) {
            throw new AssertionError(
                PlanetsEndpoint.getFailedRequestErrorMessage(
                    PlanetsEndpoint.getCustomRequest(),
                    assertionError.getMessage(),
                    response
                ),
                assertionError);
        }
    }
}

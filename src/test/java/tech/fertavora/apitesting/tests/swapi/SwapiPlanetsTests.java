package tech.fertavora.apitesting.tests.swapi;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.SpecificationQuerier;
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
            response.spec(PlanetsEndpoint.getRespSpec(203, ContentType.JSON));
            PlanetDTO planet = response.extract().as(PlanetDTO.class);
            Assert.assertEquals(planet.getName(), "Hoth");
        } catch(AssertionError assertionError) {
            // todo custom error to be moved to method on service base class
            // also reformat req spec to include params
            QueryableRequestSpecification queryRequest = SpecificationQuerier.query(PlanetsEndpoint.getEndpoint());
            String errorMessage = assertionError.getMessage() +
                    "\nGET " + queryRequest.getBaseUri() + queryRequest.getBasePath() + queryRequest.getPathParams().toString() +
                    "\n\nResponse Headers:\n" + response.extract().response().getHeaders().toString() +
                    "\n\nResponse Body:\n" + response.extract().response().prettyPrint();
            throw new AssertionError(errorMessage, assertionError);
        }

    }

    @Test
    public void requestPlanets_checkResponseFormatAndNotEmptyList() {
        ValidatableResponse response = PlanetsEndpoint.getPlanets()
                .spec(PlanetsEndpoint.getRespSpec(200, ContentType.JSON));
        PlanetsListDTO planetsList = response.extract().as(PlanetsListDTO.class);
        Assert.assertTrue(planetsList.getResults().size() > 0);
    }
}

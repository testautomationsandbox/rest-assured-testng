package tech.fertavora.apitesting.clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.specification.SpecificationQuerier;
import tech.fertavora.apitesting.clients.swapi.endpoints.PlanetsEndpoint;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseService {

    protected static RequestSpecification customRequest;

    /**
     * The base request spec.
     * Defines the base path of the service under test and logging details
     * @param baseUrl
     * @return
     */
    protected static RequestSpecification setBaseUrlSpec(String baseUrl) {
        return new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .log(LogDetail.METHOD)
                .log(LogDetail.URI)
                .log(LogDetail.HEADERS)
                .log(LogDetail.PARAMS)
                .log(LogDetail.BODY)
                .build();
    }

    /**
     * The base path spec.
     * It defines an endpoint of the service under test reusing the base path req spec
     * @param basePath
     * @param baseUrlReqSpec
     * @return
     */
    protected static RequestSpecification setEndpoint(String basePath, RequestSpecification baseUrlReqSpec) {
        return new RequestSpecBuilder()
                .addRequestSpecification(baseUrlReqSpec)
                .setBasePath(basePath)
                .build();
    }

    /**
     * A GET request
     * @param requestSpec The req spec to be send the request
     * @return ValidatableResponse The response to be validated
     */
    protected static ValidatableResponse getRequest(RequestSpecification requestSpec) {
        return given()
                .spec(requestSpec)
                .when()
                .get()
                .then();
    }

    public static ResponseSpecification getRespSpec(int expectedStatusCode, ContentType expectedContentType) {
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectStatusCode(expectedStatusCode)
                .expectContentType(expectedContentType)
                .build();
    }

    /**
     * Generates a custom error message with the information of the request sent.
     * Helps to get request details on stackTrace messages on reporting output.
     * @param reqSpec The request specification that failed the request
     * @param assertionErrorMessage The error message of the fail itself
     * @param response The response of the failed request
     * @return
     */
    public static String getFailedRequestErrorMessage(RequestSpecification reqSpec, String assertionErrorMessage, ValidatableResponse response) {
        QueryableRequestSpecification queryRequest = SpecificationQuerier.query(PlanetsEndpoint.getCustomRequest());
        String requestBody = "Request had no body";
        if (queryRequest.getBody() != null) {
            requestBody = queryRequest.getBody().toString();
        }

        String errorMessage = assertionErrorMessage +
                "\nGET " + queryRequest.getBaseUri() + queryRequest.getBasePath() +
                "\nPath Params: " + queryRequest.getPathParams().toString() +
                "\nForm Params: " + queryRequest.getFormParams().toString() +
                "\nQuery Params: " + queryRequest.getQueryParams().toString() +
                "\nRequest Headers:\n" + queryRequest.getHeaders().toString() +
                "\nRequest Body: " + requestBody +
                "\n\nResponse Headers:\n" + response.extract().response().getHeaders().toString() +
                "\n\nResponse Body:\n" + response.extract().response().prettyPrint();

        return errorMessage;
    }

    /**
     * Returns the request specification set as current.
     * Helpful for reporting output
     * @return The request specification set as custom request.
     */
    public static RequestSpecification getCustomRequest() {
        return customRequest;
    }
}

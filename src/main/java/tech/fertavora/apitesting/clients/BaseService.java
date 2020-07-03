package tech.fertavora.apitesting.clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseService {

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
     * A GET request with no params, body nor headers
     * @param requestSpec The req spec to be send the request
     * @return ValidatableResponse The response to be validated
     */
    protected static ValidatableResponse getRequestNoHeadersNoParamsNoBody(RequestSpecification requestSpec) {
        return given()
                .spec(requestSpec)
                .when()
                .get()
                .then();
    }

    /**
     * A GET request with path params, no body, no headers.
     *
     * @param paramsMap The path params to be passed
     * @param requestSpec The req spec to be sent the GET
     * @param pathFormat The path format with params reference. e.g. "/clients/{clientId}/addresses/{addressId}"
     * @return
     */
    protected static ValidatableResponse getRequestWithParamsNoHeadersNoBody(Map<String, ?> paramsMap, RequestSpecification requestSpec, String pathFormat) {
        return given()
                .spec(requestSpec)
                .pathParams(paramsMap)
                .when()
                .get(pathFormat)
                .then();
    }

    public static ResponseSpecification getRespSpec(int expectedStatusCode, ContentType expectedContentType) {
        return new ResponseSpecBuilder()
                .log(LogDetail.ALL)
                .expectStatusCode(expectedStatusCode)
                .expectContentType(expectedContentType)
                .build();
    }
}

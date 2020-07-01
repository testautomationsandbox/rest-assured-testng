package tech.fertavora.apitesting.tests;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.ResponseSpecification;

/***
 * This class is extended by each test class.
 * It defines default request specifications to test.
 */
public abstract class ServiceTests {
    public static ValidatableResponse response;
    public static ResponseSpecification responseSpecValid = new ResponseSpecBuilder().
            expectStatusCode(200).
            expectContentType(ContentType.JSON).
            build();

    public static ResponseSpecification failedResponse(int statusCode){
        return new ResponseSpecBuilder().
                expectStatusCode(statusCode).
                expectContentType(ContentType.JSON).
                build();
    }
}

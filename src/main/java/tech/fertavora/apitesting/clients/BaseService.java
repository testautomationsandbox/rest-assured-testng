package tech.fertavora.apitesting.clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseService {

    protected static RequestSpecification setBaseUrlSpec(String baseUrl) {
        return new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .build();
    }

    protected static RequestSpecification setEndpoint(String basePath, RequestSpecification baseUrlReqSpec) {
        return new RequestSpecBuilder()
                .addRequestSpecification(baseUrlReqSpec)
                .setBasePath(basePath)
                .build();
    }
}

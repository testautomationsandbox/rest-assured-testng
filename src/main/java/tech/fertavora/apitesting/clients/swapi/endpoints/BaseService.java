package com.fertavora.testing.clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;

public class BaseService {
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

    protected static RequestSpecification setEndpoint(String endpoint, RequestSpecification baseServiceSpec){
        return new RequestSpecBuilder()
                .addRequestSpecification(baseServiceSpec)
                .setBasePath(endpoint)
                .build();
    }
}

package com.fertavora.testing.clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseService {

    protected static RequestSpecification requestSpec;
    protected static RequestSpecification createRequestSpecification(String basePath, RequestSpecBuilder defaultSpec) {
        return defaultSpec.
                setBasePath(basePath).
                build();
    }

}

package com.fertavora.testing.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public interface BasicChecks {
    void getRequest();
    void checkStatusCode();
    void checkContentType();
    void checkResponseTime();
}

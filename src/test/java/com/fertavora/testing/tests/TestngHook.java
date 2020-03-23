package com.fertavora.testing.tests;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestngHook {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println(">>> Before Suite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println(">>> Before Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println(">>> Before Method");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println(">>> After Suite");
    }

    @AfterClass
    public void afterClass() {
        System.out.println(">>> After Class");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println(">>> After Method");
    }

    @Test(testName = "I am the passing test case", description = "This test case must pass.")
    public void dummyTest() {
        Assert.assertEquals(true, true, "This is a dummy assertion.");
    }

    @Test(testName = "I am the failing test case", description = "This test case must fail.")
    public void failTest() {
        Assert.assertEquals(false, true, "I am the test that MUST fail.");
    }
}

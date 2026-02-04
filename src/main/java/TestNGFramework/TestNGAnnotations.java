package TestNGFramework;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;

public class TestNGAnnotations {

    // ---------------------- 6.1 Annotations ----------------------

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite: Executed once before the suite starts");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite: Executed once after the suite ends");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test: Executed before any test in <test> tag");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test: Executed after all tests in <test> tag");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class: Executed before the first method of the class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class: Executed after the last method of the class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method: Executed before each @Test method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method: Executed after each @Test method");
    }

    // ---------------------- 6.2 Enable / Disable ----------------------

    @Test(enabled = true)
    public void enabledTest() {
        System.out.println("Enabled Test: This test will run");
    }

    @Test(enabled = false)
    public void disabledTest() {
        System.out.println("Disabled Test: This test will NOT run");
    }

    // ---------------------- 6.3 Sequence of Execution and Priority ----------------------

    @Test(priority = 2)
    public void logoutTest() {
        System.out.println("Priority 2: Logout Test");
    }

    @Test(priority = 1)
    public void loginTest() {
        System.out.println("Priority 1: Login Test");
    }

    @Test(priority = 3, dependsOnMethods = {"loginTest"})
    public void profileTest() {
        System.out.println("Priority 3: Profile Test (depends on Login Test)");
    }
}

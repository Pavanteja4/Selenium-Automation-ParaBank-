package Hooks;

import base.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    String browser = "chrome"; 
    // you can change to "edge" or pass 

    @Before(order = 0)
    public void setUp() {

        // initialize browser
        BaseClass.getDriver(browser);

        // launch application
        BaseClass.launchApp();

        System.out.println("Browser launched and application opened");
    }

    @After(order = 0)
    public void tearDown() {

        // quit browser
        BaseClass.quitDriver();

        System.out.println("Browser closed successfully");
    }
}
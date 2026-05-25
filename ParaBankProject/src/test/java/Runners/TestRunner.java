package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
//import org.testng.annotations.DataProvider;

@CucumberOptions(
    features = "src/test/resources/Features",
    glue = {"stepDefinitions", "Hooks"},
    plugin = {"pretty", "html:target/cucumber-reports.html"},
    monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

  
    }




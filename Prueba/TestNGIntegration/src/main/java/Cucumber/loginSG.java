package Cucumber;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/main/resources/testlogin.feature" }, glue = { "StepsDefinitions" }
)

@Test
public class loginSG extends AbstractTestNGCucumberTests {

}

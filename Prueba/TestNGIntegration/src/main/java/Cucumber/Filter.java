package Cucumber;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = { "src/main/resources/Feature/filter.feature" }, glue = {
		"StepsDefinitions" } /* strict= true, dryRun= true */
)

@Test
public class Filter extends AbstractTestNGCucumberTests {

}

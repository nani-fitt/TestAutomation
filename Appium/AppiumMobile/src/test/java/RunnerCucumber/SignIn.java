package RunnerCucumber;

import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;


	
	@CucumberOptions(features = { "src/test/resources/TestCases/SignIn.feature" }, glue = {
	"StepDefinitions" } /* strict= true, dryRun= true */
)
  @Test
  public class SignIn extends AbstractTestNGCucumberTests {
}

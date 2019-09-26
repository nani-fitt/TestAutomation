package StepsDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.UserDataHandler;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginSG {

	WebDriver driver;

	@Given("^I have valid set of data and access to Sign In$")
	public void EnterSGpage() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "./src/main/java/Driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://staging.supremegolf.com/");
	}

	@When("^Sign In on page is selected$")
	public void SelectSignInOptions() throws Throwable {
		driver.findElement(By.xpath("//a[@class='l-subheader__text sign-in']")).click();

	}

	@When("^I enter valid data username and password$")
	public void EnterData(DataTable data1) throws Throwable {
		List<List<String>> data = data1.raw();

		driver.findElement(By.id("user_email")).clear();
		driver.findElement(By.id("user_email")).sendKeys(data.get(0).get(0));

		driver.findElement(By.id("user_password")).clear();
		driver.findElement(By.id("user_password")).sendKeys(data.get(0).get(1));

	}

	@Then("^Click on Sign In button$")
	public void clickSignInbutton() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Sign In')]")).click();
		;
	}

	@Then("^Sign In successful: should be displayed$")
	public void signInsuccessful() throws Throwable {

		System.out.println("estoy dentro");
	}

	@Then("^I enter valid data courses on the search field$")
	public void SelectSignInOptions(DataTable data) throws Exception {

		List<List<String>> data1 = data.raw();

		Thread.sleep(3000);
		if (driver.findElement(By.cssSelector("#q_home")).isDisplayed()) {
			driver.findElement(By.cssSelector("#q_home")).click();
			driver.findElement(By.cssSelector("#q_home")).sendKeys(data1.get(0).get(0));
		}
	}

	@Then("^User click on Search button$")
	public void clickSearch() throws Throwable {

		driver.findElement(
				By.xpath("//button[@class='m-home-search__btn btn btn-orange btn-round icon-search oval-btn']"))
				.click();

	}

	@Then("^Show the tee time$")
	public void ready() throws Throwable {

		Assert.assertEquals("SUPREME GOLF DEMO COURSE",
				driver.findElement(By.xpath("//span[@id='course_26311']")).getText());
	}

}

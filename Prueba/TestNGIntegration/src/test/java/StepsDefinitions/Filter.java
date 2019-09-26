package StepsDefinitions;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Class.TestBase;
import ClassPage.LoginAdminPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Filter {

	WebDriver driver;
	LoginAdminPage page; // = new LoginAdminPage(driver);;

	@Given("^I have a valid the search$")
	public void OpenBrowersOnPage() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "./src/main/java/Driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

	}

	@When("^Enter on the functionality Barter tee times$")
	public void EnterBarterTeeTimes() throws Throwable {
		page = new LoginAdminPage(driver);
		page.GetUrl();
		page.BarterSearch("eguerrero@codigodelsur.com", "Cdelsur1");
	}

	@When("^Enter valid course and dateini and enddate$")
	public void EntertheData(DataTable data) throws Throwable {

		for(Map<String, String> dat : data.asMaps(String.class, String.class))
		{
		// implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id=\"new_q\"]/div[1]/div/button")).click();
		
		driver.findElement(By.xpath("//input[@class='form-control']")).clear();
		driver.findElement(By.xpath("//input[@class='form-control']")).click();
		
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(dat.get("course"));
		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys(Keys.ENTER);
        
		driver.findElement(By.xpath("//input[@id='q_tee_off_at_local_date_gteq']")).clear();
		driver.findElement(By.xpath("//input[@id='q_tee_off_at_local_date_gteq']")).sendKeys(dat.get("dateini"));
		driver.findElement(By.xpath("//input[@id='q_tee_off_at_local_date_gteq']")).sendKeys(Keys.ENTER);

		driver.findElement(By.xpath("//input[@id='q_tee_off_at_local_date_lteq']")).clear();
		driver.findElement(By.xpath("//input[@id='q_tee_off_at_local_date_lteq']")).sendKeys(dat.get("enddate"));
		driver.findElement(By.xpath("//input[@id='q_tee_off_at_local_date_lteq']")).sendKeys(Keys.ENTER);
 
		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='q_tee_off_at_local_time_gteq']")));

		driver.findElement(By.xpath("//input[@id='q_tee_off_at_local_time_gteq']")).click();
		driver.findElement(By.xpath(
				"//div[@class='form-group form-group-sm string required q_tee_off_at_local_time_gteq']//div[@class='time']//input[@class='timepicki-input']"))
				.click();
		driver.findElement(By.xpath(
				"//div[@class='form-group form-group-sm string required q_tee_off_at_local_time_gteq']//div[@class='time']//input[@class='timepicki-input']"))
				.clear();
		driver.findElement(By.xpath(
				"//div[@class='form-group form-group-sm string required q_tee_off_at_local_time_gteq']//div[@class='time']//input[@class='timepicki-input']"))
				.sendKeys("12");
			driver.findElement(By.name("commit")).click();
			Thread.sleep(6000);
			
			Actions act= new Actions(driver);
			driver.findElement(By.xpath("//*[@id=\"new_q\"]/div[1]/div/button")).click();
			
		
			
		}
		
	}

	@Then("^Click on the Create Search$")
	public void clickCreateSearch() throws Throwable {

		//driver.findElement(By.name("commit")).click();

	}

	@Then("^Show the result of the search$")
	public void ShowtheResult() throws Throwable {
		System.out.println("Show the result of the search");
		// Assert.assertEquals("Supreme Golf Demo Course",
		// driver.findElement(By.xpath("//tr[1]//td[1]")).getText());
	}

}

package StepDefinitions;

import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class SignInMobile {

	AndroidDriver<WebElement> driver;

	@Given("^Open the app Supreme Golf$")
	public void openappSupreme_Golf() throws Throwable {

		/*DesiredCapabilities test = new DesiredCapabilities();
		test.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		test.setCapability(MobileCapabilityType.DEVICE_NAME, "N@NI");
		test.setCapability(MobileCapabilityType.UDID, "4CU9X18907G01546");
		test.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		test.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");

		test.setCapability("appPackage", "com.supremegolf.app.stage");
		test.setCapability("appActivity", "com.supremegolf.app.ui.activity.SplashActivity");*/
		
		DesiredCapabilities test = new DesiredCapabilities();
		test.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		test.setCapability(MobileCapabilityType.DEVICE_NAME, "Google Nexus 5X");
		test.setCapability(MobileCapabilityType.UDID, "192.168.138.106:5555");
		test.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		test.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");

		test.setCapability("appPackage", "com.supremegolf.app.stage");
		test.setCapability("appActivity", "com.supremegolf.app.ui.activity.SplashActivity");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AndroidDriver<WebElement>(url, test);
		Thread.sleep(6000);
	}

	@When("^Select the option MySG$")
	public void selectMySG() throws Throwable {
		
		WebElement num1 = driver.findElement(By.id("com.android.packageinstaller:id/permission_deny_button"));
		num1.click();
		Thread.sleep(2000);
		
		/*WebElement num1 = driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
		num1.click();
		Thread.sleep(2000);*/

		driver.findElement(By.id("com.supremegolf.app.stage:id/icon")).click();
	}

	@When("^Select the option SignIn$")
	public void selectSignIn() throws Throwable {

		driver.findElement(By.id("com.supremegolf.app.stage:id/icon")).click();
	}

	@Then("^Enter the data username and password$")
	public void EnterData(DataTable data) throws Throwable {

		for (Map<String, String> dat : data.asMaps(String.class, String.class)) {
			
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			
			if (driver
					.findElement(By.xpath(
							"//android.widget.FrameLayout[@content-desc=\"MySG\"]/android.widget.ImageView\r\n" + ""))
					.isDisplayed()) {

				driver.findElement(By.xpath(
						"//android.widget.FrameLayout[@content-desc=\"MySG\"]/android.widget.ImageView\r\n" + ""))
						.click();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

				driver.findElement(By.id("com.supremegolf.app.stage:id/fav_signin")).click();

				driver.findElement(By.id("com.supremegolf.app.stage:id/signIn_email_edittext"))
						.sendKeys(dat.get("username"));

				driver.findElement(By.id("com.supremegolf.app.stage:id/signIn_password_edittext"))
						.sendKeys(dat.get("password"));

				driver.findElement(By.id("com.supremegolf.app.stage:id/signIn_btnView")).click();

			//	Alert alert = driver.switchTo().alert();
			//	alert.accept();

				Thread.sleep(3000);

				driver.findElement(By.id("com.supremegolf.app.stage:id/settings_container")).click();
				driver.findElement(By.id("com.supremegolf.app.stage:id/rl_signoutLayoutHolder")).click();
				if(driver.findElement(By.id("android:id/button1")).isDisplayed())
				{
					driver.findElement(By.id("android:id/button1")).click();
				}
			}
		}
	}

	@Then("^Click on button SignIn$")
	public void clickSignIn() throws Throwable {

		System.out.println("Usuario logueado");

	}

}

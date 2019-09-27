package StepDefinitions;

import java.net.URL;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ClassBase.ClassbaseMobile;
import ClassBase.Scrolling;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BookingMobile {

	AndroidDriver<WebElement> driver;
	

	@Given("^Open the app Supreme Golf and made signIn$")
	public void openSupremeGolfandmadesignIn(DataTable data) throws Throwable {

		DesiredCapabilities test = new DesiredCapabilities();
		test.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		test.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy S10");
		test.setCapability(MobileCapabilityType.UDID, "192.168.138.105:5555");
		test.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		test.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");

		test.setCapability("appPackage", "com.supremegolf.app.stage");
		test.setCapability("appActivity", "com.supremegolf.app.ui.activity.SplashActivity");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AndroidDriver<WebElement>(url, test);
		Thread.sleep(6000);

		WebElement num1 = driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")); // mensaje
																												// de
																												// alerta
																												// dar
																												// allow
		num1.click();
		Thread.sleep(2000);

		driver.findElement(By.id("android:id/button2")).click(); // mensaje de alerta not thanks

		Thread.sleep(2000);

		driver.findElement(By.id("com.supremegolf.app.stage:id/icon")).click();

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

				Thread.sleep(3000);

			}
		}

	}

	@When("^Search a course for made the reservation$")
	public void searchCourse() throws Throwable {

		driver.findElement(
				By.xpath("//android.widget.FrameLayout[@content-desc=\"Home\"]/android.widget.ImageView\r\n" + ""))
				.click(); // button home

		driver.findElement(By.id("com.supremegolf.app.stage:id/ivTeeTime_bg")).click(); // book tee times

		Thread.sleep(2000);

		driver.findElement(By.id("android:id/button2")).click(); // not thanks

		Thread.sleep(5000);

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.id("com.supremegolf.app.stage:id/search_tv"))));

		driver.findElement(By.id("com.supremegolf.app.stage:id/search_tv")).click();

		Thread.sleep(3000);

		driver.findElement(By.id("com.supremegolf.app.stage:id/search_tv")).click();

		Thread.sleep(3000);

		driver.findElement(By.id("com.supremegolf.app.stage:id/search_tv")).sendKeys("Supreme golf demo course");

		Thread.sleep(2000);
		driver.findElement(By.id("com.supremegolf.app.stage:id/item_search_name")).click();// seleccionar la course
																							// supreme golf

		Thread.sleep(3000);

		driver.findElement(By.id("com.supremegolf.app.stage:id/btn_search")).click();

		Thread.sleep(5000);

	}

	@When("^Select the tee time for made the booking$")
	public void selectTeetime() throws Throwable {

		driver.findElement(By.id("com.supremegolf.app.stage:id/img_right_arrow")).click();

		Thread.sleep(5000);
		//	com.supremegolf.app.stage:id/tee_times_item_list
		//android:id/content
		String scrollableList = "com.supremegolf.app.stage:id/tee_times_item_list";
		String uiSelector = "android.widget.TextView";
		String textToSearchInList = "7:20";
		try{
			Scrolling page= new Scrolling(driver);
		  MobileElement element= page.scrollElementByContentText(scrollableList, uiSelector, textToSearchInList);
		  element.click();
		    
		}catch(Exception e){
		    //do nothing
		}
		
		
		Thread.sleep(3000);
		}	
		

	@Then("^Select the players and made click on checkbox button$")
	public void selectPlayersandClickcheckboxButton() throws Throwable {

		Actions ver = new Actions(driver);
		ver.moveToElement(driver.findElement(By.id("com.supremegolf.app.stage:id/numberOfPlayersHolder"))).build()
				.perform();
		driver.findElement(By.id("com.supremegolf.app.stage:id/numberOfPlayersHolder")).click();

		Thread.sleep(2000);
		
		ver.moveToElement(driver.findElement(By.id("com.supremegolf.app.stage:id/players_screen_single_player_view")))
				.build().perform();
		driver.findElement(By.id("com.supremegolf.app.stage:id/players_screen_single_player_view")).click(); // dos players
		
		Thread.sleep(2000);
		
		ver.moveToElement(driver.findElement(By.id("com.supremegolf.app.stage:id/switchTermsConditions1")))
		.build().perform();
        driver.findElement(By.id("com.supremegolf.app.stage:id/switchTermsConditions1")).click();    
		   
		   
		
	}
		

		
	

	@Then("^Click on button Booking$")
	public void click_on_button_Booking() throws Throwable {

		Thread.sleep(2000);

		driver.findElement(By.id("com.supremegolf.app.stage:id/btnBookNow")).click();
	}

}

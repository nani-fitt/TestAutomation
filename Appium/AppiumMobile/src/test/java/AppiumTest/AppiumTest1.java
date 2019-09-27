package AppiumTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumTest1 {
	
	
	
	
	//public static WebDriver driver;
	
	public static void main(String[] args) throws Exception
	{
		DesiredCapabilities test= new DesiredCapabilities();
		test.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		test.setCapability(MobileCapabilityType.DEVICE_NAME, "N@NI");
		test.setCapability(MobileCapabilityType.UDID, "4CU9X18907G01546");
		test.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		test.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0");
		
		test.setCapability("appPackage", "com.supremegolf.app.stage");
		test.setCapability("appActivity", "com.supremegolf.app.ui.activity.SplashActivity");
		
		
		URL url= new URL("http://127.0.0.1:4723/wd/hub");
		
		AndroidDriver<WebElement> driver= new AndroidDriver<WebElement> (url, test);
		Thread.sleep(6000);
		System.out.println("starting ");
		
		WebElement num1= driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button"));
		num1.click();
		Thread.sleep(2000);
		
		driver.findElement(By.id("com.supremegolf.app.stage:id/icon")).click();
		
		if(driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"MySG\"]/android.widget.ImageView\r\n" + 
				"")).isDisplayed())
		{
		
		driver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"MySG\"]/android.widget.ImageView\r\n" + 
				"")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		driver.findElement(By.id("com.supremegolf.app.stage:id/fav_signin")).click();
		
		driver.findElement(By.id("com.supremegolf.app.stage:id/signIn_email_edittext")).sendKeys("test@mailinator.com");
		
		driver.findElement(By.id("com.supremegolf.app.stage:id/signIn_password_edittext")).sendKeys("123456");
		
		driver.findElement(By.id("com.supremegolf.app.stage:id/signIn_btnView")).click();
		  
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		Thread.sleep(2000);
		
		}
		
	
	}
	
	public static void openCalculator() throws Exception
	{
		
		
		
		
	}

}

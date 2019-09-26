package Class;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;

public class TestBase {

	protected WebDriver driver;
	JavascriptExecutor ex;

	@BeforeClass
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", "./src/main/java/Driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		

		/*System.setProperty("webdriver.chrome.driver", "./src/main/java/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();*/
		

	}
	///-----------------------para hacer scroll y llegar al elemento---------------------------------------------
	
/*	public void javaScriptScrollView(WebElement element) 
	{		
			ex.executeScript("arguments[0].scrollIntoView();", element);
	}*/

	@AfterClass
	public void afterTest() {

		// driver.close();
	}

}

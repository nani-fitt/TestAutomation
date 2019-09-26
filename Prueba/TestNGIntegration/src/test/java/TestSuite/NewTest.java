package TestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest {
	
	private WebDriver driver;
  @Test
  public void ByVisibleElement() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "./src/main/java/Driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
    //  JavascriptExecutor js = (JavascriptExecutor) driver;

      //Launch the application		
      driver.get("https://staging.supremegolf.com/tee-times/at/supreme-golf-demo-course-texas/on/september-14");

      //Find element by link text and store in variable "Element"        		
    //  WebElement Element = driver.findElement(By.xpath("//tr[@id='tee_time_703403626']//span[@class='words'][contains(text(),'Book It')]"));

      //This will scroll the page till the element is found		
   //   js.executeScript("arguments[0].scrollIntoView();", Element);
      
      WebElement element = driver.findElement(By.xpath("//tr[@id='tee_time_705301472']//span[@class='words'][contains(text(),'Book It')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		
		
		
  }
}

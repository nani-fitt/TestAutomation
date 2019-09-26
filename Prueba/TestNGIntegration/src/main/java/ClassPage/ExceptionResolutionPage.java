package ClassPage;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Class.ClassBase;

public class ExceptionResolutionPage extends ClassBase {

	By id = By.xpath("//table[@class='table table-striped table-hover']//td[contains(text(),'554')]");   
	
	By time = By.id("resolution_start_time_164");
	
	By minutos = By.cssSelector("#edit_barter_rule_exception_164 > div > div:nth-child(1) > div > div > div > div.time > div.ti_tx > input");

	By timend = By.id("resolution_end_time_164");

	By resolved = By.cssSelector("#resolve_rule_exception_164");
	
    
	By status = By.xpath("//table[@class='table table-striped table-hover']//tr[1]//td[7]");

	// Delete a rule

	By delete = By.cssSelector("#delete_rule_529");

	public ExceptionResolutionPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void ExceptionResolution( int num, int idhora, String min) throws Exception {

		
		//int id1= 554;
		String comilla2= "'";
		String parentesis= ")";
		String corchete= "]";
		String xpathId= "//table[@class='table table-striped table-hover']//td[contains(text(),'";
		
		String idtime= "resolution_start_time_";
		String idtimeend= "resolution_end_time_";
		String resolvedExcption= "resolve_rule_exception_";
		String minut= "#edit_barter_rule_exception_";
		String minut2=" > div > div:nth-child(1) > div > div > div > div.time > div.ti_tx > input";
		
		
		System.out.println(driver.findElement(By.xpath(xpathId + num + comilla2 + parentesis + corchete)).getText());
		
		System.out.println(driver.findElement(By.id(idtime + idhora)).getText());
		
		System.out.println(driver.findElement(By.id(idtimeend + idhora)).getText());
		
		System.out.println(driver.findElement(By.id(resolvedExcption + idhora)).getText());
		
			
		if (driver.findElement(By.xpath(xpathId + num + comilla2 + parentesis + corchete)).isDisplayed()) {
			
			driver.findElement(By.id(idtime + idhora)).click();
			
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			driver.findElement(By.cssSelector(minut+idhora+minut2)).click();
			
			driver.findElement(By.cssSelector(minut+idhora+minut2)).clear();
			
			driver.findElement(By.cssSelector(minut+idhora+minut2)).sendKeys(min);

			driver.findElement(By.id(idtimeend + idhora)).click();
            
			Thread.sleep(2000);
            WebElement move= driver.findElement(By.id(resolvedExcption + idhora));
            moveToElement(move);
            
            Thread.sleep(8000);
           
            driver.findElement(By.id(resolvedExcption + idhora)).click();
		}
		
	}

	public void deleteRule() throws Exception {
		if (FindElement(delete).isDisplayed()) {
			FindElement(delete).click();
			Thread.sleep(3000);

		}
	}

}

package ClassPage;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Class.ClassBase;

public class FilterRulePage extends ClassBase {

	/// Filter rule
	By filtrar = By.cssSelector("#start_date_filter");
	By startime = By.xpath("//input[@id='start_time_filter']");
	By writetime = By.xpath("//div[3]//div[1]//div[1]//div[1]//div[2]//div[2]//input[1]");
	By endtime = By.xpath("//input[@id='end_time_filter']");
	By writeend = By.xpath("//div[4]//div[1]//div[1]//div[1]//div[2]//div[2]//input[1]");

	By endfilter = By.cssSelector("#end_date_filter");
	By enddate = By.xpath("//td[@class='day'][contains(text(),'31')]");

	By search = By.cssSelector("#submit_filter");

	public FilterRulePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void FilterRule(String fecha, String fec) throws Exception {
		if (FindElement(filtrar).isDisplayed()) {
			FindElement(filtrar).click();
			FindElement(filtrar).clear();
			FindElement(filtrar).sendKeys(fecha);

			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(FindElement(endfilter)));
			wait.until(ExpectedConditions.elementToBeClickable(FindElement(endfilter)));

			FindElement(endfilter).clear();
			FindElement(endfilter).sendKeys(fec);

			/*
			 * JavascriptExecutor js = (JavascriptExecutor)driver; WebElement elem =
			 * FindElement(search);
			 * ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+elem.
			 * getLocation().y+")");
			 */

			FindElement(search).click();

		}

	}

}

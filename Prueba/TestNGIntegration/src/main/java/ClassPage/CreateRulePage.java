package ClassPage;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import Class.ClassBase;

public class CreateRulePage extends ClassBase {

	// Create a rule

	By Stardate = By.id("start_date_rule");
	By date = By.xpath("//td[@class='active day']");

	By Startime = By.id("start_time_rule");
	By writetime = By.xpath(
			"//div[@class='form-group']//div[@class='form-group']//div[@class='time']//input[@class='timepicki-input']");

	By endtime = By.xpath(" //input[@id='end_time_rule']");
	By writeendtime = By.xpath(
			" /html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/input[1]");
	By writemin = By.xpath(
			"/html[1]/body[1]/div[2]/div[1]/div[2]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[2]/input[1]");

	By rounds = By.id("number_of_rounds");
	By discount = By.id("discount_percentage");
	By createrule = By.id("submit_rule");

	By messageconfir = By.xpath("//p[contains(text(),'The Barter rule has been created, a job has been e')]");

	///// lagout

	By logout = By.xpath("//a[contains(text(),'Logout')]");

	/// Seleccionar un course

	public CreateRulePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void CreateRule(String dateini, String timeini, String timend, String minutos, String roudsselect,
			String disc) throws Exception {
		// FindElement(course).click();

		if (FindElement(Stardate).isDisplayed()) {
			FindElement(Stardate).click();
			FindElement(Stardate).clear();
			FindElement(Stardate).sendKeys(dateini);

			FindElement(Startime).click();
			FindElement(writetime).clear();
			FindElement(writetime).sendKeys(timeini);

			FindElement(endtime).click();
			FindElement(writeendtime).clear();
			FindElement(writeendtime).sendKeys(timend);
			FindElement(writemin).click();
			FindElement(writemin).clear();
			FindElement(writemin).sendKeys(minutos);

			SelectElement(rounds, roudsselect);
			FindElement(discount).sendKeys(disc);

			FindElement(createrule).click();

			Thread.sleep(3000);
			// System.out.println(driver.switchTo().alert().getText());
			// driver.switchTo().alert().accept();

			Assert.assertEquals("The Barter rule has been created,"
					+ " a job has been enqueued to create barter tee times." + " We'll notify when we are ready.",
					FindElement(messageconfir).getText());
			Logout();
		}

	}

	public void Logout() {
		if (FindElement(logout).isDisplayed()) {
			FindElement(logout).click();
		}
		//actions class en selenium
	//	Actions act=new Actions(driver);
	//	act.moveToElement(FindElement(writemin)).build().perform();
		
		//act.moveToElement(FindElement(writemin)).click().keyDown(Keys.SHIFT).sendKeys("algo").doubleClick().build().perform();;
		
		// para cambira de ventana 
		/*Set<String> algo =driver.getWindowHandles();
		Iterator<String> al=algo.iterator();
		String parent=al.next();
		String children=al.next();
		driver.switchTo().window(children);*/
	}
    

}

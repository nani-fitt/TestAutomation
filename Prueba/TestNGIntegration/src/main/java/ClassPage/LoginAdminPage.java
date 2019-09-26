package ClassPage;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Class.ClassBase;

public class LoginAdminPage extends ClassBase {

	public LoginAdminPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private String URL = "https://staging.supremegolf.com/admin/login";

	// Login to Admin page

	By email = By.id("admin_user_email");
	By pass = By.id("admin_user_password");
	By login = By.name("commit");
	By confir = By.xpath("//h1[contains(text(),'Bookings over the last 30 days')]");

	// Select a course
	By course = By.xpath("//a[contains(text(),'Providers & Courses')]");
	By coursehijo = By.xpath("//a[contains(text(),'Barter Courses')]");
	By selectcourse = By.xpath("//a[contains(text(),'Supreme Golf Demo Course')]");

	// filter Barter tee times
	By teetimes = By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Tee Times')]");
	By barter = By.xpath("//a[contains(text(),'Barter Tee Times')]");

	public void AdminLogin(String user, String password) throws Exception {
		if (FindElement(email).isDisplayed()) {
			FindElement(email).sendKeys(user);
			FindElement(pass).sendKeys(password);
			FindElement(login).click();
		}

		assertEquals("Bookings over the last 30 days", FindElement(confir).getText());

		SelectCourse();
		if (FindElement(selectcourse).isDisplayed()) {
			FindElement(selectcourse).click();
			Thread.sleep(6000);
		}

	}

	public void SelectCourse() throws Exception {
		FindElement(course).click();
		Thread.sleep(3000);
		FindElement(coursehijo).click();
		// FindElement(Stardate).sendKeys(Keys.ENTER); dar enter en en un campo.
		// FindElement(Enddate).sendKeys(Keys.ARROW_DOWN); para escoger el elemento en
		// una lista de abajo
		// FindElement(Stardate).sendKeys(keys.);
	}

	public void SelectBarterTeeTimes() throws Exception {
		FindElement(teetimes).click();
		Thread.sleep(3000);
		FindElement(barter).click();

	}

	public void BarterSearch(String user, String password) throws Exception {
		
		if (FindElement(email).isDisplayed()) {
			FindElement(email).sendKeys(user);
			FindElement(pass).sendKeys(password);
			FindElement(login).click();
		}

		assertEquals("Bookings over the last 30 days", FindElement(confir).getText());

		SelectBarterTeeTimes();
	}

	public void GetUrl() {
		driver.get(URL);
		System.out.println(driver.getCurrentUrl());
	}

}

package ClassPage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Class.ClassBase;

public class CancelBooking extends ClassBase {

	By signin = By.xpath("//a[@class='l-subheader__text sign-in']");
	By user1 = By.id("user_email");
	By passw = By.id("user_password");
	By submit = By.xpath("//button[contains(text(),'Sign In')]");
	By search = By.cssSelector("#q_home");
	By click = By.xpath("//button[@class='m-home-search__btn btn btn-orange btn-round icon-search oval-btn']");

	By irprofile = By.xpath(
			"//span[contains(@class,'m-dropdown-select arrow-down sgDropdown-select l-subheader__text inline-block profile-dropdown')]");
	By reservations = By.xpath("//ul[@class='m-dropdown-list uppercase']//a[@id='reservations-link']");
	By viewdetails = By.xpath(
			"//tr[@class='res_detail_100192']//a[@class='link orange view-reservation-details'][contains(text(),'VIEW DETAILS')]");
	By cancelteetime = By.xpath("//h4[@class='btn btn-orange btn-cancel cancel-reservation']");
	By confiryes = By.xpath("//span[@class='btn btn-confirm confirm-cancel-tee-time-yes']");
	
	String url = "https://staging.supremegolf.com";

	public CancelBooking(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void signIn(String user, String pass, String course) throws Exception {

		if (FindElement(signin).isDisplayed()) {
			FindElement(signin).click();
			Thread.sleep(3000);
			FindElement(user1).sendKeys(user);
			FindElement(passw).sendKeys(pass);
			FindElement(submit).click();

			Thread.sleep(3000);

			if (FindElement(search).isDisplayed()) {

				FindElement(search).click();
				FindElement(search).sendKeys(course);

				WebDriverWait wait = new WebDriverWait(driver, 60);
				wait.until(ExpectedConditions.visibilityOfElementLocated(click)).click();

			}
		}

	}

	public void SelectOptionsReservations(int num) throws Exception {
		

		String cancelbooking = "//h4[@class='btn btn-orange btn-cancel cancel-reservation']";
		String yes = "//span[@class='btn btn-confirm confirm-cancel-tee-time-yes']";
		
		String verdetalis= "//tr[@class='res_detail_";
		String verdetalis1=  "']//a[@class='link orange view-reservation-details'][contains(text(),'VIEW DETAILS')]";
		
		
		FindElement(irprofile).click();
		Thread.sleep(3000);
		FindElement(reservations).click();
		
        
		Thread.sleep(3000);
		ScrollFinalpage(By.xpath(verdetalis + num +verdetalis1));
		FindElement(By.xpath(verdetalis + num +verdetalis1)).click();

		Thread.sleep(2000);

		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(presenceOfElementLocated(By.xpath(cancelbooking)));

		driver.findElement(By.xpath(cancelbooking)).click();

		Thread.sleep(2000);

		WebDriverWait wait3 = new WebDriverWait(driver, 10);
		wait3.until(presenceOfElementLocated(By.xpath(yes)));

		driver.findElement(By.xpath(yes)).click();

		Thread.sleep(2000);

	}
	
	public void Conectar() {
		driver.get(url);
	}



}

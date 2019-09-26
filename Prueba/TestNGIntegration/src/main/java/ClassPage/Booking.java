package ClassPage;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.apache.http.auth.AuthSchemeRegistry;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Class.ClassBase;

public class Booking extends ClassBase {

	// sign In y search a course

	By signin = By.xpath("//a[@class='l-subheader__text sign-in']");
	By user1 = By.id("user_email");
	By passw = By.id("user_password");
	By submit = By.xpath("//button[contains(text(),'Sign In')]");
	By search = By.cssSelector("#q_home");
	By click = By.xpath("//button[@class='m-home-search__btn btn btn-orange btn-round icon-search oval-btn']");

	// -------------------------------------------------Booking------------------------------------

	By players = By.xpath("//select[@id='qty']");

	By book1 = By.xpath(
			"//a[@class='btn btn-orange btn-medium btn-block oswald uppercase js-prepare-tee-time book-it book-it-btn']");

	By checkbox = By.xpath("//input[@name='tc-agreement']");

	By completeBook = By.xpath("//a[@id='book-now-prepare']");

	By nextday = By.xpath(
			"//span[@class='left wrapper on_date l-course__date-nav-span js-date-nav hidden-sm hidden-xs']//span[@class='arrow-right']");

	By closemesage = By.xpath("/html/body/div[13]/div[2]/div/div/div/span/div/div[7]/div/div/div[2]");

	By playersBook = By.xpath("//select[@id='qty']");

	// -------------------------select
	// date---------------------------------------------------------------------

	String url = "https://staging.supremegolf.com";

	/////////////////////// --------------------------------------------------------------------------------------------------------------------

	By book2 = By.xpath("//*[@id=\"tee_time_705301677\"]/td[9]/a/span");

	//// --------------lista de tee
	//// timesss-------------------------------------------

	By bookingventana = By
			.xpath("//a[@class='btn btn-orange btn-xlarge btn-block btn-book-new uppercase js-bookit-button']");

	By coursesupreme = By.xpath("//h2[@class='m-bookit--course-name prepare']");

	public Booking(WebDriver driver) {
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

	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void MadeBooking(String play, int num) throws Exception {

		String book01 = "//tr[@id='tee_time_";
		String book2 = "']//span[@class='words'][contains(text(),'Book It')]";
		
		FindElement(nextday).click();
		Thread.sleep(3000);
		
		FindElement(nextday).click();
        
		Thread.sleep(5000);

		ScrollFinalpage(By.xpath(book01 + num + book2));
		driver.findElement(By.xpath(book01 + num + book2)).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		SelectElement(players, play);

		 Thread.sleep(5000);

		// if (FindElement(closemesage).isDisplayed()) {
		// FindElement(closemesage).click();

		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait1.until(ExpectedConditions.elementToBeClickable(FindElement(book1)));
		FindElement(book1).click();

		Thread.sleep(3000);

		// }

	}

	public void CompletyBooking() throws Exception {

		String select1 = "//input[@name='tc-agreement']";
		String completebooking = "//a[@id='book-now-prepare']";
		String bookcourseagain = "//button[@name='button']";

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(presenceOfElementLocated(By.xpath(select1)));

		driver.findElement(By.xpath(select1)).isSelected();
		driver.findElement(By.xpath(select1)).click();
		Thread.sleep(1000);

		WebDriverWait wait1 = new WebDriverWait(driver, 15);
		wait.until(presenceOfElementLocated(By.xpath(completebooking)));

		driver.findElement(By.xpath(completebooking)).click();

		Thread.sleep(2000);

		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait2.until(presenceOfElementLocated(By.xpath(bookcourseagain)));
		
		driver.findElement(By.xpath(bookcourseagain)).click();

		Thread.sleep(3000);
	}

	//////////////////////////// ---------------------------------------/////////////////////////////////

	public void Conectar() {
		driver.get(url);
	}
}

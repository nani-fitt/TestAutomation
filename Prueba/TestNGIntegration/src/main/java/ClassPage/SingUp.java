package ClassPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import Class.ClassBase;

public class SingUp extends ClassBase{
	
	By signup= By.xpath("//a[@class='l-subheader__text divider']");
	By firtname= By.id("user_first_name");
	By lastname=By.id("user_last_name");
	By email=By.xpath("//div[@id='part_1']//input[@id='user_email']");
	By zopcode=By.id("user_address_zipcode");
	By contin=By.xpath("//button[contains(text(),'Continue')]");
	By password=By.xpath("//input[@id='sign_up_form_password']");
	By entrar=By.xpath("//button[contains(text(),'Sign up now')]");
	
	
	String url= "https://staging.supremegolf.com/";
	
	WebElement element;

	public SingUp(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void SignUp(String name, String lastna,String emai, String codigo, String pass) throws Exception
	{
		if(FindElement(signup).isDisplayed())
		{
			FindElement(signup).click();
			FindElement(firtname).clear();
			FindElement(firtname).sendKeys(name);
			FindElement(lastname).clear();
			FindElement(lastname).sendKeys(lastna);
			FindElement(email).click();
			FindElement(email).sendKeys(emai);
			Thread.sleep(1000);
		 
		//new WebDriverWait(driver, 20).until(EC.elementToBeClickable((By.xpath("//div[@id='part_1']//input[@id='user_email']")))).click();
			FindElement(zopcode).sendKeys(codigo);
			FindElement(contin).click();
			FindElement(password).sendKeys(pass);
			FindElement(entrar).click();
			
		}
	}
	
	
	public void Conectar()
	{
		
		driver.get(url);
	}
	
	

}

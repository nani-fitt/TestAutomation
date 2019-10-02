package ClassPage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ver {
	
	WebDriver driver;
	boolean isFoundTheElement = false;
	
	By listateetimes= By.xpath("//table[@class='m-teetimes m-table__teetimes js-teetime-table tt-table tablesorter tablesorter-default highlighted']");


	By descuento= By.xpath("//tr[@id='tee_time_705300209']//td[@class='row savings hidden-xs'][contains(text(),'0%')]");
	By players= By.xpath("//tr[@id='tee_time_705300209']//td[@class='row players'][contains(text(),'1-4')]");
	By type=By.xpath("//tr[@id='tee_time_705300209']//td[@class='row transport'][contains(text(),'WALK')]");
	
	By book=By.xpath("//tr[@id='tee_time_705300209']//td[@class='action']");
	

	String hora0= "//tr[@id='tee_time_705300209']//td[contains(@class,'row time')][contains(text(),'";
	String hora1= " PM')]";
	
	
	String precio1= "//tr[@id='tee_time_705300209']//td[@class='row rate'][contains(text(),'";
	String precio2= "')]";
	
	
	String holes1= "//tr[@id='tee_time_705300209']//td[@class='row holes'][contains(text(),'";
	String holes2= "')]";
	
	public void ScrollFinalpage(By locator) {
		WebElement element = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		
	}
}
			
			
		


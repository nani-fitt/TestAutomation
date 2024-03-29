package ClassBase;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.google.common.base.Function;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;

public class Scrolling {

	AndroidDriver<WebElement> driver;

	 
   public Scrolling (AndroidDriver<WebElement> driver)
   {
	   this.driver=driver;
   }
	
	public MobileElement scrollElementByContentText(String scrollableList, String uiSelector, String textToSearchInList) {
    
		
		MobileElement element= (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
	                "new UiScrollable(new UiSelector().resourceId(\"" + scrollableList + "\")).getChildByText("
	                        + "new UiSelector().className(\"" + uiSelector + "\"), \"" + textToSearchInList + "\" )"));	
		
		System.out.println(element.getText());
		
		return element;
		
	}

	public MobileElement scrollElementByContentDesc(String scrollableList, String uiSelector, String textToSearchInList) {
	       
		 MobileElement element= (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator(
               "new UiScrollable(new UiSelector().resourceId(\"" + scrollableList + "\")).getChildByDescription("
                       + "new UiSelector().className(\"" + uiSelector + "\"), \"" + textToSearchInList + "\" )"));
		 
		 System.out.println(element.getText());
		return element;
	}
	
	public MobileElement scrollElementByScrollView(String scrollableList, String textToSearchInList) {
		
	
	MobileElement element = (MobileElement)driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector().resourceId(\"" + scrollableList + "\")).scrollIntoView("
					+ "new UiSelector().text(\""+ textToSearchInList + "\")"));

      return element;
	}
	
	//scrollableList is id of your scrollable List element
	
}
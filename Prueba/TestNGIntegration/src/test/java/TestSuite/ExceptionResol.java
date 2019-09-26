package TestSuite;

import org.testng.annotations.Test;

import Class.TestBase;
import ClassPage.ExceptionResolutionPage;
import ClassPage.LoginAdminPage;
import DataProvider.DataProviderClass;

public class ExceptionResol extends TestBase {

	@Test(dataProvider = "getException", dataProviderClass = DataProviderClass.class)
	public void ExceptionResolution(int num, int num2, String min) throws Exception {

		LoginAdminPage page2 = new LoginAdminPage(driver);
		page2.GetUrl();
		page2.AdminLogin("eguerrero@codigodelsur.com", "Cdelsur1");

		ExceptionResolutionPage page = new ExceptionResolutionPage(driver);
		page.ExceptionResolution(num, num2, min);
		// page.deleteRule();

	}
}

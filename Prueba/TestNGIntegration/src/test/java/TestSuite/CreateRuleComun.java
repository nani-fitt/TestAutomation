package TestSuite;

import org.testng.annotations.Test;

import Class.TestBase;

import ClassPage.CreateRulePage;
import ClassPage.LoginAdminPage;
import DataProvider.DataProviderClass;
//import DataProvider.DataProviderClass;

public class CreateRuleComun extends TestBase {

	CreateRulePage page1;
	LoginAdminPage page2;

	@Test(dataProvider = "getRule", dataProviderClass = DataProviderClass.class)
	public void CreateRuleTest(String fechaini, String date, String enddate, String minutos, String rounds,
			String discount) throws Exception {

		page2 = new LoginAdminPage(driver);
		page2.GetUrl();
		page2.AdminLogin("eguerrero@codigodelsur.com", "Cdelsur1");

		page1 = new CreateRulePage(driver);
		page1.CreateRule(fechaini, date, enddate, minutos, rounds, discount);
		// page1.Logout();
	}
}

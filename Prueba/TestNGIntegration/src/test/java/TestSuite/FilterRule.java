package TestSuite;

import org.testng.annotations.Test;

import Class.TestBase;
import ClassPage.FilterRulePage;
import ClassPage.LoginAdminPage;
import DataProvider.DataProviderClass;

public class FilterRule extends TestBase {

	@Test(dataProvider = "getFilter", dataProviderClass = DataProviderClass.class)
	public void FilterRule(String fecha, String fend) throws Exception {

		LoginAdminPage page2 = new LoginAdminPage(driver);
		page2.GetUrl();
		page2.AdminLogin("eguerrero@codigodelsur.com", "Cdelsur1");

		FilterRulePage page = new FilterRulePage(driver);
		page.FilterRule(fecha, fend);
	}
}

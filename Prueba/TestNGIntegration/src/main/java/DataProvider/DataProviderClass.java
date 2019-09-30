package DataProvider;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider(name = "getRule")
	public static Object[][] dataProviderMethodRule() {
		return new Object[][] { { "10/04/2019", "06", "10", "00", "12", "10" }
			//	{ "09/29/2019", "06", "12", "20", "12", "10" }, 
			//	{ "09/30/2019", "6", "20", "10", "12", "10" },
			//	{ "10/01/2019", "6", "06", "10", "12", "10" }

		};

	}
	
	@DataProvider(name = "getException")
	public static Object[][] dataProviderMethodException() {
		return new Object[][] { { 552, 168,"9" } 
			//	{ 555, 166,"9"}

		};

	}

	@DataProvider(name = "getFilter")
	public static Object[][] dataProviderMethodFilter() {
		return new Object[][] { { "09/06/2019", "09/06/2019" } };

	}

}

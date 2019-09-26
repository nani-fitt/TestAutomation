package TestSuite;

import org.testng.annotations.Test;

import Class.TestBase;
import ClassPage.CancelBooking;

public class Cancelbooking extends TestBase{
 
	
	
	@Test
  public void cancelbooking() throws Exception {
		
		CancelBooking page= new CancelBooking(driver);
		page.Conectar();
		page.signIn("eguerrero@codigodelsur.com", "123456789", "SUPREME GOLF DEMO COURSE");
		page.SelectOptionsReservations(100691);
	
		
  }
}

package TestSuite;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import Class.TestBase;

@Listeners(listener.ListenerTest.class)

public class BookingTest extends TestBase{
	
	
	 
  @Test
  public void Booking() throws Exception {
	  
	  
	  ClassPage.Booking page=new ClassPage.Booking(driver);
	  page.Conectar();
	  page.signIn("eguerrero@codigodelsur.com", "123456789", "SUPREME GOLF DEMO COURSE");
	  page.MadeBooking("4",705864722);
	  page.CompletyBooking();
	  
  }
}

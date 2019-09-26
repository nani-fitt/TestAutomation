package TestSuite;

import org.testng.annotations.Test;

import Class.TestBase;
import ClassPage.SingUp;

public class SignUPSupremGolf extends TestBase{
	
	
  @Test
  public void f() throws Exception {
	  SingUp page= new SingUp(driver);
	  page.Conectar();
	  page.SignUp("eddy", "garcia", "eddy@mailinator.com", "11000", "123456");
	  
  }
}

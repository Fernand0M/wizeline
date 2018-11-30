package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;

public class Login extends SeleniumTest {
	
	
	@DataProvider(name="login")
	    public static Object[][] getClient1Data() {
	        return new Object[][]{
	        	{"testuser@example.com","test123"},
	        	{"invalid","password"},
	        };    
	    }

	@Test (dataProvider="login")
	public void positive(String username,String password) {
		LoginPage lgnpage = new LoginPage(driver);
		
		System.out.println("Login");
		lgnpage.login(username,password);
	}

}

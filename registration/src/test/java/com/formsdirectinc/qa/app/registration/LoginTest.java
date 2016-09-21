package com.formsdirectinc.qa.app.registration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.formsdirectinc.qa.TestBase;
import com.formsdirectinc.qa.enums.Sites;
import com.formsdirectinc.qa.pages.Login;
import com.formsdirectinc.qa.utils.CheckPageErrors;

/**
 * Login: Selenium Page Object for Login(Existing User)
 *
 * @author:Orina Revision: $Rev$
 */
public class LoginTest extends TestBase {

	
	@Test
	@Parameters({ "sitename","siteurl", "username", "password" })
	public void logintest(String sitename,String siteurl, String username, String password) throws Exception {

		if(driver==null)
	 	{
	 		createStep(driver, this.getClass().getName());
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String loginURL = "%s/login.jsp?next=applicationcenter.do&lang=en";

		Sites site;
		if(System.getProperty("site.name")==null)
		{
			site = Sites.valueOf(sitename);
		}else
		{
			site = Sites.valueOf(System.getProperty("site.name"));
		}
		
		if (siteURL() == null) {
			driver.get(String.format(loginURL, siteurl));
		} else {
			driver.get(String.format(loginURL, siteURL()));
		}

		
		Login existingUser = new Login(driver);
		existingUser.setUserID(username);
		existingUser.setUserPassword(password);
		existingUser.logIntoApplication(username,site);

		CheckPageErrors pageValidation = new CheckPageErrors(driver);
		pageValidation.checkWhetherLoginPageHasError(site);

	}

	@Override
	public void eqtest(String sitename, String siteurl, String product,
			String flowname) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrationtest(String sitename, String siteurl,
			String product, String emailID, String password, String flowname)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paymenttest(String sitename, String siteurl, String product,
			String emailID, String password) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sqtest(String sitename, String siteurl, String product,
			String username, String password, String flowname,
			String applicationID) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public LoginTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginTest(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
}

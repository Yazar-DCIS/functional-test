package com.formsdirectinc.qa.app.registration;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.formsdirectinc.qa.TestBase;
import com.formsdirectinc.qa.enums.Products;
import com.formsdirectinc.qa.enums.Sites;
import com.formsdirectinc.qa.utils.CaptureScreen;
import com.formsdirectinc.qa.utils.CheckPageErrors;
import com.formsdirectinc.qa.utils.EmailIDGenerator;
import com.formsdirectinc.qa.utils.PropertyResource;

/**
 * Selenium Page Model for RegistrationPage CoreSites
 * 
 * @author:Orina
 * @Date: 6/29/15
 * @Updated:24.02.2016
 */

public class RegistrationTest extends TestBase {

	@Test
	@Parameters({ "sitename","siteurl", "product", "username", "password","flowname" })
	public void registrationtest(String sitename,String siteurl, String product, String username,
			String password,String flowname) throws Exception {

		if(driver==null)
	 	{
	 		createStep(driver, this.getClass().getName());
		}
		
		Sites site;
		if(System.getProperty("site.name")==null)
		{
			site = Sites.valueOf(sitename);
		}else
		{
			site = Sites.valueOf(System.getProperty("site.name"));
		}
		PropertyResource propertyFile = new PropertyResource();
		Properties data = propertyFile.loadProperty("registration");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		CaptureScreen myscreen = new CaptureScreen(getDriver());

		String myproduct="%s";
		String testProduct = null;

		if (System.getProperty("product") == null) {
			
			testProduct =Products.valueOf(String.format(myproduct,product).
												toUpperCase()).getProductName();
			
		} else {
			
			testProduct =Products.valueOf( String.format(myproduct,System.getProperty("product")).
															toUpperCase()).getProductName();
			
		}

		if(!driver.getCurrentUrl().contains("createaccounts.do"))
		{
			String registrationURL = "%s/" + data.getProperty("registerUrl")+ testProduct;
	
			if (siteURL() == null) {
				driver.get(String.format(registrationURL, siteurl));
			} else {
				driver.get(String.format(registrationURL, siteURL()));
			}
		}
	/*	myscreen.takeScreenShot(product, "RegistrationPage");

		EmailIDGenerator writeEmail = PageFactory.initElements(getDriver(),
				EmailIDGenerator.class);

		Registration createUser = new Registration(getDriver(),
				"customerSignup");
		createUser.setFirstName(data.getProperty("FirstName"));
		createUser.setLastName(data.getProperty("LastName"));

		if (username.isEmpty()) {
			
			 * If email-id not passed in registration.xml, random email-id will
			 * get generated
			 
			createUser.setEMail(writeEmail.generateEmailID(site.name(),flowname,product));
		} else {
			
			 * If email-id is passed in registration.xml, same email-id will be
			 * used for registration
			 
			createUser.setEMail(username);
		}
		// createUser.setEMail("orina.moorthy@dcis.net");
		createUser.setPassword(password);
		createUser.setPhoneAreaCode(data.getProperty("PhoneAreaCode"));
		createUser.setPhoneNumber1(data.getProperty("PhoneNumber1"));
		createUser.setPhoneNumber2(data.getProperty("PhoneNumber2"));

		myscreen.takeScreenShot(product, "RegistrationPage");

		createUser.createAccount();

		
		 * To check if there are page or element errors if error occurs
		 * (Assert.fail) Test will fail throwing what caused error else next
		 * tests will be done.
		 
		CheckPageErrors checkPage = new CheckPageErrors(driver);
		checkPage.checkWhetherPageHasError();*/

	}

	
	public RegistrationTest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RegistrationTest(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void eqtest(String sitename, String siteurl, String product,
			String flowname) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
	
	@Override
	public void sqtest(String sitename, String siteurl, String product,
			String username, String password, String flowname,
			String applicationID) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void logintest(String sitename, String siteurl, String username,
			String password) throws Exception {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void paymenttest(String sitename, String siteurl, String product,
			String emailID, String password) throws Exception {
		// TODO Auto-generated method stub
		
	}

}

package com.formsdirectinc.functionaltests.apps.login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.SignIn;

/**
 * Login: Selenium Page Object for Login(Existing User)
 *
 * @author:Orina Revision: $Rev$
 */
public class Login extends Step{

	
	public Login(WebDriver driver) {

		super(driver);
	}

	public void test(String product, String flowname) {

		Sites site = Sites.valueOf(System.getProperty("site.name"));
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get(site.getBaseURL());
		
		String username=System.getProperty("username");
		String password=System.getProperty("password");
		
		SignIn existingUser=new SignIn(driver);
		existingUser.selectSignIn();
		existingUser.setUserID(username);
		existingUser.setUserPassword(password);
		existingUser.logIntoApplication(username);	
		
		
	}

}

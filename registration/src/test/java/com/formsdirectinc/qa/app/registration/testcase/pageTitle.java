package com.formsdirectinc.qa.app.registration.testcase;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

/*import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;*/


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.formsdirectinc.qa.enums.Products;
import com.formsdirectinc.qa.enums.Sites;
import com.formsdirectinc.qa.utils.PropertyResource;
import com.formsdirectinc.qa.pages.WizardPage;

public class pageTitle extends WizardPage {

	@Test
	
	
	public void registrationScripTtest(String sitename, String product, String username,String password,String flowname) throws Exception {
	
		PropertyResource propertyFile = new PropertyResource();
		Properties data = propertyFile.loadProperty("registration");
		
	
			site = Sites.valueOf(sitename);
		
		
		String myproduct="%s";
		//String productinfo =Products.valueOf( String.format(myproduct,System.getProperty("product")).toUpperCase()).getProductName();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String ttl;
		String title = driver.getTitle();
		ttl = data.getProperty(site + "_title");
		if (!(ttl.equals(title))) {
			System.out.println("Page title Copy Check in "
					+ driver.getCurrentUrl());
			System.out.println("Page title mismatched \nFrom:\n\n " + ttl
					+ "\n\nTo:\n\n " + title);

		}

	
	}
	
	
	public pageTitle(WebDriver driver) {
		super(driver);
	}

	
	
	

		
		

	}



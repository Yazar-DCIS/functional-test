package com.formsdirectinc.qa.app.registration.testcase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/*import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;*/

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.formsdirectinc.qa.enums.Products;
import com.formsdirectinc.qa.enums.Sites;
import com.formsdirectinc.qa.utils.PropertyResource;
import com.formsdirectinc.qa.pages.WizardPage;

public class scriptsCheck extends WizardPage {

	@Test
	@Parameters({ "sitename","siteurl", "product", "username", "password","flowname" })
	
	public void registrationScripTtest(String sitename,String siteurl, String product, String username,String password,String flowname) throws Exception {
	
		PropertyResource propertyFile = new PropertyResource();
		Properties data = propertyFile.loadProperty("registration");
		
		Sites site;
		if(System.getProperty("site.name")==null)
		{
			site = Sites.valueOf(sitename);
		}else
		{
			site = Sites.valueOf(System.getProperty("site.name"));
		}
		
		String myproduct="%s";
		String productinfo = null;

		if (System.getProperty("product") == null) {
			
			productinfo =Products.valueOf(String.format(myproduct,product).
												toUpperCase()).getProductName();
			
		} else {
			
			productinfo =Products.valueOf( String.format(myproduct,System.getProperty("product")).
															toUpperCase()).getProductName();
			
		}
		
		
		if(!driver.getCurrentUrl().contains("createaccounts.do"))
		{
			String registrationURL = "%s/" + data.getProperty("registerUrl")+ productinfo;
	


				driver.get(String.format(registrationURL, siteurl));


				
		}
	
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		String[] prod_scripts = data.getProperty("" + site + "_scripts").split(
				":");
		for (int i = 0; i <= prod_scripts.length - 1; i++) {
			int size = driver.getPageSource().split("" + prod_scripts[i] + "").length - 1;
			if (size >= 2) {
				System.out.println(site + productinfo);
				String currentURL = driver.getCurrentUrl();
				System.out.println(currentURL);
				System.out.println("Problem in " + prod_scripts[i]
						+ "script -might be repeated");
				System.out.println("\n");
			}
			if (size == 0) {
				System.out.println(site + productinfo);
				String currentURL = driver.getCurrentUrl();
				System.out.println(currentURL);
				System.out.println("Problem in " + prod_scripts[i]
						+ "script -might be left out");
				System.out.println("\n");
			}

		}

	
	}
	
	
	public scriptsCheck(WebDriver driver) {
		super(driver);
	}

	
	
	

		
		

	}



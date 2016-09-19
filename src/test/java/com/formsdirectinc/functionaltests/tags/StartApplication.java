package com.formsdirectinc.functionaltests.tags;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;

/**
 * Skip_Quiz: Selenium Page Object for Skip Quiz
 
 * @author Orina  Date: 6/22/15 11:22
 * AM
 
 * Revision: $Rev$
 */
public class StartApplication {

	private WebDriver driver;

	public StartApplication(WebDriver driver) {

		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public StartApplication startApplication(String tag,String text) throws Exception {

		SelectElement startApp = new SelectElement(driver,
				"//"+tag+"[contains(text(),'"+text+"')]");
		startApp.selectElementUsingXPath();
		
		return PageFactory.initElements(driver, StartApplication.class);
	}
	
	public StartApplication startApplication(String product) throws Exception {

		Sites site = Sites.valueOf(System.getProperty("site.name"));

		SelectElement startApplication;

		if (site != Sites.FR) {
			if (product == Products.I130.name()
					|| product == Products.I130I485.name()
					|| product == Products.I765.name()
					|| product == Products.I824.name()
					|| product == Products.I102.name()
					|| product == Products.I134.name()
					|| product == Products.I821.name()) {
				if (site == Sites.DUS) {
					startApplication = new SelectElement(driver, "Start");
					startApplication.selectElementUsingPartialLinkText();
				} else if (site == Sites.USC) {
					if (product == Products.I130.name()
							|| product == Products.I130I485.name()) {
						startApplication = new SelectElement(driver,
								"I am a US Citizen");
					}

					else {
						startApplication = new SelectElement(driver, "Start");
					}
					startApplication.selectElementUsingPartialLinkText();
				} else {
					startApplication = new SelectElement(driver, "START");
					startApplication.selectElementUsingPartialLinkText();
				}

			}

			else if (product == Products.I821D.name()) {
				if (site == Sites.AIC) {
					startApplication = new SelectElement(driver, "APPLY NOW!");
				} else if (site == Sites.DUS) {
					startApplication = new SelectElement(driver, "Start");
				} else if (site == Sites.USC) {
					startApplication = new SelectElement(driver, "Apply Now!");
				} else {
					startApplication = new SelectElement(driver, "START");
				}
				startApplication.selectElementUsingPartialLinkText();
			}

			else {
				if (site == Sites.DUS || site == Sites.USC) {

					startApplication = new SelectElement(driver, "Start");
				} else {
					startApplication = new SelectElement(driver, "START");
				}
				startApplication.selectElementUsingPartialLinkText();
			}
		}
		
		if(site==Sites.FR)
		{
			startApplication = new SelectElement(driver, "START");
			startApplication.selectElementUsingPartialLinkText();
		}
		
		return PageFactory.initElements(driver, StartApplication.class);
	}

}

package com.formsdirectinc.functionaltests.tags;

import org.openqa.selenium.By;
/**
 * <--EQ_InEliglible:Script for JVM common to all sites-->
 * @author:Orina <br>
 * Revision: $Rev$
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

public class EQ_InEligible extends WizardPage {

	private By byPage = By.cssSelector("input[name='page']");
	private WebElement pageID;
	
	public EQ_InEligible(WebDriver driver) {
		super(driver);

	}

		
	public EQ_InEligible ineligibleApplication(String product) {

		pageID = driver.findElement(byPage);
		Reporter.log("InEligible Page of :- " + pageID.getAttribute("value")+ " product " +product);
		System.out.println("InEligible Page of :- " + pageID.getAttribute("value")+ " product " +product);
		
		return this;

	}

}

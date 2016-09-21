package com.formsdirectinc.qa.tags.qastyles;

import org.openqa.selenium.By;
/**
 * <--EQ_InEliglible:Script for JVM common to all sites-->
 * @author:Orina <br>
 * Revision: $Rev$
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.formsdirectinc.qa.pages.WizardPage;

public class EQ_InEligible extends WizardPage {

	private By byPage = By.cssSelector("input[name='client']");
	private WebElement pageID;

	public EQ_InEligible(WebDriver driver) {
		super(driver);

	}

	public EQ_InEligible ineligibleApplication(String product, int number) {

		pageID = driver.findElement(byPage);
		Reporter.log("InEligible Page of :- " + pageID.getAttribute("value")
				+ " product " + product);
		System.out.println("InEligible Page of :- "
				+ pageID.getAttribute("value") + " product " + product);

		String reasoncode = driver.getCurrentUrl();

		// to check the in eligible page reason codes.
		Assert.assertEquals(reasoncode.split("\\?")[1],
				"reasonCode=" + String.format("%02d", number),
				"Wrong Reason Code");

		return this;

	}

}

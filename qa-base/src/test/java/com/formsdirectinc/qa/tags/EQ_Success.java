package com.formsdirectinc.qa.tags;

/**
 * <--EQ_Success:Script for JVM common to all sites-->
 * @author:Orina <br>
 * Revision: $Rev$
 */

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.qa.enums.Products;
import com.formsdirectinc.qa.enums.Sites;
import com.formsdirectinc.qa.pages.WizardPage;

public class EQ_Success extends WizardPage {

	public EQ_Success(WebDriver driver) {
		super(driver);

	}

	public EQ_Success startApplication(String product) {

		if (product.equalsIgnoreCase(Products.I751.name())) {
			SelectElement startApplication = new SelectElement(driver,
					"//span[text()='Start the Application Now']");
			startApplication.selectInvisibleElementUsingXpath();
		}

		else if (product.equalsIgnoreCase(Products.N400.name())
				&& site == Sites.AIC) {
			SelectElement startApplication = new SelectElement(driver,
					"Start the Application Now");
			startApplication.selectElementUsingLinkText();

		}

		else if (product.equalsIgnoreCase(Products.I90.name())) {
			SelectElement startApplication = null;
			if (site == Sites.AIC || site == Sites.USC) {
				startApplication = new SelectElement(driver,
						"//span[text()='Start the Application Now']");
			} else {
				startApplication = new SelectElement(driver,
						"//div[text()='Start the Application Now']");
			}

			startApplication.selectElementUsingXPath();

		}

		else {
			SelectElement startApplication = new SelectElement(driver,
					"span[class='button-text']");
			startApplication.selectElementUsingCSS();
		}

		return this;

	}

	public EQ_Success startTheApplication(String tag) {

		SelectElement startApplication = new SelectElement(driver, "//" + tag
				+ "[contains(text(),'Start the Application Now')]");
		startApplication.selectElementUsingXPath();

		return this;

	}
}

package com.formsdirectinc.qa.tags.qastyles;

/**
 * <--EQ_Success:Script for JVM common to all sites-->
 * @author:Orina <br>
 * Revision: $Rev$
 */

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.qa.pages.WizardPage;
import com.formsdirectinc.qa.tags.SelectElement;

public class EQ_Success extends WizardPage {

	public EQ_Success(WebDriver driver) {
		super(driver);

	}

	public EQ_Success startTheApplication(String tag) {

		SelectElement startApplication = new SelectElement(driver, "//" + tag
				+ "[contains(text(),'Start the Application Now')]");
		startApplication.selectElementUsingXPath();

		return this;

	}
}

package com.formsdirectinc.functionaltests.apps.n600.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for EQ_Success Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ_Success extends WizardPage {

	public EQ_Success(WebDriver driver) {
		super(driver);

	}

	public EQ_Success startApplication() {

		SelectElement createaccounts = new SelectElement(driver,
				"a[href='createaccounts.do?quizentry=true']");
		createaccounts.selectElementUsingCSS();

		return this;
	}

}

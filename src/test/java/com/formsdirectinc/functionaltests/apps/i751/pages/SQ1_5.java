package com.formsdirectinc.functionaltests.apps.i751.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_5 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_5 extends WizardPage {

	private YesNo ssnInfo;

	public SQ1_5(WebDriver driver) {
		super(driver);

	}

	public SQ1_5 SSNDetails(Properties data) {

		ssnInfo = new YesNo(driver, "formSpecific.haveSSN");
		ssnInfo.no();

		return this;
	}

}

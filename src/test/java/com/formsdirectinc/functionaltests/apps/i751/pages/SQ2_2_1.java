package com.formsdirectinc.functionaltests.apps.i751.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_2_1 extends WizardPage {

	private YesNo ssnInfo;

	public SQ2_2_1(WebDriver driver) {
		super(driver);

	}

	public SQ2_2_1 SSNDetails(Properties data) {

		ssnInfo = new YesNo(driver, "jointSpouse.haveSSN");
		ssnInfo.no();

		return this;
	}

}

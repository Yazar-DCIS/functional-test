package com.formsdirectinc.functionaltests.apps.i751.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_2_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_2_2 extends WizardPage {

	private YesNo arnInfo;

	public SQ2_2_2(WebDriver driver) {
		super(driver);

	}

	public SQ2_2_2 ARNDetails(Properties data) {

		arnInfo = new YesNo(driver, "jointSpouse.haveARN");
		arnInfo.no();

		return this;
	}

}

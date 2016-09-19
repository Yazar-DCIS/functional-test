package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ2_1 extends WizardPage {

	public YesNo applicantCitizenship;
	public Sites site;

	public EQ2_1(WebDriver driver) {
		super(driver);

	}

	public EQ2_1 applicantReside_InUS() {
		applicantCitizenship = new YesNo(driver, "applicant.usCitizen");
		applicantCitizenship.yes();
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ2_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ2_2 extends WizardPage {

	public YesNo spouseResident;
	public Sites site;

	public EQ2_2(WebDriver driver) {
		super(driver);

	}

	public EQ2_2 spouseReside_InUS() {
		spouseResident = new YesNo(driver, "applicant.currentlyInUs");
		spouseResident.yes();
		return this;
	}

}

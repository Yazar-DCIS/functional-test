package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ12_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ12_1 extends WizardPage {

	private YesNo haveDisabilities;

	public SQ12_1(WebDriver driver) {
		super(driver);
	}

	public SQ12_1 relativeInformationOnAccommodations(String haveDisability) {

		haveDisabilities = new YesNo(driver,
				"foreignRelative.accomodation.haveDisability");
		haveDisabilities.setYesOrNo(haveDisability);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		

		return this;
	}

}

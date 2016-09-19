package com.formsdirectinc.functionaltests.apps.i134.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ4_1 extends WizardPage {
	private YesNo otherDependent;

	public SQ4_1(WebDriver driver) {
		super(driver);
	}

	public SQ4_1 haveDependent(String haveAnyDependents) {
		otherDependent = new YesNo(driver, "formSpecific.haveAnyDependents");
		otherDependent.setYesOrNo(haveAnyDependents);
		return this;
	}

	
	public SQ4_1 haveOtherDependent(String haveAnyOtherDependents) {
		otherDependent = new YesNo(driver,"formSpecific.haveAnyOtherDependents");
		otherDependent.setYesOrNo(haveAnyOtherDependents);
		return this;
	}



}

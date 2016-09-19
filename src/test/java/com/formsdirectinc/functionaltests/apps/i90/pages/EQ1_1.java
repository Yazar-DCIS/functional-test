package com.formsdirectinc.functionaltests.apps.i90.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.newtags.WizardPage;


/**
 * EQ1_1- typeOfApplicant
 * @author Orina
 *
 */
public class EQ1_1 extends WizardPage {
	public MultiRadioOptions residentStatus;

	public EQ1_1(WebDriver driver) {
		super(driver);
	}

	public EQ1_1 customerStatus(int answer) {
	
		residentStatus = new MultiRadioOptions(driver,"applicationData-quiz.typeOfApplicant");
		residentStatus.selectOption(answer);
			saveScreenShot("i90", this.getClass().getSimpleName()); 
			gotoNextPage("div","Continue");
		
		return this;
	}


}

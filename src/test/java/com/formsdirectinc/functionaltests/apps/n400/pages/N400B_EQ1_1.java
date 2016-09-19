package com.formsdirectinc.functionaltests.apps.n400.pages;


import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.newtags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for N400B_EQ1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class N400B_EQ1_1 extends WizardPage {

	public MultiRadioOptions citizenshipQualificationCriteria;
	public Sites site;

	public N400B_EQ1_1(WebDriver driver) {
		super(driver);

	}

	
	public N400B_EQ1_1 citizenshipQualificationCriteria(String citizenshipQualification) {

		String citizenshipQualificationValues=citizenshipQualification;
		for(String qualificationTypeSelect:citizenshipQualificationValues.split(",")) {
			citizenshipQualificationCriteria = new MultiRadioOptions(driver, 
					"applicationData-quiz.citizenshipQualificationCriteria.optionList["+qualificationTypeSelect+"].value");
			citizenshipQualificationCriteria.selectOption(Integer.parseInt(qualificationTypeSelect));
		}
	
		 clickContinueInEQ();

		return this;
	}

}

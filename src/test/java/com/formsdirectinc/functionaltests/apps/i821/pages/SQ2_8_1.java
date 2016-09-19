package com.formsdirectinc.functionaltests.apps.i821.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_8_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_8_1 extends WizardPage {

	public SQ2_8_1(WebDriver driver) {
		super(driver);
	}

	
	private YesNo haveELISActNumber;
	private AdditionalInfoFields elisActNumber;

	public SQ2_8_1 setELIS_number(String number, Properties data) {

		if (!number.equalsIgnoreCase("NA")) {

			haveELISActNumber = new YesNo(driver,"applicant.haveELISAccountNumber");
			haveELISActNumber.setYesOrNo(number);
			if (number.equalsIgnoreCase("Yes")) {

			
				elisActNumber = new AdditionalInfoFields(driver,

				"applicationData-applicant.ELISAccountNumber");
				elisActNumber.normalText(data.getProperty("ELIS"));

			} 
			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;
	}
}

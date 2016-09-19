package com.formsdirectinc.functionaltests.apps.n565.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_1_1 extends WizardPage {

	private YesNo option;
	private AdditionalInfoFields declarationNumber;

	public SQ3_1_1(WebDriver driver) {
		super(driver);
	}

	public SQ3_1_1 certificate_number(String number, Properties data) {
		if (!number.equalsIgnoreCase("NA")) {
			option = new YesNo(driver,
					"formSpecific.knowYourDeclarationIntentionnumber");
			option.setYesOrNo(number);
			if (number.equalsIgnoreCase("Yes")) {
				
				declarationNumber = new AdditionalInfoFields(driver,
						"applicationData-formSpecific.declarationIntentionnumber");
				declarationNumber.normalText(data.getProperty("Certifynumber"));
			} 
			saveScreenShot("n565", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}
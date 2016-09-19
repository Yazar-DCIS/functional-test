package com.formsdirectinc.functionaltests.apps.i131.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_7 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_7 extends WizardPage {
	private YesNo removalProceedings;
	private AdditionalInfoFields officeHandlingProceedings;

	public SQ2_7(WebDriver driver) {
		super(driver);
	}

	public SQ2_7 havRemovalProceedings(Properties data,
			String havRemovalProceedings) {
		
		removalProceedings = new YesNo(driver, "applicant.inRemovalProceedings");
		removalProceedings.setYesOrNo(havRemovalProceedings);
		
		if (havRemovalProceedings.equalsIgnoreCase("Yes")) {
			
			officeHandlingProceedings = new AdditionalInfoFields(driver,
					"applicant.nameOfDHSOffice");
			officeHandlingProceedings.textDDM("I131_Location_I485Pending");
		}
		
		saveScreenShot("i131", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}
}

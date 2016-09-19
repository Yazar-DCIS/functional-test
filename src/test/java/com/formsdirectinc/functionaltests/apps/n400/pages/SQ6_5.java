package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ6_5 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ6_5 extends WizardPage {

	private YesNo taxes;
	private AdditionalInfoFields reasons;

	public SQ6_5(WebDriver driver) {
		super(driver);

	}

	public SQ6_5 taxes(Properties copies, Properties data, String answers) {

		if (!answers.equalsIgnoreCase("NA")) {

			taxes = new YesNo(driver,"formSpecific.nonresidentOnTaxReturnDetails.yesno");
			taxes.setYesOrNo(answers);
			if (answers.equalsIgnoreCase("Yes")) {
				
				reasons = new AdditionalInfoFields(driver,
						"applicationData-formSpecific.nonresidentOnTaxReturnDetails.explain");
				reasons.normalText(data.getProperty("Reasons"));
			}
			
			taxes = new YesNo(driver,"formSpecific.fileTaxReturnNonresidentDetails.yesno");
			taxes.setYesOrNo(answers);
			if (answers.equalsIgnoreCase("Yes")) {
				reasons = new AdditionalInfoFields(driver,
						"applicationData-formSpecific.fileTaxReturnNonresidentDetails.explain");
				reasons.normalText(data.getProperty("Reasons"));
				
				taxes = new YesNo(driver,"formSpecific.considerNonUSResident.yesno");
				taxes.setYesOrNo(answers);
				if (answers.equalsIgnoreCase("Yes")) {
					reasons = new AdditionalInfoFields(driver,
							"applicationData-formSpecific.considerNonUSResident.explain");
					reasons.normalText(data.getProperty("Reasons"));
				}
				

			}
			
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ6_5");
			 clickContinueInSQ();
		}
		return this;
	}

}

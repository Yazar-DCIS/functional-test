package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ5_4 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ5_4 extends WizardPage {

	protected YesNo hasFatherLostCitizenShip;
	protected AdditionalInfoFields reasonForLostCitizenShip;

	public SQ5_4(WebDriver driver) {
		super(driver);

	}

	public SQ5_4 fatherCitizenshipStatus(Properties data,
			String lostUSCitizenship) {

		if (!lostUSCitizenship.equalsIgnoreCase("NA")) {

			hasFatherLostCitizenShip = new YesNo(driver,
					"applicant.fatherInfo.lostUSCitizenshipWithExplanation.answer");
			hasFatherLostCitizenShip.setYesOrNo(lostUSCitizenship);
			if (lostUSCitizenship.equalsIgnoreCase("Yes")) {
			
				reasonForLostCitizenShip = new AdditionalInfoFields(
						driver,	"applicationData-applicant.fatherInfo.lostUSCitizenshipWithExplanation.explanation");
				reasonForLostCitizenShip.isStatusOther(data
						.getProperty("Reasons"));
			}

			saveScreenShot("n600", "SQ5_4"); clickContinueInSQ();
		}
		return this;

	}

}

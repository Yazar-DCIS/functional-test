package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ6_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ6_4 extends WizardPage {

	protected YesNo hasMotherLostCitizenShip;
	protected AdditionalInfoFields reasonForLostCitizenShip;

	public SQ6_4(WebDriver driver) {
		super(driver);

	}

	public SQ6_4 motherCitizenshipStatus(Properties data,
			String lostUSCitizenship) {

		if (!lostUSCitizenship.equalsIgnoreCase("NA")) {

			hasMotherLostCitizenShip = new YesNo(driver,
					"applicant.motherInfo.lostUSCitizenshipWithExplanation.answer");
			hasMotherLostCitizenShip.setYesOrNo(lostUSCitizenship);
			if (lostUSCitizenship.equalsIgnoreCase("Yes")) {
				reasonForLostCitizenShip = new AdditionalInfoFields(
						driver,
				"applicationData-applicant.motherInfo.lostUSCitizenshipWithExplanation.explanation");
				reasonForLostCitizenShip.isStatusOther(data
						.getProperty("Reasons"));
			}

			
			saveScreenShot("n600", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}

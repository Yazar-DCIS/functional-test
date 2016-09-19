
package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_8 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_8 extends WizardPage {

	protected YesNo prevAppliedPassport, prevLostCitizenship, prevArmyMember;
	protected AdditionalInfoFields prevAppliedPassportReason,
			prevLostCitizenshipReason;
	protected Sites site;

	public SQ3_8(WebDriver driver) {
		super(driver);

	}

	public SQ3_8 previousApplicationsAndService(Properties data, String service) {

		if (!service.equalsIgnoreCase("NA")) {

			prevAppliedPassport = new YesNo(driver,
					"applicant.additionalInfo.preAppliedForPassportWithExplanation.answer");
			prevAppliedPassport.setYesOrNo(service);
			if (service.equalsIgnoreCase("Yes")) {
				prevAppliedPassportReason = new AdditionalInfoFields(
						driver,

						"applicationData-applicant.additionalInfo.preAppliedForPassportWithExplanation.explanation");
				prevAppliedPassportReason.isStatusOther(data
						.getProperty("Reasons"));
			}

			prevLostCitizenship = new YesNo(driver,
					"applicant.additionalInfo.abandonedOrLost");
			prevLostCitizenship.setYesOrNo(service);
			if (service.equalsIgnoreCase("Yes")) {
				prevLostCitizenshipReason = new AdditionalInfoFields(driver,

				"applicationData-applicant.additionalInfo.abandonedOrLostExplain");
				prevLostCitizenshipReason.isStatusOther(data
						.getProperty("Reasons"));
			}

			
			saveScreenShot("n600", "SQ3_8"); clickContinueInSQ();
		}
		return this;
	}

}

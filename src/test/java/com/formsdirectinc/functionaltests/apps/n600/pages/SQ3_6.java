package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ3_6 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_6 extends WizardPage {

	protected YesNo residentStatus;
	protected AdditionalInfoFields uscisOfficeLoc;
	protected DateTag statusDate;

	public SQ3_6(WebDriver driver) {
		super(driver);

	}

	public SQ3_6 immigrationStatus_part2(String residentType, Properties data) {

		if (!residentType.equalsIgnoreCase("NA")) {
			residentStatus = new YesNo(driver,
					"applicant.additionalInfo.hasLawfulPermanentResident");
			residentStatus.setYesOrNo(residentType);
			if (residentType.equalsIgnoreCase("Yes")) {
				
				statusDate = new DateTag(driver,
						"applicant.additionalInfo.dateOfPR");
				statusDate.selectDate(data.getProperty("DOB"));
				uscisOfficeLoc = new AdditionalInfoFields(driver,

				"applicationData-applicant.additionalInfo.uscisOffice");
				uscisOfficeLoc.isStatusOther(data.getProperty("Reasons"));
			}

			
			saveScreenShot("n600", "SQ3_6"); clickContinueInSQ();
		}
		return this;
	}

}

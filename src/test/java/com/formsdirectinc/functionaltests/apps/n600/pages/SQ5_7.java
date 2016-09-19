
package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ5_7 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ5_7 extends WizardPage {

	protected AdditionalInfoFields marriageCount, marriageStatus;
	protected YesNo currentSpouse;
	protected MultiRadioOptions dischargeType;
	protected AdditionalInfoFields explainations;

	public SQ5_7(WebDriver driver) {
		super(driver);

	}

	public SQ5_7 fatherMaritalInfo(Properties data, String fatherDeceased,
			int mrgCount, String maritalType, String presentSpouse) {

		if (!fatherDeceased.equalsIgnoreCase("NA")
				&& !maritalType.equalsIgnoreCase("NA")
				&& !presentSpouse.equalsIgnoreCase("NA") && mrgCount != -1) {
			marriageCount = new AdditionalInfoFields(driver,
					"applicationData-applicant.fatherInfo.maritalStatus.howManyTimesMarried");
			marriageCount.selectDDM_Number(mrgCount);

			if ((fatherDeceased.equalsIgnoreCase("No")) && (mrgCount >= 1)) {

				marriageStatus = new AdditionalInfoFields(driver,

				"applicationData-applicant.fatherInfo.maritalStatus.currentlyMarried");
				marriageStatus.selectDDM(maritalType);

				if (maritalType.equalsIgnoreCase(data
						.getProperty("status_Married"))) {
					currentSpouse = new YesNo(driver,
							"applicant.fatherInfo.maritalStatus.spouseDetails.spouseYourMother");

					currentSpouse.setYesOrNo(presentSpouse);

				}

				else if (maritalType.equalsIgnoreCase(data
						.getProperty("status_Other"))) {
					explainations = new AdditionalInfoFields(driver,

					"applicationData-applicant.fatherInfo.maritalStatus.explainOtherMarriage");
					explainations.normalText(data.getProperty("status_Other"));

				}

			}
			saveScreenShot("n600", "SQ5_7"); clickContinueInSQ();
		}
		return this;
	}

}

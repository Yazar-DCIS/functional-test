package com.formsdirectinc.functionaltests.apps.i821.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_4 extends WizardPage {

	public SQ1_4(WebDriver driver) {
		super(driver);
	}

	
	private YesNo residing;
	private AdditionalInfoFields eligibilitystatus;
	private YesNo sameCountryNationalityAndResidence;
	private AdditionalInfoFields addAnotherCountry;

	private DateTag addAnotherDate;
	private AdditionalInfoFields addAnotherText;

	public SQ1_4 currentlyResidingInUs(String currentlyresidinginus,
			String tpsstatus, String countryOfLastResidence, Properties data) {
		if (!currentlyresidinginus.equalsIgnoreCase("NA")) {

			residing = new YesNo(driver,
					"eligibilityDetails.currentlyResidingInUs");

			if (currentlyresidinginus.equalsIgnoreCase("Yes")) {
				residing.yes();

				eligibilitystatus = new AdditionalInfoFields(driver,

				"applicationData-eligibilityDetails.nationality-country");
				eligibilitystatus.selectDDM(tpsstatus);

				if (tpsstatus.equalsIgnoreCase("stateless")) {

					eligibilitystatus = new AdditionalInfoFields(driver,

					"applicationData-eligibilityDetails.countryOfLastResidence-country");
					eligibilitystatus.selectDDM(countryOfLastResidence);
				}
				sameCountryNationalityAndResidence = new YesNo(driver,

				"eligibilityDetails.sameCountryNationalityAndResidence");
				if (currentlyresidinginus.equalsIgnoreCase("Yes")) {

					sameCountryNationalityAndResidence.yes();
					addAnotherCountry(2, data);

				} else if (currentlyresidinginus.equalsIgnoreCase("No")) {
					sameCountryNationalityAndResidence.no();
				}

			} else if (currentlyresidinginus.equalsIgnoreCase("No")) {
				residing.no();

			}
			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;
	}

	public SQ1_4 addAnotherCountry(int count, Properties data) {
		for (int i = 0; i < count; i++) {

			addAnotherCountry = new AdditionalInfoFields(driver,

			"applicationData-eligibilityDetails.residencyDetails[" + i
					+ "].otherThanUSCountry-country");
			addAnotherCountry.selectDDM(data.getProperty("DOB_Country"));

			addAnotherDate = new DateTag(driver,
					"eligibilityDetails.residencyDetails[" + i
							+ "].dateResidingInNonUS.fromDate");
			addAnotherDate.selectDateAsSingle(data.getProperty("fromDate"));
			addAnotherDate = new DateTag(driver,
					"eligibilityDetails.residencyDetails[" + i
							+ "].dateResidingInNonUS.toDate");
			addAnotherDate.selectDateAsSingle(data.getProperty("toDate"));

			addAnotherText = new AdditionalInfoFields(driver,

			"applicationData-eligibilityDetails.residencyDetails[" + i
					+ "].immigrationStatusInNonUS");
			addAnotherText.normalText(data
					.getProperty("i821_immigrationstatus"));

			if (i < count - 1) {
				CommonInputClasses others = new CommonInputClasses(driver);
				others.addAnother();
			}

		}
		return this;

	}
}

package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ6_6_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ6_6_1 extends WizardPage {

	private DateTag arrestedDate;
	private AdditionalInfoFields arrestedCountry, arrestedCity, arrestedState,
			arrestedReason, outcome;

	public SQ6_6_1(WebDriver driver) {
		super(driver);

	}

	public SQ6_6_1 priorOffensesInDetail(Properties copies, int count,
			Properties data) {

		if ((count != -1)) {
			if (count > 0) {
				for (int i = 0; i < count; i++) {
					priorOffenses(copies, i, data);
					if (i < count - 1) {
						CommonInputClasses others = new CommonInputClasses(
								driver);
						others.addAnotherPriorOffense();
					}
				}

			}
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ6_6_1");
			
			 clickContinueInSQ();
		}
		return this;

	}

	public SQ6_6_1 priorOffenses(Properties copies, int count, Properties data) {

		arrestedDate = new DateTag(driver, "crimeDetails.crime[" + count
				+ "].date");
		arrestedDate.selectDate(data.getProperty("arrestedDate" + count));

		arrestedCountry = new AdditionalInfoFields(driver,
				"applicationData-crimeDetails.crime[" + count
						+ "].place.country-country");
		arrestedCountry.selectDDM(data.getProperty("arrestedCountry" + count));

		arrestedCity = new AdditionalInfoFields(driver,
				"applicationData-crimeDetails.crime[" + count + "].place-city");
		arrestedCity.normalText(data.getProperty("arrestedCity" + count));

		arrestedState = new AdditionalInfoFields(driver,
				"applicationData-crimeDetails.crime[" + count
						+ "].place.state-statetext");
		arrestedState.normalText(data.getProperty("arrestedState" + count));

		arrestedReason = new AdditionalInfoFields(driver,
				"applicationData-crimeDetails.crime[" + count + "].reason");
		arrestedReason.normalText(data.getProperty("arrestedReason" + count));

		outcome = new AdditionalInfoFields(driver,
				"applicationData-crimeDetails.crime[" + count + "].outcome");
		outcome.normalText(data.getProperty("outcome" + count));

		return this;
	}

}

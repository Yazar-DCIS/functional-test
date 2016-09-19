package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.CheckBox;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ9_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ9_2 extends WizardPage {

	private YesNo accomodation;
	private CheckBox disablityType;
	private AdditionalInfoFields explain;

	public SQ9_2(WebDriver driver) {
		super(driver);

	}

	public SQ9_2 accomodation(Properties copies, Properties data,
			String needAccomodation, String disablityTypes) {
		if (!needAccomodation.equalsIgnoreCase("NA")
				&& !disablityTypes.equalsIgnoreCase("NA")) {

			accomodation = new YesNo(driver,
					"formSpecific.requestingAccommodation");

			if (needAccomodation.equalsIgnoreCase("Yes")) {
				accomodation.yes();

				if (disablityTypes.equalsIgnoreCase("deaf")) {
					disablityType = new CheckBox(driver,
							"applicationData-formSpecific.deafOrHearingImpaired");
					disablityType.check();

					explain = new AdditionalInfoFields(driver,

					"applicationData-formSpecific.interpreterLanguageExplain");
					explain.normalText(data.getProperty("disablity"));

					accomodation = new YesNo(driver,
							"formSpecific.tddTelephoneConnection");
					if (needAccomodation.equalsIgnoreCase("Yes")) {
						accomodation.yes();
					}
					else if (needAccomodation.equalsIgnoreCase("No")) {
						accomodation.no();
					}

				}
				else if (disablityTypes.equalsIgnoreCase("wheelChair")) {
					disablityType = new CheckBox(driver,
							"applicationData-formSpecific.wheelChair");
					disablityType.check();
				}
				else if (disablityTypes.equalsIgnoreCase("blind")) {
					disablityType = new CheckBox(driver,
							"applicationData-formSpecific.blindOrSight");
					disablityType.check();
				}
				else if (disablityTypes.equalsIgnoreCase("other")) {
					disablityType = new CheckBox(driver,
							"applicationData-formSpecific.anotherTypeOfAccommodation");
					disablityType.check();

					explain = new AdditionalInfoFields(driver,

					"applicationData-formSpecific.otherAccommodationExplain");
					explain.normalText(data.getProperty("disablity"));
				}

			}

			else if (needAccomodation.equalsIgnoreCase("No")) {
				accomodation.no();
			}
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ9_2");
			 clickContinueInSQ();
		}
		return this;
	}

}

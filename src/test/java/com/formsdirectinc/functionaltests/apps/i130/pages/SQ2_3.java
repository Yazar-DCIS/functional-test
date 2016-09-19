package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_3 extends WizardPage {

	private Name_FirstMiddleLast relativeName;
	private YesNo moreNames;
	private AdditionalInfoFields setotherNameField;

	public SQ2_3(WebDriver driver) {
		super(driver);

	}

	public SQ2_3 relativeNameDetails(String hasMoreNames, Properties data,
			int count) {

		if (!hasMoreNames.equalsIgnoreCase("na") && count != -1) {
			relativeName = new Name_FirstMiddleLast(driver, "applicationData",
					"relative.name");
			relativeName.setFirstNameField(data.getProperty("FirstName"));
			relativeName.setLastNameField(data.getProperty("FirstName2"));
			relativeName.setMiddleNameField(data.getProperty("FirstName1"));

			moreNames = new YesNo(driver, "relative.usedOtherNames");

			if (hasMoreNames.equalsIgnoreCase("yes")) {
				moreNames.yes();

				for (int i = 0; i < count; i++) {

					setotherNameField = new AdditionalInfoFields(driver,

					"applicationData-relative.otherNames[" + i
							+ "].familyMemberOtherNames");
					setotherNameField.normalText(data.getProperty("LastName"));

					if (i < count - 1) {
						CommonInputClasses otherNames = new CommonInputClasses(
								driver);
						otherNames.addAnother();
					}

				}
			}
			else if (hasMoreNames.equalsIgnoreCase("no")) {
				moreNames.no();
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

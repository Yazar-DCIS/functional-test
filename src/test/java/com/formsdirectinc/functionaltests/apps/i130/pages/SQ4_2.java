package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_2 extends WizardPage {

	private Name_FirstMiddleLast name;
	private YesNo otherNameField;

	private AdditionalInfoFields setotherNameField;

	public SQ4_2(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public SQ4_2 spouseLegalName(Properties data, String otherNames, int count) {

		if (!otherNames.equalsIgnoreCase("na") && count != -1) {

			name = new Name_FirstMiddleLast(driver, "applicationData",
					"spouseInfo.name");
			name.setFirstNameField(data.getProperty("FirstName"));
			name.setMiddleNameField(data.getProperty("MiddleName"));
			name.setLastNameField(data.getProperty("LastName"));

			otherNameField = new YesNo(driver, "spouseInfo.usedOtherNames");

			if (otherNames.equalsIgnoreCase("yes")) {
				otherNameField.yes();

				for (int i = 0; i < count; i++) {

					setotherNameField = new AdditionalInfoFields(driver,

					"applicationData-spouseInfo.otherNames[" + i
							+ "].otherName");
					setotherNameField.normalText(data.getProperty("LastName"));
					if (i < count - 1) {
						CommonInputClasses relativeInfo = new CommonInputClasses(
								driver);
						relativeInfo.addAnother();
					}

				}

			}

			else if (otherNames.equalsIgnoreCase("no")) {
				otherNameField.no();
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

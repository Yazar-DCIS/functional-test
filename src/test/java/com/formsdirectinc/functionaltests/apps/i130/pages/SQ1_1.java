package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_1 extends WizardPage {

	private Name_FirstMiddleLast name;
	private YesNo otherNameField;

	public SQ1_1(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void applicantName(Properties data, String otherNames, int count) {

		name = new Name_FirstMiddleLast(driver, "applicationData",
				"applicant.name");
		name.setFirstNameField(data.getProperty("FirstName"));
		name.setMiddleNameField(data.getProperty("MiddleName"));
		name.setLastNameField(data.getProperty("LastName"));

		otherNameField = new YesNo(driver, "applicant.haveUsedOtherNames");

		if (otherNames.equalsIgnoreCase("yes")) {

			otherNameField.yes();

			for (int i = 0; i < count; i++) {

				AdditionalInfoFields moreNames = new AdditionalInfoFields(
						driver, "applicationData-applicant.otherNames[" + i
								+ "].appOtherNames");
				moreNames.normalText(data.getProperty("LastName" + i));

				if (i < count - 1) {
					CommonInputClasses name = new CommonInputClasses(driver);
					name.addAnother();
				}

			}

		}

		else if (otherNames.equalsIgnoreCase("no")) {
			otherNameField.no();
		}

		saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
	}

}

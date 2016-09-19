package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_3 extends WizardPage {

	private Name_FirstMiddleLast spouseName;
	private YesNo hasOtherName;

	public SQ3_3(WebDriver driver) {
		super(driver);

	}

	public SQ3_3 spouseNameDetails(Properties copies, Properties data,
			String otherNames, int count) {

		if (!otherNames.equalsIgnoreCase("NA") && count != -1) {

			spouseName = new Name_FirstMiddleLast(driver, "applicationData",
					"currentSpouse.currentSpouseName");
			spouseName.setFirstNameField(data.getProperty("spouseFirstName"));
			spouseName.setLastNameField(data.getProperty("spouseLastName"));

			spouseName = new Name_FirstMiddleLast(driver, "applicationData",
					"currentSpouse.previousLegalName");
			spouseName.setFirstNameField(data.getProperty("spouseFirstName"));
			spouseName.setLastNameField(data.getProperty("spouseLastName"));

			hasOtherName = new YesNo(driver, "currentSpouse.haveOtherNames");
			if (otherNames.equalsIgnoreCase("Yes")) {

				hasOtherName.yes();

				spouseName.setFirstNameField(data.getProperty("spouseNewFirstName"));
				spouseName.setLastNameField(data.getProperty("spouseNewLastName"));

				for (int i = 0; i < count; i++) {

					Name_FirstMiddleLast moreNames = new Name_FirstMiddleLast(
							driver, "applicationData",
							"currentSpouse.otherNames[" + i
									+ "].otherNamesList");
					moreNames.setFirstNameField(data.getProperty("FirstName"));
					moreNames
							.setMiddleNameField(data.getProperty("MiddleName"));
					moreNames.setLastNameField(data.getProperty("LastName"));

					if (i < count - 1) {
						CommonInputClasses otherName = new CommonInputClasses(
								driver);
						otherName.addAnother();
					}

				}

			}

			else if (otherNames.equalsIgnoreCase("No")) {
				hasOtherName.no();
			}
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ3_3");
			 clickContinueInSQ();
		}
		return this;
	}

}

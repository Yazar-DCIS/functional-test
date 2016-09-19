package com.formsdirectinc.functionaltests.apps.i821.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_3 extends WizardPage {

	public SQ4_3(WebDriver driver) {
		super(driver);
	}

	
	private YesNo spouseDetails;

	public SQ4_3 spousePriorMarriages(String previouslymarried, int count,
			Properties data) {

		if (!previouslymarried.equalsIgnoreCase("NA")) {
			spouseDetails = new YesNo(driver,
					"currentSpouseDetails.previouslyMarried");
			if (previouslymarried.equalsIgnoreCase("Yes")) {
				spouseDetails.yes();

				for (int i = 0; i < count; i++) {

					Name_FirstMiddleLast moreNames = new Name_FirstMiddleLast(
							driver, "applicationData",
							"currentSpouseDetails.otherNames[" + i
									+ "].otherNamesList");
					moreNames.setFirstNameField(data.getProperty("FirstName"
							+ i));
					moreNames.setLastNameField(data.getProperty("MiddleName"
							+ i));
					moreNames.setMiddleNameField(data.getProperty("LastName"
							+ i));

					if (i < count - 1) {
						CommonInputClasses relativeInfo = new CommonInputClasses(
								driver);
						relativeInfo.addAnother();
					}
				}

			}
			else if (previouslymarried.equalsIgnoreCase("No")) {
				spouseDetails.no();
			}
			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();

		}

		return this;

	}

}

package com.formsdirectinc.functionaltests.apps.i821.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_2 extends WizardPage {

	public SQ2_2(WebDriver driver) {
		super(driver);
	}

	
	private YesNo usedOtherNames;

	public SQ2_2 other_Names(String usedothername, int count, Properties data) {

		if (!usedothername.equalsIgnoreCase("NA")) {

			usedOtherNames = new YesNo(driver, "applicant.usedOtherNames");

			if (usedothername.equalsIgnoreCase("Yes")) {

				usedOtherNames.yes();

				for (int i = 0; i < count; i++) {

					Name_FirstMiddleLast moreNames = new Name_FirstMiddleLast(
							driver, "applicationData", "applicant.otherNames["
									+ i + "].otherNamesList");
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
			else if (usedothername.equalsIgnoreCase("No")) {
				usedOtherNames.no();
			}
			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

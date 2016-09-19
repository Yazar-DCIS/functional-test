package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_1_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_1_3 extends WizardPage {

	private Name_FirstMiddleLast nameTag;

	public SQ2_1_3(WebDriver driver) {
		super(driver);

	}

	public SQ2_1_3 namesUsedDuringMilitary(Properties n400copies,
			Properties data, int nameCount) {

		if (nameCount != 0) {
			for (int i = 0; i < nameCount; i++) {
				nameTag = new Name_FirstMiddleLast(driver, "applicationData",
						"presenceInUs.allNamesInArmedForces[" + i
								+ "].otherNamesList");
				nameTag.setFirstNameField(data.getProperty("FirstName"));
				nameTag.setMiddleNameField(data.getProperty("MiddleName"));
				nameTag.setLastNameField(data.getProperty("LastName"));

				if (i < nameCount - 1) {

					CommonInputClasses others = new CommonInputClasses(driver);
					others.addAnother();

				}

			}
			
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ2_1_3");
			
			 clickContinueInSQ();
		}
		return this;
	}

}

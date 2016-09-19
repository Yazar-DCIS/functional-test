package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_2 extends WizardPage {

	private MultiRadioOptions maritalStatus;

	public SQ3_2(WebDriver driver) {
		super(driver);

	}

	public SQ3_2 priorMaritalStatus(Properties copies, String marriageCount) {
		if (!marriageCount.equalsIgnoreCase("NA")) {

			maritalStatus = new MultiRadioOptions(driver,
					"applicationData-maritalStatus.marriageCount");

			if (marriageCount.equalsIgnoreCase("marriedOnce")) {
				maritalStatus.selectOption(1);
			}

			else if (marriageCount.equalsIgnoreCase("marriedMoreThanOnce")) {
				maritalStatus.selectOption(2);
			}

			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ3_2");
			
			 clickContinueInSQ();
		}
		return this;
	}

}

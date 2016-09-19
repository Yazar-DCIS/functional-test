package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ3_11 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_11 extends WizardPage {

	private MultiRadioOptions priorMarriages;

	public SQ3_11(WebDriver driver) {
		super(driver);

	}

	public SQ3_11 spousePriorMarriages(Properties copies, Properties data,
			String priorMarriage) {

		if (!priorMarriage.equalsIgnoreCase("NA")) {

			priorMarriages = new MultiRadioOptions(driver,
					"applicationData-currentSpouse.currentSpouseMarriageCount");

			if (priorMarriage.equalsIgnoreCase("marriedOnce")) {
				priorMarriages.selectOption(1);
			}
			else if (priorMarriage.equalsIgnoreCase("marriedMoreThanOnce")) {
				priorMarriages.selectOption(2);
			}
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ3_11");
			 clickContinueInSQ();
		}
		return this;
	}

}

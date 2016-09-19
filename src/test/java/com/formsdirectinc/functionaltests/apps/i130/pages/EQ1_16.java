package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_16 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ1_16 extends WizardPage {

	public YesNo applicantsParentBiological;

	public EQ1_16(WebDriver driver) {
		super(driver);

	}

	public EQ1_16 applicantsParentBiological(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

			
			applicantsParentBiological = new YesNo(driver,
					"quiz.applicantsParentBiological");

			applicantsParentBiological.setYesOrNo(answer);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}

		return this;
	}

}

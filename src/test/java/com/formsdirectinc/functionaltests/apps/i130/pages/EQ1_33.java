package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_33 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ1_33 extends WizardPage {

	public YesNo priorMarriageTerminated;

	public EQ1_33(WebDriver driver) {
		super(driver);

	}

	public EQ1_33 priorMarriageTerminated(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

			
			priorMarriageTerminated = new YesNo(driver,
					"quiz.priorMarriageTerminated");

			priorMarriageTerminated.setYesOrNo(answer);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_34 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_34 extends WizardPage {

	public YesNo presentInUS;

	public EQ1_34(WebDriver driver) {
		super(driver);

	}

	public EQ1_34 physicallyPresent(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

			
			presentInUS = new YesNo(driver, "quiz.physicallyPresent");
			presentInUS.setYesOrNo(answer);
			
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

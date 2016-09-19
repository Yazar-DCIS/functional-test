package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_39 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_39 extends WizardPage {

	public YesNo biologicalParentOfTheChild;

	public EQ1_39(WebDriver driver) {
		super(driver);

	}

	public EQ1_39 biologicalParentOfTheChild(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {
			
			biologicalParentOfTheChild = new YesNo(driver,"quiz.biologicalParentOfTheChild");
			biologicalParentOfTheChild.setYesOrNo(answer);
			
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ1_42 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_42 extends WizardPage {

	public YesNo marriageBeforeEighteenthBirthday;

	public EQ1_42(WebDriver driver) {
		super(driver);

	}

	public EQ1_42 marriageBeforeEighteenthBirthday(String answer,
			Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

		
			marriageBeforeEighteenthBirthday = new YesNo(driver,
					"quiz.marriageBeforeEighteenthBirthday");
			marriageBeforeEighteenthBirthday.setYesOrNo(answer);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

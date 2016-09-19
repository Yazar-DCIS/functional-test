package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_20 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_20 extends WizardPage {

	public YesNo adoptedBySomeone;

	public EQ1_20(WebDriver driver) {
		super(driver);

	}

	public EQ1_20 adoptedBySomeone(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

			adoptedBySomeone = new YesNo(driver, "quiz.adoptedBySomeone");
			adoptedBySomeone.setYesOrNo(answer);
			
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

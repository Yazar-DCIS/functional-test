package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_32 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_32 extends WizardPage {

	public YesNo proceedings;

	public EQ1_32(WebDriver driver) {
		super(driver);

	}

	public EQ1_32 husbandOrWifeRescissionProceeding(String answer,
			Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

			
			proceedings = new YesNo(driver,
					"quiz.husbandOrWifeRescissionProceeding");

			proceedings.setYesOrNo(answer);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

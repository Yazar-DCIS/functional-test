package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_6 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_6 extends WizardPage {

	public YesNo beneficiary;

	public EQ1_6(WebDriver driver) {
		super(driver);

	}

	public EQ1_6 applicantisBPOfBeneficiary(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {
			
			beneficiary = new YesNo(driver, "quiz.applicantisBPOfBeneficiary");

			beneficiary.setYesOrNo(answer);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

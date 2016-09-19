package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_44 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_44 extends WizardPage {

	public YesNo sameBiologicalParents;

	public EQ1_44(WebDriver driver) {
		super(driver);

	}

	public EQ1_44 sameBiologicalParents(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

			sameBiologicalParents = new YesNo(driver,
					"quiz.sameBiologicalParents");

			sameBiologicalParents.setYesOrNo(answer);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

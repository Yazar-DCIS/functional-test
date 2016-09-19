package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_45 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_45 extends WizardPage {

	public YesNo adoptedByNonBiologicalParents;

	public EQ1_45(WebDriver driver) {
		super(driver);

	}

	public EQ1_45 adoptedByNonBiologicalParents(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {
			
			adoptedByNonBiologicalParents = new YesNo(driver,
					"quiz.adoptedByNonBiologicalParents");

			adoptedByNonBiologicalParents.setYesOrNo(answer);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

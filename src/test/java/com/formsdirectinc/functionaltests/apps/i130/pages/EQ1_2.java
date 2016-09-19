package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_2 extends WizardPage {

	public YesNo physicalPresence;

	public EQ1_2(WebDriver driver) {
		super(driver);

	}

	public EQ1_2 physicalPresenceAtWedding(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {
			
			physicalPresence = new YesNo(driver,
					"quiz.bothPhysicallyPresentAtWedding");
			physicalPresence.setYesOrNo(answer);
			
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

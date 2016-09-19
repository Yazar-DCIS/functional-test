package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ1_16 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ1_16 extends WizardPage {

	private YesNo physicalPresence;

	public SQ1_16(WebDriver driver) {
		super(driver);

	}

	public void physicalPresenceInUS(String answer) {
		physicalPresence = new YesNo(driver, "principalQuiz.physicalPresence");
		physicalPresence.setYesOrNo(answer);
		
	}

	
}

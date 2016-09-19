package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ1_9 Details
 * @author:Orina<br> Revision: $Rev$
 */



public class SQ1_9 extends WizardPage {


	private YesNo unauthorizedWorker;

	public SQ1_9(WebDriver driver) {
		super(driver);

	}

	public void unauthorizedWorker(String answer) {

		unauthorizedWorker = new YesNo(driver, "principalQuiz.unauthorizedWorker");
		unauthorizedWorker.setYesOrNo(answer);
		

	}

}

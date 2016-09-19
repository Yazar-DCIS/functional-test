package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ1_9 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ1_9 extends WizardPage {

	private YesNo currentlyMarried,haveChildren;
	public EQ1_9(WebDriver driver) {
		super(driver);

	}

	
	public EQ1_9 familyInformation(String answercurrentlyMarried,String answerhaveChildren) {
		
		
		currentlyMarried = new YesNo(driver, "principalQuiz.currentlyMarried");
		haveChildren = new YesNo(driver, "principalQuiz.haveChildren");
		currentlyMarried.setYesOrNo(answercurrentlyMarried);
		haveChildren.setYesOrNo(answerhaveChildren);
		
		saveScreenShot("i485multi", this.getClass().getSimpleName()); clickContinueInEQ();
		return this;
	}

}

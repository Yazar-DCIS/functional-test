package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ1_40 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_40 extends WizardPage {

	public YesNo adoptedChild;

	public EQ1_40(WebDriver driver) {
		super(driver);

	}

	public EQ1_40 adoptedChild(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

		
			adoptedChild = new YesNo(driver, "quiz.adoptedChild");
			adoptedChild.setYesOrNo(answer);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

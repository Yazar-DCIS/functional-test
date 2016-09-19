package com.formsdirectinc.functionaltests.apps.n400.pages;


import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.newtags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for N400B_EQ3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class N400B_EQ3_1 extends WizardPage {

	public MultiRadioOptions servingArmedForce;
	public Sites site;

	public N400B_EQ3_1(WebDriver driver) {
		super(driver);

	}

	
	public N400B_EQ3_1 servingArmedForce(String areYouServingArmedForce) {

		servingArmedForce = new MultiRadioOptions(driver, 
					"applicationData-quiz.servingArmedForce");
		if(areYouServingArmedForce.equalsIgnoreCase("yes"))
		{
			servingArmedForce.selectOption(1);
		}
		else if(areYouServingArmedForce.equalsIgnoreCase("no"))
		{
			servingArmedForce.selectOption(2);
		}
		 clickContinueInEQ();

		return this;
	}

}

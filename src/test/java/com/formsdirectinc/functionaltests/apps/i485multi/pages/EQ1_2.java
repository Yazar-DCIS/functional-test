package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for EQ1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ1_2 extends WizardPage {

	private MultiRadioOptions applicationBasis;
	public EQ1_2(WebDriver driver) {
		super(driver);

	}

	public EQ1_2 baseOfApplication(String answer) {
		
		
		applicationBasis = new MultiRadioOptions(driver,"applicationData-principalQuiz.baseOfApplication");
		
		
		if(answer.equalsIgnoreCase("approvedImmigrantPetition"))
		{
			applicationBasis.selectOption(1);
		}
		else if(answer.equalsIgnoreCase("K-1Fiance"))
		{
			applicationBasis.selectOption(2);
		}
		else if(answer.equalsIgnoreCase("asylee"))
		{
			applicationBasis.selectOption(3);
		}
		else if(answer.equalsIgnoreCase("refugee"))
		{
			applicationBasis.selectOption(4);
		}
		else if(answer.equalsIgnoreCase("citizenOfCuba"))
		{
			applicationBasis.selectOption(5);
		}
		else if(answer.equalsIgnoreCase("fillingFormConcurrently"))
		{
			applicationBasis.selectOption(6);
		}
		else if(answer.equalsIgnoreCase("other"))
		{
			applicationBasis.selectOption(7);
		}
		saveScreenShot("i485multi", this.getClass().getSimpleName()); clickContinueInEQ();
		return this;
	}



}

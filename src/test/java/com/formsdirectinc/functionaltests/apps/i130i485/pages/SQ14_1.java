package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.Interpreter;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ14_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ14_1 extends WizardPage {

	private MultiRadioOptions applicantCanUnderstandLanguage;

	public SQ14_1(WebDriver driver) {
		super(driver);
	}

	public SQ14_1 uscitizenPetitionerCertification(String languageUnderstand) {

		String appname=Products.I130I485.name().toLowerCase();
		
		applicantCanUnderstandLanguage = new MultiRadioOptions(driver,
				"applicationData-uscitizenPetitioner.languageUnderstand");
		if(languageUnderstand.equalsIgnoreCase("yes"))
		{
			applicantCanUnderstandLanguage.selectOption(1);
		}
		else if(languageUnderstand.equalsIgnoreCase("no"))
		{
			applicantCanUnderstandLanguage.selectOption(2);
			Interpreter interpreterInfo=new Interpreter(driver);
			interpreterInfo.setInterpreterInformation("uscitizenPetitioner", appname);
		}
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.Interpreter;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ13_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ13_1 extends WizardPage {

	private MultiRadioOptions applicantCanUnderstandLanguage;

	public SQ13_1(WebDriver driver) {
		super(driver);
	}

	public SQ13_1 relativeCertificationStatement(String languageUnderstand) {

		String appname=Products.I130I485.name().toLowerCase();
		
		applicantCanUnderstandLanguage = new MultiRadioOptions(driver,
				"applicationData-foreignRelative.statement.languageUnderstand");
		if(languageUnderstand.equalsIgnoreCase("yes"))
		{
			applicantCanUnderstandLanguage.selectOption(1);
		}
		else if(languageUnderstand.equalsIgnoreCase("no"))
		{
			applicantCanUnderstandLanguage.selectOption(2);
			Interpreter interpreterInfo=new Interpreter(driver);
			interpreterInfo.setInterpreterInformation("foreignRelative.statement", appname);
		}
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();

		return this;
	}

}

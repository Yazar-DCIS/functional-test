package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.PriorPetition;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_12 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ4_12 extends WizardPage {

	private YesNo priorPetition;

	public SQ4_12(WebDriver driver) {
		super(driver);
	}

	public SQ4_12 priorPetitionInformation(String previouslyFiled,int previousPetitionCount,
			String petitionType,String wasItfiledOnBehalf) {
		
		
		String appname=Products.I130I485.name().toLowerCase();
		
		priorPetition = new YesNo(driver, "applicant.previouslyFiled");
		priorPetition.setYesOrNo(previouslyFiled);
		if(previouslyFiled.equalsIgnoreCase("Yes"))
		{
			
			PriorPetition petitionInfo=new PriorPetition(driver);
			petitionInfo.priorPetitionInformation("applicant.priorPetitions", appname, 
													previousPetitionCount, petitionType, wasItfiledOnBehalf);
		}
		
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();

		return this;
	}

}

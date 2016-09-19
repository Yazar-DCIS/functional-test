package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.PriorPetition;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ4_13_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_13_1 extends WizardPage {

	private YesNo otherPetition;

	public SQ4_13_1(WebDriver driver) {
		super(driver);
	}

	public SQ4_13_1 otherPetitionInformation(String filledOtherPetitions,int otherPetitionCount,String relation) {
		
		String appname=Products.I130I485.name().toLowerCase();
		if(filledOtherPetitions.equalsIgnoreCase("Yes")||filledOtherPetitions.equalsIgnoreCase("no"))
		{
		otherPetition = new YesNo(driver, "applicant.otherPetitions2.submitted");
		otherPetition.setYesOrNo(filledOtherPetitions);
		if(filledOtherPetitions.equalsIgnoreCase("Yes"))
		{
			PriorPetition petitionInfo=new PriorPetition(driver);
			petitionInfo.otherPetitionInformationSecondPart("applicant.otherPetitions2.nameRelationship", appname, 
					otherPetitionCount, relation);
		}
		
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

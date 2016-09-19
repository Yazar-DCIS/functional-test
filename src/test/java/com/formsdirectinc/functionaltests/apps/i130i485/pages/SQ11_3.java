package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.TaxDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ11_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ11_3 extends WizardPage {

	private MultiRadioOptions coSponsorRelation;
	private Name_FirstMiddleLast coSponsorName;
	private TaxDetails coSponsorIncome;

	public SQ11_3(WebDriver driver) {
		super(driver);
	}

	public SQ11_3 relativeAdditionalSponsorInformation1(String additionalSponsorType,int sponsorCount) {

		
		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		if(sponsorCount>0)
		{
		for (int i = 0; i < sponsorCount; i++) {
		coSponsorName=new Name_FirstMiddleLast(driver, "applicationData", "applicant.additionalSponsor1["+i+"].name");
		coSponsorName.setFirstNameField(i130i485.getProperty("applicant.additionalSponsor1["+i+"].name.first"));
		coSponsorName.setLastNameField(i130i485.getProperty("applicant.additionalSponsor1["+i+"].name.last"));
		coSponsorName.setMiddleNameField(i130i485.getProperty("applicant.additionalSponsor1["+i+"].name.middle"));
		
		coSponsorRelation = new MultiRadioOptions(driver,
				"applicationData-applicant.additionalSponsor1["+i+"].relationship");
		if(additionalSponsorType.equalsIgnoreCase("AdultChild"))
		{
			coSponsorRelation.selectOption(1);
		}
		else if(additionalSponsorType.equalsIgnoreCase("Parent"))
		{
			coSponsorRelation.selectOption(2);
		}
		else if(additionalSponsorType.equalsIgnoreCase("Sibling"))
		{
			coSponsorRelation.selectOption(3);
		}
		else if(additionalSponsorType.equalsIgnoreCase("Dependent"))
		{
			coSponsorRelation.selectOption(4);
		}
		
		coSponsorIncome=new TaxDetails(driver, "applicationData-applicant.additionalSponsor1["+i+"]");
		coSponsorIncome.setCurrentIncome(i130i485.getProperty("applicant.additionalSponsor1["+i+"].currentIncome"));
		coSponsorIncome.setTotalAssets(i130i485.getProperty("applicant.additionalSponsor1["+i+"].totalAssets"));
		
		if (i < sponsorCount - 1) {
			CommonInputClasses addAnotherSponsor=new CommonInputClasses(driver);
			addAnotherSponsor.addAnother();
		}
		
		}
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

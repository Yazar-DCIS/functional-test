package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DropDown;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ5_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ5_3 extends WizardPage {

	private YesNo haveDependentChildren,haveOtherDependent,haveSponsoredOthers;
	private DropDown dependents;
	
	
	public SQ5_3(WebDriver driver) {
		super(driver);
	}

	public SQ5_3 sponsorsHouseHoldSize(String childrenDependent,String otherDependent,String sponsorDependent) {

		
		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		haveDependentChildren = new YesNo(driver,
				"applicant.sponsorInfo.haveDependentChildren");
		dependents=new DropDown(driver, "applicationData-applicant.sponsorInfo");
		
		if(childrenDependent.equalsIgnoreCase("Yes"))
		{
			haveDependentChildren.yes();
			dependents.setNumberOfChildren(i130i485.getProperty("applicant.sponsorInfo.numberOfDependentChildren"));
			
		}
		else if(childrenDependent.equalsIgnoreCase("No"))
		{
			haveDependentChildren.no();
		}
		
		haveOtherDependent = new YesNo(driver,
				"applicant.sponsorInfo.haveOtherDependent");
		if(otherDependent.equalsIgnoreCase("Yes"))
		{
			haveOtherDependent.yes();
			dependents.setNumberOfOtherDependent(i130i485.getProperty("applicant.sponsorInfo.numberOfOtherDependent"));
		}
		else if(otherDependent.equalsIgnoreCase("No"))
		{
			haveOtherDependent.no();
		}
		
		haveSponsoredOthers = new YesNo(driver,
				"applicant.sponsorInfo.haveSponsoredOthers");
		if(sponsorDependent.equalsIgnoreCase("Yes"))
		{
			haveSponsoredOthers.yes();
			dependents.setNumberOfSponsoredOthers(i130i485.getProperty("applicant.sponsorInfo.numberOfSponsoredOthers"));
		}
		else if(sponsorDependent.equalsIgnoreCase("No"))
		{
			haveSponsoredOthers.no();
		}
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}

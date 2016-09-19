package com.formsdirectinc.functionaltests.apps.i129f.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.Employment;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_10 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_10 extends WizardPage {

	public SQ1_10(WebDriver driver) {
		super(driver);
	}

	public SQ1_10 employment(String workedInPast5Years, String workingAtPresent, String isThisCurrentOccupation, 
										String occupationCountry,int employmentCount) {
	
		YesNo workedPastFiveYears=new YesNo(driver, "applicant.workedPastFiveYears");
		if(workedInPast5Years.equalsIgnoreCase("Yes"))
		{
			workedPastFiveYears.yes();
			
			YesNo currentlyWorking=new YesNo(driver, "applicant.currentlyWorking");
			if(workingAtPresent.equalsIgnoreCase("yes"))
			{
				currentlyWorking.yes();
				
				for(int i=0;i<employmentCount;i++)
				{
				Employment infoAboutEmployer=new Employment(driver);
				infoAboutEmployer.employmentInformation("applicant.emplHistoryCurrent["+i+"]", "i129f", 
																	isThisCurrentOccupation, occupationCountry);
				
					if (i < employmentCount - 1) {
						CommonInputClasses addAnotherWork=new CommonInputClasses(driver);
						addAnotherWork.addAnother();
					}
				}
				
			}
			else if(workingAtPresent.equalsIgnoreCase("no"))
			{
				currentlyWorking.no();
			}
			
			
		}
		else if(workedInPast5Years.equalsIgnoreCase("No"))
		{
			workedPastFiveYears.no();
		}
		
		saveScreenShot("i129f", "SQ1_10"); clickContinueInSQ();
		return this;
	}
}

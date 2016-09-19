package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.Employment;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;


public class SQ2_11 extends WizardPage {

	public SQ2_11(WebDriver driver) {
		super(driver);
	}

	public SQ2_11 fianceEmploymentPart1(Properties data,String workedInPast5Years, String workingAtPresent, String isThisCurrentOccupation, 
										String occupationCountry,int employmentCount) {
	
		YesNo workedPastFiveYears=new YesNo(driver, "foreignFiance.workedPastFiveYears");
		if(workedInPast5Years.equalsIgnoreCase("Yes"))
		{
			workedPastFiveYears.yes();
			
			YesNo currentlyWorking=new YesNo(driver, "foreignFiance.currentlyWorking");
			if(workingAtPresent.equalsIgnoreCase("yes"))
			{
				currentlyWorking.yes();
				
				for(int i=0;i<employmentCount;i++)
				{
				Employment infoAboutEmployer=new Employment(driver);
				infoAboutEmployer.employmentInformation("foreignFiance.emplHistoryWithCurrent["+i+"]", "i129f", 
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
		
		saveScreenShot("i129f", "SQ2_11"); clickContinueInSQ();
		return this;
	}
}

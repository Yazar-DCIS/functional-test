package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Employment;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ4_11 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ4_11 extends WizardPage {

	private YesNo workedPastFiveYears;
	private MultiRadioOptions employmentInfo;
	
	public SQ4_11(WebDriver driver) {
		super(driver);
	}

	public SQ4_11 employmentDetails(String workedDuringLast5years,String employmentCategory,
			int employmentCount,String currentOccupation,String occupationCountry) {
		
		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		String appname=Products.I130I485.name().toLowerCase();
		
		if(workedDuringLast5years.equalsIgnoreCase("Yes")||workedDuringLast5years.equalsIgnoreCase("no"))
		{
		
		Employment otherEmploymentInfo=new Employment(driver,"applicationData-applicant.employmentInfo");
				
		workedPastFiveYears = new YesNo(driver,	"applicant.employmentInfo.workedPastFiveYears");
		workedPastFiveYears.setYesOrNo(workedDuringLast5years);
				
		employmentInfo = new MultiRadioOptions(driver,
				"applicationData-applicant.employmentInfo.statement");
		if(employmentCategory.equalsIgnoreCase("employed"))
		{
			employmentInfo.selectOption(1);
			
			for(int i=0;i<employmentCount;i++)
			{
			Employment employmentInfo=new Employment(driver);
			employmentInfo.employmentInformation("applicant.employmentInfo.usEmployment"+"["+i+"]", appname, 
													currentOccupation,occupationCountry);
			
			if (i < employmentCount - 1) {
				CommonInputClasses addAnotherEmployment=new CommonInputClasses(driver);
				addAnotherEmployment.addAnother();
			}
			
			}
			
		}
		
		
		else if(employmentCategory.equalsIgnoreCase("selfemployed"))
		{
			employmentInfo.selectOption(2);
			
			otherEmploymentInfo.setSelfEmployerInfo(i130i485.getProperty("applicant.employmentInfo.selfemployedAs"));
			
		}
		else if(employmentCategory.equalsIgnoreCase("retired"))
		{
			employmentInfo.selectOption(3);
			
			otherEmploymentInfo.setRetiredEmployerInfo(i130i485.getProperty("applicant.employmentInfo.retiredFrom"));
			
			DateTag retiredDate=new DateTag(driver, "applicant.employmentInfo.retiredSince");
			retiredDate.selectDate(i130i485.getProperty("applicant.employmentInfo.retiredSince"));
			
		}
		else if(employmentCategory.equalsIgnoreCase("unemployed"))
		{
			employmentInfo.selectOption(4);
			
			DateTag unemployedSinceDate=new DateTag(driver, "applicant.employmentInfo.unemployedSince");
			unemployedSinceDate.selectDate(i130i485.getProperty("applicant.employmentInfo.unemployedSince"));
		}
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
	
		return this;
	}

}

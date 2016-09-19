package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Employment;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ1_10_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_10_1 extends WizardPage {

	public SQ1_10_1(WebDriver driver) {
		super(driver);
	}

	public SQ1_10_1 employmentHistoryRecent(int employmentCount,String empCountry) {
		
		PropertyResource propertyFile=new PropertyResource();
		Properties data = propertyFile.loadProperty("i129f");
		if(employmentCount!=0)
		{
			for(int i=0;i<employmentCount;i++)
			{
				Employment infoAboutEmployer=new Employment(driver,"applicationData-applicant.emplHistoryRecent["+i+"]");
				infoAboutEmployer.setEmployerName(data.getProperty("applicant.emplHistoryRecent.employerName"));
				infoAboutEmployer.setEmployerOccupation(data.getProperty("applicant.emplHistoryRecent.empOccupation"));
				
				Address employerAddress=new Address(driver);
				employerAddress.setAddress("i129f", "applicant.emplHistoryRecent["+i+"].employerAddress", empCountry);
				
				DateTag employFromDate=new DateTag(driver, "applicant.emplHistoryRecent["+i+"].dateRange.fromDate");
				employFromDate.selectDate(data.getProperty("emplHistoryRecent.dateRange.fromDate"));
				
				DateTag employToDate=new DateTag(driver, "applicant.emplHistoryRecent["+i+"].dateRange.toDate");
				employToDate.selectDate(data.getProperty("emplHistoryRecent.dateRange.toDate"));
			
				
				if (i < employmentCount - 1) {
					CommonInputClasses addAnotherWork=new CommonInputClasses(driver);
					addAnotherWork.addAnother();
				}
			}
		saveScreenShot("i129f", "SQ1_10_1"); clickContinueInSQ();
		}
		return this;
	}
}

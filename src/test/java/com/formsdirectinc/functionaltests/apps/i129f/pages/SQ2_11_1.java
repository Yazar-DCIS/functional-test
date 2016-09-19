package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Employment;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_11_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_11_1 extends WizardPage {



	public SQ2_11_1(WebDriver driver) {
		super(driver);
	}

	public SQ2_11_1 fianceEmploymentPart2(Properties data, int empCount, String occupationCountry) {
		
		if(empCount!=0)
		{
		for (int i = 0; i < empCount; i++) {
			
			Employment infoAboutEmployer=new Employment(driver,"applicationData-foreignFiance.emplHistoryRecent["+i+"]");
			infoAboutEmployer.setEmployerName(data.getProperty("foreignFiance.emplHistoryRecent.employerName"));
			infoAboutEmployer.setEmployerOccupation(data.getProperty("foreignFiance.emplHistoryRecent.empOccupation"));
			
			Address employerAddress=new Address(driver);
			employerAddress.setAddress("i129f", "foreignFiance.emplHistoryRecent["+i+"].employerAddress", occupationCountry);
			
			DateTag employFromDate=new DateTag(driver, "foreignFiance.emplHistoryRecent["+i+"].dateRange.fromDate");
			employFromDate.selectDate(data.getProperty("foreignFiance.emplHistoryRecent.dateRange.fromDate"));
			
			DateTag employToDate=new DateTag(driver, "foreignFiance.emplHistoryRecent["+i+"].dateRange.toDate");
			employToDate.selectDate(data.getProperty("foreignFiance.emplHistoryRecent.dateRange.toDate"));
		
			
			if (i < empCount - 1) {
				CommonInputClasses addAnotherWork=new CommonInputClasses(driver);
				addAnotherWork.addAnother();
			}
		}
			saveScreenShot("i129f", "SQ2_11_1"); clickContinueInSQ();
		}
		return this;
	}
}

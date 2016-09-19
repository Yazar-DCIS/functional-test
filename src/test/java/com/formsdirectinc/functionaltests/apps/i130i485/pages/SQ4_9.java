package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MaritalInfo;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ4_9 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ4_9 extends WizardPage {

	private DateTag dateOfMarriage;
	private YesNo alreadyMarried;
	private MaritalInfo placeMarried;

	public SQ4_9(WebDriver driver) {
		super(driver);
	}

	public SQ4_9 applicantMarriageInfo(String applicantAlreadyMarried) {
		
		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		if(applicantAlreadyMarried.equalsIgnoreCase("Yes")||applicantAlreadyMarried.equalsIgnoreCase("no"))
		{
		
		dateOfMarriage =new DateTag(driver, "applicant.dateMarried");
		dateOfMarriage.selectDate(i130i485.getProperty("applicant.dateMarried"));
		
		placeMarried=new MaritalInfo(driver, "applicant");
		placeMarried.setPlaceOfMarriage(i130i485.getProperty("applicant.placeMarried"));
		
		alreadyMarried=new YesNo(driver, "applicant.marriedBefore");
		alreadyMarried.setYesOrNo(applicantAlreadyMarried);
		
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

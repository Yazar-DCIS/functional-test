package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * Page model for SQ4_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_3 extends WizardPage {

	private YesNo livedAnyWhereElse,residedMoreThanAYear;

	public SQ4_3(WebDriver driver) {
		super(driver);
	}

	public SQ4_3 residenceInformation(String livedInsideUS,String livedMoreThanAYear,String countryLived) {

		PropertyResource propertyFile = new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		String appname = Products.I130I485.name().toLowerCase();
		if(livedInsideUS.equalsIgnoreCase("no")||livedInsideUS.equalsIgnoreCase("yes"))
		{
		
		livedAnyWhereElse = new YesNo(driver, "applicant.livedInsideUS");
		
		if(livedInsideUS.equalsIgnoreCase("no"))
		{
			livedAnyWhereElse.yes();
			
			residedMoreThanAYear = new YesNo(driver, "applicant.livedOutsideUS");
								
			if(livedMoreThanAYear.equalsIgnoreCase("yes"))
			{
				residedMoreThanAYear.yes();
				
				Address otherAddress = new Address(driver);
				otherAddress.setAddress(appname, "applicant.lastAddressOutsideUS",countryLived);
				
				DateTag residenceDates = new DateTag(driver,"applicant.dateOutsideUS");
				residenceDates.setStartMonth(i130i485.getProperty("applicant.dateOutsideUS.fromMonth"));
				residenceDates.setStartYear(i130i485.getProperty("applicant.dateOutsideUS.fromYear"));
				residenceDates.setEndMonth("applicant.dateOutsideUS.toMonth");
				residenceDates.setEndYear("applicant.dateOutsideUS.toYear");
				
				
			}
			else if(livedMoreThanAYear.equalsIgnoreCase("no"))
			{
				residedMoreThanAYear.no();
			}
			
		}
		else if(livedInsideUS.equalsIgnoreCase("yes"))
		{
			livedAnyWhereElse.no();
		}
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

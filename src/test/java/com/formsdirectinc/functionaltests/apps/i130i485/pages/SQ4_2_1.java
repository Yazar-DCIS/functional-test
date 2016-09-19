package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * Page model for SQ4_2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_2_1 extends WizardPage {

	private DateTag fromDate, toDate;
	
	public SQ4_2_1(WebDriver driver) {
		super(driver);
	}

	public SQ4_2_1 otherAddressDetails(int count,String country) {
		
		//Address
		PropertyResource propertyFile = new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		String appname = Products.I130I485.name().toLowerCase();
		if(count>0)
		{
			for(int i=0;i<count;i++)
			{
				
			Address otherAddress = new Address(driver);
			otherAddress.setAddress(appname, "applicant.residence["+i+"].address", country);
				
			fromDate = new DateTag(driver,
					"applicant.residence["+i+"].dateRange.fromDate");
			fromDate.selectDate(i130i485.getProperty("applicant.residence["+i+"].dateRange.fromDate"));
			
			toDate = new DateTag(driver, "applicant.residence["+i+"].dateRange.toDate");
			toDate.selectDate(i130i485.getProperty("applicant.residence["+i+"].dateRange.toDate"));
	
			if (i < count - 1) {
				CommonInputClasses otherAddresses = new CommonInputClasses(
						driver);
				otherAddresses.addAnother();
			}
			}
			saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

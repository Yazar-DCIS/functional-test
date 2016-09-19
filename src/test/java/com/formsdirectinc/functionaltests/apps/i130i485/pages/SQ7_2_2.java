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
 * Page model for SQ7_2_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ7_2_2 extends WizardPage {

	
	public SQ7_2_2(WebDriver driver) {
		super(driver);
	}

	public SQ7_2_2 relativeOtherAddressDetails(String country,int addressCount) {
		
		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		String appname=Products.I130I485.name().toLowerCase();
		if(addressCount>0)
		{
			for(int i=0;i<addressCount;i++)
			{
				Address relativeAddress=new Address(driver);
				relativeAddress.setAddress(appname, "foreignRelative.residence["+i+"].address",country);
				
				DateTag fromDateLivedTogether = new DateTag(driver,	"foreignRelative.residence["+i+"].dateRange");
				fromDateLivedTogether.selectDate(i130i485.getProperty("foreignRelative.residence["+i+"].dateRange.fromDate"));
				
				DateTag toDateLivedTogether = new DateTag(driver,"foreignRelative.residence["+i+"].dateRange.toDate");
				toDateLivedTogether.selectDate(i130i485.getProperty("foreignRelative.residence["+i+"].dateRange.toDate"));
	
			
			if (i < addressCount - 1) {
				CommonInputClasses addAnotherAddress=new CommonInputClasses(driver);
				addAnotherAddress.addAnother();
			}
			
			}
			saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

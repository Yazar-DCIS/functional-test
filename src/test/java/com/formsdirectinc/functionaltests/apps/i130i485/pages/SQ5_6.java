package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.TaxDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ5_6 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ5_6 extends WizardPage {

	
	public SQ5_6(WebDriver driver) {
		super(driver);
	}

	public SQ5_6 assetDetails() {

		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		
		TaxDetails assetInformation=new TaxDetails(driver, "applicationData-applicant.sponsorInfo.assetValue");
		assetInformation.setSavings(i130i485.getProperty("applicant.sponsorInfo.assetValue.savings"));
		assetInformation.setValueOfEstate(i130i485.getProperty("applicant.sponsorInfo.assetValue.valueOfEstate"));
		assetInformation.setValueOfStock(i130i485.getProperty("applicant.sponsorInfo.assetValue.valueOfStock"));
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		
		return this;
	}

}

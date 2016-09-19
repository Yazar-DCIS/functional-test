package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.TaxDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ5_7 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ5_7 extends WizardPage {

	private YesNo contributions;

	public SQ5_7(WebDriver driver) {
		super(driver);
	}

	public SQ5_7 relativePlanToContributions(String planToContribute) {

		if(planToContribute.equalsIgnoreCase("Yes")||planToContribute.equalsIgnoreCase("no"))
		{
		contributions = new YesNo(driver,"applicant.sponsorInfo.planToContribute");
		if(planToContribute.equalsIgnoreCase("Yes"))
		{
			contributions.yes();
			PropertyResource propertyFile=new PropertyResource();
			Properties i130i485 = propertyFile.loadProperty("i130i485");
			
			TaxDetails assetInformation=new TaxDetails(driver, "applicationData-applicant.sponsorInfo.relativeAssetValue");
			assetInformation.setSavings(i130i485.getProperty("applicant.sponsorInfo.relativeAssetValue.savings"));
			assetInformation.setValueOfEstate(i130i485.getProperty("applicant.sponsorInfo.relativeAssetValue.valueOfEstate"));
			assetInformation.setValueOfStock(i130i485.getProperty("applicant.sponsorInfo.relativeAssetValue.valueOfStock"));
		}
		else if(planToContribute.equalsIgnoreCase("No"))
		{
			contributions.no();
		}
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
	
		
		return this;
	}

}

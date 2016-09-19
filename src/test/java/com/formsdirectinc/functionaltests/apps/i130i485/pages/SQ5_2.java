package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.TaxDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ5_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ5_2 extends WizardPage {

	private TaxDetails sponsorIncome;

	public SQ5_2(WebDriver driver) {
		super(driver);
	}

	public SQ5_2 sponsorCurrentIncome() {

		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		sponsorIncome = new TaxDetails(driver,"applicationData-applicant.sponsorInfo");
		sponsorIncome.setCurrentAnnualIncome(i130i485.getProperty("applicant.sponsorInfo.currentAnnualIncome"));
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}

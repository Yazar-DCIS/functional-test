package com.formsdirectinc.functionaltests.apps.i824.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ5_2 Details
 * @author:Orina<br> Revision: $Rev$
 */



public class SQ5_2 extends WizardPage {

	
	

	private AdditionalInfoFields initialApplication;

	public SQ5_2(WebDriver driver) {
		super(driver);

	}

	public void receiptTypeAndNumber(Properties data) {

		initialApplication = new AdditionalInfoFields(driver,

		"applicationData-petitionInfo.receiptNumber.name");
		initialApplication.selectDDM(data.getProperty("receiptType"));
		initialApplication = new AdditionalInfoFields(driver,

		"applicationData-petitionInfo.receiptNumber.number");
		initialApplication.normalText(data.getProperty("Phone2"));
	}

}

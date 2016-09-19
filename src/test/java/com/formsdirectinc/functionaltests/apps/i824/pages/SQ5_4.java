package com.formsdirectinc.functionaltests.apps.i824.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ5_4 Details
 * @author:Orina<br> Revision: $Rev$
 */



public class SQ5_4 extends WizardPage {

	
	

	private AdditionalInfoFields initialApplication;

	public SQ5_4(WebDriver driver) {
		super(driver);

	}

	public void uscisOffice(Properties data) {

		initialApplication = new AdditionalInfoFields(driver,
				"applicationData-petitionInfo.officeUSCIS");
		initialApplication.selectDDM(data.getProperty("USCIS_Office"));

	}

}

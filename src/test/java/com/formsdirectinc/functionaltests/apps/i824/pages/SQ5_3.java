package com.formsdirectinc.functionaltests.apps.i824.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ5_3 Details
 * @author:Orina<br> Revision: $Rev$
 */



public class SQ5_3 extends WizardPage {

	
	

	private DateTag initialApplication;

	public SQ5_3(WebDriver driver) {
		super(driver);

	}

	public void dateOfFilling(Properties data) {

		initialApplication = new DateTag(driver, "petitionInfo.dateOfFiling");
		initialApplication.selectDate(data.getProperty("DOA"));
	}

}

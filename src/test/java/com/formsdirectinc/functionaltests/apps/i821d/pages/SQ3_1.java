package com.formsdirectinc.functionaltests.apps.i821d.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ3_1 extends WizardPage {

	private DateTag dateEnteredInUS;
	private AdditionalInfoFields entryDetails;
	private Sites site;

	public SQ3_1(WebDriver driver) {
		super(driver);
	}

	public SQ3_1 entryIntoUS(Properties data,String displayControls) throws Exception {
		site = Sites.valueOf(System.getProperty("site.name"));

		if(displayControls.equalsIgnoreCase("yes"))
		{
			dateEnteredInUS = new DateTag(driver,
					"initialApplication.intialEnterUS");
			dateEnteredInUS.selectDateAsSingle(data.getProperty("DateEntered1"));
	
			entryDetails = new AdditionalInfoFields(driver,
					"applicationData-initialApplication.placeOfEntry");
			entryDetails.normalText(data.getProperty("City"));
	
			if ((site == Sites.USC)) {
				entryDetails = new AdditionalInfoFields(driver,
						"applicationData-initialApplication.statusOfEntry");
				entryDetails.normalText(data.getProperty("City"));
			}
		}
		
		dateEnteredInUS = new DateTag(driver, "applicant.lastEnterUS");
		dateEnteredInUS.selectDateAsSingle(data.getProperty("DateEntered"));

		entryDetails = new AdditionalInfoFields(driver,
				"applicationData-applicant.placeOfLastEntry");
		entryDetails.normalText(data.getProperty("City"));

		entryDetails = new AdditionalInfoFields(driver,
				"applicationData-applicant.mannerOfLastEntry");
		entryDetails.normalText(data.getProperty("City"));

		return this;

	}

}

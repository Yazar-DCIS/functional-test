package com.formsdirectinc.functionaltests.apps.i765.pages;

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

	private DateTag employmentDates;
	private AdditionalInfoFields entryStatus;

	public SQ3_1(WebDriver driver) {
		super(driver);
	}

	public SQ3_1 lastEntryDetails(Properties data) throws Exception {
		
		
		Sites site = Sites.valueOf(System.getProperty("site.name"));
		employmentDates = new DateTag(driver,
				"applicant.entryDetails.dateOfEntry");
		employmentDates.selectDate(data.getProperty("DOA"));

		entryStatus = new AdditionalInfoFields(driver,
				"applicationData-formSpecific.placeOfLastEntry");
		if(site==Sites.AIC||site==Sites.FR||site==Sites.DUS)
		{
			entryStatus.normalText(data.getProperty("entryPlaceI765"));
		}
		else
		{
			entryStatus.selectDDM(data.getProperty("entryPlaceI765"));
		}
		
		entryStatus = new AdditionalInfoFields(driver,
				"formSpecific.mannerEnteredUs");
		entryStatus.selectDDM(data.getProperty("currentImmigrationStatus"));

		entryStatus = new AdditionalInfoFields(driver,
				"formSpecific.currentImmigrationStatus");
		entryStatus.selectDDM(data.getProperty("currentImmigrationStatus"));

		saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInSQ();

		return this;
	}

}

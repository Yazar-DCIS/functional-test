package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.newtags.WizardPage;
/**
 * I-90: personal Information
 * @author Orina
 * Revision: $Rev$
 */


public class SQ1_1_3 extends WizardPage {

	private Address countryOfBirth;
	private DateTag dateOfBirth;

	public SQ1_1_3(WebDriver driver) {
		super(driver);
	}

	public SQ1_1_3 personalInfo(Properties data) {

		dateOfBirth = new DateTag(driver, "applicant.birth.dateOfBirth");
		dateOfBirth.selectDate(data.getProperty("applicant.birth.dateOfBirth"));

		countryOfBirth = new Address(driver,
				"applicationData-applicant.birth.countryOfBirth");
		countryOfBirth.setCountry(data.getProperty("applicant.birth.countryOfBirth"));
		driver.findElement(By.id("applicationData-applicant.birth.cityOfBirth"))
				.sendKeys(data.getProperty("applicant.birth.cityOfBirth"));

		saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Next");

		return this;
	}
}

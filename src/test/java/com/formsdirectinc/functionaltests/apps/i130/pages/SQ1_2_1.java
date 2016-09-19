package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_2_1 extends WizardPage {
	private DateTag date;
	private Address address;

	@FindBy(how = How.ID, using = "")
	WebElement elementAptNum;

	public SQ1_2_1(WebDriver driver) {
		super(driver);

	}

	public void applicantAddress(Properties data, String residentialYears) {

		address = new Address(driver,
				"applicationData-applicant.currentAddress");
		address.setStreet(data.getProperty("StreetName"));
		address.setCity(data.getProperty("City"));
		address.setState(data.getProperty("State"));
		address.setZipcode(data.getProperty("Zipcode"));

		date = new DateTag(driver, "applicant.dateFrom");

		if (residentialYears.equalsIgnoreCase("lessThan5YearsFromNow")) {
			date.selectDateAsSingle(data.getProperty("lessThan5Years"));
		} else if (residentialYears
				.equalsIgnoreCase("greaterThan5YearsFromNow")) {
			date.selectDateAsSingle(data.getProperty("greaterThan5Years"));
		}
		saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
	}

}

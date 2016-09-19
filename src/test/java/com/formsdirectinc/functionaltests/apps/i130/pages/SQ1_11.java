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
 * Page model for SQ1_11 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_11 extends WizardPage {

	private DateTag lpr_date;
	private Address lpr_City;

	@FindBy(how = How.ID, using = "applicationData-applicant.classOfAdmission")
	WebElement lpr_placeAdmitted;

	public SQ1_11(WebDriver driver) {
		super(driver);

	}

	public SQ1_11 applicantImmigrationStatus_PermanentResident(Properties data,
			String visitPage) {

		if (visitPage.equalsIgnoreCase("yes")) {
			set_LPR_Date(data);
			set_LPR_City(data);
			set_ClassAdmittedasLPR(data);
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

	public void set_LPR_Date(Properties data) {
		lpr_date = new DateTag(driver, "applicant.dateBecomingLPR");
		lpr_date.selectMonth(data.getProperty("I130_DOB_Month"));
		lpr_date.selectDay(data.getProperty("DOB_Day"));
		lpr_date.selectYear(data.getProperty("I130_DOB_Year"));
	}

	public void set_LPR_City(Properties data) {
		lpr_City = new Address(driver,
				"applicationData-applicant.placeAdmittedasLPR");
		lpr_City.setCity(data.getProperty("City"));
		lpr_City.setState(data.getProperty("State"));

	}

	public void set_ClassAdmittedasLPR(Properties data) {

		lpr_placeAdmitted.sendKeys(data.getProperty("I130_PlaceOfAdmitted"));

	}

}

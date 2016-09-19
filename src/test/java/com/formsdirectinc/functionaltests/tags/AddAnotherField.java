package com.formsdirectinc.functionaltests.tags;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Class for Adding more Names,Address, Dates etc
 * 
 * @author:Orina<br> Revision: $Rev$
 */
public class AddAnotherField extends WizardPage {

	String addAnotherExpression = "//a[contains(text(),'ADD ANOTHER')]";
	WebElement addAnotherField;

	public AddAnotherField(WebDriver driver) {
		super(driver);

	}

	public AddAnotherField addAnother() {

		addAnotherField = driver.findElement(By.xpath(addAnotherExpression));
		addAnotherField.click();

		return this;
	}

	public AddAnotherField addAnotherTrip(int count, Properties data, String id) {

		for (int i = 0; i < count; i++) {

			DateTag dateLeftAndReturned = new DateTag(driver, id
					+ ".travelHistory.travel[" + i
					+ "].dateLeftAndReturned.fromDate");
			dateLeftAndReturned.selectDateAsSingle(data
					.getProperty("fromDateDaca"));

			dateLeftAndReturned = new DateTag(driver, id
					+ ".travelHistory.travel[" + i
					+ "].dateLeftAndReturned.toDate");
			dateLeftAndReturned.selectDateAsSingle(data
					.getProperty("fromDateDaca"));

			OtherExplain reasonforthetrip = new OtherExplain(driver,
					"applicationData", id + ".travelHistory.travel[" + i
							+ "].reasonForTrip");
			reasonforthetrip.setOtherTrip(data.getProperty("Reason" + i));

			if (i < count - 1) {
				addAnother();
			}
		}
		return this;
	}

	public AddAnotherField addAnotherAddress(int count, Properties data,
			String id) {
		for (int i = 0; i < count; i++) {

			Address applicantAddress = new Address(driver, "applicationData-"
					+ id + ".residentialHistory[" + i + "]");
			applicantAddress.setStreet(data.getProperty("StreetName"));
			applicantAddress.setCity(data.getProperty("City"));
			applicantAddress.setState(data.getProperty("State"));
			applicantAddress.setZipcode(data.getProperty("Zipcode"));
			DateTag fromDate = new DateTag(driver, id + ".residentialHistory["
					+ i + "].dateLeftAndReturned.fromDate");
			fromDate.selectDateAsSingle(data.getProperty("DateEntered"));
			DateTag toDate = new DateTag(driver, id + ".residentialHistory["
					+ i + "].dateLeftAndReturned.toDate");
			toDate.selectDateAsSingle(data.getProperty("DateEntered"));

			if (i < count - 1) {
				addAnother();
			}
		}
		return this;
	}

	public AddAnotherField addAnotherSSN(int count, Properties data, String id) {
		for (int i = 0; i < count; i++) {

			Numbers addAnotherSSN = new Numbers(driver, id
					+ ".socialSecurityNumber[" + i + "].ssnNum");
			addAnotherSSN.setSocialSecurityNumber(data.getProperty("SSN_1"),
					data.getProperty("SSN_2"), data.getProperty("SSN_3"));

			if (i < count - 1) {

				addAnother();
			}
		}
		return this;
	}

	public AddAnotherField addAnotherEAD(int count, Properties data, String id) {

		for (int i = 0; i < count; i++) {

			AdditionalInfoFields uscisOffice = new AdditionalInfoFields(driver,
					"applicationData-" + id + ".workAuthorization[" + i
							+ "].USCISOfficeApplied");
			uscisOffice.normalText(data.getProperty("State"));

			DateTag dateOfApply = new DateTag(driver, id
					+ ".workAuthorization[" + i + "].dateApplied");
			dateOfApply.selectDate(data.getProperty("DOB"));

			MultiRadioOptions eadResult = new MultiRadioOptions(driver,
					"applicationData-" + id + ".workAuthorization[" + i
							+ "].resultOfApplication");
			eadResult.selectOption(1);

			if (i < count - 1) {

				addAnother();
			}
		}

		return this;
	}

	public AddAnotherField AddAnotherPriorEAD(double count, Properties data,
			String id) {
		for (int i = 0; i < count; i++) {

			AdditionalInfoFields priorUscisOffice = new AdditionalInfoFields(
					driver, "applicationData-" + id
							+ ".priorEmploymentAuthorization[" + i
							+ "].uscisOffice");
			priorUscisOffice.selectDDM(data.getProperty("I765_USCISOffice"));

			DateTag priorEadDate = new DateTag(driver, id
					+ ".priorEmploymentAuthorization[" + i + "].dateApplied");
			priorEadDate.selectDate(data
					.getProperty("I765_EADCardExpirationDate"));

			MultiRadioOptions priorResults = new MultiRadioOptions(driver,
					"applicationData-" + id + ".priorEmploymentAuthorization["
							+ i + "].applicationResultant");
			priorResults.selectOption(1);

			if (i < count - 1) {
				addAnother();
			}

		}
		return this;

	}

}

package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CheckBox;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_2 extends WizardPage {

	private CommonInputClasses selectAddress;
	private Country countryName;
	private DateTag fromDate, toDate;
	private CheckBox presentAddress;
	private YesNo inCare;
	private AdditionalInfoFields careOfName;

	public SQ2_2(WebDriver driver) {
		super(driver);
	}

	public SQ2_2 fianceOtherAddress(Properties data, String inCareOf,
			String homeAddresscountry, int count, String currentAddress ,String livedDate) {

		countryName = new Country(driver,
				"applicationData-foreignFiance.homeAddressInCareOf");
		selectAddress = new CommonInputClasses(driver);

		if (homeAddresscountry.equalsIgnoreCase("USA")) {
			countryName.setCountry(data.getProperty("I134_USA"));
			selectAddress.applicantAddressDetails(
					"applicationData-foreignFiance.homeAddressInCareOf", data);
		}
		else if (homeAddresscountry.equalsIgnoreCase("OutSideUSA")) {
			countryName.setCountry(data.getProperty("I134_Country"));
			selectAddress.applicantOtherAddressDetails(
					"applicationData-foreignFiance.homeAddressInCareOf", data);
		}

		inCare = new YesNo(driver,
				"foreignFiance.homeAddressInCareOf.hasInCareOfAgent");
		if (inCareOf.equalsIgnoreCase("Yes")) {
			inCare.yes();
			careOfName = new AdditionalInfoFields(driver,
					"applicationData-foreignFiance.homeAddressInCareOf.inCareOfAgentName");
			careOfName.normalText(data.getProperty("CareOfName"));
		}
		else if (inCareOf.equalsIgnoreCase("No")) {
			inCare.no();
		}
		for (int i = 0; i < count; i++) {
			countryName = new Country(driver,
					"applicationData-foreignFiance.residentialHistory[" + i
							+ "].address");
			selectAddress = new CommonInputClasses(driver);

			if (homeAddresscountry.equalsIgnoreCase("USA")) {

				countryName.setCountry(data.getProperty("I134_USA"));
				selectAddress.applicantAddressDetails(
						"applicationData-foreignFiance.residentialHistory[" + i
								+ "].address", data);
			}
			else if (homeAddresscountry.equalsIgnoreCase("OutSideUSA")) {

				countryName.setCountry(data.getProperty("I134_Country"));
				selectAddress.applicantOtherAddressDetails(
						"applicationData-foreignFiance.residentialHistory[" + i
								+ "].address", data);
			}

			presentAddress = new CheckBox(driver,
					"foreignFiance.residentialHistory[" + i + "]-checkbox");

			if (currentAddress.equalsIgnoreCase("Yes")) {
				presentAddress.check();
				fromDate = new DateTag(driver,
						"foreignFiance.residentialHistory[" + i
								+ "].dateRange.fromDate");
				fromDate.selectDate(data.getProperty(livedDate+"fromDate"));
				}

			else if (currentAddress.equalsIgnoreCase("No")) {
				fromDate = new DateTag(driver,
						"foreignFiance.residentialHistory[" + i
								+ "].dateRange.fromDate");
				fromDate.selectDate(data.getProperty(livedDate+"fromDate"));

				toDate = new DateTag(driver,
						"foreignFiance.residentialHistory[" + i
								+ "].dateRange.toDate");
				toDate.selectDate(data.getProperty(livedDate+"toDate"));
			}

			if (i < count - 1) {
				selectAddress.addAnotherAddress();
			}

		}
		saveScreenShot("i129f", "SQ2_2"); clickContinueInSQ();
		return this;
	}

	
}

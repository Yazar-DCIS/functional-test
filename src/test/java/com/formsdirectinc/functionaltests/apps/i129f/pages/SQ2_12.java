package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_12 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_12 extends WizardPage {

	private YesNo workStatus, currentOccup;
	private AdditionalInfoFields empName, empOccupation;
	private Address selectCountry;
	private DateTag workedFrom, workedTo;
	private CommonInputClasses selectAddress;

	public SQ2_12(WebDriver driver) {
		super(driver);
	}

	public SQ2_12 fianceFmploymentAbroad(Properties data,
			String fianceWorkedAbroad, String currentOccupation) {
		if (!fianceWorkedAbroad.equalsIgnoreCase("NA")) {
			workStatus = new YesNo(driver, "foreignFiance.everWorkedAbroad");
			if (fianceWorkedAbroad.equalsIgnoreCase("Yes")) {
				workStatus.yes();

				empName = new AdditionalInfoFields(driver,
						"applicationData-foreignFiance.emplDetailsAbroad.employerName");
				empName.normalText(data.getProperty("I134_EmployerName"));

				selectCountry = new Address(driver,
						"applicationData-foreignFiance.emplDetailsAbroad.employerAddress.country");
				selectCountry.setCountryDropDown(data
						.getProperty("I134_Country"));

				selectAddress = new CommonInputClasses(driver);
				selectAddress
						.applicantOtherAddressDetails(
								"applicationData-foreignFiance.emplDetailsAbroad.employerAddress",
								data);

				empOccupation = new AdditionalInfoFields(driver,

				"applicationData-foreignFiance.emplDetailsAbroad.occupation");
				empOccupation.normalText(data.getProperty("I134_Occupation"));

				currentOccup = new YesNo(driver,
						"foreignFiance.emplDetailsAbroad.presentJob");
				if (currentOccupation.equalsIgnoreCase("Yes")) {
					currentOccup.yes();
				}

				workedFrom = new DateTag(driver,
						"foreignFiance.emplDetailsAbroad.dateRange.fromDate");
				workedFrom.selectDate(data.getProperty("fromDate"));

				if (currentOccupation.equalsIgnoreCase("No")) {
					currentOccup.no();

					workedTo = new DateTag(driver,
							"foreignFiance.emplDetailsAbroad.dateRange.toDate");
					workedTo.selectDate(data.getProperty("toDate"));
				}

			}
			else if (fianceWorkedAbroad.equalsIgnoreCase("No")) {
				workStatus.no();
			}
			saveScreenShot("i129f", "SQ2_12"); clickContinueInSQ();
		}
		return this;
	}
}

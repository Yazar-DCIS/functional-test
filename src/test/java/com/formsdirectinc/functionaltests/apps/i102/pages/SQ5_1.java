package com.formsdirectinc.functionaltests.apps.i102.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ5_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ5_1 extends WizardPage {

	private YesNo immigrationViolations;
	private AdditionalInfoFields nameOfCourt;
	private DateTag dateOfProceedings;
	private Address proceedingLocation;
	private MultiRadioOptions typeOfProceeding;

	public SQ5_1(WebDriver driver) {
		super(driver);
	}

	public SQ5_1 notViolated(Properties data, String inRemovalProceedings,
			String proceedingType) {

		if (!(inRemovalProceedings.equalsIgnoreCase("skip"))) {

			immigrationViolations = new YesNo(driver,
					"processingInfo.inRemovalProceedings");

			nameOfCourt = new AdditionalInfoFields(driver,
					"applicationData-processingInfo.nameOfCourt");

			if (inRemovalProceedings.equalsIgnoreCase("Yes")) {
				immigrationViolations.yes();
				nameOfCourt.normalText(data.getProperty("StateAU"));

				proceedingLocation = new Address(driver,
						"applicationData-processingInfo.placeOfCourt");
				proceedingLocation.setCity(data.getProperty("City"));
				proceedingLocation.setState(data.getProperty("State"));

				dateOfProceedings = new DateTag(driver,
						"processingInfo.dateOfProceedings");
				dateOfProceedings.selectDate(data.getProperty("signDate"));

				typeOfProceeding = new MultiRadioOptions(driver,

				"applicationData-processingInfo.typeOfProceedings");

				if (proceedingType.equalsIgnoreCase("Removal")) {
					typeOfProceeding.selectOption(1);
				}
				else if (proceedingType.equalsIgnoreCase("Exclusion_Deportation")) {
					typeOfProceeding.selectOption(2);
				}
				else if (proceedingType.equalsIgnoreCase("Rescission")) {
					typeOfProceeding.selectOption(3);
				}
				else if (proceedingType.equalsIgnoreCase("Judicial_Proceedings ")) {
					typeOfProceeding.selectOption(4);
				}

			}
			else if (inRemovalProceedings.equalsIgnoreCase("No")) {
				immigrationViolations.no();
			}

			saveScreenShot("I102", "SQ5_1"); clickContinueInSQ();

		}

		return this;
	}

}

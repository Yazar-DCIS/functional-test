package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_19 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_19 extends WizardPage {

	private YesNo beenUnderImmigrationProceedings;
	private Address statusCity_State;
	private AdditionalInfoFields proceedingTime;
	private MultiRadioOptions proceedingType;

	public SQ4_19(WebDriver driver) {
		super(driver);

	}

	public SQ4_19 spouseImmigrationProceeding_Info(Properties data,
			String underImmigrationProceedings, String proceedingTypeIs) {

		if (!underImmigrationProceedings.equalsIgnoreCase("na")) {

			beenUnderImmigrationProceedings = new YesNo(driver,
					"spouseInfo.beenUnderImmigrationProceedings");
			if (underImmigrationProceedings.equalsIgnoreCase("Yes")) {
				beenUnderImmigrationProceedings.yes();

				statusCity_State = new Address(driver,
						"applicationData-spouseInfo.whereImmigrationProceedings");
				statusCity_State.setCity(data.getProperty("City"));

				statusCity_State.setState(data.getProperty("tripState"));

				proceedingTime = new AdditionalInfoFields(driver,
						"applicationData-spouseInfo.whenImmigrationProceedings");
				proceedingTime.normalText(data.getProperty("fromDate"));

				proceedingType = new MultiRadioOptions(driver,
						"applicationData-spouseInfo.typeOfProceedings");

				if (proceedingTypeIs.equalsIgnoreCase("Removal")) {
					proceedingType.selectOption(1);
				}
				else if (proceedingTypeIs.equalsIgnoreCase("Exclusion")) {
					proceedingType.selectOption(2);
				}
				else if (proceedingTypeIs.equalsIgnoreCase("Rescission")) {
					proceedingType.selectOption(3);
				}
				else if (proceedingTypeIs.equalsIgnoreCase("JudicialProceedings")) {
					proceedingType.selectOption(4);
				}

			}

			else if (underImmigrationProceedings.equalsIgnoreCase("no")) {
				beenUnderImmigrationProceedings.no();
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

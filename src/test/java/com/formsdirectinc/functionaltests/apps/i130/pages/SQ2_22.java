package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ2_22 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_22 extends WizardPage {

	private YesNo beenUnderImmigrationProceedings;
	private Address statusCity_State;
	private AdditionalInfoFields proceedingTime;
	private MultiRadioOptions proceedingType;

	public SQ2_22(WebDriver driver) {
		super(driver);

	}

	public SQ2_22 relativeImmigrationProceeding_Info(Properties data,
			String underImmigrationProceedings, String proceedingTypeIs) {

		if (!underImmigrationProceedings.equalsIgnoreCase("na")
				&& !proceedingTypeIs.equalsIgnoreCase("na")) {

			beenUnderImmigrationProceedings = new YesNo(driver,
					"relative.beenUnderImmigrationProceedings");
			if (underImmigrationProceedings.equalsIgnoreCase("Yes")) {
				beenUnderImmigrationProceedings.yes();

				statusCity_State = new Address(driver,
						"applicationData-relative.whereImmigrationProceedings");
				statusCity_State.setCity(data.getProperty("City"));

				statusCity_State.setState(data.getProperty("tripState"));

				proceedingTime = new AdditionalInfoFields(driver,
						"applicationData-relative.whenImmigrationProceedings");
				proceedingTime.normalText(data.getProperty("fromDate"));

				proceedingType = new MultiRadioOptions(driver,
						"applicationData-relative.typeOfProceedings");

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

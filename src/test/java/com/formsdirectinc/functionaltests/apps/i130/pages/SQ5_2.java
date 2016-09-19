package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ5_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ5_2 extends WizardPage {

	private YesNo applicantPriorPetitions;

	private Name_FirstMiddleLast priorPetitionerName;
	private MultiRadioOptions relationsOfFilling;

	public SQ5_2(WebDriver driver) {
		super(driver);

	}

	public SQ5_2 spouseSeperatePetitions_Info(String appliedPriorPetition,
			Properties data, String relationShipOfFilling, int count) {

		if (!appliedPriorPetition.equalsIgnoreCase("na")
				&& !relationShipOfFilling.equalsIgnoreCase("na") && count != -1) {

			applicantPriorPetitions = new YesNo(driver,
					"otherFilingInfo.separatePetitionsSubmitted");

			if (appliedPriorPetition.equalsIgnoreCase("Yes")) {
				applicantPriorPetitions.yes();

				if (count > 0) {
					for (int i = 0; i < count; i++) {

						priorPetitionerName = new Name_FirstMiddleLast(driver,
								"applicationData",

								"otherFilingInfo.relationDetails[" + i
										+ "].name");
						priorPetitionerName.setFirstNameField(data
								.getProperty("FirstName1"));
						priorPetitionerName.setMiddleNameField(data
								.getProperty("FirstName3"));
						priorPetitionerName.setLastNameField(data
								.getProperty("FirstName2"));

						relationsOfFilling = new MultiRadioOptions(driver,

						"applicationData-otherFilingInfo.relationDetails[" + i
								+ "].relationShip");

						if (relationShipOfFilling.equalsIgnoreCase("Parent")) {
							relationsOfFilling.selectOption(1);
						}
						else if (relationShipOfFilling.equalsIgnoreCase("Child")) {
							relationsOfFilling.selectOption(2);
						}
						else if (relationShipOfFilling.equalsIgnoreCase("Sibling")) {
							relationsOfFilling.selectOption(3);
						}

						if ((i < count - 1)) {
							CommonInputClasses others = new CommonInputClasses(
									driver);
							others.addAnother();
						}
					}

				}

			}

			else if (appliedPriorPetition.equalsIgnoreCase("No")) {
				applicantPriorPetitions.no();
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

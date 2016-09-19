package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_1 extends WizardPage {

	private YesNo applicantPriorPetitions, filledOnBehalf;
	private AdditionalInfoFields placeOfFilling;
	private Name_FirstMiddleLast priorPetitionerName;
	private DateTag priorPetitionerDateOfFilling;
	private MultiRadioOptions resultOfFilling;

	public SQ3_1(WebDriver driver) {
		super(driver);

	}

	public SQ3_1 applicantPriorPetitions_Info(String appliedPriorPetition,
			Properties data, String resultsOfFilling, String filledBehalf,
			int count) {

		if (!appliedPriorPetition.equalsIgnoreCase("na")
				&& !resultsOfFilling.equalsIgnoreCase("na")
				&& !filledBehalf.equalsIgnoreCase("na") && count != -1) {
			applicantPriorPetitions = new YesNo(driver, "otherInfo.filedI130");

			if (appliedPriorPetition.equalsIgnoreCase("Yes")) {
				applicantPriorPetitions.yes();

				if (count > 0) {
					for (int i = 0; i < count; i++) {

						priorPetitionerName = new Name_FirstMiddleLast(driver,
								"applicationData", "otherInfo.priorPetitions["
										+ i + "].name");
						priorPetitionerName.setFirstNameField(data
								.getProperty("FirstName1"));
						priorPetitionerName.setMiddleNameField(data
								.getProperty("FirstName3"));
						priorPetitionerName.setLastNameField(data
								.getProperty("FirstName2"));

						priorPetitionerDateOfFilling = new DateTag(driver,
								"otherInfo.priorPetitions[" + i
										+ "].dateOfFiling");
						priorPetitionerDateOfFilling.selectDate(data
								.getProperty("fromDate"));

						placeOfFilling = new AdditionalInfoFields(driver,

						"applicationData-otherInfo.priorPetitions[" + i
								+ "].placeOfFiling");
						placeOfFilling.normalText(data.getProperty("City"));

						resultOfFilling = new MultiRadioOptions(driver,

						"applicationData-otherInfo.priorPetitions[" + i
								+ "].resultOfFiling");

						if (resultsOfFilling.equalsIgnoreCase("Approved")) {
							resultOfFilling.selectOption(1);
						}
						else if (resultsOfFilling.equalsIgnoreCase("Denied")) {
							resultOfFilling.selectOption(2);
						}
						else if (resultsOfFilling.equalsIgnoreCase("Withdrawn")) {
							resultOfFilling.selectOption(3);
						}
						else if (resultsOfFilling.equalsIgnoreCase("Abandoned")) {
							resultOfFilling.selectOption(4);
						}
						else if (resultsOfFilling.equalsIgnoreCase("Pending")) {
							resultOfFilling.selectOption(5);

							filledOnBehalf = new YesNo(driver,
									"otherInfo.priorPetitions[" + i
											+ "].pendingFiled");

							if (filledBehalf.equalsIgnoreCase("Yes")) {
								filledOnBehalf.yes();
							}
							else if (filledBehalf.equalsIgnoreCase("no")) {
								filledOnBehalf.no();
							}

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

package com.formsdirectinc.functionaltests.apps.i130.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for FR_EQFlow Details
 * @author:Orina<br> Revision: $Rev$
 */
public class FR_EQFlow extends WizardPage {

	public MultiRadioOptions immigrantstatus, spouseLegalStatus,
			spouseLivingInUS, requirementToSponsor, filedI130,
			physicalPresence, livingInUS;
	public YesNo spouseInspected;

	public Sites site;

	public FR_EQFlow(WebDriver driver) {
		super(driver);

	}

	public FR_EQFlow immigratantPetition() {

		immigrantstatus = new MultiRadioOptions(driver,
				"applicationData-quiz.toSponsor");
		immigrantstatus.selectOption(1);
		saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();

		spouseLivingInUS = new MultiRadioOptions(driver,
				"applicationData-quiz.spouseInUS");
		spouseLivingInUS.selectOption(2);
		saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();

		requirementToSponsor = new MultiRadioOptions(driver,
				"applicationData-quiz.requirementToSponsor");
		requirementToSponsor.selectOption(1);
		saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();

		filedI130 = new MultiRadioOptions(driver,
				"applicationData-quiz.filedI130");
		filedI130.selectOption(2);
		saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();

		physicalPresence = new MultiRadioOptions(driver,
				"applicationData-quiz.presentAtWedding");
		physicalPresence.selectOption(1);
		saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();

		livingInUS = new MultiRadioOptions(driver,
				"applicationData-quiz.currentlyInUS");
		livingInUS.selectOption(1);
		saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInEQ();

		return this;
	}

}

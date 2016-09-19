package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for FR_EQFlow Details
 * @author:Orina<br> Revision: $Rev$
 */

public class FR_EQFlow extends WizardPage {

	public MultiRadioOptions immigrantstatus, spouseLegalStatus;
	public YesNo physicalPresence, livingInUS, spouseLivingInUS,
			spouseInspected;

	public Sites site;

	@FindBy(how = How.CSS, using = "span[class='button-text']")
	private WebElement continueBtn;

	public FR_EQFlow(WebDriver driver) {
		super(driver);

	}

	public FR_EQFlow sponserMySpouse() {

		immigrantstatus = new MultiRadioOptions(driver,
				"applicationData-quiz.bestApplies");
		immigrantstatus.selectOption(1);
		continueBtn.click();

		physicalPresence = new YesNo(driver,
				"quiz.bothPhysicallyPresentAtWedding");
		physicalPresence.yes();
		continueBtn.click();

		livingInUS = new YesNo(driver, "quiz.applicantCurrentlyLivingInUS");
		livingInUS.yes();
		continueBtn.click();

		spouseLivingInUS = new YesNo(driver, "quiz.spouseCurrentlyLivingInUS");
		spouseLivingInUS.yes();
		continueBtn.click();

		spouseInspected = new YesNo(driver, "quiz.spouseInspectedLastEntryUS");
		spouseInspected.yes();
		continueBtn.click();

		immigrantstatus = new MultiRadioOptions(driver,
				"applicationData-quiz.spouseLivingUSUnderLegalStatus");
		immigrantstatus.selectOption(1);
		continueBtn.click();

		return this;
	}

}

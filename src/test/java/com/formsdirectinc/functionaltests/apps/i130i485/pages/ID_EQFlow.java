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
 * Page model for ID_EQFlow Details
 * @author:Orina<br> Revision: $Rev$
 */


public class ID_EQFlow extends WizardPage {

	public MultiRadioOptions immigrantstatus, spouseLegalStatus,
			meetRequirements, currentlyInUS, spouseLivingInUS, spouseInspected,
			filedI130, presentAtWedding;
	public YesNo physicalPresence;

	public Sites site;

	@FindBy(how = How.CSS, using = "span[class='button-text']")
	private WebElement continueBtn;

	public ID_EQFlow(WebDriver driver) {
		super(driver);

	}

	public ID_EQFlow sponserMySpouse() {

		immigrantstatus = new MultiRadioOptions(driver,
				"applicationData-quiz.toSponsor");
		immigrantstatus.selectOption(1);
		continueBtn.click();

		spouseLivingInUS = new MultiRadioOptions(driver,
				"applicationData-quiz.spouseInUS");
		spouseLivingInUS.selectOption(1);
		continueBtn.click();

		immigrantstatus = new MultiRadioOptions(driver,
				"applicationData-quiz.spouseLegalStatus");
		immigrantstatus.selectOption(1);
		continueBtn.click();

		spouseInspected = new MultiRadioOptions(driver,
				"applicationData-quiz.spouseCustomsReview");
		spouseInspected.selectOption(1);
		continueBtn.click();

		meetRequirements = new MultiRadioOptions(driver,
				"applicationData-quiz.requirementToSponsor");
		meetRequirements.selectOption(1);
		continueBtn.click();

		filedI130 = new MultiRadioOptions(driver,
				"applicationData-quiz.filedI130");
		filedI130.selectOption(2);
		continueBtn.click();

		presentAtWedding = new MultiRadioOptions(driver,
				"applicationData-quiz.presentAtWedding");
		presentAtWedding.selectOption(1);
		continueBtn.click();

		currentlyInUS = new MultiRadioOptions(driver,
				"applicationData-quiz.currentlyInUS");
		currentlyInUS.selectOption(1);
		continueBtn.click();

		return this;
	}

}

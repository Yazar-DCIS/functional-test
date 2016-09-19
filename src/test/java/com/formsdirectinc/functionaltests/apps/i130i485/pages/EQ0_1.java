package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for EQ0_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class EQ0_1 extends WizardPage {

	public MultiRadioOptions residentStatus;
	public Sites site;

	@FindBy(how = How.CSS, using = "img[alt='Continue']")
	private WebElement continueBtn;

	public EQ0_1(WebDriver driver) {
		super(driver);

	}

	public EQ0_1 citizenOf_US() {
		residentStatus = new MultiRadioOptions(driver,
				"applicationData-applicant.statusInUS");
		residentStatus.selectOption(1);
		continueBtn.click();
		return this;
	}

}

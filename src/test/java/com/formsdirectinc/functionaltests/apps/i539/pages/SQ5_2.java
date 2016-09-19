package com.formsdirectinc.functionaltests.apps.i539.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ5_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ5_2 extends WizardPage {

	private MultiRadioOptions jointPetition;
	private CommonInputClasses petition;
	private AdditionalInfoFields receipt;
	private DateTag filedOn;

	@FindBy(how = How.ID, using = "applicationData-applicant.petitionerDetails.receiptNumber.name")
	WebElement receiptName;

	public SQ5_2(WebDriver driver) {
		super(driver);
	}

	public void set_JointPetition_Status() {
		jointPetition = new MultiRadioOptions(driver,
				"applicationData-applicant.separateOrJointPetition");
		jointPetition.selectOption(3);
	}

	public void set_PetitionerDetails(Properties data) {
		petition = new CommonInputClasses(driver);
		petition.applicantNameDetails("applicant.petitionerDetails.name", data);

	}

	public void set_ReceiptNumber(Properties data) {
		
		
		new Select(receiptName).selectByVisibleText(data
				.getProperty("receiptType"));
		receipt = new AdditionalInfoFields(driver,
				"applicationData-applicant.petitionerDetails.receiptNumber.number");
		receipt.normalText(data.getProperty("receiptNumber"));
	}

	public void set_filedOn(Properties data) {
		filedOn = new DateTag(driver, "applicant.petitionerDetails.filedOn");
		filedOn.selectDate(data.getProperty("fromDate"));

	}

}

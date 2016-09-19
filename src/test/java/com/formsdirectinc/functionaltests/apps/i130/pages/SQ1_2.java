package com.formsdirectinc.functionaltests.apps.i130.pages;
import org.openqa.selenium.WebDriver;
import com.formsdirectinc.functionaltests.tags.Gender;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_2 extends WizardPage {

	private Gender gender;

	public SQ1_2(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void applicantGender(String genderIs) {
		gender = new Gender(driver, "applicationData-applicant.sex");
		gender.setGender(genderIs);
		
		saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
	}

}

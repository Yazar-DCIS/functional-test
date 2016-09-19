package com.formsdirectinc.functionaltests.apps.i821.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Gender;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_4 extends WizardPage {

	public SQ2_4(WebDriver driver) {
		super(driver);
	}

	
	private Gender gender_options;
	private DateTag dateOfBirth;
	private YesNo usedOtherDateOfBirth;

	private DateTag addOtherDate;
	private Address placeOfBirth;

	public SQ2_4 biographic_Information(String gender, String otherdob,
			Properties data) {

		if (!gender.equalsIgnoreCase("NA")) {

			gender_options = new Gender(driver, "applicationData-applicant.sex");
			gender_options.setGender(gender);

			dateOfBirth = new DateTag(driver, "applicant.birth.dateOfBirth");
			dateOfBirth.selectDateAsSingle(data.getProperty("DOB"));

			usedOtherDateOfBirth = new YesNo(driver,
					"applicant.usedOtherDateOfBirth");
			if (otherdob.equalsIgnoreCase("Yes")) {

				usedOtherDateOfBirth.yes();
				addAnotherDate(3, data);

			} else if (otherdob.equalsIgnoreCase("No")) {

				usedOtherDateOfBirth.no();
			}

			placeOfBirth = new Address(driver,
					"applicationData-applicant.placeOfBirth");
			placeOfBirth.setCity(data.getProperty("DOB_City"));
			placeOfBirth.setBirthState(data.getProperty("DOB_State"));

			placeOfBirth = new Address(driver,
					"applicationData-applicant.placeOfBirth.country");
			placeOfBirth.setCountry(data.getProperty("DOB_Country"));

			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

	public SQ2_4 addAnotherDate(int count, Properties data) {

		for (int i = 0; i < count; i++) {

			addOtherDate = new DateTag(driver, "applicant.otherDateOfBirth["
					+ i + "].otherDate");
			addOtherDate.selectDateAsSingle(data.getProperty("DOB"));

			if (i < count - 1) {

				CommonInputClasses others = new CommonInputClasses(driver);
				others.addAnother();
			}

		}
		return this;

	}
}

package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_1 extends WizardPage {
	private YesNo filedAlready, filedK1Visa, petApproved;
	private Name_FirstMiddleLast name;
	private AdditionalInfoFields moreInfo;
	private Address state;
	private DateTag dateOfFiling;
	private Numbers arnNo;
	private MultiRadioOptions resultOfFiling;

	public SQ4_1(WebDriver driver) {
		super(driver);
	}

	public SQ4_1 previousFilings(Properties data, String everFiledI129F,
			double noOfI129fFiled, String filedMorePetition,
			String petitionApproved) throws Exception {
		
		filedAlready = new YesNo(driver,
				"applicant.personalHistory.filedI129Before");
		if (everFiledI129F.equalsIgnoreCase("Yes")) {
			filedAlready.yes();
			for (int i = 0; i < noOfI129fFiled; i++) {
				name = new Name_FirstMiddleLast(driver, "applicationData",
						"applicant.personalHistory.previousFilings[" + i
								+ "].name");
				name.setFirstNameField(data.getProperty("FirstName2"));
				name.setMiddleNameField(data.getProperty("MiddleName2"));
				name.setLastNameField(data.getProperty("LastName2"));

				moreInfo = new AdditionalInfoFields(driver,
						"applicationData-applicant.personalHistory.previousFilings["
								+ i + "].placeFiled-city");
				moreInfo.normalText(data.getProperty("City"));

				state = new Address(driver,
						"applicationData-applicant.personalHistory.previousFilings["
								+ i + "].placeFiled");
				state.setState(data.getProperty("I134_StateDD"));

				dateOfFiling = new DateTag(driver,
						"applicant.personalHistory.previousFilings[" + i
								+ "].dateFiled");
				dateOfFiling.selectDateAsSingle(data
						.getProperty("I131_DateIssued"));

				arnNo = new Numbers(driver,
						"applicationData-applicant.personalHistory.previousFilings["
								+ i + "].ARN");
				arnNo.setAlienRegistrationNumber(data.getProperty("ARN"));

				resultOfFiling = new MultiRadioOptions(driver,
						"applicationData-applicant.personalHistory.previousFilings["
								+ i + "].filingResult");
				resultOfFiling.selectOption(1);

				if (i < noOfI129fFiled - 1) {
					CommonInputClasses file = new CommonInputClasses(driver);
					file.addAnother();
				}
			}
			filedK1Visa = new YesNo(driver,
					"applicant.personalHistory.filedTwoOrMorePetitions");
			if (filedMorePetition.equalsIgnoreCase("Yes")) {
				filedK1Visa.yes();
			}
			else if (filedMorePetition.equalsIgnoreCase("No")) {
				filedK1Visa.no();
			}
			petApproved = new YesNo(driver,
					"applicant.personalHistory.petitionApproved");
			if (petitionApproved.equalsIgnoreCase("Yes")) {
				petApproved.yes();
			}
			else if (petitionApproved.equalsIgnoreCase("No")) {
				petApproved.no();
			}
		}
		else if (everFiledI129F.equalsIgnoreCase("No")) {
			filedAlready.no();
		}
		saveScreenShot("i129f", "SQ4_1"); clickContinueInSQ();
		return this;
	}
}
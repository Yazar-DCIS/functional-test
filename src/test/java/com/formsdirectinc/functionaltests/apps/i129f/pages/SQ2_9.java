package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_9 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_9 extends WizardPage {
	private Name_FirstMiddleLast childName;
	private CommonInputClasses moreInfo;
	private DateTag childDob;
	private YesNo haveChildren;
	private Address childCountryOfBirth, selectCountry;

	public SQ2_9(WebDriver driver) {
		super(driver);
	}

	public SQ2_9 fianceChildrenDetails(Properties data,
			String fianceHaveChildren, double childrenCount,
			String childrenCountry) {
		haveChildren = new YesNo(driver, "foreignFiance.haveChildren");
		if (fianceHaveChildren.equalsIgnoreCase("Yes")) {
			haveChildren.yes();
			for (int i = 0; i < childrenCount; i++) {
				childName = new Name_FirstMiddleLast(driver, "applicationData",
						"foreignFiance.childDetails[" + i + "].name");
				childName.setFirstNameField(data.getProperty("FirstName3"));
				childName.setMiddleNameField(data.getProperty("MiddleName3"));
				childName.setLastNameField(data.getProperty("LastName3"));

				childDob = new DateTag(driver, "foreignFiance.childDetails["
						+ i + "].birth.dateOfBirth");
				childDob.selectMonth(data.getProperty("DOB_Month"));
				childDob.selectDay(data.getProperty("DOB_Day"));
				childDob.selectYear(data.getProperty("DOB_Year"));

				childCountryOfBirth = new Address(driver,
						"applicationData-foreignFiance.childDetails[" + i
								+ "].birth.countryOfBirth");
				childCountryOfBirth.setCountryDropDown(data
						.getProperty("I134_USA"));

				selectCountry = new Address(driver,
						"applicationData-foreignFiance.childDetails[" + i
								+ "].presentAddress.country");
				moreInfo = new CommonInputClasses(driver);

				if (childrenCountry.equalsIgnoreCase("USA")) {
					selectCountry.setCountryDropDown(data
							.getProperty("I134_USA"));
					moreInfo.applicantAddressDetails(
							"applicationData-foreignFiance.childDetails[" + i
									+ "].presentAddress", data);
				}
				else if (childrenCountry.equalsIgnoreCase("OutSideUSA")) {
					selectCountry.setCountryDropDown(data
							.getProperty("I134_Country"));
					moreInfo.applicantOtherAddressDetails(
							"applicationData-foreignFiance.childDetails[" + i
									+ "].presentAddress", data);
				}

				if (i < childrenCount - 1) {

					moreInfo.addAnotherChild();

				}
			}

		}
		else if (fianceHaveChildren.equalsIgnoreCase("No")) {
			haveChildren.no();
		}
		saveScreenShot("i129f", "SQ2_9"); clickContinueInSQ();
		return this;
	}

}

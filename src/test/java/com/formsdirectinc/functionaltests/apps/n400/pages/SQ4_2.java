package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ4_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ4_2 extends WizardPage {

	private MultiRadioOptions childResident;
	private Country childBirthCountry;
	private Name_FirstMiddleLast childName;
	private DateTag dateOfBirth;
	private AdditionalInfoFields reasons, childRelation;
	private YesNo haveARN, haveSupport;

	private Address childAddr;

	public SQ4_2(WebDriver driver) {
		super(driver);

	}

	public SQ4_2 childMoreDetails(Properties copies, Properties data,
			int count, String childInfo, String number) {

		if ((count != -1)
				&& (!childInfo.equalsIgnoreCase("NA") && (!number
						.equalsIgnoreCase("NA")))) {
			if (count > 0) {
				for (int i = 0; i < count; i++) {
					childDetails(copies, data, i, childInfo, number);
					if (i < count - 1) {

						CommonInputClasses others = new CommonInputClasses(
								driver);
						others.addAnotherChild();
					}
				}

			}
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ4_2");
			
			 clickContinueInSQ();
		}
		return this;

	}

	public SQ4_2 childDetails(Properties copies, Properties data, int i,
			String childInfo, String number) {

		childName = new Name_FirstMiddleLast(driver, "applicationData",
				"childDetails.children[" + i + "].name");
		childName.setFirstNameField(data.getProperty("ChildFirstName"+i));
		childName.setLastNameField(data.getProperty("ChildLastName"+i));

		dateOfBirth = new DateTag(driver, "childDetails.children[" + i
				+ "].birth.dateOfBirth");
		dateOfBirth.selectDate(data.getProperty("ChildDOB"+i));

		childBirthCountry = new Country(driver,
				"applicationData-childDetails.children[" + i
						+ "].birth.countryOfBirth");
		childBirthCountry.setCountryDDM(data.getProperty("ChildCountry"));

		haveARN = new YesNo(driver, "childDetails.children[" + i + "].haveARN");

		if (number.equalsIgnoreCase("Yes")) {
			haveARN.yes();
			reasons = new AdditionalInfoFields(driver,
					"applicationData-childDetails.children[" + i + "].ARN.arn");
			reasons.normalText(data.getProperty("childARN"+i));
		}
		else if (number.equalsIgnoreCase("No")) {
			haveARN.no();
		}

		childRelation = new AdditionalInfoFields(driver,
				"applicationData-childDetails.children[" + i
						+ "].relationToYou");
		childRelation.normalText(data.getProperty("childRelation"+i));

		childResident = new MultiRadioOptions(driver,
				"applicationData-childDetails.children[" + i + "].livingStatus");

		if (childInfo.equalsIgnoreCase("liveWithMe")) {
			childResident.selectOption(1);
		}
		else if (childInfo.equalsIgnoreCase("doesntliveWithMe")) {
			childResident.selectOption(2);

			haveSupport = new YesNo(driver, "childDetails.children[" + i
					+ "].financialSupportChild");
			if (number.equalsIgnoreCase("Yes")) {
				haveSupport.yes();
			}
			else if (number.equalsIgnoreCase("No")) {
				haveSupport.no();
			}

			childBirthCountry = new Country(driver,
					"applicationData-childDetails.children[" + i
							+ "].presentAddress.country");
			childBirthCountry.setCountryDDM(data.getProperty("Country"));

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			childAddr = new Address(driver,
					"applicationData-childDetails.children[" + i
							+ "].presentAddress");
			childAddr.setStreet(data.getProperty("StreetName"));
			childAddr.setCity(data.getProperty("City"));
			childAddr.setStateText(data.getProperty("State"));
			childAddr.setZipcode(data.getProperty("Zipcode"));

		}
		if (childInfo.equalsIgnoreCase("deceased")) {
			childResident.selectOption(3);
		}
		else if (childInfo.equalsIgnoreCase("missed")) {
			childResident.selectOption(4);
		}

		return this;
	}

}

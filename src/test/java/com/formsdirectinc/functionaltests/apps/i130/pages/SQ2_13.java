package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_13 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_13 extends WizardPage {

	private YesNo relativeChildInfo;
	private AdditionalInfoFields childARN;
	private Name_FirstMiddleLast childName;
	private DateTag childDOB;
	private Country childCountry;

	public SQ2_13(WebDriver driver) {
		super(driver);

	}

	public SQ2_13 relativeChildrenInfo(String relativeHaveChild,
			Properties data, int count) {

		if (!relativeHaveChild.equalsIgnoreCase("na") && count != -1) {
			relativeChildInfo = new YesNo(driver, "relative.hasChildren");

			if (relativeHaveChild.equalsIgnoreCase("Yes")) {
				relativeChildInfo.yes();

				if (count > 0) {
					for (int i = 0; i < count; i++) {

						childName = new Name_FirstMiddleLast(driver,
								"applicationData", "relative.childDetails[" + i
										+ "].name");
						childName.setFirstNameField(data
								.getProperty("FirstName1"));
						childName.setMiddleNameField(data
								.getProperty("FirstName2"));
						childName.setLastNameField(data
								.getProperty("FirstName3"));

						childDOB = new DateTag(driver, "relative.childDetails["
								+ i + "].birth.dateOfBirth");
						childDOB.selectDate(data.getProperty("fromDate"));

						childARN = new AdditionalInfoFields(driver,

						"applicationData-relative.childDetails[" + i
								+ "].ARN.arn");
						childARN.normalText(data.getProperty("ARN"));

						childCountry = new Country(driver,
								"applicationData-relative.childDetails[" + i
										+ "].birth.countryOfBirth");
						childCountry.setCountryDDM(data.getProperty("Country"));

						if ((i < count - 1)) {
							CommonInputClasses childInfo = new CommonInputClasses(
									driver);
							childInfo.addAnotherChild();
						}
					}

				}

			}

			else if (relativeHaveChild.equalsIgnoreCase("No")) {
				relativeChildInfo.no();
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

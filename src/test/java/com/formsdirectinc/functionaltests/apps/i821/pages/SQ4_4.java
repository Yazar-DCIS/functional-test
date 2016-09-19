package com.formsdirectinc.functionaltests.apps.i821.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_4 extends WizardPage {

	public SQ4_4(WebDriver driver) {
		super(driver);
	}

	
	private YesNo haveChildren;

	private CommonInputClasses childName;
	private DateTag dateOfBirth;
	private Address currentResident;
	private AdditionalInfoFields childArn;
	private AdditionalInfoFields childElisNumber;

	public SQ4_4 setChildDetails(String havechildren,int count ,Properties data) {

		if (!havechildren.equalsIgnoreCase("NA")) {
			haveChildren = new YesNo(driver, "childDetails.haveChildren");
			haveChildren.setYesOrNo(havechildren);
			if (havechildren.equalsIgnoreCase("Yes")) {
				addAnotherchildDetails(count, data);
			}
			
			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

	public SQ4_4 addAnotherchildDetails(int count, Properties data) {

		for (int i = 0; i < count; i++) {

			childName = new CommonInputClasses(driver);
			childName.applicantNameDetails("childDetails.children[" + i
					+ "].childName", data);

			dateOfBirth = new DateTag(driver, "childDetails.children[" + i
					+ "].dateOfBirth");
			dateOfBirth.selectDateAsSingle(data.getProperty("DOB"));

			currentResident = new Address(driver,
					"applicationData-childDetails.children[" + i
							+ "].currentResident.country");
			currentResident.setCountryDropDown(data.getProperty("Country"));

			childName.applicantOtherAddressDetails(
					"applicationData-childDetails.children[" + i
							+ "].currentResident", data);

			childArn = new AdditionalInfoFields(driver,
					"applicationData-childDetails.children[" + i + "].childArn");
			childArn.normalText(data.getProperty("ARN"));

			childElisNumber = new AdditionalInfoFields(driver,
					"applicationData-childDetails.children[" + i
							+ "].childElisNumber");
			childElisNumber.normalText(data.getProperty("ELIS"));

			if (i < count - 1) {
				CommonInputClasses others = new CommonInputClasses(driver);
				others.addAnother();
			}
		}
		return this;
	}

}

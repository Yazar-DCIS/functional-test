package com.formsdirectinc.functionaltests.apps.i821d.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ2_2 extends WizardPage {

	private YesNo otherNames;

	public SQ2_2(WebDriver driver) {
		super(driver);

	}

	public SQ2_2 setOtherNames(String usedOtherNames, int count, Properties data)
			throws Exception {

		if (usedOtherNames.equalsIgnoreCase("Yes")
				|| usedOtherNames.equalsIgnoreCase("No")) {

			otherNames = new YesNo(driver, "applicant.usedOtherNames");

			if (usedOtherNames.equalsIgnoreCase("Yes")) {

				otherNames.yes();

				for (int i = 0; i < count; i++)

				{
					Name_FirstMiddleLast moreNames = new Name_FirstMiddleLast(
							driver, "applicationData", "applicant.otherNames["
									+ i + "].otherNamesList");
					moreNames.setFirstNameField(data.getProperty("FirstName"
							+ i));
					moreNames.setLastNameField(data.getProperty("MiddleName"
							+ i));
					moreNames.setMiddleNameField(data.getProperty("LastName"
							+ i));

					if (i < count - 1) {
						CommonInputClasses name = new CommonInputClasses(driver);
						name.addAnother();
					}
				}

			}

			if (usedOtherNames.equalsIgnoreCase("No")) {
				otherNames.no();
			}

		}
		return this;

	}

}

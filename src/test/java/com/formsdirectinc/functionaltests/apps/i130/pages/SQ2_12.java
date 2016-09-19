package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ2_12 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_12 extends WizardPage {

	private YesNo marriedBeforeStatus;

	private AdditionalInfoFields relativeName;
	private DateTag relativeDateOfMrgEnd;

	public SQ2_12(WebDriver driver) {
		super(driver);

	}

	public SQ2_12 relativeSpousePriorMarriage(
			String relativeSpouseMarriedBefore, Properties data, int count) {

		if (!relativeSpouseMarriedBefore.equalsIgnoreCase("na") && count != -1) {

			marriedBeforeStatus = new YesNo(driver,
					"relative.spouseDetails.previouslyMarried");

			if (relativeSpouseMarriedBefore.equalsIgnoreCase("Yes")) {
				marriedBeforeStatus.yes();

				if (count > 0) {
					for (int i = 0; i < count; i++) {

						relativeName = new AdditionalInfoFields(driver,

						"applicationData-relative.spouseDetails.previousSpouseDetails["
								+ i + "].name");
						relativeName.normalText(data.getProperty("FirstName1"));

						relativeDateOfMrgEnd = new DateTag(driver,

						"relative.spouseDetails.previousSpouseDetails[" + i
								+ "].date");
						relativeDateOfMrgEnd.selectDate(data
								.getProperty("fromDate"));

						if ((i < count - 1)) {
							CommonInputClasses relativeInfo = new CommonInputClasses(
									driver);
							relativeInfo.addAnother();
						}
					}

				}

			}

			else if (relativeSpouseMarriedBefore.equalsIgnoreCase("No")) {
				marriedBeforeStatus.no();
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ5_5 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ5_5 extends WizardPage {

	protected DateTag fatherPresenceInUSFrom, fatherPresenceInUSTo;

	public SQ5_5(WebDriver driver) {
		super(driver);

	}

	public SQ5_5 fatherPhysicalPresenceInUSDates(Properties data, int count) {

		if (count != -1) {
			if (count > 0) {
				for (int i = 0; i < count; i++) {
					fatherPhysicalPresenceInUS(data, i);
					if ((i < count - 1)) {

						CommonInputClasses others = new CommonInputClasses(
								driver);
						others.addAnotherDate();
					}
				}

			}
			saveScreenShot("n600", "SQ5_5"); clickContinueInSQ();
		}
		return this;

	}

	public SQ5_5 fatherPhysicalPresenceInUS(Properties data, int count) {

		fatherPresenceInUSFrom = new DateTag(driver,
				"applicant.fatherInfo.presentDateInUSHistory[" + count
						+ "].presentDateInUS.fromDate");
		fatherPresenceInUSFrom.selectDate(data.getProperty("fromDate" + count));

		fatherPresenceInUSTo = new DateTag(driver,
				"applicant.fatherInfo.presentDateInUSHistory[" + count
						+ "].presentDateInUS.toDate");
		fatherPresenceInUSTo.selectDate(data.getProperty("toDate" + count));

		return this;

	}

}

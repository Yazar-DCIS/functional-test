package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ6_5 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ6_5 extends WizardPage {

	protected DateTag motherPresenceInUSFrom, motherPresenceInUSTo;

	public SQ6_5(WebDriver driver) {
		super(driver);

	}

	public SQ6_5 motherPhysicalPresenceInUSDates(Properties data, int count) {

		if (count != -1) {

			if (count > 0) {
				for (int i = 0; i < count; i++) {
					motherPhysicalPresenceInUS(data, i);
					if ((i < count - 1)) {

						CommonInputClasses others = new CommonInputClasses(
								driver);
						others.addAnotherDate();
					}
				}

			}
			saveScreenShot("n600", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;

	}

	public SQ6_5 motherPhysicalPresenceInUS(Properties data, int i) {

		motherPresenceInUSFrom = new DateTag(driver,
				"applicant.motherInfo.presentDateInUSHistory[" + i
						+ "].presentDateInUS.fromDate");
		motherPresenceInUSFrom.selectDate(data.getProperty("fromDate" + i));

		motherPresenceInUSTo = new DateTag(driver,
				"applicant.motherInfo.presentDateInUSHistory[" + i
						+ "].presentDateInUS.toDate");
		motherPresenceInUSTo.selectDate(data.getProperty("toDate" + i));

		return this;

	}

}

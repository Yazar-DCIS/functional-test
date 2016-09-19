package com.formsdirectinc.functionaltests.apps.i131.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_10_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_10_1 extends WizardPage {
	private MultiRadioOptions filingDate;
	private AdditionalInfoFields locationI485Pending;

	public SQ1_10_1(WebDriver driver) {
		super(driver);
	}

	public SQ1_10_1 i485FileStatus(Properties data, String i485Status) {
		if (!i485Status.equalsIgnoreCase("NA")) {
			
			filingDate = new MultiRadioOptions(driver,
					"applicationData-applicant.filedI485");

			if (i485Status.equalsIgnoreCase("FiledI485Before30July2007")) {
				filingDate.selectOption(1);
			}
			else if (i485Status.equalsIgnoreCase("FiledI485After30July2007")) {
				filingDate.selectOption(2);
			}
			locationI485Pending = new AdditionalInfoFields(driver,
					"applicant.i485PendingLocation");
			locationI485Pending.textDDM(data
					.getProperty("I131_Location_I485Pending"));

			saveScreenShot("i131", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}
}
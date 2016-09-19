package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.newtags.WizardPage;
/**
 * EQ2_1- cprExpiryDate
 * @author Orina
 *
 */

public class EQ2_1 extends WizardPage {
	private DateTag datePermanentResidency;

	public EQ2_1(WebDriver driver) {
		super(driver);
	}

	public EQ2_1 dateSelection(Properties data, String answer) {
	
		if (!answer.equalsIgnoreCase("NA")) {
			
			datePermanentResidency = new DateTag(driver, "quiz.cprExpiryDate");

			if (answer.equalsIgnoreCase("set_expiryDate1")) {
				datePermanentResidency.selectDateAsSingle(data
						.getProperty("cprExpiryDate.1"));
			}

			else if (answer.equalsIgnoreCase("set_expiryDate2")) {
				datePermanentResidency.selectDateAsSingle(data
						.getProperty("cprExpiryDate.2"));
			}

			else if (answer.equalsIgnoreCase("set_expiryDate3")) {
				datePermanentResidency.selectDateAsSingle(data
						.getProperty("cprExpiryDate.3"));
			}
			saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Continue");
		}

		return this;
	}
}

package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.newtags.WizardPage;
import com.formsdirectinc.functionaltests.newtags.YesNo;

/**
 * I-90:Abandonment/Judged
 *
 * @author Orina
 */

public class SQ4_2 extends WizardPage {

	private YesNo filedFormI407OrAbandonedPRStatus;

	public SQ4_2(WebDriver driver) {
		super(driver);
	}

	public SQ4_2 abondonment(Properties data, String filedFormI407) {

		
		
		
		filedFormI407OrAbandonedPRStatus = new YesNo(driver,
				"formSpecific.filedFormI407OrAbandonedPRStatus.answer");

		if (filedFormI407.equalsIgnoreCase("yes")) {
			filedFormI407OrAbandonedPRStatus.yes();

			YesNo abandonedReason = new YesNo(driver,
					"formSpecific.filedFormI407OrAbandonedPRStatus");
			abandonedReason
					.explain(data
							.getProperty("formSpecific.filedFormI407OrAbandonedPRStatus.explaination"));

		}

		else if (filedFormI407.equalsIgnoreCase("no")) {
			filedFormI407OrAbandonedPRStatus.no();
		}

		saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Next");

		return this;
	}
}

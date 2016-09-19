package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.newtags.WizardPage;
import com.formsdirectinc.functionaltests.newtags.YesNo;

/**
 * I-90:Proceedings
 * @author Orina
 */

public class SQ4_1 extends WizardPage {

	
	private YesNo excludedStatus;

	public SQ4_1(WebDriver driver) {
		super(driver);
	}

	public SQ4_1 proceedings(Properties data, String inRemovalProceedings) {
		
		excludedStatus = new YesNo(driver,"formSpecific.inRemovalProceedings.answer");

			if (inRemovalProceedings.equalsIgnoreCase("yes")) {
				
				excludedStatus.yes();

				YesNo excludedReason=new YesNo(driver, "formSpecific.inRemovalProceedings");
				excludedReason.explain(data.getProperty("formSpecific.inRemovalProceedings.explaination"));
				
			}

			else if (inRemovalProceedings.equalsIgnoreCase("no")) {
				excludedStatus.no();
			}

			saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Next");
		return this;
	}
}

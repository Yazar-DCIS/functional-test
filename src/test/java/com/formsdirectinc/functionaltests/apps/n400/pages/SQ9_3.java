package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ9_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ9_3 extends WizardPage {

	private YesNo fiftyYears,sixtyFiveYears,fiftyFiveYears;

	public SQ9_3(WebDriver driver) {
		super(driver);

	}

	public SQ9_3 waiver(Properties copies, String answer) {

		if (!answer.equalsIgnoreCase("NA")) {

			fiftyYears = new YesNo(driver, "formSpecific.fiftyYears");
			fiftyYears.setYesOrNo(answer);

			fiftyFiveYears = new YesNo(driver, "formSpecific.fiftyFiveYears");
			fiftyFiveYears.setYesOrNo(answer);

			sixtyFiveYears = new YesNo(driver, "formSpecific.sixtyFiveYears");
			sixtyFiveYears.setYesOrNo(answer);
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ9_3");
			 clickContinueInSQ();
		}
		return this;
	}

}

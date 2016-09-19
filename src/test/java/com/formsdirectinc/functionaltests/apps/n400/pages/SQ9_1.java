package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ9_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ9_1 extends WizardPage {

	private YesNo waiver;

	public SQ9_1(WebDriver driver) {
		super(driver);

	}

	public SQ9_1 waiver(Properties copies, String requestingWaiver) {

		if (!requestingWaiver.equalsIgnoreCase("NA")) {

			waiver = new YesNo(driver, "formSpecific.requestingWaiver");
			waiver.setYesOrNo(requestingWaiver);
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ9_1");
			 clickContinueInSQ();
		}
		return this;
	}

}

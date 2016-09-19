package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ4_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ4_1 extends WizardPage {

	private YesNo haveChildren;

	public SQ4_1(WebDriver driver) {
		super(driver);

	}

	public SQ4_1 childrenDetails(Properties copies, String haveChild) {
		if (haveChild.equalsIgnoreCase("no")||haveChild.equalsIgnoreCase("yes")) {

			haveChildren = new YesNo(driver, "childDetails.haveChildren");
			haveChildren.setYesOrNo(haveChild);
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ4_1");
			 clickContinueInSQ();
		}
		return this;
	}

}

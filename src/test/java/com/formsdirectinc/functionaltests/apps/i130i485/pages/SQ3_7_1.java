package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_7_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_7_1 extends WizardPage {

	public SQ3_7_1(WebDriver driver) {
		super(driver);

	}

	public SQ3_7_1 stopApplication() throws IOException {

		
			CaptureScreen takeSnap=new CaptureScreen(driver);
			takeSnap.takeScreenShot("I130I485","SQ3_7_1");
		
		return this;

	}

}

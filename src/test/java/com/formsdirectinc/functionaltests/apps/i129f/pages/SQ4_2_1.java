package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ4_2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ4_2_1 extends WizardPage {

	public SQ4_2_1(WebDriver driver) {
		super(driver);

	}

	public SQ4_2_1 stopApplication() throws IOException {

			CaptureScreen takeSnap=new CaptureScreen(driver);
			takeSnap.takeScreenShot("I129F","SQ4_2_1");
			
		return this;

	}

}

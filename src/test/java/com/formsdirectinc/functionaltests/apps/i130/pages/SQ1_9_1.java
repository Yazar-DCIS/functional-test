package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ1_9_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_9_1 extends WizardPage {

	public SQ1_9_1(WebDriver driver) {
		super(driver);

	}

	public SQ1_9_1 stopApplication() throws IOException {

		CaptureScreen stopPage=new CaptureScreen(driver);
		stopPage.takeScreenShot("i130", "SQ1_9_1");
		
		return this;

	}

}

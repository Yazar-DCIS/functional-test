package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ4_12_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ4_12_1 extends WizardPage {

	public SQ4_12_1(WebDriver driver) {
		super(driver);

	}

	public SQ4_12_1 stopApplication() throws IOException {

		
		CaptureScreen takeSnap=new CaptureScreen(driver);
		takeSnap.takeScreenShot("I130I485","SQ4_12_1");
		
		return this;

	}

}

package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ2_5_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_5_1 extends WizardPage {

	
	

	private YesNo irsStatus;

	public SQ2_5_1(WebDriver driver) {
		super(driver);

	}

	public void irsStatus() {

		irsStatus = new YesNo(driver, "principalFormSpecific.haveIRSTaxNumber");
		irsStatus.no();

	}

}

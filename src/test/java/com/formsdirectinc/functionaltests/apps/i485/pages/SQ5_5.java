package com.formsdirectinc.functionaltests.apps.i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ5_5 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ5_5 extends WizardPage {

	private YesNo havechild;

	public SQ5_5(WebDriver driver) {
		super(driver);

	}

	public void childrenInfo(Properties data) {
		havechild = new YesNo(driver, "familyMembers.hasChildren");
		havechild.no();
	}

}

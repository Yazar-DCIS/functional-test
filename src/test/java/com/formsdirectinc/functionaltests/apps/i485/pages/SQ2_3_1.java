package com.formsdirectinc.functionaltests.apps.i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */



public class SQ2_3_1 extends WizardPage {

	private CommonInputClasses nameTag;
	private YesNo fatherAlive, motherAlive;

	public SQ2_3_1(WebDriver driver) {
		super(driver);

	}

	public void setFatherNameFields(Properties data) {
		nameTag = new CommonInputClasses(driver);
		nameTag.applicantNameDetails("applicant.fatherName", data);
	}

	public void fatherAliveNo() {
		fatherAlive = new YesNo(driver, "applicant.fatherStillAlive");
		fatherAlive.no();

	}

	public void setMotherNameFields(Properties data) {
		nameTag = new CommonInputClasses(driver);
		nameTag.applicantNameDetails("applicant.motherName", data);
	}

	public void motherAliveNo() {
		motherAlive = new YesNo(driver, "applicant.motherStillAlive");
		motherAlive.no();
	}
}

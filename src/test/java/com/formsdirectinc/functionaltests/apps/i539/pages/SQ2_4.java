package com.formsdirectinc.functionaltests.apps.i539.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_4 extends WizardPage {

	private CommonInputClasses ssn_No;
	private YesNo ssnInfo;

	public SQ2_4(WebDriver driver) {
		super(driver);
	}

	public void setSSNInfo(Properties data,String answer) {
		
		ssnInfo = new YesNo(driver, "applicant.haveSsn");
		ssnInfo.setYesOrNo(answer);
		if(answer.equalsIgnoreCase("yes"))
		{
			ssn_No = new CommonInputClasses(driver);
			ssn_No.applicantSSNDetails("applicationData-applicant.SSN", data);
		}
		

	}

	

}

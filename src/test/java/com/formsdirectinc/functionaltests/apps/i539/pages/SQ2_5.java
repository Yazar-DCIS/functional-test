package com.formsdirectinc.functionaltests.apps.i539.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_5 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_5 extends WizardPage {

	private YesNo arn_Click;
	private CommonInputClasses arn_No;

	public SQ2_5(WebDriver driver) {
		super(driver);
	}

	public void setARNInfo(Properties data, String answer) {
		
		arn_Click = new YesNo(driver, "applicant.haveArn");
		arn_Click.setYesOrNo(answer);
		if(answer.equalsIgnoreCase("yes"))
		{
			set_Arn_No(data);
		}
	}

	public void set_Arn_No(Properties data) {
		arn_No = new CommonInputClasses(driver);
		arn_No.applicantARNDetails("applicationData-applicant.ARN", data);
	}

}

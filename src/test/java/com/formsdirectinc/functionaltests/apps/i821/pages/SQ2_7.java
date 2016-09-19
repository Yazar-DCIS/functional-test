package com.formsdirectinc.functionaltests.apps.i821.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_7 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_7 extends WizardPage {

	public SQ2_7(WebDriver driver) {
		super(driver);
	}

	
	private YesNo havingARN;
	private CommonInputClasses arn_Number;

	public SQ2_7 setARN(String arnnumber, Properties data) {
		if (!arnnumber.equalsIgnoreCase("NA")) {
			havingARN = new YesNo(driver, "applicant.havingARN");
			havingARN.setYesOrNo(arnnumber);
			if (arnnumber.equalsIgnoreCase("Yes")) {

				
				arn_Number = new CommonInputClasses(driver);
				arn_Number.applicantARNDetails("applicationData-applicant.ARN",
						data);

			} 
			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;

	}

}

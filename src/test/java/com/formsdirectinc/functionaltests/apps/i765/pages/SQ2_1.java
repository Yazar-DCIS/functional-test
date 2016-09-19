package com.formsdirectinc.functionaltests.apps.i765.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AddAnotherField;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_1 extends WizardPage {

	private AddAnotherField addPriorEAD;
	private YesNo appliedEmpAuthorization;

	public SQ2_1(WebDriver driver) {
		super(driver);
	}

	public SQ2_1 employmentAuthorization(Properties data,
			String appliedEmploymentAuthorization, double priorEADCount)
			throws Exception {
		if (!appliedEmploymentAuthorization.equalsIgnoreCase("NA")) {
			
			appliedEmpAuthorization = new YesNo(driver,"formSpecific.appliedEmploymentAuthorization");
			appliedEmpAuthorization.setYesOrNo(appliedEmploymentAuthorization);
			
			if (appliedEmploymentAuthorization.equalsIgnoreCase("Yes")) {
					addPriorEAD = new AddAnotherField(driver);
					addPriorEAD.AddAnotherPriorEAD(priorEADCount, data,	"formSpecific");
				}
		
			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

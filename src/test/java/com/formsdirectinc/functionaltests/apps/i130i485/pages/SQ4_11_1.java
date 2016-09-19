package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.Employment;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ4_11_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_11_1 extends WizardPage {

	private YesNo workedOutside;

	public SQ4_11_1(WebDriver driver) {
		super(driver);
	}

	public SQ4_11_1 employmentDetailsAbroad(String workedOutsideUSA,
			String currentOccupation,String occupationCountry) {

		String appname = Products.I130I485.name().toLowerCase();

		if (workedOutsideUSA.equalsIgnoreCase("Yes")||workedOutsideUSA.equalsIgnoreCase("no"))
		{
		workedOutside = new YesNo(driver,"applicant.employmentInfo.workedOutside");
		workedOutside.setYesOrNo(workedOutsideUSA);
		if (workedOutsideUSA.equalsIgnoreCase("Yes")) {
		
			Employment employmentInfo = new Employment(driver);
			employmentInfo.employmentInformation("applicant.employmentInfo.outsideEmployment", appname,currentOccupation,
					occupationCountry);
		}
		
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

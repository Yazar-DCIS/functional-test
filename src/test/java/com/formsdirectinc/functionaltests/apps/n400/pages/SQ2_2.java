package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ2_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_2 extends WizardPage {

	private CommonInputClasses  cardName;
	private DateTag cardDate;
	private YesNo sameName;
	private AdditionalInfoFields reasons;

	public SQ2_2(WebDriver driver) {
		super(driver);

	}

	public SQ2_2 greenCardDetailsWithFormI551(Properties copies,
			Properties data, String qualifier, String sameCardName,
			String formI551) {

		if (!qualifier.equalsIgnoreCase("NA")) {
			if (qualifier.equalsIgnoreCase("5yrGreenCard")
					|| qualifier.equalsIgnoreCase("3yrGreenCard")
					|| qualifier.equalsIgnoreCase("workOutsideUS")
					|| qualifier.equalsIgnoreCase("priest")
					|| qualifier.equalsIgnoreCase("promoteUS")
					|| qualifier.equalsIgnoreCase("none")) {
				greenCardDetails(data, sameCardName);
			}

			else {

				sameName = new YesNo(driver, "formSpecific.unexpiredForm");
				if (formI551.equalsIgnoreCase("Yes")) {
					sameName.yes();
					greenCardDetails(data, sameCardName);
				}

				else if (formI551.equalsIgnoreCase("No")) {

					sameName.no();
					reasons = new AdditionalInfoFields(driver,

					"applicationData-formSpecific.explainNoGreenCard");
					reasons.normalText(data.getProperty("Reasons"));
				}
			}

			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ2_2");
			
			 clickContinueInSQ();
		}
		return this;
	}

	public SQ2_2 greenCardDetails(Properties data, String sameCardName) {

		
		Numbers userARN= new Numbers(driver, "applicationData-applicant.ARN");
		userARN.setAlienRegistrationNumber("111-111-111");

		cardDate = new DateTag(driver,
				"personalDetails.dateOfPermanentResident");
		cardDate.selectDate(data.getProperty("DOE"));

		sameName = new YesNo(driver, "personalDetails.nameOnGreenCard");
		if (sameCardName.equalsIgnoreCase("yes")) {
			sameName.yes();
		}
		else if (sameCardName.equalsIgnoreCase("no")) {
			sameName.no();

			cardName = new CommonInputClasses(driver);
			cardName.applicantNameDetails("personalDetails.greenCardName", data);

		}

		return this;
	}

}

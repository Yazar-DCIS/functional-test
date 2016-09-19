package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ1_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_3 extends WizardPage {

	private YesNo havePermanentResidentCard, sameCardFR;
	private Name_FirstMiddleLast pr_other;
	private AdditionalInfoFields arn;

	public SQ1_3(WebDriver driver) {
		super(driver);

	}

	public SQ1_3 permanentCardInfo(Properties n600copies, String havePRCard,
			String sameName, Properties data) {

		

		try {
			PageCopiesAndContent copyValidation = new PageCopiesAndContent(
					driver);
			copyValidation
					.verifyPageLabelText(
							n600copies.getProperty("label.sq1.3.question1")
									+ " "
									+ data.getProperty("FirstName")
									+ " "
									+ n600copies
											.getProperty("label.sq1.3.question1.1"),
							"section-1.3.1");
			copyValidation.verifyResources_FAQContent("UseFul",
					n600copies.getProperty("faq.sq1.3.question"),
					n600copies.getProperty("faq.sq1.3.answer"));

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

		havePermanentResidentCard = new YesNo(driver, "applicant.haveThePRC");

		if (havePRCard.equalsIgnoreCase("Yes")) {
			havePermanentResidentCard.yes();

			sameCardFR = new YesNo(driver,	"applicant.prcNameSameAsCurrentLegalName");
			sameCardFR.setYesOrNo(sameName);
			
			if (sameName.equalsIgnoreCase("no")) {
				pr_other = new Name_FirstMiddleLast(driver, "applicationData",
						"applicant.prcName");
				pr_other.setFirstNameField("prFirst");
				pr_other.setMiddleNameField("prMiddle");
				pr_other.setLastNameField("prLast");
			}

			arn = new AdditionalInfoFields(driver,
					"applicationData-applicant.prcNumber");
			arn.normalText(data.getProperty("ARN"));

		}

		if (havePRCard.equalsIgnoreCase("No")) {
			havePermanentResidentCard.no();
		}
		saveScreenShot("n600", "SQ1_3"); clickContinueInSQ();

		return this;
	}

}

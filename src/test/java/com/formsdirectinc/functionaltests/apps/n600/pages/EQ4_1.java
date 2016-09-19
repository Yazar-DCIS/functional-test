package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ4_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ4_1 extends WizardPage{

	public Sites site;

	public YesNo legalPhysicalCustody;

	public EQ4_1(WebDriver driver) {
		super(driver);

	}

	public EQ4_1 legalPhysicalCustody(Properties n600copies,
			String userLegalPhysicalCustody, String dateOfBirth) {
		if (!userLegalPhysicalCustody.equalsIgnoreCase("NA")) {

			

			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);

				if (dateOfBirth.equalsIgnoreCase("afterNov14_1986")
						|| dateOfBirth.equalsIgnoreCase("onNov14_1986")) {

					copyValidation.verifyPageLabelText(
							n600copies.getProperty("label.eq4.1.1"),
							"section-4.1.1");

				} else {
					copyValidation.verifyPageLabelText(
							n600copies.getProperty("label.eq4.1.2"),
							"section-4.1.1");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			legalPhysicalCustody = new YesNo(driver,
					"quiz.legalPhysicalCustody");
			legalPhysicalCustody.setYesOrNo(userLegalPhysicalCustody);
			saveScreenShot("n600", "EQ4_1"); clickContinueInEQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ5_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ5_1 extends WizardPage{

	public Sites site;

	public YesNo permanentResidence;

	public EQ5_1(WebDriver driver) {
		super(driver);

	}

	public EQ5_1 admittedAsPermanentResident(Properties n600copies,
			String permanentResident, String dateOfBirth) {

		if (!permanentResident.equalsIgnoreCase("NA")) {

			

			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);

				if (dateOfBirth.equalsIgnoreCase("afterNov14_1986")
						|| dateOfBirth.equalsIgnoreCase("onNov14_1986")) {

					copyValidation.verifyPageLabelText(
							n600copies.getProperty("label.eq5.1.1"),
							"section-5.1.1");

				} else {
					copyValidation.verifyPageLabelText(
							n600copies.getProperty("label.eq5.1.2"),
							"section-5.1.1");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			permanentResidence = new YesNo(driver, "quiz.permanentResidence");
			permanentResidence.setYesOrNo(permanentResident);

			saveScreenShot("n600", "EQ5_1"); clickContinueInEQ();
		}
		return this;
	}

}

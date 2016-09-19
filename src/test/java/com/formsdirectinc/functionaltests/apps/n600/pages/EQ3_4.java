package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for EQ3_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ3_4 extends WizardPage

{

	public Sites site;
	public YesNo priorBirthParentsPhysicallyPresent;

	public EQ3_4(WebDriver driver) {
		super(driver);

	}

	public EQ3_4 parents_PhysicallyPresentInUS(Properties n600copies,
			String parentPhysicallyPresentInUS) {

		if (!parentPhysicallyPresentInUS.equalsIgnoreCase("NA")) {

			
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(
						n600copies.getProperty("label.eq3.4"), "section-3.4.1");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			priorBirthParentsPhysicallyPresent = new YesNo(driver,
					"quiz.priorBirthPPhysicallyPresent");
			priorBirthParentsPhysicallyPresent.setYesOrNo(parentPhysicallyPresentInUS);
		

			saveScreenShot("n600", "EQ3_4"); clickContinueInEQ();
		}
		return this;
	}

}

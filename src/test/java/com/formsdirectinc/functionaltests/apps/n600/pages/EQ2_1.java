package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * Page model for EQ2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ2_1 extends WizardPage {
	public DateTag dateTag;
	public Sites site;

	public EQ2_1(WebDriver driver) {
		super(driver);

	}

	public EQ2_1 dateOfBirth(Properties n600copies, String birthDate) {
		
		PropertyResource propertyFile=new PropertyResource();
		Properties data = propertyFile.loadProperty("name");
		
		if (!birthDate.equalsIgnoreCase("NA")) {

			
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(
						n600copies.getProperty("label.eq2.1"), "section-2.1.1");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			dateTag = new DateTag(driver, "quiz.dateOfBirth");

			if (birthDate.equalsIgnoreCase("beforeNov14_1986")) {
				dateTag.selectDate(data.getProperty("beforeNov14_1986"));
			}

			else if (birthDate.equalsIgnoreCase("afterNov14_1986")) {
				dateTag.selectDate(data.getProperty("afterNov14_1986"));
			}

			else if (birthDate.equalsIgnoreCase("onNov14_1986")) {
				dateTag.selectDate(data.getProperty("onNov14_1986"));
			}

			saveScreenShot("n600", "EQ2_1"); clickContinueInEQ();
		}
		return this;
	}

}

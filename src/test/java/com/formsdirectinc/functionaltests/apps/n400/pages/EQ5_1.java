package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for EQ5_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ5_1 extends WizardPage {

	public YesNo sameState3Months;
	public Sites site;

	public EQ5_1(WebDriver driver) {
		super(driver);

	}

	public EQ5_1 sameState3Months(Properties n400copies,
			String wereYouInSameStateFor3Months) {
		if (wereYouInSameStateFor3Months.equalsIgnoreCase("yes")
				|| wereYouInSameStateFor3Months.equalsIgnoreCase("no")) {
			System.out.println("5.1-----------------------------------"
					+ wereYouInSameStateFor3Months);
			
			try {
				PageCopiesAndContent copyValidation = new PageCopiesAndContent(
						driver);
				copyValidation.verifyPageLabelText(
						n400copies.getProperty("eqLabel-sameState3Months")
								+ " "
								+ n400copies.getProperty("label-LearnMore"),
						"section-5.1.1");
				/*copyValidation.verifyLearnMoreText(n400copies
						.getProperty("eq-explainthis.5.1AB"));*/
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			sameState3Months = new YesNo(driver, "quiz.sameState3Months");
			sameState3Months.setYesOrNo(wereYouInSameStateFor3Months);
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "EQ5_1");
			 clickContinueInEQ();
		}
		return this;
	}

}

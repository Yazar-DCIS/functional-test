package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_1 extends WizardPage {

	private MultiRadioOptions qualifyingStatus;
	
	public SQ2_1(WebDriver driver) {
		super(driver);

	}

	public SQ2_1 qualifyingStatus(Properties n400copies, String status) {

		
		PageCopiesAndContent copyValidation = new PageCopiesAndContent(driver);
		try {
			copyValidation.verifyPageTableHeader(n400copies
					.getProperty("SQ-2.1.pageheader"));
			copyValidation.verifyPageInstructionalText(
					n400copies.getProperty("SQ-2.1.instructionaltext.1"),
					"example");

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

		qualifyingStatus = new MultiRadioOptions(driver,
				"applicationData-formSpecific.whyEligibleForUSCitizenship");
		
		if (status.equalsIgnoreCase("5yrGreenCard")) {
			qualifyingStatus.selectOption(1);
		}

		else if (status.equalsIgnoreCase("3yrGreenCard")) {
			qualifyingStatus.selectOption(2);
		}

		else if (status.equalsIgnoreCase("workOutsideUS")) {
			qualifyingStatus.selectOption(3);
		}

		else if (status.equalsIgnoreCase("inMilitary")) {
			qualifyingStatus.selectOption(4);
		}

		else if (status.equalsIgnoreCase("spouseMilitary")) {
			qualifyingStatus.selectOption(5);
		}

		else if (status.equalsIgnoreCase("spouseOfDeceasedServiceMan")) {
			qualifyingStatus.selectOption(6);
		}

		else if (status.equalsIgnoreCase("childOfDeceasedServiceMan")) {
			qualifyingStatus.selectOption(7);
		}

		else if (status.equalsIgnoreCase("parentOfDeceasedServiceMan")) {
			qualifyingStatus.selectOption(8);
		}

		else if (status.equalsIgnoreCase("US_National")) {
			qualifyingStatus.selectOption(12);
		}

		else if (status.equalsIgnoreCase("priest")) {
			qualifyingStatus.selectOption(9);
		}

		else if (status.equalsIgnoreCase("promoteUS")) {
			qualifyingStatus.selectOption(10);
		}

		else if (status.equalsIgnoreCase("workForUSVessel")) {
			qualifyingStatus.selectOption(11);
		}

		CaptureScreen myscreen=new CaptureScreen(driver);
		myscreen.takeScreenShot("n400", "SQ2_1");
		
		 clickContinueInSQ();
		return this;
	}

}

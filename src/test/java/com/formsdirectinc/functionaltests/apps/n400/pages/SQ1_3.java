package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ1_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_3 extends WizardPage {

	private YesNo haveUsedOtherNames;
	private PageCopiesAndContent copyValidation;

	public SQ1_3(WebDriver driver) {
		super(driver);

	}

	public SQ1_3 hasUsedOtherNames(Properties data, Properties n400copies,
			String usedOtherNames, int count) {

		

		try {
			copyValidation = new PageCopiesAndContent(driver);
			copyValidation.verifyPageTableHeader(n400copies
					.getProperty("SQ-1.3.pageheader"));
			copyValidation.verifyPageLabelText(
					n400copies.getProperty("SQ-1.3.pagetext.1"),
					"section-1.3.1");

			copyValidation.getPageTitle();
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

		haveUsedOtherNames = new YesNo(driver, "personalDetails.usedOtherNames");

		if (usedOtherNames.equalsIgnoreCase("Yes")) {

			haveUsedOtherNames.yes();
			try {
				copyValidation.verifyPageSectionHeader(
						n400copies.getProperty("SQ-1.3.pagetext.2") + " "
								+ n400copies.getProperty("label-ExplainThis"),
						"section-1.3.2");
				copyValidation
						.verifyExplainThisText(
								n400copies
										.getProperty("control.explainthis.title.otherNames")
										+ n400copies
												.getProperty("control.explainthis.help.otherNames"),
								"section-1.3.2", "otherNames");

			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}

			for (int i = 0; i < count; i++) {

				Name_FirstMiddleLast moreNames = new Name_FirstMiddleLast(
						driver, "applicationData",
						"personalDetails.otherNames[" + i + "].otherNamesList");
				moreNames.setFirstNameField(data.getProperty("OtherFirsttName"+i));
				moreNames.setMiddleNameField(data.getProperty("MiddleName"));
				moreNames.setLastNameField(data.getProperty("OtherLastName"+i));
			

				if (i < count - 1) {
					CommonInputClasses otherNames = new CommonInputClasses(
							driver);
					otherNames.addAnother();
				}

			}

		}

		else if (usedOtherNames.equalsIgnoreCase("No")) {
			haveUsedOtherNames.no();
		}

		CaptureScreen myscreen=new CaptureScreen(driver);
		myscreen.takeScreenShot("n400", "SQ1_3");
		
		 clickContinueInSQ();

		return this;
	}

}

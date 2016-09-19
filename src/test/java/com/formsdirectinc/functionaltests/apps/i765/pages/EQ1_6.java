package com.formsdirectinc.functionaltests.apps.i765.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for EQ1_6 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_6 extends WizardPage {

	public MultiRadioOptions selectVisaTypeApplicable;

	public EQ1_6(WebDriver driver) {
		super(driver);
	}

	public EQ1_6 studentTypeOfApplicant(String visaApplicable) throws Exception {
		if (!visaApplicable.equalsIgnoreCase("NA")) {
			
			selectVisaTypeApplicable = new MultiRadioOptions(driver,
					"applicationData-quiz.visaType");
			if (visaApplicable.equalsIgnoreCase("J-2Visa")) {
				selectVisaTypeApplicable.selectOption(1);
			}
			else if (visaApplicable.equalsIgnoreCase("L-2Visa")) {
				selectVisaTypeApplicable.selectOption(2);
			}
			else if (visaApplicable.equalsIgnoreCase("A-1/A-2Visa")) {
				selectVisaTypeApplicable.selectOption(3);
			}
			else if (visaApplicable.equalsIgnoreCase("A-3Visa")) {
				selectVisaTypeApplicable.selectOption(4);
			}
			else if (visaApplicable.equalsIgnoreCase("E-1/E-2Visa")) {
				selectVisaTypeApplicable.selectOption(5);
			}
			else if (visaApplicable.equalsIgnoreCase("E-3Visa")) {
				selectVisaTypeApplicable.selectOption(6);
			}
			else if (visaApplicable.equalsIgnoreCase("G-1/G-3/G-4Visa")) {
				selectVisaTypeApplicable.selectOption(7);
			}
			else if (visaApplicable.equalsIgnoreCase("H-4Visa")) {
				selectVisaTypeApplicable.selectOption(8);
			}
			else if (visaApplicable.equalsIgnoreCase("N-8/N-9Visa")) {
				selectVisaTypeApplicable.selectOption(9);
			}
			else if (visaApplicable.equalsIgnoreCase("U-2/U-3/U-4/U-5Visa")) {
				selectVisaTypeApplicable.selectOption(10);
			}
			else if (visaApplicable.equalsIgnoreCase("T-2/T-3/T-4Visa")) {
				selectVisaTypeApplicable.selectOption(11);
			}
			else if (visaApplicable.equalsIgnoreCase("None")) {
				selectVisaTypeApplicable.selectOption(12);
			}

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}

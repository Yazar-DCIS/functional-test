package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for EQ1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_1 extends WizardPage {

	public MultiRadioOptions immigrantstatus;

	public EQ1_1(WebDriver driver) {
		super(driver);

	}

	public EQ1_1 immigrantStatus(String answer, Properties data) {
		if (!answer.equalsIgnoreCase("NA")) {

			immigrantstatus = new MultiRadioOptions(driver,
					"applicationData-quiz.bestApplies");
			if (answer.equalsIgnoreCase("USCitizen_SponserSpouse")) {

				immigrantstatus.selectOption(1);
			}

			else if (answer.equalsIgnoreCase("USCitizen_SponserChild")) {

				immigrantstatus.selectOption(2);
			}

			else if (answer.equalsIgnoreCase("USCitizen_SponserParent")) {

				immigrantstatus.selectOption(3);
			}

			else if (answer.equalsIgnoreCase("permanentResident_SponserSpouse")) {

				immigrantstatus.selectOption(4);
			}

			else if (answer.equalsIgnoreCase("permanentResident_SponserChild")) {

				immigrantstatus.selectOption(5);
			}

			else if (answer.equalsIgnoreCase("USCitizen_sponserSibling")) {

				immigrantstatus.selectOption(6);
			}

			else if (answer.equalsIgnoreCase("None")) {

				immigrantstatus.selectOption(7);
			}

			saveScreenShot("i130", "EQ1_1"); clickContinueInEQ();
		}
		return this;
	}

}

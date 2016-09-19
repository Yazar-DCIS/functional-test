package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for EQ6_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ6_1 extends WizardPage {

	public MultiRadioOptions userIs;
	public Sites site;
	public PageCopiesAndContent copyValidation;
	

	SelectElement checkSublabel;
	String[] expContents = new String[12];

	public EQ6_1(WebDriver driver) {
		super(driver);

	}

	public EQ6_1 userServiceStatus(Properties n400copies,
			String statusThatAppliesBestToYou) {

		if (statusThatAppliesBestToYou.equalsIgnoreCase("inMilitary")
				|| statusThatAppliesBestToYou.equalsIgnoreCase("wasInMilitary")
				|| statusThatAppliesBestToYou.equalsIgnoreCase("discharged")
				|| statusThatAppliesBestToYou
						.equalsIgnoreCase("deceasedServiceMen_spouse")
				|| statusThatAppliesBestToYou
						.equalsIgnoreCase("deceasedServiceMen_child")
				|| statusThatAppliesBestToYou
						.equalsIgnoreCase("deceasedServiceMen_parent")
				|| statusThatAppliesBestToYou
						.equalsIgnoreCase("currentServiceMen_spouse")
				|| statusThatAppliesBestToYou.equalsIgnoreCase("employee")
				|| statusThatAppliesBestToYou
						.equalsIgnoreCase("priestAttender")
				|| statusThatAppliesBestToYou.equalsIgnoreCase("workOutOfUS")
				|| statusThatAppliesBestToYou.equalsIgnoreCase("servingUS")
				|| statusThatAppliesBestToYou.equalsIgnoreCase("none")) {
			System.out.println("6.1-----------------------------------"
					+ statusThatAppliesBestToYou);

			
			try {
				copyValidation = new PageCopiesAndContent(driver);
				copyValidation.verifyPageLabelText(
						n400copies.getProperty("eqLabel-bestApplies"),
						"section-6.1.1");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			userIs = new MultiRadioOptions(driver,
					"applicationData-quiz.bestApplies");

			if (statusThatAppliesBestToYou.equalsIgnoreCase("inMilitary")) {

				try {
					// the number represents the index of sub-label
					copyValidation.verifySubLabelsText(
							n400copies.getProperty("eqLabel-bestApplies.1"),
							"section-6.1.1", 0);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				userIs.selectOption(1);
			}

			else if (statusThatAppliesBestToYou.equalsIgnoreCase("wasInMilitary")) {
				try {
					copyValidation.verifySubLabelsText(
							n400copies.getProperty("eqLabel-bestApplies.2"),
							"section-6.1.1", 1);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				userIs.selectOption(2);
			}

			else if (statusThatAppliesBestToYou.equalsIgnoreCase("discharged")) {
				try {
					copyValidation.verifySubLabelsText(
							n400copies.getProperty("eqLabel-bestApplies.3"),
							"section-6.1.1", 2);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				userIs.selectOption(3);
			}

			else if (statusThatAppliesBestToYou
					.equalsIgnoreCase("deceasedServiceMen_spouse")) {
				try {
					copyValidation.verifySubLabelsText(
							n400copies.getProperty("eqLabel-bestApplies.4"),
							"section-6.1.1", 3);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				userIs.selectOption(4);
			}

			else if (statusThatAppliesBestToYou
					.equalsIgnoreCase("deceasedServiceMen_child")) {
				try {
					copyValidation.verifySubLabelsText(
							n400copies.getProperty("eqLabel-bestApplies.5"),
							"section-6.1.1", 4);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				userIs.selectOption(5);

			}

			else if (statusThatAppliesBestToYou
					.equalsIgnoreCase("deceasedServiceMen_parent")) {
				try {
					copyValidation.verifySubLabelsText(
							n400copies.getProperty("eqLabel-bestApplies.6"),
							"section-6.1.1", 5);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				userIs.selectOption(6);
			}

			else if (statusThatAppliesBestToYou
					.equalsIgnoreCase("currentServiceMen_spouse")) {
				try {
					copyValidation.verifySubLabelsText(
							n400copies.getProperty("eqLabel-bestApplies.7"),
							"section-6.1.1", 6);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				userIs.selectOption(7);
			}

			else if (statusThatAppliesBestToYou.equalsIgnoreCase("employee")) {
				try {
					copyValidation.verifySubLabelsText(
							n400copies.getProperty("eqLabel-bestApplies.8"),
							"section-6.1.1", 7);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				userIs.selectOption(8);

			}

			else if (statusThatAppliesBestToYou.equalsIgnoreCase("priestAttender")) {
				try {
					copyValidation.verifySubLabelsText(
							n400copies.getProperty("eqLabel-bestApplies.9"),
							"section-6.1.1", 8);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				userIs.selectOption(9);
			}

			else if (statusThatAppliesBestToYou.equalsIgnoreCase("workOutOfUS")) {
				try {
					copyValidation.verifySubLabelsText(
							n400copies.getProperty("eqLabel-bestApplies.10"),
							"section-6.1.1", 9);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				userIs.selectOption(10);
			}

			else if (statusThatAppliesBestToYou.equalsIgnoreCase("servingUS")) {
				try {
					copyValidation.verifySubLabelsText(
							n400copies.getProperty("eqLabel-bestApplies.11"),
							"section-6.1.1", 10);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				userIs.selectOption(11);
			}

			else if (statusThatAppliesBestToYou.equalsIgnoreCase("none")) {
				try {
					copyValidation.verifySubLabelsText(
							n400copies.getProperty("eqLabel-bestApplies.12"),
							"section-6.1.1", 11);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				userIs.selectOption(12);
			}
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "EQ6_1");
			 clickContinueInEQ();

		}

		return this;
	}

}

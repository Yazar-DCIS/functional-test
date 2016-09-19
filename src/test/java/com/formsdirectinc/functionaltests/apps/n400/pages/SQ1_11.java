package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.Gender;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.PhysicalTraits;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_11 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ1_11 extends WizardPage {

	private Gender gender;
	private PhysicalTraits height, heightOption;
	private YesNo origin;
	private MultiRadioOptions hairColor, eyeColor;

	public SQ1_11(WebDriver driver) {
		super(driver);

	}

	public SQ1_11 physicalTraits(Properties n400copies, Properties data,
			String selectGender, String selectHeight, String selectOrigin,
			String selectRace, String selectHairColor, String selectEyeColor) {

		
		PageCopiesAndContent copyValidation = new PageCopiesAndContent(driver);
		try {
			copyValidation.verifyPageTableHeader(n400copies
					.getProperty("SQ-1.11.pageheader"));

			for (int i = 0; i <= 2; i++) {
				copyValidation.verifyMultipleLabelText(
						n400copies.getProperty("SQ-1.11.pagetext." + i),
						"section-1.11.1", i);
			}

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

		gender = new Gender(driver, "applicationData-applicant.sex");
		gender.setGender(selectGender);

		heightOption = new PhysicalTraits(driver, "applicationData",
				"personalDetails.height.heightoption");
		height = new PhysicalTraits(driver, "applicationData",
				"personalDetails.height");
		if (selectHeight.equalsIgnoreCase("english")) {
			heightOption.heightEnglish();
			height.selectHeightinFeetN400(data.getProperty("Feet"));
			height.selectHeightinInches(data.getProperty("Inches"));
		}

		else if (selectHeight.equalsIgnoreCase("metric")) {
			heightOption.heightMetric();
			height.setHeightinCentimetre(data.getProperty("Centimeters"));
		}

		try {

			copyValidation.verifyMultipleLabelText(
					n400copies.getProperty("SQ-1.11.pagetext.2"),
					"section-1.11.2", 0);
			copyValidation.verifyExplainThisText(n400copies
					.getProperty("control.explainthis.help.personalDetails"),
					"section-1.11.2", "personalDetails");

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		// Are you Hispanic or Latino?
		origin = new YesNo(driver, "personalDetails.hispanicorLatino");
		origin.setYesOrNo(selectOrigin);
		

		try {

			copyValidation.verifyMultipleLabelText(
					n400copies.getProperty("SQ-1.11.pagetext.3"),
					"section-1.11.2", 1);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		
		// What is your race?
		PhysicalTraits setRace=new PhysicalTraits(driver);
		setRace.setRaceOptions("personalDetails", selectRace);
	
		// What is your hair color?
		try {

			copyValidation.verifyMultipleLabelText(
					n400copies.getProperty("SQ-1.11.pagetext.4"),
					"section-1.11.3", 0);
			copyValidation.verifyExplainThisText(n400copies
					.getProperty("control.explainthis.help.1.11f.header"),
					"section-1.11.3",
					"requireexplainheader-personalDetails.hairColor");

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		hairColor = new MultiRadioOptions(driver,
				"applicationData-personalDetails.hairColor");
		if (selectHairColor.equalsIgnoreCase("Black")) {
			hairColor.selectOption(1);
		}
		else if (selectHairColor.equalsIgnoreCase("Brown")) {
			hairColor.selectOption(2);
		}
		else if (selectHairColor.equalsIgnoreCase("Blonde")) {
			hairColor.selectOption(3);
		}
		else if (selectHairColor.equalsIgnoreCase("Gray")) {
			hairColor.selectOption(4);
		}
		else if (selectHairColor.equalsIgnoreCase("White")) {
			hairColor.selectOption(5);
		}
		else if (selectHairColor.equalsIgnoreCase("Red")) {
			hairColor.selectOption(6);
		}
		else if (selectHairColor.equalsIgnoreCase("Sandy")) {
			hairColor.selectOption(7);
		}
		else if (selectHairColor.equalsIgnoreCase("Bald")) {
			hairColor.selectOption(8);
		}

		try {

			copyValidation.verifyMultipleLabelText(
					n400copies.getProperty("SQ-1.11.pagetext.5"),
					"section-1.11.3", 1);
			copyValidation.verifyMultipleExplainText(n400copies
					.getProperty("control.explainthis.help.1.11g.header"), 1,
					"requireexplainheader-personalDetails.eyeColor");
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
		eyeColor = new MultiRadioOptions(driver,
				"applicationData-personalDetails.eyeColor");
		if (selectEyeColor.equalsIgnoreCase("Brown")) {
			eyeColor.selectOption(1);
		}
		else if (selectEyeColor.equalsIgnoreCase("Blue")) {
			eyeColor.selectOption(2);
		}
		else if (selectEyeColor.equalsIgnoreCase("Green")) {
			eyeColor.selectOption(3);
		}
		else if (selectEyeColor.equalsIgnoreCase("Hazel")) {
			eyeColor.selectOption(4);
		}
		else if (selectEyeColor.equalsIgnoreCase("Gray")) {
			eyeColor.selectOption(5);
		}
		else if (selectEyeColor.equalsIgnoreCase("Black")) {
			eyeColor.selectOption(6);
		}
		else if (selectEyeColor.equalsIgnoreCase("Pink")) {
			eyeColor.selectOption(7);
		}
		else if (selectEyeColor.equalsIgnoreCase("Maroon")) {
			eyeColor.selectOption(8);
		}
		else if (selectEyeColor.equalsIgnoreCase("Other")) {
			eyeColor.selectOption(9);
		}

		CaptureScreen myscreen=new CaptureScreen(driver);
		myscreen.takeScreenShot("n400", "SQ1_11");
		
		 clickContinueInSQ();

		return this;
	}

}

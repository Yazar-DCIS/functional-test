package com.formsdirectinc.functionaltests.apps.i130;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_1;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_10;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_11;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_12;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_13;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_13_1;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_13_2;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_14;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_15;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_16;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_17;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_2;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_20;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_21;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_21_1;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_21_2;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_22;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_23;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_24;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_24_1;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_24_2;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_25;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_25_1;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_25_2;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_26;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_26_1;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_26_2;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_27;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_28;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_29;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_3;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_30;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_31;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_32;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_33;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_34;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_35;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_36;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_36_1;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_36_2;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_37;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_37_1;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_37_2;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_38;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_39;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_4;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_40;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_41;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_42;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_43;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_43_1;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_43_2;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_43_3;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_43_4;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_44;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_45;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_46;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_47;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_48;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_49;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_4_1;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_4_2;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_5;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_6;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_7;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_8;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_8_1;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_8_2;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_9;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.EQ_InEligible;
import com.formsdirectinc.functionaltests.tags.EQ_Success;
import com.formsdirectinc.functionaltests.tags.Quiz_Options;
import com.formsdirectinc.functionaltests.tags.ReadDataFromExcelSheet;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.StartApplication;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * @author Orina
 * @Product I130 EligiblityQuestions
 */

public class EligiblityQuestions extends Step {

	public EligiblityQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String appName = Products.I130.name();
	Sites site = Sites.valueOf(System.getProperty("site.name"));

	public void test(String product, String flowname) throws Exception {

		ReadDataFromExcelSheet readFromExcelSheet = new ReadDataFromExcelSheet();
		String i130Sheet = "I130";
		readFromExcelSheet.initializeWorkbook(i130Sheet);
		Integer fieldContent = readFromExcelSheet.getRowNumberUsingContent(flowname);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Sites site = Sites.valueOf(System.getProperty("site.name"));
		
		PropertyResource propertyFile = new PropertyResource();
		Properties copiesOfI130 = propertyFile.loadProperty(appName);

		if (site != Sites.FR) {
			driver.get(site.getProductURL());
			SelectElement productName = new SelectElement(driver, "I-130");
			productName.selectElementUsingPartialLinkText();
		}
		
		if (site == Sites.FR) {
			driver.get(site.getBaseURL()+"immigration-solutions/petition-for-relative/");
		}
		
		StartApplication start = PageFactory.initElements(driver,
				StartApplication.class);
		start.startApplication(appName);

		if (site != Sites.FR) {
		Quiz_Options takeQuiz = PageFactory.initElements(driver,
				Quiz_Options.class);
		takeQuiz.takeQuiz(appName);
		}
		
		EQ1_1 eq1_1 = PageFactory.initElements(driver, EQ1_1.class);
		eq1_1.immigrantStatus(
				readFromExcelSheet.getCellStringContent(fieldContent, 1),
				copiesOfI130);

		EQ1_2 eq1_2 = PageFactory.initElements(driver, EQ1_2.class);
		eq1_2.physicalPresenceAtWedding(
				readFromExcelSheet.getCellStringContent(fieldContent, 2),
				copiesOfI130);

		EQ1_3 eq1_3 = PageFactory.initElements(driver, EQ1_3.class);
		eq1_3.applicantCurrentlyLivingInUS(
				readFromExcelSheet.getCellStringContent(fieldContent, 3),
				copiesOfI130);

		EQ1_4 eq1_4 = PageFactory.initElements(driver, EQ1_4.class);
		eq1_4.spouseCurrentlyLivingInUS(
				readFromExcelSheet.getCellStringContent(fieldContent, 4),
				copiesOfI130);

		EQ1_4_1 eq1_4_1 = PageFactory.initElements(driver, EQ1_4_1.class);
		eq1_4_1.spouseInspectedLastEntryUS(
				readFromExcelSheet.getCellStringContent(fieldContent, 5),
				copiesOfI130);

		EQ1_4_2 eq1_4_2 = PageFactory.initElements(driver, EQ1_4_2.class);
		eq1_4_2.spouseLivingUSUnderLegalStatus(
				readFromExcelSheet.getCellStringContent(fieldContent, 6),
				copiesOfI130);

		EQ1_5 eq1_5 = PageFactory.initElements(driver, EQ1_5.class);
		eq1_5.applicantCurrentlyLivingInUS(
				readFromExcelSheet.getCellStringContent(fieldContent, 7),
				copiesOfI130);

		EQ1_6 eq1_6 = PageFactory.initElements(driver, EQ1_6.class);
		eq1_6.applicantisBPOfBeneficiary(
				readFromExcelSheet.getCellStringContent(fieldContent, 8),
				copiesOfI130);

		EQ1_7 eq1_7 = PageFactory.initElements(driver, EQ1_7.class);
		eq1_7.childUnderTwentyOne(
				readFromExcelSheet.getCellStringContent(fieldContent, 9),
				copiesOfI130);

		EQ1_8 eq1_8 = PageFactory.initElements(driver, EQ1_8.class);
		eq1_8.childCurrentlyLivingInUS(
				readFromExcelSheet.getCellStringContent(fieldContent, 10),
				copiesOfI130);

		EQ1_8_1 eq1_8_1 = PageFactory.initElements(driver, EQ1_8_1.class);
		eq1_8_1.childInspectedLastEntryUS(
				readFromExcelSheet.getCellStringContent(fieldContent, 11),
				copiesOfI130);

		EQ1_8_2 eq1_8_2 = PageFactory.initElements(driver, EQ1_8_2.class);
		eq1_8_2.childLivingUSUnderLegalStatus(
				readFromExcelSheet.getCellStringContent(fieldContent, 12),
				copiesOfI130);

		EQ1_9 eq1_9 = PageFactory.initElements(driver, EQ1_9.class);
		eq1_9.adoptedChild(
				readFromExcelSheet.getCellStringContent(fieldContent, 13),
				copiesOfI130);

		EQ1_10 eq1_10 = PageFactory.initElements(driver, EQ1_10.class);
		eq1_10.stepParent(
				readFromExcelSheet.getCellStringContent(fieldContent, 14),
				copiesOfI130);

		EQ1_11 eq1_11 = PageFactory.initElements(driver, EQ1_11.class);
		eq1_11.marriageBeforeEighteenthBirthday(
				readFromExcelSheet.getCellStringContent(fieldContent, 15),
				copiesOfI130);

		EQ1_12 eq1_12 = PageFactory.initElements(driver, EQ1_12.class);
		eq1_12.childUnderTwentyOne(
				readFromExcelSheet.getCellStringContent(fieldContent, 16),
				copiesOfI130);

		EQ1_13 eq1_13 = PageFactory.initElements(driver, EQ1_13.class);
		eq1_13.childCurrentlyLivingInUS(
				readFromExcelSheet.getCellStringContent(fieldContent, 17),
				copiesOfI130);

		EQ1_13_1 eq1_13_1 = PageFactory.initElements(driver, EQ1_13_1.class);
		eq1_13_1.childInspectedLastEntryUS(
				readFromExcelSheet.getCellStringContent(fieldContent, 18),
				copiesOfI130);

		EQ1_13_2 eq1_13_2 = PageFactory.initElements(driver, EQ1_13_2.class);
		eq1_13_2.childLivingUSUnderLegalStatus(
				readFromExcelSheet.getCellStringContent(fieldContent, 19),
				copiesOfI130);

		EQ1_14 eq1_14 = PageFactory.initElements(driver, EQ1_14.class);
		eq1_14.atLeastTwentyOneYears(
				readFromExcelSheet.getCellStringContent(fieldContent, 20),
				copiesOfI130);

		EQ1_15 eq1_15 = PageFactory.initElements(driver, EQ1_15.class);
		eq1_15.applicantCurrentlyLivingInUS(
				readFromExcelSheet.getCellStringContent(fieldContent, 21),
				copiesOfI130);

		EQ1_16 eq1_16 = PageFactory.initElements(driver, EQ1_16.class);
		eq1_16.applicantsParentBiological(
				readFromExcelSheet.getCellStringContent(fieldContent, 22),
				copiesOfI130);

		EQ1_17 eq1_17 = PageFactory.initElements(driver, EQ1_17.class);
		eq1_17.parentAdoptedYou(
				readFromExcelSheet.getCellStringContent(fieldContent, 23),
				copiesOfI130);

		EQ1_20 eq1_20 = PageFactory.initElements(driver, EQ1_20.class);
		eq1_20.adoptedBySomeone(
				readFromExcelSheet.getCellStringContent(fieldContent, 24),
				copiesOfI130);

		EQ1_21 eq1_21 = PageFactory.initElements(driver, EQ1_21.class);
		eq1_21.parentLivingInTheUS(
				readFromExcelSheet.getCellStringContent(fieldContent, 25),
				copiesOfI130);

		EQ1_21_1 eq1_21_1 = PageFactory.initElements(driver, EQ1_21_1.class);
		eq1_21_1.parentInspectedLastEntryUS(
				readFromExcelSheet.getCellStringContent(fieldContent, 26),
				copiesOfI130);

		EQ1_21_2 eq1_21_2 = PageFactory.initElements(driver, EQ1_21_2.class);
		eq1_21_2.parentLivingUSUnderLegalStatus(
				readFromExcelSheet.getCellStringContent(fieldContent, 27),
				copiesOfI130);

		EQ1_22 eq1_22 = PageFactory.initElements(driver, EQ1_22.class);
		eq1_22.stepParent(
				readFromExcelSheet.getCellStringContent(fieldContent, 28),
				copiesOfI130);

		EQ1_23 eq1_23 = PageFactory.initElements(driver, EQ1_23.class);
		eq1_23.stepParentMarriedBP(
				readFromExcelSheet.getCellStringContent(fieldContent, 29),
				copiesOfI130);

		EQ1_24 eq1_24 = PageFactory.initElements(driver, EQ1_24.class);
		eq1_24.parentLivingInTheUS(
				readFromExcelSheet.getCellStringContent(fieldContent, 30),
				copiesOfI130);

		EQ1_24_1 eq1_24_1 = PageFactory.initElements(driver, EQ1_24_1.class);
		eq1_24_1.parentInspectedLastEntryUS(
				readFromExcelSheet.getCellStringContent(fieldContent, 31),
				copiesOfI130);

		EQ1_24_2 eq1_24_2 = PageFactory.initElements(driver, EQ1_24_2.class);
		eq1_24_2.parentLivingUSUnderLegalStatus(
				readFromExcelSheet.getCellStringContent(fieldContent, 32),
				copiesOfI130);

		EQ1_25 eq1_25 = PageFactory.initElements(driver, EQ1_25.class);
		eq1_25.marriageBeforeBecomingPR(
				readFromExcelSheet.getCellStringContent(fieldContent, 33),
				copiesOfI130);

		EQ1_25_1 eq1_25_1 = PageFactory.initElements(driver, EQ1_25_1.class);
		eq1_25_1.lawfulPermanentResident(
				readFromExcelSheet.getCellStringContent(fieldContent, 34),
				copiesOfI130);

		EQ1_25_2 eq1_25_2 = PageFactory.initElements(driver, EQ1_25_2.class);
		eq1_25_2.applicantCurrentlyLivingInUS(
				readFromExcelSheet.getCellStringContent(fieldContent, 35),
				copiesOfI130);

		EQ1_26 eq1_26 = PageFactory.initElements(driver, EQ1_26.class);
		eq1_26.spouseCurrentlyLivingInUS(
				readFromExcelSheet.getCellStringContent(fieldContent, 36),
				copiesOfI130);

		EQ1_26_1 eq1_26_1 = PageFactory.initElements(driver, EQ1_26_1.class);
		eq1_26_1.spouseInspectedLastEntryUS(
				readFromExcelSheet.getCellStringContent(fieldContent, 37),
				copiesOfI130);

		EQ1_26_2 eq1_26_2 = PageFactory.initElements(driver, EQ1_26_2.class);
		eq1_26_2.spouseLivingUSUnderLegalStatus(
				readFromExcelSheet.getCellStringContent(fieldContent, 38),
				copiesOfI130);

		EQ1_27 eq1_27 = PageFactory.initElements(driver, EQ1_27.class);
		eq1_27.legalPermanentResident(
				readFromExcelSheet.getCellStringContent(fieldContent, 39),
				copiesOfI130);

		EQ1_28 eq1_28 = PageFactory.initElements(driver, EQ1_28.class);
		eq1_28.physicallyPresent(
				readFromExcelSheet.getCellStringContent(fieldContent, 40),
				copiesOfI130);

		EQ1_29 eq1_29 = PageFactory.initElements(driver, EQ1_29.class);
		eq1_29.husbandOrWifeRescissionProceeding(
				readFromExcelSheet.getCellStringContent(fieldContent, 41),
				copiesOfI130);

		EQ1_30 eq1_30 = PageFactory.initElements(driver, EQ1_30.class);
		eq1_30.permanentResidentFiveYearsAgo(
				readFromExcelSheet.getCellStringContent(fieldContent, 42),
				copiesOfI130);

		EQ1_31 eq1_31 = PageFactory.initElements(driver, EQ1_31.class);
		eq1_31.physicallyPresent(
				readFromExcelSheet.getCellStringContent(fieldContent, 43),
				copiesOfI130);

		EQ1_32 eq1_32 = PageFactory.initElements(driver, EQ1_32.class);
		eq1_32.husbandOrWifeRescissionProceeding(
				readFromExcelSheet.getCellStringContent(fieldContent, 44),
				copiesOfI130);

		EQ1_33 eq1_33 = PageFactory.initElements(driver, EQ1_33.class);
		eq1_33.priorMarriageTerminated(
				readFromExcelSheet.getCellStringContent(fieldContent, 45),
				copiesOfI130);

		EQ1_34 eq1_34 = PageFactory.initElements(driver, EQ1_34.class);
		eq1_34.physicallyPresent(
				readFromExcelSheet.getCellStringContent(fieldContent, 46),
				copiesOfI130);

		EQ1_35 eq1_35 = PageFactory.initElements(driver, EQ1_35.class);
		eq1_35.husbandOrWifeRescissionProceeding(
				readFromExcelSheet.getCellStringContent(fieldContent, 47),
				copiesOfI130);

		EQ1_36 eq1_36 = PageFactory.initElements(driver, EQ1_36.class);
		eq1_36.childBornBeforePR(
				readFromExcelSheet.getCellStringContent(fieldContent, 48),
				copiesOfI130);

		EQ1_36_1 eq1_36_1 = PageFactory.initElements(driver, EQ1_36_1.class);
		eq1_36_1.lawfulPermanentResident(
				readFromExcelSheet.getCellStringContent(fieldContent, 49),
				copiesOfI130);

		EQ1_36_2 eq1_36_2 = PageFactory.initElements(driver, EQ1_36_2.class);
		eq1_36_2.applicantCurrentlyLivingInUS(
				readFromExcelSheet.getCellStringContent(fieldContent, 50),
				copiesOfI130);

		EQ1_37 eq1_37 = PageFactory.initElements(driver, EQ1_37.class);
		eq1_37.childCurrentlyLivingInUS(
				readFromExcelSheet.getCellStringContent(fieldContent, 51),
				copiesOfI130);

		EQ1_37_1 eq1_37_1 = PageFactory.initElements(driver, EQ1_37_1.class);
		eq1_37_1.childInspectedLastEntryUS(
				readFromExcelSheet.getCellStringContent(fieldContent, 52),
				copiesOfI130);

		EQ1_37_2 eq1_37_2 = PageFactory.initElements(driver, EQ1_37_2.class);
		eq1_37_2.childLivingUSUnderLegalStatus(
				readFromExcelSheet.getCellStringContent(fieldContent, 53),
				copiesOfI130);

		EQ1_38 eq1_38 = PageFactory.initElements(driver, EQ1_38.class);
		eq1_38.childMarried(
				readFromExcelSheet.getCellStringContent(fieldContent, 54),
				copiesOfI130);

		EQ1_39 eq1_39 = PageFactory.initElements(driver, EQ1_39.class);
		eq1_39.biologicalParentOfTheChild(
				readFromExcelSheet.getCellStringContent(fieldContent, 55),
				copiesOfI130);

		EQ1_40 eq1_40 = PageFactory.initElements(driver, EQ1_40.class);
		eq1_40.adoptedChild(
				readFromExcelSheet.getCellStringContent(fieldContent, 56),
				copiesOfI130);

		EQ1_41 eq1_41 = PageFactory.initElements(driver, EQ1_41.class);
		eq1_41.stepParent(
				readFromExcelSheet.getCellStringContent(fieldContent, 57),
				copiesOfI130);

		EQ1_42 eq1_42 = PageFactory.initElements(driver, EQ1_42.class);
		eq1_42.marriageBeforeEighteenthBirthday(
				readFromExcelSheet.getCellStringContent(fieldContent, 58),
				copiesOfI130);

		EQ1_43 eq1_43 = PageFactory.initElements(driver, EQ1_43.class);
		eq1_43.atLeastTwentyOneYears(
				readFromExcelSheet.getCellStringContent(fieldContent, 59),
				copiesOfI130);

		EQ1_43_1 eq1_43_1 = PageFactory.initElements(driver, EQ1_43_1.class);
		eq1_43_1.applicantCurrentlyLivingInUS(
				readFromExcelSheet.getCellStringContent(fieldContent, 60),
				copiesOfI130);

		EQ1_43_2 eq1_43_2 = PageFactory.initElements(driver, EQ1_43_2.class);
		eq1_43_2.brotherOrSisterCurrentlyLivingInUS(
				readFromExcelSheet.getCellStringContent(fieldContent, 61),
				copiesOfI130);

		EQ1_43_3 eq1_43_3 = PageFactory.initElements(driver, EQ1_43_3.class);
		eq1_43_3.brotherOrSisterInspectedLastEntryUS(
				readFromExcelSheet.getCellStringContent(fieldContent, 62),
				copiesOfI130);

		EQ1_43_4 eq1_43_4 = PageFactory.initElements(driver, EQ1_43_4.class);
		eq1_43_4.brotherOrSisteLivingUSUnderLegalStatus(
				readFromExcelSheet.getCellStringContent(fieldContent, 63),
				copiesOfI130);

		EQ1_44 eq1_44 = PageFactory.initElements(driver, EQ1_44.class);
		eq1_44.sameBiologicalParents(
				readFromExcelSheet.getCellStringContent(fieldContent, 64),
				copiesOfI130);

		EQ1_45 eq1_45 = PageFactory.initElements(driver, EQ1_45.class);
		eq1_45.adoptedByNonBiologicalParents(
				readFromExcelSheet.getCellStringContent(fieldContent, 65),
				copiesOfI130);

		EQ1_46 eq1_46 = PageFactory.initElements(driver, EQ1_46.class);
		eq1_46.halfBrotherOrHalfSister(
				readFromExcelSheet.getCellStringContent(fieldContent, 66),
				copiesOfI130);

		EQ1_47 eq1_47 = PageFactory.initElements(driver, EQ1_47.class);
		eq1_47.siblingRelatedByAdoption(
				readFromExcelSheet.getCellStringContent(fieldContent, 67),
				copiesOfI130);

		EQ1_48 eq1_48 = PageFactory.initElements(driver, EQ1_48.class);
		eq1_48.siblingStepBrotherOrSister(
				readFromExcelSheet.getCellStringContent(fieldContent, 68),
				copiesOfI130);

		EQ1_49 eq1_49 = PageFactory.initElements(driver, EQ1_49.class);
		eq1_49.parentsMarreidBeforeEighteenth(
				readFromExcelSheet.getCellStringContent(fieldContent, 69),
				copiesOfI130);

		readFromExcelSheet.closeWorkbook();

		if(flowname.contains("InEligible"))
		{
			EQ_InEligible stopApp=PageFactory.initElements(driver, EQ_InEligible.class);
			stopApp.ineligibleApplication(appName);
		}
		else
		{
			EQ_Success startApp = PageFactory.initElements(driver, EQ_Success.class);
			startApp.startApplication(appName);
			
		}
	}

}

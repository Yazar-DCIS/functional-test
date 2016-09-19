package com.formsdirectinc.functionaltests.apps.n400;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ10_1;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ1_1;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ1_10;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ1_11;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ1_3;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ1_4;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ1_5;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ1_5_1;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ1_5_2;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ1_5_3;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ1_5_4;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ1_5_5;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ1_5_6;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ1_6;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ1_7;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ1_8;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ1_8_1;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ2_1;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ2_1_1;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ2_1_1_1;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ2_1_3;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ2_2;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ3_1;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ3_10;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ3_11;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ3_12;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ3_2;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ3_3;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ3_4;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ3_4_1;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ3_5;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ3_6;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ3_6_1;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ3_7;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ3_8;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ3_9;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ3_9_1;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ4_1;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ4_2;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ5_1;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ5_2;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ5_2_1;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ6_1;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ6_10;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ6_2;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ6_3;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ6_4;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ6_5;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ6_6;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ6_6_1;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ6_7;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ6_8;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ6_9;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ6_9_1;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ6_9_2;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ7_1;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ7_2;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ7_3;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ8_1;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ9_1;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ9_2;
import com.formsdirectinc.functionaltests.apps.n400.pages.SQ9_3;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.ApplicationReview;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.ReadDataFromExcelSheet;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * @author Orina
 * @Product N400 SimpleQuestions
 */
public class SimpleQuestions  extends Step {

	
	public SimpleQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String appName = Products.N400.name();

	Sites site = Sites.valueOf(System.getProperty("site.name"));

	public void test(String product, String flowname)
			throws Exception {

		ReadDataFromExcelSheet readFromExcelSheet = new ReadDataFromExcelSheet();
		String n400Sheet = "N400";
		readFromExcelSheet.initializeWorkbook(n400Sheet);
		Integer fieldContent = readFromExcelSheet
				.getRowNumberUsingContent(flowname);
		PropertyResource propertyFile=new PropertyResource();
		Properties n400data = propertyFile.loadProperty("name");
		Properties n400Copies = propertyFile.loadProperty(appName);
		Properties n400keys = propertyFile.loadProperty("keyValue");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		// SQ Section :
		ApplicationReview startHere = PageFactory.initElements(driver,
				ApplicationReview.class);
		CaptureScreen myscreen=new CaptureScreen(driver);
		myscreen.takeScreenShot("n400", "ApplicationCenterPage");
		startHere.selectStartApplication();
		myscreen.takeScreenShot("n400", "ReviewPage");
		startHere.selectStartHereLink();

		// Your Name
		SQ1_1 sq1_1 = PageFactory.initElements(driver, SQ1_1.class);
		sq1_1.applicantLegalName(n400data, n400Copies);

		// Other Names
		SQ1_3 sq1_3 = PageFactory.initElements(driver, SQ1_3.class);
		sq1_3.hasUsedOtherNames(n400data, n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 20),
				(int) readFromExcelSheet
						.getCellIntegerContent(fieldContent, 21));

		// Name Change
		SQ1_4 sq1_4 = PageFactory.initElements(driver, SQ1_4.class);
		sq1_4.legallyChangeName(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 22),
				n400data);

		// Residence
		SQ1_5 sq1_5 = PageFactory.initElements(driver, SQ1_5.class);
		sq1_5.residenceUS(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 23));

		// Current Address
		SQ1_5_1 sq1_5_1 = PageFactory.initElements(driver, SQ1_5_1.class);
		sq1_5_1.livingAbroad_applicantMilitary(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 24));

		// Current Address
		SQ1_5_2 sq1_5_2 = PageFactory.initElements(driver, SQ1_5_2.class);
		sq1_5_2.applicantResidenceDetails(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 25),
				n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 26),
				readFromExcelSheet.getCellStringContent(fieldContent, 27));

		// Current Address
		SQ1_5_3 sq1_5_3 = PageFactory.initElements(driver, SQ1_5_3.class);
		sq1_5_3.applicantResidenceDetails(n400Copies,
				n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 28),
				readFromExcelSheet.getCellStringContent(fieldContent, 29),
				readFromExcelSheet.getCellStringContent(fieldContent, 30));

		// Current Address
		SQ1_5_4 sq1_5_4 = PageFactory.initElements(driver, SQ1_5_4.class);
		sq1_5_4.applicantResidenceDetails(n400Copies,
				n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 31),
				readFromExcelSheet.getCellStringContent(fieldContent, 32),
				readFromExcelSheet.getCellStringContent(fieldContent, 33));

		// Address History
		SQ1_5_5 sq1_5_5 = PageFactory.initElements(driver, SQ1_5_5.class);
		sq1_5_5.applicantResidenceHistoryInfo(n400Copies, n400data, (int) readFromExcelSheet
				.getCellIntegerContent(fieldContent, 34), readFromExcelSheet
				.getCellStringContent(fieldContent, 112));

		// STOP - Attention Required -- On continue to 1.5.3
		SQ1_5_6 sq1_5_6 = PageFactory.initElements(driver, SQ1_5_6.class);
		sq1_5_6.applicantInEligible(readFromExcelSheet.getCellStringContent(fieldContent, 35),
				readFromExcelSheet.getRowNumberUsingContent(flowname));

		// Contact Information
		SQ1_6 sq1_6 = PageFactory.initElements(driver, SQ1_6.class);
		sq1_6.contactInformation(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 36));

		// Parents
		SQ1_7 sq1_7 = PageFactory.initElements(driver, SQ1_7.class);
		sq1_7.parentsDetails(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 37),
				readFromExcelSheet.getCellStringContent(fieldContent, 38),
				readFromExcelSheet.getCellStringContent(fieldContent, 39));

		// Date and Country of Birth
		SQ1_8 sq1_8 = PageFactory.initElements(driver, SQ1_8.class);
		sq1_8.applicantBirthDetails(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 40));

		// STOP - Wrong Form-- continue to 1.10
		SQ1_8_1 sq1_8_1 = PageFactory.initElements(driver, SQ1_8_1.class);
		sq1_8_1.applicantInEligible(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 41));

		// Social Security Number
		SQ1_10 sq1_10 = PageFactory.initElements(driver, SQ1_10.class);
		sq1_10.ssnDetails(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 42));

		// Physical Traits
		SQ1_11 sq1_11 = PageFactory.initElements(driver, SQ1_11.class);
		sq1_11.physicalTraits(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 43),
				readFromExcelSheet.getCellStringContent(fieldContent, 44),
				readFromExcelSheet.getCellStringContent(fieldContent, 45),
				readFromExcelSheet.getCellStringContent(fieldContent, 46),
				readFromExcelSheet.getCellStringContent(fieldContent, 47),
				readFromExcelSheet.getCellStringContent(fieldContent, 48));

		// Qualifying Status
		SQ2_1 sq2_1 = PageFactory.initElements(driver, SQ2_1.class);
		sq2_1.qualifyingStatus(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 49));

		// Military Service
		SQ2_1_1 sq2_1_1 = PageFactory.initElements(driver, SQ2_1_1.class);
		sq2_1_1.militaryServingStatus(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 113),
				(int) readFromExcelSheet.getCellIntegerContent(fieldContent,
						114), readFromExcelSheet.getCellStringContent(
						fieldContent, 115), readFromExcelSheet
						.getCellStringContent(fieldContent, 116));

		// Enlistment Information
		SQ2_1_1_1 sq2_1_1_1 = PageFactory.initElements(driver, SQ2_1_1_1.class);
		sq2_1_1_1.enlistmentInfo(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 117),
				(int) readFromExcelSheet.getCellIntegerContent(fieldContent,
						114));

		// Name(s) During Military Service
		SQ2_1_3 sq2_1_3 = PageFactory.initElements(driver, SQ2_1_3.class);
		sq2_1_3.namesUsedDuringMilitary(n400Copies, n400data,
				(int) readFromExcelSheet.getCellIntegerContent(fieldContent,
						118));

		// Green Card Details
		SQ2_2 sq2_2 = PageFactory.initElements(driver, SQ2_2.class);
		sq2_2.greenCardDetailsWithFormI551(n400Copies,
				n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 50),
				readFromExcelSheet.getCellStringContent(fieldContent, 51),
				readFromExcelSheet.getCellStringContent(fieldContent, 52));

		// Marital Status
		SQ3_1 sq3_1 = PageFactory.initElements(driver, SQ3_1.class);
		sq3_1.maritalStatus(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 53));

		// Prior Marriages Status
		SQ3_2 sq3_2 = PageFactory.initElements(driver, SQ3_2.class);
		sq3_2.priorMaritalStatus(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 54));

		// Spouse's Name
		SQ3_3 sq3_3 = PageFactory.initElements(driver, SQ3_3.class);
		sq3_3.spouseNameDetails(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 55),
				(int) readFromExcelSheet
						.getCellIntegerContent(fieldContent, 56));

		// Spouse's Address
		SQ3_4 sq3_4 = PageFactory.initElements(driver, SQ3_4.class);
		sq3_4.spouseAddressDetails(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 57),
				readFromExcelSheet.getCellStringContent(fieldContent, 58),
				readFromExcelSheet.getCellStringContent(fieldContent, 49),
				readFromExcelSheet.getCellStringContent(fieldContent, 120));

		// STOP - Attention Required-Stop Application
		SQ3_4_1 sq3_4_1 = PageFactory.initElements(driver, SQ3_4_1.class);
		sq3_4_1.applicantInEligible(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 59));

		// Spouse's Date of Birth
		SQ3_5 sq3_5 = PageFactory.initElements(driver, SQ3_5.class);
		sq3_5.spouseBirthDetails(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 60));

		// Date of Marriage
		SQ3_6 sq3_6 = PageFactory.initElements(driver, SQ3_6.class);
		sq3_6.spouseMarriageDetails(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 61));

		// Spouse's Employment
		SQ3_6_1 sq3_6_1 = PageFactory.initElements(driver, SQ3_6_1.class);
		sq3_6_1.spouseEmploymentDetails(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 49),
				readFromExcelSheet.getCellStringContent(fieldContent, 63));

		// Spouse's Citizenship -1
		SQ3_7 sq3_7 = PageFactory.initElements(driver, SQ3_7.class);
		sq3_7.spouseCitizenshipDetails(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 64));

		// Spouse's Citizenship -2
		SQ3_8 sq3_8 = PageFactory.initElements(driver, SQ3_8.class);
		sq3_8.spouseCitizenshipDetails(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 65));

		// Spouse's Citizenship -3
		SQ3_9 sq3_9 = PageFactory.initElements(driver, SQ3_9.class);
		sq3_9.spouseImmigrationDetails(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 66));

		// Spouse's Alien Registration Number
		SQ3_9_1 sq3_9_1 = PageFactory.initElements(driver, SQ3_9_1.class);
		sq3_9_1.spouseARNDetails(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 67));

		// Other Spouses
		SQ3_10 sq3_10 = PageFactory.initElements(driver, SQ3_10.class);
		sq3_10.otherSpouseMoreDetails(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 68),
				readFromExcelSheet.getCellStringContent(fieldContent, 69),
				(int) readFromExcelSheet
						.getCellIntegerContent(fieldContent, 70),
				readFromExcelSheet.getCellStringContent(fieldContent, 119));

		// Your Spouse's Prior Marriages
		SQ3_11 sq3_11 = PageFactory.initElements(driver, SQ3_11.class);
		sq3_11.spousePriorMarriages(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 71));

		// Your Spouse's Prior Marriages
		SQ3_12 sq3_12 = PageFactory.initElements(driver, SQ3_12.class);
		sq3_12.otherSpouseMoreDetails(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 72),
				readFromExcelSheet.getCellStringContent(fieldContent, 73),
				(int) readFromExcelSheet
						.getCellIntegerContent(fieldContent, 74));

		// Children
		SQ4_1 sq4_1 = PageFactory.initElements(driver, SQ4_1.class);
		sq4_1.childrenDetails(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 75));

		// About Your Children
		SQ4_2 sq4_2 = PageFactory.initElements(driver, SQ4_2.class);
		sq4_2.childMoreDetails(n400Copies, n400data,
				(int) readFromExcelSheet
						.getCellIntegerContent(fieldContent, 76),
				readFromExcelSheet.getCellStringContent(fieldContent, 77),
				readFromExcelSheet.getCellStringContent(fieldContent, 78));

		// Trips Outside the U.S.
		SQ5_1 sq5_1 = PageFactory.initElements(driver, SQ5_1.class);
		sq5_1.tripsTakenOutsideUS(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 79),
				readFromExcelSheet.getCellStringContent(fieldContent, 80));

		// Trip Details-1
		SQ5_2 sq5_2 = PageFactory.initElements(driver, SQ5_2.class);
		sq5_2.tripsTakenOutsideUS_InDetail(n400Copies, n400data,
				 (int) readFromExcelSheet
				.getCellIntegerContent(fieldContent, 81), readFromExcelSheet
				.getCellStringContent(fieldContent, 82));

		// Trip Details-2
		SQ5_2_1 sq5_2_1 = PageFactory.initElements(driver, SQ5_2_1.class);
		sq5_2_1.tripsTakenOutsideUS(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 83));

		// Moral Character-1
		SQ6_1 sq6_1 = PageFactory.initElements(driver, SQ6_1.class);
		sq6_1.generalQuestions(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 84));

		// Moral Character-2
		SQ6_2 sq6_2 = PageFactory.initElements(driver, SQ6_2.class);
		sq6_2.generalQuestions(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 85));

		// Your Affiliations
		SQ6_3 sq6_3 = PageFactory.initElements(driver, SQ6_3.class);
		sq6_3.affiliationsQuestions(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 86));

		// Other Affiliations
		SQ6_4 sq6_4 = PageFactory.initElements(driver, SQ6_4.class);
		sq6_4.otherAffiliationsDetails(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 87),
				(int) readFromExcelSheet
						.getCellIntegerContent(fieldContent, 88));

		// Taxes
		SQ6_5 sq6_5 = PageFactory.initElements(driver, SQ6_5.class);
		sq6_5.taxes(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 89));

		// Criminal Charges
		SQ6_6 sq6_6 = PageFactory.initElements(driver, SQ6_6.class);
		sq6_6.criminalCharges(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 90));

		// Prior Offenses
		SQ6_6_1 sq6_6_1 = PageFactory.initElements(driver, SQ6_6_1.class);
		sq6_6_1.priorOffensesInDetail(n400Copies, (int) readFromExcelSheet
				.getCellIntegerContent(fieldContent, 91), n400data);

		// Other Offenses
		SQ6_7 sq6_7 = PageFactory.initElements(driver, SQ6_7.class);
		sq6_7.otherOffences(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 92));

		// Perjury
		SQ6_8 sq6_8 = PageFactory.initElements(driver, SQ6_8.class);
		sq6_8.perjury(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 93));

		// Removal, Exclusion and Deportation Proceedings
		SQ6_9 sq6_9 = PageFactory.initElements(driver, SQ6_9.class);
		sq6_9.removalDetails(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 94));

		// Crime Details-1
		SQ6_9_1 sq6_9_1 = PageFactory.initElements(driver, SQ6_9_1.class);
		sq6_9_1.crimeDetails(n400Copies, n400keys,
				n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 95));

		// Crime Details-2
		SQ6_9_2 sq6_9_2 = PageFactory.initElements(driver, SQ6_9_2.class);
		sq6_9_2.crimeDetails(n400Copies, n400keys,
				n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 96));

		// Oath Requirements
		SQ6_10 sq6_10 = PageFactory.initElements(driver, SQ6_10.class);
		sq6_10.oathRequirements(n400Copies, n400keys,
				n400data, 
				readFromExcelSheet.getCellStringContent(fieldContent, 97),
				readFromExcelSheet.getCellStringContent(fieldContent, 85));

		// Prior Services
		SQ7_1 sq7_1 = PageFactory.initElements(driver, SQ7_1.class);
		sq7_1.priorService(n400Copies, n400keys,
				n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 98));

		// Honorable Service
		SQ7_2 sq7_2 = PageFactory.initElements(driver, SQ7_2.class);
		sq7_2.honorableService(n400Copies, n400keys,
				n400data, readFromExcelSheet
						.getCellStringContent(readFromExcelSheet
								.getRowNumberUsingContent(flowname), 101));

		// Selective Service Registration
		SQ7_3 sq7_3 = PageFactory.initElements(driver, SQ7_3.class);
		sq7_3.selectiveServiceRegistration(n400Copies,
				n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 102));

		// Employment and Education
		SQ8_1 sq8_1 = PageFactory.initElements(driver, SQ8_1.class);
		sq8_1.activityDetails(n400Copies, (int) readFromExcelSheet
				.getCellIntegerContent(fieldContent, 103), n400data, readFromExcelSheet.getCellStringContent(
				fieldContent, 104), readFromExcelSheet.getCellStringContent(
				fieldContent, 105));

		// Disability Information-Waiver 1
		SQ9_1 sq9_1 = PageFactory.initElements(driver, SQ9_1.class);
		sq9_1.waiver(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 106));

		// Accommodation Because of a Disability or Impairment
		SQ9_2 sq9_2 = PageFactory.initElements(driver, SQ9_2.class);
		sq9_2.accomodation(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 107),
				readFromExcelSheet.getCellStringContent(fieldContent, 108));

		// Disability Information-Waiver 2
		SQ9_3 sq9_3 = PageFactory.initElements(driver, SQ9_3.class);
		sq9_3.waiver(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 109));

		// Certification-Interpreter's Information
		SQ10_1 sq10_1 = PageFactory.initElements(driver, SQ10_1.class);
		sq10_1.interpreterInfo(n400Copies, n400data,
				readFromExcelSheet.getCellStringContent(fieldContent, 110),
				readFromExcelSheet.getCellStringContent(fieldContent, 111));
		
		myscreen.takeScreenShot("n400", "ApplicationReviewPage");
		// Application Review
		if (!flowname.contains("InEligible")) {

			ApplicationReview appReview = PageFactory.initElements(driver,
					ApplicationReview.class);
			appReview.completeApplicationUsingNewCSS(appName);
		}
		readFromExcelSheet.closeWorkbook();

	}

}

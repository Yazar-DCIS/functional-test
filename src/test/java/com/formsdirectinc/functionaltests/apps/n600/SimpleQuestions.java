package com.formsdirectinc.functionaltests.apps.n600;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ1_1;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ1_2;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ1_3;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ1_4;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ1_5;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ1_6;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ2_1;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ2_1_1;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ2_1_2;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ2_2;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ3_1;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ3_2;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ3_3;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ3_4;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ3_5;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ3_6;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ3_7;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ3_8;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ4_1_1;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ4_2;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ4_3;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ5_1;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ5_2;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ5_3_1;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ5_3_2;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ5_3_3;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ5_4;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ5_5;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ5_6;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ5_7;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ5_8;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ6_1;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ6_2;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ6_3_1;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ6_3_2;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ6_3_3;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ6_4;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ6_5;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ6_6;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ6_7;
import com.formsdirectinc.functionaltests.apps.n600.pages.SQ6_8;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.ApplicationReview;
import com.formsdirectinc.functionaltests.tags.ReadDataFromExcelSheet;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * @author Orina
 * @Product N600 SimpleQuestions
 */
public class SimpleQuestions  extends Step {

	

	public SimpleQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String appName = Products.N600.name();

	Sites site = Sites.valueOf(System.getProperty("site.name"));

	public void test(String product, String flowname)
			throws Exception {

		ReadDataFromExcelSheet readFromExcelSheet = new ReadDataFromExcelSheet();
		String n600Sheet = "N600";
		readFromExcelSheet.initializeWorkbook(n600Sheet);
		Integer fieldContent = readFromExcelSheet
				.getRowNumberUsingContent(flowname);

		PropertyResource propertyFile=new PropertyResource();
		Properties n600Copies = propertyFile.loadProperty(appName);
		Properties n600Values = propertyFile.loadProperty("name");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		

		// SQ Section :
		ApplicationReview startHere = PageFactory.initElements(driver,
				ApplicationReview.class);
		startHere.selectStartApplication();
		startHere.selectStartHereLink();

		// SQ Pages
		// Current Legal Name

		SQ1_1 sq1_1 = PageFactory.initElements(driver, SQ1_1.class);
		sq1_1.setNameFields(n600Copies, n600Values);

		// Other Names
		SQ1_2 sq1_2 = PageFactory.initElements(driver, SQ1_2.class);
		sq1_2.otherNamesInfo(n600Copies, readFromExcelSheet
				.getCellStringContent(fieldContent, 16), n600Values, (int) readFromExcelSheet
				.getCellIntegerContent(fieldContent, 17));

		// Permanent Resident Card
		SQ1_3 sq1_3 = PageFactory.initElements(driver, SQ1_3.class);
		sq1_3.permanentCardInfo(n600Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 18),
				readFromExcelSheet.getCellStringContent(fieldContent, 19),
				n600Values);

		// Social Security Card
		SQ1_4 sq1_4 = PageFactory.initElements(driver, SQ1_4.class);
		sq1_4.ssnInfo(
				readFromExcelSheet.getCellStringContent(fieldContent, 20),
				n600Values);

		// Date and Place of Birth
		SQ1_5 sq1_5 = PageFactory.initElements(driver, SQ1_5.class);
		sq1_5.birthDetails(n600Values,
				readFromExcelSheet.getCellStringContent(fieldContent, 21));

		// Gender and Height
		SQ1_6 sq1_6 = PageFactory.initElements(driver, SQ1_6.class);
		sq1_6.physicalTraits(
				readFromExcelSheet.getCellStringContent(fieldContent, 22),
				readFromExcelSheet.getCellStringContent(fieldContent, 23),
				n600Values);

		// Relationship to the Applicant
		// SQ 2.1
		SQ2_1 sq2_1 = PageFactory.initElements(driver, SQ2_1.class);
		sq2_1.relationToTheUser(readFromExcelSheet.getCellStringContent(
				fieldContent, 24));
		sq2_1.claimCitizenship(readFromExcelSheet.getCellStringContent(
				fieldContent, 25));
		sq2_1.armedForces(readFromExcelSheet.getCellStringContent(fieldContent,
				72));

		// Relationship to the Applicant
		SQ2_1_1 sq2_1_1 = PageFactory.initElements(driver, SQ2_1_1.class);
		sq2_1_1.relationToTheUser(readFromExcelSheet.getCellStringContent(
				fieldContent, 26));

		// SQ2.1.2
		// Relationship to the Applicant
		SQ2_1_2 sq2_1_2 = PageFactory.initElements(driver, SQ2_1_2.class);
		sq2_1_2.relationToTheUser(readFromExcelSheet.getCellStringContent(
				fieldContent, 27));

		// Basis for Claiming Eligibility
		// SQ2.2
		SQ2_2 sq2_2 = PageFactory.initElements(driver, SQ2_2.class);
		sq2_2.relationToTheUser(readFromExcelSheet.getCellStringContent(
				fieldContent, 28));

		// About the Applicant
		// Address and Phone:
		SQ3_1 sq3_1 = PageFactory.initElements(driver, SQ3_1.class);
		sq3_1.applicantAddress(n600Values,
				readFromExcelSheet.getCellStringContent(fieldContent, 29),
				readFromExcelSheet.getCellStringContent(fieldContent, 30));

		// MARITAL STATUS
		SQ3_2 sq3_2 = PageFactory.initElements(driver, SQ3_2.class);
		sq3_2.setMaritalStatus(n600Values,
				readFromExcelSheet.getCellStringContent(fieldContent, 31));

		// Entry into the United States
		SQ3_3 sq3_3 = PageFactory.initElements(driver, SQ3_3.class);
		sq3_3.entryIntoUS_part1(n600Values,
				readFromExcelSheet.getCellStringContent(fieldContent, 32));

		// Entry into the United States -- Passport Information
		SQ3_4 sq3_4 = PageFactory.initElements(driver, SQ3_4.class);
		sq3_4.entryIntoUS_part2(
				readFromExcelSheet.getCellStringContent(fieldContent, 33),
				n600Values);

		// Immigration Status -- Resident
		SQ3_5 sq3_5 = PageFactory.initElements(driver, SQ3_5.class);
		sq3_5.immigrationStatus_part1(n600Values,
				readFromExcelSheet.getCellStringContent(fieldContent, 34));

		// Immigration Status -- Adjustment of Status
		SQ3_6 sq3_6 = PageFactory.initElements(driver, SQ3_6.class);
		sq3_6.immigrationStatus_part2(
				readFromExcelSheet.getCellStringContent(fieldContent, 35),
				n600Values);

		SQ3_7 sq3_7 = PageFactory.initElements(driver, SQ3_7.class);
		sq3_7.otherTravelDetails(n600Values, readFromExcelSheet
				.getCellStringContent(fieldContent, 36),
				(int) readFromExcelSheet
						.getCellIntegerContent(fieldContent, 37));

		// Immigration Status -- Adjustment of Status
		SQ3_8 sq3_8 = PageFactory.initElements(driver, SQ3_8.class);
		sq3_8.previousApplicationsAndService(n600Values,
				readFromExcelSheet.getCellStringContent(fieldContent, 38));

		SQ4_1_1 sq4_1_1 = PageFactory.initElements(driver, SQ4_1_1.class);
		sq4_1_1.applicantAdopted(n600Values,
				readFromExcelSheet.getCellStringContent(fieldContent, 39));

		SQ4_2 sq4_2 = PageFactory.initElements(driver, SQ4_2.class);
		sq4_2.applicantReAdoption(
				readFromExcelSheet.getCellStringContent(fieldContent, 40),
				n600Values);

		SQ4_3 sq4_3 = PageFactory.initElements(driver, SQ4_3.class);
		sq4_3.parentsInfo(readFromExcelSheet.getCellStringContent(fieldContent,
				41));

		SQ5_1 sq5_1 = PageFactory.initElements(driver, SQ5_1.class);
		sq5_1.fatherBiographicalInfo(n600Values,
				readFromExcelSheet.getCellStringContent(fieldContent, 42));

		SQ5_2 sq5_2 = PageFactory.initElements(driver, SQ5_2.class);
		sq5_2.fatherInformation(n600Values,
				readFromExcelSheet.getCellStringContent(fieldContent, 43),
				readFromExcelSheet.getCellStringContent(fieldContent, 44),
				readFromExcelSheet.getCellStringContent(fieldContent, 42));

		SQ5_3_1 sq5_3_1 = PageFactory.initElements(driver, SQ5_3_1.class);
		sq5_3_1.citizenshipType(n600Values,
				readFromExcelSheet.getCellStringContent(fieldContent, 45));

		// 5.3.2
		SQ5_3_2 sq5_3_2 = PageFactory.initElements(driver, SQ5_3_2.class);
		sq5_3_2.naturalizationType(n600Values,
				readFromExcelSheet.getCellStringContent(fieldContent, 46));

		// 5.3.3
		SQ5_3_3 sq5_3_3 = PageFactory.initElements(driver, SQ5_3_3.class);
		sq5_3_3.naturalizationNumber(n600Values,
				readFromExcelSheet.getCellStringContent(fieldContent, 47));

		SQ5_4 sq5_4 = PageFactory.initElements(driver, SQ5_4.class);
		sq5_4.fatherCitizenshipStatus(n600Values,
				readFromExcelSheet.getCellStringContent(fieldContent, 48));

		SQ5_5 sq5_5 = PageFactory.initElements(driver, SQ5_5.class);
		sq5_5.fatherPhysicalPresenceInUSDates(n600Values,
				(int) readFromExcelSheet
						.getCellIntegerContent(fieldContent, 49));

		SQ5_6 sq5_6 = PageFactory.initElements(driver, SQ5_6.class);
		sq5_6.militaryServices(n600Values,
				readFromExcelSheet.getCellStringContent(fieldContent, 50),
				readFromExcelSheet.getCellStringContent(fieldContent, 51));

		SQ5_7 sq5_7 = PageFactory.initElements(driver, SQ5_7.class);
		sq5_7.fatherMaritalInfo(n600Values, readFromExcelSheet
				.getCellStringContent(fieldContent, 52),
				(int) readFromExcelSheet
						.getCellIntegerContent(fieldContent, 53),
				readFromExcelSheet.getCellStringContent(fieldContent, 54),
				readFromExcelSheet.getCellStringContent(fieldContent, 55));

		// 5.8 father spouse details
		SQ5_8 sq5_8 = PageFactory.initElements(driver, SQ5_8.class);
		sq5_8.spouseOfFatherInfo(n600Values,
				readFromExcelSheet.getCellStringContent(fieldContent, 56),
				readFromExcelSheet.getCellStringContent(fieldContent, 42));

		SQ6_1 sq6_1 = PageFactory.initElements(driver, SQ6_1.class);
		sq6_1.motherBiographicalInfo(n600Values,
				readFromExcelSheet.getCellStringContent(fieldContent, 57));

		SQ6_2 sq6_2 = PageFactory.initElements(driver, SQ6_2.class);
		sq6_2.motherInformation(n600Values,
				readFromExcelSheet.getCellStringContent(fieldContent, 58),
				readFromExcelSheet.getCellStringContent(fieldContent, 59),
				readFromExcelSheet.getCellStringContent(fieldContent, 57));

		SQ6_3_1 sq6_3_1 = PageFactory.initElements(driver, SQ6_3_1.class);
		sq6_3_1.citizenshipType(n600Values,
				readFromExcelSheet.getCellStringContent(fieldContent, 60));

		// 6.3.2
		SQ6_3_2 sq6_3_2 = PageFactory.initElements(driver, SQ6_3_2.class);
		sq6_3_2.naturalizationType(n600Values,
				readFromExcelSheet.getCellStringContent(fieldContent, 61));

		// 6.3.3
		SQ6_3_3 sq6_3_3 = PageFactory.initElements(driver, SQ6_3_3.class);
		sq6_3_3.naturalizationNumber(n600Values,
				readFromExcelSheet.getCellStringContent(fieldContent, 62));

		SQ6_4 sq6_4 = PageFactory.initElements(driver, SQ6_4.class);
		sq6_4.motherCitizenshipStatus(n600Values,
				readFromExcelSheet.getCellStringContent(fieldContent, 63));

		SQ6_5 sq6_5 = PageFactory.initElements(driver, SQ6_5.class);
		sq6_5.motherPhysicalPresenceInUSDates(n600Values,
				(int) readFromExcelSheet
						.getCellIntegerContent(fieldContent, 64));

		SQ6_6 sq6_6 = PageFactory.initElements(driver, SQ6_6.class);
		sq6_6.militaryServices(n600Values,
				readFromExcelSheet.getCellStringContent(fieldContent, 65),
				readFromExcelSheet.getCellStringContent(fieldContent, 66));

		SQ6_7 sq6_7 = PageFactory.initElements(driver, SQ6_7.class);
		sq6_7.motherMaritalInfo(n600Values,
				(int) readFromExcelSheet
						.getCellIntegerContent(fieldContent, 67),
				readFromExcelSheet.getCellStringContent(fieldContent, 68),
				readFromExcelSheet.getCellStringContent(fieldContent, 69),
				readFromExcelSheet.getCellStringContent(fieldContent, 70),
				readFromExcelSheet.getCellStringContent(fieldContent, 57));

		SQ6_8 sq6_8 = PageFactory.initElements(driver, SQ6_8.class);
		sq6_8.motherImmigrationStatus(readFromExcelSheet.getCellStringContent(
				fieldContent, 71));

		readFromExcelSheet.closeWorkbook();

		// Application Review
		if (!flowname.contains("InEligible")) {

			ApplicationReview appReview = PageFactory.initElements(driver,
							ApplicationReview.class);
			appReview.completeApplicationUsingNewCSS(appName);
		}
		
		
	}

}

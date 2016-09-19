package com.formsdirectinc.functionaltests.apps.i102;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.i102.pages.SQ1_1;
import com.formsdirectinc.functionaltests.apps.i102.pages.SQ1_1_1_1;
import com.formsdirectinc.functionaltests.apps.i102.pages.SQ1_1_2;
import com.formsdirectinc.functionaltests.apps.i102.pages.SQ2_1;
import com.formsdirectinc.functionaltests.apps.i102.pages.SQ2_1_1;
import com.formsdirectinc.functionaltests.apps.i102.pages.SQ2_2;
import com.formsdirectinc.functionaltests.apps.i102.pages.SQ2_3;
import com.formsdirectinc.functionaltests.apps.i102.pages.SQ2_4;
import com.formsdirectinc.functionaltests.apps.i102.pages.SQ2_5;
import com.formsdirectinc.functionaltests.apps.i102.pages.SQ2_6;
import com.formsdirectinc.functionaltests.apps.i102.pages.SQ2_6_1;
import com.formsdirectinc.functionaltests.apps.i102.pages.SQ2_6_2;
import com.formsdirectinc.functionaltests.apps.i102.pages.SQ2_7;
import com.formsdirectinc.functionaltests.apps.i102.pages.SQ2_7_1;
import com.formsdirectinc.functionaltests.apps.i102.pages.SQ3_1;
import com.formsdirectinc.functionaltests.apps.i102.pages.SQ3_1_1;
import com.formsdirectinc.functionaltests.apps.i102.pages.SQ3_1_2;
import com.formsdirectinc.functionaltests.apps.i102.pages.SQ3_2;
import com.formsdirectinc.functionaltests.apps.i102.pages.SQ3_2_1;
import com.formsdirectinc.functionaltests.apps.i102.pages.SQ3_2_2;
import com.formsdirectinc.functionaltests.apps.i102.pages.SQ3_3;
import com.formsdirectinc.functionaltests.apps.i102.pages.SQ4_1;
import com.formsdirectinc.functionaltests.apps.i102.pages.SQ5_1;
import com.formsdirectinc.functionaltests.apps.i102.pages.SQ6_1;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.ApplicationReview;
import com.formsdirectinc.functionaltests.tags.ReadDataFromExcelSheet;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * @author Orina
 * @Product I102 SimpleQuestions
 */
public class SimpleQuestions extends Step{

	public SimpleQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	Sites site = Sites.valueOf(System.getProperty("site.name"));
	String appName = Products.I102.name();

	public void test(String product, String flowname)
			throws Exception {

		ReadDataFromExcelSheet readFromExcelSheet = new ReadDataFromExcelSheet();
		String i102Sheet = "I102";
		readFromExcelSheet.initializeWorkbook(i102Sheet);

		Integer fieldContent = readFromExcelSheet
				.getRowNumberUsingContent(flowname);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		PropertyResource propertyFile=new PropertyResource();
		Properties i102data = propertyFile.loadProperty("name");

		// SQ Section :
		ApplicationReview startHere = PageFactory.initElements(driver,
				ApplicationReview.class);
		startHere.selectStartApplication();
		startHere.selectStartHereLink();

		// Reason for Applying
		SQ1_1 sq1_1 = PageFactory.initElements(driver, SQ1_1.class);
		sq1_1.reasonforApplying(
				readFromExcelSheet.getCellStringContent(fieldContent, 1),
				readFromExcelSheet.getCellStringContent(fieldContent, 2),
				readFromExcelSheet.getCellStringContent(fieldContent, 3),
				readFromExcelSheet.getCellStringContent(fieldContent, 4));

		// Attention Required
		SQ1_1_1_1 sq1_1_1_1 = PageFactory.initElements(driver, SQ1_1_1_1.class);
		sq1_1_1_1.clickContinue(readFromExcelSheet.getCellStringContent(
				fieldContent, 5));

		// Purpose of Filing
		SQ1_1_2 sq1_1_2 = PageFactory.initElements(driver, SQ1_1_2.class);
		sq1_1_2.includeAnotherPetition(readFromExcelSheet.getCellStringContent(
				fieldContent, 6));

		// Name
		SQ2_1 sq2_1 = PageFactory.initElements(driver, SQ2_1.class);
		sq2_1.setNameFields(i102data);

		// Name on the Document
		SQ2_1_1 sq2_1_1 = PageFactory.initElements(driver, SQ2_1_1.class);
		sq2_1_1.setNameOnDocument(i102data,
				readFromExcelSheet.getCellStringContent(fieldContent, 1));

		// Current Address
		SQ2_2 sq2_2 = PageFactory.initElements(driver, SQ2_2.class);
		sq2_2.setAddressFields(i102data,
				readFromExcelSheet.getCellStringContent(fieldContent, 7),
				readFromExcelSheet.getCellStringContent(fieldContent, 8));

		// Contact Information
		SQ2_3 sq2_3 = PageFactory.initElements(driver, SQ2_3.class);
		sq2_3.setNumberFields(i102data,
				readFromExcelSheet.getCellStringContent(fieldContent, 9));

		// Biographical Information
		SQ2_4 sq2_4 = PageFactory.initElements(driver, SQ2_4.class);
		sq2_4.setBiographicalInfo(i102data,
				readFromExcelSheet.getCellStringContent(fieldContent, 10));

		// Alien Registration Number
		SQ2_5 sq2_5 = PageFactory.initElements(driver, SQ2_5.class);
		sq2_5.haveARN(i102data,
				readFromExcelSheet.getCellStringContent(fieldContent, 11));

		// Social Security Number
		SQ2_6 sq2_6 = PageFactory.initElements(driver, SQ2_6.class);
		sq2_6.haveSSN(i102data,
				readFromExcelSheet.getCellStringContent(fieldContent, 12));

		// ELIS Account Number
		SQ2_6_1 sq2_6_1 = PageFactory.initElements(driver, SQ2_6_1.class);
		sq2_6_1.haveELIS_Number(i102data,
				readFromExcelSheet.getCellStringContent(fieldContent, 13));

		// Travel Document
		SQ2_6_2 sq2_6_2 = PageFactory.initElements(driver, SQ2_6_2.class);
		sq2_6_2.travelDocument(i102data,
				readFromExcelSheet.getCellStringContent(fieldContent, 14));

		// Arrival/Departure Record (I-94) Number (Optional)
		SQ2_7 sq2_7 = PageFactory.initElements(driver, SQ2_7.class);
		sq2_7.i_94Number(i102data,
				readFromExcelSheet.getCellStringContent(fieldContent, 15));

		// Arrival/Departure Record (I-95) Number (Optional)
		SQ2_7_1 sq2_7_1 = PageFactory.initElements(driver, SQ2_7_1.class);
		sq2_7_1.i_95Number(i102data,
				readFromExcelSheet.getCellStringContent(fieldContent, 16));

		// Date and Place of Last Admission
		SQ3_1 sq3_1 = PageFactory.initElements(driver, SQ3_1.class);
		sq3_1.lastDateAndPlaceOfAdmission(i102data,
				readFromExcelSheet.getCellStringContent(fieldContent, 17));

		// Place of Admission
		SQ3_1_1 sq3_1_1 = PageFactory.initElements(driver, SQ3_1_1.class);
		sq3_1_1.placeOfAdmissionStamped(i102data,
				readFromExcelSheet.getCellStringContent(fieldContent, 18));

		// Date and Place of Last Admission
		SQ3_1_2 sq3_1_2 = PageFactory.initElements(driver, SQ3_1_2.class);
		sq3_1_2.dateAndPlaceOfAdmission(i102data,
				readFromExcelSheet.getCellStringContent(fieldContent, 19));

		// Current Non-immigrant Status
		SQ3_2 sq3_2 = PageFactory.initElements(driver, SQ3_2.class);
		sq3_2.currentNonImmigrantStatus(i102data,
				readFromExcelSheet.getCellStringContent(fieldContent, 20));

		// Non-immigrant Status on the Document
		SQ3_2_1 sq3_2_1 = PageFactory.initElements(driver, SQ3_2_1.class);
		sq3_2_1.nonimmigrantStatusOnTheDocument(i102data,
				readFromExcelSheet.getCellStringContent(fieldContent, 21));

		// Current Non-immigrant Status
		SQ3_2_2 sq3_2_2 = PageFactory.initElements(driver, SQ3_2_2.class);
		sq3_2_2.nonimmigrantStatus(i102data,
				readFromExcelSheet.getCellStringContent(fieldContent, 22));

		// Expiration of Current Status
		SQ3_3 sq3_3 = PageFactory.initElements(driver, SQ3_3.class);
		sq3_3.expirationOfCurrentStatus(i102data,
				readFromExcelSheet.getCellStringContent(fieldContent, 23));

		// Type of Petition or Application
		SQ4_1 sq4_1 = PageFactory.initElements(driver, SQ4_1.class);
		sq4_1.typeOfPetition(i102data,
				readFromExcelSheet.getCellStringContent(fieldContent, 24));

		// Immigration Violations
		SQ5_1 sq5_1 = PageFactory.initElements(driver, SQ5_1.class);
		sq5_1.notViolated(i102data,
				readFromExcelSheet.getCellStringContent(fieldContent, 25),
				readFromExcelSheet.getCellStringContent(fieldContent, 26));

		// Certification
		SQ6_1 sq6_1 = PageFactory.initElements(driver, SQ6_1.class);
		sq6_1.applicantStatement(i102data,
				readFromExcelSheet.getCellStringContent(fieldContent, 27));

		// Application Review
		if (!flowname.contains("InEligible")) {

			ApplicationReview appReview = PageFactory.initElements(driver,
					ApplicationReview.class);
			//appReview.downloadApplicationUsingNewCSS();
			appReview.completeApplicationUsingNewCSS(appName);

		}

		readFromExcelSheet.closeWorkbook();
		
		
		
		
	}

}
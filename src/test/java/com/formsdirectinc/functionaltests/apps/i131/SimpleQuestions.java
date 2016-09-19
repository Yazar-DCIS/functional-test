package com.formsdirectinc.functionaltests.apps.i131;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ1_1;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ1_10;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ1_10_1;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ1_10_2;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ1_2;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ1_6;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ1_7_1;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ1_8;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ2_1;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ2_10;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ2_11;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ2_2;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ2_3;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ2_4;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ2_5;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ2_6;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ2_7;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ2_8;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ2_9;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ3_1;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ3_2;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ3_3;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ3_4;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ3_5;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ4_1;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ4_2;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ5_1;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ5_2;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ5_3;
import com.formsdirectinc.functionaltests.apps.i131.pages.SQ5_4;
import com.formsdirectinc.functionaltests.apps.i131.pages.StopAttentionPage;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.ApplicationReview;
import com.formsdirectinc.functionaltests.tags.ReadDataFromExcelSheet;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * @author Orina
 * @Product I131 SimpleQuestions
 */
public class SimpleQuestions  extends Step {

	
	public SimpleQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String appName = Products.I131.name();

	public void test(String product, String flowname)
			throws Exception {

		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		PropertyResource propertyFile=new PropertyResource();
		Properties i131data = propertyFile.loadProperty("name");

		

		ReadDataFromExcelSheet readFromExcelSheet = PageFactory.initElements(
				driver, ReadDataFromExcelSheet.class);
		String i131Sheet = "I131";
		readFromExcelSheet.initializeWorkbook(i131Sheet);
		Integer fieldContent = readFromExcelSheet
				.getRowNumberUsingContent(flowname);
		// SQ Section :
		ApplicationReview startHere = PageFactory.initElements(driver,
				ApplicationReview.class);
		startHere.selectStartApplication();
		startHere.selectStartHereLink();

		SQ1_1 sq1_1 = PageFactory.initElements(driver, SQ1_1.class);
		sq1_1.selectReason(readFromExcelSheet.getCellStringContent(
				fieldContent, 1));

		SQ1_2 sq1_2 = PageFactory.initElements(driver, SQ1_2.class);
		sq1_2.departUs(readFromExcelSheet.getCellStringContent(fieldContent, 2));

		StopAttentionPage attnRequired = PageFactory.initElements(driver,
				StopAttentionPage.class);
		// Attention Required
		if (readFromExcelSheet.getCellStringContent(fieldContent, 1)
				.equalsIgnoreCase("PermanantResidentRefugee")
				&& readFromExcelSheet.getCellStringContent(fieldContent, 2)
						.equalsIgnoreCase("Yes")) {
			attnRequired.clickContinueInSQ();
		}

		SQ1_6 sq1_6 = PageFactory.initElements(driver, SQ1_6.class);
		sq1_6.dateOfDeparture(i131data,
				readFromExcelSheet.getCellStringContent(fieldContent, 3));

		// Attention Required
		if (readFromExcelSheet.getCellStringContent(fieldContent, 3)
				.equalsIgnoreCase("MoreThan30Days")) {
			attnRequired.clickContinueInSQ();
		}

		SQ1_7_1 sq1_7_1 = PageFactory.initElements(driver, SQ1_7_1.class);
		sq1_7_1.lengthOfTrip(
				readFromExcelSheet.getCellStringContent(fieldContent, 1),
				readFromExcelSheet.getCellStringContent(fieldContent, 4));

		SQ1_8 sq1_8 = PageFactory.initElements(driver, SQ1_8.class);
		sq1_8.inUs(readFromExcelSheet.getCellStringContent(fieldContent, 5));

		SQ1_10 sq1_10 = PageFactory.initElements(driver, SQ1_10.class);
		sq1_10.unlawfulPresence(readFromExcelSheet.getCellStringContent(
				fieldContent, 6));

		SQ1_10_1 sq1_10_1 = PageFactory.initElements(driver, SQ1_10_1.class);
		sq1_10_1.i485FileStatus(i131data,
				readFromExcelSheet.getCellStringContent(fieldContent, 7));

		SQ1_10_2 sq1_10_2 = PageFactory.initElements(driver, SQ1_10_2.class);
		sq1_10_2.i797ThreeDigitCode(readFromExcelSheet.getCellStringContent(
				fieldContent, 8));

		SQ2_1 sq2_1 = PageFactory.initElements(driver, SQ2_1.class);
		sq2_1.nameAndGender(i131data);

		SQ2_2 sq2_2 = PageFactory.initElements(driver, SQ2_2.class);
		sq2_2.contactInformation(i131data);

		SQ2_3 sq2_3 = PageFactory.initElements(driver, SQ2_3.class);
		sq2_3.addressDetails(i131data);

		SQ2_4 sq2_4 = PageFactory.initElements(driver, SQ2_4.class);
		sq2_4.birthDetails(i131data,
				readFromExcelSheet.getCellStringContent(fieldContent, 9));

		SQ2_5 sq2_5 = PageFactory.initElements(driver, SQ2_5.class);
		sq2_5.arnNo(i131data);

		SQ2_6 sq2_6 = PageFactory.initElements(driver, SQ2_6.class);
		sq2_6.SSN(i131data,
				readFromExcelSheet.getCellStringContent(fieldContent, 10));

		SQ2_7 sq2_7 = PageFactory.initElements(driver, SQ2_7.class);
		sq2_7.havRemovalProceedings(i131data,
				readFromExcelSheet.getCellStringContent(fieldContent, 11));

		if (readFromExcelSheet.getCellStringContent(fieldContent, 1)
				.equalsIgnoreCase("ReEntryPermit")) {
			SQ2_8 sq2_8 = PageFactory.initElements(driver, SQ2_8.class);
			sq2_8.COA(i131data);
		} else if (readFromExcelSheet.getCellStringContent(fieldContent, 1)
				.equalsIgnoreCase("RefugeeTravelDocument")) {
			SQ2_9 sq2_9 = PageFactory.initElements(driver, SQ2_9.class);
			sq2_9.COA(i131data);
		} else if (readFromExcelSheet.getCellStringContent(fieldContent, 1)
				.equalsIgnoreCase("PermanantResidentRefugee")) {
			SQ2_11 sq2_11 = PageFactory.initElements(driver, SQ2_11.class);
			sq2_11.COA(i131data);
		} else {
			SQ2_10 sq2_10 = PageFactory.initElements(driver, SQ2_10.class);
			sq2_10.COA(i131data);
		}

		SQ3_1 sq3_1 = PageFactory.initElements(driver, SQ3_1.class);
		sq3_1.docIssued(i131data,
				readFromExcelSheet.getCellStringContent(fieldContent, 12));

		SQ3_2 sq3_2 = PageFactory.initElements(driver, SQ3_2.class);
		sq3_2.travelDocToCurrentAddress(i131data,
				readFromExcelSheet.getCellStringContent(fieldContent, 13),
				readFromExcelSheet.getCellStringContent(fieldContent, 14));

		SQ3_3 sq3_3 = PageFactory.initElements(driver, SQ3_3.class);
		sq3_3.notificationAddress(i131data,
				readFromExcelSheet.getCellStringContent(fieldContent, 15),
				"Yes");

		SQ3_4 sq3_4 = PageFactory.initElements(driver, SQ3_4.class);
		sq3_4.puropseOfTrip(i131data,
				readFromExcelSheet.getCellStringContent(fieldContent, 16));

		SQ3_5 sq3_5 = PageFactory.initElements(driver, SQ3_5.class);
		sq3_5.countryToVisit(i131data,
				readFromExcelSheet.getCellStringContent(fieldContent, 17));

		SQ4_1 sq4_1 = PageFactory.initElements(driver, SQ4_1.class);
		sq4_1.timeOutSideUs(readFromExcelSheet.getCellStringContent(
				fieldContent, 18));

		SQ4_2 sq4_2 = PageFactory.initElements(driver, SQ4_2.class);
		sq4_2.IncomeTax(i131data,
				readFromExcelSheet.getCellStringContent(fieldContent, 19));

		SQ5_1 sq5_1 = PageFactory.initElements(driver, SQ5_1.class);
		sq5_1.refugeeCountry(i131data,
				readFromExcelSheet.getCellStringContent(fieldContent, 20));

		SQ5_2 sq5_2 = PageFactory.initElements(driver, SQ5_2.class);
		sq5_2.travelDetails(i131data,
				readFromExcelSheet.getCellStringContent(fieldContent, 21));

		// Attention Required
		if (readFromExcelSheet.getCellStringContent(fieldContent, 21)
				.equalsIgnoreCase("Yes")) {
			attnRequired.clickContinueInSQ();
		}

		SQ5_3 sq5_3 = PageFactory.initElements(driver, SQ5_3.class);
		sq5_3.travelDetails(i131data,
				readFromExcelSheet.getCellStringContent(fieldContent, 22),
				readFromExcelSheet.getCellStringContent(fieldContent, 23),
				readFromExcelSheet.getCellStringContent(fieldContent, 24));

		SQ5_4 sq5_4 = PageFactory.initElements(driver, SQ5_4.class);
		sq5_4.travelDetails(i131data,
				readFromExcelSheet.getCellStringContent(fieldContent, 25),
				readFromExcelSheet.getCellStringContent(fieldContent, 26),
				readFromExcelSheet.getCellStringContent(fieldContent, 27));
		// Application Review
		if (!flowname.contains("InEligible")) {

			ApplicationReview appReview = PageFactory.initElements(driver,
					ApplicationReview.class);
			appReview.completeApplicationUsingNewCSS(appName);

		}

		readFromExcelSheet.closeWorkbook();

	}

}

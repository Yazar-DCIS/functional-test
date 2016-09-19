package com.formsdirectinc.functionaltests.apps.i765;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.i765.pages.SQ1_1;
import com.formsdirectinc.functionaltests.apps.i765.pages.SQ1_2;
import com.formsdirectinc.functionaltests.apps.i765.pages.SQ1_3;
import com.formsdirectinc.functionaltests.apps.i765.pages.SQ1_4;
import com.formsdirectinc.functionaltests.apps.i765.pages.SQ1_4_1;
import com.formsdirectinc.functionaltests.apps.i765.pages.SQ1_5;
import com.formsdirectinc.functionaltests.apps.i765.pages.SQ1_6;
import com.formsdirectinc.functionaltests.apps.i765.pages.SQ1_6_1;
import com.formsdirectinc.functionaltests.apps.i765.pages.SQ2_1;
import com.formsdirectinc.functionaltests.apps.i765.pages.SQ3_1;
import com.formsdirectinc.functionaltests.apps.i765.pages.SQ3_2;
import com.formsdirectinc.functionaltests.apps.i765.pages.SQ3_3;
import com.formsdirectinc.functionaltests.apps.i765.pages.SQ3_3_1;
import com.formsdirectinc.functionaltests.apps.i765.pages.SQ3_4;
import com.formsdirectinc.functionaltests.apps.i765.pages.SQ3_5;
import com.formsdirectinc.functionaltests.apps.i765.pages.SQ3_5_1;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.ApplicationReview;
import com.formsdirectinc.functionaltests.tags.ReadDataFromExcelSheet;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * @author Orina
 * @Product I765 SimpleQuestions
 */

public class SimpleQuestions  extends Step {

	
	public SimpleQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String appName = Products.I765.name();

	public void test(String product, String flowname)
			throws Exception {

		ReadDataFromExcelSheet readFromExcelSheet = new ReadDataFromExcelSheet();
		String i765Sheet = "I765";
		readFromExcelSheet.initializeWorkbook(i765Sheet);
		Integer fieldContent = readFromExcelSheet
				.getRowNumberUsingContent(flowname);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		PropertyResource propertyFile=new PropertyResource();
		Properties i765data = propertyFile.loadProperty("name");

		
		// SQ Section :
		ApplicationReview startHere = PageFactory.initElements(driver,
				ApplicationReview.class);
		startHere.selectStartApplication();
		startHere.selectStartHereLink();

		// SQ Section
		SQ1_1 sq1_1 = PageFactory.initElements(driver, SQ1_1.class);
		sq1_1.setNameFields(i765data);

		SQ1_2 sq1_2 = PageFactory.initElements(driver, SQ1_2.class);
		sq1_2.hasOtherNames(i765data,
				readFromExcelSheet.getCellStringContent(fieldContent, 30));

		SQ1_3 sq1_3 = PageFactory.initElements(driver, SQ1_3.class);
		sq1_3.addressDetails(i765data);

		SQ1_4 sq1_4 = PageFactory.initElements(driver, SQ1_4.class);
		sq1_4.applicantBirthDetails(i765data);

		SQ1_4_1 sq1_4_1 = PageFactory.initElements(driver, SQ1_4_1.class);
		sq1_4_1.maritalStatus(i765data,
				readFromExcelSheet.getCellStringContent(fieldContent, 31));

		SQ1_5 sq1_5 = PageFactory.initElements(driver, SQ1_5.class);
		sq1_5.SSNDetails(i765data, readFromExcelSheet
				.getCellStringContent(fieldContent, 32),
				(int) readFromExcelSheet
						.getCellIntegerContent(fieldContent, 33));

		SQ1_6 sq1_6 = PageFactory.initElements(driver, SQ1_6.class);
		sq1_6.ARNDetails(i765data,
				readFromExcelSheet.getCellStringContent(fieldContent, 34));

		SQ1_6_1 sq1_6_1 = PageFactory.initElements(driver, SQ1_6_1.class);
		sq1_6_1.arrivalDepartureRecord(i765data,
				readFromExcelSheet.getCellStringContent(fieldContent, 35));

		SQ2_1 sq2_1 = PageFactory.initElements(driver, SQ2_1.class);
		sq2_1.employmentAuthorization(i765data,
				readFromExcelSheet.getCellStringContent(fieldContent, 36),
				(int) readFromExcelSheet
						.getCellIntegerContent(fieldContent, 37));

		SQ3_1 sq3_1 = PageFactory.initElements(driver, SQ3_1.class);
		sq3_1.lastEntryDetails(i765data);

		SQ3_2 sq3_2 = PageFactory.initElements(driver, SQ3_2.class);
		sq3_2.eligiblityStatus(i765data,
				readFromExcelSheet.getCellStringContent(fieldContent, 38),
				readFromExcelSheet.getCellStringContent(fieldContent, 39),
				readFromExcelSheet.getCellStringContent(fieldContent, 40));

		SQ3_3 sq3_3 = PageFactory.initElements(driver, SQ3_3.class);
		sq3_3.reasonForApplication(
				readFromExcelSheet.getCellStringContent(fieldContent, 41),
				readFromExcelSheet.getCellStringContent(fieldContent, 42));

		SQ3_3_1 sq3_3_1 = PageFactory.initElements(driver, SQ3_3_1.class);
		sq3_3_1.reasonForApplication(
				readFromExcelSheet.getCellStringContent(fieldContent, 43),
				readFromExcelSheet.getCellStringContent(fieldContent, 44));

		SQ3_4 sq3_4 = PageFactory.initElements(driver, SQ3_4.class);
		sq3_4.reasonForApplication(readFromExcelSheet.getCellStringContent(
				fieldContent, 45));

		SQ3_5 sq3_5 = PageFactory.initElements(driver, SQ3_5.class);
		sq3_5.reasonForApplication(
				readFromExcelSheet.getCellStringContent(fieldContent, 46),
				readFromExcelSheet.getCellStringContent(fieldContent, 47));
		
		String visitSorryPage=readFromExcelSheet.getCellStringContent(fieldContent, 48);
		if(visitSorryPage.equalsIgnoreCase("yes"))
		{
			SQ3_5_1 sq3_5_1 = PageFactory.initElements(driver, SQ3_5_1.class);
			sq3_5_1.stopApplication();
		}
		// Application Review
		if (!flowname.contains("InEligible")) {

			ApplicationReview appReview = PageFactory.initElements(driver,
					ApplicationReview.class);
			appReview.completeApplicationUsingNewCSS(appName);
		}
		readFromExcelSheet.closeWorkbook();

	}

}

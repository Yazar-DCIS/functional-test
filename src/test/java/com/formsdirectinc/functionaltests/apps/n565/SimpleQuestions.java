package com.formsdirectinc.functionaltests.apps.n565;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.n565.pages.SQ1_1;
import com.formsdirectinc.functionaltests.apps.n565.pages.SQ1_1_2;
import com.formsdirectinc.functionaltests.apps.n565.pages.SQ1_1_3;
import com.formsdirectinc.functionaltests.apps.n565.pages.SQ1_2;
import com.formsdirectinc.functionaltests.apps.n565.pages.SQ2_1;
import com.formsdirectinc.functionaltests.apps.n565.pages.SQ2_2;
import com.formsdirectinc.functionaltests.apps.n565.pages.SQ3_1;
import com.formsdirectinc.functionaltests.apps.n565.pages.SQ3_1_1;
import com.formsdirectinc.functionaltests.apps.n565.pages.SQ3_2;
import com.formsdirectinc.functionaltests.apps.n565.pages.SQ3_3;
import com.formsdirectinc.functionaltests.apps.n565.pages.SQ3_4;
import com.formsdirectinc.functionaltests.apps.n565.pages.SQ4_1;
import com.formsdirectinc.functionaltests.apps.n565.pages.SQ4_2;
import com.formsdirectinc.functionaltests.apps.n565.pages.SQ5_1;
import com.formsdirectinc.functionaltests.apps.n565.pages.SQ5_2;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.ApplicationReview;
import com.formsdirectinc.functionaltests.tags.ReadDataFromExcelSheet;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * @author Orina
 * @Product N565 SimpleQuestions
 */

public class SimpleQuestions  extends Step {

	

	public SimpleQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String appName = Products.N565.name();

	public void test(String product, String flowname)
			throws Exception {

	
		PropertyResource propertyFile=new PropertyResource();
		Properties n565data = propertyFile.loadProperty("name");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
		// SQ Section :
		ApplicationReview startHere = PageFactory.initElements(driver,
				ApplicationReview.class);
		startHere.selectStartApplication();
		startHere.selectStartHereLink();

		ReadDataFromExcelSheet readFromExcelSheet = PageFactory.initElements(
				driver, ReadDataFromExcelSheet.class);
		String n565Sheet = "N565";
		readFromExcelSheet.initializeWorkbook(n565Sheet);
		Integer fieldContent = readFromExcelSheet
				.getRowNumberUsingContent(flowname);

		// Current Legal Name
		SQ1_1 sq1_1 = PageFactory.initElements(driver, SQ1_1.class);
		sq1_1.setNameOnDocument(n565data);

		// Current Address
		SQ1_1_2 sq1_1_2 = PageFactory.initElements(driver, SQ1_1_2.class);
		sq1_1_2.setAddressFields(
				readFromExcelSheet.getCellStringContent(fieldContent, 1),
				n565data);

		// Personal Information
		SQ1_1_3 sq1_1_3 = PageFactory.initElements(driver, SQ1_1_3.class);
		sq1_1_3.personal_Information(
				readFromExcelSheet.getCellStringContent(fieldContent, 2),
				n565data);

		// Your ARN
		SQ1_2 sq1_2 = PageFactory.initElements(driver, SQ1_2.class);
		sq1_2.haveARN(readFromExcelSheet.getCellStringContent(fieldContent, 3),
				n565data);
		// Your Application
		SQ2_1 sq2_1 = PageFactory.initElements(driver, SQ2_1.class);
		sq2_1.type_of_Application(
				readFromExcelSheet.getCellStringContent(fieldContent, 4),
				readFromExcelSheet.getCellStringContent(fieldContent, 5));
		// Reason for Applying

		SQ2_2 sq2_2 = PageFactory.initElements(driver, SQ2_2.class);
		sq2_2.reasonforApplying(n565data,
				readFromExcelSheet.getCellStringContent(fieldContent, 6),
				readFromExcelSheet.getCellStringContent(fieldContent, 16),
				readFromExcelSheet.getCellStringContent(fieldContent, 17),
				readFromExcelSheet.getCellStringContent(fieldContent, 18),
				readFromExcelSheet.getCellStringContent(fieldContent, 19));

		// Certificate Number
		SQ3_1 sq3_1 = PageFactory.initElements(driver, SQ3_1.class);
		sq3_1.intention_Number(
				readFromExcelSheet.getCellStringContent(fieldContent, 7),
				n565data);

		// Declaration of Intention Number
		SQ3_1_1 sq3_1_1 = PageFactory.initElements(driver, SQ3_1_1.class);
		sq3_1_1.certificate_number(
				readFromExcelSheet.getCellStringContent(fieldContent, 8),
				n565data);

		// Document issuance details
		SQ3_2 sq3_2 = PageFactory.initElements(driver, SQ3_2.class);
		sq3_2.DocsIssuanceDetails(
				readFromExcelSheet.getCellStringContent(fieldContent, 9), 
				(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 20),
				n565data);

		// About Your U.S. Citizenship
		SQ3_3 sq3_3 = PageFactory.initElements(driver, SQ3_3.class);
		sq3_3.abt_YourUSCitizenship(
				readFromExcelSheet.getCellStringContent(fieldContent, 10),
				n565data);

		// Incorrect Document
		SQ3_4 sq3_4 = PageFactory.initElements(driver, SQ3_4.class);
		sq3_4.incorrect_Document(
				readFromExcelSheet.getCellStringContent(fieldContent, 11),
				n565data);

		// Government Agency Details
		SQ4_1 sq4_1 = PageFactory.initElements(driver, SQ4_1.class);
		sq4_1.govt_AgencyDetails(
				readFromExcelSheet.getCellStringContent(fieldContent, 12),
				n565data);

		// Government Agency Address
		SQ4_2 sq4_2 = PageFactory.initElements(driver, SQ4_2.class);
		sq4_2.addressOfGovtAgency(
				readFromExcelSheet.getCellStringContent(fieldContent, 13),
				n565data);
		
		
		SQ5_1 sq5_1=PageFactory.initElements(driver, SQ5_1.class);
		sq5_1.interpreterInfo(readFromExcelSheet.getCellStringContent(fieldContent, 14));
		
		
		SQ5_2 sq5_2=PageFactory.initElements(driver, SQ5_2.class);
		sq5_2.agreeToSubmit(readFromExcelSheet.getCellStringContent(fieldContent, 15));
		
		// Application Review
		if (!flowname.contains("InEligible")) {

			ApplicationReview appReview = PageFactory.initElements(driver,
					ApplicationReview.class);
			appReview.completeApplicationUsingNewCSS(appName);
		}
		readFromExcelSheet.closeWorkbook();

	}

}

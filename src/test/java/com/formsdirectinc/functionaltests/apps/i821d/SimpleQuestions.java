package com.formsdirectinc.functionaltests.apps.i821d;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.i821d.pages.SQ1_0;
import com.formsdirectinc.functionaltests.apps.i821d.pages.SQ1_0_2;
import com.formsdirectinc.functionaltests.apps.i821d.pages.SQ1_1;
import com.formsdirectinc.functionaltests.apps.i821d.pages.SQ1_2;
import com.formsdirectinc.functionaltests.apps.i821d.pages.SQ1_3;
import com.formsdirectinc.functionaltests.apps.i821d.pages.SQ2_1;
import com.formsdirectinc.functionaltests.apps.i821d.pages.SQ2_2;
import com.formsdirectinc.functionaltests.apps.i821d.pages.SQ2_3;
import com.formsdirectinc.functionaltests.apps.i821d.pages.SQ2_3_1;
import com.formsdirectinc.functionaltests.apps.i821d.pages.SQ2_3_2;
import com.formsdirectinc.functionaltests.apps.i821d.pages.SQ2_4;
import com.formsdirectinc.functionaltests.apps.i821d.pages.SQ2_4_2;
import com.formsdirectinc.functionaltests.apps.i821d.pages.SQ2_6;
import com.formsdirectinc.functionaltests.apps.i821d.pages.SQ2_7;
import com.formsdirectinc.functionaltests.apps.i821d.pages.SQ2_8;
import com.formsdirectinc.functionaltests.apps.i821d.pages.SQ3_1;
import com.formsdirectinc.functionaltests.apps.i821d.pages.SQ3_2;
import com.formsdirectinc.functionaltests.apps.i821d.pages.SQ3_2_1;
import com.formsdirectinc.functionaltests.apps.i821d.pages.SQ4_1;
import com.formsdirectinc.functionaltests.apps.i821d.pages.SQ4_2;
import com.formsdirectinc.functionaltests.apps.i821d.pages.SQ5_1;
import com.formsdirectinc.functionaltests.apps.i821d.pages.SQ5_2;
import com.formsdirectinc.functionaltests.apps.i821d.pages.SQ6_1;
import com.formsdirectinc.functionaltests.apps.i821d.pages.SQ6_2;
import com.formsdirectinc.functionaltests.apps.i821d.pages.SQ6_3;
import com.formsdirectinc.functionaltests.apps.i821d.pages.SQ7_1;
import com.formsdirectinc.functionaltests.apps.i821d.pages.SQ7_2;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.ApplicationReview;
import com.formsdirectinc.functionaltests.tags.ReadDataFromExcelSheet;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * @author Orina
 * @Product DACA SimpleQuestions
 */
public class SimpleQuestions  extends Step {

	

	public SimpleQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	String appName = Products.I821D.name();

	public void test(String product, String flowname)
			throws Exception {

		ReadDataFromExcelSheet readFromExcelSheet = new ReadDataFromExcelSheet();
		String dacaSheet = "DACA";
		readFromExcelSheet.initializeWorkbook(dacaSheet);
		Integer fieldContent = readFromExcelSheet
				.getRowNumberUsingContent(flowname);
		PropertyResource propertyFile=new PropertyResource();
		Properties i821Ddata = propertyFile.loadProperty("name");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		// SQ Section :
		ApplicationReview startHere = PageFactory.initElements(driver,
				ApplicationReview.class);
		startHere.selectStartApplication();
		startHere.selectStartHereLink();

		SQ1_0 sq1_0 = PageFactory.initElements(driver, SQ1_0.class);
		sq1_0.applyingDACAForFirstTime(
				readFromExcelSheet.getCellStringContent(fieldContent, 26),
				i821Ddata);
		sq1_0.continueToNext(readFromExcelSheet.getCellStringContent(
				fieldContent, 26),"SQ1_0");

		SQ1_0_2 sq1_0_2 = PageFactory.initElements(driver, SQ1_0_2.class);
		sq1_0_2.attention_Required(readFromExcelSheet.getCellStringContent(
				fieldContent, 27));

		SQ1_1 sq1_1 = PageFactory.initElements(driver, SQ1_1.class);
		sq1_1.presenceInUS(
				readFromExcelSheet.getCellStringContent(fieldContent, 26),
				readFromExcelSheet.getCellStringContent(fieldContent, 28));
		sq1_0.continueToNext(readFromExcelSheet.getCellStringContent(
				fieldContent, 26),"SQ1_1");

		SQ1_2 sq1_2 = PageFactory.initElements(driver, SQ1_2.class);
		sq1_2.tripsOutsideUS(readFromExcelSheet.getCellStringContent(
				fieldContent, 29), (int) readFromExcelSheet
				.getCellIntegerContent(fieldContent, 47), i821Ddata);
		sq1_0.continueToNext(readFromExcelSheet.getCellStringContent(
				fieldContent, 29),"SQ1_2");

		SQ1_3 sq1_3 = PageFactory.initElements(driver, SQ1_3.class);
		sq1_3.tripOutside(readFromExcelSheet.getCellStringContent(fieldContent,
				30), (int) readFromExcelSheet.getCellIntegerContent(
				fieldContent, 47), i821Ddata);
		sq1_0.continueToNext(readFromExcelSheet.getCellStringContent(
				fieldContent, 30),"SQ1_3");

		SQ2_1 sq2_1 = PageFactory.initElements(driver, SQ2_1.class);
		sq2_1.applicantNameDetails(i821Ddata);
		sq1_0.saveScreenShot(product, "SQ2_1"); sq1_0.clickContinueInSQ();

		SQ2_2 sq2_2 = PageFactory.initElements(driver, SQ2_2.class);
		sq2_2.setOtherNames(readFromExcelSheet.getCellStringContent(
				fieldContent, 31), (int) readFromExcelSheet
				.getCellIntegerContent(fieldContent, 47), i821Ddata);
		sq1_0.continueToNext(readFromExcelSheet.getCellStringContent(
				fieldContent, 31),"SQ2_2");

		SQ2_3 SQ2_3 = PageFactory.initElements(driver, SQ2_3.class);
		SQ2_3.applicantAddress(i821Ddata);
		sq1_0.saveScreenShot(product, "SQ2_3"); sq1_0.clickContinueInSQ();

		SQ2_3_1 SQ2_3_1 = PageFactory.initElements(driver, SQ2_3_1.class);
		SQ2_3_1.applicantCurrentAddress(readFromExcelSheet
				.getCellStringContent(fieldContent, 32),
				(int) readFromExcelSheet
						.getCellIntegerContent(fieldContent, 47), i821Ddata);
		sq1_0.continueToNext(readFromExcelSheet.getCellStringContent(
				fieldContent, 32),"SQ2_3_1");

		SQ2_3_2 SQ2_3_2 = PageFactory.initElements(driver, SQ2_3_2.class);
		SQ2_3_2.applicantCurrentAddress(readFromExcelSheet.getCellStringContent(fieldContent, 33),
				(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 47),
				i821Ddata);
		sq1_0.continueToNext(readFromExcelSheet.getCellStringContent(
				fieldContent, 33),"SQ2_3_2");

		SQ2_4 SQ2_4 = PageFactory.initElements(driver, SQ2_4.class);
		SQ2_4.applicantCurrentAddress(i821Ddata);
		sq1_0.saveScreenShot(product, "SQ2_4"); sq1_0.clickContinueInSQ();

		SQ2_4_2 SQ2_4_2 = PageFactory.initElements(driver, SQ2_4_2.class);
		SQ2_4_2.applicantPhysicalTraits(i821Ddata);
		sq1_0.saveScreenShot(product, "SQ2_4_2"); sq1_0.clickContinueInSQ();

		SQ2_6 SQ2_6 = PageFactory.initElements(driver, SQ2_6.class);
		SQ2_6.applicantMarritalStatus(i821Ddata);
		sq1_0.saveScreenShot(product, "SQ2_6"); sq1_0.clickContinueInSQ();

		SQ2_7 SQ2_7 = PageFactory.initElements(driver, SQ2_7.class);
		SQ2_7.applicantARN(
				readFromExcelSheet.getCellStringContent(fieldContent, 34),
				i821Ddata);
		sq1_0.continueToNext(readFromExcelSheet.getCellStringContent(
				fieldContent, 34),"SQ2_7");

		SQ2_8 SQ2_8 = PageFactory.initElements(driver, SQ2_8.class);
		SQ2_8.applicantSSN(readFromExcelSheet.getCellStringContent(
				fieldContent, 35), (int) readFromExcelSheet
				.getCellIntegerContent(fieldContent, 47), i821Ddata);
		sq1_0.continueToNext(readFromExcelSheet.getCellStringContent(
				fieldContent, 35),"SQ2_8");

		SQ3_1 SQ3_1 = PageFactory.initElements(driver, SQ3_1.class);
		SQ3_1.entryIntoUS(i821Ddata,readFromExcelSheet.getCellStringContent(
				fieldContent, 48));
		sq1_0.saveScreenShot(product, "SQ3_1"); sq1_0.clickContinueInSQ();

		SQ3_2 SQ3_2 = PageFactory.initElements(driver, SQ3_2.class);
		SQ3_2.applicantDontHaveI94(
				readFromExcelSheet.getCellStringContent(fieldContent, 36),
				i821Ddata);
		sq1_0.continueToNext(readFromExcelSheet.getCellStringContent(
				fieldContent, 36),"SQ3_2");

		SQ3_2_1 SQ3_2_1 = PageFactory.initElements(driver, SQ3_2_1.class);
		SQ3_2_1.applicantDontHaveTravelDoc(
				readFromExcelSheet.getCellStringContent(fieldContent, 37),
				i821Ddata);
		sq1_0.continueToNext(readFromExcelSheet.getCellStringContent(
				fieldContent, 37),"SQ3_2_1");

		SQ4_1 SQ4_1 = PageFactory.initElements(driver, SQ4_1.class);
		SQ4_1.applicantEducationStatus(
				readFromExcelSheet.getCellStringContent(fieldContent, 38),
				readFromExcelSheet.getCellStringContent(fieldContent, 39),
				i821Ddata);
		sq1_0.continueToNext(readFromExcelSheet.getCellStringContent(
				fieldContent, 38),"SQ1_1");

		SQ4_2 SQ4_2 = PageFactory.initElements(driver, SQ4_2.class);
		SQ4_2.applicantNotServedMilitary(
				readFromExcelSheet.getCellStringContent(fieldContent, 40),
				i821Ddata);
		sq1_0.continueToNext(readFromExcelSheet.getCellStringContent(
				fieldContent, 40),"SQ4_2");

		SQ5_1 SQ5_1 = PageFactory.initElements(driver, SQ5_1.class);
		SQ5_1.applicantEmploymentDetails(i821Ddata);
		sq1_0.saveScreenShot(product, "SQ5_1"); sq1_0.clickContinueInSQ();

		SQ5_2 SQ5_2 = PageFactory.initElements(driver, SQ5_2.class);
		SQ5_2.applicantPreviousEmployment(readFromExcelSheet
				.getCellStringContent(fieldContent, 41),
				(int) readFromExcelSheet
						.getCellIntegerContent(fieldContent, 47), i821Ddata);
		sq1_0.continueToNext(readFromExcelSheet.getCellStringContent(
				fieldContent, 41),"SQ5_2");

		SQ6_1 SQ6_1 = PageFactory.initElements(driver, SQ6_1.class);
		SQ6_1.immigrationproceedings(
				readFromExcelSheet.getCellStringContent(fieldContent, 42),
				readFromExcelSheet.getCellStringContent(fieldContent, 43),
				i821Ddata);
		sq1_0.continueToNext(readFromExcelSheet.getCellStringContent(
				fieldContent, 42),"SQ6_1");

		SQ6_2 SQ6_2 = PageFactory.initElements(driver, SQ6_2.class);
		SQ6_2.criminalCharges(
				readFromExcelSheet.getCellStringContent(fieldContent, 44),
				i821Ddata);
		sq1_0.continueToNext(readFromExcelSheet.getCellStringContent(
				fieldContent, 43),"SQ6_2");

		SQ6_3 SQ6_3 = PageFactory.initElements(driver, SQ6_3.class);
		SQ6_3.criminalCharges(
				readFromExcelSheet.getCellStringContent(fieldContent, 45),
				i821Ddata);
		sq1_0.continueToNext(readFromExcelSheet.getCellStringContent(
				fieldContent, 44),"SQ6_3");

		SQ7_1 SQ7_1 = PageFactory.initElements(driver, SQ7_1.class);
		SQ7_1.certification(
				readFromExcelSheet.getCellStringContent(fieldContent, 46),
				i821Ddata);
		sq1_0.continueToNext(readFromExcelSheet.getCellStringContent(fieldContent, 45),"SQ7_1");

		SQ7_2 SQ7_2 = PageFactory.initElements(driver, SQ7_2.class);
		SQ7_2.certification();
		sq1_0.saveScreenShot(product, "SQ7_2"); sq1_0.clickContinueInSQ();
		// Application Review
		if (!flowname.contains("InEligible")) {

			ApplicationReview appReview = PageFactory.initElements(driver,
					ApplicationReview.class);
			appReview.completeApplicationUsingNewCSS(appName);
		}
		readFromExcelSheet.closeWorkbook();

	}

}

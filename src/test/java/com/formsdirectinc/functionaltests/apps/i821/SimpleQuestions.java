package com.formsdirectinc.functionaltests.apps.i821;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ1_1;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ1_3;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ1_4;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ1_6;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ1_9;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ2_1;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ2_2;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ2_3;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ2_4;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ2_6;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ2_7;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ2_8;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ2_8_1;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ2_9;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ3_1;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ3_2;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ4_1;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ4_2;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ4_3;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ4_4;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ5_1;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ5_2;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ6_1;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ6_2;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ6_3;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ6_4;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ6_5;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ6_6;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ6_7;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ7_1;
import com.formsdirectinc.functionaltests.apps.i821.pages.SQ7_2;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.ApplicationReview;
import com.formsdirectinc.functionaltests.tags.ReadDataFromExcelSheet;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * @author Orina
 * @Product I821 SimpleQuestions
 */
public class SimpleQuestions  extends Step {

	

	public SimpleQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String appName = Products.I821.name();

	public void test(String product, String flowname)
			throws Exception {

		ReadDataFromExcelSheet readFromExcelSheet = new ReadDataFromExcelSheet();
		String i821Sheet = "I821";
		readFromExcelSheet.initializeWorkbook(i821Sheet);
		Integer fieldContent = readFromExcelSheet
				.getRowNumberUsingContent(flowname);

		PropertyResource propertyFile=new PropertyResource();
		Properties i821data = propertyFile.loadProperty("name");
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		

		// SQ Section :
		ApplicationReview startHere = PageFactory.initElements(driver,
				ApplicationReview.class);
		startHere.selectStartApplication();
		startHere.selectStartHereLink();
		
		
		SQ1_1 sq1_1 = PageFactory.initElements(driver, SQ1_1.class);
		sq1_1.registration_TPS(
				readFromExcelSheet.getCellStringContent(fieldContent, 6),
				readFromExcelSheet.getCellStringContent(fieldContent, 7));

		SQ1_3 sq1_3 = PageFactory.initElements(driver, SQ1_3.class);
		sq1_3.attention_RequiredUpdates(readFromExcelSheet.getCellStringContent(
					fieldContent, 8));
		
		SQ1_4 sq1_4 = PageFactory.initElements(driver, SQ1_4.class);
		sq1_4.currentlyResidingInUs(
				readFromExcelSheet.getCellStringContent(fieldContent, 9),
				readFromExcelSheet.getCellStringContent(fieldContent, 10),
				readFromExcelSheet.getCellStringContent(fieldContent, 11),
				i821data);

		SQ1_6 sq1_6 = PageFactory.initElements(driver, SQ1_6.class);
		sq1_6.presencein_US(
				readFromExcelSheet.getCellStringContent(fieldContent, 12),
				readFromExcelSheet.getCellDateContent(fieldContent, 13),
				readFromExcelSheet.getCellDateContent(fieldContent, 14),
				i821data);

		SQ1_9 sq1_9 = PageFactory.initElements(driver, SQ1_9.class);
		sq1_9.tripOutSide_US(
				readFromExcelSheet.getCellStringContent(fieldContent, 15),
				i821data);

		SQ2_1 sq2_1 = PageFactory.initElements(driver, SQ2_1.class);
		sq2_1.name_Detail(i821data);

		SQ2_2 sq2_2 = PageFactory.initElements(driver, SQ2_2.class);
		sq2_2.other_Names(readFromExcelSheet.getCellStringContent(fieldContent,
				16), (int) readFromExcelSheet.getCellIntegerContent(
				fieldContent, 43), i821data);

		SQ2_3 sq2_3 = PageFactory.initElements(driver, SQ2_3.class);
		sq2_3.address_Detail(readFromExcelSheet.getCellStringContent(
				fieldContent, 17), i821data,
				readFromExcelSheet.getCellStringContent(
						readFromExcelSheet.getRowNumberUsingContent(flowname),
						18));

		SQ2_4 sq2_4 = PageFactory.initElements(driver, SQ2_4.class);
		sq2_4.biographic_Information(
				readFromExcelSheet.getCellStringContent(fieldContent, 19),
				readFromExcelSheet.getCellStringContent(fieldContent, 20),
				i821data);

		SQ2_6 sq2_6 = PageFactory.initElements(driver, SQ2_6.class);
		sq2_6.marital_Status(readFromExcelSheet.getCellStringContent(
				fieldContent, 21));

		SQ2_7 sq2_7 = PageFactory.initElements(driver, SQ2_7.class);
		sq2_7.setARN(readFromExcelSheet.getCellStringContent(fieldContent, 22),
				i821data);

		SQ2_8 sq2_8 = PageFactory.initElements(driver, SQ2_8.class);
		sq2_8.set_SSN(
				readFromExcelSheet.getCellStringContent(fieldContent, 23),
				i821data);

		SQ2_8_1 sq2_8_1 = PageFactory.initElements(driver, SQ2_8_1.class);
		sq2_8_1.setELIS_number(
				readFromExcelSheet.getCellStringContent(fieldContent, 24),
				i821data);

		SQ2_9 sq2_9 = PageFactory.initElements(driver, SQ2_9.class);
		sq2_9.physical_Traits(
				readFromExcelSheet.getCellStringContent(fieldContent, 25),
				i821data);

		SQ3_1 sq3_1 = PageFactory.initElements(driver, SQ3_1.class);
		sq3_1.lastEnterUS(i821data);

		SQ3_2 sq3_2 = PageFactory.initElements(driver, SQ3_2.class);
		sq3_2.classofAdmission(
				readFromExcelSheet.getCellStringContent(fieldContent, 26),
				readFromExcelSheet.getCellStringContent(fieldContent, 27),
				readFromExcelSheet.getCellStringContent(fieldContent, 28),
				i821data);

		SQ4_1 sq4_1 = PageFactory.initElements(driver, SQ4_1.class);
		sq4_1.about_Spouse(
				readFromExcelSheet.getCellStringContent(fieldContent, 29),
				i821data);

		SQ4_2 sq4_2 = PageFactory.initElements(driver, SQ4_2.class);
		sq4_2.spouse_Address(
				readFromExcelSheet.getCellStringContent(fieldContent, 30),
				i821data);

		SQ4_3 sq4_3 = PageFactory.initElements(driver, SQ4_3.class);
		sq4_3.spousePriorMarriages(readFromExcelSheet.getCellStringContent(
				fieldContent, 31), (int) readFromExcelSheet
				.getCellIntegerContent(fieldContent, 43), i821data);

		SQ4_4 sq4_4 = PageFactory.initElements(driver, SQ4_4.class);
		sq4_4.setChildDetails(readFromExcelSheet.getCellStringContent(fieldContent, 32),
				(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 43),
				i821data);

		SQ5_1 sq5_1 = PageFactory.initElements(driver, SQ5_1.class);
		sq5_1.setEAD(readFromExcelSheet.getCellStringContent(fieldContent, 33));

		SQ5_2 sq5_2 = PageFactory.initElements(driver, SQ5_2.class);
		sq5_2.setPreviousEAD(
				readFromExcelSheet.getCellStringContent(fieldContent, 34),
				i821data,
				(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 44));

		SQ6_1 sq6_1 = PageFactory.initElements(driver, SQ6_1.class);
		sq6_1.immigration_Proceedings(
				readFromExcelSheet.getCellStringContent(fieldContent, 35),
				i821data);

		SQ6_2 sq6_2 = PageFactory.initElements(driver, SQ6_2.class);
		sq6_2.setcrimeDetails(
				readFromExcelSheet.getCellStringContent(fieldContent, 36),
				i821data);

		SQ6_3 sq6_3 = PageFactory.initElements(driver, SQ6_3.class);
		sq6_3.setcriminal_Charges(
				readFromExcelSheet.getCellStringContent(fieldContent, 37),
				i821data);

		SQ6_4 sq6_4 = PageFactory.initElements(driver, SQ6_4.class);
		sq6_4.your_Affiliations(
				readFromExcelSheet.getCellStringContent(fieldContent, 38),
				i821data);

		SQ6_5 sq6_5 = PageFactory.initElements(driver, SQ6_5.class);
		sq6_5.set_Miscellaneous(
				readFromExcelSheet.getCellStringContent(fieldContent, 39),
				i821data);

		SQ6_6 sq6_6 = PageFactory.initElements(driver, SQ6_6.class);
		sq6_6.setOtherViolations(
				readFromExcelSheet.getCellStringContent(fieldContent, 40),
				i821data);

		SQ6_7 sq6_7 = PageFactory.initElements(driver, SQ6_7.class);
		sq6_7.setOther_Violations(
				readFromExcelSheet.getCellStringContent(fieldContent, 41),
				i821data);

		SQ7_1 sq7_1 = PageFactory.initElements(driver, SQ7_1.class);
		sq7_1.setCertification1(
				readFromExcelSheet.getCellStringContent(fieldContent, 42),
				i821data);

		SQ7_2 sq7_2 = PageFactory.initElements(driver, SQ7_2.class);
		sq7_2.set_Declaration();
		// Application Review
		if (!flowname.contains("InEligible")) {

			ApplicationReview appReview = PageFactory.initElements(driver,
					ApplicationReview.class);
			appReview.completeApplicationUsingNewCSS(appName);
			
			
		}
		readFromExcelSheet.closeWorkbook();

	}

}

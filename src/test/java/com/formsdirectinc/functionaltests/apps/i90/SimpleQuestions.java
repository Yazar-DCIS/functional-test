package com.formsdirectinc.functionaltests.apps.i90;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_1;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_1_2;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_1_3;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_1_3_1;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_1_4;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_1_5;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_2_1;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_2_2;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_3;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_3_1;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_3_2;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_3_3;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_3_3_1;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_3_4;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ1_4;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ2_1;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ3_1;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ3_1_2;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ3_1_3;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ3_2;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ4_1;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ4_2;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ4_3;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ5_1;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ5_1_1;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ5_1_2;
import com.formsdirectinc.functionaltests.apps.i90.pages.SQ5_2;
import com.formsdirectinc.functionaltests.apps.i90.pages.VerifyAddressPage1;
import com.formsdirectinc.functionaltests.apps.i90.pages.VerifyAddressPage2;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.ReadDataFromExcelSheet;
import com.formsdirectinc.functionaltests.newtags.ApplicationReview;
import com.formsdirectinc.functionaltests.utils.PropertyResource;


/**
 * @author Orina
 * @Product I90 SimpleQuestions
 */
public class SimpleQuestions extends Step{
	
	public SimpleQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String appName = Products.I90.name().toLowerCase();

	public void test(String product,String flowname) throws Exception {

		ReadDataFromExcelSheet readFromExcelSheet = new ReadDataFromExcelSheet();
		String i90Sheet = "I90";
		readFromExcelSheet.initializeWorkbook(i90Sheet);
		
		PropertyResource values=new PropertyResource();
		Properties i90properties=values.loadProperty("i90");
		Integer fieldContent=readFromExcelSheet.getRowNumberUsingContent(flowname);
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		// SQ Section :
		ApplicationReview startHere = PageFactory.initElements(driver,
				ApplicationReview.class);
		/*startHere.selectContinueApplication();
		startHere.gotoPage("i90", "SQ-1.1");*/
		startHere.selectStartApplication();
		startHere.selectStartHereLink();

		// SQ Section :

		SQ1_1 sq1_1 = PageFactory.initElements(driver, SQ1_1.class);
		sq1_1.nameandgender(i90properties,
				readFromExcelSheet.getCellStringContent(fieldContent,1),
				readFromExcelSheet.getCellStringContent(fieldContent,2));
		
		SQ1_1_2 sq1_1_2 = PageFactory.initElements(driver, SQ1_1_2.class);
		sq1_1_2.setAddressFields(i90properties,
				readFromExcelSheet.getCellStringContent(fieldContent, 3),
				readFromExcelSheet.getCellStringContent(fieldContent, 4),
				readFromExcelSheet.getCellStringContent(fieldContent, 5));
		
		
		VerifyAddressPage1 sq1_1_2_1 = PageFactory.initElements(driver, VerifyAddressPage1.class);
		sq1_1_2_1.decideAddress(readFromExcelSheet.getCellStringContent(fieldContent, 6));
		
		VerifyAddressPage2 sq1_1_2_2 = PageFactory.initElements(driver, VerifyAddressPage2.class);
		sq1_1_2_2.sureAboutMyMailingAddress(readFromExcelSheet.getCellStringContent(fieldContent, 7));
		
		
		SQ1_1_3 sq1_1_3 = PageFactory.initElements(driver, SQ1_1_3.class);
		sq1_1_3.personalInfo(i90properties);

		SQ1_1_3_1 sq1_1_3_1 = PageFactory.initElements(driver, SQ1_1_3_1.class);
		sq1_1_3_1.contactDetails(i90properties,
				readFromExcelSheet.getCellStringContent(fieldContent, 8));

		SQ1_1_4 sq1_1_4 = PageFactory.initElements(driver, SQ1_1_4.class);
		sq1_1_4.setParentName(i90properties);

		SQ1_1_5 sq1_1_5 = PageFactory.initElements(driver, SQ1_1_5.class);
		sq1_1_5.physicalTraits(i90properties,
				readFromExcelSheet.getCellStringContent(fieldContent, 9),
				readFromExcelSheet.getCellStringContent(fieldContent, 10),
				(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 11),
				(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 12),
				readFromExcelSheet.getCellStringContent(fieldContent, 13));

		SQ1_2_1 sq1_2_1 = PageFactory.initElements(driver, SQ1_2_1.class);
		sq1_2_1.alienRegistrationNumber(i90properties,
				readFromExcelSheet.getCellStringContent(fieldContent, 14),
				readFromExcelSheet.getCellStringContent(fieldContent, 15));

		SQ1_2_2 sq1_2_2 = PageFactory.initElements(driver, SQ1_2_2.class);
		sq1_2_2.socialSecurityNumber(i90properties,
				readFromExcelSheet.getCellStringContent(fieldContent, 16));

		SQ1_3 sq1_3 = PageFactory.initElements(driver, SQ1_3.class);
		sq1_3.originApplication(readFromExcelSheet.getCellStringContent(fieldContent, 17),
				readFromExcelSheet.getCellStringContent(fieldContent, 18));

		SQ1_3_1 sq1_3_1 = PageFactory.initElements(driver, SQ1_3_1.class);
		sq1_3_1.setImmigrationVisaProcessingInfo(i90properties,
				readFromExcelSheet.getCellStringContent(fieldContent, 19));

		SQ1_3_2 sq1_3_2 = PageFactory.initElements(driver, SQ1_3_2.class);
		sq1_3_2.adjustmentOfStatus(i90properties,
				readFromExcelSheet.getCellStringContent(fieldContent, 20));

		SQ1_3_3 sq1_3_3 = PageFactory.initElements(driver, SQ1_3_3.class);
		sq1_3_3.setStatusAdjustmentDate(i90properties,
				readFromExcelSheet.getCellStringContent(fieldContent, 21));

		SQ1_3_3_1 sq1_3_3_1 = PageFactory.initElements(driver, SQ1_3_3_1.class);
		sq1_3_3_1.setImmigrantAdmissionDate(i90properties,
				readFromExcelSheet.getCellStringContent(fieldContent, 22));

		SQ1_3_4 sq1_3_4 = PageFactory.initElements(driver, SQ1_3_4.class);
		sq1_3_4.classOfAdmission(i90properties);

		SQ1_4 sq1_4 = PageFactory.initElements(driver, SQ1_4.class);
		sq1_4.setPlaceOfEntry(i90properties,
				readFromExcelSheet.getCellStringContent(fieldContent, 23));

		SQ2_1 sq2_1 = PageFactory.initElements(driver, SQ2_1.class);
		sq2_1.residenceType(
				readFromExcelSheet.getCellStringContent(fieldContent, 24),
				readFromExcelSheet.getCellStringContent(fieldContent, 25));

		SQ3_1 sq3_1 = PageFactory.initElements(driver, SQ3_1.class);
		sq3_1.applicationType(i90properties,
				readFromExcelSheet.getCellStringContent(fieldContent, 26),
				readFromExcelSheet.getCellStringContent(fieldContent, 27),
				readFromExcelSheet.getCellStringContent(fieldContent, 28),
				readFromExcelSheet.getCellStringContent(fieldContent, 29));

		SQ3_1_2 sq3_1_2 = PageFactory.initElements(driver, SQ3_1_2.class);
		sq3_1_2.applicationType(i90properties,
				readFromExcelSheet.getCellStringContent(fieldContent, 30),
				readFromExcelSheet.getCellStringContent(fieldContent, 31));

		SQ3_1_3 sq3_1_3 = PageFactory.initElements(driver, SQ3_1_3.class);
		sq3_1_3.waitToFileApplication(readFromExcelSheet.getCellStringContent(fieldContent, 32));
		
		
		SQ3_2 sq3_2 = PageFactory.initElements(driver, SQ3_2.class);
		sq3_2.corrections(i90properties,
				readFromExcelSheet.getCellStringContent(fieldContent, 33),
				readFromExcelSheet.getCellStringContent(fieldContent, 34),
				readFromExcelSheet.getCellStringContent(fieldContent, 35),
				readFromExcelSheet.getCellStringContent(fieldContent, 36),
				readFromExcelSheet.getCellStringContent(fieldContent, 37),
				readFromExcelSheet.getCellStringContent(fieldContent, 38),
				readFromExcelSheet.getCellStringContent(fieldContent, 39));

		SQ4_1 sq4_1 = PageFactory.initElements(driver, SQ4_1.class);
		sq4_1.proceedings(i90properties,
				readFromExcelSheet.getCellStringContent(fieldContent, 40));

		SQ4_2 sq4_2 = PageFactory.initElements(driver, SQ4_2.class);
		sq4_2.abondonment(i90properties,
				readFromExcelSheet.getCellStringContent(fieldContent, 41));

		SQ4_3 sq4_3 = PageFactory.initElements(driver, SQ4_3.class);
		sq4_3.accommodations(i90properties,
				readFromExcelSheet.getCellStringContent(fieldContent, 42),
				readFromExcelSheet.getCellStringContent(fieldContent, 43));

		SQ5_1_1 sq5_1_1 = PageFactory.initElements(driver, SQ5_1_1.class);
		sq5_1_1.interpreterInfo(i90properties,
				readFromExcelSheet.getCellStringContent(fieldContent, 44),
				readFromExcelSheet.getCellStringContent(fieldContent, 45));

		SQ5_1_2 sq5_1_2 = PageFactory.initElements(driver, SQ5_1_2.class);
		sq5_1_2.preparerInfo(i90properties,
				readFromExcelSheet.getCellStringContent(fieldContent, 46),
				readFromExcelSheet.getCellStringContent(fieldContent, 47),
				readFromExcelSheet.getCellStringContent(fieldContent, 48),
				readFromExcelSheet.getCellStringContent(fieldContent, 49));

		SQ5_1 sq5_1 = PageFactory.initElements(driver, SQ5_1.class);
		sq5_1.acknowledgements();
		
		SQ5_2 sq5_2 = PageFactory.initElements(driver, SQ5_2.class);
		sq5_2.applicantCertification();
		
		// Application Review
		if (!flowname.contains("InEligible")) {

			ApplicationReview appReview = PageFactory.initElements(driver,
					ApplicationReview.class);
			appReview.completeApplicationUsingNewCSS(appName);
		}
		readFromExcelSheet.closeWorkbook();
	}

	
}

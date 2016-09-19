package com.formsdirectinc.functionaltests.apps.i765;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_1;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_10;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_10_1;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_11;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_11_1;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_11_2;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_11_3;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_12;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_12_1;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_12_2;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_12_3;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_12_4;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_13;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_13_1;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_13_2;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_13_3;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_13_4;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_14;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_2;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_3;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_3_1;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_3_2;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_4;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_5;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_6;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_7;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_8;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_8_1;
import com.formsdirectinc.functionaltests.apps.i765.pages.EQ1_9;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.EQ_InEligible;
import com.formsdirectinc.functionaltests.tags.EQ_Success;
import com.formsdirectinc.functionaltests.tags.Quiz_Options;
import com.formsdirectinc.functionaltests.tags.ReadDataFromExcelSheet;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.StartApplication;

/**
 * @author Orina
 * @Product I765 EligiblityQuestions
 */

public class EligiblityQuestions extends Step {

	public EligiblityQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String appName = Products.I765.name();

	public void test(String product, String flowname) throws Exception {

		ReadDataFromExcelSheet readFromExcelSheet = new ReadDataFromExcelSheet();
		String i765Sheet = "I765";
		readFromExcelSheet.initializeWorkbook(i765Sheet);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Integer fieldContent = readFromExcelSheet.getRowNumberUsingContent(flowname);

		Sites site = Sites.valueOf(System.getProperty("site.name"));
		if (site != Sites.FR) {
			driver.get(site.getProductURL());
			SelectElement productName = new SelectElement(driver, "I-765");
			productName.selectElementUsingPartialLinkText();
		}
		
		if (site == Sites.FR) {
			driver.get(site.getBaseURL()+"immigration-solutions/employment-authorization/");
		}

		StartApplication startApp = PageFactory.initElements(driver,
					StartApplication.class);
		startApp.startApplication(appName);
	

		if (site != Sites.FR) {
			Quiz_Options takeQuiz = PageFactory.initElements(driver,
					Quiz_Options.class);
			takeQuiz.takeQuiz(appName);
		}

		// EQ Pages
		EQ1_1 eq1_1 = PageFactory.initElements(driver, EQ1_1.class);
		eq1_1.reasonForI765Application((int) readFromExcelSheet
				.getCellIntegerContent(fieldContent, 1));

		EQ1_2 eq1_2 = PageFactory.initElements(driver, EQ1_2.class);
		eq1_2.applyingEADthroughDACA(readFromExcelSheet.getCellStringContent(
				fieldContent, 2));

		EQ1_3 eq1_3 = PageFactory.initElements(driver, EQ1_3.class);
		eq1_3.renewEADthroughDACA(readFromExcelSheet.getCellStringContent(
				fieldContent, 3));

		EQ1_3_1 eq1_3_1 = PageFactory.initElements(driver, EQ1_3_1.class);
		eq1_3_1.EADCardStatus(readFromExcelSheet.getCellStringContent(
				fieldContent, 4));

		EQ1_3_2 eq1_3_2 = PageFactory.initElements(driver, EQ1_3_2.class);
		eq1_3_2.reasonForI765Application(readFromExcelSheet
				.getCellStringContent(fieldContent, 5));

		EQ1_4 eq1_4 = PageFactory.initElements(driver, EQ1_4.class);
		eq1_4.currentStatusOfApplicant(readFromExcelSheet.getCellStringContent(
				fieldContent, 6));

		EQ1_5 eq1_5 = PageFactory.initElements(driver, EQ1_5.class);
		eq1_5.studentTypeOfApplicant(readFromExcelSheet.getCellStringContent(
				fieldContent, 7));

		EQ1_6 eq1_6 = PageFactory.initElements(driver, EQ1_6.class);
		eq1_6.studentTypeOfApplicant(readFromExcelSheet.getCellStringContent(
				fieldContent, 8));

		EQ1_7 eq1_7 = PageFactory.initElements(driver, EQ1_7.class);
		eq1_7.spouseVisaStatus(readFromExcelSheet.getCellStringContent(
				fieldContent, 9));

		EQ1_8 eq1_8 = PageFactory.initElements(driver, EQ1_8.class);
		eq1_8.k1FianceVisa(readFromExcelSheet.getCellStringContent(
				fieldContent, 10));

		EQ1_8_1 eq1_8_1 = PageFactory.initElements(driver, EQ1_8_1.class);
		eq1_8_1.arrrivedUsOn(readFromExcelSheet.getCellStringContent(
				fieldContent, 11));

		EQ1_9 eq1_9 = PageFactory.initElements(driver, EQ1_9.class);
		eq1_9.haveK3orK4Visa(readFromExcelSheet.getCellStringContent(
				fieldContent, 12));

		EQ1_10 eq1_10 = PageFactory.initElements(driver, EQ1_10.class);
		eq1_10.I589Status(readFromExcelSheet.getCellStringContent(fieldContent,
				13));

		EQ1_10_1 eq1_10_1 = PageFactory.initElements(driver, EQ1_10_1.class);
		eq1_10_1.receivedNoticeDateForI589(readFromExcelSheet
				.getCellStringContent(fieldContent, 14));

		EQ1_11 eq1_11 = PageFactory.initElements(driver, EQ1_11.class);
		eq1_11.selectReason(readFromExcelSheet.getCellStringContent(
				fieldContent, 15));

		EQ1_11_1 eq1_11_1 = PageFactory.initElements(driver, EQ1_11_1.class);
		eq1_11_1.HaveImmigrationJudgeOrder(readFromExcelSheet
				.getCellStringContent(fieldContent, 16));

		EQ1_11_2 eq1_11_2 = PageFactory.initElements(driver, EQ1_11_2.class);
		eq1_11_2.haveProofForI881(readFromExcelSheet.getCellStringContent(
				fieldContent, 17));

		EQ1_11_3 eq1_11_3 = PageFactory.initElements(driver, EQ1_11_3.class);
		eq1_11_3.haveIdentityDocProof(readFromExcelSheet.getCellStringContent(
				fieldContent, 18));

		EQ1_12 eq1_12 = PageFactory.initElements(driver, EQ1_12.class);
		eq1_12.EverHadEADCard(readFromExcelSheet.getCellStringContent(
				fieldContent, 19));

		EQ1_12_1 eq1_12_1 = PageFactory.initElements(driver, EQ1_12_1.class);
		eq1_12_1.reasonForI765Application(readFromExcelSheet
				.getCellStringContent(fieldContent, 20));

		EQ1_12_2 eq1_12_2 = PageFactory.initElements(driver, EQ1_12_2.class);
		eq1_12_2.EADCardStatus(readFromExcelSheet.getCellStringContent(
				fieldContent, 21));

		EQ1_12_3 eq1_12_3 = PageFactory.initElements(driver, EQ1_12_3.class);
		eq1_12_3.receivedNoticeDateForI589(readFromExcelSheet
				.getCellStringContent(fieldContent, 22));

		EQ1_12_4 eq1_12_4 = PageFactory.initElements(driver, EQ1_12_4.class);
		eq1_12_4.approvedDateForI589(readFromExcelSheet.getCellStringContent(
				fieldContent, 23));

		EQ1_13 eq1_13 = PageFactory.initElements(driver, EQ1_13.class);
		eq1_13.selectReasonForApplying(readFromExcelSheet.getCellStringContent(
				fieldContent, 24));

		EQ1_13_1 eq1_13_1 = PageFactory.initElements(driver, EQ1_13_1.class);
		eq1_13_1.HaveProofForI485Pending(readFromExcelSheet
				.getCellStringContent(fieldContent, 25));

		EQ1_13_2 eq1_13_2 = PageFactory.initElements(driver, EQ1_13_2.class);
		eq1_13_2.RequestedForEADCardUstatus(readFromExcelSheet
				.getCellStringContent(fieldContent, 26));

		EQ1_13_3 eq1_13_3 = PageFactory.initElements(driver, EQ1_13_3.class);
		eq1_13_3.RequestedForEADCardTstatus(readFromExcelSheet
				.getCellStringContent(fieldContent, 27));

		EQ1_13_4 eq1_13_4 = PageFactory.initElements(driver, EQ1_13_4.class);
		eq1_13_4.CopyOfApprovalNotice(readFromExcelSheet.getCellStringContent(
				fieldContent, 28));

		EQ1_14 eq1_14 = PageFactory.initElements(driver, EQ1_14.class);
		eq1_14.selectReason(readFromExcelSheet.getCellStringContent(
				fieldContent, 29));

		if(flowname.contains("InEligible"))
		{
			EQ_InEligible stopApp=PageFactory.initElements(driver, EQ_InEligible.class);
			stopApp.ineligibleApplication(appName);
		}
		else
		{
			EQ_Success startApplication = PageFactory.initElements(driver, EQ_Success.class);
			startApplication.startApplication(appName);
		}	

	}

}

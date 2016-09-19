package com.formsdirectinc.functionaltests.apps.i821d;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.i821d.pages.EQ1_1;
import com.formsdirectinc.functionaltests.apps.i821d.pages.EQ1_2;
import com.formsdirectinc.functionaltests.apps.i821d.pages.EQ1_3;
import com.formsdirectinc.functionaltests.apps.i821d.pages.EQ2_1;
import com.formsdirectinc.functionaltests.apps.i821d.pages.EQ2_2;
import com.formsdirectinc.functionaltests.apps.i821d.pages.EQ2_3;
import com.formsdirectinc.functionaltests.apps.i821d.pages.EQ2_4;
import com.formsdirectinc.functionaltests.apps.i821d.pages.EQ2_5;
import com.formsdirectinc.functionaltests.apps.i821d.pages.EQ2_6;
import com.formsdirectinc.functionaltests.apps.i821d.pages.EQ3_1;
import com.formsdirectinc.functionaltests.apps.i821d.pages.EQ3_2;
import com.formsdirectinc.functionaltests.apps.i821d.pages.EQ3_3;
import com.formsdirectinc.functionaltests.apps.i821d.pages.EQ3_4;
import com.formsdirectinc.functionaltests.apps.i821d.pages.EQ3_5;
import com.formsdirectinc.functionaltests.apps.i821d.pages.EQ3_6;
import com.formsdirectinc.functionaltests.apps.i821d.pages.EQ3_7;
import com.formsdirectinc.functionaltests.apps.i821d.pages.EQ4_1;
import com.formsdirectinc.functionaltests.apps.i821d.pages.EQ4_2;
import com.formsdirectinc.functionaltests.apps.i821d.pages.EQ4_3;
import com.formsdirectinc.functionaltests.apps.i821d.pages.EQ4_4;
import com.formsdirectinc.functionaltests.apps.i821d.pages.EQ5_1;
import com.formsdirectinc.functionaltests.apps.i821d.pages.EQ5_2;
import com.formsdirectinc.functionaltests.apps.i821d.pages.EQ5_3;
import com.formsdirectinc.functionaltests.apps.i821d.pages.EQ5_4;
import com.formsdirectinc.functionaltests.apps.i821d.pages.EQ5_5;
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
 * @Product DACA EligiblityQuestions
 */
public class EligiblityQuestions extends Step {

	public EligiblityQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String appName = Products.I821D.name();

	public void test(String product, String flowname) throws Exception {

		ReadDataFromExcelSheet readFromExcelSheet = new ReadDataFromExcelSheet();
		String dacaSheet = "DACA";
		readFromExcelSheet.initializeWorkbook(dacaSheet);
		Integer fieldContent = readFromExcelSheet.getRowNumberUsingContent(flowname);
		Sites site = Sites.valueOf(System.getProperty("site.name"));

		driver.get(site.getProductURL());

		SelectElement productName = new SelectElement(driver, "I-821D");
		productName.selectElementUsingPartialLinkText();

		StartApplication start = PageFactory.initElements(driver,
				StartApplication.class);
		start.startApplication(appName);

		if (site == Sites.AIC) {
			Quiz_Options takeQuiz = PageFactory.initElements(driver,
					Quiz_Options.class);
			takeQuiz.takeQuiz(appName);
		}
		EQ1_1 eq1_1 = PageFactory.initElements(driver, EQ1_1.class);
		eq1_1.receivedDACA(readFromExcelSheet.getCellStringContent(
				fieldContent, 1));
		

		EQ1_2 eq1_2 = PageFactory.initElements(driver, EQ1_2.class);
		eq1_2.dacaNotExpired(readFromExcelSheet.getCellStringContent(
				fieldContent, 2));
	

		EQ1_3 eq1_3 = PageFactory.initElements(driver, EQ1_3.class);
		eq1_3.dacaExpiredYearAgo(readFromExcelSheet.getCellStringContent(
				fieldContent, 3));
		

		EQ2_1 eq2_1 = PageFactory.initElements(driver, EQ2_1.class);
		eq2_1.currentlyUndocumented(readFromExcelSheet.getCellStringContent(
				fieldContent, 4));
		

		EQ2_2 eq2_2 = PageFactory.initElements(driver, EQ2_2.class);
		eq2_2.livingInUSRightNow(readFromExcelSheet.getCellStringContent(
				fieldContent, 5));
		

		EQ2_3 eq2_3 = PageFactory.initElements(driver, EQ2_3.class);
		eq2_3.whenEnterUS(readFromExcelSheet.getCellStringContent(fieldContent,
				6));
		

		EQ2_4 eq2_4 = PageFactory.initElements(driver, EQ2_4.class);
		eq2_4.everLeftUS15June2007(readFromExcelSheet.getCellStringContent(
				fieldContent, 7));
		

		EQ2_5 eq2_5 = PageFactory.initElements(driver, EQ2_5.class);
		eq2_5.everLeftUS01January2010(readFromExcelSheet.getCellStringContent(
				fieldContent, 8));
		

		EQ2_6 eq2_6 = PageFactory.initElements(driver, EQ2_6.class);
		eq2_6.chooseAllThatApply(readFromExcelSheet.getCellStringContent(
				fieldContent, 9));
		
		EQ3_1 eq3_1 = PageFactory.initElements(driver, EQ3_1.class);
		eq3_1.bornOnOrBefore15June1981(readFromExcelSheet.getCellStringContent(
				fieldContent, 10));
		

		EQ3_2 eq3_2 = PageFactory.initElements(driver, EQ3_2.class);
		eq3_2.currentlyInSchool(readFromExcelSheet.getCellStringContent(
				fieldContent, 11));
		

		EQ3_3 eq3_3 = PageFactory.initElements(driver, EQ3_3.class);
		eq3_3.graduatedFromHighSchool(readFromExcelSheet.getCellStringContent(
				fieldContent, 12));
		
		EQ3_4 eq3_4 = PageFactory.initElements(driver, EQ3_4.class);
		eq3_4.passedTheGED(readFromExcelSheet.getCellStringContent(
				fieldContent, 13));
		

		EQ3_5 eq3_5 = PageFactory.initElements(driver, EQ3_5.class);
		eq3_5.dischargeFromUS(readFromExcelSheet.getCellStringContent(
				fieldContent, 14));
		

		EQ3_6 eq3_6 = PageFactory.initElements(driver, EQ3_6.class);
		eq3_6.undocumentedOn15June2012(readFromExcelSheet.getCellStringContent(
				fieldContent, 15));
		

		EQ3_7 eq3_7 = PageFactory.initElements(driver, EQ3_7.class);
		eq3_7.convictedOfAnyCrimes(readFromExcelSheet.getCellStringContent(
				fieldContent, 16));
		

		EQ4_1 eq4_1 = PageFactory.initElements(driver, EQ4_1.class);
		eq4_1.childUSCitizenOn20November2014(readFromExcelSheet
				.getCellStringContent(fieldContent, 17));
	

		EQ4_2 eq4_2 = PageFactory.initElements(driver, EQ4_2.class);
		eq4_2.childUSGCHolderOn20November2014(readFromExcelSheet
				.getCellStringContent(fieldContent, 18));
		

		EQ4_3 eq4_3 = PageFactory.initElements(driver, EQ4_3.class);
		eq4_3.undocumentedOn20November2014(readFromExcelSheet
				.getCellStringContent(fieldContent, 19));
		

		EQ4_4 eq4_4 = PageFactory.initElements(driver, EQ4_4.class);
		eq4_4.anyCrimes(readFromExcelSheet.getCellStringContent(fieldContent,
				20));
		

		EQ5_1 eq5_1 = PageFactory.initElements(driver, EQ5_1.class);
		eq5_1.expireBefore150Days(readFromExcelSheet.getCellStringContent(
				fieldContent, 21));
		

		EQ5_2 eq5_2 = PageFactory.initElements(driver, EQ5_2.class);
		eq5_2.notLeftUSAfterReceivingDACA(readFromExcelSheet
				.getCellStringContent(fieldContent, 22));
		
		EQ5_3 eq5_3 = PageFactory.initElements(driver, EQ5_3.class);
		eq5_3.advanceParoleForAllTrips(readFromExcelSheet.getCellStringContent(
				fieldContent, 23));
		

		EQ5_4 eq5_4 = PageFactory.initElements(driver, EQ5_4.class);
		eq5_4.livingInUSRightNow(readFromExcelSheet.getCellStringContent(
				fieldContent, 24));
		

		EQ5_5 eq5_5 = PageFactory.initElements(driver, EQ5_5.class);
		eq5_5.notConvictedAnyCrimes(readFromExcelSheet.getCellStringContent(
				fieldContent, 25));
		

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
		

		readFromExcelSheet.closeWorkbook();
	}

}

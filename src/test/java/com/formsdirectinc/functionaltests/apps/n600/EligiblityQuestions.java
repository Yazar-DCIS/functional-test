package com.formsdirectinc.functionaltests.apps.n600;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.n600.pages.EQ1_1;
import com.formsdirectinc.functionaltests.apps.n600.pages.EQ1_2;
import com.formsdirectinc.functionaltests.apps.n600.pages.EQ2_1;
import com.formsdirectinc.functionaltests.apps.n600.pages.EQ3_1;
import com.formsdirectinc.functionaltests.apps.n600.pages.EQ3_10;
import com.formsdirectinc.functionaltests.apps.n600.pages.EQ3_2;
import com.formsdirectinc.functionaltests.apps.n600.pages.EQ3_3;
import com.formsdirectinc.functionaltests.apps.n600.pages.EQ3_4;
import com.formsdirectinc.functionaltests.apps.n600.pages.EQ3_5;
import com.formsdirectinc.functionaltests.apps.n600.pages.EQ3_6;
import com.formsdirectinc.functionaltests.apps.n600.pages.EQ3_7;
import com.formsdirectinc.functionaltests.apps.n600.pages.EQ3_8;
import com.formsdirectinc.functionaltests.apps.n600.pages.EQ3_9;
import com.formsdirectinc.functionaltests.apps.n600.pages.EQ4_1;
import com.formsdirectinc.functionaltests.apps.n600.pages.EQ5_1;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.EQ_InEligible;
import com.formsdirectinc.functionaltests.tags.EQ_Success;
import com.formsdirectinc.functionaltests.tags.Quiz_Options;
import com.formsdirectinc.functionaltests.tags.ReadDataFromExcelSheet;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.StartApplication;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * @author Orina
 * @Product N600 EligiblityQuestions
 */
public class EligiblityQuestions extends Step {

	public EligiblityQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String appName = Products.N600.name();

	public void test(String product, String flowname) throws Exception {

		ReadDataFromExcelSheet readFromExcelSheet = new ReadDataFromExcelSheet();
		String n600Sheet = "N600";
		readFromExcelSheet.initializeWorkbook(n600Sheet);
		Integer fieldContent = readFromExcelSheet
				.getRowNumberUsingContent(flowname);
		PropertyResource propertyFile = new PropertyResource();
		Properties n600Copies = propertyFile.loadProperty(appName);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Sites site = Sites.valueOf(System.getProperty("site.name"));
		if (site != Sites.FR) {
			driver.get(site.getProductURL());
			SelectElement productName = new SelectElement(driver, "N-600");
			productName.selectElementUsingPartialLinkText();
		}
		
		if (site == Sites.FR) {
			driver.get(site.getBaseURL()+"immigration-solutions/certificate-of-citizenship/");
		}

		StartApplication start = PageFactory.initElements(driver,
				StartApplication.class);
		start.startApplication(appName);
		
		if (site != Sites.FR) {
			Quiz_Options takeQuiz = PageFactory.initElements(driver,
					Quiz_Options.class);
			takeQuiz.takeQuiz(appName);
		}
		
		EQ1_1 eq1_1;
		eq1_1 = PageFactory.initElements(driver, EQ1_1.class);
		eq1_1.bornOutsideUS(n600Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 1));

		EQ1_2 eq1_2;
		eq1_2 = PageFactory.initElements(driver, EQ1_2.class);
		eq1_2.residentStatus(n600Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 2));

		EQ2_1 eq2_1;
		eq2_1 = PageFactory.initElements(driver, EQ2_1.class);
		eq2_1.dateOfBirth(n600Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 3));

		EQ3_1 eq3_1;
		eq3_1 = PageFactory.initElements(driver, EQ3_1.class);
		eq3_1.bornToUSParents(n600Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 4));

		EQ3_2 eq3_2;
		eq3_2 = PageFactory.initElements(driver, EQ3_2.class);
		eq3_2.atleastOneParent_haveResidence(n600Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 5));

		EQ3_3 eq3_3;
		eq3_3 = PageFactory.initElements(driver, EQ3_3.class);
		eq3_3.oneParentIsUSCitizen(n600Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 6));

		EQ3_4 eq3_4;
		eq3_4 = PageFactory.initElements(driver, EQ3_4.class);
		eq3_4.parents_PhysicallyPresentInUS(n600Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 7));

		EQ3_5 eq3_5;
		eq3_5 = PageFactory.initElements(driver, EQ3_5.class);
		eq3_5.adopted_ByUSCitizenParent(n600Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 8));

		EQ3_6 eq3_6;
		eq3_6 = PageFactory.initElements(driver, EQ3_6.class);
		eq3_6.wasLegimate(n600Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 9));

		EQ3_7 eq3_7;
		eq3_7 = PageFactory.initElements(driver, EQ3_7.class);
		eq3_7.bothParents_Naturalized(n600Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 10));

		EQ3_8 eq3_8;
		eq3_8 = PageFactory.initElements(driver, EQ3_8.class);
		eq3_8.afterAdmission_ResidedRegularly(n600Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 11));

		EQ3_9 eq3_9;
		eq3_9 = PageFactory.initElements(driver, EQ3_9.class);
		eq3_9.born_OutOfWedlock(n600Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 12));

		EQ3_10 eq3_10;
		eq3_10 = PageFactory.initElements(driver, EQ3_10.class);
		eq3_10.motherNaturalizedStatus(n600Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 13));

		EQ4_1 eq4_1;
		eq4_1 = PageFactory.initElements(driver, EQ4_1.class);
		eq4_1.legalPhysicalCustody(n600Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 14),
				readFromExcelSheet.getCellStringContent(fieldContent, 3));

		EQ5_1 eq5_1;
		eq5_1 = PageFactory.initElements(driver, EQ5_1.class);
		eq5_1.admittedAsPermanentResident(n600Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 15),
				readFromExcelSheet.getCellStringContent(fieldContent, 3));

		readFromExcelSheet.closeWorkbook();

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

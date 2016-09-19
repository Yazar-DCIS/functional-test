package com.formsdirectinc.functionaltests.apps.n400;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.n400.pages.EQ1_1;
import com.formsdirectinc.functionaltests.apps.n400.pages.EQ1_2;
import com.formsdirectinc.functionaltests.apps.n400.pages.EQ2_1;
import com.formsdirectinc.functionaltests.apps.n400.pages.EQ2_2;
import com.formsdirectinc.functionaltests.apps.n400.pages.EQ2_3;
import com.formsdirectinc.functionaltests.apps.n400.pages.EQ3_1;
import com.formsdirectinc.functionaltests.apps.n400.pages.EQ3_2;
import com.formsdirectinc.functionaltests.apps.n400.pages.EQ3_3;
import com.formsdirectinc.functionaltests.apps.n400.pages.EQ3_4;
import com.formsdirectinc.functionaltests.apps.n400.pages.EQ3_5;
import com.formsdirectinc.functionaltests.apps.n400.pages.EQ3_6;
import com.formsdirectinc.functionaltests.apps.n400.pages.EQ4_1;
import com.formsdirectinc.functionaltests.apps.n400.pages.EQ4_2;
import com.formsdirectinc.functionaltests.apps.n400.pages.EQ4_3;
import com.formsdirectinc.functionaltests.apps.n400.pages.EQ5_1;
import com.formsdirectinc.functionaltests.apps.n400.pages.EQ5_2;
import com.formsdirectinc.functionaltests.apps.n400.pages.EQ5_3;
import com.formsdirectinc.functionaltests.apps.n400.pages.EQ5_4;
import com.formsdirectinc.functionaltests.apps.n400.pages.EQ6_1;
import com.formsdirectinc.functionaltests.apps.n400.pages.N400B_EQ1_1;
import com.formsdirectinc.functionaltests.apps.n400.pages.N400B_EQ3_1;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.EQ_InEligible;
import com.formsdirectinc.functionaltests.tags.EQ_Success;
import com.formsdirectinc.functionaltests.tags.Quiz_Options;
import com.formsdirectinc.functionaltests.tags.ReadDataFromExcelSheet;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.StartApplication;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * @author Orina
 * @Product N400 EligiblityQuestions
 */
public class EligiblityQuestions extends Step {

	public EligiblityQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String appName = Products.N400.name();
	
	public void test(String product, String flowname) throws Exception {

		ReadDataFromExcelSheet readFromExcelSheet = new ReadDataFromExcelSheet();
		String n400Sheet = "N400";

		readFromExcelSheet.initializeWorkbook(n400Sheet);
		Integer fieldContent = readFromExcelSheet.getRowNumberUsingContent(flowname);

		PropertyResource propertyFile = new PropertyResource();
		Properties n400Copies = propertyFile.loadProperty(appName);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Sites site = Sites.valueOf(System.getProperty("site.name"));
		if (site != Sites.FR) {
			driver.get(site.getProductURL());
			SelectElement productName = new SelectElement(driver, "N-400");
			productName.selectElementUsingPartialLinkText();
		}
		
		if (site == Sites.FR) {
			driver.get(site.getBaseURL()+"immigration-solutions/apply-for-citizenship/");
		}

		CaptureScreen homepage=new CaptureScreen(driver);
		homepage.takeScreenShot("n400", "HomePage");

		StartApplication startApp = PageFactory.initElements(driver,
				StartApplication.class);
		startApp.startApplication(appName);

		if (site == Sites.AIC || site == Sites.USC) {
			Quiz_Options takeQuiz = PageFactory.initElements(driver,
					Quiz_Options.class);
			takeQuiz.takeQuiz(appName);
		}

				
		if(driver.getCurrentUrl().contains("-b")&&site==Sites.AIC)
		{
			
			N400B_EQ1_1 n400_b_eq1_1=PageFactory.initElements(driver, N400B_EQ1_1.class);
			n400_b_eq1_1.citizenshipQualificationCriteria("2");
			
			N400B_EQ3_1 n400_b_eq3_1=PageFactory.initElements(driver, N400B_EQ3_1.class);
			n400_b_eq3_1.servingArmedForce("yes");
			
		}
		else
		{
		
		// EQ Pages
		EQ1_1 eq1_1 = PageFactory.initElements(driver, EQ1_1.class);
		eq1_1.ageAbove18(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 1));
		
		EQ1_2 eq1_2 = PageFactory.initElements(driver, EQ1_2.class);
		eq1_2.livedOutsideUS(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 2));
	
		
		EQ2_1 eq2_1 = PageFactory.initElements(driver, EQ2_1.class);
		eq2_1.permanentResidentHolder(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 3));
		
		
		EQ2_2 eq2_2 = PageFactory.initElements(driver, EQ2_2.class);
		eq2_2.belongToUSNational(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 4));
		
		
		EQ2_3 eq2_3 = PageFactory.initElements(driver, EQ2_3.class);
		eq2_3.marriedToUSCitizen(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 5));
		
		
		EQ3_1 eq3_1 = PageFactory.initElements(driver, EQ3_1.class);
		eq3_1.greencard2Years9Months(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 6));
		
		
		EQ3_2 eq3_2 = PageFactory.initElements(driver, EQ3_2.class);
		eq3_2.specifiedEmploymentEngage(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 7));
		
		
		EQ3_3 eq3_3 = PageFactory.initElements(driver, EQ3_3.class);
		eq3_3.greencard6MonthValid(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 8));
		
		
		EQ3_4 eq3_4 = PageFactory.initElements(driver, EQ3_4.class);
		eq3_4.physicallyPresent18Months(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 9));
		
		
		EQ3_5 eq3_5 = PageFactory.initElements(driver, EQ3_5.class);
		eq3_5.spouseHasBeenUSCitizen(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 10));
		
		
		EQ3_6 eq3_6 = PageFactory.initElements(driver, EQ3_6.class);
		eq3_6.marriedUSCitizen(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 11));
		
		
		EQ4_1 eq4_1 = PageFactory.initElements(driver, EQ4_1.class);
		eq4_1.greencard4Years9Months(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 12));
		
		
		EQ4_2 eq4_2 = PageFactory.initElements(driver, EQ4_2.class);
		eq4_2.greencard6MonthValid(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 13));
		
		
		EQ4_3 eq4_3 = PageFactory.initElements(driver, EQ4_3.class);
		eq4_3.outOfUSThreeYears(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 14));
		
		
		EQ5_1 eq5_1 = PageFactory.initElements(driver, EQ5_1.class);
		eq5_1.sameState3Months(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 15));
		
		
		EQ5_2 eq5_2 = PageFactory.initElements(driver, EQ5_2.class);
		eq5_2.outOfUSThreeYears(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 16));
		
		
		EQ5_3 eq5_3 = PageFactory.initElements(driver, EQ5_3.class);
		eq5_3.outOfUSFiveYears(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 17));
		
		
		EQ5_4 eq5_4 = PageFactory.initElements(driver, EQ5_4.class);
		eq5_4.outOfUSOneYear(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 18));
		
		
		EQ6_1 eq6_1 = PageFactory.initElements(driver, EQ6_1.class);
		eq6_1.userServiceStatus(n400Copies,
				readFromExcelSheet.getCellStringContent(fieldContent, 19));
		
		homepage.takeScreenShot("n400", "EQ_Success");
		readFromExcelSheet.closeWorkbook();
		}
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

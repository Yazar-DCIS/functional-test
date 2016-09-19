package com.formsdirectinc.functionaltests.apps.i129f;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.i129f.pages.EQ1_1;
import com.formsdirectinc.functionaltests.apps.i129f.pages.EQ1_2;
import com.formsdirectinc.functionaltests.apps.i129f.pages.EQ1_3;
import com.formsdirectinc.functionaltests.apps.i129f.pages.EQ1_4;
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
 * @Product I129 EligiblityQuestions
 */
public class EligiblityQuestions extends Step   {

	public EligiblityQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String appName = Products.I129F.name();

	public void test(String product, String flowname)
			throws Exception {

		ReadDataFromExcelSheet readFromExcelSheet = new ReadDataFromExcelSheet();
		String i129Sheet = "I129F";
		readFromExcelSheet.initializeWorkbook(i129Sheet);

		Integer fieldContent = readFromExcelSheet.getRowNumberUsingContent(flowname);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Sites site = Sites.valueOf(System.getProperty("site.name"));
		

		if (site != Sites.FR) {
			driver.get(site.getProductURL());
			SelectElement productName = new SelectElement(driver, "I-129F");
			productName.selectElementUsingPartialLinkText();
		}

		if (site == Sites.FR) 
		{
			driver.get(site.getBaseURL()+"immigration-solutions/fiance-visa-k1/");
		}

		StartApplication start = PageFactory.initElements(driver,
				StartApplication.class);
		start.startApplication(appName);
		
		if (site != Sites.FR) {
		Quiz_Options takeQuiz = PageFactory.initElements(driver,
				Quiz_Options.class);
		takeQuiz.takeQuiz(appName);
		}
		
		// EQ Pages
		String usCitizen=readFromExcelSheet.getCellStringContent(fieldContent, 1);
		EQ1_1 eq1_1 = PageFactory.initElements(driver, EQ1_1.class);
		eq1_1.usCitizen(usCitizen);

		String marryWithIn90Days=readFromExcelSheet.getCellStringContent(fieldContent, 2);
		EQ1_2 eq1_2 = PageFactory.initElements(driver, EQ1_2.class);
		eq1_2.marryWithIn90Days(marryWithIn90Days);

		String freeToMarry=readFromExcelSheet.getCellStringContent(fieldContent, 3);
		EQ1_3 eq1_3 = PageFactory.initElements(driver, EQ1_3.class);
		eq1_3.freeToMarry(freeToMarry);

		String metFiance=readFromExcelSheet.getCellStringContent(fieldContent, 4);
		EQ1_4 eq1_4 = PageFactory.initElements(driver, EQ1_4.class);
		eq1_4.metFiance(metFiance);

		readFromExcelSheet.closeWorkbook();
		
		if(flowname.contains("InEligible"))
		{
			EQ_InEligible stopApp=PageFactory.initElements(driver, EQ_InEligible.class);
			stopApp.ineligibleApplication(appName);
		}
		else
		{
			EQ_Success startApp = PageFactory.initElements(driver, EQ_Success.class);
			startApp.startApplication(appName);
			
		}
	}

}
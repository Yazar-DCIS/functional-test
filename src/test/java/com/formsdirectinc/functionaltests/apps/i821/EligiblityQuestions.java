package com.formsdirectinc.functionaltests.apps.i821;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.i821.pages.EQ1_1;
import com.formsdirectinc.functionaltests.apps.i821.pages.EQ1_2;
import com.formsdirectinc.functionaltests.apps.i821.pages.EQ1_3;
import com.formsdirectinc.functionaltests.apps.i821.pages.EQ1_4;
import com.formsdirectinc.functionaltests.apps.i821.pages.EQ1_5;
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
 * @Product I821 EligiblityQuestions
 */
public class EligiblityQuestions extends Step   {

	
	public EligiblityQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String appName = Products.I821.name();

	public void test(String product, String flowname)
			throws Exception {

		ReadDataFromExcelSheet readFromExcelSheet = new ReadDataFromExcelSheet();
		String i821Sheet = "I821";
		readFromExcelSheet.initializeWorkbook(i821Sheet);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Integer fieldContent = readFromExcelSheet.getRowNumberUsingContent(flowname);
		Sites site = Sites.valueOf(System.getProperty("site.name"));
		driver.get(site.getProductURL());

		SelectElement productName = new SelectElement(driver, "I-821");
		productName.selectElementUsingPartialLinkList(1);

		if (site != Sites.FR) {

			if (site == Sites.USC) {
				// until issue gets fixed
				driver.get("https://www.uscitizenship.info/us-visas/"
						+ "Temporary-Protected-Status-Form-I-821.jsp?lang=en");
			}

			StartApplication startApp = PageFactory.initElements(driver,
					StartApplication.class);
			startApp.startApplication(appName);
		}

		if (site != Sites.FR) {
		Quiz_Options takeQuiz = PageFactory.initElements(driver,
				Quiz_Options.class);
		takeQuiz.takeQuiz(appName);
		}
		
		EQ1_1 eq1_1 = PageFactory.initElements(driver, EQ1_1.class);
		eq1_1.usPresent(readFromExcelSheet.getCellStringContent(
				fieldContent, 1));

		EQ1_2 eq1_2 = PageFactory.initElements(driver, EQ1_2.class);
		eq1_2.tpsCountryCoc(readFromExcelSheet.getCellStringContent(
				fieldContent, 2));

		EQ1_3 eq1_3 = PageFactory.initElements(driver, EQ1_3.class);
		eq1_3.tpsCountryCor(readFromExcelSheet.getCellStringContent(
				fieldContent, 3));

		EQ1_4 eq1_4 = PageFactory.initElements(driver, EQ1_4.class);
		eq1_4.continuousResidence(readFromExcelSheet.getCellStringContent(
				fieldContent, 4));

		EQ1_5 eq1_5 = PageFactory.initElements(driver, EQ1_5.class);
		eq1_5.desiOrRedesiTpsCountry(readFromExcelSheet.getCellStringContent(
				fieldContent, 5));

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
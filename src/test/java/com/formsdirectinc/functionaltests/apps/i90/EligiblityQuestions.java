package com.formsdirectinc.functionaltests.apps.i90;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.i90.pages.EQ1_1;
import com.formsdirectinc.functionaltests.apps.i90.pages.EQ2_1;
import com.formsdirectinc.functionaltests.apps.i90.pages.EQ3_1;
import com.formsdirectinc.functionaltests.apps.i90.pages.EQ3_2;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
import com.formsdirectinc.functionaltests.tags.EQ_InEligible;
import com.formsdirectinc.functionaltests.tags.EQ_Success;
import com.formsdirectinc.functionaltests.tags.ReadDataFromExcelSheet;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.StartApplication;

/**
 * @author Orina
 * @Product I90 EligiblityQuestions
 */
public class EligiblityQuestions extends Step {

	public EligiblityQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String appName = Products.I90.name().toLowerCase();

	public void test(String product, String flowname) throws Exception {

		ReadDataFromExcelSheet readFromExcelSheet = new ReadDataFromExcelSheet();
		String i90Sheet = "I90EQ";
		readFromExcelSheet.initializeWorkbook(i90Sheet);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Integer fieldContent = readFromExcelSheet.getRowNumberUsingContent(flowname);
		Sites site = Sites.valueOf(System.getProperty("site.name"));
		
		if (site == Sites.FRSTAGING) {
			driver.get(site.getBaseURL() + appName.toLowerCase() + "/quiz.do");
		}
		
		else if (site == Sites.FR){
			driver.get(site.getBaseURL()+"immigration-solutions/green-card-renewal/");
		}
		else
		{
			driver.get(site.getProductURL());
			SelectElement productName = new SelectElement(driver, "I-90");
			productName.selectElementUsingPartialLinkText();
		}
		
		StartApplication startApp = PageFactory.initElements(driver,StartApplication.class);
		if (site == Sites.DUS||site == Sites.FR) {
			startApp.startApplication("a","Start");
			}
		else if (site == Sites.ID||site == Sites.USC) {
			startApp.startApplication("span","Start");
		}
		else
		{
			startApp.startApplication("a","START");
		}
		PropertyResource propertyFile = new PropertyResource();
		Properties i90data = propertyFile.loadProperty("i90");

		/*if (site == Sites.AIC) {
			startApp.startApplication("span","Start");
		}*/
		
		// EQ Section :
		EQ1_1 eq1_1 = PageFactory.initElements(driver, EQ1_1.class);
		eq1_1.customerStatus((int)readFromExcelSheet.getCellIntegerContent(fieldContent, 1));
		

		EQ2_1 eq2_1 = PageFactory.initElements(driver, EQ2_1.class);
		eq2_1.dateSelection(i90data,
				readFromExcelSheet.getCellStringContent(fieldContent, 2));
		

		EQ3_1 eq3_1 = PageFactory.initElements(driver, EQ3_1.class);
		eq3_1.reasonForApplication(readFromExcelSheet.getCellStringContent(fieldContent,
				3));
		

		EQ3_2 eq3_2 = PageFactory.initElements(driver, EQ3_2.class);
		eq3_2.prReasonForApplication(readFromExcelSheet.getCellStringContent(
				fieldContent, 4));
		

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

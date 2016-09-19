package com.formsdirectinc.functionaltests.apps.i751;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.i751.pages.EQ1_1;
import com.formsdirectinc.functionaltests.apps.i751.pages.EQ1_2;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.EQ_InEligible;
import com.formsdirectinc.functionaltests.tags.EQ_Success;
import com.formsdirectinc.functionaltests.tags.Quiz_Options;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.StartApplication;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * @Product I751 EligiblityQuestions
 * @author Orina
 */

public class EligiblityQuestions extends Step   {

	
	public EligiblityQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String appName = Products.I751.name();

	public void test(String product, String flowname)
			throws Exception {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Sites site = Sites.valueOf(System.getProperty("site.name"));
		if (site != Sites.FR) {
			driver.get(site.getProductURL());
			SelectElement productName = new SelectElement(driver, "I-751");
			productName.selectElementUsingPartialLinkText();
		}
		
		if (site == Sites.FR) {
			driver.get(site.getBaseURL()+"immigration-solutions/remove-conditions-on-green-card/");
		}
		

		StartApplication startApp = PageFactory.initElements(driver,
				StartApplication.class);
		startApp.startApplication(appName);

		PropertyResource propertyFile=new PropertyResource();
		Properties i751data = propertyFile.loadProperty("name");

		if ((site == Sites.AIC) || (site == Sites.USC)) {
			Quiz_Options takeQuiz = PageFactory.initElements(driver,
					Quiz_Options.class);
			takeQuiz.takeQuiz(appName);
		}

		EQ1_1 eq1_1 = PageFactory.initElements(driver, EQ1_1.class);
		eq1_1.set_conditionalGreenCardHolder();

		EQ1_2 eq2_2 = PageFactory.initElements(driver, EQ1_2.class);
		eq2_2.set_expiryDate(i751data);

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

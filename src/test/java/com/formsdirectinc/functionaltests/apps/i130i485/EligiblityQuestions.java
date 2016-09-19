package com.formsdirectinc.functionaltests.apps.i130i485;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_1;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_2;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_3;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_4;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_4_1;
import com.formsdirectinc.functionaltests.apps.i130.pages.EQ1_4_2;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.EQ_InEligible;
import com.formsdirectinc.functionaltests.tags.EQ_Success;
import com.formsdirectinc.functionaltests.tags.Quiz_Options;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.StartApplication;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * @Product I130-I485 EligiblityQuestions
 * @author Orina
 */

	public class EligiblityQuestions extends Step{

	public EligiblityQuestions(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
	}
		
	String appName = Products.I130I485.name();
	Sites site = Sites.valueOf(System.getProperty("site.name"));

	public void test(String product,String flowname) throws Exception {

		// Flows needs to be drafted
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PropertyResource propertyFile = new PropertyResource();
		
		Sites site = Sites.valueOf(System.getProperty("site.name"));
		if (site != Sites.FR) {
			driver.get(site.getProductURL());
			SelectElement productName = new SelectElement(driver, "I-130");
			productName.selectElementUsingPartialLinkText();
		}
		
		if (site == Sites.FR) {
			driver.get(site.getBaseURL()+"immigration-solutions/green-card-through-family/");
			Reporter.log("Sorry I130-I485 does not have EQ IN FR");
		}
		
		StartApplication start = PageFactory.initElements(driver,
				StartApplication.class);
		start.startApplication(appName);

		if (site != Sites.FR) 
		{
			Quiz_Options takeQuiz = PageFactory.initElements(driver,
					Quiz_Options.class);
			takeQuiz.takeQuiz(appName);
		}	
			Properties i130_i485 = propertyFile.loadProperty(appName);
	
			EQ1_1 eq1_1 = PageFactory.initElements(driver, EQ1_1.class);
			eq1_1.immigrantStatus("USCitizen_SponserSpouse", i130_i485);
	
			EQ1_2 eq1_2 = PageFactory.initElements(driver, EQ1_2.class);
			eq1_2.physicalPresenceAtWedding("yes", i130_i485);
	
			EQ1_3 eq1_3 = PageFactory.initElements(driver, EQ1_3.class);
			eq1_3.applicantCurrentlyLivingInUS("yes", i130_i485);
	
			EQ1_4 eq1_4 = PageFactory.initElements(driver, EQ1_4.class);
			eq1_4.spouseCurrentlyLivingInUS("yes", i130_i485);
	
			EQ1_4_1 eq1_4_1 = PageFactory.initElements(driver, EQ1_4_1.class);
			eq1_4_1.spouseInspectedLastEntryUS("yes", i130_i485);
	
			EQ1_4_2 eq1_4_2 = PageFactory.initElements(driver, EQ1_4_2.class);
			eq1_4_2.spouseLivingUSUnderLegalStatus("yes", i130_i485);
	
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

package com.formsdirectinc.functionaltests.apps.i485multi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.EQ1_1;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.EQ1_10;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.EQ1_2;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.EQ1_3;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.EQ1_9;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.EQ_InEligible;
import com.formsdirectinc.functionaltests.tags.EQ_Success;
import com.formsdirectinc.functionaltests.tags.Quiz_Options;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.StartApplication;

/**
 * @Product I485-Multi EligiblityQuestions
 * @author Orina
 */

public class EligiblityQuestions extends Step   {

	

	public EligiblityQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String appName = Products.I485MULTI.name();

	public void test(String product, String flowname)
			throws Exception {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Sites site = Sites.valueOf(System.getProperty("site.name"));
		SelectElement productName = null;
	
		if (site != Sites.FR) {
			driver.get(site.getProductURL());
			productName = new SelectElement(driver, "I-485");
			productName.selectElementUsingPartialLinkText();
		}
		
		if (site == Sites.FR) {
			driver.get(site.getBaseURL()+"immigration-solutions/apply-for-green-card/");
		}
		
		StartApplication startapp = PageFactory.initElements(driver,
				StartApplication.class);
		startapp.startApplication(appName);

		if (site != Sites.FR) {
		Quiz_Options takeQuiz = PageFactory.initElements(driver,
				Quiz_Options.class);
		takeQuiz.takeQuiz(appName);
		}
		
		EQ1_1 eq1_1 = PageFactory.initElements(driver, EQ1_1.class);
		eq1_1.livingUS("yes");

		EQ1_2 eq1_2 = PageFactory.initElements(driver, EQ1_2.class);
		eq1_2.baseOfApplication("citizenOfCuba");

		EQ1_3 eq1_3 = PageFactory.initElements(driver, EQ1_3.class);
		eq1_3.oneYearLastAdmitted("yes");
		
		EQ1_9 eq1_9 = PageFactory.initElements(driver, EQ1_9.class);
		eq1_9.familyInformation("yes", "yes");
		
		EQ1_10 eq1_10 = PageFactory.initElements(driver, EQ1_10.class);
		eq1_10.spouseOrChildrenApply("yes");
		
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

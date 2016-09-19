package com.formsdirectinc.functionaltests.apps.i485;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.i485.pages.EQ1_1;
import com.formsdirectinc.functionaltests.apps.i485.pages.EQ1_2;
import com.formsdirectinc.functionaltests.apps.i485.pages.EQ1_6;
import com.formsdirectinc.functionaltests.apps.i485.pages.EQ1_6_2;
import com.formsdirectinc.functionaltests.apps.i485.pages.EQ1_7;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.EQ_InEligible;
import com.formsdirectinc.functionaltests.tags.EQ_Success;
import com.formsdirectinc.functionaltests.tags.Quiz_Options;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.StartApplication;

/**
 * @Product I485 EligiblityQuestions
 * @author Orina
 */

public class EligiblityQuestions extends Step   {



	public EligiblityQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String appName = Products.I485.name();

	public void test(String product, String flowname)
			throws Exception {

		// Flows need to be drafted
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Sites site = Sites.valueOf(System.getProperty("site.name"));
		driver.get(site.getProductURL());

		SelectElement productName = null;
		if (site != Sites.FR) {
			productName = new SelectElement(driver, "I-485");
		}

		if (site == Sites.FR) {

			productName = new SelectElement(driver, "Adjustment of Status");
		}
		productName.selectElementUsingPartialLinkText();

		StartApplication startapp = PageFactory.initElements(driver,
				StartApplication.class);
		startapp.startApplication(appName);

		Quiz_Options takeQuiz = PageFactory.initElements(driver,
				Quiz_Options.class);
		takeQuiz.takeQuiz(appName);

		EQ1_1 eq1_1 = PageFactory.initElements(driver, EQ1_1.class);
		eq1_1.livingUS("yes");

		EQ1_2 eq1_2 = PageFactory.initElements(driver, EQ1_2.class);
		eq1_2.baseOfApplication("approvedImmigrantPetition");

		EQ1_6 eq1_6 = PageFactory.initElements(driver, EQ1_6.class);
		eq1_6.inspectedByUS("yes");

		EQ1_6_2 eq1_6_2 = PageFactory.initElements(driver, EQ1_6_2.class);
		eq1_6_2.immediateFamilyRelative("yes");

		EQ1_7 eq1_7 = PageFactory.initElements(driver, EQ1_7.class);
		eq1_7.legallyInUS("yes");

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

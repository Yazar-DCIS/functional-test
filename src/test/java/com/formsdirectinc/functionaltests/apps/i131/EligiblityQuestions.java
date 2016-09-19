package com.formsdirectinc.functionaltests.apps.i131;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.StartApplication;


/**
 * @author Orina
 * @Product I131 EligiblityQuestions
 */
public class EligiblityQuestions extends Step   {



	public EligiblityQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String appName = Products.I131.name();

	public void test(String product, String flowname)
			throws Exception {

		Sites site = Sites.valueOf(System.getProperty("site.name"));

		if (site != Sites.FR) {
			driver.get(site.getProductURL());
			SelectElement productName = new SelectElement(driver, "I-131");
			productName.selectElementUsingPartialLinkText();
		}
		
		if (site == Sites.FR) {
			driver.get(site.getBaseURL()+"travel-document/");
		}
		
		
		StartApplication startApp = PageFactory.initElements(driver,
				StartApplication.class);
		startApp.startApplication(appName);

		Reporter.log("Sorry I131 does not have EQ");
		System.out.println("Sorry I131 does not have EQ");

	}

}

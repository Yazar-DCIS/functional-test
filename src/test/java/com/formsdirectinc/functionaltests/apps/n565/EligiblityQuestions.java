package com.formsdirectinc.functionaltests.apps.n565;

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
 * @Product n565 EligiblityQuestions
 */
public class EligiblityQuestions extends Step   {

	

	public EligiblityQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void test(String product, String flowname)
			throws Exception {

		String appName = Products.N565.name();
		Sites site = Sites.valueOf(System.getProperty("site.name"));
		
		if (site != Sites.FR) {
			driver.get(site.getProductURL());
			SelectElement productName = new SelectElement(driver, "N-565");
			productName.selectElementUsingPartialLinkText();
		}
		
		if (site == Sites.FR) {
			driver.get(site.getBaseURL()+"immigration-solutions/replace-naturalization-certificate/");
		}
		
		StartApplication startApp = PageFactory.initElements(driver,
					StartApplication.class);
		startApp.startApplication(appName);
		
		
		Reporter.log("Sorry N-565 does not have EQ");
		System.out.println("Sorry n565 does not have EQ");

	}

}

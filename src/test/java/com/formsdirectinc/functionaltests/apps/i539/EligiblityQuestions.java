package com.formsdirectinc.functionaltests.apps.i539;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.StartApplication;

/**
 * @Product I539 EligiblityQuestions
 * @author Orina
 */

public class EligiblityQuestions extends Step   {

	
	public EligiblityQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void test(String product, String flowname)
			throws Exception {

		String appName = Products.I539.name();

		Sites site = Sites.valueOf(System.getProperty("site.name"));
		driver.get(site.getProductURL());

		SelectElement productName = new SelectElement(driver, "I-539");
		productName.selectElementUsingPartialLinkText();

		if (site != Sites.FR) {

			if (site == Sites.USC) {
				// until issue gets fixed
				driver.get("https://www.uscitizenship.info/us-visas/I-539-change-or-extend-visa.jsp?lang=en");
			}

			StartApplication startApp = PageFactory.initElements(driver,
					StartApplication.class);
			startApp.startApplication(appName);

		}
		Reporter.log("Sorry I-539 does not have EQ");
		System.out.println("Sorry I539 does not have EQ");
	}

}

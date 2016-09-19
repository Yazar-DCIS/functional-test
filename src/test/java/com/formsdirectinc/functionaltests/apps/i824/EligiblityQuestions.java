	package com.formsdirectinc.functionaltests.apps.i824;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.StartApplication;

/**
 * @Product I824 EligiblityQuestions
 * @author Orina
 */

public class EligiblityQuestions extends Step   {

	

	public EligiblityQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void test(String product, String flowname)
			throws Exception {

		String appName = Products.I824.name();

		Sites site = Sites.valueOf(System.getProperty("site.name"));
		driver.get(site.getProductURL());

		SelectElement productName = new SelectElement(driver, "I-824");
		productName.selectElementUsingPartialLinkText();

		if (site != Sites.FR) {

			StartApplication startApp = PageFactory.initElements(driver,
					StartApplication.class);
			startApp.startApplication(appName);
		}
		Reporter.log("Sorry I-824 does not have EQ");
		System.out.println("Sorry i824 does not have EQ");

	}

}

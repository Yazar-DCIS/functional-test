package com.formsdirectinc.functionaltests.apps.i102;

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
 * @Product I102 EligiblityQuestions
 */
public class EligiblityQuestions extends Step{

	
	
	public EligiblityQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public void test(String product, String flowname) throws Exception{
		String appName = Products.I102.name();

		Sites site = Sites.valueOf(System.getProperty("site.name"));
		driver.get(site.getProductURL());

		SelectElement productName = new SelectElement(driver, "I-102");
		productName.selectElementUsingPartialLinkText();

		if(site!=Sites.FR)
		{
			StartApplication start = PageFactory.initElements(driver,
					StartApplication.class);
			start.startApplication(appName);
		}

		Reporter.log("Sorry I102 does not have EQ");
		System.out.println("Sorry I102 does not have EQ");

	}
	

	

}
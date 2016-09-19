package com.formsdirectinc.functionaltests.tags;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;

/**
 * Skip_Quiz: Selenium Page Object for Skip Quiz
 *
 * @author:Orina <br>
 *               Revision: $Rev$
 */
public class Quiz_Options {

	private WebDriver driver;
	private Sites site;
	private SelectElement takeQuiz, skipQuiz;

	public Quiz_Options(WebDriver driver) {

		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public Quiz_Options takeQuiz(String product) {

		Sites site = Sites.valueOf(System.getProperty("site.name"));

		if(site==Sites.AIC)
		{
			takeQuiz = new SelectElement(driver, "//span[contains(text(),'Start Quiz')]");
			takeQuiz.selectElementUsingXPath();
		}
		
		if((site==Sites.USC)&&(product==Products.I765.name()))
		{
			takeQuiz = new SelectElement(driver, "//span[contains(text(),'Start with the FREE Qualification Quiz')]");
			takeQuiz.selectElementUsingXPath();
		}
		
		/********************************************************************************/

		return this;
	}

	public Quiz_Options skipQuiz() {

		site = Sites.valueOf(System.getProperty("site.name"));
		if ((site == Sites.ID) || (site == Sites.AIC)) {
			skipQuiz = new SelectElement(driver, "span[class='button-text']");
			skipQuiz.selectElementUsingList(1);
		}

		return this;
	}

}

package com.formsdirectinc.qa.tags;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

/**
 * Skip_Quiz: Selenium Page Object for Skip Quiz
 *
 * @author:Orina <br>
 *               Revision: $Rev$
 */
public class Quiz_Options {

	private WebDriver driver;
	private SelectElement takeQuiz;
	private String quizText = "//%s[contains(text(),'%s')]";

	public Quiz_Options(WebDriver driver) {

		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public Quiz_Options selectQuiz(String text) {

		SelectElement takeQuiz = new SelectElement(driver, "a[href='" + text
				+ "']");
		takeQuiz.selectElementUsingCSS();

		return this;
	}

	public Quiz_Options selectQuiz(String tag, String text) {

		takeQuiz = new SelectElement(driver, String.format(quizText, tag, text));
		takeQuiz.selectElementUsingXPath();

		return this;
	}

}

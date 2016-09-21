package com.formsdirectinc.qa.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;

import com.formsdirectinc.qa.enums.Sites;

/**
 * Skip_Quiz: Selenium Page Object to check Page/Element Error(Page Check)
 *
 * @author:Orina <br>
 *               Revision: $Rev$
 */
public class CheckPageErrors {

	private WebDriver driver;
	
	public CheckPageErrors(WebDriver driver) {

		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void checkWhetherPageHasError() {

		if (driver.getCurrentUrl().contains("createaccounts")) {
			if (driver.findElement(By.cssSelector("p[class='page-error']"))
					.isDisplayed()) {
				WebElement pageError = driver.findElement(By
						.cssSelector("p[class='page-error']"));
				if (pageError.getText().contains("account already exists")) {
					Assert.fail(pageError.getText());
				} else {
					List<WebElement> pageElementError = driver.findElements(By
							.cssSelector("p[class='element-error']"));
					int totalErrors = pageElementError.size();
					int i = 0;
					for (i = 0; i <= totalErrors; i++) {
						System.out
								.println("\n" + pageElementError.get(i).getText());
						Reporter.log("\n" + pageElementError.get(i).getText());
					}
					Assert.fail("\n" + pageElementError.get(i).getText() + " : "
							+ pageError.getText());
				}
			}
		}
	}

	public void checkWhetherSQPageHasError(String page) {

		if(driver.getCurrentUrl().endsWith(page))
		{	
			if (driver.findElement(By.cssSelector("span[class='PageError-label']"))
					.isDisplayed()) {
				WebElement pageError = driver.findElement(By
						.cssSelector("span[class='PageError-label']"));
				List<WebElement> pageElementError = driver.findElements(By
						.cssSelector("p[class='AnswerField-errorMessage']"));
				List<WebElement> errorForQuestion = driver.findElements(By
						.cssSelector("div[class='AnswerField set error']"));
	
				int totalErrors = pageElementError.size();
				int i = 0;
				for (i = 0; i <= totalErrors; i++) {
					System.out.println("\n"
							+ errorForQuestion.get(i)
									.findElement(By.tagName("label")).getText()
							+ ":" + pageElementError.get(i).getText());
	
					Reporter.log("\n" + pageElementError.get(i).getText());
				}
				Assert.fail("\n" + pageElementError.get(i).getText() + " : "
						+ pageError.getText());
			}
		}
	}

	public void checkWhetherLoginPageHasError(Sites site) {

		String tag = null;
		if (site.name().contains(Sites.DUS.name())) {
			tag = "div";
		} else {
			tag = "p";
		}
		if (driver.getCurrentUrl().contains("login")) {
			if (driver.findElement(
					By.xpath("//" + tag + "[contains(@class,'error')]"))
					.isDisplayed()) {
				WebElement pageError = driver.findElement(By.xpath("//" + tag
						+ "[contains(@class,'error')]"));

				System.out.println("\n" + pageError.getText());

				Reporter.log("\n" + pageError.getText());

				Assert.fail("\n" + pageError.getText());
			}

		}

	}
}

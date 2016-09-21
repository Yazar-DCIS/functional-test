package com.formsdirectinc.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.formsdirectinc.qa.enums.Sites;
import com.formsdirectinc.qa.utils.CaptureScreen;

/**
 * Wizard Page for Navigations
 * 
 * @author Orina
 *
 */
public class WizardPage {

	protected WebDriver driver;
	protected Sites site;

	@FindBy(how = How.CSS, using = "input[name=\"page\"]")
	protected WebElement pageNameInput;

	@FindBy(how = How.CLASS_NAME, using = "page-header")
	protected WebElement pageHeader;

	public WizardPage(WebDriver driver) {
		this.driver = driver;
		}

	public String pageID() {

		WebElement pageNameInput = driver.findElement(By
				.cssSelector("input[name='page']"));
		String pageNameText = pageNameInput.getAttribute("value");
		return pageNameText.substring(pageNameText.lastIndexOf("/") + 1,
				pageNameText.lastIndexOf("."));
	}

	public String pageHeader() {
		return pageHeader.getText();
	}

	public WizardPage gotoNextPage(String tag, String name) {

		WebElement nextPage = driver.findElement(By.xpath("//" + tag
				+ "[contains(text(),'" + name + "')]"));
		nextPage.click();
		return this;
	}

	public String pageQuestions() {

		String pageQuestionLabel = driver.findElement(
				By.cssSelector("div[class='Questions']")).getText();
		return pageQuestionLabel;
	}

	public void saveScreenShot(String appName, String page) {
		CaptureScreen snapShot = new CaptureScreen(driver);
		snapShot.takeScreenShot(appName, page);
	}

}

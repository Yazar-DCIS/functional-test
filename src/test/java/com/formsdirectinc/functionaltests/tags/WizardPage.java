package com.formsdirectinc.functionaltests.tags;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Wizard: Base class for all wizard pages
 * Author: <a href="mailto:hari@dcis.net">Hari Selvarajan</a> Date: 6/21/15
 * 11:48 AM
 * @author Orina
 * Revision: $Rev$
 */
public class WizardPage {
	@FindBy(how = How.CSS, using = "input[name=\"page\"]")
	protected WebElement pageNameInput;

	@FindBy(how = How.CLASS_NAME, using = "page-header")
	protected WebElement pageHeader;

	protected WebDriver driver;

	protected String pageID;

	public WizardPage(WebDriver driver) {
		this.driver = driver;
	}
	

	public String pageID() {
		String pageNameText = pageNameInput.getAttribute("value");
		return pageNameText.substring(pageNameText.lastIndexOf("/") + 1,
				pageNameText.lastIndexOf("."));
	}

	public void saveScreenShot(String appName, String page)
	{
		CaptureScreen snapShot=new CaptureScreen(driver);
		snapShot.takeScreenShot(appName, page);
	}
	
	public String pageHeader() {
		return pageHeader.getText();
	}

	public WizardPage clickContinueInSQ() {
		//
		// TODO: currently to ALL SQ
		//
		SelectElement continueButton = new SelectElement(driver,
				"//a[contains(text(),'Continue')]");
		continueButton.selectElementUsingXPath();

		return PageFactory.initElements(driver, WizardPage.class);
	}

	public WizardPage clickContinueInSQFR() {
		//
		// TODO: currently to ALL SQ
		//
		SelectElement continueButton = new SelectElement(driver,
				"//button[contains(text(),'Next')]");
		continueButton.selectElementUsingXPath();

		return PageFactory.initElements(driver, WizardPage.class);
	}
	
	public WizardPage clickBackInSQ() {
		//
		// TODO: currently to ALL SQ
		//
		SelectElement continueButton = new SelectElement(driver,
				"//a[contains(text(),'Back')]");
		continueButton.selectElementUsingXPath();

		return PageFactory.initElements(driver, WizardPage.class);
	}
	
	public WizardPage clickContinueInEQ() {
		//
		// TODO: currently to ALL EQ
		//
		SelectElement continueButton = new SelectElement(driver,
				"span[class='button-text']");
		continueButton.selectElementUsingCSS();

		return PageFactory.initElements(driver, WizardPage.class);
	}

	public WizardPage clickContinueInEQFR() {
		//
		// TODO: currently to ALL EQ
		//
		SelectElement continueButton = new SelectElement(driver,
				"//div[contains(text(),'Continue')]");
		continueButton.selectElementUsingXPath();

		return PageFactory.initElements(driver, WizardPage.class);
	}
	
	public List<WebElement> sections() {
		return driver
				.findElements(By.xpath("//*[starts-with(@id, 'section-']"));
	}

	public WebElement section(int index) {
		return driver.findElement(By.xpath("//*[@id='section-" + pageID + "."
				+ Integer.toString(index)));
	}

	public String sectionHeader(int index) {
		WebElement section = section(index);
		return section.findElement(
				By.xpath("fieldSet/p[@class='sectionHeader']")).getText();
	}
	
	
	

}

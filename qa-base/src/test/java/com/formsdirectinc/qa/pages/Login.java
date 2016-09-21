package com.formsdirectinc.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.formsdirectinc.qa.enums.Sites;
import com.formsdirectinc.qa.tags.BaseTag;
import com.formsdirectinc.qa.tags.SelectElement;

/**
 * Sign UP: Selenium page Model for Register And Payment Controls
 * 
 * @author Orina
 * @Date: 04/03/2016
 */
public class Login extends BaseTag {

	String signInExpressionLink = "//a[contains(text(),'Sign')]";
	String signInExpressionSpan = "//span[contains(text(),'Sign')]";
	String signInExpressionButton = "//button[contains(text(),'Sign')]";
	String signInURL = "logincheck.do?next=applicationcenter.do";

	String emailFieldExpression = "loginEmail";
	String passwordFieldExpression = "loginPassword";

	String loginMessage = "Login results of %s";
	String InvalidloginMessage = "The user '%s' is invalid in '%s'";
	String ValidloginMessage = "The user '%s' is valid in '%s'";

	String createFieldExpressionCore = "Createbutton";

	WebElement valuefield;
	SelectElement clickOnElement;

	public Login(WebDriver driver, String property) {
		super(driver, property);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public Login(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public Login selectSignIn() {

		if (site.name().contains(Sites.DUS.name())) {
			// Since for DUS Element Not Visible Exception is thrown
			driver.get(siteURL() + signInURL);
		}

		else {
			if (site.name().contains(Sites.FR.name())) {
				clickOnElement = new SelectElement(driver,
						String.format(signInExpressionSpan));
			} else {
				clickOnElement = new SelectElement(driver,
						String.format(signInExpressionLink));
			}
			clickOnElement.selectElementUsingXPath();
		}

		return this;
	}

	private String siteURL() {
		// TODO Auto-generated method stub
		return System.getProperty("site.url");
	}

	public String setUserID(String userID) {

		valuefield = driver.findElement(By.id(String
				.format(emailFieldExpression)));
		valuefield.sendKeys(userID);

		return userID;
	}

	public String setUserPassword(String userPassword) {

		valuefield = driver.findElement(By.id(String
				.format(passwordFieldExpression)));
		valuefield.sendKeys(userPassword);

		return userPassword;
	}

	public Login logIntoApplication(String userID,Sites site) {

		
		
		if (site.name().contains(Sites.DUS.name())) {
			valuefield = driver.findElement(By.xpath(String
					.format(signInExpressionButton)));
		} else {
			valuefield = driver.findElement(By.xpath(String
					.format(signInExpressionSpan)));
		}
		valuefield.click();

		if (driver.getCurrentUrl().contains("login")) {
			Reporter.log(String.format(InvalidloginMessage, userID, site));
		} else {
			Reporter.log(String.format(ValidloginMessage, userID, site));
		}

		return this;
	}

	public void login(String username, String password,Sites site) {
		setUserID(username);
		setUserPassword(password);
		logIntoApplication(username,site);
	}

}

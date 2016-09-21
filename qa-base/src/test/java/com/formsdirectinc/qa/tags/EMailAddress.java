package com.formsdirectinc.qa.tags;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * EMailAddress: Selenium page model for E-Mail tag
 * 
 * @author:Orina <br>
 *               Revision: $Rev$
 */
public class EMailAddress extends BaseTag {

	protected String emailAddressExpression = "%s.emailAddress";
	protected WebElement emailAddressTextField;
	protected String intrepreterEmailAddressExpression = "%s.emailAddressOfInterpreter";
	protected String businessEmailAddressExpression = "%s.businessEmailAddress";
	protected String emailExpression = "%s.email";
	protected String spouseEmailExpression = "%s.spouseEmail";
	protected String spouseAbroadEmailExpression = "%s.spouseAbroadEmail";
	protected String intrepreterEmailExpression = "%s.interpretersEmail";
	protected String preparerEmailExpression = "%s.emailAddressOfPreparer";
	protected WebElement emailTextField;

	public EMailAddress(WebDriver driver, String property) {
		super(driver, property);

	}

	public EMailAddress setEMailAddress(String email) {
		emailAddressTextField = driver.findElement(By.id(String.format(
				emailAddressExpression, property)));
		emailAddressTextField.clear();
		emailAddressTextField.sendKeys(email);
		return this;
	}

	public EMailAddress setEMail(String email) {
		emailTextField = driver.findElement(By.id(String.format(
				emailExpression, property)));
		emailTextField.clear();
		emailTextField.sendKeys(email);
		return this;
	}

	public EMailAddress setSpouseEMail(String email) {
		emailTextField = driver.findElement(By.id(String.format(
				spouseEmailExpression, property)));
		emailTextField.clear();
		emailTextField.sendKeys(email);
		return this;
	}

	public EMailAddress setSpouseAbroadEMail(String email) {
		emailTextField = driver.findElement(By.id(String.format(
				spouseAbroadEmailExpression, property)));
		emailTextField.clear();
		emailTextField.sendKeys(email);
		return this;
	}

	public EMailAddress setInterpretersEmail(String email) {
		emailTextField = driver.findElement(By.id(String.format(
				intrepreterEmailExpression, property)));
		emailTextField.clear();
		emailTextField.sendKeys(email);
		return this;
	}

	public EMailAddress setPreparerEmail(String email) {
		emailTextField = driver.findElement(By.id(String.format(
				preparerEmailExpression, property)));
		emailTextField.clear();
		emailTextField.sendKeys(email);
		return this;
	}

	public EMailAddress setBusinessEmail(String email) {
		emailTextField = driver.findElement(By.id(String.format(
				businessEmailAddressExpression, property)));
		emailTextField.clear();
		emailTextField.sendKeys(email);
		return this;
	}

	public EMailAddress setInterpretersEmailAddress(String email) {
		emailTextField = driver.findElement(By.id(String.format(
				intrepreterEmailAddressExpression, property)));
		emailTextField.clear();
		emailTextField.sendKeys(email);
		return this;
	}

}

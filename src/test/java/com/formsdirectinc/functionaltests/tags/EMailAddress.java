package com.formsdirectinc.functionaltests.tags;

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

	protected String emailExpression = "%s.email";
	protected WebElement emailTextField;

	public EMailAddress(WebDriver driver, String property) {
		super(driver, property);

	}

	public EMailAddress setEMailAddress(String email) {
		emailAddressTextField = driver.findElement(By.id(String.format(
				emailAddressExpression, property)));
		emailAddressTextField.sendKeys(email);
		return this;
	}

	public EMailAddress setEMail(String email) {
		emailTextField = driver.findElement(By.id(String.format(
				emailExpression, property)));
		emailTextField.sendKeys(email);
		return this;
	}

}

package com.formsdirectinc.functionaltests.tags;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * PhoneNumber: Selenium page model for Phone Number
 * 
 * @author:Orina <br>
 *               Revision: $Rev$
 */
public class PhoneNumber extends BaseTag {

	protected String dayPhoneExpression = "%s.dayPhone";
	protected String mobilePhoneExpression = "%s.phone1";
	protected String workPhoneExpression = "%s.workPhoneNo";
	protected String evePhoneExpression = "%s.eveningPhone";
	protected String cellPhoneExpression = "%s.cellPhoneNo";
	protected String phoneCountryMenuExpression = "%s.country.countrymenu";
	protected String phone1145 = "%s.phone1145";
	protected String workPhoneExpressionOld = "%s.workPhone";

	protected String phoneCodeExpression = "-phone1";
	protected String phoneNumberExpression = "-phone2";
	protected String otherPhoneNumberExpression = "-phone3";

	protected String phoneAreaCodeFieldExpression = "%s-areaCode";
	protected String phoneCodeOldExpression = "%s-phone1";
	protected String phoneNumberOldExpression = "%s-phone2";
	protected String otherNumberOldExpression = "%s-phone3";

	protected WebElement phoneCodeTextField;
	protected WebElement phoneNumberTextField;
	protected WebElement addnPhoneNumberTextField;
	protected WebElement phoneCountryMenuField;

	public PhoneNumber(WebDriver driver, String property) {
		super(driver, property);

	}
	
	public PhoneNumber(WebDriver driver, String beanName, String property) {
		super(driver, beanName,property);

	}

	public PhoneNumber setPhoneCode(String code) {
		phoneCodeTextField = driver.findElement(By.id(String.format(
				phoneCodeOldExpression, property)));
		phoneCodeTextField.sendKeys(code);
		return this;
	}

	public PhoneNumber setAreaCode(String code) {
		phoneCodeTextField = driver.findElement(By.id(String.format(
				phoneAreaCodeFieldExpression, property)));
		phoneCodeTextField.sendKeys(code);
		return this;
	}
	
	public PhoneNumber setPhoneNumber(String number) {
		phoneNumberTextField = driver.findElement(By.id(String.format(
				phoneNumberOldExpression, property)));
		phoneNumberTextField.sendKeys(number);
		return this;
	}

	public PhoneNumber setDayTimeNumber(String code, String number) {
		phoneCodeTextField = driver.findElement(By.id(String.format(
				dayPhoneExpression + phoneCodeExpression, property)));
		phoneNumberTextField = driver.findElement(By.id(String.format(
				dayPhoneExpression + phoneNumberExpression, property)));
		phoneCodeTextField.sendKeys(code);
		phoneNumberTextField.sendKeys(number);
		return this;
	}

	public PhoneNumber setPhone1145Number(String code, String number) {
		phoneCodeTextField = driver.findElement(By.id(String.format(phone1145
				+ phoneCodeExpression, property)));
		phoneNumberTextField = driver.findElement(By.id(String.format(phone1145
				+ phoneNumberExpression, property)));
		phoneCodeTextField.sendKeys(code);
		phoneNumberTextField.sendKeys(number);
		return this;
	}

	public PhoneNumber setMobileNumber(String code, String number) {
		phoneCodeTextField = driver.findElement(By.id(String.format(
				mobilePhoneExpression + phoneCodeExpression, property)));
		phoneNumberTextField = driver.findElement(By.id(String.format(
				mobilePhoneExpression + phoneNumberExpression, property)));
		phoneCodeTextField.sendKeys(code);
		phoneNumberTextField.sendKeys(number);
		return this;
	}

	public PhoneNumber setEveningTimeNumber(String code, String number) {
		phoneCodeTextField = driver.findElement(By.id(String.format(
				evePhoneExpression + phoneCodeExpression, property)));
		phoneNumberTextField = driver.findElement(By.id(String.format(
				evePhoneExpression + phoneNumberExpression, property)));
		phoneCodeTextField.sendKeys(code);
		phoneNumberTextField.sendKeys(number);
		return this;
	}

	public PhoneNumber setCellPhoneNumber(String code, String number) {
		phoneCodeTextField = driver.findElement(By.id(String.format(
				cellPhoneExpression + phoneCodeExpression, property)));
		phoneNumberTextField = driver.findElement(By.id(String.format(
				cellPhoneExpression + phoneNumberExpression, property)));
		phoneCodeTextField.sendKeys(code);
		phoneNumberTextField.sendKeys(number);
		return this;
	}

	public PhoneNumber setWorkPhoneNumber(String code, String number) {
		phoneCodeTextField = driver.findElement(By.id(String.format(
				workPhoneExpression + phoneCodeExpression, property)));
		phoneNumberTextField = driver.findElement(By.id(String.format(
				workPhoneExpression + phoneNumberExpression, property)));
		phoneCodeTextField.sendKeys(code);
		phoneNumberTextField.sendKeys(number);
		return this;
	}

	public PhoneNumber setOldWorkPhoneNumber(String code, String number) {
		phoneCodeTextField = driver.findElement(By.id(String.format(
				workPhoneExpressionOld + phoneCodeExpression, property)));
		phoneNumberTextField = driver.findElement(By.id(String.format(
				workPhoneExpressionOld + phoneNumberExpression, property)));
		phoneCodeTextField.sendKeys(code);
		phoneNumberTextField.sendKeys(number);
		return this;
	}

	public PhoneNumber otherCountryPhoneNumber(String code, String number,
			String time, String country) {

		setPhoneCountryOptions(country);

		if (time.equalsIgnoreCase("day")) {

			addnPhoneNumberTextField = driver.findElement(By.id(String.format(
					dayPhoneExpression + phoneCountryMenuExpression
							+ otherPhoneNumberExpression, property)));

		}

		if (time.equalsIgnoreCase("eve")) {
			addnPhoneNumberTextField = driver.findElement(By.id(String.format(
					evePhoneExpression + phoneCountryMenuExpression
							+ otherPhoneNumberExpression, property)));
		}

		if (time.equalsIgnoreCase("cell")) {
			addnPhoneNumberTextField = driver.findElement(By.id(String.format(
					cellPhoneExpression + phoneCountryMenuExpression
							+ otherPhoneNumberExpression, property)));
		}

		if (time.equalsIgnoreCase("work")) {
			addnPhoneNumberTextField = driver.findElement(By.id(String.format(
					workPhoneExpression + phoneCountryMenuExpression
							+ otherPhoneNumberExpression, property)));
		}
		addnPhoneNumberTextField.clear();
		addnPhoneNumberTextField.sendKeys(code + number);

		return this;
	}

	public PhoneNumber setPhoneCountryOptions(String countryOptions) {
		phoneCountryMenuField = driver.findElement(By.id(String.format(
				phoneCountryMenuExpression, property)));
		Select countryMenuSelect = new Select(phoneCountryMenuField);
		countryMenuSelect.selectByValue(countryOptions);
		return this;
	}

	public PhoneNumber setAddnPhoneNumber(String number) {
		addnPhoneNumberTextField = driver.findElement(By.id(String.format(otherNumberOldExpression, beanName+"-"+property)));
		addnPhoneNumberTextField.clear();
		addnPhoneNumberTextField.sendKeys(number);
		return this;
	}
}

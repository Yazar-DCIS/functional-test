package com.formsdirectinc.functionaltests.tags;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * SocialSecurityNumber, Alien Registration Number,Arrival Departure Number
 * 
 * @author:Orina <br>
 *               Revision: $Rev$
 */
public class Numbers extends BaseTag {

	protected String firstSSNExpression = "%s-ssn1";
	protected String secondSSNExpression = "%s-ssn2";
	protected String thirdSSNExpression = "%s-ssn3";

	protected String ssn1Expression = "%s.ssn1";
	protected String ssn2Expression = "%s.ssn2";
	protected String ssn3Expression = "%s.ssn3";

	protected String numberUnknownExpression = "%s.unknown";
	protected String arnExpression = "%s.arn";
	protected String ARNExpression = "%s.ARN";
	protected String elisNumberExpression = "%s.elisAccountNumber";
	protected String elisUSCISNumberExpression = "%s.uscisElisAccountNumber";

	protected String i94Expression1 = "%s.adn1";
	protected String i94Expression2 = "%s.adn2";
	protected String visaNumberExpression="%s.visaNumber";

	protected WebElement firstSSNField;
	protected WebElement secondSSNField;
	protected WebElement thirdSSNField;
	protected WebElement arnField;
	protected WebElement elisNumberField;
	protected WebElement visaNumberField;
	protected WebElement arrivalRecordField;

	public Numbers(WebDriver driver, String property) {
		super(driver, property);

	}

	public Numbers setSocialSecurityNumber(String ssn1, String ssn2, String ssn3) {
		firstSSNField = driver.findElement(By.id(String.format(
				firstSSNExpression, property)));
		firstSSNField.sendKeys(ssn1);

		secondSSNField = driver.findElement(By.id(String.format(
				secondSSNExpression, property)));
		secondSSNField.sendKeys(ssn2);

		thirdSSNField = driver.findElement(By.id(String.format(
				thirdSSNExpression, property)));
		thirdSSNField.sendKeys(ssn3);

		return this;
	}

	public Numbers setSocialSecurityNumberI90(String ssn1, String ssn2,
			String ssn3) {
		firstSSNField = driver.findElement(By.id(String.format(ssn1Expression,
				property)));
		firstSSNField.sendKeys(ssn1);

		secondSSNField = driver.findElement(By.id(String.format(ssn2Expression,
				property)));
		secondSSNField.sendKeys(ssn2);

		thirdSSNField = driver.findElement(By.id(String.format(ssn3Expression,
				property)));
		thirdSSNField.sendKeys(ssn3);

		return this;
	}

	public Numbers setAlienRegistrationNumber(String arn) {
		arnField = driver.findElement(By.id(String.format(arnExpression,
				property)));
		arnField.sendKeys(arn);
		return this;
	}
	
	public Numbers setNumberUnknown() {
		arnField = driver.findElement(By.id(String.format(numberUnknownExpression,
				property)));
		arnField.click();
		return this;
	}

	public Numbers setElisAccountNumber(String elisNumber) {
		elisNumberField = driver.findElement(By.id(String.format(
				elisNumberExpression, property)));
		elisNumberField.sendKeys(elisNumber);
		return this;
	}
	public Numbers setUSCISElisAccountNumber(String elisNumber) {
		elisNumberField = driver.findElement(By.id(String.format(
				elisUSCISNumberExpression, property)));
		elisNumberField.sendKeys(elisNumber);
		return this;
	}
	public Numbers setAlienRegistrationNumberInCaps(String arn) {
		arnField = driver.findElement(By.id(String.format(ARNExpression,
				property)));
		arnField.sendKeys(arn);
		return this;
	}
	public Numbers setVisaNumber(String visaNumber) {
		arnField = driver.findElement(By.id(String.format(visaNumberExpression,
				property)));
		arnField.sendKeys(visaNumber);
		return this;
	}
	public Numbers setArrivalRecordNumber(String arrivalNumber1,
			String arrivalNumber2) {

		arrivalRecordField = driver.findElement(By.name(String.format(
				i94Expression1, property)));
		arrivalRecordField.sendKeys(arrivalNumber1);

		arrivalRecordField = driver.findElement(By.name(String.format(
				i94Expression2, property)));
		arrivalRecordField.sendKeys(arrivalNumber2);

		return this;
	}

}

package com.formsdirectinc.functionaltests.tags;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * CountryTag: Selenium page Model for Country tag
 * 
 * @author:Orina <br>
 *               Revision: $Rev$
 */

public class Country extends BaseTag {

	protected String countryFieldExpression = "%s-country";
	protected String countryExpression = "%s.country-country";
	protected String countryOfBirthExpression = "%s.countryOfBirth-country";
	protected String passportCountryExpression = "%s.passportCountry-country";
	protected String travelCountryExpression = "%s.travelCountry-country";
	protected String countryOfCitizenshipExpression="%s.countryOfCitizenship-country";
	protected String nationalityExpression="%s.nationality";
	
	protected WebElement countryField;

	public Country(WebDriver driver, String property) {
		super(driver, property);

	}

	public Country setCountryDDM(String country) {
		countryField = driver.findElement(By.id(String.format(
				countryFieldExpression, property)));
		Select countrySelect = new Select(countryField);
		countrySelect.selectByValue(country);
		return this;
	}

	public Country setCountry(String country) {
		countryField = driver.findElement(By.id(String.format(
				countryExpression, property)));
		Select countrySelect = new Select(countryField);
		countrySelect.selectByValue(country);
		return this;
	}

	public Country setPassportCountry(String country) {
		countryField = driver.findElement(By.id(String.format(
				passportCountryExpression, property)));
		Select countrySelect = new Select(countryField);
		countrySelect.selectByValue(country);
		return this;
	}

	public Country setTravelCountry(String country) {
		countryField = driver.findElement(By.id(String.format(
				travelCountryExpression, property)));
		Select countrySelect = new Select(countryField);
		countrySelect.selectByValue(country);
		return this;
	}

	public Country setBirthCountry(String country) {
		countryField = driver.findElement(By.id(String.format(
				countryOfBirthExpression, property)));
		countryField.sendKeys(country);

		return this;
	}
	public Country setCitizenshipCountry(String country) {
		countryField = driver.findElement(By.id(String.format(
				countryOfCitizenshipExpression, property)));
		countryField.sendKeys(country);

		return this;
	}
	public Country setNationality(String nationality) {
		countryField = driver.findElement(By.id(String.format(
				nationalityExpression, property)));
		countryField.sendKeys(nationality);

		return this;
	}
}

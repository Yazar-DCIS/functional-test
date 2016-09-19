package com.formsdirectinc.functionaltests.tags;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * Address_Tag: Selenium page model for Address_Tag Address Details
 * 
 * @author:Orina<br> Revision: $Rev$
 */
public class Address extends BaseTag {

	protected String streetExpression = "%s-street";
	protected String streetNameExpression = "%s-streetName";
	protected String stateTextExpression = "%s.state-statetext";
	protected String addressLine1Expression = "%s.addressLine1";
	protected String countyExpression = "%s-county";

	protected String secondaryUnitType="%s-secondaryUnitType";
	protected String secondaryUnitNumber="%s-secondaryUnitNumber";
	protected String aptNumExpression = "%s-apartmentNum";
	protected String cityExpression = "%s-city";
	protected String cityEnteredExpression = "%s.cityEntered";
	protected String cityNameExpression = "%s.city";
	protected String cityOfBirthExpression = "%s.cityOfBirth";
	protected String stateOfBirthExpression = "%s.stateOfBirth";
	protected String countryOfBirthExpression = "%s.countryOfBirth-country";
	
	protected String stateNameExpression = "%s.state";
	protected String randomState = "%s-state";
	protected String stateExpression = "%s.state-state";
	protected String zipcodeExpression = "%s-zipCode";
	protected String zipcodeNameExpression = "%s.zip";
	protected String countryExpression = "%s-country";
	protected String countryNameExpression = "%s.country";
	protected String countryFieldExpression = "%s.country-country";
	protected String careOfExpression = "%s-careof";

	protected String stateExp = "%s-state";
	protected String placeOfEntryCity = "%s.cityOfLastEntry";
	protected String placeOfEntryState = "%s.stateOfLastEntry-state";
	protected String placeOfEntryManner = "%s.mannerOfLastEntry";

	protected WebElement streetTextField;

	protected WebElement countyTextField;

	protected WebElement streetNameTextField;
	protected WebElement aptNumTextField;
	protected WebElement cityTextField;
	protected WebElement cityVisaField;
	protected WebElement cityOfBirthField;
	protected WebElement cityEnteredField;
	protected WebElement stateTextBoxField;
	protected WebElement stateTextField;
	protected WebElement zipcodeTextField;
	protected WebElement countryTextField;
	protected WebElement careOfTextField;
	protected WebElement stateOfBirthField;
	protected WebElement countryDropDownField;

	public Address(WebDriver driver, String property) {
		super(driver, property);

	}
	
	public Address(WebDriver driver) {
		super(driver);

	}
	
	PropertyResource propertyFile=new PropertyResource();
	
	public Address setStreet(String street) {
		streetTextField = driver.findElement(By.id(String.format(
				streetExpression, property)));
		streetTextField.clear();
		streetTextField.sendKeys(street);
		return this;
	}

	public Address setCounty(String county) {
		countyTextField = driver.findElement(By.id(String.format(
				countyExpression, property)));
		countyTextField.sendKeys(county);
		return this;
	}

	public Address setCountryOffBirth(String country) {
		countryTextField = driver.findElement(By.id(String.format(
				countryOfBirthExpression, property)));
		Select countrySelect = new Select(countryTextField);
		countrySelect.selectByValue(country);
		
		
		return this;
	}
	
	public Address setStreetName(String street) {
		streetNameTextField = driver.findElement(By.id(String.format(
				streetNameExpression, property)));
		streetNameTextField.clear();
		streetNameTextField.sendKeys(street);
		return this;
	}

	public Address setAptNum(String aptNum) {
		aptNumTextField = driver.findElement(By.id(String.format(
				aptNumExpression, property)));
		aptNumTextField.clear();
		aptNumTextField.sendKeys(aptNum);
		return this;
	}

	public Address setApartmentTypeAndNumber(String aptName,String aptNum) {
		aptNumTextField = driver.findElement(By.id(String.format(
				secondaryUnitType, property)));
		aptNumTextField.sendKeys(aptName);
		aptNumTextField = driver.findElement(By.id(String.format(
				secondaryUnitNumber, property)));
		aptNumTextField.sendKeys(aptNum);
		
		return this;
	}
	
	public Address setCity(String city) {
		cityTextField = driver.findElement(By.id(String.format(cityExpression,
				property)));
		cityTextField.clear();
		cityTextField.sendKeys(city);
		return this;
	}

	public Address setCityOfBirth(String city) {
		cityOfBirthField = driver.findElement(By.id(String.format(
				cityOfBirthExpression, property)));
		cityOfBirthField.clear();
		cityOfBirthField.sendKeys(city);
		return this;
	}

	public Address setStateOfBirth(String state) {
		stateOfBirthField = driver.findElement(By.id(String.format(
				stateOfBirthExpression, property)));
		stateOfBirthField.clear();
		stateOfBirthField.sendKeys(state);
		return this;
	}
	
	public Address setCityEntered(String city) {
		cityEnteredField = driver.findElement(By.id(String.format(
				cityEnteredExpression, property)));
		cityEnteredField.clear();
		cityEnteredField.sendKeys(city);
		return this;
	}

	public Address setVisaCity(String city) {
		cityVisaField = driver.findElement(By.id(String.format(
				cityNameExpression, property)));
		cityVisaField.clear();
		cityVisaField.sendKeys(city);
		return this;
	}

	public Address setState(String state) {
		stateTextField = driver.findElement(By.id(String.format(
				stateExpression, property)));
		Select stateSelect = new Select(stateTextField);
		stateSelect.selectByValue(state);
		return this;
	}

	public Address setStateText(String state) {
		stateTextBoxField = driver.findElement(By.id(String.format(
				stateTextExpression, property)));
		stateTextBoxField.clear();
		stateTextBoxField.sendKeys(state);
		return this;
	}

	public Address setRandomState(String state) {
		stateTextBoxField = driver.findElement(By.id(String.format(
				randomState, property)));
		stateTextBoxField.clear();
		stateTextBoxField.sendKeys(state);
		return this;
	}
	
	public Address setZipcode(String zipcode) {
		zipcodeTextField = driver.findElement(By.id(String.format(
				zipcodeExpression, property)));
		zipcodeTextField.clear();
		zipcodeTextField.sendKeys(zipcode);
		return this;
	}

	public Address setCountry(String country) {
		countryTextField = driver.findElement(By.id(String.format(
				countryExpression, property)));
		countryTextField.sendKeys(country);
		return this;
	}

	public Address setCountryDropDown(String country) {
		countryDropDownField = driver.findElement(By.id(String.format(
				countryExpression, property)));
		Select countryDropDownSelect = new Select(countryDropDownField);
		countryDropDownSelect.selectByValue(country);
		return this;

	}

	public Address setBirthState(String state) {
		stateTextField = driver.findElement(By.id(String.format(stateExp,
				property)));
		stateTextField.sendKeys(state);
		return this;
	}

	public Address setAddressLineName(String street) {
		streetNameTextField = driver.findElement(By.name(String.format(
				addressLine1Expression, property)));
		streetNameTextField.clear();
		streetNameTextField.sendKeys(street);
		return this;
	}
	
	public Address setStateName(String state) {
		stateTextField = driver.findElement(By.name(String.format(
				stateNameExpression, property)));
		Select stateSelect = new Select(stateTextField);
		stateSelect.selectByValue(state);
		return this;
	}
	
	public Address setCityName(String city) {
		cityTextField = driver.findElement(By.name(String.format(cityNameExpression,
				property)));
		cityTextField.clear();
		cityTextField.sendKeys(city);
		return this;
	}
	
	public Address setCityField(String city) {
		cityTextField = driver.findElement(By.id(String.format(cityNameExpression,
				property)));
		cityTextField.clear();
		cityTextField.sendKeys(city);
		return this;
	}
	
	public Address setCountryField(String country) {
		countryDropDownField = driver.findElement(By.id(String.format(
				countryFieldExpression, property)));
		Select countryDropDownSelect = new Select(countryDropDownField);
		countryDropDownSelect.selectByValue(country);
		return this;

	}
	
	public Address setCountryName(String country) {
		countryDropDownField = driver.findElement(By.name(String.format(
				countryNameExpression, property)));
		Select countryDropDownSelect = new Select(countryDropDownField);
		countryDropDownSelect.selectByValue(country);
		return this;

	}
	
	public Address setZipcodeValue(String zipcode) {
		zipcodeTextField = driver.findElement(By.name(String.format(
				zipcodeNameExpression, property)));
		zipcodeTextField.clear();
		zipcodeTextField.sendKeys(zipcode);
		return this;
	}
	
	public Address setCityPlaceOfEntry(String city) {
		cityTextField = driver.findElement(By.id(String.format(
				placeOfEntryCity, property)));
		cityTextField.clear();
		cityTextField.sendKeys(city);
		return this;
	}

	public Address setStatePlaceOfEntry(String state) {
		stateTextField = driver.findElement(By.id(String.format(
				placeOfEntryState, property)));
		Select stateSelect = new Select(stateTextField);
		stateSelect.selectByValue(state);
		return this;
	}

	public Address setMannerPlaceOfEntry(String manner) {
		stateTextField = driver.findElement(By.id(String.format(
				placeOfEntryManner, property)));
		Select stateSelect = new Select(stateTextField);
		stateSelect.selectByValue(manner);
		return this;
	}
	
	public Address setAddress(String appname,String elementProperty,String country) {
		
		Properties data = propertyFile.loadProperty(appname);
		
		Address residenceAddress = new Address(driver, "applicationData-"+elementProperty);
		if(country.equalsIgnoreCase("USA"))
		{
			residenceAddress.setCountryField(data.getProperty(elementProperty+".countryUSA"));
			residenceAddress.setApartmentTypeAndNumber(data.getProperty(elementProperty+".aptName"), 
					data.getProperty(elementProperty+".aptNum"));
			residenceAddress.setState(data.getProperty(elementProperty+".state"));
		}
		else if(!country.equalsIgnoreCase("USA"))
		{
			residenceAddress.setCountryField(data.getProperty(elementProperty+".country"));
			//residenceAddress.setStateText(data.getProperty(elementProperty+".state"));
		}
		
		residenceAddress.setStreet(data.getProperty(elementProperty+".streetName"));
		residenceAddress.setCity(data.getProperty(elementProperty+".city"));
		residenceAddress.setZipcode(data.getProperty(elementProperty+".zipcode"));
		
		return this;
	}

	
	public Address setAddressWithoutCountry(String appname,String elementProperty) {
		
		Properties data = propertyFile.loadProperty(appname);
		
		Address residenceAddress = new Address(driver, "applicationData-"+elementProperty);
		residenceAddress.setState(data.getProperty(elementProperty+".state"));
		residenceAddress.setStreet(data.getProperty(elementProperty+".streetName"));
		residenceAddress.setCity(data.getProperty(elementProperty+".city"));
		residenceAddress.setZipcode(data.getProperty(elementProperty+".zipcode"));
		
		return this;
	}
	
	
	
}
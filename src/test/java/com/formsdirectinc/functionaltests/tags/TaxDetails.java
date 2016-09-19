package com.formsdirectinc.functionaltests.tags;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * TaxDetails: Selenium page Model for INCOME TAX
 * 
 * @author Orina
 */
public class TaxDetails extends BaseTag {

	protected String taxYearExpression = "%s.taxYear";
	protected WebElement taxYearField;

	protected String totalIncomeExpression = "%s.totalIncome";
	protected String totalAssetsExpression = "%s.totalAssets";
	protected WebElement totalIncomeField;
	
	protected String currentAnnualExpensesExpression="%s.currentAnnualExpenses";
	
	protected String currentAnnualIncomeExpression = "%s.currentAnnualIncome";
	protected String currentIncomeExpression = "%s.currentIncome";
	protected WebElement currentIncomeField;

	protected String secondYearTaxExpression = "%s.secondYearTax";
	protected WebElement secondYearTaxField;

	protected String thirdYearTaxExpression = "%s.thirdYearTax";
	protected WebElement thirdYearTaxField;

	protected String secondYearIncomeExpression = "%s.secondYearIncome";
	protected WebElement secondYearIncomeField;

	protected String thirdYearIncomeExpression = "%s.thirdYearIncome";
	protected WebElement thirdYearIncomeField;

	protected String fileFederalIncomeExpression = "%s.fileFederalIncomeNotRequired";
	protected WebElement fileFederalIncomeField;

	protected String currentValueAssestsExpression="%s.currentValueAssests";
	protected String savingsExpression = "%s.savings";
	protected WebElement savingsField;

	protected String valueOfEstateExpression = "%s.valueOfEstate";
	protected WebElement valueOfEstateField;

	protected String valueOfStockExpression = "%s.valueOfStock";
	protected WebElement valueOfStockField;

	public TaxDetails(WebDriver driver, String property) {

		super(driver, property);
	}

	public TaxDetails setTaxYear(String taxYear) {
		taxYearField = driver.findElement(By.id(String.format(
				taxYearExpression, property)));
		taxYearField.sendKeys(taxYear);

		return this;
	}

	public TaxDetails setTotalIncome(String totalIncome) {
		totalIncomeField = driver.findElement(By.id(String.format(
				totalIncomeExpression, property)));
		totalIncomeField.sendKeys(totalIncome);
		return this;
	}
	
	public TaxDetails setTotalAssets(String totalAssets) {
		totalIncomeField = driver.findElement(By.id(String.format(
				totalAssetsExpression, property)));
		totalIncomeField.sendKeys(totalAssets);
		return this;
	}

	public TaxDetails setCurrentAnnualIncome(String currentAnnualIncome) {
		currentIncomeField = driver.findElement(By.id(String.format(
				currentAnnualIncomeExpression, property)));
		currentIncomeField.sendKeys(currentAnnualIncome);
		return this;
	}
	
	public TaxDetails setCurrentAnnualExpenses(String currentAnnualExpenses) {
		currentIncomeField = driver.findElement(By.id(String.format(
				currentAnnualExpensesExpression, property)));
		currentIncomeField.sendKeys(currentAnnualExpenses);
		return this;
	}
	
	public TaxDetails setCurrentIncome(String currentIncome) {
		currentIncomeField = driver.findElement(By.id(String.format(
				currentIncomeExpression, property)));
		currentIncomeField.sendKeys(currentIncome);
		return this;
	}
	
	public TaxDetails setSecondYearTax(String secondYearTax) {
		secondYearTaxField = driver.findElement(By.id(String.format(
				secondYearTaxExpression, property)));
		secondYearTaxField.sendKeys(secondYearTax);
		return this;
	}

	public TaxDetails setThirdYearTax(String thirdYearTax) {
		thirdYearTaxField = driver.findElement(By.id(String.format(
				thirdYearTaxExpression, property)));
		thirdYearTaxField.sendKeys(thirdYearTax);
		return this;
	}

	public TaxDetails setSecondYearIncome(String secondYearIncome) {
		secondYearIncomeField = driver.findElement(By.id(String.format(
				secondYearIncomeExpression, property)));
		secondYearIncomeField.sendKeys(secondYearIncome);
		return this;
	}

	public TaxDetails setThirdYearIncome(String thirdYearIncome) {
		thirdYearIncomeField = driver.findElement(By.id(String.format(
				thirdYearIncomeExpression, property)));
		thirdYearIncomeField.sendKeys(thirdYearIncome);
		return this;
	}

	public TaxDetails setFederalIncome(String reasonForNotFiled) {
		fileFederalIncomeField = driver.findElement(By.id(String.format(
				fileFederalIncomeExpression, property)));
		fileFederalIncomeField.sendKeys(reasonForNotFiled);
		return this;
	}

	public TaxDetails setSavings(String savings) {
		savingsField = driver.findElement(By.id(String.format(
				savingsExpression, property)));
		savingsField.sendKeys(savings);
		return this;
	}
	
	public TaxDetails setCurrentValueAssests(String currentValueAssests) {
		savingsField = driver.findElement(By.id(String.format(
				currentValueAssestsExpression, property)));
		savingsField.sendKeys(currentValueAssests);
		return this;
	}

	public TaxDetails setValueOfEstate(String valueOfEstate) {
		valueOfEstateField = driver.findElement(By.id(String.format(
				valueOfEstateExpression, property)));
		valueOfEstateField.sendKeys(valueOfEstate);
		return this;
	}

	public TaxDetails setValueOfStock(String valueOfStock) {
		valueOfStockField = driver.findElement(By.id(String.format(
				valueOfStockExpression, property)));
		valueOfStockField.sendKeys(valueOfStock);
		return this;
	}
}

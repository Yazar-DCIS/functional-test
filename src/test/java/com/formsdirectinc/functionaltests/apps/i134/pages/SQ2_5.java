package com.formsdirectinc.functionaltests.apps.i134.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_5 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_5 extends WizardPage {
	private AdditionalInfoFields annualIncome, savingsUsBank, propertyValue,
			stockValue, insuranceAmount, surrenderValue, realEstateValue,
			mortgageOrEncumbrance;
	private Address propertyCountrySelect;
	private YesNo insurance, realEstate;
	private Address propertyAddress;

	public SQ2_5(WebDriver driver) {
		super(driver);
	}

	public SQ2_5 IncomeDetails(Properties data) {
		annualIncome = new AdditionalInfoFields(driver,
				"applicationData-applicant.incomeInfo.annualIncome");
		annualIncome.isStatusOther(data.getProperty("1134_Income"));

		savingsUsBank = new AdditionalInfoFields(driver,
				"applicationData-applicant.incomeInfo.savingsInUSBank");
		savingsUsBank.isStatusOther(data.getProperty("1134_Income"));

		propertyValue = new AdditionalInfoFields(driver,
				"applicationData-applicant.incomeInfo.valueOfProperty");
		propertyValue.isStatusOther(data.getProperty("1134_Income"));

		stockValue = new AdditionalInfoFields(driver,
				"applicationData-applicant.incomeInfo.valueOfStocksAndBonds");
		stockValue.isStatusOther(data.getProperty("1134_Income"));
		return this;
	}

	public SQ2_5 yesInsurance(Properties data) {
		insurance = new YesNo(driver, "applicant.incomeInfo.haveLifeInsurance");
		insurance.yes();

		insuranceAmount = new AdditionalInfoFields(driver,
				"applicationData-applicant.incomeInfo.amountOfLifeInsurance");
		insuranceAmount.isStatusOther(data.getProperty("1134_Income"));

		surrenderValue = new AdditionalInfoFields(driver,
				"applicationData-applicant.incomeInfo.cashSurrenderValue");
		surrenderValue.isStatusOther(data.getProperty("1134_Income"));
		return this;
	}

	public SQ2_5 noInsurance() {
		insurance = new YesNo(driver, "applicant.incomeInfo.haveLifeInsurance");
		insurance.no();
		return this;
	}

	public SQ2_5 yesRealEstate() {
		realEstate = new YesNo(driver, "applicant.incomeInfo.ownRealEstate");
		realEstate.yes();

		realEstateValue = new AdditionalInfoFields(driver,
				"applicationData-applicant.incomeInfo.realEstateValue");
		realEstateValue.isStatusOther("12345");

		mortgageOrEncumbrance = new AdditionalInfoFields(driver,

		"applicationData-applicant.incomeInfo.mortgageOrEncumbrance");
		mortgageOrEncumbrance.isStatusOther("12345");
		return this;
	}

	public SQ2_5 noRealEstate() {
		realEstate = new YesNo(driver, "applicant.incomeInfo.ownRealEstate");
		realEstate.no();
		return this;
	}

	public SQ2_5 NonUsPropertyAddress() {
		propertyCountrySelect = new Address(driver,
				"applicationData-applicant.incomeInfo.propertyAddress.country");
		propertyCountrySelect.setCountryDropDown("Argentina");

		propertyAddress = new Address(driver,
				"applicationData-applicant.incomeInfo.propertyAddress");
		propertyAddress.setStreet("Street");
		propertyAddress.setCity("City");
		propertyAddress.setStateText("State");
		propertyAddress.setZipcode("12345");
		return this;
	}

	public SQ2_5 UsPropertyAddress() {
		propertyCountrySelect = new Address(driver,
				"applicationData-applicant.incomeInfo.propertyAddress.country");
		propertyCountrySelect.setCountryDropDown("United States of America");

		propertyAddress = new Address(driver,
				"applicationData-applicant.incomeInfo.propertyAddress");
		propertyAddress.setStreet("Street");
		propertyAddress.setCity("Texas");
		propertyAddress.setState("FL");
		propertyAddress.setZipcode("12345");
		return this;
	}

}

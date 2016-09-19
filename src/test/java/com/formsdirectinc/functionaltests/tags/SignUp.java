package com.formsdirectinc.functionaltests.tags;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.formsdirectinc.functionaltests.apps.payment.Payment;
import com.formsdirectinc.functionaltests.apps.registration.Registration;

/**
 * Sign UP: Selenium page Model for Register And Payment Controls
 * 
 * @author Orina
 * @Date: 24/02/2016
 */
public class SignUp extends BaseTag {

	String firstNameFieldExpressionCore = "%s-firstName";
	String emailFieldExpressionCore = "%s-emailId";
	String confirmEmailFieldExpressionCore = "confirm-%s-emailId";
	String confirmEmailFieldExpression = "confirmemailId";
	String lastNameFieldExpressionCore = "%s-lastName";
	String passwordFieldExpressionCore = "%s-password";
	String confirmPasswordFieldExpressionCore = "confirm-%s-password";
	String phoneAreaCodeFieldExpressionCore = "%s-signinPhone-areaCode";
	String phoneNumber1FieldExpressionCore = "%s-signinPhone-phone1";
	String phoneNumber2FieldExpressionCore = "%s-signinPhone-phone2";
	String phoneNumber3FieldExpressionCore = "%s-signinPhone-phone3";

	String hintQuestionFieldExpressionCore = "%s-hintQuestion";
	String hintAnswerFieldExpressionCore = "%s-hintAnswer";
	String termsFieldExpressionCore = "sign_up_accepts_terms";
	String createFieldExpressionCore = "Createbutton";

	String cardNumber = "UMcard";
	String cardNumberDVD = "CARDNUM";
	String cardType = "cardType";

	String cardMonth = "month";
	String cardYear = "year";

	String cardPin = "UMcvv2";
	String cardPinDVD="CIN";
	String cardFirstName = "firstname";

	String cardLastName = "lastname";
	String cardZipcode = "ZIP";

	String cardAgreeTerms = "termsagree";
	String cardStateBasedTerms = "stateBased";

	String cardState = "STATE";
	String cardShipingAddr="isSameAsShippingAddress";
	
	
	String paypalLink="paypal-payment";
	
	
	WebElement valuefield, confirmvaluefield;

	String paymentSuccessExpression = "a[href='/applicationcenter.do']";
	WebElement paymentSuccessField;

	public SignUp(WebDriver driver, String property) {
		super(driver, property);

	}

	public SignUp(WebDriver driver) {
		super(driver);

	}

	public SignUp setFirstNameInCore(String firstName) {
		valuefield = driver.findElement(By.id(String.format(
				firstNameFieldExpressionCore, property)));
		valuefield.sendKeys(firstName);

		return this;
	}

	public String setEMailInCore(String email) {
		valuefield = driver.findElement(By.id(String.format(
				emailFieldExpressionCore, property)));
		valuefield.sendKeys(email);
		Reporter.log("<br>"+"EMail ID" + "<br>" + "<font color=\"green\">" + email
				+ "</font>");
		GenerateMail writeEmail = PageFactory.initElements(driver,
				GenerateMail.class);
		try {
			writeEmail.writeMail_ID(email);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return email;
	}

	public SignUp setConfirmEMailInCore() {

		valuefield = driver.findElement(By.id(String.format(
				emailFieldExpressionCore, property)));
		confirmvaluefield = driver.findElement(By.id(String.format(
				confirmEmailFieldExpressionCore, property)));
		confirmvaluefield.sendKeys(valuefield.getAttribute("value"));

		return this;
	}

	public SignUp setConfirmEMail() {

		valuefield = driver.findElement(By.id(String.format(
				emailFieldExpressionCore, property)));
		confirmvaluefield = driver.findElement(By.name(String.format(
				confirmEmailFieldExpression, property)));
		confirmvaluefield.sendKeys(valuefield.getAttribute("value"));

		return this;
	}
	
	public SignUp setConfirmPasswordInCore(String confirmPassword) {
		valuefield = driver.findElement(By.id(String.format(
				confirmPasswordFieldExpressionCore, property)));
		valuefield.sendKeys(confirmPassword);

		return this;
	}

	public SignUp setLastNameInCore(String lastName) {
		valuefield = driver.findElement(By.id(String.format(
				lastNameFieldExpressionCore, property)));
		valuefield.sendKeys(lastName);

		return this;
	}

	public SignUp setPasswordInCore(String password) {
		valuefield = driver.findElement(By.id(String.format(
				passwordFieldExpressionCore, property)));
		valuefield.sendKeys(password);

		return this;
	}

	public SignUp setPhoneAreaCodeInCore(String phoneNumber) {
		valuefield = driver.findElement(By.id(String.format(
				phoneAreaCodeFieldExpressionCore, property)));
		valuefield.sendKeys(phoneNumber);

		return this;
	}

	public SignUp setPhoneNumber1InCore(String phoneNumber) {
		valuefield = driver.findElement(By.id(String.format(
				phoneNumber1FieldExpressionCore, property)));
		valuefield.sendKeys(phoneNumber);

		return this;
	}

	public SignUp setPhoneNumber2InCore(String phoneNumber) {
		valuefield = driver.findElement(By.id(String.format(
				phoneNumber2FieldExpressionCore, property)));
		valuefield.sendKeys(phoneNumber);

		return this;
	}

	public SignUp setPhoneNumber3InCore(String phoneNumber) {
		valuefield = driver.findElement(By.id(String.format(
				phoneNumber3FieldExpressionCore, property)));
		valuefield.sendKeys(phoneNumber);

		return this;
	}

	public SignUp setQuestionInCore(String question) {
		valuefield = driver.findElement(By.id(String.format(
				hintQuestionFieldExpressionCore, property)));
		valuefield.sendKeys(question);

		return this;
	}

	public SignUp setAnswerInCore(String answer) {
		valuefield = driver.findElement(By.id(String.format(
				hintAnswerFieldExpressionCore, property)));
		valuefield.sendKeys(answer);

		return this;
	}

	public SignUp createAccountInCore() {
		valuefield = driver.findElement(By.id(createFieldExpressionCore));
		valuefield.click();

		return this;
	}

	/*
	 * ==========================================================================
	 * ===============
	 */

	public SignUp setCardNumber(String answer) {
		valuefield = driver.findElement(By.id(cardNumber));
		valuefield.sendKeys(answer);

		return this;
	}

	public SignUp setCardNumberDVD(String answer) {
		valuefield = driver.findElement(By.id(cardNumberDVD));
		valuefield.sendKeys(answer);

		return this;
	}
	
	public SignUp setCardType(String answer) {
		valuefield = driver.findElement(By.id(cardType));
		valuefield.sendKeys(answer);

		return this;
	}

	public SignUp setCardMonth(String answer) {
		valuefield = driver.findElement(By.id(cardMonth));
		valuefield.sendKeys(answer);

		return this;
	}

	public SignUp setCardYear(String answer) {
		valuefield = driver.findElement(By.id(cardYear));
		valuefield.sendKeys(answer);

		return this;
	}

	public SignUp setCardMonthName(String answer) {
		valuefield = driver.findElement(By.name(cardMonth));
		valuefield.sendKeys(answer);

		return this;
	}

	public SignUp setCardYearName(String answer) {
		valuefield = driver.findElement(By.name(cardYear));
		valuefield.sendKeys(answer);

		return this;
	}
	
	public SignUp setCardPinNumber(String answer) {
		valuefield = driver.findElement(By.id(cardPin));
		valuefield.sendKeys(answer);

		return this;
	}

	public SignUp setCardPinNumberDVD(String answer) {
		valuefield = driver.findElement(By.id(cardPinDVD));
		valuefield.sendKeys(answer);

		return this;
	}
	
	public SignUp setFirstNameAsInCard(String answer) {
		valuefield = driver.findElement(By.id(cardFirstName));
		valuefield.clear();
		valuefield.sendKeys(answer);

		return this;
	}

	public SignUp setLastNameAsInCard(String answer) {
		valuefield = driver.findElement(By.id(cardLastName));
		valuefield.clear();
		valuefield.sendKeys(answer);

		return this;
	}

	public SignUp setZipcode(String answer) {
		valuefield = driver.findElement(By.id(cardZipcode));
		valuefield.sendKeys(answer);

		return this;
	}

	public SignUp setCardState(String answer) {
		valuefield = driver.findElement(By.id(cardState));
		valuefield.sendKeys(answer);

		return this;
	}

	public SignUp agreeCardTerms() {
		valuefield = driver.findElement(By.name(cardAgreeTerms));
		valuefield.click();

		return this;
	}

	public SignUp agreeCardStateTerms() {
		valuefield = driver.findElement(By.id(cardStateBasedTerms));
		valuefield.click();

		return this;
	}
	
	public SignUp paypalTab(){
		valuefield = driver.findElement(By.id(paypalLink));
		valuefield.click();
		return this;
		
	}
	
	
	
	

	public SignUp setSameShippingAddress() {
		valuefield = driver.findElement(By.id(cardShipingAddr));
		valuefield.click();

		return this;
	}
	
	public SignUp confirmPayment(String productname) {

		paymentSuccessField = driver.findElement(By
				.cssSelector(paymentSuccessExpression));
		
		CaptureScreen myscreen=new CaptureScreen(driver);
		myscreen.takeScreenShot(productname, "PaymentSuccessPage");
		
		paymentSuccessField.click();

		return this;
	}

	public SignUp register(String appName, String flowName) throws IOException {

		Registration register = PageFactory.initElements(driver,
				Registration.class);
		register.test(appName, flowName);

		return this;

	}

	public SignUp pay(String appName, String flowName) throws Exception {

		Payment payment = PageFactory.initElements(driver,
				Payment.class);
		payment.test(appName, flowName);

		return this;

	}

}

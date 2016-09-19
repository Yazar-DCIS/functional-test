package com.formsdirectinc.functionaltests.apps.dvd;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.Buttons;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.SignUp;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * Register and Payment for DVD in ID/USC ; AIC just loads the DVD Page
 * @author Orina
 * 
 */

public class DVD extends Step{


	public DVD(WebDriver driver) {
		super(driver);
		
	}
	Sites site = Sites.valueOf(System.getProperty("site.name"));
	public void test(String product, String flowname) throws Exception {
	
	
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		PropertyResource propertyFile=new PropertyResource();
		Properties setPropertyKeyValues=propertyFile.loadProperty("keyValue");

		
		driver.get(site.getBaseURL()
				+ setPropertyKeyValues.getProperty("dvdUrl" + site));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		if(site==Sites.AIC)
		{
			SelectElement orderDVD=new SelectElement(driver, "MAIL ORDER");
			orderDVD.selectElementUsingLinkText();
			
			CaptureScreen page = PageFactory.initElements(driver,
					CaptureScreen.class);
			page.takeScreenShot(product,product);
		}
		else
		{
			Buttons orderDVD=new Buttons(driver, "DVD");
			orderDVD.selectButton();
		
		
		SignUp createUser = new SignUp(driver, "applicationData");
		createUser.setFirstNameInCore("Test");
		createUser.setLastNameInCore("Dcis");
		
		if(site==Sites.ID)
		{
		createUser.setEMailInCore("testpayment@immigrationdirect.com");
		createUser.setConfirmEMail();
		
		PhoneNumber contactInfo=new PhoneNumber(driver, "applicationData-customer.phone");
		contactInfo.setAreaCode("123");
		contactInfo.setPhoneCode("123");
		contactInfo.setPhoneNumber("1231");
		}
		
		Address shippingAddressInfo=new Address(driver, "shipping");
		shippingAddressInfo.setAddressLineName("Test");
		shippingAddressInfo.setCityName("Test");
		shippingAddressInfo.setStateName("CA");
		shippingAddressInfo.setZipcodeValue("10101");
		
		Buttons continueBtn=new Buttons(driver, "Continue");
		continueBtn.selectButton();
		
		if(site==Sites.USC)
		{
			Buttons shippingAddress=new Buttons(driver, "Ship To This Address");
			shippingAddress.selectButton();
		}
		
		makePaymentForDVD();
		
		if(site==Sites.USC)
		{
			SelectElement setEmail=new SelectElement(driver, "email");
			setEmail.sendValuesUsingElementID("testpayment@immigrationdirect.com");
			SelectElement setzipcode=new SelectElement(driver, "ZIP");
			setzipcode.sendValuesUsingElementID("10101");
		}
		
		Buttons submitOrder=new Buttons(driver, "Submit");
		submitOrder.selectButton();
		
		CaptureScreen page = PageFactory.initElements(driver,
				CaptureScreen.class);
		page.takeScreenShot(product,product);

		Buttons home=new Buttons(driver, "Home");
		home.selectButton();
		}
	}
	
	
	private void makePaymentForDVD()
	{
		SignUp payForProduct = new SignUp(driver);
		payForProduct.setCardType("Visa");
		payForProduct.setCardNumberDVD("4111111111111111");
		payForProduct.setCardMonthName("Nov");
		payForProduct.setCardYearName("2019");
		payForProduct.setCardPinNumberDVD("000");
		payForProduct.setFirstNameAsInCard("test");
		payForProduct.setLastNameAsInCard("dcis");
		
		if(site==Sites.ID)
		{
			payForProduct.setSameShippingAddress();
		}
	}
	
}

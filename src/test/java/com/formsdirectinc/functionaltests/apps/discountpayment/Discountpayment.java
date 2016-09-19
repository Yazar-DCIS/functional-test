package com.formsdirectinc.functionaltests.apps.discountpayment;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.payment.PaymentSuccess;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.AcquisitionUtils;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.SignIn;
import com.formsdirectinc.functionaltests.tags.SignUp;

import com.formsdirectinc.functionaltests.utils.PropertyResource;

public class Discountpayment extends Step {

	public Discountpayment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void test(String product, String flowname) throws Exception {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Sites site = Sites.valueOf(System.getProperty("site.name"));

		String siteName = System.getProperty("site.name");
		boolean a = siteName.contains("STAGING");
		String siteNameNew = siteName.replace("STAGING", "");
		// String page=Payment.class.getSimpleName().toLowerCase();
		String runProductCORE = Products.valueOf(product.toUpperCase())
				.getProductNameInCoreSites();
		String lang = System.getProperty("acquisitionLang");

		PropertyResource propertyFile = new PropertyResource();
		Properties prop = propertyFile.loadProperty("acquisition");
		Properties data = propertyFile.loadProperty("purchaseApp");

		if (!(lang == null)) {
			lang = lang.substring(0, 1).toUpperCase()
					+ lang.substring(1).toLowerCase();
		}

		if ((lang == null)) {
			lang = "En";
		}
		if (!(lang.equalsIgnoreCase("en") || lang.equalsIgnoreCase("es"))) {
			lang = "En";
		}
		System.out.println(product + "product---->");
		System.out.println(lang + "--->");

		if ((site == Sites.ID || site == Sites.IDSTAGING)
				&& (runProductCORE.equalsIgnoreCase("i90") || runProductCORE
						.equalsIgnoreCase("n400"))) {

			driver.get(site.getBaseURL()
					+ prop.getProperty("discountUrl" + lang) + siteNameNew
					+ runProductCORE.toUpperCase() + "25" + "&application="
					+ runProductCORE);

		}

		else if (runProductCORE.equalsIgnoreCase("i485principal")) {
			driver.get(site.getBaseURL()
					+ prop.getProperty("discountUrl" + lang) + siteNameNew
					+ "I485D" + "&application=" + runProductCORE);

		} else {
			driver.get(site.getBaseURL()
					+ prop.getProperty("discountUrl" + lang) + siteNameNew
					+ runProductCORE.toUpperCase() + "D" + "&application="
					+ runProductCORE);
		}

		if (lang.equalsIgnoreCase("en")) {
			SignIn existingUser = new SignIn(driver);
			existingUser.setUserID("mohamed.yazar@dcis.net");
			existingUser.setUserPassword("abcd1234");
			existingUser.logIntoDiscount();
		}
		if (lang.equalsIgnoreCase("es")) {
			SignIn existingUser = new SignIn(driver);
			existingUser.setUserID("yazar.testnew@gmail.com");
			existingUser.setUserPassword("abcdef");
			existingUser.logIntoDiscountEs();
		}

		AcquisitionUtils acquisitionUtils = PageFactory.initElements(driver,
				AcquisitionUtils.class);
		SignUp payForProduct = new SignUp(driver);

		String url = driver.getCurrentUrl();
		site = Sites.valueOf(System.getProperty("site.name").replace("STAGING",
				""));

		String creditcardCost = acquisitionUtils.testDiscountProductcost(site,
				runProductCORE, "Creditcard");
		creditcardCost = creditcardCost.replaceAll("\\.0*$", "");
		creditcardCost = creditcardCost.replaceAll("\\D+", "");

		if (!((site == Sites.USC) && (runProductCORE.equalsIgnoreCase("n400")) || (a == true))) {

			payForProduct.paypalTab();
			payForProduct.agreeCardTerms();

			String paypalCost = acquisitionUtils.testDiscountProductcost(site,
					runProductCORE, "Paypal");

			SelectElement selectPaypalPayment = new SelectElement(driver,
					data.getProperty("doPaymentPaypal" + site));
			selectPaypalPayment.selectElementUsingCSS();

			acquisitionUtils.testPaypalTotal(paypalCost);

			driver.get(url + "&lang=" + lang.toLowerCase());
		}

		payForProduct.setCardType(data.getProperty("CardType"));
		payForProduct.setCardNumber(data.getProperty("CardNumber"));
		payForProduct.setCardMonth(data.getProperty("CardMonth"));
		payForProduct.setCardYear(data.getProperty("CardYear"));
		payForProduct.setCardPinNumber(data.getProperty("CardPIN"));

		if (site == Sites.FR) {
			payForProduct.setFirstNameAsInCard(data
					.getProperty("CardFirstNameFR"));
		} else {

			payForProduct.setFirstNameAsInCard(data
					.getProperty("CardFirstName"));
			payForProduct.setLastNameAsInCard(data.getProperty("CardLastName"));
		}

		payForProduct.setZipcode(data.getProperty("CardZipcode"));
		payForProduct.agreeCardTerms();

		if (site == Sites.ID || site == Sites.FR || site == Sites.AIC) {
			payForProduct.setCardState(data.getProperty("CardState"));
		}

		SelectElement selectPayment = new SelectElement(driver,
				data.getProperty("doPayment" + site));
		selectPayment.selectElementUsingCSS();

		driver.switchTo().alert().accept();

		PaymentSuccess selectContinue = new PaymentSuccess(driver);

		selectContinue.PaymentSuccesstest(product, creditcardCost);

	}

}

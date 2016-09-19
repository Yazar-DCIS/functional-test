package com.formsdirectinc.functionaltests.apps.payment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import org.testng.Reporter;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.AcquisitionUtils;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.SignIn;
import com.formsdirectinc.functionaltests.tags.SignUp;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

public class Payment extends Step {

	public Payment(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void test(String product, String flowname) throws Exception {

		Sites site = Sites.valueOf(System.getProperty("site.name"));

		String emailAlert = System.getProperty("acquisitionMailAlert");
		String siteName = System.getProperty("site.name");
		boolean a = siteName.contains("STAGING");
		String siteNameNew = siteName.replace("STAGING", "");
		String page = Payment.class.getSimpleName().toLowerCase();
		String runProductCORE = Products.valueOf(product.toUpperCase())
				.getProductNameInCoreSites();
		String lang = System.getProperty("acquisitionLang");

		PropertyResource propertyFile = new PropertyResource();
		Properties data = propertyFile.loadProperty("purchaseApp");
		Properties keys = propertyFile.loadProperty("keyValue");

		SignUp payForProduct = new SignUp(driver);

		AcquisitionUtils acquisitionUtils = PageFactory.initElements(driver,
				AcquisitionUtils.class);

		if ((lang == null)) {
			lang = "En";
		}
		if (!(lang.equalsIgnoreCase("en") || lang.equalsIgnoreCase("es"))) {
			lang = "En";
		}

		System.out.println(product + "product---->");
		System.out.println(lang + "--->");

		File outputFile = new File(
				"src/test/resources/prepurchaceOutput/payment" + product + site
						+ ".txt");
		if (!outputFile.exists()) {
			outputFile.createNewFile();
		}

		String outputFilePath = outputFile.getAbsolutePath();
		FileOutputStream fos = new FileOutputStream(outputFilePath);

		if (!(emailAlert == null) && (emailAlert.equalsIgnoreCase("yes"))) {

			PrintStream ps = new PrintStream(fos);
			System.setOut(ps);

		}

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		String paymentURL = site.getBaseURL() + keys.getProperty("paymentURL")
				+ runProductCORE;
		String applicationCenterURL = site.getBaseURL()
				+ "application-center/applicationcenter.do";

		String paymentURLCheck = driver.getCurrentUrl();

		if (paymentURLCheck.equalsIgnoreCase(paymentURL)) {
			Reporter.log("Payment page via new user registration");

		} else if (paymentURLCheck.equalsIgnoreCase(applicationCenterURL)) {
			Reporter.log("Payment Page via login");
			driver.get(paymentURL);

		} else {
			Reporter.log("Payment Page via Bookmarked user/ Payment Module test");

			String paymentURLLang = site.getBaseURL()
					+ keys.getProperty("paymentURL" + lang) + runProductCORE;
			driver.get(paymentURLLang);
			if (lang.equalsIgnoreCase("en")) {
				SignIn existingUser = new SignIn(driver);
				existingUser.setUserID("mohamed.yazar@dcis.net");
				existingUser.setUserPassword("abcd1234");
				existingUser.logIntoApplication("mohamed.yazar@dcis.net");
			}
			if (lang.equalsIgnoreCase("es")) {
				SignIn existingUser = new SignIn(driver);
				existingUser.setUserID("yazar.testnew@gmail.com");
				existingUser.setUserPassword("abcdef");
				existingUser.logIntoApplicationEs("yazar.testnew@gmail.com");
			}
		}

		CaptureScreen myscreen = new CaptureScreen(driver);
		myscreen.takeScreenShot(product, "PaymentPage");

		site = Sites.valueOf(siteNameNew);
		String[] acqTests = null;
		String testacqScope = System.getProperty("acquisitionTest");
		String acqDefaultScope = "Scripts,PageTitle,FooterLink,FooterDisclaimer,PageLabel,ProductDescription,ProductCost,PaymentDecline,Cookies,Paypal";

		if (!(testacqScope == null)) {
			if (testacqScope.equalsIgnoreCase("All")) {
				acqTests = acqDefaultScope.split(",");
			} else if (!testacqScope.equalsIgnoreCase("All")) {
				acqTests = testacqScope.split(",");
			} else {
				System.err.println("Make Sure Defined Scope!");
			}
			for (String acqStepToRun : acqTests) {

				if (acqStepToRun.equalsIgnoreCase("Scripts")) {
					System.out.println("Scripts Check");
					acquisitionUtils.testScripts(site, runProductCORE);
				}

				if (acqStepToRun.equalsIgnoreCase("PageTitle")) {
					System.out.println("PageTitle Check");
					acquisitionUtils.testPageTitle(site, runProductCORE);
				}

				if (acqStepToRun.equalsIgnoreCase("FooterLink")
						&& (site == Sites.AIC || site == Sites.DUS)) {

					System.out.println("Footer Links Check");
					acquisitionUtils.testFooterLink(site, lang);

				}

				if (acqStepToRun.equalsIgnoreCase("FooterDisclaimer")) {
					System.out.println("Footer Disclaimer Check");
					acquisitionUtils.testDisclaimer(page, site, lang);
				}

				if (acqStepToRun.equalsIgnoreCase("PageLabel")) {
					System.out.println("PageLabel Check");
					acquisitionUtils.testLabel(page, site, lang);
				}

				if (acqStepToRun.equalsIgnoreCase("ProductDescription")) {
					System.out.println("Product Description Check");
					acquisitionUtils.testProductDescription(site,
							runProductCORE, lang, "Creditcard");
				}

				if (acqStepToRun.equalsIgnoreCase("ProductCost")) {

					System.out.println("Product Cost Check");
					acquisitionUtils.testProductcost(site, runProductCORE,
							"Creditcard");

				}

				if (acqStepToRun.equalsIgnoreCase("PaymentDecline")) {

					System.out.println("Payment Decline Check");

					payForProduct.setCardType(data.getProperty("CardType"));
					payForProduct.setCardNumber(data
							.getProperty("DeclineCardNumber"));
					payForProduct.setCardMonth(data.getProperty("CardMonth"));
					payForProduct.setCardYear(data.getProperty("CardYear"));
					payForProduct.setCardPinNumber(data
							.getProperty("DeclineCardPIN"));

					if (site == Sites.FR) {
						payForProduct.setFirstNameAsInCard(data
								.getProperty("CardFirstNameFR"));
					} else {

						payForProduct.setFirstNameAsInCard(data
								.getProperty("CardFirstName"));
						payForProduct.setLastNameAsInCard(data
								.getProperty("CardLastName"));
					}
					payForProduct.setZipcode(data.getProperty("CardZipcode"));
					payForProduct.agreeCardTerms();

					if (site == Sites.ID || site == Sites.FR || site == Sites.AIC) {
						payForProduct.setCardState(data
								.getProperty("CardState"));
					}

					SelectElement selectPayment = new SelectElement(driver,
							data.getProperty("doPayment" + site));
					selectPayment.selectElementUsingCSS();
					driver.switchTo().alert().accept();
					driver.manage().timeouts()
							.implicitlyWait(30, TimeUnit.SECONDS);

					driver.get(paymentURL);

				}

				if (acqStepToRun.equalsIgnoreCase("Cookies")) {
					System.out.println("Cookie Check");

					String langCookie = acquisitionUtils
							.getValueOfCookieNamed("lang");
					if (!langCookie.equalsIgnoreCase(lang)) {
						System.out
								.println("Lang Cookie value is mismatched from "
										+ lang + " to " + langCookie);
					}

					Cookie Cokie = acquisitionUtils.getCookieNamed("id.i");
					if (Cokie == null) {
						System.out.println("cookie has not been set");
					}

				}

				if (acqStepToRun.equalsIgnoreCase("Paypal")) {
					System.out.println("Paypal Check");

					if (!((site == Sites.USC)
							&& (runProductCORE.equalsIgnoreCase("n400")) || a == true)) {
						payForProduct.paypalTab();
						payForProduct.agreeCardTerms();

						System.out
								.println("Product description in paypal");
						acquisitionUtils.testProductDescription(site,
								runProductCORE, lang, "Paypal");

						System.out
								.println("Product cost in paypal");

						acquisitionUtils.testProductcost(site, runProductCORE,
								"Paypal");

						String total = acquisitionUtils.testreturncostTotal(
								site, runProductCORE, "Paypal");

						SelectElement selectPayment = new SelectElement(driver,
								data.getProperty("doPaymentPaypal" + site));
						selectPayment.selectElementUsingCSS();

						acquisitionUtils.testPaypalTotal(total);

						driver.get(site.getBaseURL()
								+ keys.getProperty("registerUrl" + lang)
								+ runProductCORE);

					}
				}
			}
			String s = acquisitionUtils.readFile(page + product);
			if (!(emailAlert == null || emailAlert.equalsIgnoreCase("no"))) {
				if (s != null) {

					acquisitionUtils.sendmail(s, site + product + page);

				}
			}

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

		if (site == Sites.ID || site == Sites.FR || site == Sites.AIC ) {
			payForProduct.setCardState(data.getProperty("CardState"));
		}
		String CreditCardTotalPrice = acquisitionUtils.testreturncostTotal(
				site, runProductCORE, "Creditcard");
		CreditCardTotalPrice = CreditCardTotalPrice.replaceAll("\\.0*$", "");
		CreditCardTotalPrice = CreditCardTotalPrice.replaceAll("\\D+", "");

		System.out.println(CreditCardTotalPrice + "============>>");
		/* Select the submit payment---> */
		SelectElement selectPayment = new SelectElement(driver,
				data.getProperty("doPayment" + site));
		selectPayment.selectElementUsingCSS();

		/* Select the alert box---> */
		driver.switchTo().alert().accept();

		PaymentSuccess selectContinue = new PaymentSuccess(driver);

		selectContinue.PaymentSuccesstest(product, CreditCardTotalPrice);

		fos.close();

	}
}








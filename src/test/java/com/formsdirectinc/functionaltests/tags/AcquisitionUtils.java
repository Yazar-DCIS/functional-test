package com.formsdirectinc.functionaltests.tags;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.formsdirectinc.functionaltests.apps.payment.Payment;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

public class AcquisitionUtils extends WizardPage {

	Sites site = Sites.valueOf(System.getProperty("site.name"));

	protected String transactionExpression = "'transactionTotal': %s.0,";
	protected String transactionExpressionFR = "total: '%s.0'";
	private static final String DEFAULT_OUTPUT_PATH = "src/test/resources/output/%s.txt";

	PropertyResource propertyFile = new PropertyResource();
	Properties prop = propertyFile.loadProperty("acquisition");

	public AcquisitionUtils(WebDriver driver) {
		super(driver);
	}

	// To check page Script GA,GTM,Optimizely
	public AcquisitionUtils testScripts(Sites site, String productinfo) {

		String[] prod_scripts = prop.getProperty("" + site + "_scripts").split(
				":");
		for (int i = 0; i <= prod_scripts.length - 1; i++) {
			int size = driver.getPageSource().split("" + prod_scripts[i] + "").length - 1;
			if (size >= 2) {
				System.out.println(site + productinfo);
				String currentURL = driver.getCurrentUrl();
				System.out.println(currentURL);
				System.out.println("Problem in " + prod_scripts[i]
						+ "script -might be repeated");
				System.out.println("\n");
			}
			if (size == 0) {
				System.out.println(site + productinfo);
				String currentURL = driver.getCurrentUrl();
				System.out.println(currentURL);
				System.out.println("Problem in " + prod_scripts[i]
						+ "script -might be left out");
				System.out.println("\n");
			}

		}
		return this;

	}

	// to check page title
	public AcquisitionUtils testPageTitle(Sites site, String productinfo) {
		String ttl;
		String title = driver.getTitle();
		ttl = prop.getProperty(site + "_title");
		if (!(ttl.equals(title))) {
			System.out.println("Page title Copy Check in "
					+ driver.getCurrentUrl());
			System.out.println("Page title mismatched \nFrom:\n\n " + ttl
					+ "\n\nTo:\n\n " + title);
		}
		return this;
	}

	// To check footer links (terma of use,privacypolicy etc.,)
	public AcquisitionUtils testFooterLink(Sites site, String Lang) {

		String[] footerLink = prop
				.getProperty(site + "_footerLinksCopy" + Lang).split(":");
		String[] footerLinkXpath = prop.getProperty(site + "_footerLinksXpath")
				.split(":");
		String[] c3 = new String[10];
		for (int i = 0; i <= footerLinkXpath.length - 1; i++) {
			try {
				List<WebElement> copy = driver.findElements(By
						.cssSelector(footerLinkXpath[i]));
				int listsize = copy.size();
				for (int j = 0; j <= listsize - 1; j++) {
					c3[j] = copy.get(j).getText();
					String sts;
					if (i == 0) {
						sts = footerLink[j];
					} else {
						sts = footerLink[i];
					}
					if (!(sts.equals(c3[j]))) {
						System.out.println("Footer Link Copy Check in "
								+ driver.getCurrentUrl());
						System.out
								.println("Footer Link copy mismatched \nFrom:\n\n "
										+ sts + "\n\nTo:\n\n" + c3[j]);
					}

				}
			}

			catch (Exception e) {

				System.out.println(e);
			}
		}
		return this;
	}

	// to check footer disclaimer copy
	public AcquisitionUtils testDisclaimer(String page, Sites site, String lang)
			throws IOException {

		String[] footerDisclaimer = prop.getProperty(
				site + "_" + page + "footerDisclaimerCopy" + lang).split(";;");
		String[] footerDisclaimerXpath = prop.getProperty(
				site + "_" + page + "footerDisclaimerXpath").split(";;");

		String sts;
		String c3;

		for (int i = 0; i <= footerDisclaimerXpath.length - 1; i++) {

			try {

				List<WebElement> copy = driver.findElements(By
						.cssSelector(footerDisclaimerXpath[i]));

				int Disclaimersize = copy.size();

				for (int k = 0; k <= Disclaimersize - 1; k++) {

					c3 = copy.get(k).getText();

					if (i == 0) {

						sts = footerDisclaimer[k];
					}

					else {
						sts = footerDisclaimer[i];
					}

					if (!(sts.equals(c3))) {
						System.out.println("Footer Disclaimer Copy Check in "
								+ driver.getCurrentUrl());

						System.out
								.println("Footer Disclaimer copy mismatched \nFrom: \n\n"
										+ sts + "\n\nTo:\n\n" + c3);

					}

				}
			}

			catch (Exception e) {

				System.out.println(e);

			}

		}
		return this;
	}

	// to check the product name in order summary section
	public AcquisitionUtils testProductDescription(Sites site,
			String productinfo, String lang, String paymentType) {

		String productDescription = prop.getProperty(site + "." + productinfo
				+ ".name." + lang);
		String productDescriptionXpath = prop.getProperty(site
				+ ".productDescription" + paymentType + "Xpath");

		String desc = driver.findElement(
				By.cssSelector(productDescriptionXpath)).getText();
		if (!(desc.equals(productDescription))) {
			System.out
					.println("Product description in Payment page order summary section has been mismatched from  "
							+ productDescription + " to " + desc);
		}

		return this;

	}

	// to check product cost in order summary section
	public AcquisitionUtils testProductcost(Sites site, String productinfo,
			String paymentType) {

		String productCost = prop.getProperty(site + "." + productinfo
				+ ".price");
		String productCostXpath = prop.getProperty(site + ".productCost"
				+ paymentType + "Xpath");
		String productCosttotalXpath = prop.getProperty(site
				+ ".productCosttotal" + paymentType + "Xpath");

		if (paymentType.equalsIgnoreCase("Creditcard")) {

			if (!(site == Sites.FR)) {
				productCost = "$" + productCost;
			}

		}

		else {

			if (!(site == Sites.FR)) {
				productCost = productCost + " USD";

			}
			/*
			 * if ((site == Sites.AIC || site == Sites.USC)) { productCost =
			 * "Order Total - " + productCost + " plus USCIS Filing Fees"; }
			 */

		}

		String total = driver
				.findElement(By.cssSelector(productCosttotalXpath)).getText();
		// System.out.println(productCost + "<--->\n<--->" + total);

		if (!(site == Sites.DUS) && !(site == Sites.ID) && !(site == Sites.FR)) {
			String price = driver.findElement(By.cssSelector(productCostXpath))
					.getText();
			// System.out.println(productCost + "<--->\n<--->" + price);

			if (!(price.equals(productCost)))

			{
				System.out
						.println("Product cost in Payment page order summary section has been mismatched from  "
								+ productCost + " to " + price);
			}
		}

		if (!(total.equals(productCost))) {

			System.out
					.println("Product Cost total in Payment page order summary section has been mismatched from  "
							+ productCost + " to " + total);
		}

		return this;
	}

	// returns the final cost of the product
	public String testreturncostTotal(Sites site, String productinfo,
			String paymentType) {
		String productCosttotalXpath = prop.getProperty(site
				+ ".productCosttotal" + paymentType + "Xpath");
		String total = driver
				.findElement(By.cssSelector(productCosttotalXpath)).getText();
		return total;

	}

	// to check discount cost of the product
	public String testDiscountProductcost(Sites site, String productinfo,
			String paymentType) {

		String productCost = prop.getProperty(site + "." + productinfo
				+ ".price");
		String discountCost = prop.getProperty(site + "." + productinfo
				+ ".price.discount");

		int cost = Integer.parseInt(productCost);
		int discount = Integer.parseInt(discountCost);

		int totalAmount = cost - discount;

		String totalCost = Integer.toString(totalAmount);

		String productCostXpath = prop.getProperty(site + ".productCost"
				+ paymentType + "Xpath");
		String discountCostXpath = prop.getProperty(site + ".discountCost"
				+ paymentType + "Xpath");
		String discountCosttotalXpath = prop.getProperty(site
				+ ".discountCosttotal" + paymentType + "Xpath");

		if (paymentType.equalsIgnoreCase("Creditcard")) {

			discountCost = "-$" + discountCost;

			if (!(site == Sites.FR)) {
				if (!(site == Sites.ID)) {
					productCost = "$" + productCost;
					totalCost = "$" + totalCost;
				}

				else {
					productCost = "$" + productCost + ".00";
					totalCost = "$" + totalCost + ".00";

				}
			}
		}

		else {

			// String
			// productCosToataltAIC="Order Total - "+productCost+" USD plus USCIS Filing Fee";
			if (!(site == Sites.FR)) {
				productCost = productCost + " USD";
				discountCost = "-" + discountCost + " USD";
				totalCost = totalCost + " USD";
			} else {
				discountCost = "-$" + discountCost;
			}

		}

		String total = driver.findElement(
				By.cssSelector(discountCosttotalXpath)).getText();
		String discountPrice = driver.findElement(
				By.cssSelector(discountCostXpath)).getText();

		// actual cost
		if (!(site == Sites.DUS) && !(site == Sites.ID) && !(site == Sites.FR)) {
			String price = driver.findElement(By.cssSelector(productCostXpath))
					.getText();
			/*
			 * System.out.println("Actual cost" + productCost + "<--->\n<--->" +
			 * price);
			 */

			if (!(price.equals(productCost)))

			{
				System.out
						.println("Product cost in Payment page order summary section has been mismatched from  "
								+ productCost + " to " + price);
			}
		}

		// discount cost
		/*
		 * System.out.println("Discount Cost" + discountCost + "<--->\n<--->" +
		 * discountPrice);
		 */
		if (!(discountPrice.equals(discountCost))) {

			System.out
					.println("Product Cost total in Payment page order summary section has been mismatched from  "
							+ discountCost + " to " + discountPrice);
		}

		// total cost

		/*
		 * System.out.println("Total Cost" + total + "<--->\n<--->" +
		 * totalCost);
		 */
		if (!(total.equals(totalCost))) {

			System.out
					.println("Product Cost total in Payment page order summary section has been mismatched from  "
							+ totalCost + " to " + total);
		}

		return total;
	}

	public AcquisitionUtils testPaypalTotal(String productCost) {
		productCost = productCost.replaceAll("\\.0*$", "");
		productCost = productCost.replaceAll("\\D+", "");

		// System.out.println(productCost + "->->->");

		String productCostXpath = prop.getProperty("paypal.ordertotal.xpath");
		productCost = "Total $" + productCost + ".00 USD";
		String total = driver.findElement(By.cssSelector(productCostXpath))
				.getText();

		if (!(total.equals(productCost))) {

			System.out
					.println("Product Cost total in Paypal Checkout page has been mismatched from  "
							+ productCost + " to " + total);
		}

		return this;
	}

	// to check page label copies
	public AcquisitionUtils testLabel(String page, Sites site, String lang) {

		String[] pageLabel = prop.getProperty(
				site + "_" + page + "pageLabelCopy" + lang).split(";;");
		String[] pageLabelXpath = prop.getProperty(
				site + "_" + page + "pageLabelXpath").split(";;");

		String sts;
		String c3;

		for (int i = 0; i <= pageLabelXpath.length - 1; i++) {

			try {

				List<WebElement> copy = driver.findElements(By
						.cssSelector(pageLabelXpath[i]));

				int Disclaimersize = copy.size();

				for (int k = 0; k <= Disclaimersize - 1; k++) {

					c3 = copy.get(k).getText();
					if (i == 0) {

						sts = pageLabel[k];
					}

					else {
						sts = pageLabel[i];
					}

					if (!(sts.equals(c3))) {
						System.out.println("Page Label Copy Check in "
								+ driver.getCurrentUrl());

						System.out
								.println("Page Label Copy mismatched \nFrom: \n\n"
										+ sts + "\n\nTo:\n\n" + c3);

					}

				}
			}

			catch (Exception e) {

				System.out.println(e);

			}

		}
		return this;
	}

	public AcquisitionUtils sendmail(String msg, String subject) {
		String to = "mohamed.yazar@dcis.net";
		String cc = "pradeep_h@dcis.net";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(
								"yazar.testnew@gmail.com", "!Welcome0");
					}
				});
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress("yazar.testnew@gmail.com"));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					to));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(
					cc));
			message.setSubject("Alert on" + subject);
			message.setText("Automatically generated mail on script check, kindly do not reply \n "
					+ msg);

			Transport.send(message);
			System.out.println("message sent successfully");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

		return this;
	}

	public String readFile(String fileName) throws IOException

	{

		File outputFile = new File(String.format(DEFAULT_OUTPUT_PATH, fileName));
		String outputFilePath = outputFile.getAbsolutePath();
		String line = null;
		BufferedReader br = new BufferedReader(new FileReader(outputFilePath));
		try {
			StringBuilder sb = new StringBuilder();
			line = br.readLine();
			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
			return sb.toString();
		}

		finally {
			br.close();
		}

	}

	// To check cookies
	public Cookie getCookieNamed(String name) {
		return driver.manage().getCookieNamed(name);
	}

	public String getValueOfCookieNamed(String name) {
		String cookievalue = driver.manage().getCookieNamed(name).getValue();
		if (cookievalue.isEmpty()) {
			return null;
		}
		return cookievalue;
	}

	protected Payment checkCardType() {

		return null;

	}

	public void testValidations() {

	}

	public AcquisitionUtils testPaymentCostTrack(String cost) {

		int size;
		if (site == Sites.FR) {
			size = driver.getPageSource().split(
					String.format(transactionExpressionFR, cost)).length - 1;
		}

		else {
			size = driver.getPageSource().split(
					String.format(transactionExpression, cost)).length - 1;
		}
		if (size == 0) {
			String currentURL = driver.getCurrentUrl();
			System.out.println(currentURL);
			System.out.println("Problem in cost track");
			System.out.println("\n");
		} else {
			System.out.println("Cost track success");
		}

		return this;

	}

}

package com.formsdirectinc.functionaltests.apps.payment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.AcquisitionUtils;
import com.formsdirectinc.functionaltests.tags.SignUp;
import com.formsdirectinc.functionaltests.tags.WizardPage;

public class PaymentSuccess extends WizardPage {

	public PaymentSuccess(WebDriver driver) {
		super(driver);

	}

	public void PaymentSuccesstest(String product, String cost)
			throws Exception {

		String emailAlert = System.getProperty("acquisitionMailAlert");
		File outputFile = new File(
				"src/test/resources/prepurchaceOutput/paymentsuccess.txt");
		if (!outputFile.exists()) {
			outputFile.createNewFile();
		}
		String outputFilePath = outputFile.getAbsolutePath();
		FileOutputStream fos = new FileOutputStream(outputFilePath);
		if (!(emailAlert == null) && (emailAlert.equalsIgnoreCase("yes"))) {

			PrintStream ps = new PrintStream(fos);
			System.setOut(ps);

		}

		AcquisitionUtils acquisitionUtils = PageFactory.initElements(driver,
				AcquisitionUtils.class);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Sites site = Sites.valueOf(System.getProperty("site.name"));
		String siteName = System.getProperty("site.name");
		siteName = siteName.replace("STAGING", "");
		String runProductCORE = Products.valueOf(product.toUpperCase())
				.getProductNameInCoreSites();
		String page = PaymentSuccess.class.getSimpleName().toLowerCase();
		System.out.println(page + "--->page");
		site = Sites.valueOf(siteName);
		String[] acqTests = null;
		String testacqScope = System.getProperty("acquisitionTest");
		String acqDefaultScope = "Scripts,PageTitle,FooterLink,FooterDisclaimer";
		String lang = System.getProperty("acquisitionLang");

		if ((lang == null)) {
			lang = "En";
		}
		if (!(lang.equalsIgnoreCase("en") || lang.equalsIgnoreCase("es"))) {
			lang = "En";
		}

		System.out.println(product + "product---->");
		System.out.println(lang + "--->");
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
					System.out.println("Page Title Check");
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

			}

			String s = acquisitionUtils.readFile(page);
			if (!(emailAlert == null || emailAlert.equalsIgnoreCase("no"))
					&& (s != null)) {
				acquisitionUtils.sendmail(s, site + product + page);
			}
		}
		acquisitionUtils.testPaymentCostTrack(cost);
		SignUp payForProduct = new SignUp(driver);
		payForProduct.confirmPayment(runProductCORE);

		fos.close();
	}

}

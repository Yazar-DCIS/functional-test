package com.formsdirectinc.functionaltests.apps.registration;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.AcquisitionUtils;
import com.formsdirectinc.functionaltests.tags.GenerateMail;
import com.formsdirectinc.functionaltests.tags.SignUp;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

public class Registration extends Step {

	public Registration(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void test(String product, String flowname) throws IOException {

		Sites site = Sites.valueOf(System.getProperty("site.name"));

		String emailAlert = System.getProperty("acquisitionMailAlert");
		String siteName = System.getProperty("site.name");
		siteName = siteName.replace("STAGING", "");
		String lang = System.getProperty("acquisitionLang");
		String runProductCORE = Products.valueOf(product.toUpperCase())
				.getProductNameInCoreSites();
		String page = Registration.class.getSimpleName().toLowerCase();

		PropertyResource propertyFile = new PropertyResource();
		Properties data = propertyFile.loadProperty("purchaseApp");
		Properties keys = propertyFile.loadProperty("keyValue");

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
				"src/test/resources/prepurchaceOutput/registration" + product
						+ site + ".txt");
		if (!outputFile.exists()) {
			outputFile.createNewFile();
		}
		String outputFilePath = outputFile.getAbsolutePath();
		FileOutputStream fos = new FileOutputStream(outputFilePath);

		if (!(emailAlert == null) && (emailAlert.equalsIgnoreCase("yes"))) {

			PrintStream ps = new PrintStream(fos);
			System.setOut(ps);
		}

		String signInURL = site.getBaseURL()
				+ keys.getProperty("registerUrl" + lang) + runProductCORE;

		String registrationURLCheck = driver.getCurrentUrl();
		if (registrationURLCheck.equalsIgnoreCase(signInURL)) {
			Reporter.log("Registering the user after EligiblityQuestions");
		} else {
			Reporter.log("Registering the user by skipping EligiblityQuestions");
			driver.get(signInURL);
		}

		site = Sites.valueOf(siteName);
		String[] acqTests = null;
		String testacqScope = System.getProperty("acquisitionTest");
		String acqDefaultScope = "Scripts,PageTitle,FooterLink,FooterDisclaimer,PageLabel";
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

				if (acqStepToRun.equalsIgnoreCase("FooterLink")) {

					if (!(site == Sites.FR)) {

						System.out.println("Footer Links Check");
						acquisitionUtils.testFooterLink(site, lang);
					}
				}

				if (acqStepToRun.equalsIgnoreCase("FooterDisclaimer")) {
					System.out.println("Footer Disclaimer Check");
					acquisitionUtils.testDisclaimer(page, site, lang);
				}

				if (acqStepToRun.equalsIgnoreCase("PageLabel")) {
					System.out.println("PageLabel Check");
					acquisitionUtils.testLabel(page, site, lang);
				}
			}
			String s = acquisitionUtils.readFile(page + product);
			if (!(emailAlert == null || emailAlert.equalsIgnoreCase("no"))) {

				if ((s != null)) {
					acquisitionUtils.sendmail(s, site + product + page);

				}
			}

		}

		GenerateMail writeEmail = PageFactory.initElements(driver,
				GenerateMail.class);

		SignUp createUser = new SignUp(driver, "customerSignup");
		createUser.setFirstNameInCore(data.getProperty("FirstName"));
		createUser.setLastNameInCore(data.getProperty("LastName"));
		createUser.setEMailInCore(writeEmail.generateEmail(product + "."
				+ flowname));
		createUser.setPasswordInCore(data.getProperty("Password"));
		createUser.setConfirmPasswordInCore(data.getProperty("Password"));
		createUser.setPhoneAreaCodeInCore(data.getProperty("PhoneAreaCode"));
		createUser.setPhoneNumber1InCore(data.getProperty("PhoneNumber1"));
		createUser.setPhoneNumber2InCore(data.getProperty("PhoneNumber2"));
		createUser.setConfirmEMailInCore();
		createUser.setQuestionInCore(data.getProperty("HintQuestion" + lang));
		createUser.setAnswerInCore(data.getProperty("HintAnswer"));

		CaptureScreen myscreen = new CaptureScreen(driver);
		myscreen.takeScreenShot(product, "RegistrationPage");

		createUser.createAccountInCore();
		fos.close();
	}

}

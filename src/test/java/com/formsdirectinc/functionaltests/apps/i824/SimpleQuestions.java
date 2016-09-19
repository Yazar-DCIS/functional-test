package com.formsdirectinc.functionaltests.apps.i824;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.i824.pages.SQ10_1;
import com.formsdirectinc.functionaltests.apps.i824.pages.SQ10_2;
import com.formsdirectinc.functionaltests.apps.i824.pages.SQ1_1;
import com.formsdirectinc.functionaltests.apps.i824.pages.SQ2_1;
import com.formsdirectinc.functionaltests.apps.i824.pages.SQ2_2;
import com.formsdirectinc.functionaltests.apps.i824.pages.SQ4_1;
import com.formsdirectinc.functionaltests.apps.i824.pages.SQ4_10;
import com.formsdirectinc.functionaltests.apps.i824.pages.SQ4_2;
import com.formsdirectinc.functionaltests.apps.i824.pages.SQ4_3;
import com.formsdirectinc.functionaltests.apps.i824.pages.SQ4_4;
import com.formsdirectinc.functionaltests.apps.i824.pages.SQ4_5;
import com.formsdirectinc.functionaltests.apps.i824.pages.SQ4_6;
import com.formsdirectinc.functionaltests.apps.i824.pages.SQ5_1;
import com.formsdirectinc.functionaltests.apps.i824.pages.SQ5_2;
import com.formsdirectinc.functionaltests.apps.i824.pages.SQ5_3;
import com.formsdirectinc.functionaltests.apps.i824.pages.SQ5_4;
import com.formsdirectinc.functionaltests.apps.i824.pages.SQ6_1;
import com.formsdirectinc.functionaltests.apps.i824.pages.SQ6_2;
import com.formsdirectinc.functionaltests.apps.i824.pages.SQ6_3;
import com.formsdirectinc.functionaltests.apps.i824.pages.SQ6_4;
import com.formsdirectinc.functionaltests.apps.i824.pages.SQ6_5;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.ApplicationReview;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * @Product I824 SimpleQuestions
 * @author Orina
 */

public class SimpleQuestions  extends Step {


	public SimpleQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String appName = Products.I824.name();
	Sites site = Sites.valueOf(System.getProperty("site.name"));

	public void test(String product, String flowname)
			throws Exception {

		PropertyResource propertyFile=new PropertyResource();
		Properties i824data = propertyFile.loadProperty("name");
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	

		// SQ Section :
		ApplicationReview startHere = PageFactory.initElements(driver,
				ApplicationReview.class);
		startHere.selectStartApplication();
		startHere.selectStartHereLink();

		// Reason for Applying
		SQ1_1 sq1_1 = PageFactory.initElements(driver, SQ1_1.class);
		sq1_1.reasonForApplication();
		sq1_1.saveScreenShot(product, "SQ1_1"); sq1_1.clickContinueInSQ();

		// Qualifying Status
		SQ2_1 sq2_1 = PageFactory.initElements(driver, SQ2_1.class);
		sq2_1.qualifyingStatus();
		sq2_1.saveScreenShot(product, "SQ2_1"); sq1_1.clickContinueInSQ();

		// Reason for Applying
		SQ2_2 sq2_2 = PageFactory.initElements(driver, SQ2_2.class);
		sq2_2.basisForApplication();
		sq2_2.saveScreenShot(product, "SQ2_2"); sq1_1.clickContinueInSQ();

		// Name
		SQ4_1 sq4_1 = PageFactory.initElements(driver, SQ4_1.class);
		sq4_1.applicantNameDetails(i824data);
		sq4_1.saveScreenShot(product, "SQ4_1"); sq1_1.clickContinueInSQ();

		// applicantAddressDetails
		SQ4_2 sq4_2 = PageFactory.initElements(driver, SQ4_2.class);
		sq4_2.applicantAddressDetails(i824data);
		sq4_2.saveScreenShot(product, "SQ4_2"); sq1_1.clickContinueInSQ();

		// applicantNumberDetails
		SQ4_3 sq4_3 = PageFactory.initElements(driver, SQ4_3.class);
		sq4_3.applicantNumberDetails(i824data);
		sq4_3.saveScreenShot(product, "SQ4_3"); sq1_1.clickContinueInSQ();

		// applicantBirthDetails
		SQ4_4 sq4_4 = PageFactory.initElements(driver, SQ4_4.class);
		sq4_4.applicantBirthDetails(i824data);
		sq4_4.saveScreenShot(product, "SQ4_4"); sq1_1.clickContinueInSQ();

		// immigrationStatus
		SQ4_5 sq4_5 = PageFactory.initElements(driver, SQ4_5.class);
		sq4_5.immigrationStatus();
		sq4_5.saveScreenShot(product, "SQ4_5"); sq1_1.clickContinueInSQ();

		// citizenshipStatus
		SQ4_6 sq4_6 = PageFactory.initElements(driver, SQ4_6.class);
		sq4_6.citizenshipStatus();
		sq4_6.saveScreenShot(product, "SQ4_6"); sq1_1.clickContinueInSQ();

		// applicantSSNDetails
		SQ4_10 sq4_10 = PageFactory.initElements(driver, SQ4_10.class);
		sq4_10.applicantSSNDetails(i824data);
		sq4_10.saveScreenShot(product, "SQ4_10"); sq1_1.clickContinueInSQ();

		// petitionType
		SQ5_1 sq5_1 = PageFactory.initElements(driver, SQ5_1.class);
		sq5_1.petitionType(i824data);
		sq5_1.saveScreenShot(product, "sq5_1"); sq1_1.clickContinueInSQ();

		// receiptTypeAndNumber
		SQ5_2 sq5_2 = PageFactory.initElements(driver, SQ5_2.class);
		sq5_2.receiptTypeAndNumber(i824data);
		sq5_2.saveScreenShot(product, "sq5_2"); sq1_1.clickContinueInSQ();

		// dateOfFilling
		SQ5_3 sq5_3 = PageFactory.initElements(driver, SQ5_3.class);
		sq5_3.dateOfFilling(i824data);
		sq5_3.saveScreenShot(product, "sq5_3"); sq1_1.clickContinueInSQ();

		// uscisOffice
		SQ5_4 sq5_4 = PageFactory.initElements(driver, SQ5_4.class);
		sq5_4.uscisOffice(i824data);
		sq5_4.saveScreenShot(product, "sq5_4"); sq1_1.clickContinueInSQ();

		// beneficiary's Name
		SQ6_1 sq6_1 = PageFactory.initElements(driver, SQ6_1.class);
		sq6_1.beneficiaryNameDetails(i824data);
		sq6_1.saveScreenShot(product, "sq6_1"); sq1_1.clickContinueInSQ();

		// beneficiary's AddressDetails
		SQ6_2 sq6_2 = PageFactory.initElements(driver, SQ6_2.class);
		sq6_2.beneficiaryAddressDetails(i824data);
		sq6_2.saveScreenShot(product, "sq6_2"); sq1_1.clickContinueInSQ();

		// beneficiary's NumberDetails
		SQ6_3 sq6_3 = PageFactory.initElements(driver, SQ6_3.class);
		sq6_3.beneficiaryNumberDetails(i824data);
		sq6_3.saveScreenShot(product, "sq6_3"); sq1_1.clickContinueInSQ();

		// beneficiary's BirthDetails
		SQ6_4 sq6_4 = PageFactory.initElements(driver, SQ6_4.class);
		sq6_4.beneficiaryBirthDetails(i824data);
		sq6_4.saveScreenShot(product, "sq6_4"); sq1_1.clickContinueInSQ();

		// beneficiary's ARN
		SQ6_5 sq6_5 = PageFactory.initElements(driver, SQ6_5.class);
		sq6_5.applicantARNDetails(i824data);
		sq6_5.saveScreenShot(product, "sq6_5"); sq1_1.clickContinueInSQ();

		// interpreter help
		SQ10_1 sq10_1 = PageFactory.initElements(driver, SQ10_1.class);
		sq10_1.applicantCertificationDetails();
		sq10_1.saveScreenShot(product, "SQ10_1"); sq1_1.clickContinueInSQ();

		// agree
		SQ10_2 sq10_2 = PageFactory.initElements(driver, SQ10_2.class);
		sq10_2.applicantAgreementDetails();
		sq10_2.saveScreenShot(product, "SQ10_2"); sq1_1.clickContinueInSQ();
		// Application Review
		if (!flowname.contains("InEligible")) {

			ApplicationReview appReview = PageFactory.initElements(driver,
					ApplicationReview.class);
			appReview.completeApplicationUsingNewCSS(appName);
		}
	}

}

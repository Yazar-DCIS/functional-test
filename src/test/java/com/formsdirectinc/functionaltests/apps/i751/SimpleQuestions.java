package com.formsdirectinc.functionaltests.apps.i751;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.i751.pages.SQ1_1;
import com.formsdirectinc.functionaltests.apps.i751.pages.SQ1_2;
import com.formsdirectinc.functionaltests.apps.i751.pages.SQ1_3;
import com.formsdirectinc.functionaltests.apps.i751.pages.SQ1_3_1;
import com.formsdirectinc.functionaltests.apps.i751.pages.SQ1_4;
import com.formsdirectinc.functionaltests.apps.i751.pages.SQ1_4_1;
import com.formsdirectinc.functionaltests.apps.i751.pages.SQ1_5;
import com.formsdirectinc.functionaltests.apps.i751.pages.SQ1_6;
import com.formsdirectinc.functionaltests.apps.i751.pages.SQ1_6_1;
import com.formsdirectinc.functionaltests.apps.i751.pages.SQ1_7;
import com.formsdirectinc.functionaltests.apps.i751.pages.SQ2_1;
import com.formsdirectinc.functionaltests.apps.i751.pages.SQ2_2;
import com.formsdirectinc.functionaltests.apps.i751.pages.SQ2_2_1;
import com.formsdirectinc.functionaltests.apps.i751.pages.SQ2_2_2;
import com.formsdirectinc.functionaltests.apps.i751.pages.SQ3_1;
import com.formsdirectinc.functionaltests.apps.i751.pages.SQ4_1;
import com.formsdirectinc.functionaltests.apps.i751.pages.SQ5_1;
import com.formsdirectinc.functionaltests.apps.i751.pages.SQ5_1_1;
import com.formsdirectinc.functionaltests.apps.i751.pages.SQ5_1_2;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.ApplicationReview;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * @Product I751 SimpleQuestions
 * @author Orina
 */

public class SimpleQuestions  extends Step {

	

	public SimpleQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String appName = Products.I751.name();

	public void test(String product, String flowname)
			throws Exception {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


		PropertyResource propertyFile=new PropertyResource();
		Properties i751data = propertyFile.loadProperty("name");

		

		// SQ Section :
		ApplicationReview startHere = PageFactory.initElements(driver,
				ApplicationReview.class);
		startHere.selectStartApplication();
		startHere.selectStartHereLink();

		// Application name
		SQ1_1 sq1_1 = PageFactory.initElements(driver, SQ1_1.class);
		sq1_1.setNameFields(i751data);
		sq1_1.saveScreenShot(product, "SQ1_1"); sq1_1.clickContinueInSQ();

		// Other Name
		SQ1_2 sq1_2 = PageFactory.initElements(driver, SQ1_2.class);
		sq1_2.hasNotUsedOtherNames();
		sq1_1.saveScreenShot(product, "SQ1_2"); sq1_1.clickContinueInSQ();

		// Residential address
		SQ1_3 sq1_3 = PageFactory.initElements(driver, SQ1_3.class);
		sq1_3.applicantResidenceCountry(i751data);
		sq1_3.applicantResidenceDetails(i751data);
		sq1_1.saveScreenShot(product, "SQ1_3"); sq1_1.clickContinueInSQ();

		// residenceOutsideUS

		SQ1_3_1 sq1_3_1 = PageFactory.initElements(driver, SQ1_3_1.class);
		sq1_3_1.residenceOutsideUS();
		sq1_1.saveScreenShot(product, "SQ1_3_1"); sq1_1.clickContinueInSQ();

		// Birth details

		SQ1_4 sq1_4 = PageFactory.initElements(driver, SQ1_4.class);
		sq1_4.setBirthDetails(i751data);
		sq1_4.setCountryDetailsUpdated(i751data);
		sq1_1.saveScreenShot(product, "SQ1_4"); sq1_1.clickContinueInSQ();
		sq1_4.setNumberFields(i751data);
		sq1_1.saveScreenShot(product, "SQ1_4"); sq1_1.clickContinueInSQ();

		// physicalTraits

		SQ1_4_1 sq1_4_1 = PageFactory.initElements(driver, SQ1_4_1.class);
		sq1_4_1.physicalTraits(i751data);

		// SSN
		SQ1_5 sq1_5 = PageFactory.initElements(driver, SQ1_5.class);
		sq1_5.SSNDetails(i751data);
		sq1_1.saveScreenShot(product, "SQ1_5"); sq1_1.clickContinueInSQ();

		// ARN

		SQ1_6 sq1_6 = PageFactory.initElements(driver, SQ1_6.class);
		sq1_6.ARNDetails(i751data);
		sq1_6.conditionalPermanentResidency(i751data);
		sq1_1.saveScreenShot(product, "SQ1_6"); sq1_1.clickContinueInSQ();

		// Martial status
		SQ1_6_1 sq1_6_1 = PageFactory.initElements(driver, SQ1_6_1.class);
		sq1_6_1.maritalStatus();
		sq1_1.saveScreenShot(product, "SQ1_6_1"); sq1_1.clickContinueInSQ();

		// children

		SQ1_7 sq1_7 = PageFactory.initElements(driver, SQ1_7.class);
		sq1_7.haveChildren();
		sq1_1.saveScreenShot(product, "SQ1_7"); sq1_1.clickContinueInSQ();

		// App type
		SQ2_1 sq2_1 = PageFactory.initElements(driver, SQ2_1.class);
		sq2_1.setAppType();
		sq1_1.saveScreenShot(product, "SQ2_1"); sq1_1.clickContinueInSQ();

		// spouse details

		SQ2_2 sq2_2 = PageFactory.initElements(driver, SQ2_2.class);
		sq2_2.setNameFields(i751data);
		sq2_2.applicantResidenceCountry(i751data);
		sq2_2.applicantResidenceDetails(i751data);
		sq2_2.setBirthDetails(i751data);
		sq2_2.setContactDetails(i751data);
		sq1_1.saveScreenShot(product, "SQ2_2"); sq1_1.clickContinueInSQ();

		// Spouse SSN
		SQ2_2_1 sq2_2_1 = PageFactory.initElements(driver, SQ2_2_1.class);
		sq2_2_1.SSNDetails(i751data);
		sq1_1.saveScreenShot(product, "SQ2_2_1"); sq1_1.clickContinueInSQ();

		// Spouse ARN
		SQ2_2_2 sq2_2_2 = PageFactory.initElements(driver, SQ2_2_2.class);
		sq2_2_2.ARNDetails(i751data);
		sq1_1.saveScreenShot(product, "SQ2_2_2"); sq1_1.clickContinueInSQ();

		// Immigration proceedings
		SQ3_1 sq3_1 = PageFactory.initElements(driver, SQ3_1.class);
		sq3_1.immigrationProceedings();
		sq1_1.saveScreenShot(product, "SQ3_1"); sq1_1.clickContinueInSQ();

		// Accommodation
		SQ4_1 sq4_1 = PageFactory.initElements(driver, SQ4_1.class);
		sq4_1.setNoSQ4_1();
		sq1_1.saveScreenShot(product, "SQ4_1"); sq1_1.clickContinueInSQ();

		// Declaration

		SQ5_1_1 sq5_1_1 = PageFactory.initElements(driver, SQ5_1_1.class);
		sq5_1_1.haveEnglishKnowledge("Yes");

		SQ5_1 sq5_1 = PageFactory.initElements(driver, SQ5_1.class);
		sq5_1.agreeToSubmit("Yes");

		SQ5_1_2 sq5_1_2 = PageFactory.initElements(driver, SQ5_1_2.class);
		sq5_1_2.declarationTwo("Yes");

		// Application Review
		if (!flowname.contains("InEligible")) {

			ApplicationReview appReview = PageFactory.initElements(driver,
					ApplicationReview.class);
			appReview.completeApplicationUsingNewCSS(appName);
		}
	}

}

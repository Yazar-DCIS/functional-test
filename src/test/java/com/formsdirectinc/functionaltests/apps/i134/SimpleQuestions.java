package com.formsdirectinc.functionaltests.apps.i134;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.i134.pages.SQ1_1;
import com.formsdirectinc.functionaltests.apps.i134.pages.SQ1_2;
import com.formsdirectinc.functionaltests.apps.i134.pages.SQ1_5;
import com.formsdirectinc.functionaltests.apps.i134.pages.SQ2_1;
import com.formsdirectinc.functionaltests.apps.i134.pages.SQ2_2;
import com.formsdirectinc.functionaltests.apps.i134.pages.SQ2_3;
import com.formsdirectinc.functionaltests.apps.i134.pages.SQ2_4;
import com.formsdirectinc.functionaltests.apps.i134.pages.SQ2_5;
import com.formsdirectinc.functionaltests.apps.i134.pages.SQ3_1;
import com.formsdirectinc.functionaltests.apps.i134.pages.SQ3_3;
import com.formsdirectinc.functionaltests.apps.i134.pages.SQ4_1;
import com.formsdirectinc.functionaltests.apps.i134.pages.SQ4_3;
import com.formsdirectinc.functionaltests.apps.i134.pages.SQ4_4;
import com.formsdirectinc.functionaltests.apps.i134.pages.SQ4_5;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.ApplicationReview;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * @Product I134 SimpleQuestions
 * @author Orina
 */
public class SimpleQuestions  extends Step {

	

	public SimpleQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String appName = Products.I134.name();

	public void test(String product, String flowname)
			throws Exception {

		PropertyResource propertyFile=new PropertyResource();
		Properties i134data = propertyFile.loadProperty("name");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		

		// SQ Section :
		ApplicationReview startHere = PageFactory.initElements(driver,
				ApplicationReview.class);
		startHere.selectStartApplication();
		startHere.selectStartHereLink();

		SQ1_1 sq1_1 = PageFactory.initElements(driver, SQ1_1.class);
		sq1_1.submittingAOSOnBehalfOf(1);
		sq1_1.saveScreenShot(product, "SQ1_1"); sq1_1.clickContinueInSQ();

		SQ1_2 sq1_2 = PageFactory.initElements(driver, SQ1_2.class);
		sq1_2.currentlyInUS(i134data,"yes",1);
		sq1_2.dateLivedinUsSince(i134data);
		sq1_2.saveScreenShot(product, "SQ1_2"); sq1_1.clickContinueInSQ();

		SQ1_5 sq1_5 = PageFactory.initElements(driver, SQ1_5.class);
		sq1_5.becomeUSCitizen(i134data,1,"");
		sq1_5.saveScreenShot(product, "SQ1_5"); sq1_1.clickContinueInSQ();

		SQ2_1 sq2_1 = PageFactory.initElements(driver, SQ2_1.class);
		sq2_1.basicDetails(i134data);
		sq2_1.saveScreenShot(product, "SQ2_1"); sq1_1.clickContinueInSQ();

		SQ2_2 sq2_2 = PageFactory.initElements(driver, SQ2_2.class);
		sq2_2.NonUsHomeAddress(i134data);
		sq2_2.saveScreenShot(product, "SQ2_2"); sq1_1.clickContinueInSQ();

		SQ2_3 sq2_3 = PageFactory.initElements(driver, SQ2_3.class);
		sq2_3.employmentStatus(2);
		sq2_3.saveScreenShot(product, "SQ2_3"); sq1_1.clickContinueInSQ();

		SQ2_4 sq2_4 = PageFactory.initElements(driver, SQ2_4.class);
		sq2_4.BusinessTypeAndName(i134data);
		sq2_4.UsAddressOfBusiness();
		sq2_4.saveScreenShot(product, "SQ2_4"); sq1_1.clickContinueInSQ();

		SQ2_5 sq2_5 = PageFactory.initElements(driver, SQ2_5.class);
		sq2_5.IncomeDetails(i134data);
		sq2_5.yesInsurance(i134data);
		sq2_5.noRealEstate();
		sq2_5.saveScreenShot(product, "SQ2_5"); sq1_1.clickContinueInSQ();

		SQ3_1 sq3_1 = PageFactory.initElements(driver, SQ3_1.class);
		sq3_1.BeneficiaryBasicDetails(i134data);
		sq3_1.selectMale();
		sq3_1.setMaritalStatusSingle();
		sq3_1.BeneficiaryUsAddress(i134data);
		sq3_1.NotDependent();
		sq3_1.saveScreenShot(product, "SQ3_1"); sq1_1.clickContinueInSQ();

		SQ3_3 sq3_3 = PageFactory.initElements(driver, SQ3_3.class);
		sq3_3.NoSpecificContibutions();
		sq3_3.saveScreenShot(product, "SQ3_3"); sq1_1.clickContinueInSQ();

		SQ4_1 sq4_1 = PageFactory.initElements(driver, SQ4_1.class);
		sq4_1.haveDependent("no");
		sq4_1.saveScreenShot(product, "SQ4_1"); sq1_1.clickContinueInSQ();

		SQ4_3 sq4_3 = PageFactory.initElements(driver, SQ4_3.class);
		sq4_3.haveSubmittedAffidavit(i134data,"no");
		sq4_3.saveScreenShot(product, "SQ4_3"); sq1_1.clickContinueInSQ();

		SQ4_4 sq4_4 = PageFactory.initElements(driver, SQ4_4.class);
		sq4_4.submittedIVPetition(i134data,"no");
		sq4_4.saveScreenShot(product, "SQ4_4"); sq1_1.clickContinueInSQ();

		SQ4_5 sq4_5 = PageFactory.initElements(driver, SQ4_5.class);
		sq4_5.checkAffirmationOne();
		sq4_5.saveScreenShot(product, "SQ4_5"); sq1_1.clickContinueInSQ();

		// Application Review
		if (!flowname.contains("InEligible")) {

			ApplicationReview appReview = PageFactory.initElements(driver,
					ApplicationReview.class);
			appReview.completeApplicationUsingNewCSS(appName);
		}
	}

}
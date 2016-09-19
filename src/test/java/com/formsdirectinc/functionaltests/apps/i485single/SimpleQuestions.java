package com.formsdirectinc.functionaltests.apps.i485single;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ10_1;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ11_1;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ11_2;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ1_1;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ1_16;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ1_1_1;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ2_1;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ2_10;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ2_1_1;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ2_2;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ2_2_2;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ2_2_3;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ2_3;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ2_3_1;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ2_4;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ2_5;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ2_5_1;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ2_6;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ2_7;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ2_8;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ2_9;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ3_1;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ3_2;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ4_1;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ4_2;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ5_5;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ6_1;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ6_2;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ6_3;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ6_4;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ6_5;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ6_5_1;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ6_6;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ6_7;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ6_7_1;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ6_7_2;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ6_8;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ6_9;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ7_1;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ8_1;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ8_2;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.ApplicationReview;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * @Product I485 SimpleQuestions
 * @author Orina
 */

public class SimpleQuestions  extends Step {

	

	public SimpleQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String appName = Products.I485.name();

	public void test(String product, String flowname)
			throws Exception {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PropertyResource propertyFile=new PropertyResource();
		Properties i485data = propertyFile.loadProperty("name");

		
		// SQ Section :
		ApplicationReview startHere = PageFactory.initElements(driver,
				ApplicationReview.class);
		startHere.selectStartApplication();
		startHere.selectStartHereLink();
		
		// Basis for Application
		SQ1_1 sq1_1 = PageFactory.initElements(driver, SQ1_1.class);
		sq1_1.setApplicationBasis(2);
		sq1_1.saveScreenShot("i485single", "I485Single-SQ1_1"); sq1_1.clickContinueInSQ();

		// Immigration Proceedings
		SQ1_1_1 sq1_1_1 = PageFactory.initElements(driver, SQ1_1_1.class);
		sq1_1_1.immigrationProcceding("principal","no");
		sq1_1.saveScreenShot("i485single", "I485Single-SQ1_1_1"); sq1_1.clickContinueInSQ();

		// Immigration Proceedings
		SQ1_16 sq1_16 = PageFactory.initElements(driver, SQ1_16.class);
		sq1_16.physicalPresenceInUS("yes");
		sq1_1.saveScreenShot("i485single", "I485Single-SQ1_16"); sq1_1.clickContinueInSQ();

		// Name
		SQ2_1 sq2_1 = PageFactory.initElements(driver, SQ2_1.class);
		sq2_1.applicantNameDetails(i485data);
		sq1_1.saveScreenShot("i485single", "I485Single-SQ2_1"); sq1_1.clickContinueInSQ();

		// Other Name
		SQ2_1_1 sq2_1_1 = PageFactory.initElements(driver, SQ2_1_1.class);
		sq2_1_1.notUsedOtherNames("principal");
		sq1_1.saveScreenShot("i485single", "I485Single-SQ2_1_1"); sq1_1.clickContinueInSQ();

		// Address
		SQ2_2 sq2_2 = PageFactory.initElements(driver, SQ2_2.class);
		sq2_2.applicantAddressDetails(i485data);
		sq1_1.saveScreenShot("i485single", "I485Single-SQ2_2"); sq1_1.clickContinueInSQ();

		// Address
		SQ2_2_2 sq2_2_2 = PageFactory.initElements(driver, SQ2_2_2.class);
		sq2_2_2.applicantForeignAddressDetails(i485data);
		sq1_1.saveScreenShot("i485single", "I485Single-SQ2_2_2"); sq1_1.clickContinueInSQ();

		// Mailing Address
		SQ2_2_3 sq2_2_3 = PageFactory.initElements(driver, SQ2_2_3.class);
		sq2_2_3.otherMailingAddress();
		sq1_1.saveScreenShot("i485single", "I485Single-SQ2_2_3"); sq1_1.clickContinueInSQ();
				
		// Biographical Information
		SQ2_3 sq2_3 = PageFactory.initElements(driver, SQ2_3.class);
		sq2_3.biographicalInformation(i485data);
		sq1_1.saveScreenShot("i485single", "I485Single-SQ2_3"); sq1_1.clickContinueInSQ();

		// Contact
		sq1_1.saveScreenShot("i485single", "I485Single-Contact"); sq1_1.clickContinueInSQ();

		// Father Mother
		SQ2_3_1 sq2_3_1 = PageFactory.initElements(driver, SQ2_3_1.class);
		sq2_3_1.applicantParentsInformation(i485data);
		sq1_1.saveScreenShot("i485single", "I485Single-SQ2_3_1"); sq1_1.clickContinueInSQ();

		// Marital Status
		SQ2_4 sq2_4 = PageFactory.initElements(driver, SQ2_4.class);
		sq2_4.maritalInformation(i485data,"Single");
		sq1_1.saveScreenShot("i485single", "I485Single-SQ2_4"); sq1_1.clickContinueInSQ();

		// SSN
		SQ2_5 sq2_5 = PageFactory.initElements(driver, SQ2_5.class);
		sq2_5.ssnStatus("principal","no");
		sq1_1.saveScreenShot("i485single", "I485Single-SQ2_5"); sq1_1.clickContinueInSQ();

		// IRS Tax#
		SQ2_5_1 sq2_5_1 = PageFactory.initElements(driver, SQ2_5_1.class);
		sq2_5_1.irsStatus();
		sq1_1.saveScreenShot("i485single", "I485Single-SQ2_5_1"); sq1_1.clickContinueInSQ();
				
		// ARN
		SQ2_6 sq2_6 = PageFactory.initElements(driver, SQ2_6.class);
		sq2_6.arnStatus(i485data);
		sq1_1.saveScreenShot("i485single", "I485Single-SQ2_6"); sq1_1.clickContinueInSQ();

		
		// Employment
		SQ2_7 sq2_7 = PageFactory.initElements(driver, SQ2_7.class);
		sq2_7.employmentStatus("principal");
		sq1_1.saveScreenShot("i485single", "I485Single-SQ2_7"); sq1_1.clickContinueInSQ();

		// Employment Abroad
		SQ2_8 sq2_8 = PageFactory.initElements(driver, SQ2_8.class);
		sq2_8.employmentStatusAbroad("principal");
		sq1_1.saveScreenShot("i485single", "I485Single-SQ2_8"); sq1_1.clickContinueInSQ();

		// Income
		SQ2_9 sq2_9 = PageFactory.initElements(driver, SQ2_9.class);
		sq2_9.incomeInformation(i485data);

		sq1_1.saveScreenShot("i485single", "I485Single-SQ2_9"); sq1_1.clickContinueInSQ();

		// Assets
		SQ2_10 sq2_10 = PageFactory.initElements(driver, SQ2_10.class);
		sq2_10.assetsStatus();

		sq1_1.saveScreenShot("i485single", "I485Single-SQ2_10"); sq1_1.clickContinueInSQ();
		
		// LastEntryInformation
		SQ3_1 sq3_1 = PageFactory.initElements(driver, SQ3_1.class);
		sq3_1.lastEntryInformation(i485data,"principal");
		sq1_1.saveScreenShot("i485single", "I485Single-SQ3_1"); sq1_1.clickContinueInSQ();

		// Class of Admission and Current Status
		SQ3_2 sq3_2 = PageFactory.initElements(driver, SQ3_2.class);
		sq3_2.classOfAdmission(i485data,"principal");
		sq1_1.saveScreenShot("i485single", "I485Single-SQ3_2"); sq1_1.clickContinueInSQ();

		// Nonimmigrant Visa Number
		SQ4_1 sq4_1 = PageFactory.initElements(driver, SQ4_1.class);
		sq4_1.visaNumber(i485data,"principal");
		sq1_1.saveScreenShot("i485single", "I485Single-SQ4_1"); sq1_1.clickContinueInSQ();

		// Immigration History
		SQ4_2 sq4_2 = PageFactory.initElements(driver, SQ4_2.class);
		sq4_2.immigrationHistory("principal");
		sq1_1.saveScreenShot("i485single", "I485Single-SQ4_2"); sq1_1.clickContinueInSQ();

		// Information About Your Children
		SQ5_5 sq5_5 = PageFactory.initElements(driver, SQ5_5.class);
		sq5_5.haveChild("no","principal");
		sq1_1.saveScreenShot("i485single", "I485Single-SQ5_5"); sq1_1.clickContinueInSQ();

		// Membership
		SQ6_1 sq6_1 = PageFactory.initElements(driver, SQ6_1.class);
		sq6_1.membershipDetails("principal");
		sq1_1.saveScreenShot("i485single", "I485Single-SQ6_1"); sq1_1.clickContinueInSQ();

		// Criminal History
		SQ6_2 sq6_2 = PageFactory.initElements(driver, SQ6_2.class);
		sq6_2.criminalHistory("principal");
		sq1_1.saveScreenShot("i485single", "I485Single-SQ6_2"); sq1_1.clickContinueInSQ();

		// Criminal History
		SQ6_3 sq6_3 = PageFactory.initElements(driver, SQ6_3.class);
		sq6_3.criminalHistory("principal");
		sq1_1.saveScreenShot("i485single", "I485Single-SQ6_3"); sq1_1.clickContinueInSQ();
				
		// Criminal Intent
		SQ6_4 sq6_4 = PageFactory.initElements(driver, SQ6_4.class);
		sq6_4.criminalIntent("principal");
		sq1_1.saveScreenShot("i485single", "I485Single-SQ6_4"); sq1_1.clickContinueInSQ();

		// Miscellaneous
		SQ6_5 sq6_5 = PageFactory.initElements(driver, SQ6_5.class);
		sq6_5.miscellaneous("principal");

		sq1_1.saveScreenShot("i485single", "I485Single-SQ6_5"); sq1_1.clickContinueInSQ();

		// Miscellaneous
		SQ6_5_1 sq6_5_1 = PageFactory.initElements(driver, SQ6_5_1.class);
		sq6_5_1.miscellaneous("principal");

		sq1_1.saveScreenShot("i485single", "I485Single-SQ6_5_1"); sq1_1.clickContinueInSQ();

		// Immigration Violations
		SQ6_6 sq6_6 = PageFactory.initElements(driver, SQ6_6.class);
		sq6_6.immigrationViolations("principal");

		sq1_1.saveScreenShot("i485single", "I485Single-SQ6_6"); sq1_1.clickContinueInSQ();

		// Other Violations
		SQ6_7 sq6_7 = PageFactory.initElements(driver, SQ6_7.class);
		sq6_7.immigrationViolations("principal");

		sq1_1.saveScreenShot("i485single", "I485Single-SQ6_7"); sq1_1.clickContinueInSQ();

		// Miscellaneous
		SQ6_7_1 sq6_7_1 = PageFactory.initElements(driver, SQ6_7_1.class);
		sq6_7_1.miscellaneous("principal");

		sq1_1.saveScreenShot("i485single", "I485Single-SQ6_7_1"); sq1_1.clickContinueInSQ();

		// Miscellaneous
		SQ6_7_2 sq6_7_2 = PageFactory.initElements(driver, SQ6_7_2.class);
		sq6_7_2.miscellaneous("principal");
		sq1_1.saveScreenShot("i485single", "I485Single-SQ6_7_2"); sq1_1.clickContinueInSQ();

		// Previous Petitions
		SQ6_8 sq6_8 = PageFactory.initElements(driver, SQ6_8.class);
		sq6_8.previousPetitions("principal");
		sq1_1.saveScreenShot("i485single", "I485Single-SQ6_8"); sq1_1.clickContinueInSQ();

		// Prior Affidavits of Support
		SQ6_9 sq6_9 = PageFactory.initElements(driver, SQ6_9.class);
		sq6_9.previousAffidavit("principal");
		sq1_1.saveScreenShot("i485single", "I485Single-SQ6_9"); sq1_1.clickContinueInSQ();

		// Prior Employment Authorization Applications
		SQ7_1 sq7_1 = PageFactory.initElements(driver, SQ7_1.class);
		sq7_1.previousEmploymentAuthorization("principal");

		sq1_1.saveScreenShot("i485single", "I485Single-SQ7_1"); sq1_1.clickContinueInSQ();

		// Prior Travel Documents
		SQ8_1 sq8_1 = PageFactory.initElements(driver, SQ8_1.class);
		sq8_1.travelDocumentIssuedBefore(i485data, "yes");
		sq1_1.saveScreenShot("i485single", "I485Single-SQ8_1"); sq1_1.clickContinueInSQ();

		// Details About Your Travel Plans
		SQ8_2 sq8_2 = PageFactory.initElements(driver, SQ8_2.class);
		sq8_2.travelDocumentIntendToTravel(i485data, "no");
		sq1_1.saveScreenShot("i485single", "I485Single-SQ8_2"); sq1_1.clickContinueInSQ();
				
		// Requesting an Accommodation
		SQ10_1 sq10_1 = PageFactory.initElements(driver, SQ10_1.class);
		sq10_1.requestAccomodation("principal");

		sq1_1.saveScreenShot("i485single", "I485Single-SQ10_1"); sq1_1.clickContinueInSQ();

		// Certification
		SQ11_1 sq11_1 = PageFactory.initElements(driver, SQ11_1.class);
		sq11_1.certification("principal");

		sq1_1.saveScreenShot("i485single", "I485Single-SQ11_1"); sq1_1.clickContinueInSQ();

		// Certification
		SQ11_2 sq11_2 = PageFactory.initElements(driver, SQ11_2.class);
		sq11_2.certification("principal");
		sq1_1.saveScreenShot("i485single", "I485Single-SQ11_2"); sq1_1.clickContinueInSQ();


		// Application Review
		if (!flowname.contains("InEligible")) {

			ApplicationReview appReview = PageFactory.initElements(driver,
					ApplicationReview.class);
			appReview.completeApplicationUsingNewCSS(appName);
		}

	}

}

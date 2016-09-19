package com.formsdirectinc.functionaltests.apps.i539;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.i539.pages.SQ1_1;
import com.formsdirectinc.functionaltests.apps.i539.pages.SQ1_2;
import com.formsdirectinc.functionaltests.apps.i539.pages.SQ1_3;
import com.formsdirectinc.functionaltests.apps.i539.pages.SQ2_1;
import com.formsdirectinc.functionaltests.apps.i539.pages.SQ2_2;
import com.formsdirectinc.functionaltests.apps.i539.pages.SQ2_3;
import com.formsdirectinc.functionaltests.apps.i539.pages.SQ2_4;
import com.formsdirectinc.functionaltests.apps.i539.pages.SQ2_5;
import com.formsdirectinc.functionaltests.apps.i539.pages.SQ2_6;
import com.formsdirectinc.functionaltests.apps.i539.pages.SQ2_7;
import com.formsdirectinc.functionaltests.apps.i539.pages.SQ2_8;
import com.formsdirectinc.functionaltests.apps.i539.pages.SQ2_9;
import com.formsdirectinc.functionaltests.apps.i539.pages.SQ3_1;
import com.formsdirectinc.functionaltests.apps.i539.pages.SQ3_2;
import com.formsdirectinc.functionaltests.apps.i539.pages.SQ3_3;
import com.formsdirectinc.functionaltests.apps.i539.pages.SQ4_1_1;
import com.formsdirectinc.functionaltests.apps.i539.pages.SQ4_2;
import com.formsdirectinc.functionaltests.apps.i539.pages.SQ5_1;
import com.formsdirectinc.functionaltests.apps.i539.pages.SQ5_2;
import com.formsdirectinc.functionaltests.apps.i539.pages.SQ6_1;
import com.formsdirectinc.functionaltests.apps.i539.pages.SQ6_2;
import com.formsdirectinc.functionaltests.apps.i539.pages.SQ6_3;
import com.formsdirectinc.functionaltests.apps.i539.pages.SQ6_4;
import com.formsdirectinc.functionaltests.apps.i539.pages.SQ6_5;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.ApplicationReview;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * @Product I539 SimpleQuestions
 * @author Orina
 */

public class SimpleQuestions  extends Step {

	
	public SimpleQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String appName = Products.I539.name();

	public void test(String product, String flowname)
			throws Exception {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		PropertyResource propertyFile=new PropertyResource();
		Properties i539data = propertyFile.loadProperty("name");

		

		// SQ Section :
		ApplicationReview startHere = PageFactory.initElements(driver,
				ApplicationReview.class);
		startHere.selectStartApplication();
		startHere.selectStartHereLink();

		// <--Eligibility-->Status
		SQ1_1 sq1_1 = PageFactory.initElements(driver, SQ1_1.class);
		sq1_1.set_currentlyInUS();
		sq1_1.saveScreenShot("i539", "SQ1_1"); sq1_1.clickContinueInSQ();

		// Reason for Applying
		SQ1_2 sq1_2 = PageFactory.initElements(driver, SQ1_2.class);
		sq1_2.set_ReasonForApplication();
		sq1_1.saveScreenShot("i539", "SQ1_2"); sq1_1.clickContinueInSQ();

		// Current Non-immigrant Status
		SQ1_3 sq1_3 = PageFactory.initElements(driver, SQ1_3.class);
		sq1_3.set_NonImmigrantStatus();
		sq1_1.saveScreenShot("i539", "SQ1_3"); sq1_1.clickContinueInSQ();
		// <--About You-->Name

		SQ2_1 sq2_1 = PageFactory.initElements(driver, SQ2_1.class);
		sq2_1.set_ApplicantName(i539data);
		sq1_1.saveScreenShot("i539", "SQ2_1"); sq1_1.clickContinueInSQ();

		// Date and Place of Birth
		SQ2_2 sq2_2 = PageFactory.initElements(driver, SQ2_2.class);
		sq2_2.set_DateOfBirth(i539data);
		sq2_2.set_CountryOfBirth(i539data);
		sq2_2.set_CitizenOfCountry(i539data);
		sq1_1.saveScreenShot("i539", "SQ2_2"); sq1_1.clickContinueInSQ();

		// Arrival/Departure Record (I-94) Number
		SQ2_3 sq2_3 = PageFactory.initElements(driver, SQ2_3.class);
		sq2_3.set_Applicanti94No();
		sq1_1.saveScreenShot("i539", "SQ2_3"); sq1_1.clickContinueInSQ();

		// Social Security Number
		SQ2_4 sq2_4 = PageFactory.initElements(driver, SQ2_4.class);
		sq2_4.setSSNInfo(i539data, "no");
		sq1_1.saveScreenShot("i539", "SQ2_4"); sq1_1.clickContinueInSQ();

		// Alien Registration Number
		SQ2_5 sq2_5 = PageFactory.initElements(driver, SQ2_5.class);
		sq2_5.setARNInfo(i539data,"no");
		sq1_1.saveScreenShot("i539", "SQ2_5"); sq1_1.clickContinueInSQ();

		// Current Address
		SQ2_6 sq2_6 = PageFactory.initElements(driver, SQ2_6.class);
		sq2_6.set_homeAddressUpdates(i539data);
		sq2_6.set_homeAddressInCareOf();
		sq2_6.set_MailingAddress();

		sq1_1.saveScreenShot("i539", "SQ2_6"); sq1_1.clickContinueInSQ();

		// E-mail and Phone Number
		SQ2_7 sq2_7 = PageFactory.initElements(driver, SQ2_7.class);
		sq2_7.set_EmailUpdates(i539data);
		sq2_7.set_dayPhoneUpdates(i539data);
		sq2_7.set_notifications();
		sq1_1.saveScreenShot("i539", "SQ2_7"); sq1_1.clickContinueInSQ();

		// Foreign Address
		SQ2_8 sq2_8 = PageFactory.initElements(driver, SQ2_8.class);
		sq2_8.set_AbroadAddress(i539data);
		sq1_1.saveScreenShot("i539", "SQ2_8"); sq1_1.clickContinueInSQ();

		// Travel Document Information
		SQ2_9 sq2_9 = PageFactory.initElements(driver, SQ2_9.class);
		sq2_9.set_usEntryDocument();
		sq2_9.set_Passport(i539data);
		sq2_9.set_PassportIssued(i539data);
		sq1_1.saveScreenShot("i539", "SQ2_9"); sq1_1.clickContinueInSQ();

		// <--lastEnteredOn-->Expiration of Current Status
		SQ3_1 sq3_1 = PageFactory.initElements(driver, SQ3_1.class);
		sq3_1.set_StatusExpireOn(i539data);
		sq1_1.saveScreenShot("i539", "SQ3_1"); sq1_1.clickContinueInSQ();

		// Date of Extension
		SQ3_2 sq3_2 = PageFactory.initElements(driver, SQ3_2.class);
		sq3_2.set_ExtendStatusBy(i539data);
		sq1_1.saveScreenShot("i539", "SQ3_2"); sq1_1.clickContinueInSQ();

		// Date of Last Arrival
		SQ3_3 sq3_3 = PageFactory.initElements(driver, SQ3_3.class);
		sq3_3.set_LastEnteredOn(i539data);
		sq1_1.saveScreenShot("i539", "SQ3_3"); sq1_1.clickContinueInSQ();

		// <--Family Members-->
		SQ4_1_1 sq4_1_1 = PageFactory.initElements(driver, SQ4_1_1.class);
		sq4_1_1.set_WithSpouseOrChildren();
		sq1_1.saveScreenShot("i539", "SQ4_1_1"); sq1_1.clickContinueInSQ();

		// Family Members Applying with You
		SQ4_2 sq4_2 = PageFactory.initElements(driver, SQ4_2.class);
		sq4_2.set_F_Member_Name(i539data);
		sq4_2.set_F_Member_DateOfBirth(i539data);
		sq4_2.set_countryOfBirth(i539data);
		sq4_2.set_countryOfCitizenship(i539data);
		sq4_2.set_F_Member_SSN(i539data);
		sq4_2.set_F_Member_ARN(i539data);
		sq4_2.set_F_Member_i94_No();
		sq4_2.set_i94Updates(i539data);

		sq4_2.set_UsEntryDocument(i539data);
		sq4_2.set_Passport_No(i539data);
		sq1_1.saveScreenShot("i539", "SQ4_2"); sq1_1.clickContinueInSQ();

		// <--Processing Information-->
		SQ5_1 sq5_1 = PageFactory.initElements(driver, SQ5_1.class);
		sq5_1.set_PrimaryHolder();
		sq1_1.saveScreenShot("i539", "SQ5_1"); sq1_1.clickContinueInSQ();

		// About the Primary Visa Petition
		SQ5_2 sq5_2 = PageFactory.initElements(driver, SQ5_2.class);
		sq5_2.set_JointPetition_Status();
		sq5_2.set_PetitionerDetails(i539data);
		sq5_2.set_ReceiptNumber(i539data);
		sq5_2.set_filedOn(i539data);
		sq1_1.saveScreenShot("i539", "SQ5_2"); sq1_1.clickContinueInSQ();

		// <-- General Information -->
		SQ6_1 sq6_1 = PageFactory.initElements(driver, SQ6_1.class);
		sq6_1.immigrationHistory();
		sq1_1.saveScreenShot("i539", "SQ6_1"); sq1_1.clickContinueInSQ();

		// Employment Details
		SQ6_2 sq6_2 = PageFactory.initElements(driver, SQ6_2.class);
		sq6_2.setEmploymentDetails(i539data);
		sq1_1.saveScreenShot("i539", "SQ6_2"); sq1_1.clickContinueInSQ();

		// Past Immigration Violations
		SQ6_3 sq6_3 = PageFactory.initElements(driver, SQ6_3.class);
		sq6_3.pastImmigrationViolations();
		sq1_1.saveScreenShot("i539", "SQ6_3"); sq1_1.clickContinueInSQ();

		// Criminal History
		SQ6_4 sq6_4 = PageFactory.initElements(driver, SQ6_4.class);
		sq6_4.criminalHistory();
		sq1_1.saveScreenShot("i539", "SQ6_4"); sq1_1.clickContinueInSQ();

		// Weapon Related Activities
		SQ6_5 sq6_5 = PageFactory.initElements(driver, SQ6_5.class);
		sq6_5.weaponRelatedActivities();
		sq1_1.saveScreenShot("i539", "SQ6_5"); sq1_1.clickContinueInSQ();
		// Application Review
		if (!flowname.contains("InEligible")) {

			ApplicationReview appReview = PageFactory.initElements(driver,
					ApplicationReview.class);
			appReview.completeApplicationUsingNewCSS(appName);
		}
	}

}

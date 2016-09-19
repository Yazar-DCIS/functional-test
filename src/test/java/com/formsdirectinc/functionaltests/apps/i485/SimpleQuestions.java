package com.formsdirectinc.functionaltests.apps.i485;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ10_1;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ11_1;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ11_2;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ1_1;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ1_16;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ1_1_1;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ2_1;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ2_1_1;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ2_2;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ2_2_2;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ2_3;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ2_3_1;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ2_4;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ2_5;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ2_6;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ2_6_2;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ2_7;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ2_8;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ3_1;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ3_2;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ4_1;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ4_2;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ5_5;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ6_1;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ6_2;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ6_3;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ6_4;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ6_5;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ6_5_1;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ6_6;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ6_7;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ6_7_1;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ6_7_2;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ7_1;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ8_1;
import com.formsdirectinc.functionaltests.apps.i485.pages.SQ8_2;
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

		// Basis for Application
		SQ1_1 sq1_1 = PageFactory.initElements(driver, SQ1_1.class);
		sq1_1.setApplicationBasis(2);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Immigration Proceedings
		SQ1_1_1 sq1_1_1 = PageFactory.initElements(driver, SQ1_1_1.class);
		sq1_1_1.haveimmigrationProceedings("no");
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Immigration Proceedings
		SQ1_16 sq1_16 = PageFactory.initElements(driver, SQ1_16.class);
		sq1_16.physicalPresenceInUS("yes");
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Name
		SQ2_1 sq2_1 = PageFactory.initElements(driver, SQ2_1.class);
		sq2_1.setNameOnDocument(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Other Name
		SQ2_1_1 sq2_1_1 = PageFactory.initElements(driver, SQ2_1_1.class);
		sq2_1_1.haveotherName("no");
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Address
		SQ2_2 sq2_2 = PageFactory.initElements(driver, SQ2_2.class);
		sq2_2.setAddress(i485data);
		sq2_2.sameAddress(i485data);
		sq2_2.addressCare();
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Address
		SQ2_2_2 sq2_2_2 = PageFactory.initElements(driver, SQ2_2_2.class);
		sq2_2_2.setForeignAddress(i485data);
		sq2_2_2.fromDateAddress(i485data);
		sq2_2_2.toDateAddress(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Biographical Information
		SQ2_3 sq2_3 = PageFactory.initElements(driver, SQ2_3.class);
		sq2_3.setDateOfBirth(i485data);
		sq2_3.setAddress(i485data);
		sq2_3.genderMaleFemale(i485data);
		sq2_3.setNumberFields(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Contact
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Father Mother
		SQ2_3_1 sq2_3_1 = PageFactory.initElements(driver, SQ2_3_1.class);
		sq2_3_1.setFatherNameFields(i485data);
		sq2_3_1.fatherAliveNo();
		sq2_3_1.setMotherNameFields(i485data);
		sq2_3_1.motherAliveNo();
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Marital Status
		SQ2_4 sq2_4 = PageFactory.initElements(driver, SQ2_4.class);
		sq2_4.applicantMaritalStatus(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// SSN
		SQ2_5 sq2_5 = PageFactory.initElements(driver, SQ2_5.class);
		sq2_5.haveSSN(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// ARN
		SQ2_6 sq2_6 = PageFactory.initElements(driver, SQ2_6.class);
		sq2_6.haveARN(i485data,"yes");
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// ELIS
		SQ2_6_2 sq2_6_2 = PageFactory.initElements(driver, SQ2_6_2.class);
		sq2_6_2.haveELIS(i485data, "yes");
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Employment
		SQ2_7 sq2_7 = PageFactory.initElements(driver, SQ2_7.class);
		sq2_7.noEmployment(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Employment Abroad
		SQ2_8 sq2_8 = PageFactory.initElements(driver, SQ2_8.class);
		sq2_8.notOutside(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Employment Abroad
		SQ3_1 sq3_1 = PageFactory.initElements(driver, SQ3_1.class);
		sq3_1.setentryDate(i485data);
		sq3_1.setAddress(i485data);
		sq3_1.noEmployment(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Class of Admission and Current Status
		SQ3_2 sq3_2 = PageFactory.initElements(driver, SQ3_2.class);
		sq3_2.admissionCurrentStatus(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Nonimmigrant Visa Number
		SQ4_1 sq4_1 = PageFactory.initElements(driver, SQ4_1.class);
		sq4_1.nonImmigrantVisaNumber(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Immigration History
		SQ4_2 sq4_2 = PageFactory.initElements(driver, SQ4_2.class);
		sq4_2.noHistory(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Information About Your Children
		SQ5_5 sq5_5 = PageFactory.initElements(driver, SQ5_5.class);
		sq5_5.childrenInfo(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Membership
		SQ6_1 sq6_1 = PageFactory.initElements(driver, SQ6_1.class);
		sq6_1.pastMembership(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Criminal History
		SQ6_2 sq6_2 = PageFactory.initElements(driver, SQ6_2.class);
		sq6_2.criminalHistory(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Criminal History
		SQ6_3 sq6_3 = PageFactory.initElements(driver, SQ6_3.class);
		sq6_3.criminalHistory1(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Criminal Intent
		SQ6_4 sq6_4 = PageFactory.initElements(driver, SQ6_4.class);
		sq6_4.criminalIntent(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Miscellaneous
		SQ6_5 sq6_5 = PageFactory.initElements(driver, SQ6_5.class);
		sq6_5.miscellaneous(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Miscellaneous
		SQ6_5_1 sq6_5_1 = PageFactory.initElements(driver, SQ6_5_1.class);
		sq6_5_1.miscellaneous1(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Immigration Violations
		SQ6_6 sq6_6 = PageFactory.initElements(driver, SQ6_6.class);
		sq6_6.immigrationViolation(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Other Violations
		SQ6_7 sq6_7 = PageFactory.initElements(driver, SQ6_7.class);
		sq6_7.otherViolations(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Miscellaneous
		SQ6_7_1 sq6_7_1 = PageFactory.initElements(driver, SQ6_7_1.class);
		sq6_7_1.miscellaneous2(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Miscellaneous
		SQ6_7_2 sq6_7_2 = PageFactory.initElements(driver, SQ6_7_2.class);
		sq6_7_2.miscellaneous3(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Prior Employment Authorization Applications
		SQ7_1 sq7_1 = PageFactory.initElements(driver, SQ7_1.class);
		sq7_1.priorEmployment(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Prior Travel Documents
		SQ8_1 sq8_1 = PageFactory.initElements(driver, SQ8_1.class);
		sq8_1.priorTravel(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Details About Your Travel Plans
		SQ8_2 sq8_2 = PageFactory.initElements(driver, SQ8_2.class);
		sq8_2.plannedTravel(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Requesting an Accommodation
		SQ10_1 sq10_1 = PageFactory.initElements(driver, SQ10_1.class);
		sq10_1.requestAccommodation(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Certification
		SQ11_1 sq11_1 = PageFactory.initElements(driver, SQ11_1.class);
		sq11_1.Certification(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Certification
		SQ11_2 sq11_2 = PageFactory.initElements(driver, SQ11_2.class);
		sq11_2.certification1(i485data);
		sq1_1.saveScreenShot("i485", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Application Review
		if (!flowname.contains("InEligible")) {

			ApplicationReview appReview = PageFactory.initElements(driver,
					ApplicationReview.class);
			appReview.completeApplicationUsingPrint(appName);
		}

	}

}

package com.formsdirectinc.functionaltests.apps.i485multi;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ10_1;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ11_1;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ11_2;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ1_1;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ1_14;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ1_1_1;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ1_2;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ1_4;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ1_6;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ1_7;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ1_9;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ2_1;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ2_10;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ2_1_1;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ2_2;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ2_2_2;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ2_2_3;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ2_3;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ2_3_0;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ2_3_1;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ2_4;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ2_4_1;
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
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ5_1;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ5_1_1;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ5_2_1;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ5_3;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ5_4;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ5_5;
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ5_6;
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
import com.formsdirectinc.functionaltests.apps.i485multi.pages.SQ9_1;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.ApplicationReview;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * @Product I485-Multi SimpleQuestions
 * @author Orina
 */

public class SimpleQuestions  extends Step {

	

	public SimpleQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	String appName = Products.I485MULTI.name();

	public void test(String product, String flowname)
			throws Exception {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PropertyResource propertyFile=new PropertyResource();
		Properties i485Multidata = propertyFile.loadProperty("name");
		Sites site = Sites.valueOf(System.getProperty("site.name"));
		
		// SQ Section :
		ApplicationReview startHere = PageFactory.initElements(driver,
				ApplicationReview.class);
		startHere.selectStartApplication();
		startHere.selectStartHereLink();
		
		/*startHere.selectContinueApplication();
		driver.get("baseURL/product/controller.do?tree=pageNumbr");*/
		
		// Basis for Application
		SQ1_1 sq1_1 = PageFactory.initElements(driver, SQ1_1.class);
		sq1_1.setApplicationBasis(6);

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Immigration Proceedings
		SQ1_1_1 sq1_1_1 = PageFactory.initElements(driver, SQ1_1_1.class);
		sq1_1_1.immigrationProcceding("principal","no");

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Presence in the U.S.
		SQ1_2 sq1_2 = PageFactory.initElements(driver, SQ1_2.class);
		sq1_2.presenceInUS();

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Inspection
		SQ1_4 sq1_4 = PageFactory.initElements(driver, SQ1_4.class);
		sq1_4.inspectionInUS();

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Relationship to Sponsor
		SQ1_6 sq1_6 = PageFactory.initElements(driver, SQ1_6.class);
		sq1_6.sponsorImmediateRelative();
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Status
		SQ1_7 sq1_7 = PageFactory.initElements(driver, SQ1_7.class);
		sq1_7.inLawfulStatus();
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Work Authorization
		if(site==Sites.ID||site==Sites.AIC||site==Sites.FR||site==Sites.USC||site==Sites.DUS){
		SQ1_9 sq1_9 = PageFactory.initElements(driver, SQ1_9.class);
		sq1_9.unauthorizedWorker("no");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();
		}				
		// Name
		SQ2_1 sq2_1 = PageFactory.initElements(driver, SQ2_1.class);
		sq2_1.applicantNameDetails(i485Multidata);
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Other Names
		SQ2_1_1 sq2_1_1 = PageFactory.initElements(driver, SQ2_1_1.class);
		sq2_1_1.notUsedOtherNames("principal");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Address
		SQ2_2 sq2_2 = PageFactory.initElements(driver, SQ2_2.class);
		sq2_2.applicantAddressDetails(i485Multidata);

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Foreign Address
		SQ2_2_2 sq2_2_2 = PageFactory.initElements(driver, SQ2_2_2.class);
		sq2_2_2.applicantForeignAddressDetails(i485Multidata);

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Mailing Address
		SQ2_2_3 sq2_2_3 = PageFactory.initElements(driver, SQ2_2_3.class);
		sq2_2_3.otherMailingAddress();

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Biographical Information
		SQ2_3 sq2_3 = PageFactory.initElements(driver, SQ2_3.class);
		sq2_3.biographicalInformation(i485Multidata);

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Optional Contact Information for USCIS Notifications
		SQ2_3_0 sq2_3_0 = PageFactory.initElements(driver, SQ2_3_0.class);
		sq2_3_0.optionalContactInformation(i485Multidata);

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Parents
		SQ2_3_1 sq2_3_1 = PageFactory.initElements(driver, SQ2_3_1.class);
		sq2_3_1.applicantParentsInformation(i485Multidata);

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Marital Status
		SQ2_4 sq2_4 = PageFactory.initElements(driver, SQ2_4.class);
		sq2_4.maritalInformation(i485Multidata,"Married");

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Information About Your Previous Spouse
		SQ2_4_1 sq2_4_1 = PageFactory.initElements(driver, SQ2_4_1.class);
		sq2_4_1.previousMarriedInformation("No");

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Social Security Number
		SQ2_5 sq2_5 = PageFactory.initElements(driver, SQ2_5.class);
		sq2_5.ssnStatus("principal","no");

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// IRS Tax#
		SQ2_5_1 sq2_5_1 = PageFactory.initElements(driver, SQ2_5_1.class);
		sq2_5_1.irsStatus();

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Alien Registration Number
		SQ2_6 sq2_6 = PageFactory.initElements(driver, SQ2_6.class);
		sq2_6.arnStatus(i485Multidata);

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Employment
		SQ2_7 sq2_7 = PageFactory.initElements(driver, SQ2_7.class);
		sq2_7.employmentStatus("principal");

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Employment Abroad
		SQ2_8 sq2_8 = PageFactory.initElements(driver, SQ2_8.class);
		sq2_8.employmentStatusAbroad("principal");

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Income
		SQ2_9 sq2_9 = PageFactory.initElements(driver, SQ2_9.class);
		sq2_9.incomeInformation(i485Multidata);

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Assets
		SQ2_10 sq2_10 = PageFactory.initElements(driver, SQ2_10.class);
		sq2_10.assetsStatus();

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Your Entry into the U.S.
		SQ3_1 sq3_1 = PageFactory.initElements(driver, SQ3_1.class);
		sq3_1.lastEntryInformation(i485Multidata,"principal");

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Class of Admission and Current Status
		SQ3_2 sq3_2 = PageFactory.initElements(driver, SQ3_2.class);
		sq3_2.classOfAdmission(i485Multidata,"principal");

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Nonimmigrant Visa Number
		SQ4_1 sq4_1 = PageFactory.initElements(driver, SQ4_1.class);
		sq4_1.visaNumber(i485Multidata,"principal");

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Immigration History
		SQ4_2 sq4_2 = PageFactory.initElements(driver, SQ4_2.class);
		sq4_2.immigrationHistory("principal");

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Information About Your Spouse
		SQ5_1 sq5_1 = PageFactory.initElements(driver, SQ5_1.class);
		sq5_1.spouseDetails(i485Multidata);

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Information About Your Spouse
		SQ5_1_1 sq5_1_1 = PageFactory.initElements(driver, SQ5_1_1.class);
		sq5_1_1.contributionToSpouse("No");

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Information About Your Spouse
		SQ5_2_1 sq5_2_1 = PageFactory.initElements(driver, SQ5_2_1.class);
		sq5_2_1.addressOfSpouse(i485Multidata);

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Information About Your Spouse
		SQ5_3 sq5_3 = PageFactory.initElements(driver, SQ5_3.class);
		sq5_3.marriageInformations(i485Multidata);

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Information About Your Spouse
		SQ5_4 sq5_4 = PageFactory.initElements(driver, SQ5_4.class);
		sq5_4.spouseARNInformations("yes", i485Multidata);

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Information about Your Children
		SQ5_5 sq5_5 = PageFactory.initElements(driver, SQ5_5.class);
		sq5_5.haveChild("no","principal");

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Other Dependents
		SQ5_6 sq5_6 = PageFactory.initElements(driver, SQ5_6.class);
		sq5_6.haveOtherDependents("no", i485Multidata);

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Membership
		SQ6_1 sq6_1 = PageFactory.initElements(driver, SQ6_1.class);
		sq6_1.membershipDetails("principal");

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Criminal History
		SQ6_2 sq6_2 = PageFactory.initElements(driver, SQ6_2.class);
		sq6_2.criminalHistory("principal");

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Criminal History
		SQ6_3 sq6_3 = PageFactory.initElements(driver, SQ6_3.class);
		sq6_3.criminalHistory("principal");

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Criminal Intent
		SQ6_4 sq6_4 = PageFactory.initElements(driver, SQ6_4.class);
		sq6_4.criminalIntent("principal");

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Miscellaneous
		SQ6_5 sq6_5 = PageFactory.initElements(driver, SQ6_5.class);
		sq6_5.miscellaneous("principal");

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Miscellaneous
		SQ6_5_1 sq6_5_1 = PageFactory.initElements(driver, SQ6_5_1.class);
		sq6_5_1.miscellaneous("principal");

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Immigration Violations
		SQ6_6 sq6_6 = PageFactory.initElements(driver, SQ6_6.class);
		sq6_6.immigrationViolations("principal");

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Other Violations
		SQ6_7 sq6_7 = PageFactory.initElements(driver, SQ6_7.class);
		sq6_7.immigrationViolations("principal");

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Miscellaneous
		SQ6_7_1 sq6_7_1 = PageFactory.initElements(driver, SQ6_7_1.class);
		sq6_7_1.miscellaneous("principal");

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Miscellaneous
		SQ6_7_2 sq6_7_2 = PageFactory.initElements(driver, SQ6_7_2.class);
		sq6_7_2.miscellaneous("principal");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Previous Petitions
		SQ6_8 sq6_8 = PageFactory.initElements(driver, SQ6_8.class);
		sq6_8.previousPetitions("principal");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Prior Affidavits of Support
		SQ6_9 sq6_9 = PageFactory.initElements(driver, SQ6_9.class);
		sq6_9.previousAffidavit("principal");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Prior Employment Authorization Applications
		SQ7_1 sq7_1 = PageFactory.initElements(driver, SQ7_1.class);
		sq7_1.previousEmploymentAuthorization("principal");

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Processing Details
		SQ9_1 sq9_1 = PageFactory.initElements(driver, SQ9_1.class);
		sq9_1.livedInUSLawfully("principal");

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Requesting an Accommodation
		SQ10_1 sq10_1 = PageFactory.initElements(driver, SQ10_1.class);
		sq10_1.requestAccomodation("principal");

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Certification
		SQ11_1 sq11_1 = PageFactory.initElements(driver, SQ11_1.class);
		sq11_1.certification("principal");

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Certification
		SQ11_2 sq11_2 = PageFactory.initElements(driver, SQ11_2.class);
		sq11_2.certification("principal");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Beneficiary
		SelectElement nextStep = new SelectElement(driver,
				"//button[contains(text(),'done reviewing, Go to Next Step')]");
		nextStep.selectElementUsingXPath();

		SelectElement beneficiaryApp = new SelectElement(driver,
				"//a[contains(text(),'Continue to Next Application')]");
		beneficiaryApp.selectElementUsingXPath();

		SelectElement startbeneficiary = new SelectElement(driver, "Start Here");
		startbeneficiary.selectElementUsingLinkText();

		// Basis for Application
		SQ1_1 spouse1_1 = PageFactory.initElements(driver, SQ1_1.class);
		spouse1_1.setApplicationBasis(6);
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Immigration Proceedings
		SQ1_1_1 spouse1_1_1 = PageFactory.initElements(driver, SQ1_1_1.class);
		spouse1_1_1.immigrationProcceding("beneficiary","no");

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Status
		SQ1_14 sq1_14 = PageFactory.initElements(driver, SQ1_14.class);
		sq1_14.beneficiaryOneYearSinceInspected();

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Name

		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Other Names
		SQ2_1_1 spouse2_1_1 = PageFactory.initElements(driver, SQ2_1_1.class);
		spouse2_1_1.notUsedOtherNames("beneficiary");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Address

		SQ2_2 spouse2_2 = PageFactory.initElements(driver, SQ2_2.class);
		spouse2_2.beneficiaryAddressDetails();
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Foreign Address
		SQ2_2_2 spouse2_2_2 = PageFactory.initElements(driver, SQ2_2_2.class);
		spouse2_2_2.beneficiaryForeignAddressDetails();
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Biographical Information
		SQ2_3 spouse2_3 = PageFactory.initElements(driver, SQ2_3.class);
		spouse2_3.beneficiaryBiographicalInformation(i485Multidata);
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Optional Contact Information for USCIS Notifications
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Parents
		SQ2_3_1 spouse2_3_1 = PageFactory.initElements(driver, SQ2_3_1.class);
		spouse2_3_1.beneficiaryParentsInformation(i485Multidata);
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Marital Status
		SQ2_4 spouse2_4 = PageFactory.initElements(driver, SQ2_4.class);
		spouse2_4.beneficiaryMaritalInformation();
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Social Security Number
		SQ2_5 spouse2_5 = PageFactory.initElements(driver, SQ2_5.class);
		spouse2_5.ssnStatus("beneficiary","no");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Alien Registration Number
		SQ2_6 spouse2_6 = PageFactory.initElements(driver, SQ2_6.class);
		spouse2_6.beneficiaryARNStatus();
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Employment
		SQ2_7 spouse2_7 = PageFactory.initElements(driver, SQ2_7.class);
		spouse2_7.employmentStatus("beneficiary");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Employment Abroad
		SQ2_8 spouse2_8 = PageFactory.initElements(driver, SQ2_8.class);
		spouse2_8.employmentStatusAbroad("beneficiary");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Your Entry into the U.S.
		SQ3_1 spouse3_1 = PageFactory.initElements(driver, SQ3_1.class);
		spouse3_1.lastEntryInformation(i485Multidata,"beneficiary");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Class of Admission and Current Status
		SQ3_2 spouse3_2 = PageFactory.initElements(driver, SQ3_2.class);
		spouse3_2.classOfAdmission(i485Multidata,"beneficiary");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Nonimmigrant Visa Number
		SQ4_1 spouse4_1 = PageFactory.initElements(driver, SQ4_1.class);
		spouse4_1.visaNumber(i485Multidata,"beneficiary");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Immigration History
		SQ4_2 spouse4_2 = PageFactory.initElements(driver, SQ4_2.class);
		spouse4_2.immigrationHistory("beneficiary");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Information About Your Spouse
		SQ5_1 spouse5_1 = PageFactory.initElements(driver, SQ5_1.class);
		spouse5_1.spouseMaidenName(i485Multidata);
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Information About Your Spouse
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();
		// Information About Your Spouse
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Information about Your Children
		SQ5_5 spouse5_4 = PageFactory.initElements(driver, SQ5_5.class);
		spouse5_4.haveChild("no","beneficiary");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Membership
		SQ6_1 spouse6_1 = PageFactory.initElements(driver, SQ6_1.class);
		spouse6_1.membershipDetails("beneficiary");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Criminal History
		SQ6_2 spouse6_2 = PageFactory.initElements(driver, SQ6_2.class);
		spouse6_2.criminalHistory("beneficiary");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Criminal History
		SQ6_3 spouse6_3 = PageFactory.initElements(driver, SQ6_3.class);
		spouse6_3.criminalHistory("beneficiary");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Criminal Intent
		SQ6_4 spouse6_4 = PageFactory.initElements(driver, SQ6_4.class);
		spouse6_4.criminalIntent("beneficiary");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Miscellaneous
		SQ6_5 spouse6_5 = PageFactory.initElements(driver, SQ6_5.class);
		spouse6_5.miscellaneous("beneficiary");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Miscellaneous
		SQ6_5_1 spouse6_5_1 = PageFactory.initElements(driver, SQ6_5_1.class);
		spouse6_5_1.miscellaneous("beneficiary");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Immigration Violations
		SQ6_6 spouse6_6 = PageFactory.initElements(driver, SQ6_6.class);
		spouse6_6.immigrationViolations("beneficiary");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Other Violations
		SQ6_7 spouse6_7 = PageFactory.initElements(driver, SQ6_7.class);
		spouse6_7.immigrationViolations("beneficiary");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Miscellaneous
		SQ6_7_1 spouse6_7_1 = PageFactory.initElements(driver, SQ6_7_1.class);
		spouse6_7_1.miscellaneous("beneficiary");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Miscellaneous
		SQ6_7_2 spouse6_7_2 = PageFactory.initElements(driver, SQ6_7_2.class);
		spouse6_7_2.miscellaneous("beneficiary");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Prior Employment Authorization Applications
		SQ7_1 spouse7_1 = PageFactory.initElements(driver, SQ7_1.class);
		spouse7_1.previousEmploymentAuthorization("beneficiary");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Processing Details
		SQ9_1 spouse9_1 = PageFactory.initElements(driver, SQ9_1.class);
		spouse9_1.livedInUSLawfully("beneficiary");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Requesting an Accommodation
		SQ10_1 spouse10_1 = PageFactory.initElements(driver, SQ10_1.class);
		spouse10_1.requestAccomodation("beneficiary");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Certification
		SQ11_1 spouse11_1 = PageFactory.initElements(driver, SQ11_1.class);
		spouse11_1.certification("beneficiary");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();

		// Certification
		SQ11_2 spouse11_2 = PageFactory.initElements(driver, SQ11_2.class);
		spouse11_2.certification("beneficiary");
		sq1_1.saveScreenShot("i485multi", this.getClass().getSimpleName()); sq1_1.clickContinueInSQ();
		// Application Review
		if (!flowname.contains("InEligible")) {

			ApplicationReview appReview = PageFactory.initElements(driver,
					ApplicationReview.class);
			appReview.completeApplicationUsingNewCSS(appName);
		}
	}

}

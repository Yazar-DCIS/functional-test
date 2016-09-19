package com.formsdirectinc.functionaltests.apps.i130i485;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.i130i485.pages.*;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.ApplicationReview;
import com.formsdirectinc.functionaltests.tags.ReadDataFromExcelSheet;

/**
 * @Product I130-I485 SimpleQuestions
 * @author Orina
 */

public class SimpleQuestions extends Step {

	String appName = Products.I130I485.name();
	Sites site = Sites.valueOf(System.getProperty("site.name"));

	public SimpleQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public void test(String product,String flowname) throws Exception {

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		
		ReadDataFromExcelSheet readFromExcelSheet = new ReadDataFromExcelSheet();
		String i130i485Sheet = "I130I485";
		readFromExcelSheet.initializeWorkbook(i130i485Sheet);
		
		// SQ Section :
		ApplicationReview startHere = PageFactory.initElements(driver,
				ApplicationReview.class);
		startHere.selectStartApplication();
		startHere.selectStartHereLink();

		Integer fieldContent=readFromExcelSheet.getRowNumberUsingContent(flowname);
		
		// Current Legal Name
		SQ1_1 sq1_1 = PageFactory.initElements(driver, SQ1_1.class);
		sq1_1.applicantName();
		sq1_1.saveScreenShot(product, "SQ1_1");
		sq1_1.clickContinueInSQ();

		// Current Legal Name of Sponsor
		SQ1_2 sq1_2 = PageFactory.initElements(driver, SQ1_2.class);
		sq1_2.relativeName();
		sq1_1.saveScreenShot(product, "SQ1_2");
		sq1_2.clickContinueInSQ();

		// Citizenship
		String citizenshipMode=readFromExcelSheet.getCellStringContent(fieldContent, 1);
		SQ2_1 sq2_1 = PageFactory.initElements(driver, SQ2_1.class);
		sq2_1.obtainedCitizenshipThru(citizenshipMode);
		sq1_1.saveScreenShot(product, "SQ2_1");
		sq2_1.clickContinueInSQ();

		// We are sorry
		String visitSQ2_2=readFromExcelSheet.getCellStringContent(fieldContent, 2);
		if(visitSQ2_2.equalsIgnoreCase("yes"))
		{
		SQ2_2 sq2_2 = PageFactory.initElements(driver, SQ2_2.class);
		sq2_2.stopApplication();
		}

		// Martial Status
		String maritalStatus=readFromExcelSheet.getCellStringContent(fieldContent, 3);
		SQ2_3 sq2_3 = PageFactory.initElements(driver, SQ2_3.class);
		sq2_3.citizenshipMaritaLStatus(maritalStatus);
		

		// Type of Relationship-I
		String relationshipType1=readFromExcelSheet.getCellStringContent(fieldContent, 4);
		SQ2_4 sq2_4 = PageFactory.initElements(driver, SQ2_4.class);
		sq2_4.applicantRelationType1(relationshipType1);
		

		// Type of Relationship-II
		String relationshipType2=readFromExcelSheet.getCellStringContent(fieldContent, 5);
		SQ2_5 sq2_5 = PageFactory.initElements(driver, SQ2_5.class);
		sq2_5.applicantRelationType2(relationshipType2);
		

		//Wedding
		String physicallyPresentAtWedding=readFromExcelSheet.getCellStringContent(fieldContent, 6);
		SQ2_6 sq2_6 = PageFactory.initElements(driver, SQ2_6.class);
		sq2_6.physicallyPresentAtWedding(physicallyPresentAtWedding);
		

		// We are sorry
		String visitSQ2_6_1=readFromExcelSheet.getCellStringContent(fieldContent, 7);
		if(visitSQ2_6_1.equalsIgnoreCase("yes"))
		{
		SQ2_6_1 sq2_6_1 = PageFactory.initElements(driver, SQ2_6_1.class);
		sq2_6_1.stopApplication();
		}

		//Immigration Status
		String gainImmigrationStatusMarriage=readFromExcelSheet.getCellStringContent(fieldContent, 8);
		SQ2_7 sq2_7 = PageFactory.initElements(driver, SQ2_7.class);
		sq2_7.gainImmigrationStatusMarriage(gainImmigrationStatusMarriage);
		

		//Qualifying Information
		String passedFiveYearsAsLPR=readFromExcelSheet.getCellStringContent(fieldContent, 9);
		SQ2_7_1 sq2_7_1 = PageFactory.initElements(driver, SQ2_7_1.class);
		sq2_7_1.passedFiveYearsAsLPR(passedFiveYearsAsLPR);
		

		//Qualifying Information
		String spouseObtainPermanentResidency=readFromExcelSheet.getCellStringContent(fieldContent, 10);
		SQ2_7_2 sq2_7_2 = PageFactory.initElements(driver, SQ2_7_2.class);
		sq2_7_2.spouseObtainPermanentResidency(spouseObtainPermanentResidency);
		

		//Immigration Status
		String gainImmigrationStatusAdoption=readFromExcelSheet.getCellStringContent(fieldContent, 11);
		SQ2_8 sq2_8 = PageFactory.initElements(driver, SQ2_8.class);
		sq2_8.gainImmigrationStatusAdoption(gainImmigrationStatusAdoption);

		// Immigration Proceedings
		String currentlyExclusionProceedings=readFromExcelSheet.getCellStringContent(fieldContent, 12);
		String underImmigrationProceedings=readFromExcelSheet.getCellStringContent(fieldContent, 13);
		String immigrationProceedingsType=readFromExcelSheet.getCellStringContent(fieldContent, 14);
		SQ2_9 sq2_9 = PageFactory.initElements(driver, SQ2_9.class);
		sq2_9.immigrationProceedings(currentlyExclusionProceedings,underImmigrationProceedings,
										immigrationProceedingsType);
		

		// STOP  Attention Required
		// We are sorry
		String visitSQ2_9_1=readFromExcelSheet.getCellStringContent(fieldContent, 15);
		if(visitSQ2_9_1.equalsIgnoreCase("yes"))
		{
		SQ2_9_1 sq2_9_1 = PageFactory.initElements(driver, SQ2_9_1.class);
		sq2_9_1.stopApplication();
		}
		
		// Inspection
		String inspectedByOfficer=readFromExcelSheet.getCellStringContent(fieldContent, 16);
		String currentlyLawfulStatus=readFromExcelSheet.getCellStringContent(fieldContent, 17);
		SQ2_10 sq2_10 = PageFactory.initElements(driver, SQ2_10.class);
		sq2_10.inspections(inspectedByOfficer,currentlyLawfulStatus);
		

		// STOP  Attention Required
		String visitSQ2_10_1=readFromExcelSheet.getCellStringContent(fieldContent, 18);
		if(visitSQ2_10_1.equalsIgnoreCase("yes"))
		{
		SQ2_10_1 sq2_10_1 = PageFactory.initElements(driver, SQ2_10_1.class);
		sq2_10_1.stopApplication();
		}
		
		
		// Presence in the U.S.
		String bothCurrentlyLiveUS=readFromExcelSheet.getCellStringContent(fieldContent, 19);
		SQ3_1 sq3_1 = PageFactory.initElements(driver, SQ3_1.class);
		sq3_1.presenceInUS(bothCurrentlyLiveUS);
		

		// STOP  Attention Required
		String visitSQ3_1_1=readFromExcelSheet.getCellStringContent(fieldContent, 20);
		if(visitSQ3_1_1.equalsIgnoreCase("yes"))
		{
		SQ3_1_1 sq3_1_1 = PageFactory.initElements(driver, SQ3_1_1.class);
		sq3_1_1.stopApplication();
		}		
				
		// Adoption
		String bothRelatedByAdoption=readFromExcelSheet.getCellStringContent(fieldContent, 21);
		SQ3_2 sq3_2 = PageFactory.initElements(driver, SQ3_2.class);
		sq3_2.bothRelatedByAdoption(bothRelatedByAdoption);
		

		// Age
		String atleastTwentyOne=readFromExcelSheet.getCellStringContent(fieldContent, 22);
		SQ3_3 sq3_3 = PageFactory.initElements(driver, SQ3_3.class);
		sq3_3.ageAtleast21(atleastTwentyOne);
		

		// STOP  Attention Required
		String visitSQ3_3_1=readFromExcelSheet.getCellStringContent(fieldContent, 23);
		if(visitSQ3_3_1.equalsIgnoreCase("yes"))
		{
		SQ3_3_1 sq3_3_1 = PageFactory.initElements(driver, SQ3_3_1.class);
		sq3_3_1.stopApplication();
		}		
		
		// Your Parent- Applying for 
		String applyingFor=readFromExcelSheet.getCellStringContent(fieldContent, 24);
		SQ3_4 sq3_4 = PageFactory.initElements(driver, SQ3_4.class);
		sq3_4.applyingForRelation(applyingFor);
		

		// Your Parents' Marriage
		String parentsMarriedBeforeApplicantBirth=readFromExcelSheet.getCellStringContent(fieldContent, 25);
		SQ3_5 sq3_5 = PageFactory.initElements(driver, SQ3_5.class);
		sq3_5.parentsMarriedBeforeYourBirth(parentsMarriedBeforeApplicantBirth);
		

		// Your Legitimation
		String legitimated=readFromExcelSheet.getCellStringContent(fieldContent, 26);
		SQ3_6 sq3_6 = PageFactory.initElements(driver, SQ3_6.class);
		sq3_6.legitimated(legitimated);
		
		
		//ongoing parent-child relationship 
		String ongoingRelationshipWithFather= readFromExcelSheet.getCellStringContent(fieldContent, 27);
		SQ3_7 sq3_7 = PageFactory.initElements(driver, SQ3_7.class);
		sq3_7.ongoingRelationship(ongoingRelationshipWithFather);
		
		
		// STOP  Attention Required
		String visitSQ3_7_1=readFromExcelSheet.getCellStringContent(fieldContent, 28);
		if(visitSQ3_7_1.equalsIgnoreCase("yes"))
		{
		SQ3_7_1 sq3_7_1 = PageFactory.initElements(driver, SQ3_7_1.class);
		sq3_7_1.stopApplication();
		}
		
		//Marriage
		String stepParentMarriedNaturalParent=readFromExcelSheet.getCellStringContent(fieldContent, 29);
		SQ3_8 sq3_8 = PageFactory.initElements(driver, SQ3_8.class);		
		sq3_8.stepParentMarriedNaturalParent(stepParentMarriedNaturalParent);
		
		
		// STOP  Attention Required
		String visitSQ3_8_1=readFromExcelSheet.getCellStringContent(fieldContent, 30);
		if(visitSQ3_8_1.equalsIgnoreCase("yes"))
		{
		SQ3_8_1 sq3_8_1 = PageFactory.initElements(driver, SQ3_8_1.class);
		sq3_8_1.stopApplication();
		}
		
		//Marriage
		String relativeUnmarriedUnderAge=readFromExcelSheet.getCellStringContent(fieldContent, 31);
		SQ3_9 sq3_9 = PageFactory.initElements(driver, SQ3_9.class);
		sq3_9.relativeUnmarriedUnderAge(relativeUnmarriedUnderAge);
		
		
		// STOP  Attention Required
		String visitSQ3_9_1=readFromExcelSheet.getCellStringContent(fieldContent, 32);
		if(visitSQ3_9_1.equalsIgnoreCase("yes"))
		{
		SQ3_9_1 sq3_9_1 = PageFactory.initElements(driver, SQ3_9_1.class);
		sq3_9_1.stopApplication();
		}
		
		// Applying for Relative
		String relativeRelationship=readFromExcelSheet.getCellStringContent(fieldContent, 33);
		SQ3_10 sq3_10 = PageFactory.initElements(driver, SQ3_10.class);
		sq3_10.relativeRelationship(relativeRelationship);
		
		
		// Relative Legitimation
		String relativeLegitimated=readFromExcelSheet.getCellStringContent(fieldContent, 34);
		SQ3_11 sq3_11 = PageFactory.initElements(driver, SQ3_11.class);
		sq3_11.relativeLegitimated(relativeLegitimated);
		
		
		//ongoing parent-child relationship - Relative
		SQ3_12 sq3_12 = PageFactory.initElements(driver, SQ3_12.class);
		String ongoingRelationshipRelative=readFromExcelSheet.getCellStringContent(fieldContent, 35);
		sq3_12.relativeOngoingRelationship(ongoingRelationshipRelative);
		
		
		// STOP  Attention Required
		String visitSQ3_12_1=readFromExcelSheet.getCellStringContent(fieldContent, 36);
		if(visitSQ3_12_1.equalsIgnoreCase("Yes"))
		{
		SQ3_12_1 sq3_12_1 = PageFactory.initElements(driver, SQ3_12_1.class);
		sq3_12_1.stopApplication();
		}
		
		//Marriage
		String marriedStepChildrensParent=readFromExcelSheet.getCellStringContent(fieldContent, 37);
		SQ3_13 sq3_13 = PageFactory.initElements(driver, SQ3_13.class);
		sq3_13.relativeUnmarriedUnderAge(marriedStepChildrensParent);
		

		// STOP  Attention Required
		String visitSQ3_13_1=readFromExcelSheet.getCellStringContent(fieldContent, 38);
		if(visitSQ3_13_1.equalsIgnoreCase("yes"))
		{
		SQ3_13_1 sq3_13_1 = PageFactory.initElements(driver, SQ3_13_1.class);
		sq3_13_1.stopApplication();
		}
		
		// Biographic Information
		String haveUsedOtherNames=readFromExcelSheet.getCellStringContent(fieldContent, 39);
		Integer otherNameCount=(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 40);
		String gender=readFromExcelSheet.getCellStringContent(fieldContent, 41);
		SQ4_1 sq4_1 = PageFactory.initElements(driver, SQ4_1.class);
		sq4_1.biographicInfo(haveUsedOtherNames,otherNameCount,gender);
		

		// Address and Phone Number
		String sameMailingAddress =readFromExcelSheet.getCellStringContent(fieldContent, 42);
		String receiveMailInCareOfOthers =readFromExcelSheet.getCellStringContent(fieldContent, 43);
		String similarToRelativeAddress =readFromExcelSheet.getCellStringContent(fieldContent, 44);
		String receiveMailForRelative =readFromExcelSheet.getCellStringContent(fieldContent, 45);
		String dateMoveToCurrentAddress =readFromExcelSheet.getCellStringContent(fieldContent, 46);
		
		SQ4_2 sq4_2 = PageFactory.initElements(driver, SQ4_2.class);
		sq4_2.addressDetails(sameMailingAddress,receiveMailInCareOfOthers,similarToRelativeAddress,
				receiveMailForRelative,dateMoveToCurrentAddress);
		

		
		// Other Address(es)
		Integer otherAddressCount=(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 47);
		String otherAddresCountry=readFromExcelSheet.getCellStringContent(fieldContent, 48);
		SQ4_2_1 sq4_2_1 = PageFactory.initElements(driver, SQ4_2_1.class);
		sq4_2_1.otherAddressDetails(otherAddressCount,otherAddresCountry);
		
		
		
		// Residence Abroad
		String livedInsideUS=readFromExcelSheet.getCellStringContent(fieldContent, 49);
		String livedMoreThanAYear=readFromExcelSheet.getCellStringContent(fieldContent, 50);
		String countryLived=readFromExcelSheet.getCellStringContent(fieldContent, 51);
		
		SQ4_3 sq4_3 = PageFactory.initElements(driver, SQ4_3.class);
		sq4_3.residenceInformation(livedInsideUS,livedMoreThanAYear,countryLived);
		

		// Date and Place of Birth
		SQ4_4 sq4_4 = PageFactory.initElements(driver, SQ4_4.class);
		sq4_4.birthInformation();
		

		//Citizen through Naturalization 
		String haveCertificateofNaturalization=readFromExcelSheet.getCellStringContent(fieldContent, 52);
		String havePassport=readFromExcelSheet.getCellStringContent(fieldContent, 53);
		SQ4_5 sq4_5 = PageFactory.initElements(driver, SQ4_5.class);
		sq4_5.citizenshipThroughNaturization(haveCertificateofNaturalization,havePassport);		
		
		//Attention Required
		String visitSQ4_5_1=readFromExcelSheet.getCellStringContent(fieldContent, 54);
		if(visitSQ4_5_1.equalsIgnoreCase("yes"))
		{
		SQ4_5_1 sq4_5_1 = PageFactory.initElements(driver, SQ4_5_1.class);
		sq4_5_1.attentionRequired();
		}
		
		//citizenship through your parents
		String certificateofCitizenshipInOwnName=readFromExcelSheet.getCellStringContent(fieldContent, 55);
		String currentlyHaveCertificateofCitizenship=readFromExcelSheet.getCellStringContent(fieldContent, 56);
		String haveUSPassport=readFromExcelSheet.getCellStringContent(fieldContent, 57);
		
		SQ4_6 sq4_6 = PageFactory.initElements(driver, SQ4_6.class);
		sq4_6.citizenshipThroughParents(certificateofCitizenshipInOwnName,currentlyHaveCertificateofCitizenship,
										haveUSPassport);		

		//Attention Required
		String visitSQ4_6_1=readFromExcelSheet.getCellStringContent(fieldContent, 58);
		if(visitSQ4_6_1.equalsIgnoreCase("Yes"))
		{
		SQ4_6_1 sq4_6_1 = PageFactory.initElements(driver, SQ4_6_1.class);
		sq4_6_1.attentionRequired();
		}
		
		// Social Security Number
		SQ4_7 sq4_7 = PageFactory.initElements(driver, SQ4_7.class);
		sq4_7.ssnDetails();
		

		// Alien Registration Number
		String haveARN=readFromExcelSheet.getCellStringContent(fieldContent, 59);
		SQ4_7_1 sq4_7_1 = PageFactory.initElements(driver, SQ4_7_1.class);
		sq4_7_1.arnDetails(haveARN);
		
		
		//Parents
		String fatherAlive=readFromExcelSheet.getCellStringContent(fieldContent, 61);
		String motherAlive=readFromExcelSheet.getCellStringContent(fieldContent, 62);
		SQ4_8 sq4_8 = PageFactory.initElements(driver, SQ4_8.class);
		sq4_8.parentsInformation(fatherAlive, motherAlive);
		
		
		//Date and Place of applicant marriage
		String marriedBefore=readFromExcelSheet.getCellStringContent(fieldContent, 63);
		SQ4_9 sq4_9 = PageFactory.initElements(driver, SQ4_9.class);
		sq4_9.applicantMarriageInfo(marriedBefore);
		
		
		//Information about applicant ex-spouse(s):
		Integer previousMrgCount=(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 64);
		SQ4_10 sq4_10 = PageFactory.initElements(driver, SQ4_10.class);
		sq4_10.priorMarriage(previousMrgCount);
		
		
		// Employment
		String workedDuringLast5years =readFromExcelSheet.getCellStringContent(fieldContent, 65);
		String	employmentCategory= readFromExcelSheet.getCellStringContent(fieldContent, 66);
		Integer	employmentCount=(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 67);
		String currentOccupation= readFromExcelSheet.getCellStringContent(fieldContent, 68);
		String occupationCountry=readFromExcelSheet.getCellStringContent(fieldContent, 69);
				
		SQ4_11 sq4_11 = PageFactory.initElements(driver, SQ4_11.class);
		sq4_11.employmentDetails(workedDuringLast5years,employmentCategory,employmentCount,
								currentOccupation,occupationCountry);
	
		// Employment Abroad
		String workedOutsideUSA=readFromExcelSheet.getCellStringContent(fieldContent, 70); 
		String currentOccupationAbroad=readFromExcelSheet.getCellStringContent(fieldContent, 71);
		String occupationCountryAbroad=readFromExcelSheet.getCellStringContent(fieldContent, 72);
		SQ4_11_1 sq4_11_1 = PageFactory.initElements(driver, SQ4_11_1.class);
		sq4_11_1.employmentDetailsAbroad(workedOutsideUSA,currentOccupationAbroad,occupationCountryAbroad);
		
		
		// Income
		String wereYouRequiredFederalIncome=readFromExcelSheet.getCellStringContent(fieldContent, 73);
		String haveYouFiledfederalIncome=readFromExcelSheet.getCellStringContent(fieldContent, 74);
		String taxSubmission=readFromExcelSheet.getCellStringContent(fieldContent, 75);
		SQ4_11_2 sq4_11_2 = PageFactory.initElements(driver, SQ4_11_2.class);
		sq4_11_2.incomeDetails(wereYouRequiredFederalIncome, haveYouFiledfederalIncome,taxSubmission);
		

		// Prior Petitions
		String previouslyFiled=readFromExcelSheet.getCellStringContent(fieldContent, 76);
		int previousPetitionCount=(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 77);
		String petitionType=readFromExcelSheet.getCellStringContent(fieldContent, 78);
		String wasItfiledOnBehalf=readFromExcelSheet.getCellStringContent(fieldContent, 79);
		SQ4_12 sq4_12 = PageFactory.initElements(driver, SQ4_12.class);
		sq4_12.priorPetitionInformation(previouslyFiled,previousPetitionCount,petitionType,wasItfiledOnBehalf);
	

		// STOP  Attention Required
		String visitSQ4_12_1=readFromExcelSheet.getCellStringContent(fieldContent, 80);
		if(visitSQ4_12_1.equalsIgnoreCase("yes"))
		{
		SQ4_12_1 sq4_12_1 = PageFactory.initElements(driver, SQ4_12_1.class);
		sq4_12_1.stopApplication();
		}
		
		// Other Petitions-1
		String filledOtherPetitions=readFromExcelSheet.getCellStringContent(fieldContent, 81);
		int otherPetitionCount=(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 82);
		String relation=readFromExcelSheet.getCellStringContent(fieldContent, 83);
		SQ4_13 sq4_13 = PageFactory.initElements(driver, SQ4_13.class);
		sq4_13.otherPetitionInformation(filledOtherPetitions,otherPetitionCount,relation);
		

		// Other Petitions-2
		String filledOtherPetitionsII=readFromExcelSheet.getCellStringContent(fieldContent, 84);
		int otherPetitionIICount=(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 85);
		String relationII=readFromExcelSheet.getCellStringContent(fieldContent, 86);
		SQ4_13_1 sq4_13_1 = PageFactory.initElements(driver, SQ4_13_1.class);
		sq4_13_1.otherPetitionInformation(filledOtherPetitionsII,otherPetitionIICount,relationII);
		
		
		// Attention Required
		String visitSQ5_1=readFromExcelSheet.getCellStringContent(fieldContent, 87);
		if(visitSQ5_1.equalsIgnoreCase("YES"))
		{
		SQ5_1 sq5_1 = PageFactory.initElements(driver, SQ5_1.class);
		sq5_1.attentionRequired();
		}

		// Sponsor's Income
		SQ5_2 sq5_2 = PageFactory.initElements(driver, SQ5_2.class);
		sq5_2.sponsorCurrentIncome();
		

		// Sponsor's Household Size
		String childrenDependent=readFromExcelSheet.getCellStringContent(fieldContent, 88);
		String otherDependent=readFromExcelSheet.getCellStringContent(fieldContent, 89);
		String sponsorDependent=readFromExcelSheet.getCellStringContent(fieldContent, 90);
		SQ5_3 sq5_3 = PageFactory.initElements(driver, SQ5_3.class);
		sq5_3.sponsorsHouseHoldSize(childrenDependent,otherDependent,sponsorDependent);
		

		// U.S. armed services? 
		String servedMilitary=readFromExcelSheet.getCellStringContent(fieldContent, 91);
		SQ5_4 sq5_4 = PageFactory.initElements(driver, SQ5_4.class);
		sq5_4.militaryService(servedMilitary);
		
		
		//RELATIVE years of age? 
		String relativeAgedAbove18=readFromExcelSheet.getCellStringContent(fieldContent, 92);
		SQ5_4_1 sq5_4_1 = PageFactory.initElements(driver, SQ5_4_1.class);
		sq5_4_1.relativeAge(relativeAgedAbove18);
		
				
		//financial contributions to household:  
		String haveIncome=readFromExcelSheet.getCellStringContent(fieldContent, 93);
		String provideIncomeFromSameSource=readFromExcelSheet.getCellStringContent(fieldContent, 94);
		SQ5_5 sq5_5 = PageFactory.initElements(driver, SQ5_5.class);
		sq5_5.contributions(haveIncome,provideIncomeFromSameSource);
		
		
		//Your Assets
		String visitSQ5_6=readFromExcelSheet.getCellStringContent(fieldContent, 95);
		if(visitSQ5_6.equalsIgnoreCase("yes"))
		{
		SQ5_6 sq5_6 = PageFactory.initElements(driver, SQ5_6.class);
		sq5_6.assetDetails();
		}
		
		//Additional Financial Contributions
		String planToContribute=readFromExcelSheet.getCellStringContent(fieldContent, 96);
		SQ5_7 sq5_7 = PageFactory.initElements(driver, SQ5_7.class);
		sq5_7.relativePlanToContributions(planToContribute);
		
		
		// Attention Required
		String visitSQ6_1=readFromExcelSheet.getCellStringContent(fieldContent, 97);
		if(visitSQ6_1.equalsIgnoreCase("yes"))
		{
		SQ6_1 sq6_1 = PageFactory.initElements(driver, SQ6_1.class);
		sq6_1.attentionRequired();
		}
		
		// Attention Required
		String visitSQ7_1=readFromExcelSheet.getCellStringContent(fieldContent, 98);
		if(visitSQ7_1.equalsIgnoreCase("yes"))
		{
		SQ7_1 sq7_1 = PageFactory.initElements(driver, SQ7_1.class);
		sq7_1.attentionRequired();
		}

		// Biographical Information
		String haveRelativeUsedOtherNames=readFromExcelSheet.getCellStringContent(fieldContent, 99);
		int relativeOtherNamesCount=(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 100);
		String relativeGender=readFromExcelSheet.getCellStringContent(fieldContent, 101);
		SQ7_1_1 sq7_1_1 = PageFactory.initElements(driver, SQ7_1_1.class);
		sq7_1_1.relativeBiographicInfo(haveRelativeUsedOtherNames,relativeOtherNamesCount
										,relativeGender);
		

		// Address and Phone Number
		String visitSQ7_2=readFromExcelSheet.getCellStringContent(fieldContent, 102);
		if(visitSQ7_2.equalsIgnoreCase("yes"))
		{
		String dateMovedToCurrentAddress=readFromExcelSheet.getCellStringContent(fieldContent, 103);
		SQ7_2 sq7_2= PageFactory.initElements(driver, SQ7_2.class);
		sq7_2.relativeAddressInfo(dateMovedToCurrentAddress);
		}

		// Address and Phone Number
		String visitSQ7_2_1=readFromExcelSheet.getCellStringContent(fieldContent, 104);
		if(visitSQ7_2_1.equalsIgnoreCase("yes"))
		{
		String haveLivedTogether=readFromExcelSheet.getCellStringContent(fieldContent, 105);
		String country=readFromExcelSheet.getCellStringContent(fieldContent, 106);
		String dateMoveToRelativeCurrentAddress=readFromExcelSheet.getCellStringContent(fieldContent, 107);
		SQ7_2_1 sq7_2_1= PageFactory.initElements(driver, SQ7_2_1.class);
		sq7_2_1.relativeAddressInfo(haveLivedTogether,country,dateMoveToRelativeCurrentAddress);
		}
		
		// Address and Phone Number
		String visitSQ7_2_1_1=readFromExcelSheet.getCellStringContent(fieldContent, 108);
		if(visitSQ7_2_1_1.equalsIgnoreCase("yes"))
		{
		String dateMoveToCurrentAddress3=readFromExcelSheet.getCellStringContent(fieldContent, 109);
		SQ7_2_1_1 sq7_2_1_1= PageFactory.initElements(driver, SQ7_2_1_1.class);
		sq7_2_1_1.relativeAddressInfo(dateMoveToCurrentAddress3);
		}
		
		//other addresses
		String country=readFromExcelSheet.getCellStringContent(fieldContent, 110);
		int addressCount=(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 111);
		SQ7_2_2 sq7_2_2= PageFactory.initElements(driver, SQ7_2_2.class);
		sq7_2_2.relativeOtherAddressDetails(country,addressCount);
		
				
		// Foreign Address and Phone Number
		String foreignCountry=readFromExcelSheet.getCellStringContent(fieldContent, 112);
		SQ7_3 sq7_3 = PageFactory.initElements(driver, SQ7_3.class);
		sq7_3.relativeForeignAddressDetails(foreignCountry);
		

		// Residences
		String relativeForeignCountry=readFromExcelSheet.getCellStringContent(fieldContent, 113);
		SQ7_3_1 sq7_3_1 = PageFactory.initElements(driver, SQ7_3_1.class);
		sq7_3_1.relativeResidencesDetails(relativeForeignCountry);
	

		// Optional Contact Information
		String acceptedForProcessing=readFromExcelSheet.getCellStringContent(fieldContent,187);
		SQ7_3_2 sq7_3_2 = PageFactory.initElements(driver, SQ7_3_2.class);
		sq7_3_2.optionalContactInfo(acceptedForProcessing);
		

		// Biographical Information
		String useRomanLetters=readFromExcelSheet.getCellStringContent(fieldContent, 114);
		SQ7_4 sq7_4 = PageFactory.initElements(driver, SQ7_4.class);
		sq7_4.relativeBiographicInfo(useRomanLetters);
		

		// Social Security Number
		String haveSSNumber=readFromExcelSheet.getCellStringContent(fieldContent, 115);
		int ssncount=(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 116);
		SQ7_5 sq7_5 = PageFactory.initElements(driver, SQ7_5.class);
		sq7_5.relativeSSN(haveSSNumber,ssncount);
		

		// Alien Registration Number
		String haveArn=readFromExcelSheet.getCellStringContent(fieldContent, 117);
		SQ7_6 sq7_6 = PageFactory.initElements(driver, SQ7_6.class);
		sq7_6.relativeARN(haveArn);
		
		
		// Entry into the U.S.
		String documentType=readFromExcelSheet.getCellStringContent(fieldContent, 119);
		SQ7_7 sq7_7 = PageFactory.initElements(driver, SQ7_7.class);
		sq7_7.entryIntoUSInfo(documentType);
		

		// Nonimmigrant Visa Number
		SQ7_7_1 sq7_7_1 = PageFactory.initElements(driver, SQ7_7_1.class);
		sq7_7_1.relativeVisaNumber();
		

		// Class of Admission and Current Status
		String coaValidIndefinitely=readFromExcelSheet.getCellStringContent(fieldContent, 120);
		SQ7_8 sq7_8 = PageFactory.initElements(driver, SQ7_8.class);
		sq7_8.relativeAdmissionStatus(coaValidIndefinitely);
		

		// Presence in U.S.
		SQ7_9 sq7_9 = PageFactory.initElements(driver, SQ7_9.class);
		sq7_9.relativePresenceInUS();
	

		// Immigration History
		String hasPreviouslyApplied=readFromExcelSheet.getCellStringContent(fieldContent, 121);
		String hasLivedUnlawfully=readFromExcelSheet.getCellStringContent(fieldContent, 122);
		String hasLivedWithoutStatus=readFromExcelSheet.getCellStringContent(fieldContent, 123);
		SQ7_10 sq7_10 = PageFactory.initElements(driver, SQ7_10.class);
		sq7_10.relativeImmigrationStatus(hasPreviouslyApplied,hasLivedUnlawfully,hasLivedWithoutStatus);
	

		// Parents
		String relativeFatherAlive=readFromExcelSheet.getCellStringContent(fieldContent, 124);
		String relativeMotherAlive=readFromExcelSheet.getCellStringContent(fieldContent, 125);
		SQ8_1 sq8_1 = PageFactory.initElements(driver, SQ8_1.class);
		sq8_1.relativeParentsInfo(relativeFatherAlive,relativeMotherAlive);
		

		// Marital Status
		String relativeMaritalStatus=readFromExcelSheet.getCellStringContent(fieldContent, 126);
		SQ8_2 sq8_2 = PageFactory.initElements(driver, SQ8_2.class);
		sq8_2.relativeMaritalStatus(relativeMaritalStatus);
		

		//Your Spouse
		String spouseInfoRelationship=readFromExcelSheet.getCellStringContent(fieldContent, 127);
		SQ8_3 sq8_3 = PageFactory.initElements(driver, SQ8_3.class);
		sq8_3.relativeSpouseInformation(spouseInfoRelationship);
		
		
		//Prior marriages
		String foreignRelativeMarriedBefore=readFromExcelSheet.getCellStringContent(fieldContent, 128);
		SQ8_3_1 sq8_3_1 = PageFactory.initElements(driver, SQ8_3_1.class);
		sq8_3_1.relativePriorMarriageInfo(foreignRelativeMarriedBefore);
		
		
		//Marital Status
		String relativeOtherMaritalStatus=readFromExcelSheet.getCellStringContent(fieldContent, 129);
		SQ8_3_2 sq8_3_2 = PageFactory.initElements(driver, SQ8_3_2.class);
		sq8_3_2.relativeOtherMaritalStatus(relativeOtherMaritalStatus);
		
		
		//Prior marriages
		int relativePreviousMrgCount=(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 130);
		SQ8_4 sq8_4 = PageFactory.initElements(driver, SQ8_4.class);
		sq8_4.relativePriorMarriagesInfo(relativePreviousMrgCount);
		
		
		// Children
		String haveChildren=readFromExcelSheet.getCellStringContent(fieldContent, 131);
		int childCount=(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 132);
		SQ8_5 sq8_5 = PageFactory.initElements(driver, SQ8_5.class);
		sq8_5.relativeChildrenInfo(haveChildren,childCount);
		
		
		// Children
		String haveOtherChildren=readFromExcelSheet.getCellStringContent(fieldContent, 133);
		int otherChildCount=(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 134);
		SQ8_6 sq8_6 = PageFactory.initElements(driver, SQ8_6.class);
		sq8_6.relativeOtherChildrenInfo(haveOtherChildren,otherChildCount);
		

		
		// Employment
		String relativeWorkedPastFiveYears=readFromExcelSheet.getCellStringContent(fieldContent, 135);
		int relativeEmploymentCount=(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 136);
		String isThisRelativeCurrentOccupation=readFromExcelSheet.getCellStringContent(fieldContent, 137);
		String relativeOccupationCountry=readFromExcelSheet.getCellStringContent(fieldContent, 138);
		SQ9_1 sq9_1 = PageFactory.initElements(driver, SQ9_1.class);
		sq9_1.relativeEmployment(relativeWorkedPastFiveYears,relativeEmploymentCount,
									isThisRelativeCurrentOccupation,relativeOccupationCountry);
		
		
		// Employment
		String relativeWorkedOutside=readFromExcelSheet.getCellStringContent(fieldContent, 139);
		String relativeCurrentOccupation=readFromExcelSheet.getCellStringContent(fieldContent, 140);
		String relativeOccupationCountryAbroad=readFromExcelSheet.getCellStringContent(fieldContent, 141);
		SQ9_2 sq9_2 = PageFactory.initElements(driver, SQ9_2.class);
		sq9_2.relativeEmploymentAbroad(relativeWorkedOutside,relativeCurrentOccupation,relativeOccupationCountryAbroad);
		

		// Employment Authorization
		String relativeHaveWorkAuthorization=readFromExcelSheet.getCellStringContent(fieldContent, 142);
		int relativeWorkAuthorizationCount=(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 143);
		SQ9_3 sq9_3 = PageFactory.initElements(driver, SQ9_3.class);
		sq9_3.employmentAuthorization(relativeHaveWorkAuthorization,relativeWorkAuthorizationCount);
		

		// Membership
		String haveMembershipInfo=readFromExcelSheet.getCellStringContent(fieldContent, 144);
		int membershipCount=(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 145);
		SQ10_1 sq10_1 = PageFactory.initElements(driver, SQ10_1.class);
		sq10_1.relativeMembershipDetails(haveMembershipInfo,membershipCount);
		

		// Criminal History
		String anyMoralTurpitude=readFromExcelSheet.getCellStringContent(fieldContent, 146);
		String haveArrest=readFromExcelSheet.getCellStringContent(fieldContent, 147);
		String benefitOfPardon=readFromExcelSheet.getCellStringContent(fieldContent, 148);
		String anycriminalOffense=readFromExcelSheet.getCellStringContent(fieldContent, 149);
		SQ10_2 sq10_2 = PageFactory.initElements(driver, SQ10_2.class);
		sq10_2.relativeInformationRelatedToCrimeHistory(anyMoralTurpitude,haveArrest,benefitOfPardon,
														anycriminalOffense);
		

		// Criminal History
		String procuredForProstitution=readFromExcelSheet.getCellStringContent(fieldContent, 150);
		String anyUnlawfulAct=readFromExcelSheet.getCellStringContent(fieldContent, 151);
		String knowinglyEncourage=readFromExcelSheet.getCellStringContent(fieldContent, 152);
		String illicitlyTraffic=readFromExcelSheet.getCellStringContent(fieldContent, 153);
		
		SQ10_3 sq10_3 = PageFactory.initElements(driver, SQ10_3.class);
		sq10_3.relativeInformationRelatedToCrimeHistory(procuredForProstitution,anyUnlawfulAct
														,knowinglyEncourage	,illicitlyTraffic);
		

		// Criminal Intent
		String haveEspionage=readFromExcelSheet.getCellStringContent(fieldContent, 154);
		String oppostionToGov=readFromExcelSheet.getCellStringContent(fieldContent, 155);
		String haveEvade=readFromExcelSheet.getCellStringContent(fieldContent, 156);
		SQ10_4 sq10_4 = PageFactory.initElements(driver, SQ10_4.class);
		sq10_4.relativeInformationRelatedToCrimeIntent(haveEspionage,oppostionToGov
														,haveEvade);
		

		// Miscellaneous
		String anyPublicAssist=readFromExcelSheet.getCellStringContent(fieldContent, 157);
		String conspireToEngage=readFromExcelSheet.getCellStringContent(fieldContent, 158);
		String communistParty=readFromExcelSheet.getCellStringContent(fieldContent, 159);
		SQ10_5 sq10_5 = PageFactory.initElements(driver, SQ10_5.class);
		sq10_5.relativeInformationRelatedToMiscellaneous(anyPublicAssist,conspireToEngage
															,communistParty);
		

		// Other Acts
		String engageInGenocide=readFromExcelSheet.getCellStringContent(fieldContent, 160);
		String killingAnyPerson=readFromExcelSheet.getCellStringContent(fieldContent, 161);
		String injuredAnyPerson=readFromExcelSheet.getCellStringContent(fieldContent, 162);
		String engageSexualContact=readFromExcelSheet.getCellStringContent(fieldContent, 163);
		String denyAnyoneReligiousBeliefs=readFromExcelSheet.getCellStringContent(fieldContent, 164);
		SQ10_5_1 sq10_5_1 = PageFactory.initElements(driver, SQ10_5_1.class);
		sq10_5_1.relativeOtherActs(engageInGenocide,killingAnyPerson,injuredAnyPerson,
										engageSexualContact,denyAnyoneReligiousBeliefs);
		

		// Immigration Violations
		String deportedFromUs=readFromExcelSheet.getCellStringContent(fieldContent, 165);
		String leftUs=readFromExcelSheet.getCellStringContent(fieldContent, 166);
		String nonimmigrantExchange=readFromExcelSheet.getCellStringContent(fieldContent, 167);
		SQ10_6 sq10_6 = PageFactory.initElements(driver, SQ10_6.class);
		sq10_6.relativeImmigrationViolations(deportedFromUs,leftUs,nonimmigrantExchange);
		

		// Other Violations
		String orderOfCivilpenalty=readFromExcelSheet.getCellStringContent(fieldContent, 168);
		String grantCustody=readFromExcelSheet.getCellStringContent(fieldContent, 169);
		String naziGovt=readFromExcelSheet.getCellStringContent(fieldContent, 170);
		String practicePolygamy=readFromExcelSheet.getCellStringContent(fieldContent, 171);
		SQ10_7 sq10_7 = PageFactory.initElements(driver, SQ10_7.class);
		sq10_7.relativeOtherViolations(orderOfCivilpenalty,grantCustody	,naziGovt,practicePolygamy);
		

		// Prison service and military activity
		String servedInMilitary=readFromExcelSheet.getCellStringContent(fieldContent, 172);
		String servedInJail=readFromExcelSheet.getCellStringContent(fieldContent, 173);
		String weaponAgainstPerson=readFromExcelSheet.getCellStringContent(fieldContent, 174);
		SQ10_8 sq10_8 = PageFactory.initElements(driver, SQ10_8.class);
		sq10_8.relativePrisonServices(servedInMilitary,servedInJail,weaponAgainstPerson);
		
		// Weapons
		String sellingWeapons=readFromExcelSheet.getCellStringContent(fieldContent, 175);
		String receivedWeaponsTraining=readFromExcelSheet.getCellStringContent(fieldContent, 176);
		SQ10_9 sq10_9 = PageFactory.initElements(driver, SQ10_9.class);
		sq10_9.relativeWeaponRelatedInfo(sellingWeapons,receivedWeaponsTraining);
		

		// Requesting an Accommodation
		String haveDisability=readFromExcelSheet.getCellStringContent(fieldContent, 177);
		SQ12_1 sq12_1 = PageFactory.initElements(driver, SQ12_1.class);
		sq12_1.relativeInformationOnAccommodations(haveDisability);
		
		
		// Requesting an Accommodation
		String disablityType=readFromExcelSheet.getCellStringContent(fieldContent, 178);
		SQ12_2 sq12_2 = PageFactory.initElements(driver, SQ12_2.class);
		sq12_2.relativeInformationOnDisability(disablityType);
		

		// Certification
		String languageUnderstand=readFromExcelSheet.getCellStringContent(fieldContent, 179);
		SQ13_1 sq13_1 = PageFactory.initElements(driver, SQ13_1.class);
		sq13_1.relativeCertificationStatement(languageUnderstand);
		

		// Disclaimer
		SQ13_2 sq13_2 = PageFactory.initElements(driver, SQ13_2.class);
		sq13_2.relativeDisclaimerStatement();
		

		//Attention Required
		String visitSQ11_1=readFromExcelSheet.getCellStringContent(fieldContent, 180);
		if(visitSQ11_1.equalsIgnoreCase("yes"))
		{
		SQ11_1 sq11_1 = PageFactory.initElements(driver, SQ11_1.class);
		sq11_1.attentionRequired();
		}
		
		//General Information
		String additionalSponsorType=readFromExcelSheet.getCellStringContent(fieldContent, 181);
		SQ11_2 sq11_2 = PageFactory.initElements(driver, SQ11_2.class);
		sq11_2.relativeAdditionalSponsorInformation(additionalSponsorType);
		
		
		//General Information
		String additionalSponsor1Type=readFromExcelSheet.getCellStringContent(fieldContent, 182);
		int sponsorCount=(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 183);
		SQ11_3 sq11_3 = PageFactory.initElements(driver, SQ11_3.class);
		sq11_3.relativeAdditionalSponsorInformation1(additionalSponsor1Type,sponsorCount);
		
	
		//General Information
		String additionalSponsor2Type=readFromExcelSheet.getCellStringContent(fieldContent, 184);
		int sponsor2Count=(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 185);
		SQ11_4 sq11_4 = PageFactory.initElements(driver, SQ11_4.class);
		sq11_4.relativeAdditionalSponsorInformation2(additionalSponsor2Type,sponsor2Count);
		
		// Certification
		String uscitizenPetitionerUnderstandLanguage=readFromExcelSheet.getCellStringContent(fieldContent, 186);
		SQ14_1 sq14_1 = PageFactory.initElements(driver, SQ14_1.class);
		sq14_1.uscitizenPetitionerCertification(uscitizenPetitionerUnderstandLanguage);
		
		
		// Application Review
		if (!flowname.contains("InEligible")) {

			ApplicationReview appReview = PageFactory.initElements(driver,
					ApplicationReview.class);
			appReview.completeApplicationUsingNewCSS(appName);

		}

	}

}

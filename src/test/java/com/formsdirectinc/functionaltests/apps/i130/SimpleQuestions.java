package com.formsdirectinc.functionaltests.apps.i130;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.i130.pages.*;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.ApplicationReview;
import com.formsdirectinc.functionaltests.tags.ReadDataFromExcelSheet;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * @author Orina
 * @Product I130 SimpleQuestions
 */

public class SimpleQuestions extends Step {

	

	public SimpleQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void test(String product, String flowname)
			throws Exception {

		String appName = Products.I130.name();

		ReadDataFromExcelSheet readFromExcelSheet = new ReadDataFromExcelSheet();
		String i130Sheet = "I130";
		readFromExcelSheet.initializeWorkbook(i130Sheet);
		Integer fieldContent = readFromExcelSheet
				.getRowNumberUsingContent(flowname);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		PropertyResource propertyFile=new PropertyResource();
		Properties i130data = propertyFile.loadProperty("name");

		// Properties copiesOfI130 = .loadProperty(appName);

		// SQ Section :
		ApplicationReview startHere = PageFactory.initElements(driver,
				ApplicationReview.class);
		startHere.selectStartApplication();
		startHere.selectStartHereLink();

		// Current Legal Name
		SQ1_1 sq1_1 = PageFactory.initElements(driver, SQ1_1.class);
		sq1_1.applicantName(i130data, readFromExcelSheet
				.getCellStringContent(fieldContent, 70),
				(int) readFromExcelSheet
						.getCellIntegerContent(fieldContent, 71));

		// Gender
		SQ1_2 sq1_2 = PageFactory.initElements(driver, SQ1_2.class);
		sq1_2.applicantGender(readFromExcelSheet.getCellStringContent(
				fieldContent, 72));

		// Address
		SQ1_2_1 sq1_2_1 = PageFactory.initElements(driver, SQ1_2_1.class);
		sq1_2_1.applicantAddress(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 73));

		// Address
		SQ1_2_1_1 sq1_2_1_1 = PageFactory.initElements(driver, SQ1_2_1_1.class);
		sq1_2_1_1.addressVisitedInLast5YearsDetails((int) readFromExcelSheet
				.getCellIntegerContent(fieldContent, 74), i130data, readFromExcelSheet.getCellStringContent(
				fieldContent, 75), readFromExcelSheet.getCellStringContent(
				fieldContent, 76));

		// Residence Abroad
		SQ1_2_2 sq1_2_2 = PageFactory.initElements(driver, SQ1_2_2.class);
		sq1_2_2.addressVisitedOutsideUSDetails(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 77),
				readFromExcelSheet.getCellStringContent(fieldContent, 78));

		SQ1_3 sq1_3 = PageFactory.initElements(driver, SQ1_3.class);
		sq1_3.applicantPhoneNumber(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 225));

		// Date and Place of Birth
		SQ1_4 sq1_4 = PageFactory.initElements(driver, SQ1_4.class);
		sq1_4.applicantDateAndPlaceOfBirth(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 79),
				readFromExcelSheet.getCellStringContent(fieldContent, 80));

		// Citizenship
		SQ1_5 sq1_5 = PageFactory.initElements(driver, SQ1_5.class);
		sq1_5.applicantCitizenship(
				readFromExcelSheet.getCellStringContent(fieldContent, 81),
				i130data);

		SQ1_6 sq1_6 = PageFactory.initElements(driver, SQ1_6.class);
		sq1_6.applicantCitizenshipMode(
				readFromExcelSheet.getCellStringContent(fieldContent, 82),
				readFromExcelSheet.getCellStringContent(fieldContent, 83));

		SQ1_7 sq1_7 = PageFactory.initElements(driver, SQ1_7.class);
		sq1_7.applicantCitizenshipCertificate(readFromExcelSheet
				.getCellStringContent(fieldContent, 84), readFromExcelSheet
				.getCellStringContent(fieldContent, 85), 
				i130data, readFromExcelSheet.getCellStringContent(
				readFromExcelSheet.getRowNumberUsingContent(flowname), 86));

		// 1.7.1 87
		String visitPage1_7_1=readFromExcelSheet.getCellStringContent(fieldContent, 87);
		if (visitPage1_7_1.equalsIgnoreCase("yes")) {
			SQ1_7_1 sq1_7_1 = PageFactory.initElements(driver, SQ1_7_1.class);
			sq1_7_1.stopApplication();
		}
		// Citizenship
		SQ1_8 sq1_8 = PageFactory.initElements(driver, SQ1_8.class);
		sq1_8.applicantNaturalizationCertificate(readFromExcelSheet
				.getCellStringContent(fieldContent, 88), readFromExcelSheet
				.getCellStringContent(fieldContent, 89), 
				i130data, readFromExcelSheet.getCellStringContent(
				readFromExcelSheet.getRowNumberUsingContent(flowname), 90));

		// 1.8.1 91
		String visitPage1_8_1=readFromExcelSheet.getCellStringContent(fieldContent, 91);
		if (visitPage1_8_1.equalsIgnoreCase("yes")) {
			SQ1_8_1 sq1_8_1 = PageFactory.initElements(driver, SQ1_8_1.class);
			sq1_8_1.stopApplication();
		}
		// Immigration Status
		SQ1_9 sq1_9 = PageFactory.initElements(driver, SQ1_9.class);
		sq1_9.applicantGreenCardStatus(readFromExcelSheet.getCellStringContent(
				fieldContent, 92));

		// 1.9.1 93
		String visitPage1_9_1=readFromExcelSheet.getCellStringContent(fieldContent, 93);
		if (visitPage1_9_1.equalsIgnoreCase("yes")) {
		SQ1_9_1 sq1_9_1 = PageFactory.initElements(driver, SQ1_9_1.class);
		sq1_9_1.stopApplication();
		}
		// Immigration Status
		SQ1_10 sq1_10 = PageFactory.initElements(driver, SQ1_10.class);
		sq1_10.applicantARN_Details(
				readFromExcelSheet.getCellStringContent(fieldContent, 94),
				i130data);

		// 1.10.1 95
		String visitPage1_10_1=readFromExcelSheet.getCellStringContent(fieldContent, 95);
		if (visitPage1_10_1.equalsIgnoreCase("yes")) {
		SQ1_10_1 sq1_10_1 = PageFactory.initElements(driver, SQ1_10_1.class);
		sq1_10_1.stopApplication();
		}

		// Immigration Status
		SQ1_11 sq1_11 = PageFactory.initElements(driver, SQ1_11.class);
		sq1_11.applicantImmigrationStatus_PermanentResident(
				i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 96));

		// Immigration Status
		SQ1_12 sq1_12 = PageFactory.initElements(driver, SQ1_12.class);
		sq1_12.permanentResidentThroughMarriage(readFromExcelSheet
				.getCellStringContent(fieldContent, 97));

		// Immigration Status
		SQ1_13 sq1_13 = PageFactory.initElements(driver, SQ1_13.class);
		sq1_13.permanentResidentThroughAdoption(readFromExcelSheet
				.getCellStringContent(fieldContent, 98));

		// Marital Status
		SQ1_14 sq1_14 = PageFactory.initElements(driver, SQ1_14.class);
		sq1_14.applicantMaritalStatus(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 99));

		SQ1_15 sq1_15 = PageFactory.initElements(driver, SQ1_15.class);
		sq1_15.applicantDateAndPlaceOfMarriage(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 100));

		// Prior marriages
		SQ1_16 sq1_16 = PageFactory.initElements(driver, SQ1_16.class);
		sq1_16.applicantPriorMarriage(readFromExcelSheet.getCellStringContent(
				fieldContent, 101));

		// Prior marriages
		SQ1_17 sq1_17 = PageFactory.initElements(driver, SQ1_17.class);
		sq1_17.applicantPriorMarriages(i130data,
				(int) readFromExcelSheet.getCellIntegerContent(fieldContent,
						102), readFromExcelSheet.getCellStringContent(
						fieldContent, 103));

		// Social Security Number
		SQ1_18 sq1_18 = PageFactory.initElements(driver, SQ1_18.class);
		sq1_18.applicantSSN_Details(
				readFromExcelSheet.getCellStringContent(fieldContent, 104),
				i130data);

		// Employment
		SQ1_19 sq1_19 = PageFactory.initElements(driver, SQ1_19.class);
		sq1_19.applicantEmploymentDetails(readFromExcelSheet
				.getCellStringContent(fieldContent, 105), readFromExcelSheet
				.getCellStringContent(fieldContent, 106), readFromExcelSheet
				.getCellStringContent(fieldContent, 107), 
				i130data, readFromExcelSheet.getCellStringContent(
				readFromExcelSheet.getRowNumberUsingContent(flowname), 108),
				(int) readFromExcelSheet.getCellIntegerContent(fieldContent,
						109));

		// Employment
		SQ1_20 sq1_20 = PageFactory.initElements(driver, SQ1_20.class);
		sq1_20.applicantEmploymentDetailsOutsideUS(
				readFromExcelSheet.getCellStringContent(fieldContent, 110),
				i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 111));

		// Type of Relationship
		SQ2_1 sq2_1 = PageFactory.initElements(driver, SQ2_1.class);
		sq2_1.applicantBeneficiaryRelationType(readFromExcelSheet
				.getCellStringContent(fieldContent, 112));

		// Type of Relationship
		SQ2_1_1 sq2_1_1 = PageFactory.initElements(driver, SQ2_1_1.class);
		sq2_1_1.applicantFamilyRelationType(readFromExcelSheet
				.getCellStringContent(fieldContent, 113));

		// 2.1.2 -114
		String visitPage2_1_2=readFromExcelSheet.getCellStringContent(fieldContent, 114);
		if (visitPage2_1_2.equalsIgnoreCase("yes")) {
		SQ2_1_2 sq2_1_2 = PageFactory.initElements(driver, SQ2_1_2.class);
		sq2_1_2.stopApplication();
		}
		// 2.1.3
		SQ2_1_3 sq2_1_3 = PageFactory.initElements(driver, SQ2_1_3.class);
		sq2_1_3.permanentResidentYearCompletion(readFromExcelSheet
				.getCellStringContent(fieldContent, 115));

		// 2.1.4
		SQ2_1_4 sq2_1_4 = PageFactory.initElements(driver, SQ2_1_4.class);
		sq2_1_4.permenentResident_SpouseInfo(readFromExcelSheet
				.getCellStringContent(fieldContent, 116));

		// 2.1.6
		SQ2_1_6 sq2_1_6 = PageFactory.initElements(driver, SQ2_1_6.class);
		sq2_1_6.childDetailsAboutMarriage(readFromExcelSheet
				.getCellStringContent(fieldContent, 117));

		// 2.1.7 118
		String visitPage2_1_7=readFromExcelSheet.getCellStringContent(fieldContent, 118);
		if (visitPage2_1_7.equalsIgnoreCase("yes")) {
		SQ2_1_7 sq2_1_7 = PageFactory.initElements(driver, SQ2_1_7.class);
		sq2_1_7.stopApplication();
		}
		
		// 2.1.8 119
		String visitPage2_1_8=readFromExcelSheet.getCellStringContent(fieldContent, 119);
		if (visitPage2_1_8.equalsIgnoreCase("yes")) {
		SQ2_1_8 sq2_1_8 = PageFactory.initElements(driver, SQ2_1_8.class);
		sq2_1_8.stopApplication();
		}
		
		SQ2_2 sq2_2 = PageFactory.initElements(driver, SQ2_2.class);
		sq2_2.relatedByAdoption(readFromExcelSheet.getCellStringContent(
				fieldContent, 120));

		// 2.2.1
		SQ2_2_1 sq2_2_1 = PageFactory.initElements(driver, SQ2_2_1.class);
		sq2_2_1.atleastOneCommonParent(readFromExcelSheet.getCellStringContent(
				fieldContent, 121));

		// 2.2.1.1
		SQ2_2_1_1 sq2_2_1_1 = PageFactory.initElements(driver, SQ2_2_1_1.class);
		sq2_2_1_1.siblingRelation(readFromExcelSheet.getCellStringContent(
				fieldContent, 122));

		// 2.2.2 123
		String visitPage2_2_2=readFromExcelSheet.getCellStringContent(fieldContent, 123);
		if (visitPage2_2_2.equalsIgnoreCase("yes")) {
		SQ2_2_2 sq2_2_2 = PageFactory.initElements(driver, SQ2_2_2.class);
		sq2_2_2.stopApplication();
		}

		SQ2_2_3 sq2_2_3 = PageFactory.initElements(driver, SQ2_2_3.class);
		sq2_2_3.parentType(readFromExcelSheet.getCellStringContent(
				fieldContent, 124));

		// 2.2.3.0
		SQ2_2_3_0 sq2_2_3_0 = PageFactory.initElements(driver, SQ2_2_3_0.class);
		sq2_2_3_0.marriedWhenChildBorn(readFromExcelSheet.getCellStringContent(
				fieldContent, 125));

		// 2.2.3.1
		SQ2_2_3_1 sq2_2_3_1 = PageFactory.initElements(driver, SQ2_2_3_1.class);
		sq2_2_3_1.childsLegitimatedbeforeEighteenthBirthday(readFromExcelSheet
				.getCellStringContent(fieldContent, 126));

		// 2.2.4
		SQ2_2_4 sq2_2_4 = PageFactory.initElements(driver, SQ2_2_4.class);
		sq2_2_4.marriageBeforeChildsEighteenthBirthday(readFromExcelSheet
				.getCellStringContent(fieldContent, 127));

		// 2.2.5 128
		String visitPage2_2_5=readFromExcelSheet.getCellStringContent(fieldContent, 128);
		if (visitPage2_2_5.equalsIgnoreCase("yes")) {
		SQ2_2_5 sq2_2_5 = PageFactory.initElements(driver, SQ2_2_5.class);
		sq2_2_5.stopApplication();
		}

		// 2.2.6
		SQ2_2_6 sq2_2_6 = PageFactory.initElements(driver, SQ2_2_6.class);
		sq2_2_6.parentChildRelationship(readFromExcelSheet
				.getCellStringContent(fieldContent, 129));

		// 2.2.7 130
		String visitPage2_2_7=readFromExcelSheet.getCellStringContent(fieldContent, 130);
		if (visitPage2_2_7.equalsIgnoreCase("yes")) {
		SQ2_2_7 sq2_2_7 = PageFactory.initElements(driver, SQ2_2_7.class);
		sq2_2_7.stopApplication();
		}
		// 2.2.9
		
		SQ2_2_9 sq2_2_9 = PageFactory.initElements(driver, SQ2_2_9.class);
		sq2_2_9.applyingForParent(readFromExcelSheet.getCellStringContent(
				fieldContent, 131));

		// 2.2.10
		SQ2_2_10 sq2_2_10 = PageFactory.initElements(driver, SQ2_2_10.class);
		sq2_2_10.applyingForBiologicalParents(readFromExcelSheet
				.getCellStringContent(fieldContent, 132));

		// 2.2.11
		SQ2_2_11 sq2_2_11 = PageFactory.initElements(driver, SQ2_2_11.class);
		sq2_2_11.parentsMarriedBeforeYouBorn(readFromExcelSheet
				.getCellStringContent(fieldContent, 133));

		// 2.2.12
		SQ2_2_12 sq2_2_12 = PageFactory.initElements(driver, SQ2_2_12.class);
		sq2_2_12.parentsStillMarried(readFromExcelSheet.getCellStringContent(
				fieldContent, 134));

		// 2.2.13
		SQ2_2_13 sq2_2_13 = PageFactory.initElements(driver, SQ2_2_13.class);
		sq2_2_13.parentChildRelationship21Years(readFromExcelSheet
				.getCellStringContent(fieldContent, 135));

		// 2.2.14
		SQ2_2_14 sq2_2_14 = PageFactory.initElements(driver, SQ2_2_14.class);
		sq2_2_14.legitimateBeforeEighteenthBirthday(readFromExcelSheet
				.getCellStringContent(fieldContent, 136));

		// 2.2.15 137
		String visitPage2_2_15=readFromExcelSheet.getCellStringContent(fieldContent, 137);
		if (visitPage2_2_15.equalsIgnoreCase("yes")) {
		SQ2_2_15 sq2_2_15 = PageFactory.initElements(driver, SQ2_2_15.class);
		sq2_2_15.stopApplication();
		}
		SQ2_2_16 sq2_2_16 = PageFactory.initElements(driver, SQ2_2_16.class);
		sq2_2_16.stepParentMarriedToYourNaturalParent(readFromExcelSheet
				.getCellStringContent(fieldContent, 138));

		SQ2_2_17 sq2_2_17 = PageFactory.initElements(driver, SQ2_2_17.class);
		sq2_2_17.yourParentsStillMarried(readFromExcelSheet
				.getCellStringContent(fieldContent, 139));

		// 2.2.19 140
		String visitPage2_2_19=readFromExcelSheet.getCellStringContent(fieldContent, 140);
		if (visitPage2_2_19.equalsIgnoreCase("yes")) {
		SQ2_2_19 sq2_2_19 = PageFactory.initElements(driver, SQ2_2_19.class);
		sq2_2_19.stopApplication();
		}
		
		SQ2_3 sq2_3 = PageFactory.initElements(driver, SQ2_3.class);
		sq2_3.relativeNameDetails(readFromExcelSheet.getCellStringContent(
				fieldContent, 141), i130data,
				(int) readFromExcelSheet.getCellIntegerContent(
						readFromExcelSheet.getRowNumberUsingContent(flowname),
						142));

		SQ2_4 sq2_4 = PageFactory.initElements(driver, SQ2_4.class);
		sq2_4.relativeGender(readFromExcelSheet.getCellStringContent(
				fieldContent, 143));

		SQ2_5 sq2_5 = PageFactory.initElements(driver, SQ2_5.class);
		sq2_5.familyMemberAddress(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 144),
				readFromExcelSheet.getCellStringContent(fieldContent, 145));

		SQ2_6 sq2_6 = PageFactory.initElements(driver, SQ2_6.class);
		sq2_6.familyMemberForeignAddress(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 146));

		SQ2_6_1 sq2_6_1 = PageFactory.initElements(driver, SQ2_6_1.class);
		sq2_6_1.familyMemberAddressInUS(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 147));

		SQ2_7 sq2_7 = PageFactory.initElements(driver, SQ2_7.class);
		sq2_7.familyMemberDateAndPlaceOfBirth(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 148));

		SQ2_8 sq2_8 = PageFactory.initElements(driver, SQ2_8.class);
		sq2_8.familyMemberUseRomanLetters(readFromExcelSheet
				.getCellStringContent(fieldContent, 149));

		SQ2_9 sq2_9 = PageFactory.initElements(driver, SQ2_9.class);
		sq2_9.relativeMaritalStatus(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 150));

		SQ2_10 sq2_10 = PageFactory.initElements(driver, SQ2_10.class);
		sq2_10.relativeDateAndPlaceOfMarriage(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 151));

		SQ2_11 sq2_11 = PageFactory.initElements(driver, SQ2_11.class);
		sq2_11.relativeSpouseInfo(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 152));

		SQ2_12 sq2_12 = PageFactory.initElements(driver, SQ2_12.class);
		sq2_12.relativeSpousePriorMarriage(readFromExcelSheet
				.getCellStringContent(fieldContent, 153), 
				i130data, (int) readFromExcelSheet
				.getCellIntegerContent(fieldContent, 154));

		SQ2_13 sq2_13 = PageFactory.initElements(driver, SQ2_13.class);
		sq2_13.relativeChildrenInfo(readFromExcelSheet.getCellStringContent(
				fieldContent, 155), i130data,
				(int) readFromExcelSheet.getCellIntegerContent(
						readFromExcelSheet.getRowNumberUsingContent(flowname),
						156));

		SQ2_14 sq2_14 = PageFactory.initElements(driver, SQ2_14.class);
		sq2_14.relativeEmploymentDetails(
				readFromExcelSheet.getCellStringContent(fieldContent, 157),
				readFromExcelSheet.getCellStringContent(fieldContent, 158),
				i130data);

		SQ2_15 sq2_15 = PageFactory.initElements(driver, SQ2_15.class);
		sq2_15.relativeSSN_Details(
				readFromExcelSheet.getCellStringContent(fieldContent, 159),
				i130data);

		SQ2_15_1 sq2_15_1 = PageFactory.initElements(driver, SQ2_15_1.class);
		sq2_15_1.relativeARN_Details(
				readFromExcelSheet.getCellStringContent(fieldContent, 160),
				i130data);

		SQ2_16 sq2_16 = PageFactory.initElements(driver, SQ2_16.class);
		sq2_16.relativeBeenToUS(readFromExcelSheet.getCellStringContent(
				fieldContent, 161));

		SQ2_17 sq2_17 = PageFactory.initElements(driver, SQ2_17.class);
		sq2_17.relativeCurrentlyInUS(readFromExcelSheet.getCellStringContent(
				fieldContent, 162));

		SQ2_18 sq2_18 = PageFactory.initElements(driver, SQ2_18.class);
		sq2_18.relativeStatusInUS(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 163));

		SQ2_19 sq2_19 = PageFactory.initElements(driver, SQ2_19.class);
		sq2_19.relativeArrivalNo(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 164));

		SQ2_20 sq2_20 = PageFactory.initElements(driver, SQ2_20.class);
		sq2_20.relativeLastEnteredInUS_Info(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 165));

		SQ2_21 sq2_21 = PageFactory.initElements(driver, SQ2_21.class);
		sq2_21.relativeAdjustmentOfStatus_Info(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 166));

		SQ2_22 sq2_22 = PageFactory.initElements(driver, SQ2_22.class);
		sq2_22.relativeImmigrationProceeding_Info(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 167),
				readFromExcelSheet.getCellStringContent(fieldContent, 168));

		SQ3_1 sq3_1 = PageFactory.initElements(driver, SQ3_1.class);
		sq3_1.applicantPriorPetitions_Info(readFromExcelSheet
				.getCellStringContent(fieldContent, 169), 
				i130data, readFromExcelSheet.getCellStringContent(
				fieldContent, 170), readFromExcelSheet.getCellStringContent(
				fieldContent, 171), (int) readFromExcelSheet
				.getCellIntegerContent(fieldContent, 172));

		// 3.1.1 173
		String visitPage3_1_1=readFromExcelSheet.getCellStringContent(fieldContent, 173);
		if (visitPage3_1_1.equalsIgnoreCase("yes")) {
		SQ3_1_1 sq3_1_1 = PageFactory.initElements(driver, SQ3_1_1.class);
		sq3_1_1.stopApplication();
		}

		SQ3_2 sq3_2 = PageFactory.initElements(driver, SQ3_2.class);
		sq3_2.applicantSeperatePetitions_Info(readFromExcelSheet
				.getCellStringContent(fieldContent, 174), 
				i130data, readFromExcelSheet.getCellStringContent(
				fieldContent, 175), (int) readFromExcelSheet
				.getCellIntegerContent(fieldContent, 176));

		SQ3_3 sq3_3 = PageFactory.initElements(driver, SQ3_3.class);
		sq3_3.applicantParentsInformation(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 177),
				readFromExcelSheet.getCellStringContent(fieldContent, 178));

		SQ4_1 sq4_1 = PageFactory.initElements(driver, SQ4_1.class);
		sq4_1.spouseResidenceInformations(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 179),
				(int) readFromExcelSheet.getCellIntegerContent(fieldContent,
						180));

		SQ4_1_1 sq4_1_1 = PageFactory.initElements(driver, SQ4_1_1.class);
		sq4_1_1.spouseForeignAddress(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 181));

		SQ4_1_1_1 sq4_1_1_1 = PageFactory.initElements(driver, SQ4_1_1_1.class);
		sq4_1_1_1.spouseForeignPhone(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 182));

		SQ4_1_2 sq4_1_2 = PageFactory.initElements(driver, SQ4_1_2.class);
		sq4_1_2.spouseUSAddress(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 183));

		SQ4_1_3 sq4_1_3 = PageFactory.initElements(driver, SQ4_1_3.class);
		sq4_1_3.spouseResidenceOutsideUSInfo(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 184));

		SQ4_1_4 sq4_1_4 = PageFactory.initElements(driver, SQ4_1_4.class);
		sq4_1_4.generalInfoAboutSpouse(readFromExcelSheet.getCellStringContent(
				fieldContent, 185), i130data,
				readFromExcelSheet.getCellStringContent(
						readFromExcelSheet.getRowNumberUsingContent(flowname),
						186), readFromExcelSheet.getCellStringContent(
						fieldContent, 187));

		SQ4_2 sq4_2 = PageFactory.initElements(driver, SQ4_2.class);
		sq4_2.spouseLegalName(i130data, readFromExcelSheet
				.getCellStringContent(fieldContent, 188),
				(int) readFromExcelSheet.getCellIntegerContent(fieldContent,
						189));

		SQ4_3 sq4_3 = PageFactory.initElements(driver, SQ4_3.class);
		sq4_3.spouseGender(readFromExcelSheet.getCellStringContent(
				fieldContent, 190));

		SQ4_7 sq4_7 = PageFactory.initElements(driver, SQ4_7.class);
		sq4_7.spouseDateAndPlaceOfBirth(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 191));

		SQ4_7_1 sq4_7_1 = PageFactory.initElements(driver, SQ4_7_1.class);
		sq4_7_1.spouseParentsInformation(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 192),
				readFromExcelSheet.getCellStringContent(fieldContent, 193));

		SQ4_8 sq4_8 = PageFactory.initElements(driver, SQ4_8.class);
		sq4_8.spouseFamilyUseRomanLetters(readFromExcelSheet
				.getCellStringContent(fieldContent, 194));

		SQ4_9 sq4_9 = PageFactory.initElements(driver, SQ4_9.class);
		sq4_9.spousePriorSpouseMarriageInfo(readFromExcelSheet
				.getCellStringContent(fieldContent, 195), 
				i130data, (int) readFromExcelSheet
				.getCellIntegerContent(fieldContent, 196), readFromExcelSheet
				.getCellStringContent(fieldContent, 197));

		SQ4_10 sq4_10 = PageFactory.initElements(driver, SQ4_10.class);
		sq4_10.spousePriorChildrenInfo(readFromExcelSheet.getCellStringContent(
				fieldContent, 198), i130data,
				(int) readFromExcelSheet.getCellIntegerContent(
						readFromExcelSheet.getRowNumberUsingContent(flowname),
						199));

		SQ4_11 sq4_11 = PageFactory.initElements(driver, SQ4_11.class);
		sq4_11.spouseEmploymentDetails(readFromExcelSheet.getCellStringContent(
				fieldContent, 200), readFromExcelSheet.getCellStringContent(
				fieldContent, 201), readFromExcelSheet.getCellStringContent(
				fieldContent, 202), i130data,
				readFromExcelSheet.getCellStringContent(
						readFromExcelSheet.getRowNumberUsingContent(flowname),
						203), (int) readFromExcelSheet.getCellIntegerContent(
						fieldContent, 204));

		SQ4_11_1 sq4_11_1 = PageFactory.initElements(driver, SQ4_11_1.class);
		sq4_11_1.spouseEmploymentDetailsOutsideUS(
				readFromExcelSheet.getCellStringContent(fieldContent, 205),
				i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 206));

		SQ4_12 sq4_12 = PageFactory.initElements(driver, SQ4_12.class);
		sq4_12.spouseSSN_Details(
				readFromExcelSheet.getCellStringContent(fieldContent, 207),
				i130data);

		SQ4_12_1 sq4_12_1 = PageFactory.initElements(driver, SQ4_12_1.class);
		sq4_12_1.spouseARN_Details(
				readFromExcelSheet.getCellStringContent(fieldContent, 208),
				i130data);

		SQ4_13 sq4_13 = PageFactory.initElements(driver, SQ4_13.class);
		sq4_13.spouseBeenToUS(readFromExcelSheet.getCellStringContent(
				fieldContent, 209));

		SQ4_14 sq4_14 = PageFactory.initElements(driver, SQ4_14.class);
		sq4_14.spouseCurrentlyInUS(readFromExcelSheet.getCellStringContent(
				fieldContent, 210));

		SQ4_15 sq4_15 = PageFactory.initElements(driver, SQ4_15.class);
		sq4_15.spouseStatusInUS(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 211));

		SQ4_16 sq4_16 = PageFactory.initElements(driver, SQ4_16.class);
		sq4_16.spouseArrivalNo(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 212));

		SQ4_17 sq4_17 = PageFactory.initElements(driver, SQ4_17.class);
		sq4_17.spouseLastEnteredInUS_Info(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 213));

		SQ4_18 sq4_18 = PageFactory.initElements(driver, SQ4_18.class);
		sq4_18.spouseAdjustmentOfStatus_Info(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 214));

		SQ4_19 sq4_19 = PageFactory.initElements(driver, SQ4_19.class);
		sq4_19.spouseImmigrationProceeding_Info(i130data,
				readFromExcelSheet.getCellStringContent(fieldContent, 215),
				readFromExcelSheet.getCellStringContent(fieldContent, 216));

		SQ5_1 sq5_1 = PageFactory.initElements(driver, SQ5_1.class);
		sq5_1.spousePriorPetitions_Info(readFromExcelSheet
				.getCellStringContent(fieldContent, 217), i130data, readFromExcelSheet.getCellStringContent(
				fieldContent, 218), readFromExcelSheet.getCellStringContent(
				fieldContent, 219), (int) readFromExcelSheet
				.getCellIntegerContent(fieldContent, 220));

		// 5.1.1 221
		String visitPage5_1_1=readFromExcelSheet.getCellStringContent(fieldContent, 221);
		if (visitPage5_1_1.equalsIgnoreCase("yes")) {
			SQ5_1_1 sq5_1_1 = PageFactory.initElements(driver, SQ5_1_1.class);
			sq5_1_1.stopApplication();
		}
		SQ5_2 sq5_2 = PageFactory.initElements(driver, SQ5_2.class);
		sq5_2.spouseSeperatePetitions_Info(readFromExcelSheet
				.getCellStringContent(fieldContent, 222), 
				i130data, readFromExcelSheet.getCellStringContent(
				fieldContent, 223), (int) readFromExcelSheet
				.getCellIntegerContent(fieldContent, 224));

		// Application Review
		if (!flowname.contains("InEligible")) {

			ApplicationReview appReview = PageFactory.initElements(driver,
					ApplicationReview.class);
			appReview.completeApplicationUsingNewCSS(appName);
		}

		readFromExcelSheet.closeWorkbook();
	}

}

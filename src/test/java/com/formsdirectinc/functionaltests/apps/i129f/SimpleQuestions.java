package com.formsdirectinc.functionaltests.apps.i129f;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.apps.Step;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ1_1;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ1_10;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ1_10_1;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ1_11;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ1_1_1;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ1_2;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ1_3;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ1_4;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ1_5;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ1_6;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ1_7;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ1_8;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ1_9;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ2_1;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ2_10;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ2_11;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ2_11_1;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ2_12;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ2_2;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ2_2_1;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ2_3;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ2_4;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ2_5;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ2_6;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ2_7;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ2_8;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ2_9;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ3_1;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ3_2;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ4_1;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ4_2;
import com.formsdirectinc.functionaltests.apps.i129f.pages.SQ4_2_1;
import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.ApplicationReview;
import com.formsdirectinc.functionaltests.tags.ReadDataFromExcelSheet;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * @author Orina
 * @Product I129 SimpleQuestions
 */
public class SimpleQuestions  extends Step {

	

	public SimpleQuestions(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	String appName = Products.I129F.name();

	public void test(String product, String flowname)
			throws Exception {

		ReadDataFromExcelSheet readFromExcelSheet = new ReadDataFromExcelSheet();
		String i129Sheet = "I129F";
		readFromExcelSheet.initializeWorkbook(i129Sheet);
		Integer fieldContent = readFromExcelSheet
				.getRowNumberUsingContent(flowname);
		
		PropertyResource propertyFile=new PropertyResource();
		Properties i129data = propertyFile.loadProperty("name");
		Properties i129 = propertyFile.loadProperty("i129f");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		// SQ Section :
		ApplicationReview startHere = PageFactory.initElements(driver,
				ApplicationReview.class);
		startHere.selectStartApplication();
		startHere.selectStartHereLink();
		
		// SQ Section
		String usedOtherNames=readFromExcelSheet.getCellStringContent(fieldContent, 5);
		int otherNamesCount=(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 6);
		String country =readFromExcelSheet.getCellStringContent(fieldContent, 7);
		
		SQ1_1 sq1_1 = PageFactory.initElements(driver, SQ1_1.class);
		sq1_1.petitionerInformation(i129data,usedOtherNames	,otherNamesCount,country);

		String movedToYourCurrentAddress=readFromExcelSheet.getCellStringContent(fieldContent, 8);
		String mailingAddSameAsCurrentAdd=readFromExcelSheet.getCellStringContent(fieldContent, 9);
		String servedInArmedForces=readFromExcelSheet.getCellStringContent(fieldContent, 10);
		String armedForcesCountry=readFromExcelSheet.getCellStringContent(fieldContent, 11);
		
		SQ1_1_1 sq1_1_1 = PageFactory.initElements(driver, SQ1_1_1.class);
		sq1_1_1.address(i129data,movedToYourCurrentAddress,mailingAddSameAsCurrentAdd,servedInArmedForces,
								armedForcesCountry);

		
		int otherAddressCount=(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 12);
		String otherAddressCountry=readFromExcelSheet.getCellStringContent(fieldContent, 13);
		String currentAddress=readFromExcelSheet.getCellStringContent(fieldContent, 14);
		
		SQ1_2 sq1_2 = PageFactory.initElements(driver, SQ1_2.class);
		sq1_2.otherAddress(otherAddressCount,otherAddressCountry,currentAddress);

		String livedOutsideUS=readFromExcelSheet.getCellStringContent(fieldContent, 15);
		SQ1_3 sq1_3 = PageFactory.initElements(driver, SQ1_3.class);
		sq1_3.foreignResidence(i129data,livedOutsideUS);

		SQ1_4 sq1_4 = PageFactory.initElements(driver, SQ1_4.class);
		sq1_4.contactInformation(i129data);

		String citizenShipThrough=readFromExcelSheet.getCellStringContent(fieldContent, 16);
		String obtainedCertificateNumber=readFromExcelSheet.getCellStringContent(fieldContent, 17);
		SQ1_5 sq1_5 = PageFactory.initElements(driver, SQ1_5.class);
		sq1_5.applicantUSCISNotfication(i129data,citizenShipThrough,obtainedCertificateNumber);

		String haveSSN=readFromExcelSheet.getCellStringContent(fieldContent, 18);
		SQ1_6 sq1_6 = PageFactory.initElements(driver, SQ1_6.class);
		sq1_6.socialSecurityNumber(i129data,haveSSN);

		String haveARN=readFromExcelSheet.getCellStringContent(fieldContent, 19);
		SQ1_7 sq1_7 = PageFactory.initElements(driver, SQ1_7.class);
		sq1_7.arnDetails(i129data,haveARN);

		String maritalStatus=readFromExcelSheet.getCellStringContent(fieldContent, 20);
		int noOfMarriages=(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 21);
		SQ1_8 sq1_8 = PageFactory.initElements(driver, SQ1_8.class);
		sq1_8.applicantMaritalStatus(i129data,maritalStatus,noOfMarriages);

		String fatherAlive=readFromExcelSheet.getCellStringContent(fieldContent, 22);
		String motherAlive=readFromExcelSheet.getCellStringContent(fieldContent, 23);
		SQ1_9 sq1_9 = PageFactory.initElements(driver, SQ1_9.class);
		sq1_9.parentsInformation(i129data,fatherAlive,motherAlive);

		String workedInPast5Years=readFromExcelSheet.getCellStringContent(fieldContent, 24);
		String workingAtPresent=readFromExcelSheet.getCellStringContent(fieldContent, 25);
		String isThisCurrentOccupation=readFromExcelSheet.getCellStringContent(fieldContent, 26);
		String occupationCountry=readFromExcelSheet.getCellStringContent(fieldContent, 27);
		int employmentCount=(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 28);
		SQ1_10 sq1_10 = PageFactory.initElements(driver, SQ1_10.class);
		sq1_10.employment(workedInPast5Years,workingAtPresent,isThisCurrentOccupation,
								occupationCountry,employmentCount);

		int employmentCounts=(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 29);
		String empCountry=readFromExcelSheet.getCellStringContent(fieldContent, 30);
		
		SQ1_10_1 sq1_10_1 = PageFactory.initElements(driver, SQ1_10_1.class);
		sq1_10_1.employmentHistoryRecent(employmentCounts,empCountry);

		String workedOutSideUS=readFromExcelSheet.getCellStringContent(fieldContent, 31);
		String currentOccupation=readFromExcelSheet.getCellStringContent(fieldContent, 32);
		SQ1_11 sq1_11 = PageFactory.initElements(driver, SQ1_11.class);
		sq1_11.employmentAbroad(i129data,workedOutSideUS,currentOccupation);

		String fianceUsedOtherNames=readFromExcelSheet.getCellStringContent(fieldContent, 33);
		int fianceOtherNameCount=(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 69);
		String fianceGenderIs=readFromExcelSheet.getCellStringContent(fieldContent, 70);
		String fianceLangNonRomanAlphabet=readFromExcelSheet.getCellStringContent(fieldContent, 34);
		
		SQ2_1 sq2_1 = PageFactory.initElements(driver, SQ2_1.class);
		sq2_1.fianceInformation(fianceUsedOtherNames,fianceOtherNameCount,fianceGenderIs,
				fianceLangNonRomanAlphabet);

		
		String inCareOf=readFromExcelSheet.getCellStringContent(fieldContent, 35);
		String homeAddresscountry=readFromExcelSheet.getCellStringContent(fieldContent, 36);
		int homeAddressCount=(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 67);
		String fianceCurrentAddress=readFromExcelSheet.getCellStringContent(fieldContent, 68);
		String fianceCurrentAddressYear=readFromExcelSheet.getCellStringContent(fieldContent, 76);
		SQ2_2 sq2_2 = PageFactory.initElements(driver, SQ2_2.class);
		sq2_2.fianceOtherAddress(i129data,inCareOf,homeAddresscountry,homeAddressCount,fianceCurrentAddress,fianceCurrentAddressYear);

		
		SQ2_2_1 sq2_2_1 = PageFactory.initElements(driver, SQ2_2_1.class);
		sq2_2_1.residences(i129data,
				readFromExcelSheet.getCellStringContent(fieldContent, 38));

		SQ2_3 sq2_3 = PageFactory.initElements(driver, SQ2_3.class);
		sq2_3.fianceResidencesAbroad(i129data,
				readFromExcelSheet.getCellStringContent(fieldContent, 39));

		SQ2_4 sq2_4 = PageFactory.initElements(driver, SQ2_4.class);
		sq2_4.fianceIntendedUsAddress(i129data,
				readFromExcelSheet.getCellStringContent(fieldContent, 40));

		SQ2_5 sq2_5 = PageFactory.initElements(driver, SQ2_5.class);
		sq2_5.fianceSSN(i129data,
				readFromExcelSheet.getCellStringContent(fieldContent, 41));

		SQ2_6 sq2_6 = PageFactory.initElements(driver, SQ2_6.class);
		sq2_6.fianceARNDetails(i129data,
				readFromExcelSheet.getCellStringContent(fieldContent, 42));

		SQ2_7 sq2_7 = PageFactory.initElements(driver, SQ2_7.class);
		sq2_7.fianceMaritalStatus(i129data,
				readFromExcelSheet.getCellStringContent(fieldContent, 43),
				(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 44));

		SQ2_8 sq2_8 = PageFactory.initElements(driver, SQ2_8.class);
		sq2_8.fianceParentsInformation(i129data,
				readFromExcelSheet.getCellStringContent(fieldContent, 45),
				readFromExcelSheet.getCellStringContent(fieldContent, 46));

		SQ2_9 sq2_9 = PageFactory.initElements(driver, SQ2_9.class);
		sq2_9.fianceChildrenDetails(i129data,
				readFromExcelSheet.getCellStringContent(fieldContent, 47),
				(int) readFromExcelSheet
						.getCellIntegerContent(fieldContent, 48),
				readFromExcelSheet.getCellStringContent(fieldContent, 49));

		SQ2_10 sq2_10 = PageFactory.initElements(driver, SQ2_10.class);
		sq2_10.fianceUsTravel(i129data,
				readFromExcelSheet.getCellStringContent(fieldContent, 50),
				readFromExcelSheet.getCellStringContent(fieldContent, 51),
				readFromExcelSheet.getCellStringContent(fieldContent, 52));

		SQ2_11 sq2_11 = PageFactory.initElements(driver, SQ2_11.class);
		sq2_11.fianceEmploymentPart1(i129,
				readFromExcelSheet.getCellStringContent(fieldContent, 53),
				readFromExcelSheet.getCellStringContent(fieldContent, 54),
				readFromExcelSheet.getCellStringContent(fieldContent, 55),
				readFromExcelSheet.getCellStringContent(fieldContent, 56),
				(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 57));

		SQ2_11_1 sq2_11_1 = PageFactory.initElements(driver, SQ2_11_1.class);
		sq2_11_1.fianceEmploymentPart2(i129,
				(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 58),
				readFromExcelSheet.getCellStringContent(fieldContent, 59));

		SQ2_12 sq2_12 = PageFactory.initElements(driver, SQ2_12.class);
		sq2_12.fianceFmploymentAbroad(i129data,
				readFromExcelSheet.getCellStringContent(fieldContent, 60),
				readFromExcelSheet.getCellStringContent(fieldContent, 61));

		SQ3_1 sq3_1 = PageFactory.initElements(driver, SQ3_1.class);
		sq3_1.relationShip(i129data,
				readFromExcelSheet.getCellStringContent(fieldContent, 62));

		SQ3_2 sq3_2 = PageFactory.initElements(driver, SQ3_2.class);
		sq3_2.personalMeeting(i129data,
				readFromExcelSheet.getCellStringContent(fieldContent, 63),
				readFromExcelSheet.getCellStringContent(fieldContent, 64));

		SQ4_1 sq4_1 = PageFactory.initElements(driver, SQ4_1.class);
		sq4_1.previousFilings(i129data, readFromExcelSheet.getCellStringContent(fieldContent, 65),
				(int) readFromExcelSheet.getCellIntegerContent(fieldContent, 66),
				readFromExcelSheet.getCellStringContent(fieldContent, 71), 
				readFromExcelSheet.getCellStringContent(fieldContent, 72));

		String visitSorryPage=readFromExcelSheet.getCellStringContent(fieldContent, 77);
		if((visitSorryPage.equalsIgnoreCase("no")))
		{
		SQ4_2 sq4_2 = PageFactory.initElements(driver, SQ4_2.class);
		sq4_2.criminalRecord(i129data, readFromExcelSheet.getCellStringContent(fieldContent, 73),
									   readFromExcelSheet.getCellStringContent(fieldContent, 74),
									   readFromExcelSheet.getCellStringContent(fieldContent, 75));
		}
	
		else if((visitSorryPage.equalsIgnoreCase("yes")))
		{
			SQ4_2_1 sq4_2_1=PageFactory.initElements(driver, SQ4_2_1.class);
			sq4_2_1.stopApplication();
		}
		// Application Review
		if (!flowname.contains("InEligible")) {

			ApplicationReview appReview = PageFactory.initElements(driver,
					ApplicationReview.class);
			appReview.completeApplicationUsingNewCSS(appName);

		}

		readFromExcelSheet.closeWorkbook();
	}

}
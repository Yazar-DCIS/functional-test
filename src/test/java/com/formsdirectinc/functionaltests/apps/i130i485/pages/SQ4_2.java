package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.EMailAddress;
import com.formsdirectinc.functionaltests.tags.OtherNames;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ4_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ4_2 extends WizardPage {

	private YesNo sameMailAddress, mailCare, sameRelativeHomeAddress;
	private DateTag dateMoved;
	private PhoneNumber applicantNumber;
	private EMailAddress applicantEmail;

	public SQ4_2(WebDriver driver) {
		super(driver);
	}

	public SQ4_2 addressDetails(String sameMailingAddress,
			String receiveMailInCareOfOthers, String similarToRelativeAddress,
			String receiveMailForRelative,String dateMoveToCurrentAddress) {

		PropertyResource propertyFile = new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		String appname = Products.I130I485.name().toLowerCase();
		
		OtherNames careOfName = new OtherNames(driver,"applicationData-applicant");
		Address applicantAddress = new Address(driver);
		
		applicantAddress.setAddressWithoutCountry(appname,"applicant.homeAddress");

		
		dateMoved = new DateTag(driver, "applicant.dateMoveToCurrentAddress");
		dateMoved.selectDate(dateMoveToCurrentAddress);

		
		sameMailAddress = new YesNo(driver, "applicant.sameMailingAddress");
		sameMailAddress.setYesOrNo(sameMailingAddress);
		if (sameMailingAddress.equalsIgnoreCase("No")) {
			applicantAddress.setAddressWithoutCountry(appname,"applicant.mailingAddress");
		}

		mailCare = new YesNo(driver, "applicant.mailCare");
		mailCare.setYesOrNo(receiveMailInCareOfOthers);
		if (receiveMailInCareOfOthers.equalsIgnoreCase("Yes")) {
			careOfName.setMailCareOfName(i130i485
					.getProperty("applicant.mailCareName.first"));
		}

		
		applicantNumber = new PhoneNumber(driver, "applicationData-applicant");
		applicantNumber.setDayTimeNumber(
				i130i485.getProperty("applicant.areacode.daytime"),
				i130i485.getProperty("applicant.number.daytime"));
		applicantNumber.setMobileNumber(
				i130i485.getProperty("applicant.areacode.mobile"),
				i130i485.getProperty("applicant.number.mobile"));

		applicantEmail = new EMailAddress(driver, "applicationData-applicant");
		applicantEmail.setEMailAddress(i130i485.getProperty("applicant.emailAddress"));

		// Is your place of residence the same as Orina's?
		sameRelativeHomeAddress = new YesNo(driver,	"applicant.sameRelativeHomeAddress");
		sameRelativeHomeAddress.setYesOrNo(similarToRelativeAddress);
		if (similarToRelativeAddress.equalsIgnoreCase("no")) {
			applicantAddress.setAddressWithoutCountry(appname,"applicant.relativeHomeAddress");
		}

		
		//Is 1.2A's mailing address the same as 1.2A's place of residence?
		sameRelativeHomeAddress = new YesNo(driver,	"applicant.sameRelativeMailingAddress");
		sameRelativeHomeAddress.setYesOrNo(receiveMailForRelative);
		if (receiveMailForRelative.equalsIgnoreCase("no")) {
		 applicantAddress.setAddressWithoutCountry(appname,"applicant.sameRelativeMailingAddress");

		}
		
		mailCare = new YesNo(driver, "applicant.careofMailAddress");
		mailCare.setYesOrNo(receiveMailForRelative);
		if (receiveMailForRelative.equalsIgnoreCase("Yes")) {
			careOfName.setInCareOfName(i130i485.getProperty("applicant.careofName.first"));
		} 
		
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}

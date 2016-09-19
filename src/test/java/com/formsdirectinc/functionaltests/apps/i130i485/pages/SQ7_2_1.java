package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.OtherExplain;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ7_2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ7_2_1 extends WizardPage {

	private DateTag dateMoveToCurrentAddress2,fromDateLivedTogether,toDateLivedTogether;
	private PhoneNumber foreignRelativeNumber;
	private YesNo everLivedTogether;
	
	public SQ7_2_1(WebDriver driver) {
		super(driver);
	}

	public SQ7_2_1 relativeAddressInfo(String haveLivedTogether, String country,String dateMoveToCurrentAddress) {
		
		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		String appname=Products.I130I485.name().toLowerCase();
		
		
		dateMoveToCurrentAddress2 = new DateTag(driver,
				"foreignRelative.dateMoveToCurrentAddress2");
		dateMoveToCurrentAddress2.selectDate(dateMoveToCurrentAddress);
		
		OtherExplain reasonForDiffAddr=new OtherExplain(driver, "applicationData", "foreignRelative");
		reasonForDiffAddr.setExplainationForDifferentAddress(i130i485.getProperty("foreignRelative.explainDifferentAddress"));

		everLivedTogether=new YesNo(driver, "foreignRelative.everLivedTogether");
		if(haveLivedTogether.equalsIgnoreCase("Yes"))
		{
			everLivedTogether.yes();
			Address relativeAddress=new Address(driver);
			relativeAddress.setAddress(appname, "foreignRelative.addressLivedTogether",country);
			
			fromDateLivedTogether = new DateTag(driver,	"foreignRelative.dateLivedTogether.fromDate");
			fromDateLivedTogether.selectDate(i130i485.getProperty("foreignRelative.dateLivedTogether.fromDate"));
			
			toDateLivedTogether = new DateTag(driver,"foreignRelative.dateLivedTogether.toDate");
			toDateLivedTogether.selectDate(i130i485.getProperty("foreignRelative.dateLivedTogether.toDate"));
			
			
		}
		else if(haveLivedTogether.equalsIgnoreCase("No"))
		{
			everLivedTogether.no();
		}
		
		foreignRelativeNumber = new PhoneNumber(driver,
				"applicationData-foreignRelative.phone2");
		foreignRelativeNumber.setPhoneCode(i130i485.getProperty("foreignRelative.phone2.phone1"));
		foreignRelativeNumber.setPhoneNumber(i130i485.getProperty("foreignRelative.phone2.phone2"));
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		
		return this;
	}

}

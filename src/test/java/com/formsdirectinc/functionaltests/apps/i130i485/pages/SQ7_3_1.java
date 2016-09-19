package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ7_3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ7_3_1 extends WizardPage {

	
	private DateTag dateMoved;

	public SQ7_3_1(WebDriver driver) {
		super(driver);
	}

	public SQ7_3_1 relativeResidencesDetails(String country) {

		String appname=Products.I130I485.name().toLowerCase();
		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		if(country.equalsIgnoreCase("USA")||country.equalsIgnoreCase("notUS"))
		{
		Address relativeAddress=new Address(driver);
		relativeAddress.setAddress(appname, "foreignRelative.addressOutsideUS",country);

		dateMoved = new DateTag(driver,"foreignRelative.dateOutsideUS");
		dateMoved.setStartMonth(i130i485.getProperty("foreignRelative.dateOutsideUS.fromMonth"));
		dateMoved.setStartYear(i130i485.getProperty("foreignRelative.dateOutsideUS.fromYear"));
		dateMoved.setEndMonth(i130i485.getProperty("foreignRelative.dateOutsideUS.toMonth"));
		dateMoved.setEndYear(i130i485.getProperty("foreignRelative.dateOutsideUS.toYear"));
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}

package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ1_2 extends WizardPage {

	private Name_FirstMiddleLast relativeName;

	public SQ1_2(WebDriver driver) {
		super(driver);
	}

	public SQ1_2 relativeName() {
		
		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		relativeName = new Name_FirstMiddleLast(driver, "applicationData",
				"foreignRelative.name");
		relativeName.setFirstNameField(i130i485.getProperty("foreignRelative.name.first"));
		relativeName.setLastNameField(i130i485.getProperty("foreignRelative.name.last"));
		return this;
	}

}

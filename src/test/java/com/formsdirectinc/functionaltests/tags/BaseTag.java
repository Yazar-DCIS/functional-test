package com.formsdirectinc.functionaltests.tags;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;

/**
 * BaseTag: Base class for all tag models
 
 * Author: <a href="mailto:hari@dcis.net">Hari Selvarajan</a> Date: 6/24/15
 * 12:55 PM
 
 * Revision: $Rev$
 */
public class BaseTag {

	protected WebDriver driver;
	protected String beanName;
	protected String property;

	protected Sites site;

	public BaseTag(WebDriver driver, String beanName, String property) {
		this.driver = driver;
		this.beanName = beanName;
		this.property = property;
		this.site = Sites.valueOf(System.getProperty("site.name"));
	}

	public BaseTag(WebDriver driver, String property) {
		this.driver = driver;
		this.property = property;
		this.site = Sites.valueOf(System.getProperty("site.name"));
	}

	public BaseTag(WebDriver driver) {
		this.driver = driver;
		this.site = Sites.valueOf(System.getProperty("site.name"));
	}

}

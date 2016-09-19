package com.formsdirectinc.functionaltests.tags;

import org.openqa.selenium.WebDriver;

/**
 * Repeater: Selenium page model for repeater tag
 
 * Author: <a href="mailto:hari@dcis.net">Hari Selvarajan</a> Date: 6/21/15 4:30
 * PM
 
 * Revision: $Rev$
 */
public class Repeater<T> extends BaseTag {

	private String repeaterProperty;

	public Repeater(WebDriver driver, String beanName, String repeaterProperty,
			String property) {
		super(driver, beanName, property);
		this.repeaterProperty = repeaterProperty;
	}

	public Repeater<T> addAnother(T another) {

		return this;
	}

	public Repeater<T> delete(int index) {
		return this;
	}
}

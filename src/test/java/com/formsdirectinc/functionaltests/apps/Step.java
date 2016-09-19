package com.formsdirectinc.functionaltests.apps;

import org.openqa.selenium.WebDriver;

/**
 * @author Orina
 * @Step Rules for the methods that are used
 */

public abstract class Step {

	protected WebDriver driver;
	public Step nextStep;

	public Step(WebDriver driver) {
		this.driver = driver;
	}

	public Step() {
		// TODO Auto-generated constructor stub
	}

	public void setNextStep(Step nextStep) {
		this.nextStep = nextStep;
	}

	protected void executeNextStep(String product, String flowname) throws Exception {
		if (nextStep != null) {
			nextStep.test(product, flowname);
		}
	}

	public abstract void test(String product, String flowname) throws Exception;
}
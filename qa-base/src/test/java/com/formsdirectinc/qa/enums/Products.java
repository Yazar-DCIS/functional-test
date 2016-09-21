package com.formsdirectinc.qa.enums;

/**
 * Products: Enum listing the products
 * 
 * @author Orina Revision: $Rev$
 */
public enum Products {

	// Products Updated with QandAStyles in LIVE for ALL Sites
	I90("i90"), N400("n400"), N400SE("n400"), I102("i102"), I131("i131"), 
	I824("i824"), I751("i751"), I765("i765"), N565("n565"),

	// Products To be Updated with QandAStyles
	I129F("i129f"), I130("i130"), I130I485("i130-i485"), I134("i134"),
	I485("i485principal"), I539("i539"), I821D("deferredaction"), 
	N600("n600"), DVD("dvd"), I821("i821"),

	I129FQA("i129f"), I130QA("i130"), I130I485QA("i130-i485"),
	I485QA("i485principal"), I539QA("i539"), 
	I821DQA("deferredaction"), N600QA("n600");

	private String productName;

	Products(String productName) {
		this.productName = productName;

	}

	public String getProductName() {
		return this.productName;
	}

}
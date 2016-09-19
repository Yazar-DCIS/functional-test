package com.formsdirectinc.functionaltests.enums;

/**
 * Products: Enum listing the products
 *
 * @author Orina Revision: $Rev$
 */
public enum Products {

	I102("i102"), 
	I129F("i129f"), 
	I130("i130"), 
	I130I485("i130-i485"), 
	I131("i131"), 
	I134("i134"), 
	I485("i485"), 
	I485SINGLE("i485principal"),
	I485MULTI("i485principal"), 
	I539("i539"), 
	I751("i751"), 
	I765("i765"), 
	I821("i821"), 
	I821D("deferredaction"), 
	I824("i824"), 
	I90("i90"), 
	N400("n400"), 
	N565("n565"),
	N600("n600"), 
	DVD("dvd");

	
	private String productNameInCore;

	Products(String productNameInCore) {
		this.productNameInCore = productNameInCore;

	}

	public String getProductNameInCoreSites() {
		return this.productNameInCore;
	}

}
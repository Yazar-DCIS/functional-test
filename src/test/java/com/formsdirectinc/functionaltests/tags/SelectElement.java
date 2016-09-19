package com.formsdirectinc.functionaltests.tags;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * SelectElement: Script for selecting an element with any of ID,LINK,CSS etc
 *
 * @author:Orina <br>
 *               Revision: $Rev$
 */
public class SelectElement extends BaseTag {

	protected String elementName = "%s";
	protected String elementsName = "%s";
	protected WebElement elementField;
	protected WebElement actualElement;
	protected List<WebElement> elementsField;

	public SelectElement(WebDriver driver, String property) {
		super(driver, property);

	}

	PropertyResource propertyFile=new PropertyResource();
	Properties setPropertyValues=propertyFile.loadProperty("name");

	

	public SelectElement selectElementUsingCSS() {

		elementField = driver.findElement(By.cssSelector(String.format(
				elementName, property)));
		elementField.click();
		return this;
	}

	public SelectElement selectElementUsingLinkText() {

		elementField = driver.findElement(By.linkText(String.format(
				elementName, property)));
		elementField.click();
		return this;
	}

	public SelectElement selectElementUsingPartialLinkText() {

		elementField = driver.findElement(By.partialLinkText(String.format(
				elementName, property)));
		elementField.click();
		return this;
	}

	public SelectElement selectElementUsingID() {

		elementField = driver.findElement(By.id(String.format(elementName,
				property)));
		elementField.click();
		return this;
	}

	public SelectElement selectElementUsingName() {

		elementField = driver.findElement(By.name(String.format(elementName,
				property)));
		elementField.click();
		return this;
	}

	public SelectElement selectElementUsingList(int index) {

		elementsField = driver.findElements(By.cssSelector(String.format(
				elementsName, property)));
		elementsField.get(index).click();
		return this;
	}

	public SelectElement selectElementUsingPartialLinkList(int index) {

		elementsField = driver.findElements(By.partialLinkText(String.format(
				elementsName, property)));
		elementsField.get(index).click();
		return this;
	}

	public SelectElement selectElementUsingLinkList(int index) {

		elementsField = driver.findElements(By.linkText(String.format(
				elementsName, property)));
		elementsField.get(index).click();
		return this;
	}

	public SelectElement selectElementUsingCSSList(int index) {

		elementsField = driver.findElements(By.cssSelector(String.format(
				elementsName, property)));
		elementsField.get(index).click();
		return this;
	}
	
	public SelectElement sendValuesUsingElementName(String Name) {

		elementField = driver.findElement(By.name(String.format(elementName,
				property)));
		elementField.sendKeys(Name);
		return this;
	}

	public SelectElement sendValuesUsingElementID(String Name) {

		elementField = driver.findElement(By.id(String.format(elementName,
				property)));
		elementField.sendKeys(Name);
		return this;
	}

	public SelectElement sendValuesByCSS(String Name) {

		elementField = driver.findElement(By.cssSelector(String.format(elementName,
				property)));
		elementField.sendKeys(Name);
		return this;
	}
	
	public SelectElement selectElementUsingListID(int index) {

		elementsField = driver.findElements(By.id(String.format(elementsName,
				property)));
		elementsField.get(index).click();
		return this;
	}

	public SelectElement selectElementUsingListXpath(int index) {

		elementsField = driver.findElements(By.xpath(String.format(
				elementsName, property)));
		elementsField.get(index).click();
		return this;
	}

	public SelectElement selectElementUsingXPath() {

		elementField = driver.findElement(By.xpath(String.format(elementName,
				property)));
		elementField.click();
		return this;
	}

	public SelectElement selectInvisibleElementUsingXpath() {

		int element_size=driver.findElements(By.xpath(String.format(elementName,property))).size();
		elementField =driver.findElements(By.xpath(String.format(String.format(elementName,property)))).get(element_size-1);
		elementField.click();
		return this;
	}
	
	public SelectElement selectValueFromDropDownUsingElementID(String Name) {

		elementField = driver.findElement(By.id(String.format(elementName,
				property)));
		Select ddmElement=new Select(elementField);
		ddmElement.selectByValue(Name);
		return this;
	}
}

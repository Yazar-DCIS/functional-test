package com.formsdirectinc.functionaltests.tags;

/**
 * @author:Orina <br>
 * For Explain This TextBox
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OtherExplain extends BaseTag {

	protected String otherFieldExpression = "%s-%s.tripsExplanation";
	protected String tripExpression = "%s-%s.reasonForTrip";
	protected String meetingDescExpression = "%s-%s.meetingDescription";
	protected String mannerRelationExpression = "%s-%s.mannerRelationEst";
	protected String brokerInfoExpression = "%s-%s.brokerInfo";
	protected String differentAddressExpression = "%s-%s.explainDifferentAddress";
	
	
	protected WebElement otherField;
	private WebElement otherTrip;
	private WebElement explain;

	public OtherExplain(WebDriver driver, String beanName, String property) {
		super(driver, beanName, property);

	}

	public OtherExplain setOtherReason(String reason) {
		otherTrip = driver.findElement(By.id(String.format(
				otherFieldExpression, beanName, property)));
		otherField.clear();
		otherField.sendKeys(reason);
		return this;
	}

	public OtherExplain setOtherTrip(String reason) {
		otherTrip = driver.findElement(By.id(String.format(tripExpression,
				beanName, property)));
		otherTrip.clear();
		otherTrip.sendKeys(reason);
		return this;
	}

	public OtherExplain setMeetingDescription(String reason) {
		explain = driver.findElement(By.id(String.format(meetingDescExpression,
				beanName, property)));
		explain.clear();
		explain.sendKeys(reason);
		return this;
	}

	public OtherExplain setMannerRelation(String reason) {
		explain = driver.findElement(By.id(String.format(
				mannerRelationExpression, beanName, property)));
		explain.clear();
		explain.sendKeys(reason);
		return this;
	}

	public OtherExplain setBrokerAddress(String reason) {
		explain = driver.findElement(By.id(String.format(brokerInfoExpression,
				beanName, property)));
		explain.clear();
		explain.sendKeys(reason);
		return this;
	}
	
	public OtherExplain setExplainationForDifferentAddress(String reason) {
		explain = driver.findElement(By.id(String.format(differentAddressExpression,
				beanName, property)));
		explain.clear();
		explain.sendKeys(reason);
		return this;
	}

}

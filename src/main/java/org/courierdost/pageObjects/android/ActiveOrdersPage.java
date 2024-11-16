package org.courierdost.pageObjects.android;

import org.courierdost.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ActiveOrdersPage extends AndroidActions{
	public AndroidDriver driver;
	
	public ActiveOrdersPage(AndroidDriver driver) {
		super(driver);
		this.driver =driver;
	}

	private WebElement activeOrdersTitle() {
	    return driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Active orders']"));
	}

	public void validateActiveOrdersTitle() {
		activeOrdersTitle().getText();
	}
	private WebElement backButton() {
	    return driver.findElement(AppiumBy.xpath("//android.widget.Button[@clickable='true']"));
	}

	public void clickOnBackButton() {
		backButton().click();
	}
	
	private WebElement readyToPickUp() {
	    return driver.findElement(AppiumBy.accessibilityId("Ready to pick up"));
	}

	public void clickOnreadyToPickUp() {
		readyToPickUp().click();
	}
	
	private WebElement packageDetailsAccordion() {
	    return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(1)"));
	}

	public void clickOnpackageDetailsAccordion() {
		packageDetailsAccordion().click();
	}
	
	private WebElement senderReceiverDetailsAccordion() {
	    return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(2)"));
	}

	public void clickOnsenderReceiverDetailsAccordion() {
		senderReceiverDetailsAccordion().click();
	}
	
	private WebElement deliveryDetailsAccordion() {
	    return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(3)"));
	}

	public void clickOndeliveryDetailsAccordion() {
		deliveryDetailsAccordion().click();
	}
	
	private WebElement assignDeliveryPartner() {
	    return driver.findElement(AppiumBy.accessibilityId("Assign delivery partner"));
	}

	public void clickOnAssignDeliveryPartner() {
		assignDeliveryPartner().click();
	}
	
	private WebElement assignButton() {
	    return driver.findElement(AppiumBy.accessibilityId("Assign"));
	}

	public void clickOnAssign() {
		assignButton().click();
	}
	
	private WebElement firstDeliveryPartner() {
	    return driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"1st Delivery Partner \"]"));
	}

	public void clickOnfirstDeliveryPartner() {
		firstDeliveryPartner().click();
	}
	
	private WebElement secondDeliveryPartner() {
	    return driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"2st Delivery Partner \"]"));
	}

	public void clickOnSecondDeliveryPartner() {
		secondDeliveryPartner().click();
	}

	private WebElement selfRadioButton() {
	    return driver.findElement(AppiumBy.accessibilityId("Self"));
	}

	public void clickOnSelfRadio() {
		selfRadioButton().click();
	}
	
      

}

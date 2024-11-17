package org.courierdost.pageObjects.ios;

import org.courierdost.utils.IOSActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.github.ashwith.flutter.FlutterFinder;

public class ActiveOrderPage extends IOSActions{
	public IOSDriver driver;

	public ActiveOrderPage(IOSDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public FlutterFinder finder = new FlutterFinder(this.driver);

	public WebElement orderNumberHeader() {
		return driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[contains(@name, 'Order #')]"));
	}
	
	public WebElement packageDetailsHeader() {
		return driver.findElement(AppiumBy.xpath("//XCUIElementTypeOther[contains(@name, 'Package Details')]"));
	}
	
	public WebElement waightPerUnitField() {
		return driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name, 'Weight per unit')]"));
	}
	
	public WebElement quantityField() {
		return driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name, 'Quantity')]"));
	}
	
	public WebElement packageValueField() {
		return driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name, 'Package Value')]"));
	}
	
	public WebElement deliveryTypeField() {
		return driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name, 'Delivery Type')]"));
	}
	
	public WebElement pickupDateField() {
		return driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name, 'Pickup Date')]"));
	}
	
	public WebElement pickupTimeField() {
		return driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name, 'Pickup Time')]"));
	}
	
	public WebElement senderReceiverHeader() {
		return driver.findElement(AppiumBy.accessibilityId("Sender & Receiver's Details"));
	}
	
	public WebElement senderHeader() {
		return driver.findElement(AppiumBy.accessibilityId("Sender Details"));
	}
	
	public WebElement receiverHeader() {
		return driver.findElement(AppiumBy.accessibilityId("Receiver Details"));
	}
	
	public WebElement orderIdField() {
		return driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name, 'Order Id')]"));
	}
	
	public WebElement pickUpAddressField() {
		return driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name, 'Pickup Address')]"));
	}
	
	public WebElement phoneField() {
		return driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name, 'Phone')]"));
	}
	
	public WebElement aadharIdField() {
		return driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name, 'Adhaar Id Number')]"));
	}
	
	public WebElement deliveryAddressField() {
		return driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name, 'Delivery Address')]"));
	}
	
	public WebElement deliveryNameField() {
		return driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name, 'Name')]"));
	}
	
	public WebElement deliveryPhoneField() {
		return driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name, 'Name')]/following-sibling::XCUIElementTypeStaticText[contains(@name, 'Phone')]"));
	}
	
	public WebElement deliveryDetailsHeader() {
		return driver.findElement(AppiumBy.accessibilityId("Delivery Details"));
	}
	
	public WebElement courierPartnerField() {
		return driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name, 'Courier Partner')]"));
	}
	
	public WebElement airwayBillField() {
		return driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name, 'Airway Bill (AWB) No')]"));
	}
	
	public WebElement forwardingNumberField() {
		return driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name, 'Forwarding Number')]"));
	}
	
	public WebElement assignDeliverPartner() {
		return driver.findElement(AppiumBy.accessibilityId("Assign delivery partner"));
	}
	
	public WebElement selfAssignRadioButton() {
		return driver.findElement(AppiumBy.accessibilityId("Self"));
	}
	
	public WebElement otherAssignRadioButton() {
		return driver.findElement(AppiumBy.accessibilityId("tetsts"));
	}
	
	public WebElement assignButton() {
		return driver.findElement(AppiumBy.accessibilityId("Assign"));
	}
	
	public WebElement packageDetailAccordian() {
		return driver.findElement(AppiumBy.xpath("//XCUIElementTypeApplication[@name=\"CourierDost Partner\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeButton"));
	}
	
	public WebElement senderAndReceiverAccordian() {
		return driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeButton"));
	}
	
	public WebElement deliveryDetailsAccordian() {
		return driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[4]/XCUIElementTypeButton"));
	}
	
	
	
	// ===========Locators end================================================//
	
	
	public void validateActiveOrderScreenFields() {
		
		waitForElementToAppear(orderNumberHeader(), driver, 20);
		
		Assert.assertTrue(orderNumberHeader().isDisplayed());
		
		waitForElementToAppear(packageDetailsHeader(), driver, 20);
		
		Assert.assertTrue(packageDetailsHeader().isDisplayed());
		
		Assert.assertTrue(waightPerUnitField().isDisplayed());
		
		Assert.assertTrue(quantityField().isDisplayed());
		
		Assert.assertTrue(packageValueField().isDisplayed());
		
		Assert.assertTrue(deliveryTypeField().isDisplayed());
		
		Assert.assertTrue(pickupDateField().isDisplayed());
		
		Assert.assertTrue(pickupTimeField().isDisplayed());
		
		packageDetailAccordian().click();
		
		Assert.assertTrue(senderReceiverHeader().isDisplayed());
		
		Assert.assertTrue(receiverHeader().isDisplayed());
		
		Assert.assertTrue(orderIdField().isDisplayed());
		
		Assert.assertTrue(pickUpAddressField().isDisplayed());
		
		Assert.assertTrue(phoneField().isDisplayed());
		
		Assert.assertTrue(aadharIdField().isDisplayed());
		
		Assert.assertTrue(deliveryAddressField().isDisplayed());
		
		Assert.assertTrue(deliveryNameField().isDisplayed());
		
		Assert.assertTrue(deliveryPhoneField().isDisplayed());
		
		senderAndReceiverAccordian().click();
		
		Assert.assertTrue(deliveryDetailsHeader().isDisplayed());
		
		Assert.assertTrue(courierPartnerField().isDisplayed());
		
		Assert.assertTrue(airwayBillField().isDisplayed());
		
		Assert.assertTrue(forwardingNumberField().isDisplayed());
		
		deliveryDetailsAccordian().click();
		
	}
	
	public void assignDeliveryPartner() {
		
		Assert.assertTrue(assignDeliverPartner().isDisplayed());
		assignDeliverPartner().click();
		selfAssignRadioButton().click();
		otherAssignRadioButton().click();
		assignButton().click();
		
	}
}

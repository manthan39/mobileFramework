package org.courierdost.pageObjects.ios;

import org.courierdost.utils.IOSActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.github.ashwith.flutter.FlutterFinder;

public class HomePage extends IOSActions{
	public IOSDriver driver;

	public HomePage(IOSDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public FlutterFinder finder = new FlutterFinder(this.driver);

	public WebElement newOrderText() {
		return driver.findElement(AppiumBy.accessibilityId("New orders"));
	}
	
	public WebElement domesticTab() {
		return driver.findElement(By.xpath("//XCUIElementTypeImage[@name=\" Domestic\n"
				+ "Tab 1 of 2\"]"));
	}
	
	public WebElement internationalTab() {
		return driver.findElement(By.xpath("//XCUIElementTypeImage[@name=\" International\n"
				+ "Tab 2 of 2\"]"));
	}
	
	

	public WebElement noPickUpRequestHeader() {
		return driver.findElement(AppiumBy.accessibilityId("No pickup requests available"));
	}
	
	public WebElement activeOrderHeader() {
		return driver.findElement(AppiumBy.accessibilityId("Active orders"));
	}
	
	public WebElement activeOrderShowAllLink() {
		return driver.findElement(AppiumBy.accessibilityId("Show all"));
	}
	
	public WebElement firstActiveOrderOnHomePage() {
		return driver.findElement(AppiumBy.xpath("//XCUIElementTypeImage[contains(@name, 'Order ID')]"));
	}
	
	public WebElement firstNewOrderOnHomePage() {
		return driver.findElement(AppiumBy.xpath("(//XCUIElementTypeOther[contains(@name, 'Order ID')])[1]"));
	}
	
	public WebElement pendingOrderClick() {
		return driver.findElement(AppiumBy.xpath("//XCUIElementTypeImage[contains(@name, 'Pending orders')]"));
	}
	
	public WebElement pastOrderlClick() {
		return driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name, 'Past orders')]"));
	}
	
	public WebElement showAllOrderLinkForActiveOrder() {
		return driver.findElement(AppiumBy.xpath("(//XCUIElementTypeImage[@name=\"Show all\"])[1]"));
	}
	
	// ===========Locators end================================================//
	
	public void verifyHomePageElements() {
		waitForElementToAppear(domesticTab(), driver,15);
		Assert.assertTrue(domesticTab().isDisplayed());
	    Assert.assertTrue(internationalTab().isDisplayed());
	    internationalTab().click();
	    domesticTab().click();
	    waitForElementToAppear(newOrderText(), driver,20);
	    Assert.assertTrue(newOrderText().isDisplayed());	
	    Assert.assertTrue(noPickUpRequestHeader().isDisplayed());
	    Assert.assertTrue(activeOrderHeader().isDisplayed());
	    Assert.assertTrue(firstActiveOrderOnHomePage().isDisplayed());
	    scrollToEndAction(driver);
	    Assert.assertTrue(pendingOrderClick().isDisplayed());
	    Assert.assertTrue(pastOrderlClick().isDisplayed());
	    Assert.assertTrue(firstActiveOrderOnHomePage().isDisplayed());
	}
	
	public void showAllactiveOrderList() {
		waitForElementToAppear(activeOrderShowAllLink(), driver,15);
		activeOrderShowAllLink().click();
	}
	
	public void clickOnActiveOrder() {
		waitForElementToBeClickable(firstActiveOrderOnHomePage(), driver, 10);
		firstActiveOrderOnHomePage().click();
	}
	
	public void clickOnNewOrder() {
		waitForElementToBeClickable(firstNewOrderOnHomePage(), driver, 10);
		firstNewOrderOnHomePage().click();
	}
	
	public boolean isNewOrderAvailavle() throws InterruptedException {
		Thread.sleep(5000);
		return firstNewOrderOnHomePage().isDisplayed();
	}
	
	public boolean isActiveOrderrAvailavle() throws InterruptedException {
		Thread.sleep(5000);
		return firstActiveOrderOnHomePage().isDisplayed();
	}
}

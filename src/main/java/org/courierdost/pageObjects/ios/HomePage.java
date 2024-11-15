package org.courierdost.pageObjects.ios;

import org.courierdost.utils.IOSActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

	
	// ===========Locators end================================================//
	
	public void verifyHomePageElements() {
		waitForElementToAppear(newOrderText(), driver,15);
		newOrderText().isDisplayed();
		domesticTab().isDisplayed();
		
	}
}

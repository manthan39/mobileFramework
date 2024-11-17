package org.courierdost.pageObjects.ios;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.Arrays;

import org.courierdost.utils.IOSActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.github.ashwith.flutter.FlutterFinder;

public class LoginPage extends IOSActions{
	
	public IOSDriver driver;

	public LoginPage(IOSDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public FlutterFinder finder = new FlutterFinder(this.driver);
	
	public WebElement clickAlreadyRegisteredButton() {
		return driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Already registered?\n"
				+ " Login\"]"));
	}
	
	public WebElement enterMobileNumberField() {
		return driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"Enter your mobile number\"]"));
											
	}
	
	public WebElement mobileNumberEnter() {
		return driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"Enter your mobile number\n"
				+ "Enter your mobile number\"]"));
	}
	
	public WebElement clickVerifyButton() {
		return driver.findElement(AppiumBy.accessibilityId("Verify"));
	}
	
	public WebElement clickPin() {
		return driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeTextField"));
	}
	
	public WebElement enterPin() {
		return driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeSecureTextField"));
	}
	
	public WebElement clickLoginButton() {
		return driver.findElement(AppiumBy.accessibilityId("Login"));
	}
	
	// ===========Locators end================================================//
	
	public void clickingOnAlredyRegisteredButton() {
		clickAlreadyRegisteredButton().click();
	}
	
	public void inputMobileNumber(String MobileNom) {
		enterMobileNumberField().click();
		mobileNumberEnter().sendKeys(MobileNom);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB);
		
	}
	
	public void clickingOnVerifyButton() {
		waitForElementToBeClickable(clickVerifyButton(), driver,15);
		clickVerifyButton().click();
		
	}
	
	public void addPin(String OTP) {
		clickPin().click();
		enterPin().sendKeys(OTP);
	}
	
	
	public void clickingOnLoginButton() {
		clickLoginButton().click();
		
	}
	

}
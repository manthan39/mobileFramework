package org.courierdost.pageObjects.ios;

import org.courierdost.utils.IOSActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
	
	public WebElement SignUpButton() {
		return driver.findElement(AppiumBy.accessibilityId("Register a new company? Signup"));
	}
	
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
	
	
	public WebElement clickOtp() {
		return driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeTextField"));
	}
	
	public WebElement enterOtp() {
		return driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeTextField"));
	}
	
	public WebElement addfirstPin() {
		return driver.findElement(AppiumBy.accessibilityId("Enter a 4-digit PIN"));

	}

	public WebElement reEnterPin() {
		return driver.findElement(AppiumBy.accessibilityId("Re-enter the 4-digit PIN"));

	}
	
	public WebElement savePINandContinue() {
		return driver.findElement(AppiumBy.accessibilityId("Save PIN and continue"));
	}
	
	public WebElement enterYourName() {
		return driver.findElement(AppiumBy.accessibilityId("Enter your name"));
	}
	
	public WebElement setYourPhotoButton() {
		return driver.findElement(AppiumBy.accessibilityId("Set your profile photo"));
	}
	
	private WebElement chooseFromGalary() {
		return driver.findElement(AppiumBy.accessibilityId("Choose from library"));
	}
	
	private WebElement chhosePhoto() {
		return driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeImage[`name == \"PXGGridLayout-Info\"`][1]"));
	}
	
	private WebElement nextButton() {
		return driver.findElement(AppiumBy.accessibilityId("Next"));
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

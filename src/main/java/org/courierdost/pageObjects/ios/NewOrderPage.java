package org.courierdost.pageObjects.ios;

import java.time.LocalDate;

import org.courierdost.utils.IOSActions;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.github.ashwith.flutter.FlutterFinder;

public class NewOrderPage extends IOSActions{
	public IOSDriver driver;

	public NewOrderPage(IOSDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public FlutterFinder finder = new FlutterFinder(this.driver);

	public WebElement bidNowHeader() {
		return driver.findElement(AppiumBy.accessibilityId("Bid now"));
	}
	
	public WebElement orderIdField() {
		return driver.findElement(AppiumBy.accessibilityId("Order ID"));
	}
	
	public WebElement pickUpLocationField() {
		return driver.findElement(AppiumBy.accessibilityId("Pickup location"));
	}
	
	public WebElement weaightOfOneUnitField() {
		return driver.findElement(AppiumBy.accessibilityId("Weight of 1 unit"));
	}
	
	public WebElement noOfPiecesField() {
		return driver.findElement(AppiumBy.accessibilityId("No. of pieces"));
	}
	
	public WebElement packageValueField() {
		return driver.findElement(AppiumBy.accessibilityId("Package value"));
	}
	
	public WebElement deliveryTypeField() {
		return driver.findElement(AppiumBy.accessibilityId("Delivery type"));
	}
	
	public WebElement pickupDateField() {
		return driver.findElement(AppiumBy.accessibilityId("Pickup date"));
	}
	
	public WebElement pickupTimeField() {
		return driver.findElement(AppiumBy.accessibilityId("Pickup time"));
	}
	
	public WebElement documentImage() {
		return driver.findElement(AppiumBy.xpath("(//XCUIElementTypeImage[1])[2]"));
	}
	
	public WebElement enterYourBidPriceField() {
		return driver.findElement(AppiumBy.accessibilityId("Enter your bid price"));
	}
	
	public WebElement priceInclusiveField() {
		return driver.findElement(AppiumBy.accessibilityId("Inclusive of fuel surcharge and additional charges but Exclusive of GST."));
	}
	
	public WebElement courierPartnerField() {
		return driver.findElement(AppiumBy.accessibilityId("Select courier partner"));
	}
	
	public WebElement selectCourierPartnerField() {
		return driver.findElement(AppiumBy.accessibilityId("DHL"));
	}
	
	public WebElement estimationDateAndTime() {
		return driver.findElement(AppiumBy.accessibilityId("Select Delivery Estimation Date"));
	}
	
	public WebElement selectTomorrowsDate(int day) {
	    String xpath = "//XCUIElementTypeButton[contains(@name, \"" + day + "\")]";
	    return driver.findElement(AppiumBy.xpath(xpath));
	}
	
	public WebElement nextMonthbutton() {
		return driver.findElement(AppiumBy.accessibilityId("Next month"));
	}
	
	public WebElement okButton() {
		return driver.findElement(AppiumBy.accessibilityId("OK"));
	}
	
	public WebElement nextButton() {
		return driver.findElement(AppiumBy.accessibilityId("Place bid"));
	}
	
	public WebElement successMessage() {
		return driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name,\"Bid of\")]"));
	}
	
	public WebElement subTextMessageInSuccessScreen() {
		return driver.findElement(AppiumBy.accessibilityId("This pickup request will appear in the Pending Orders until the sender accepts your bid"));
	}
	
	public WebElement okayButton() {
		return driver.findElement(AppiumBy.accessibilityId("Okay"));
	}
	
	// ===========Locators end================================================//
	
	
	public void VerifyNewBidDetails() {
		assertFieldDisplayedOrNot(bidNowHeader(), driver, 15);
		assertFieldDisplayedOrNot(orderIdField(), driver, 15);
		assertFieldDisplayedOrNot(pickUpLocationField(), driver, 15);
		assertFieldDisplayedOrNot(weaightOfOneUnitField(), driver, 10);
		assertFieldDisplayedOrNot(noOfPiecesField(), driver, 10);
		assertFieldDisplayedOrNot(packageValueField(), driver, 10);
		assertFieldDisplayedOrNot(deliveryTypeField(), driver, 10);
		assertFieldDisplayedOrNot(pickupDateField(), driver, 10);
		assertFieldDisplayedOrNot(pickupTimeField(), driver, 10);
	//	assertFieldDisplayedOrNot(documentImage(), driver, 30);
		assertFieldDisplayedOrNot(enterYourBidPriceField(), driver, 10);
		assertFieldDisplayedOrNot(priceInclusiveField(), driver, 10);
		
	}
	
	public void enterBidPrice() {
		assertFieldDisplayedOrNot(enterYourBidPriceField(), driver, 10);
		enterYourBidPriceField().click();
		enterYourBidPriceField().sendKeys("1200");
		deliveryTypeField().click();
		swipeAction("up");
		
	}
	
	public void selectCourierPartner() {
		assertFieldDisplayedOrNot(courierPartnerField(), driver, 10);
		courierPartnerField().click();
		selectCourierPartnerField().click();
		
	}
	
	public void selectEstimationDateAndTime() {
		assertFieldDisplayedOrNot(estimationDateAndTime(), driver, 10);
		estimationDateAndTime().click();
		int tomorrowDay = LocalDate.now().plusDays(1).getDayOfMonth();
		
		if(tomorrowDay==1 || tomorrowDay==2) {
			nextMonthbutton().click();
		}
		selectTomorrowsDate(tomorrowDay).click();
		okButton().click();
		
		assertFieldDisplayedOrNot(nextButton(), driver, 10);
		nextButton().click();
	}
	
	public void successScreenValidation() throws InterruptedException {
		int successMessageEleCount = driver.findElements(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name,\"Bid of\")]")).size();
		int iterate =0;
		while(successMessageEleCount<1 && iterate<6) {
			Thread.sleep(4000);
			iterate++;
			successMessageEleCount = driver.findElements(AppiumBy.xpath("//XCUIElementTypeStaticText[contains(@name,\"Bid of\")]")).size();
		}
		assertFieldDisplayedOrNot(subTextMessageInSuccessScreen(), driver, 40);
		okayButton().click();
	}
	
	
	
}

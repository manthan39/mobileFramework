package org.courierdost.pageObjects.ios;

import java.time.Duration;
import java.util.Arrays;

import org.courierdost.utils.IOSActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.github.ashwith.flutter.FlutterFinder;

public class SignUpPage extends IOSActions{
	public IOSDriver driver;
	
	public SignUpPage(IOSDriver driver) {
		super(driver);
		this.driver =driver;
	}

	public FlutterFinder finder = new FlutterFinder(this.driver);

	public WebElement getNextButton() {
		return driver.findElement(AppiumBy.accessibilityId("Next"));
	}
	
	public WebElement gstNumber() {
		return driver.findElement(AppiumBy.xpath("//XCUIElementTypeTextField[@name=\"GST number*\n"
				+ "GST number*\"]"));
	}
	
	public WebElement gstNumberInputClick() {
		return driver.findElement(AppiumBy.xpath("//XCUIElementTypeTextField[@name=\"GST number*\"]"));
	}

	public WebElement proceedBtn() {
		return driver.findElement(AppiumBy.accessibilityId("Proceed"));
	}
	
	public WebElement companyNameText() {
		return driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"Bradtke-Keebler\"]"));
	}
	
	public WebElement verifyOTP() {
		return driver.findElement(AppiumBy.accessibilityId("Verify with OTP"));
	}
	
	public void addOTP(String OTP) {
	
		
		WebElement resendOtpElement = driver.findElement(AppiumBy.accessibilityId("Verify number"));

       //  Get the coordinates of the element
        Point elementLocation = resendOtpElement.getLocation();
        int elementX = elementLocation.getX();
        
        int elementY = elementLocation.getY();
        System.out.println(elementX+"=>>>>>>"+ elementY);

        // Define the coordinates above the element
        int clickX = elementX+17;//  Adjusted X coordinate to click in the visible area
        int clickY = elementY-109;// 20 pixels above the element

       //  Using W3C Actions API to perform the tap
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tapSequence = new Sequence(finger, 0);

       //  Move to the tap location and perform a tap
        tapSequence.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), clickX, clickY));
        tapSequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tapSequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        
      //   Perform the tap action
        driver.perform(Arrays.asList(tapSequence));
        driver.perform(Arrays.asList(tapSequence));
        Actions actions = new Actions(driver);
          
          // Type the text with a delay between each character
          String textToType = OTP;
       
          
          actions.sendKeys(textToType);

          // Perform the action sequence
          actions.perform();
	}
	public WebElement verifyOTPNumber() {
		return driver.findElement(AppiumBy.accessibilityId("Verify number"));
	}
	public WebElement addfirstPin() {
		return  driver.findElement(
	            AppiumBy.accessibilityId("Enter a 4-digit PIN")
		        );
		        
	}
	public WebElement reEnterPin() {
		return  driver.findElement(
	            AppiumBy.accessibilityId("Re-enter the 4-digit PIN")
		        );
		
	}
	public WebElement savePINandContinue() {
		return driver.findElement(AppiumBy.accessibilityId("Save PIN and continue"));
	}
	
	private WebElement selectAllInternationalServices() {
		return driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSwitch[`value == \"0\"`][1]"));
	}
	
	private WebElement selectAllDomesticServices() {
		return driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSwitch[`value == \"0\"`][4]"));
	}
	
	private WebElement proceedServiceBtn() {
		return driver.findElement(AppiumBy.accessibilityId("Save PIN and continue"));
	}
	
	private WebElement typeOfServiceScreenHeader() {
		return driver.findElement(AppiumBy.accessibilityId("Types of services\\nSelect the services you offer"));
	}

	//======================================Locators end================================================//
	
	public void clickNextButton() {
		getNextButton().click();
	}
	
	
	public void clickGSTNumberFieldAndSendNumber(String GST) {
		gstNumberInputClick().click();
		gstNumber().sendKeys(GST);
	}
	public void clickProceed() {
		proceedBtn().click();
	}
	public void fillCompanyDetails() {
		verifyOTP().click();
	}
	public void fillOTP(String OTP) throws InterruptedException {
		addOTP(OTP);
		Thread.sleep(3000);
		verifyOTPNumber().click();
		
	}
	
	public void addfirstpin(String pin) {
		addfirstPin().click();
		Actions actions = new Actions(driver);
		actions.sendKeys(pin).perform();
	}
	public void addReEnterpin(String pin) throws InterruptedException {
		reEnterPin().click();
		Actions actions = new Actions(driver);
		actions.sendKeys(pin).perform();;
	}
	public void savePinAndContinue() throws InterruptedException {
		this.
		savePINandContinue().click();
	}
	
	public void selectInternationalDomestic(){
		selectAllInternationalServices().click();
		selectAllDomesticServices().click();
		this.scrollToEndAction();
		proceedServiceBtn().click();
	}
	

}

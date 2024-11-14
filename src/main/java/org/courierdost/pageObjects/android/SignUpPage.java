package org.courierdost.pageObjects.android;

import java.time.Duration;
import java.util.Arrays;

import org.courierdost.utils.AndroidActions;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.github.ashwith.flutter.FlutterFinder;

public class SignUpPage extends AndroidActions{
	public AndroidDriver driver;
	
	public SignUpPage(AndroidDriver driver) {
		super(driver);
		this.driver =driver;
	}

	public FlutterFinder finder = new FlutterFinder(this.driver);

	public WebElement getNextButton() {
		return driver.findElement(AppiumBy.accessibilityId("Next"));
	}
	
	public WebElement gstNumber() {
		return driver.findElement(AppiumBy.xpath("//android.widget.EditText"));
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
	
		//finder.byValueKey("3").click();
	//	driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc="+"Verify your mobile number Please enter the 4-digit OTP sent to"+"]/android.widget.ImageView[3]")).click();
		
		  WebElement resendOtpElement = driver.findElement(AppiumBy.accessibilityId("Verify number"));

       //  Get the coordinates of the element
        Point elementLocation = resendOtpElement.getLocation();
        int elementX = elementLocation.getX();
        
        int elementY = elementLocation.getY();
        System.out.println(elementX+"=>>>>>>"+ elementY);

        // Define the coordinates above the element
        int clickX = elementX+106;//  Adjusted X coordinate to click in the visible area
        int clickY = elementY-289;// 20 pixels above the element

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
          for (char c : textToType.toCharArray()) {
              actions.sendKeys(String.valueOf(c));
              actions.pause(Duration.ofMillis(500));  // Add delay of 500 ms between keystrokes
          }

          // Perform the action sequence
          actions.perform();
	}
	public WebElement verifyOTPNumber() {
		return driver.findElement(AppiumBy.accessibilityId("Verify number"));
	}
	public WebElement addfirstPin() {
		return  driver.findElement(
	            AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)")
		        );
		        
	}
	public WebElement reEnterPin() {
		return  driver.findElement(
	            AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)")
		        );
		
	}
	public WebElement savePINandContinue() {
		return driver.findElement(AppiumBy.accessibilityId("Save PIN and continue"));
	}

	
	public void clickNextButton() {
		getNextButton().click();
	}
	
	
	public void clickGSTNumberFieldAndSendNumber(String GST) {
		gstNumber().click();
		gstNumber().sendKeys(GST);
	//	driver.hideKeyboard();
	}
	public void clickProceed() {
		proceedBtn().click();
	}
	public void fillCompanyDetails() {
		verifyOTP().click();
	}
	public void fillOTP(String OTP) {
		addOTP(OTP);
		
		verifyOTPNumber().click();
		
	}
	
	public void addfirstpin(String pin) {
		addfirstPin().click();
		addfirstPin().sendKeys(pin);
	}
	public void addReEnterpin(String pin) throws InterruptedException {
		//driver.wait(200);
		reEnterPin().click();
		reEnterPin().sendKeys(pin);
	}
	public void savePinAndContinue() {
		savePINandContinue().click();;
	}
	

}

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

public class LoginPage extends AndroidActions{
	public AndroidDriver driver;
	
	public LoginPage(AndroidDriver driver) {
		super(driver);
		this.driver =driver;

	}


    public WebElement mobileNumberInput() {
    	return driver.findElement(AppiumBy.xpath("//android.widget.EditText"));
    }

    public void enterMobileNumber(String mobileNumber) {
        mobileNumberInput().click();
        mobileNumberInput().sendKeys(mobileNumber);
    }

    private WebElement singUpButton() {
        return driver.findElement(AppiumBy.accessibilityId("Register a new company? Signup"));
    }

    public void clickSingUpButton() {
        singUpButton().click();
    }

    private WebElement verifyButton() {
        return driver.findElement(AppiumBy.accessibilityId("Verify"));
    }
    
    public void clickVerifyButton() {
        verifyButton().click();
    }
    
    private WebElement loginLink() {
        return driver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Login')]"));
    }
    
    public void clickloginLink() {
    	loginLink().click();
    }
    
    private WebElement loginButton() {
        return driver.findElement(AppiumBy.accessibilityId("Login"));
    }
    
    public void clickloginButton() {
    	loginButton().click();
    }
    
    
    private WebElement tncdetails() {
        return driver.findElement(AppiumBy.accessibilityId("our terms of service"));
    }

    public void clicktncdetails() {
    	tncdetails().click();
    }
    
    private WebElement privacyPolicy() {
        return driver.findElement(AppiumBy.accessibilityId("privacy policy."));
    }

    public void clickOnPrivacyPolicy() {
    	privacyPolicy().click();
    }
    
    public void addOTP(String OTP) {
    	
		  WebElement resendOtpElement = driver.findElement(AppiumBy.xpath("//android.widget.EditText"));

        Point elementLocation = resendOtpElement.getLocation();
        int elementX = elementLocation.getX();        
        int elementY = elementLocation.getY();
        System.out.println(elementX+"=>>>>>>"+ elementY);
        int clickX = elementX+106;//  Adjusted X coordinate to click in the visible area
        int clickY = elementY-289;// 20 pixels above the element
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tapSequence = new Sequence(finger, 0);
        tapSequence.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), clickX, clickY));
        tapSequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tapSequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));       
        driver.perform(Arrays.asList(tapSequence));
        driver.perform(Arrays.asList(tapSequence));
        Actions actions = new Actions(driver);
          
          String textToType = OTP;
          for (char c : textToType.toCharArray()) {
              actions.sendKeys(String.valueOf(c));
              actions.pause(Duration.ofMillis(500));  // Add delay of 500 ms between keystrokes
          }
          actions.perform();
	}
    
    public void fillOTP(String OTP) {
		addOTP(OTP);		
	}

}

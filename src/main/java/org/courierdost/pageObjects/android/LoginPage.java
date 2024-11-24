package org.courierdost.pageObjects.android;

import java.time.Duration;
import java.util.Arrays;

import org.courierdost.utils.AndroidActions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class LoginPage extends AndroidActions{
	public AndroidDriver driver;
	
	public LoginPage(AndroidDriver driver) {
		super(driver);
		this.driver =driver;

	}


    public WebElement mobileNumberInput() throws InterruptedException {
    	Thread.sleep(2000);
    	return driver.findElement(AppiumBy.xpath("//android.widget.EditText"));
    }

    public void enterMobileNumber(String mobileNumber) throws InterruptedException {
    	
        mobileNumberInput().click();
        waitForElementToBeClickable(mobileNumberInput(), driver, 200);
        waitUntilElementIsClicked(mobileNumberInput(), 200, driver);
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
    	waitUntilElementIsClicked(verifyButton(), 200, driver);
        
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
    private WebElement otpOnLogin() {
    	 return driver.findElement(AppiumBy.xpath("//android.widget.EditText"));
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
    private void fillOTPOnLogin(String pin) throws InterruptedException {
    	Thread.sleep(400);
    	waitForElementToAppear(otpOnLogin(), driver, 500);
	//	otpOnLogin().click();
		waitUntilElementIsClicked(otpOnLogin(), 1000, driver);
		 for (char digit : pin.toCharArray()) {
	            AndroidKey key = getAndroidKeyForDigit(digit);
	            if (key != null) {
	                ((AndroidDriver) driver).pressKey(new KeyEvent(key));
	            } else {
	                throw new IllegalArgumentException("Invalid digit in OTP: " + digit);
	            }
	        }
		
	}
    private AndroidKey getAndroidKeyForDigit(char digit) {
        switch (digit) {
            case '0': return AndroidKey.DIGIT_0;
            case '1': return AndroidKey.DIGIT_1;
            case '2': return AndroidKey.DIGIT_2;
            case '3': return AndroidKey.DIGIT_3;
            case '4': return AndroidKey.DIGIT_4;
            case '5': return AndroidKey.DIGIT_5;
            case '6': return AndroidKey.DIGIT_6;
            case '7': return AndroidKey.DIGIT_7;
            case '8': return AndroidKey.DIGIT_8;
            case '9': return AndroidKey.DIGIT_9;
            default: return null;
        }
    }
    HomePage hp = new HomePage(driver);
    public void logmein(String mobile, String pin) throws InterruptedException {
    	try {
    		
    	
    	WebElement skip= driver.findElement(AppiumBy.accessibilityId("Skip"));
    	waitForElementToAppear(skip, driver, 200);
    	if(skip.isDisplayed()) {
    		skip.click();
    		}
    	}
    	catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
    		 System.out.println("Skip button not found. Proceeding with login.");
		}
    	clickloginLink();
    	
		enterMobileNumber(mobile);
		clickVerifyButton();
		fillOTPOnLogin(pin);
		clickloginButton();
		
		
    }


	

}

package org.courierdost.pageObjects.android;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;

import org.courierdost.utils.AndroidActions;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Origin;
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
	public WebElement yourName() {
		return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)"));
	}
	public WebElement website() {
		return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
	}
	public WebElement alternatePhone() {
		return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)"));
	}
	public void addLOGO() throws IOException {
	    WebElement logoButton = driver.findElement(AppiumBy.accessibilityId("Add company logo (image)"));
	    logoButton.click();
	  
	    // Specify the image file path on the local system
	    File imageFile = new File("src/main/java/org/courierdost/resources/ss.jpeg");
	    
	    // Convert the image file to Base64
	    FileInputStream fileInputStream = new FileInputStream(imageFile);
	    byte[] bytes = new byte[(int) imageFile.length()];
	    fileInputStream.read(bytes);
	    fileInputStream.close();  // Ensure the stream is closed

	    String base64Image = Base64.getEncoder().encodeToString(bytes);

	    driver.executeScript("mobile: shell", Map.of(
	        "command", "echo " + base64Image + " | base64 -d > /sdcard/Pictures/uploaded_image.jpg"
	    ));

	    // Trigger a media scan to ensure the image is indexed
	    driver.executeScript("mobile: shell", Map.of(
	        "command", "am broadcast -a android.intent.action.MEDIA_SCANNER_SCAN_FILE -d file:///sdcard/Pictures/uploaded_image.jpg"
	    ));

	    WebElement choosefromLibrary=driver.findElement(AppiumBy.accessibilityId("Choose from library"));
	    choosefromLibrary.click();
	    // Locate and select the image based on its filename or appearance
	    WebElement uploadedImage = 
	            driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.google.android.providers.media.module:id/icon_thumbnail\").instance(0)"));
	    uploadedImage.click();

	}
	
	public void addOTP(String OTP) {
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
	private WebElement selectAllInternationalServices() {
		return driver.findElement(AppiumBy.androidUIAutomator
				("new UiSelector().className(\"android.widget.CheckBox\").instance(0)"));
	}
	private WebElement selectAllDomesticServices() {
		return driver.findElement(AppiumBy.androidUIAutomator
				("new UiSelector().className(\"android.widget.CheckBox\").instance(3)"));
	}
	private WebElement inviteTeam() {
		return driver.findElement(AppiumBy.xpath("//android.widget.EditText"));
	}
	private WebElement sendInvite() {
		return driver.findElement(AppiumBy.accessibilityId("Send Invite"));
	}
	private void searchlocation(String loc) {
		//android.widget.Button[@resource-id="com.android.permissioncontroller:id/permission_allow_foreground_only_button"] permission
		WebElement location= driver.findElement(AppiumBy.androidUIAutomator
				("new UiSelector().className(\"android.widget.ImageView\").instance(4)"));
		location.click();
		location.sendKeys(loc);
		driver.findElement(AppiumBy.xpath("(//android.view.View[contains(@content-desc, '"+loc+"')])[1]")).click();
				
	}
	private WebElement addMoredetailsOnLocation() {
		return driver.findElement(AppiumBy.accessibilityId("Add more details"));
	}
	private WebElement saveAddressDetails() {
		return driver.findElement(AppiumBy.accessibilityId("Save"));
	}
	//----------------------------------------------Locators above -----------------------//
	public void clickNextButton() {
		getNextButton().click();
	}
	
	public void clickGSTNumberFieldAndSendNumber(String GST) {
		gstNumber().click();
		gstNumber().sendKeys(GST);
		driver.hideKeyboard();
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
	public void addReEnterpin(String pin) {
		reEnterPin().click();
		reEnterPin().sendKeys(pin);
	}
	public void savePinAndContinue() {
		savePINandContinue().click();;
	}
	public void selectInternationalDomestic(){
		selectAllInternationalServices().click();
		selectAllDomesticServices().click();
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	    Sequence swipe = new Sequence(finger, 1);

	    // Start point (bottom-middle of the screen)
	    swipe.addAction(finger.createPointerMove(Duration.ZERO, Origin.viewport(), 500, 1500));
	    swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	    // End point (top-middle of the screen)
	    swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), Origin.viewport(), 500, 100));
	    swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	    // Perform the swipe
	    driver.perform(Arrays.asList(swipe));
		proceedBtn().click();
	}
	
	
	public void addAdditionalDetailsName(String name) {
		yourName().click();
		yourName().sendKeys(name);
	}
public void addAdditionalDetailsWeblink(String weblink) {
	website().click();
		website().sendKeys(weblink);
	}
public void addAdditionalDetailsPhone(String phno) {
	alternatePhone().click();
	alternatePhone().sendKeys(phno);
}
	public void saveAddCompanyLogo() throws IOException {
		addLOGO();
	}
	public void proceedAdditionalDetails() {
		proceedBtn().click();
	}
	public void inviteTeaWithPhone(String invitePh) {
		inviteTeam().click();
		inviteTeam().sendKeys(invitePh);
	}
	public void clickSendInvite() {
		sendInvite().click();
	}
	public void searchforLocation(String loc) {
		searchlocation(loc);
	}
	public void clickAddmoreDetails() {
		addMoredetailsOnLocation().click();
	}
	public void clickSaveAddressDetails() {
		saveAddressDetails().click();
	}
}

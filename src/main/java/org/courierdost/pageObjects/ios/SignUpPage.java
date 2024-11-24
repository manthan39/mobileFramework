package org.courierdost.pageObjects.ios;

import static org.testng.Assert.assertTrue;

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
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.ios.IOSDriver;
import io.github.ashwith.flutter.FlutterFinder;

public class SignUpPage extends IOSActions {
	public IOSDriver driver;

	public SignUpPage(IOSDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public FlutterFinder finder = new FlutterFinder(this.driver);

	public WebElement getNextButton() {
		return driver.findElement(AppiumBy.accessibilityId("Next"));
	}

	public WebElement gstNumber() {
		return driver
				.findElement(AppiumBy.xpath("//XCUIElementTypeTextField[@name=\"GST number*\n" + "GST number*\"]"));
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
	
	public WebElement verifyOTPNumber() {
		return driver.findElement(AppiumBy.accessibilityId("Verify number"));
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

	private WebElement selectAllInternationalServices() {
		return driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSwitch[`value == \"0\"`][1]"));
	}

	private WebElement selectAllDomesticServices() {
		return driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSwitch[`value == \"0\"`][4]"));
	}
	
	private WebElement enterYourName() {
		return driver.findElement(AppiumBy.accessibilityId("Your name"));
	}
	
	private WebElement enterWebSiteLink() {
		return driver.findElement(AppiumBy.accessibilityId("Website link"));
	}
	
	private WebElement enteralternatePhoneNumber() {
		return driver.findElement(AppiumBy.accessibilityId("Alternate phone number"));
	}
	
	private WebElement addCompanyLogo() {
		return driver.findElement(AppiumBy.accessibilityId("Add company logo (image)"));
	}
	
	private WebElement chooseFromGalary() {
		return driver.findElement(AppiumBy.accessibilityId("Choose from library"));
	}
	
	private WebElement chhosePhoto() {
		return driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeImage[`name == \"PXGGridLayout-Info\"`][1]"));
	}
	
	public WebElement inputPhoneNumber() {
		return driver.findElement(AppiumBy.accessibilityId("Phone number"));
	}
	
	public WebElement inputPhoneNumber2() {
		return driver.findElement(AppiumBy.xpath("(//XCUIElementTypeTextField[@name='Phone number'])[2]"));
	}
	
	public WebElement sendInviteButton() {
		return driver.findElement(AppiumBy.accessibilityId("Send Invite"));
	}
	
	private WebElement searchBar() {
		return driver.findElement(AppiumBy.accessibilityId("Search for a specific locality"));
	}
	
	private WebElement seelctFirstSuggestions() {
		return driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Ahmedabad\n"
				+ "Ahmedabad, Gujarat, India\"]"));
	}
	
	private WebElement addMoreDetailsButton() {
		return driver.findElement(AppiumBy.accessibilityId("Add more details"));
	}
	
	private WebElement addressSaveButton() {
		return driver.findElement(AppiumBy.accessibilityId("Save"));
	}

	private WebElement emptyGstNumberError() {
		return driver.findElement(AppiumBy.accessibilityId("The gst must not be empty"));
	}
	
	private WebElement invalidGSTNumberError() {
		return driver.findElement(AppiumBy.accessibilityId("[Internal Error]: [401] [Invalid gst number format}]"));
	}
	
	public WebElement enterValidOTPError() {
		return driver.findElement(AppiumBy.accessibilityId("Please enter valid otp"));
	}
	
	public WebElement emptyPinError() {
		return driver.findElement(AppiumBy.accessibilityId("The pin must not be empty"));
	}
	
	public WebElement emptyConfirmPinError() {
		return driver.findElement(AppiumBy.accessibilityId("The confirm pin must not be empty"));
	}
	
	public WebElement pinShouldBeMatchError() {
		return driver.findElement(AppiumBy.accessibilityId("PIN should match"));
	}
	
	public WebElement yourNameError() {
		return driver.findElement(AppiumBy.accessibilityId("Name is mandatory."));
	}
	
	public WebElement mobileNumberError() {
		return driver.findElement(AppiumBy.accessibilityId("Mobile number should be 10 digits"));
	}
	
	public WebElement emptyMobileNumberError() {
		return driver.findElement(AppiumBy.accessibilityId("Please Enter Mobile Number"));
	}
	
	public WebElement enterValidMobileNumberError() {
		return driver.findElement(AppiumBy.accessibilityId("Please Enter Valid Mobile Number"));
	}
	
	public WebElement addMoreButton() {
		return driver.findElement(AppiumBy.accessibilityId("+ Add more"));
	}
	
	public WebElement skipButton() {
		return driver.findElement(AppiumBy.accessibilityId("Skip"));
	}
	
	public WebElement backArrowFromInviteYourTEam() {
		return driver.findElement(AppiumBy.xpath("(//XCUIElementTypeButton)[1]"));
	}
	
	public WebElement clickSupervisor() {
		return driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeOther[`name == \"Supervisor\"`]"));
	}
	
	public WebElement crossSignOnAddressDetails() {
		return driver.findElement(AppiumBy.xpath("//XCUIElementTypeApplication[@name=\"CourierDost Partner\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[2]/XCUIElementTypeOther[3]/XCUIElementTypeButton"));
	}
	
	public WebElement addressLine1Error() {
		return driver.findElement(AppiumBy.accessibilityId("Address line 1 is required"));
	}
	
	
	public WebElement enterAddressLine1() {
		return driver.findElement(AppiumBy.accessibilityId("Address line 1"));
	}
	// ===========Locators end================================================//
	
	
	public void inviteYourFriendScreenError() {
		inputPhoneNumber().click();
		backArrowFromInviteYourTEam().click();
		proceedBtn().click();
		
		waitForElementToBeClickable(inputPhoneNumber(),driver,10);
		assertTrue(emptyMobileNumberError().isDisplayed());
		inputPhoneNumber().click();
		inputPhoneNumber().sendKeys("23423");
		assertTrue(enterValidMobileNumberError().isDisplayed());
		inputPhoneNumber().click();
		inputPhoneNumber().clear();
		skipButton().click();
	}
	
	
	public void addressDetailsError() {
		waitForElementToBeClickable(searchBar(),driver,20);
		searchBar().click();
		searchBar().sendKeys("Ahmedabad");
		waitForElementToAppear(seelctFirstSuggestions(), driver,15);
		seelctFirstSuggestions().click();
		waitForElementToBeClickable(addMoreDetailsButton(), driver,15);
		addMoreDetailsButton().click();
		
		waitForElementToAppear(addressSaveButton(), driver, 10);
		
		crossSignOnAddressDetails().click();
		addressSaveButton().click();
		assertTrue(addressLine1Error().isDisplayed());
		
		enterAddressLine1().click();
		enterAddressLine1().sendKeys("ellise bridge");
		addressSaveButton().click();
		
		
		
	}
	
	public void additionaDetailsError() {
		waitForElementToAppear(enterYourName(), driver,15);
		enterYourName().click();
		enterYourName().sendKeys("\t");
		driver.hideKeyboard();
		assertTrue(yourNameError().isDisplayed());
		
		enteralternatePhoneNumber().click();
		enteralternatePhoneNumber().sendKeys("\t");
		enterYourName().click();
		assertTrue(mobileNumberError().isDisplayed());
	}
	
	public void validateErrormessagesForGST() {
		gstNumberInputClick().click();
		gstNumber().sendKeys("\t");
		driver.hideKeyboard();
		assertTrue(emptyGstNumberError().isDisplayed());
		gstNumberInputClick().sendKeys("ABCDEFGH");
		proceedBtn().click();
		waitForElementToAppear(invalidGSTNumberError(), driver, 10);
		assertTrue(invalidGSTNumberError().isDisplayed());
	}
	
	public void clickNextButtonForOnboardingScreen() {
		getNextButton().click();
		getNextButton().click();
		getNextButton().click();
	}

	public void clickGSTNumberFieldAndSendNumber(String GST) {
		gstNumberInputClick().click();
		gstNumber().clear();
		gstNumber().sendKeys(GST);
		proceedBtn().click();
	}

	public void clickProceed() {
		proceedBtn().click();
	}

	public void clickOnVerifyOtp() {
		verifyOTP().click();
	}

	public void addOTP(String OTP) {

		WebElement resendOtpElement = driver.findElement(AppiumBy.accessibilityId("Verify number"));

		Point elementLocation = resendOtpElement.getLocation();
		int elementX = elementLocation.getX();

		int elementY = elementLocation.getY();

		int clickX = elementX + 17;// Adjusted X coordinate to click in the visible area
		int clickY = elementY - 109;// 20 pixels above the element

		// Using W3C Actions API to perform the tap
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence tapSequence = new Sequence(finger, 0);

		// Move to the tap location and perform a tap
		tapSequence.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), clickX, clickY));
		tapSequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
		tapSequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

		// Perform the tap action
		driver.perform(Arrays.asList(tapSequence));
		driver.perform(Arrays.asList(tapSequence));
		Actions actions = new Actions(driver);

		String textToType = OTP;

		actions.sendKeys(textToType);

		actions.perform();
	}

	public void fillOTP(String OTP) throws InterruptedException {
		addOTP(OTP);
		waitForElementToBeClickable(verifyOTPNumber(), driver,15);
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
		actions.sendKeys(pin).perform();
		
		waitForElementToAppear(savePINandContinue(), driver,15);
		savePINandContinue().click();
	}

	public void savePinAndContinue() throws InterruptedException {
		waitForElementToAppear(savePINandContinue(), driver,15);
		savePINandContinue().click();
	}

	public void selectInternationalDomestic() {
		selectAllInternationalServices().click();
		selectAllDomesticServices().click();
		scrollToEndAction(driver);
		proceedBtn().click();
	}
	
	public void additionalDetailsPage(StringBuilder name,StringBuilder website,String number) throws InterruptedException {
		
		waitForElementToAppear(enterYourName(), driver,15);
		enterYourName().click();
		enterYourName().sendKeys(name);
		
		enterWebSiteLink().click();
		enterWebSiteLink().sendKeys(website);
		
		enteralternatePhoneNumber().click();
		enteralternatePhoneNumber().sendKeys(number);
		
		addCompanyLogo().click();
		chooseFromGalary().click();
		chhosePhoto().click();
		waitForElementToBeClickable(proceedBtn(), driver,15);
		proceedBtn().click();
	}
	
	public void enterPhoneNumberAndSendInvite(String phoneNumber) {
		
		waitForElementToBeClickable(inputPhoneNumber(), driver,90);
		inputPhoneNumber().click();
		inputPhoneNumber().sendKeys(phoneNumber);
		waitForElementToBeClickable(sendInviteButton(), driver,15);
		sendInviteButton().click();
	}
	
	public void searchAreaAndSaveAddress() {
		waitForElementToBeClickable(searchBar(),driver,20);
		searchBar().click();
		searchBar().sendKeys("Ahmedabad");
		waitForElementToAppear(seelctFirstSuggestions(), driver,15);
		seelctFirstSuggestions().click();
		waitForElementToBeClickable(addMoreDetailsButton(), driver,15);
		addMoreDetailsButton().click();
		waitForElementToBeClickable(addressSaveButton(), driver,15);
		addressSaveButton().click();
	}
	
	
	

}

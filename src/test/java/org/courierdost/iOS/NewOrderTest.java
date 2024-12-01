package org.courierdost.iOS;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.courierdost.TestUtils.IOSBaseTest;
import org.courierdost.pageObjects.ios.HomePage;
import org.courierdost.pageObjects.ios.LoginPage;
import org.courierdost.pageObjects.ios.NewOrderPage;
import org.courierdost.pageObjects.ios.SignUpPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewOrderTest extends IOSBaseTest {
	SignUpPage signUpObj;
	LoginPage loginPageObj;
	HomePage homePageObj;
	NewOrderPage newOrderObj;

	@BeforeTest(alwaysRun = true)
	public void setUpProperty() throws IOException {
		loadProperties();
	}

	@Test(groups = {"Smoke"},description = "Verfiy the new order screen if new orders available in homepage")
	public void newOrderVerification() throws InterruptedException, IOException {
		signUpObj = new SignUpPage(driver);
		signUpObj.clickNextButtonForOnboardingScreen();

		loginPageObj = new LoginPage(driver);
		loginPageObj.clickingOnAlredyRegisteredButton();
		loginPageObj.inputMobileNumber(getPropertyOnKey("Mobile1"));
		loginPageObj.clickingOnVerifyButton();
		loginPageObj.addPin(getPropertyOnKey("PIN1"));
		loginPageObj.clickingOnLoginButton();

		homePageObj = new HomePage(driver);
		if (homePageObj.noNewOrderAvailable() == 0) {
			homePageObj.clickOnNewOrder();

			newOrderObj = new NewOrderPage(driver);
			newOrderObj.VerifyNewBidDetails();
			newOrderObj.enterBidPrice();
			newOrderObj.selectCourierPartner();
			newOrderObj.selectEstimationDateAndTime();
			newOrderObj.successScreenValidation();
		} else {
			assertTrue(homePageObj.noPickUpRequestHeader().isDisplayed());
			System.out.println("New order is not available at this moment.");
		}

	}

}

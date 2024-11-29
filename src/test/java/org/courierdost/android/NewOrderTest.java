package org.courierdost.android;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.courierdost.TestUtils.AndroidBaseTest;
import org.courierdost.pageObjects.android.HomePage;
import org.courierdost.pageObjects.android.LoginPage;
import org.courierdost.pageObjects.android.NewOrderPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewOrderTest extends AndroidBaseTest{
	
	@BeforeClass(alwaysRun = true)
	public void setUpProperty() throws IOException, InterruptedException {
		loadProperties();
		LoginPage lpt = new LoginPage(driver);
		lpt.logmein(getPropertyOnKey("Mobile1"),getPropertyOnKey("PIN1"));
	}
	
	@Test
	public void newOrderVerification() throws InterruptedException, IOException {
		HomePage homePageObj = new HomePage(driver);
		if(homePageObj.isNewOrderAvailavle()) {
			homePageObj.clickOnNewOrder();
			
			NewOrderPage newOrderObj = new NewOrderPage(driver);
			newOrderObj.VerifyNewBidDetails();
			newOrderObj.enterBidPrice();
			newOrderObj.selectCourierPartner();
			newOrderObj.selectEstimationDateAndTime();
			newOrderObj.successScreenValidation();
		}else {
			assertTrue(homePageObj.noPickUpRequestHeader().isDisplayed());
			System.out.println("New order is not available at this moment.");
		}
		
		
	}

}

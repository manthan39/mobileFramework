package org.courierdost.android;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.courierdost.TestUtils.AndroidBaseTest;
import org.courierdost.utils.AndroidActions;
import org.courierdost.pageObjects.android.ActiveOrdersPage;
import org.courierdost.pageObjects.android.HomePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActiveOrdersTest extends AndroidBaseTest  {
	ActiveOrdersPage activeOrdersObj;
	HomePage homePageObj;

	@BeforeTest(alwaysRun = true)
	public void setUpProperty() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//org//courierdost//testData//testdata.properties");
		prop.load(fis);
		fis.close();

		
	}

	@Test
	public void homepageAsVendor() throws InterruptedException {
		
		activeOrdersObj = new ActiveOrdersPage(driver);
		
		homePageObj = new HomePage(driver);
		
		homePageObj.clickOnShowAllBtn();
		activeOrdersObj.clickOnBackButton();
		homePageObj.clickOnShowAllBtn();
		activeOrdersObj.clickOnreadyToPickUp();
		activeOrdersObj.clickOnpackageDetailsAccordion();
		activeOrdersObj.clickOnsenderReceiverDetailsAccordion();
		activeOrdersObj.clickOndeliveryDetailsAccordion();
		activeOrdersObj.clickOnAssignDeliveryPartner();
		activeOrdersObj.clickOnfirstDeliveryPartner();
		activeOrdersObj.clickOnSelfRadio();
		activeOrdersObj.clickOnSecondDeliveryPartner();
		activeOrdersObj.clickOnAssign();

	}
	
}

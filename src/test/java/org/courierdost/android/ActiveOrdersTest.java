package org.courierdost.android;

import org.courierdost.TestUtils.AndroidBaseTest;
import org.courierdost.utils.AndroidActions;
import org.courierdost.pageObjects.android.ActiveOrdersPage;
import org.courierdost.pageObjects.android.HomePage;
import org.testng.annotations.Test;

public class ActiveOrdersTest extends AndroidBaseTest  {
	ActiveOrdersPage activeOrdersObj;
	HomePage homePageObj;

	
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

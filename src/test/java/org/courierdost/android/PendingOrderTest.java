package org.courierdost.android;

import java.io.IOException;
import org.courierdost.TestUtils.AndroidBaseTest;
import org.courierdost.pageObjects.android.LoginPage;
import org.courierdost.pageObjects.android.PendingOrderPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PendingOrderTest extends AndroidBaseTest {
	
	PendingOrderPage pop;
	@BeforeClass(alwaysRun = true)
	public void setUpProperty() throws IOException, InterruptedException {
	loadProperties();
	LoginPage lpt = new LoginPage(driver);
	lpt.logmein(getPropertyOnKey("Mobile1"),getPropertyOnKey("PIN1"));
	pop = new PendingOrderPage(driver);
	}
	
	@Test
	public void blankcheck() throws InterruptedException {
		pop.clickPendingOrderButton();
		pop.isOrderDetailDisplayed();
		pop.clickOrderID();
		pop.isPackageDetailsVisible();
	}
}

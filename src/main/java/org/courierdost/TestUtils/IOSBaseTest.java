package org.courierdost.TestUtils;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.courierdost.utils.AppiumUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class IOSBaseTest extends AppiumUtils {

	public IOSDriver driver;
	public AppiumDriverLocalService service;

	@BeforeClass(alwaysRun = true)
	public void ConfigureAppium() throws IOException {

		// service = startAppiumServer(ipAddress,Integer.parseInt(port));

		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("iPhone 16 Pro");
		options.setApp(System.getProperty("user.dir") + "//src//main//java//org//courierdost//resources//Runner.app");

		/// Users/bhagatsinhk/Documents/bgtkher002/AppiumFramework/src/test/java/org/courierdost/resources
		options.setPlatformVersion("18.1");
		// Appium- Webdriver Agent -> IOS Apps.
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
		options.setCapability("autoAcceptAlerts", true);

		driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}

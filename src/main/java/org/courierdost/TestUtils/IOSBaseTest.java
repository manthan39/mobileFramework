package org.courierdost.TestUtils;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.courierdost.utils.AppiumUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class IOSBaseTest extends AppiumUtils {

	public IOSDriver driver;
	public AppiumDriverLocalService service;
	public Properties prop;
	public Properties propertiesCap;

	@BeforeMethod(alwaysRun = true)
	public void ConfigureAppium() throws IOException {

		String iOSPlatformVersion = "15";
		String iOSDeviceNAme = "iPhone 13 Pro";
		String permissions = "{\"com.itdcd.vendor\": {\"photos\": \"yes\", \"location\": \"yes\"}}";

		XCUITestOptions options = new XCUITestOptions();
	//	options.setDeviceName(iOSDeviceNAme);
	//	options.setApp(System.getProperty("user.dir") + "//src//main//java//org//courierdost//resources//Runner.app");

		options.setPlatformVersion(iOSPlatformVersion);
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
		options.setCapability("autoAcceptAlerts", true);
		options.setCapability("autoDismissKeyboard", true);
		options.setCapability("permissions", permissions);
		driver = new IOSDriver(new URL("http://hub.browserstack.com/wd/hub"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

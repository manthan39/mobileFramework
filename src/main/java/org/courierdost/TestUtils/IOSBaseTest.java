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
//	@Parameters({"platformVersion", "deviceName"})
	public void ConfigureAppium(String platformVersion, String deviceName) throws IOException {

		String iOSPlatformVersion = platformVersion;
		String iOSDeviceNAme = deviceName;
		String permissions = "{\"com.itdcd.vendor\": {\"photos\": \"yes\", \"location\": \"yes\"}}";

		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName(iOSDeviceNAme);
		options.setApp(System.getProperty("user.dir") + "//src//main//java//org//courierdost//resources//Runner.app");

		options.setPlatformVersion(iOSPlatformVersion);
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
		options.setCapability("autoAcceptAlerts", true);
		options.setCapability("autoDismissKeyboard", true);
		options.setCapability("permissions", permissions);
		driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

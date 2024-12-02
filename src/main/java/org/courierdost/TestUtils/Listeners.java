package org.courierdost.TestUtils;

import java.io.IOException;

import org.courierdost.utils.AppiumUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Log;

import io.appium.java_client.AppiumDriver;

public class Listeners extends AppiumUtils implements ITestListener{
	ExtentTest test;
	ExtentReports extent = ExtentReporterNG.getReporterObject();
	AppiumDriver driver;
	
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Started: " + result.getName());
    	test= extent.createTest(result.getMethod().getMethodName()).info(result.getMethod().getDescription());
		 
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Passed: " + result.getName());
		test.log(Status.PASS, "Test Passed");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//screenshot code
		System.out.println("Test Failed: " + result.getName());
		test.fail(result.getThrowable());
		
		try {
			driver = (AppiumDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try {
			test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(),driver), result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("Test Skipped: " + result.getName());
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Test Suite Started: " + context.getName());
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Test Suite Finished: " + context.getName());
		extent.flush();
	}
//
	
}

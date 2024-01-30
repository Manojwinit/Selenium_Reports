package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import testSetup.Base;

public class Listeners extends Base implements ITestListener {
	ExtentTest test;
	ExtentReports extent = ExternalReporter.getReportsObject();
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.get().pass("Test Passed");
		//extentTest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
	    WebDriver driver = null;
	    String testMethodName = result.getMethod().getMethodName();
	    try {
	        driver = (WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver")
	                .get(result.getInstance());
	    } catch (NoSuchFieldException | IllegalAccessException e) {
	        e.printStackTrace();
	        extentTest.get().log(Status.FAIL, "Test Failed with Exception: " + e.getMessage());
	    }
	    try {
	        extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName, driver), testMethodName);
	    } catch (IOException e) {
	        e.printStackTrace();
	        System.out.println("Screenshot capture not working");
	    }
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println(result.getMethod().getMethodName() + ":Method is skipped");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test Suite is starting...");

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test Suite is finishing...");
	    // You may want to flush and close your ExtentReports instance here
	    extent.flush();

	}

}

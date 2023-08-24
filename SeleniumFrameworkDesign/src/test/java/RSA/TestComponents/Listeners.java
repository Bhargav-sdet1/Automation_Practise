package RSA.TestComponents;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import RSA.resources.ExtendReporterNG;

public class Listeners implements ITestListener {
	
	ExtentReports extent = ExtendReporterNG.GetExtentReport();
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		// not implemented
		test=extent.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		// not implemented
		test.
	}

	public void onTestFailure(ITestResult result) {
		// not implemented
	}

	public void onTestSkipped(ITestResult result) {
		// not implemented
	}

	public void onStart(ITestContext context) {
		// not implemented
	}

	public void onFinish(ITestContext context) {
		// not implemented
	}
}

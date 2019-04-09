package main.java.it.listeners;


import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import main.java.it.listeners.verify.Fail;

public class TestFailureListeners implements ITestListener{

	static String s ="";
//	static WebDriver driver;
//	static ExtentTest _report;
//
//	public TestFailureListeners(WebDriver driver, ExtentTest _report){
//		TestFailureListeners.driver = driver;
//		TestFailureListeners._report = _report;
//	}
	@Override
	public void onFinish(ITestContext context) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onTestFailure(ITestResult result) {

		System.out.println("****ERROR**"+result.getName()+" test has failed");
//		_report.log(LogStatus.FAIL, "Test case failed is "+result.getName());
//		_report.log(LogStatus.FAIL, "Test case failed is "+result.getThrowable());
//		String screenshotPath= Fail.getScreenshot(driver,result.getName());
//		_report.log(LogStatus.FAIL, _report.addScreenCapture(screenshotPath));
		s = result.getName().toString().trim();

	}



	@Override
	public void onTestSkipped(ITestResult result) {
		//_report.log(LogStatus.SKIP, "Test case skipped is "+result.getName());

	}

	@Override
	public void onTestStart(ITestResult result) {

		s = result.getName().toString().trim();

	}

	public static String getMethodName(){
		return s;
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	//	_report.log(LogStatus.PASS, "Test case passed is "+result.getName());

	}


}

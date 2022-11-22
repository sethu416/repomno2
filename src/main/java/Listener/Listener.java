package Listener;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.Base;
import utilities.ExtentReporter;

public class Listener extends Base implements ITestListener{
	 WebDriver driver=null;
 ExtentReports extentreport = ExtentReporter.getExtentReport();
 ExtentTest extenttest;
 ThreadLocal<ExtentTest> extenttestthread=new ThreadLocal<ExtentTest>() ;
	
	@Override
	public void onTestStart(ITestResult result) {
		String testName=result.getName();
		extenttest=extentreport.createTest(testName+"executed started");
		extenttestthread.set(extenttest);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testName=result.getName();
		//extenttest.log(Status.PASS,testName +"got passed");
		extenttestthread.get().log(Status.PASS,testName+"get passed");
		
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
	
		String testName = result.getName();
		//extenttest.fail(result.getThrowable());
		extenttestthread.get().fail(result.getThrowable());
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}catch(Exception e) {
			e.printStackTrace();
		}
		/*try {
			takeScreenshot(testName,driver);
		}catch(IOException e) {
			e.printStackTrace();
		}*/
		try {
			String Screenshotfilepath=takeScreenshot(testName,driver);
			extenttestthread.get().addScreenCaptureFromPath(Screenshotfilepath,testName);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extentreport.flush();
	}

}

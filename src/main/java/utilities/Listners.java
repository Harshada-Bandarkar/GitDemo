package utilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import basepackage.BaseTest;

public class Listners extends BaseTest implements ITestListener{

	ExtentReports er=ExtentReportsNG.getReports();
	ExtentTest et;
	ThreadLocal<ExtentTest> threadtest= new ThreadLocal<ExtentTest>();
	
	
	@Override
	public void onTestStart(ITestResult result) {
		et=er.createTest(result.getMethod().getMethodName());
		threadtest.set(et);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		threadtest.get().log(Status.PASS, "test passed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String TCName=result.getMethod().getMethodName();
		
		WebDriver driver=null;
		
		try {
			driver=(WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException e) 
		{
			e.printStackTrace();
		} catch (Exception e) 
		{
			e.printStackTrace();
		} 
		
		try {
			getFailedTestCasesScreens(TCName, driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		threadtest.get().fail(result.getThrowable());
		
		try {
			threadtest.get().addScreenCaptureFromPath(getFailedTestCasesScreens(TCName, driver), result.getMethod().getMethodName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		er.flush();
	}

}

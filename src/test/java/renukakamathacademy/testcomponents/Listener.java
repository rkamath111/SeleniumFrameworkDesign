package renukakamathacademy.testcomponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import renukakamathacademy.resourses.Reporter;

public class Listener extends BaseTest implements ITestListener
{
	ExtentReports extent = Reporter.Report();
	ExtentTest test;
	
	public void onTestStart(ITestResult result)
	{
		test=extent.createTest(result.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.PASS, "Test Passed");
	}
	
	public void onTestFailure(ITestResult result)
	{
		test.fail(result.getThrowable());
		
		try {
			WebDriver driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			String path = addScreenshots(result.getMethod().getMethodName(), driver);
			try {
				test.addScreenCaptureFromPath(path, result.getMethod().getMethodName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test.log(Status.SKIP, "Test Skipped");
	}
	
	public void onFinish(ITestContext context)
	{
		System.out.println("=================================");
	    System.out.println("TESTNG FINISHED");
	    System.out.println("FLUSHING EXTENT REPORT");
	    System.out.println("=================================");
		extent.flush();
	}
}

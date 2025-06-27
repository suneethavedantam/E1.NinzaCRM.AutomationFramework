package ninzaCRM.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation to ITestListeners Interface of TestNG
 * @author Chaitra M
 *
 */
public class ListenersImplementation implements ITestListener{
	
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		
		//For Every @Test -> Test method
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" ------ Test Execution Started ------");
		
		
		//Intimation of Test execution to extent Reports
	    test = report.createTest(methodName);
			
	}

	public void onTestSuccess(ITestResult result) {
		
		//For @Test is passed
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" ------ Test PASSED ------");
		
		//Log the test status as PASS in Extent Reports
		test.log(Status.PASS, methodName+" ------ Test PASSED ------");
			
	}

	public void onTestFailure(ITestResult result)  {
		
		//For @Test is Failed
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+" ------ Test Failed ------");
		
		//Print the exception for failure
		System.out.println(result.getThrowable());
		
		//Log the test status as Fail in Extent Reports
		test.log(Status.FAIL, methodName+" ------ Test Failed ------");
		test.log(Status.INFO, result.getThrowable());
		
		//For capturing the screenshot
		SeleniumUtility s = new SeleniumUtility();
		JavaUtility j = new JavaUtility();
		String screenshotName = methodName+"-"+j.getSystemDate();
		
		try {
			
			String path = s.captureScreenShot(BaseClass.sdriver, screenshotName);
			
			//attach screenshot to extent reports
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult result) {
		
		//For @Test is skipped
		String methodName = result.getMethod().getMethodName();	
		System.out.println(methodName+" ------ Test Skipped ------");
		
		//Print the exception for failure
		System.out.println(result.getThrowable());
		
		//Log the test status as Skip in Extent Reports
		test.log(Status.SKIP, methodName+" ------ Test Skipped ------");
		test.log(Status.INFO, result.getThrowable());
			
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
		System.out.println("------ Suite Execution Started ------");
		
		//Basic Configuration of Extent Reports
		ExtentSparkReporter htmlRep = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDate()+".html");
		htmlRep.config().setDocumentTitle("Execution Report");
		htmlRep.config().setTheme(Theme.DARK);
		htmlRep.config().setReportName("VTiger Execution Report");
		
		
		//Set system info inside extent reports
		report = new ExtentReports();
		report.attachReporter(htmlRep);
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Browser", "Edge");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Reporter name", "Chaitra");
		
			
	}

	public void onFinish(ITestContext context) {
		
		System.out.println("------ Suite Execution Finished ------");
		
		//Generate extent Report
		report.flush();
	}
	
	

}

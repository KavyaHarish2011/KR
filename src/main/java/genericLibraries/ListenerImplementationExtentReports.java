package genericLibraries;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementationExtentReports implements ITestListener{
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentReports/extent.html");
		spark.config().setDocumentTitle("Framework");
		spark.config().setReportName("Vtiger CRM");
		spark.config().setTheme(Theme.DARK);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Author", "Kavya");
		report.setSystemInfo("Platform", "windows");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getMethod().getMethodName());	
	    //test.addScreenCaptureFromPath(new WebDriverUtility().getScreenshot(result.getMethod().getMethodName()).getCurrentTime());
		test.addScreenCaptureFromBase64String(new WebDriverUtility().getScreenshot());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip(result.getMethod().getMethodName());
		test.fail(result.getMethod().getMethodName());
	}

	@Override
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName());
		}

}

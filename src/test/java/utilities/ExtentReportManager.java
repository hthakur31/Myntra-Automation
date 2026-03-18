package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager implements ITestListener{

	public ExtentSparkReporter sparkreport;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	public void onStart(ITestContext testContext) {
		
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		repName  = "TestReport-"+timeStamp+".html";
		sparkreport= new ExtentSparkReporter(".\\reports\\" + repName);
		
		sparkreport.config().setDocumentTitle("Myntra automation testing usecase");
		sparkreport.config().setReportName("usecase testing");
		
		extent = new ExtentReports();
		extent.attachReporter(sparkreport);
		extent.setSystemInfo(timeStamp, timeStamp);
	}
	
}

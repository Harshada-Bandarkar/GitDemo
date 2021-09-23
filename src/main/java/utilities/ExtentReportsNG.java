package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {
	
	public static 	ExtentReports er;
	public static ExtentReports getReports()
	{
		
		ExtentSparkReporter es= new ExtentSparkReporter(System.getProperty("user.dir")+"//Reports//index.html");
		es.config().setDocumentTitle("WebAutomationresults");
		es.config().setReportName("Test Results");
	
		
	 er=new ExtentReports();
	 er.attachReporter(es);
	 er.setSystemInfo("Harshada","Tester");
	 
	 return er;
	}
}

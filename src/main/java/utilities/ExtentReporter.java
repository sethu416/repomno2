package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	static ExtentReports extentreport;
	public static ExtentReports getExtentReport() {
		String extentreportpath = System.getProperty("user.dir") + "\\reports\\extentreport.html";
		 ExtentSparkReporter reporter = new ExtentSparkReporter(extentreportpath);
		reporter.config().setReportName("TutorialsNinja Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		extentreport=new ExtentReports();
		extentreport.attachReporter(reporter);
		extentreport.setSystemInfo("Operating System", "Window 10");
		extentreport.setSystemInfo("Tested By", "sethuram");
		return extentreport;
		
	}

}

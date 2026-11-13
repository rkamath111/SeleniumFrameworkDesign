package renukakamathacademy.resourses;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporter {
	
	public static ExtentReports extent;
	
	public static ExtentReports Report()
	{
		String path = System.getProperty("user.dir")+"/Reports/report.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		System.out.println("REPORT PATH = " + path);
		reporter.config().setReportName("E-Commerce Automation Test Report");
		reporter.config().setDocumentTitle("E-Commerce Test Report");
		
		//if(extent==null)
		//{
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Renuka");
			
		//}
		return extent;
	}
}

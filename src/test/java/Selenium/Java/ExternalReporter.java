package Selenium.Java;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExternalReporter {
	static ExtentReports extent;

	public static ExtentReports getReportsObject() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation");
		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Manu");
		return extent;
	}

//	public void initialDemo() {
//		ExtentTest test = extent.createTest("Login report method");
//		UsersPage u = new UsersPage();
//		u.NavigateToUsers();
//
//		extent.flush();
//	}
}

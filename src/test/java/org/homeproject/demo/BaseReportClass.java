package org.homeproject.demo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.*;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseReportClass {

	public static ExtentHtmlReporter htmlreport;
	public static ExtentReports extent1;
	public static ExtentTest test;

	@BeforeSuite
	public void Setup() {

		htmlreport = new ExtentHtmlReporter("./test-output/extentreport.html");
		extent1 = new ExtentReports();
		extent1.attachReporter(htmlreport);
		test = null;
	}

	@AfterMethod
	public void GenerateReport(ITestResult result) {
		if (test != null) {
			if (result.getStatus() == ITestResult.FAILURE) {
				test.fail(MarkupHelper.createLabel(result.getName() + "failed", ExtentColor.ORANGE));
				test.fail(result.getThrowable());
				System.out.println("from base report fail");
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				test.pass(MarkupHelper.createLabel(result.getName() + "passed", ExtentColor.GREEN));
				// test.pass(result.getThrowable());
				System.out.println("from base report success");
			} else {
				test.pass(MarkupHelper.createLabel(result.getName() + "skipped", ExtentColor.YELLOW));
				// test.fail(result.getThrowable());
			}
		}
	}

	@AfterSuite
	public void Clean() {
		extent1.flush();
		System.out.println("in flush");
	}
}

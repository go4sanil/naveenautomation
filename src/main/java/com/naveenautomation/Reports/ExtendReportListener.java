package com.naveenautomation.Reports;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.naveenautomation.Utils.Utils;

public class ExtendReportListener extends TestListenerAdapter {

	public ExtentSparkReporter sparkReporter;
	public ExtentTest test;
	public ExtentReports extent;

	@Override
	public void onStart(ITestContext testContext) {
		// Time on which report was generated
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		// Name of the report
		String repName = "Extent_Report_" + timeStamp + ".html";

		// Defines the location of extent report
		// extend = new ExtentReports("./Extent Report/" + repName);

		sparkReporter = new ExtentSparkReporter("./Extent Report/" + repName);
		// Loading the config XML
		try {
			sparkReporter.loadXMLConfig("./extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sparkReporter.config().setReportName("Regression Suite");
		sparkReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Name of the host", "Localhost");
		extent.setSystemInfo("Tester Name", "User");
		extent.setSystemInfo("RAM", "16 GB");
		extent.setSystemInfo("Browser", System.getProperty("os.name"));
		extent.setSystemInfo("SRC", "Java " + System.getProperty("java.version"));
		extent.setSystemInfo("App URL", "naveeenautomation.com");

	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		test = extent.createTest(tr.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		test.assignAuthor("Sanil").assignCategory("Smoke").assignDevice("Chrome").pass("This is a passed test");

	}

	@Override
	public void onTestFailure(ITestResult tr) {
		test = extent.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		// addScreenCaptureFromPath(Utils.takeScreenShot(tr.getName()) + tr.getName());
		System.out.println(Utils.takeScreenShot(tr.getName()));
		System.out.println(tr.getName());

		test.assignAuthor("Tester").assignCategory("Regression").assignDevice("Firefox").pass("This is a passed test");

	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		test = extent.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	@Override
	public void onFinish(ITestContext testContext) {

		extent.flush();
	}
}

package com.org.utility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.org.beforecomponents.BaseTestComponents;

public class CustomListner extends BaseTestComponents implements ITestListener {

	public ExtentTest test;
	ExtentReports extent = ExtentReportNG.getReportObject();



	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = extent.createTest(result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, "Test Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {

		test.fail(result.getThrowable());
		Object testClass = result.getInstance();
		WebDriver driver = ((BaseTestComponents) testClass).driver;
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File source =screenshot.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+result.getName()+".png");
		try {
			FileHandler.copy(source, file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String path =System.getProperty("user.dir")+"//reports//"+result.getName()+".png";

		test.addScreenCaptureFromPath(path, result.getName());
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy_MM_ddHHmmss");
//		LocalDateTime now = LocalDateTime.now();
//		System.out.println(dtf.format(now));
//		
//		//Below 2 lines of code is used to get the driver instance from base test component class
//		Object testClass = result.getInstance();
//		WebDriver driver = ((BaseTestComponents) testClass).driver;
//		//***************************************************************
//		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		try {
//			FileHandler.copy(file, new File("./screenshots/" + result.getName()+ dtf.format(now)+ ".png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	

	}

}

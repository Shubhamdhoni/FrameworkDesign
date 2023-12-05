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
//	ExtentReports extent = ExtentReportNG.getReportObject();



	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//test = extent.createTest(result.getName());

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		Object testClass = result.getInstance();
		test = ((BaseTestComponents) testClass).test;
		test.log(Status.PASS, "Test Passed");

	}

	@Override
	public void onTestFailure(ITestResult result) {

		
		Object testClass = result.getInstance();
		test = ((BaseTestComponents) testClass).test;
		WebDriver driver = ((BaseTestComponents) testClass).driver;
		test.fail(result.getThrowable());
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
		
	

	}

}

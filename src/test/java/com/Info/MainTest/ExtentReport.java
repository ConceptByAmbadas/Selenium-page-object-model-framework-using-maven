package com.Info.MainTest;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Info.TestBase.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
//import Utility.ReadProperty;

public class ExtentReport extends TestBase{

	ExtentReports report;
	ExtentTest logger;

	public static WebDriver driver=new FirefoxDriver();

	
	@BeforeTest
	public void start_Report()
	{
		try
		{
		report=new ExtentReports("E://Reports//Test.html",true);
		report.addSystemInfo("HostName", "Pravin")
		.addSystemInfo("Environment", "SIT")
		.addSystemInfo("User","Ambadas");
	
		driver.manage().timeouts().pageLoadTimeout(160, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://google.com/");	
		}
		catch(Exception ex)
		{
			
		}
	}

	@Test
	public void DemoPassTest()
	{
		logger=report.startTest("Demo Report pass");
		logger.log(LogStatus.INFO, "Test1 is started ");
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Test is pass as condition is true");
		//logger.log(LogStatus.PASS, "TC is pass");
		//takeScreenshot(driver);
	}

	@Test
	public void DemoTestFail()
	{
		logger=report.startTest("Demo report Fail");
		logger.log(LogStatus.INFO, "Test2 is started");
		Assert.assertTrue(false);
		logger.log(LogStatus.FAIL, "Test is fail as condition is flase");
		//ReadProperty.takeScreenshot(driver);	
	}
	@AfterMethod
	public void getReport(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String screnshotpath=takeScreenshot(driver);
			//String image=logger.addScreenCapture(screnshotpath);
			String info=result.getTestName();
			logger.log(LogStatus.FAIL,"test Fail is"+result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.log(LogStatus.PASS, "Test Pass is"+result.getName());
			logger.log(LogStatus.PASS, "Below is the Screen shot"+logger.addScreenCapture(takeScreenshot(driver)));
		}
		report.endTest(logger);
	}

	@AfterTest
	public void endTest()
	{
	
		report.flush();
		report.close();
	}
}

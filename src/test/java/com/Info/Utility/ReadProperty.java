package com.Info.Utility;
/*package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ReadProperty {

	public static Properties prop;
	public static String dest;


	public ReadProperty()
	{
		try
		{
			File src =new File("E:\\StudyWorkpace\\com.automation.maven\\ConfigFile\\Config.property");
			FileInputStream fis =new FileInputStream(src);
			prop=new Properties();
			prop.load(fis);
		}
		catch(Exception ex)
		{
			System.out.println("Exception is"+ex.getMessage());	
		}
	}


	public  String getChromePath()
	{
		String Chrome_path=prop.getProperty("chromeDriver");
		System.out.println("chrome path is"+Chrome_path);
		return Chrome_path; 
	}

	public  String getBrowserName()
	{
		String browser=prop.getProperty("browser");
		System.out.println("browser name is"+browser);
		return browser; 
	}


	public  String getApplicationURL()
	{
		String URL=prop.getProperty("URL");
		System.out.println("URL"+URL);
		return URL; 
	}


	public  String getExeclDataPath()
	{
		String path=prop.getProperty("ExcelFile");
		System.out.println("Execl Path is"+path);
		return path; 
	}


	public static String takeScreenshot(WebDriver driver)
	{
		try
		{
			DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HHmmss");
			Date date = new Date();
			System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
			String time=dateFormat.format(date);
			System.out.println("Time is"+time);
			TakesScreenshot tc=(TakesScreenshot)driver;
			File src=tc.getScreenshotAs(OutputType.FILE);

			dest="E:/StudyWorkpace/Data_Framwork_Using_Selenium/Screenshot/"+time+".png"; //for extent report 
			File destination =new File(dest);
			FileUtils.copyFile(src, destination);
			System.out.println("Screen shot taken");

			//return dest;
		}
		catch(Exception ex)
		{
			System.out.println("Screenshot error is"+ex.getMessage());
		}
		return dest;
	}
	
	public static  Object[][] getData(String ExcelName, String testcase) {
		DataRepository Data = new DataRepository("E:\\StudyWorkpace\\com.automation.maven\\TestDataFile\\Datasheet.xlsx");
		int rowNum = Data.getRowCount(testcase);
		System.out.println(rowNum);
		int colNum = Data.getColumnCount(testcase);

		Object sampleData[][] = new Object[rowNum - 1][colNum];
		for (int i = 2; i <=rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				sampleData[i - 2][j] = Data.getCellData(testcase, j, i);
				System.out.println("cell data is"+Data.getCellData(testcase, j, i));
			}
		}
		return sampleData;
	}

	public static  void main(String args[])
	{
		ReadProperty read= new ReadProperty();

		//System.out.println("path is"+ReadProperty.getExeclDataPath());
		//System.out.println("path is"+ReadProperty.getApplicationURL());
		System.out.println("path is"+read.getBrowserName());
	}
}
*/
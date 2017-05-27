package com.Info.Pages;

import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Info.TestBase.TestBase;
import com.Info.Utility.ExcelDataConfig;
import com.relevantcodes.extentreports.LogStatus;

public class Enquiry extends TestBase{
	
	

	final WebDriver driver;
	//ReadProperty config=new ReadProperty();
	//ExcelDataConfig  readconfig=new ExcelDataConfig(config.getExeclDataPath());

	public Enquiry(WebDriver driver) 
	{

		this.driver=driver;
	}
	Random rand = new Random(); 
	By Home_Link= By.xpath("//a[contains(text(),'Home')]");
	By Customer_name=By.xpath("//*[@name='fullname']");
	By customer_Email=By.xpath("//*[@name='em']");
	By requriment_description=By.xpath("//*[@name='feedbackDesc']");
	By Customer_mobile=By.xpath("//*[@name='mb']");
	By btn_Submit=By.xpath("//*[@id='btn' and @value='SUBMIT']");
	
	
	public void To_Fill_Customer_Enquiry_Details(String Name,String email,String Descriptin,String Mobile) 
	{
		//"Pravin", "pravin@gmail.com", "Looking for 2 BHK at aundh", "9270363789"
		try
		{
		int value = rand.nextInt(20);
		String Email = String.valueOf(value)+email;
		driver.findElement(Home_Link).click();
		Thread.sleep(100);
		driver.findElement(Customer_name).sendKeys(Name);
		driver.findElement(customer_Email).sendKeys(Email);
		driver.findElement(Customer_mobile).sendKeys(Mobile);
		driver.findElement(requriment_description).sendKeys(Descriptin);
		//driver.findElement(requriment_description).sendKeys(readconfig.getCellData("Enquiry_Form", "Description", 2));
		driver.findElement(btn_Submit).click();
		Thread.sleep(100);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	public boolean To_verify_Customer_Enquiry_form()
	{
		test=report.startTest("To_verify_Customer_Enquiry_form");
		test.log(LogStatus.INFO, "Verifying Enquiry form");
		String msg=driver.findElement(By.xpath(".//*[@id='alternatecolor']/tbody/tr[1]/td/font")).getText();
		//String msg="Thank you for submitting the detail's our team shall revert to your query soon.";
		if(msg.contains("Thank You!"))
		{
			System.out.println("IN IF Message verified is"+msg);
			return true;
		}
		else
		{
			System.out.println("IN ELSE Message verified is"+msg);
			return false;	
		}
		
	}
}

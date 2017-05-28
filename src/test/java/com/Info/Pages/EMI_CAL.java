package com.Info.Pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Info.TestBase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class EMI_CAL extends TestBase {

	final WebDriver driver;

	public EMI_CAL(WebDriver driver)
	{
		this.driver=driver;
	}

	By Tab_EMICAl=By.xpath("//a[contains(text(), 'EMI Calculator')]");
	By txt_Amout=By.xpath("//input[@name='loanamt']");
	By txt_Tenure=By.xpath("//input[@name='tenur']");
	By txt_rate=By.xpath("//input[@name='inrate']");
	By btn_submit=By.xpath("//*[@id='btn'and @value='submit']");
	By txtEmi=By.xpath("//input[@name='emi']");
	By Home=By.xpath("//a[contains(text(),'Home')]");

	public void click_on_Emi_Calculator_Tab()
	{

		String handle= driver.getWindowHandle();
		System.out.println(handle);
		driver.findElement(Tab_EMICAl).click();
		// Store and Print the name of all the windows open	              
		//Set handles = driver.getWindowHandles();
		Iterator<String> itr=getAllWindowhandle();
		//System.out.println(handles);
		// Pass a window handle to the other window
		for (String handle1 : driver.getWindowHandles()) {
			System.out.println(handle1);
			driver.switchTo().window(handle1);
		}
		test.log(LogStatus.INFO, "User has click on EMI Tab");
	}
	public void To_Fill_Emi_Details()
	{
		log.info("User has filling EMI details");
		driver.findElement(txt_Amout).sendKeys("145000");
		driver.findElement(txt_Tenure).sendKeys("5");
		driver.findElement(txt_rate).sendKeys("11.5");
		driver.findElement(btn_submit).click();
		test.log(LogStatus.INFO, "User has filled EMI values and click on submit button");
	}

	public boolean To_Verify_EMI_Details()
	{
		click_on_Emi_Calculator_Tab();
		To_Fill_Emi_Details();
		String ele=driver.findElement(txtEmi).getAttribute("value");
		float value=Float.parseFloat(ele);
	
		if(value>0)
		{
			test.log(LogStatus.INFO, "Verifying EMi calculator functionality");
			test.log(LogStatus.PASS, "EMI feature succusfully verified on page");
			driver.findElement(Home).click();
			return true;}
		else
		{	test.log(LogStatus.INFO, "Verifying EMi calculator functionality");
		test.log(LogStatus.PASS, "EMI feature not verified on page");	
		return false;
		}
	}
}









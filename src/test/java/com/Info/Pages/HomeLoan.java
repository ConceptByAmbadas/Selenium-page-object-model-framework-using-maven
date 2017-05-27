package com.Info.Pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.Info.TestBase.TestBase;

public class HomeLoan extends TestBase{
	
	final WebDriver driver;
	
	public HomeLoan(WebDriver driver)
	{
		this.driver=driver;
	}
	String value="bove 50-Lakh";
	By homeloantab= By.xpath("//a[contains(text(),'Home Loan')]");
	By laon_amt= By.xpath("//*[@name='amt']");
	By Name=By.xpath("//input[@name='nm']");
	By Mobile=By.xpath("//input[@name='mb']");
	By Email=By.xpath("//input[@name='em']");
	By pre_bank=By.xpath("//*[@name='bank']");
	By Bank=By.xpath("//select[@name='bank']");
	//xpath=(//input[@id='ndncchk'])[0] 
	By term=By.xpath("//*[@name='terms']");
	By btn_submit=By.xpath("//*[@id='btn'and @value='Submit Details']");
	
	public void click_on_Homeloan_tab()
	{
		driver.findElement(homeloantab).click();
	}
	public void select_loan_amount(String Loan_Amt)
	{
		System.out.println("In select"+Loan_Amt);
		
		List<WebElement> rdBtn = driver.findElements(laon_amt);	 
		boolean svalue = false;
		svalue = rdBtn.get(0).isSelected();
		if(Loan_Amt.equalsIgnoreCase("Above 50-Lakh")){
			rdBtn.get(1).click();}
		else{
			rdBtn.get(0).click();
		}
	}
	
	
	public void to_Enter_Customer_Details(String name,String mobile,String email,String Loan_Amt)
	{
		
		driver.findElement(Name).sendKeys(name);
		driver.findElement(Mobile).sendKeys(mobile);
		driver.findElement(Email).sendKeys(email);
	}
	
	public void to_Select_bank_Details(String Pre_Bank,String Bank_Name)
	{
	  driver.findElement(pre_bank).click();
	  Select bank=new Select(driver.findElement(Bank));
	  //bank.selectByValue(Bank_Name);
	  bank.selectByIndex(1);
	}
	public void to_Click_Submit_Details()
	{
		driver.findElement(term).click();
		driver.findElement(btn_submit).click();
	}
	
	public void to_fill_Homeloan_Details(String Loan_Amt,String name,String mobile,String email,String Pre_Bank,String Bank_Name)
	{
		System.out.println("In Home loan");
		click_on_Homeloan_tab();
		select_loan_amount(Loan_Amt);
		to_Enter_Customer_Details( name, mobile, email,Loan_Amt);
		to_Select_bank_Details( Pre_Bank, Bank_Name);
		to_Click_Submit_Details();
	}
	
	public boolean To_verify_Homeloan_details()
	{
		//.//*[@id='apDiv2']/font
		String msg=driver.findElement(By.xpath(".//*[@id='apDiv2']/form/center/font")).getText();
		if(msg.contains("successfully"))
		{
			System.out.println("IN IF Message verified is"+msg);
			return true;	
		}
		else{
			System.out.println("IN IF Message verified is"+msg);
			return false;}	
	}
	

	

}

package com.Info.Pages;

import java.util.Collection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Info.Utility.ExcelDataConfig;

public class NewYahoopage {
	
	
	
	
	public NewYahoopage(WebDriver driver) 
	{
		// this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@id='firstname']")
	public WebElement fr_name;
	@FindBy(xpath="//input[@id='secondname']")
	public WebElement sec_name;
	@FindBy(xpath="//*[@id='gender']")
	public WebElement sex;
	@FindBy(xpath="//*[@name='dd']")
	public WebElement dd;
	@FindBy(xpath="//*[@name='mm']")
	public WebElement mm;
	@FindBy(xpath="//*[@name='yyyy']")
	public WebElement yy;
	@FindBy(xpath="//*[@name='country']")
	public WebElement country;
	@FindBy(xpath="//*[@name='yahooid']")
	public WebElement emailid;
	@FindBy(xpath="//*[@name='password']")
	public WebElement pass;
	@FindBy(xpath="//*[@name='passwordconfirm']")
	public WebElement Repass;
	@FindBy(xpath="//*[@name='secquestion']")
	public WebElement security1;
	@FindBy(xpath="//*[@name='secquestionanswer']")
	public WebElement secquestionanswer;
	@FindBy(xpath="//*[@name='secquestion2']")
	public WebElement security2;
	@FindBy(xpath="//*[@name='secquestionanswer2']")
	public WebElement secquestionanswer2;
	@FindBy(xpath="//*[@name='cword']")
	public WebElement capchya;
	@FindBy(xpath="//*[@name='IAgreeBtn']")
	public WebElement submitfrom;
	
	public void toEnterRegistrationDetails(String firstname,String secondname,String gender,String DOb,String country1,String email,String password,String Repassword,String securityQues1,String Security_ans1,String securityQues2,String Security_ans2)
	{
		try
		{
			
			String [] DOB=DOb.split("-");
			String DD=DOB[0];String MM=DOB[1];String YY=DOB[2];
			System.out.println("MM"+MM);
			
			fr_name.sendKeys(firstname);
			sec_name.sendKeys(secondname);
			Select gen =new Select(sex);
			gen.selectByVisibleText(gender);
			dd.sendKeys(DD);
			Select month=new Select(mm);
			month.selectByValue("4");
			yy.sendKeys(YY);
			Select con =new Select(country);
			con.selectByVisibleText(country1);
			emailid.sendKeys(email);
			pass.sendKeys(password);
			Repass.sendKeys(Repassword);
			Select security_1 =new Select(security1);
			security_1.selectByValue(securityQues1);
			secquestionanswer.sendKeys(Security_ans1);
			
			Select security_2 =new Select(security2);
			security_2.selectByValue(securityQues2);
			secquestionanswer2.sendKeys(Security_ans2);
			capchya.sendKeys("1234");
			submitfrom.click();
			
			
			
		
		}
		catch(Exception ex)
		{
			System.out.println("Exception is"+ex.getMessage());
		}
	}

	

}

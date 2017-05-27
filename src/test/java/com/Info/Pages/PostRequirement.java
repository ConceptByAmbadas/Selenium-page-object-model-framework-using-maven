package com.Info.Pages;

import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PostRequirement {

	final WebDriver driver;
	static Logger log=Logger.getLogger(Postproperty.class.getName());

	public PostRequirement(WebDriver driver) 
	{

		this.driver=driver;
	}
	Random rand = new Random(); 


	By postpropertytab= By.xpath("//a[contains(text(),'Post Requirement')]");
	By SelectDeal=By.xpath("//*[@name='rd' and @value='Buy']");
	By Property_Type= By.xpath("//*[@name='lkf']");
	By city=By.xpath("//*[@name='city']");
	By beedroom=By.xpath("//*[@name='bed']");
	By area_from=By.xpath("//*[@name='tx1']");
	By area_To=By.xpath("//*[@name='tx2']");
	By Unit=By.xpath("//*[@name='unit']");
	By Budget_min=By.xpath("//*[@name='Bud1']");
	By Budget_max=By.xpath("//*[@name='Bud2']");
	By Capchy_Ans=By.xpath("//*[@name='answer']");
	By User_type=By.xpath("//*[@name='type' and @value='New_User']");
	By UserName=By.xpath("//*[@name='nm']");
	By User_email=By.xpath("//*[@name='Email']");
	By password=By.xpath("//*[@name='psw']");
	By mobile=By.xpath("//*[@name='mbl']");
	By btn_postReq=By.xpath("//*[@name='b1'and @value='PostRequirement']");


	public void User_has_Click_on_post_Requriment_Tab()
	{
		log.info("User clicking on postRequriment tab");
		driver.findElement(postpropertytab).click();
	}

	public void User_has_select_Deal()
	{
		log.info("User clicking on deal type");
		driver.findElement(SelectDeal).click();
	}

	public void select_property_type(String property_type)
	{
		Select property=new Select(driver.findElement(Property_Type));
		property.selectByValue("Residential House");	
	}

	public void select_property_City(String Prop_city)
	{
		Select Property_city=new Select(driver.findElement(city));
		Property_city.selectByValue(Prop_city);	
	}

	public void select_Number_of_bedroom()
	{
		Select No_of_beedroom=new Select(driver.findElement(beedroom));
		No_of_beedroom.selectByIndex(2);
	}

	public void User_has_Enter_builtUp_Area(String Area_from,String Area_To)
	{
		log.info("User has Entering built Up area");
		driver.findElement(area_from).sendKeys(Area_from);
		driver.findElement(area_To).sendKeys(Area_To);
		Select prop_unit=new Select(driver.findElement(Unit));
		prop_unit.selectByIndex(2);	
	}

	public void User_has_selecting_min_max_budget()
	{
		Select min=new Select(driver.findElement(Budget_min));
		min.selectByIndex(2);

		Select max=new Select(driver.findElement(Budget_max));
		max.selectByIndex(4);
	}

	public void User_has_Enter_capchya_answer()
	{
		log.info("User has Entering Capchya");
		driver.findElement(Capchy_Ans).sendKeys("10");

	}

	public void To_Select_User_Type()
	{
		log.info("User has selecting type details");
		driver.findElement(User_type).click();
	}
	public void User_has_Enter_Registration_details(String username,String email,String User_password,String User_mobile)
	{
		int value = rand.nextInt(300);
		String Email = String.valueOf(value)+email;
		System.out.println("Random email"+Email);

		log.info("User has Entering Registration details");
		driver.findElement(UserName).sendKeys(username);
		driver.findElement(User_email).sendKeys(Email);
		driver.findElement(password).sendKeys(User_password);
		driver.findElement(mobile).sendKeys(User_mobile);
	}

	public void To_Click_on_Registration_Button()
	{
		log.info("User is click on post requriment button");
		driver.findElement(btn_postReq).click();
	}


	public void to_Fill_post_requrimentPage(String property_type,String city, String build_area_from,String build_area_to,String username,String email,String password,String mobile)
	{
		User_has_Click_on_post_Requriment_Tab();
		User_has_select_Deal();
		select_property_type(property_type);
		select_property_City(city);
		select_Number_of_bedroom();
		User_has_Enter_builtUp_Area(build_area_from,build_area_to);
		User_has_selecting_min_max_budget();
		User_has_Enter_capchya_answer();
		To_Select_User_Type();
		User_has_Enter_Registration_details(username, email, password, mobile);
		To_Click_on_Registration_Button();
	}

	public boolean To_verify_postReq_details()
	{
		//.//*[@id='apDiv2']/font
		String msg=driver.findElement(By.xpath(".//*[@id='apDiv2']/font")).getText();
		if(msg.contains("posted Successfully"))
		{
			System.out.println("IN IF Message  post requirement verified is"+msg);
			return true;	
		}
		else{
			System.out.println("IN IF Message verified is"+msg);
			return false;}	
	}
}

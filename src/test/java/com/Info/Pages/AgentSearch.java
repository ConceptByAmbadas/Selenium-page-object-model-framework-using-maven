package com.Info.Pages;



import static org.testng.Assert.assertTrue;

import java.awt.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.Info.TestBase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class AgentSearch extends TestBase{
	final WebDriver driver;

	static Logger log=Logger.getLogger(AgentSearch.class.getName());
	public AgentSearch(WebDriver driver)
	{
		this.driver=driver;
	}
	//By homeloantab= By.xpath("//a[contains(text(),'Home Loan')]");
	By AgentSearchTab=By.xpath("//a[contains(text(),'Agent search')]");
	By ServiceType=By.xpath(".//select[@name='services']");
	By oprating_city=By.xpath(".//select[@name='operating_city']");
	By Locality=By.xpath("//input[@name='agent_locality']");
	By Dealing =By.xpath(".//select[@name='agent_deal']");
	By Property_Handle=By.xpath("//select[@name='trasaction_type']");
	By btn_submit=By.xpath("//*[@id='btn'and @value='Search Agent']");
	By btn_view_detail=By.xpath(".//*[contains(text(), 'View Contact Details...')][1]");
	By Home=By.xpath("//a[contains(text(),'Home')]");


	public void click_on_AgentSearchTab_tab()
	{

		String handle= driver.getWindowHandle();
		System.out.println(handle);
		driver.findElement(AgentSearchTab).click();
		// Store and Print the name of all the windows open	              
		Set handles = driver.getWindowHandles();
		System.out.println(handles);
		// Pass a window handle to the other window
		for (String handle1 : driver.getWindowHandles()) {
			System.out.println(handle1);
			driver.switchTo().window(handle1);
		}
	}

	public void to_enter_Search_Details( String serviceType2,String oprating_city2,String locality2,String dealing2,String Property_Handle2)
	{

		Select service=new Select(driver.findElement(ServiceType));
		service.selectByValue(serviceType2);
		Select city=new Select(driver.findElement(oprating_city));
		city.selectByValue(oprating_city2);
		driver.findElement(Locality).sendKeys(locality2);
		Select dealing_in=new Select(driver.findElement(Dealing));
		dealing_in.selectByValue(dealing2);
		Select Property_handle=new Select(driver.findElement(Property_Handle));
		Property_handle.selectByValue(Property_Handle2);
	}
	public void to_Click_Submit_Details()
	{
		driver.findElement(btn_submit).click();
	}

	public void To_Perform_Agent_Search(String serviceType2, String oprating_city2, String locality2, String dealing2, String property_Handle2) throws InterruptedException
	{
		click_on_AgentSearchTab_tab();
		to_enter_Search_Details(serviceType2,oprating_city2,locality2,dealing2,property_Handle2);
		to_Click_Submit_Details();
		//To_verify_Agent_Search_Details(Agent_Name,Agent_Code);
	}

	public boolean To_verify_Agent_Search_Details(String Agent_Name,String Agent_Code ) throws InterruptedException
	{
		//.//*[@id='apDiv2']/font
		
		String view_agent_details=driver.findElement(By.xpath(".//*[@id='n']/table[3]/tbody/tr/td/table/tbody/tr[1]/td/font")).getText();
		
		System.out.println("msg  is"+view_agent_details);
		if(view_agent_details.contains(Agent_Name))
		{
			System.out.println("IN IF Message verified is"+view_agent_details);
			driver.findElement(btn_view_detail).click();
			test.log(LogStatus.INFO, "User has click on view details button");
			waitFor(1);
			String Agent_id=driver.findElement(By.xpath(".//*[@id='n']/center/table/tbody/tr[4]/td[1]/table/tbody/tr[1]/td[2]/b")).getText();
			System.out.println("Agent id is"+Agent_id);
			System.out.println("Agent id is"+Agent_Code);
			if(Agent_id.equalsIgnoreCase(Agent_Code)){
				test.log(LogStatus.INFO, "Agent code succusfully verified on page");
				test.log(LogStatus.PASS, "Agent code succusfully verified on page");
				driver.findElement(Home).click();
				return true;
			}
			else{
				test.log(LogStatus.INFO, "Agent code not found on page on page");
				test.log(LogStatus.FAIL, "Agent code not found on page on page");
				driver.findElement(Home).click();}
			return false;
			
		}
		else {
			System.out.println("IN IF Message verified is"+view_agent_details);
			test.log(LogStatus.INFO, "Agent details not found on page");
			test.log(LogStatus.FAIL, "Agent code not found on page on page");
			return false;
		}
		
	}
	
	
	


}

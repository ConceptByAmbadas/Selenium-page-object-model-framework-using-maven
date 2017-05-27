package com.Info.MainTest;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.seleniumhq.jetty9.http.HttpGenerator;
import org.seleniumhq.jetty9.http.HttpGenerator.Result;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Info.ExcelReader.DataRepository;
import com.Info.Pages.AgentSearch;
import com.Info.Pages.EMI_CAL;
import com.Info.Pages.Enquiry;
import com.Info.Pages.HomeLoan;
import com.Info.Pages.PostRequirement;
import com.Info.Pages.Postproperty;
import com.Info.TestBase.TestBase;
import com.Info.Utility.Driver;
import com.Info.Utility.ExcelDataConfig;
import com.relevantcodes.extentreports.LogStatus;

public class TestRunner extends TestBase {


	int indexSI=1;
	Postproperty property;
	PostRequirement req;
	Enquiry enquiry;
	HomeLoan loan;
	AgentSearch agent_search;
	EMI_CAL Emi_Cal;

	@Test(priority = 1)
	public void LaunchApplichation() throws IOException {
		Driver.Instance.get(getApplicationURL());
		req = PageFactory.initElements(Driver.Instance, PostRequirement.class);
		property = PageFactory.initElements(Driver.Instance, Postproperty.class);
		enquiry = PageFactory.initElements(Driver.Instance, Enquiry.class);
		loan=PageFactory.initElements(Driver.Instance, HomeLoan.class);
		agent_search=PageFactory.initElements(Driver.Instance, AgentSearch.class);
		Emi_Cal=PageFactory.initElements(Driver.Instance, EMI_CAL.class);
		
		test=report.startTest("Launch application");
		String title = Driver.Instance.getTitle();
		
		if (title.contains("Propchilli")) {

			test.log(LogStatus.INFO, "Application is up and running");
			test.log(LogStatus.PASS, " Page Title verify");
			Assert.assertTrue(true, "Application is up and running");
			//updateResult(indexSI++, "Launch Application","Application is up and running", "Pass", "Launch Application Test",true);
		} else {
			test.log(LogStatus.INFO, "Issue with application launch");
			test.log(LogStatus.FAIL, " Page Title not verify");
			Assert.assertTrue(false);
			//updateResult(indexSI++, "Launch Application","Issue in launching application ", "Fail", "Launch Application Test",false);
		}
		

	}

	@DataProvider
	public Object[][] PostRequirmentData() {
		Object[][] data = getData("Datasheet.xlsx", "PostRequriment");
		return data;
	}

	@Test(dataProvider = "PostRequirmentData", priority = 5)
	public void toValidate_post_Requirment_Page(String property_type, String city, String build_area_from, String build_area_to, String username, String email, String password, String mobile, String runMode) {
		try {
			test = report.startTest("Validating Post requirement form");
			test.log(LogStatus.INFO, "Validating Post requirement form");
			if (runMode.equals("N")) {
				test.log(LogStatus.SKIP, "Skipping test case");
				throw new SkipException("Skipping the test");
			}
			else
			{
			req.to_Fill_post_requrimentPage(property_type, city, build_area_from, build_area_to, username, email, password, mobile);
			// report.setTestDisplayOrder(TestDisplayOrder.NEWEST_FIRST);

			boolean msg1 = req.To_verify_postReq_details();
			if (msg1 == true) {
				Assert.assertTrue(true, "User has successfully post requirment");
				test.log(LogStatus.PASS, "User has successfully post requirment");
				//updateResult(indexSI++, "Fill Property Requirment","Requirment is posted successfully", "Pass", "Fill post reuqirmrnt details",true);
			} else {
				Assert.assertTrue(false, "Requirment is not posted due to some issue");
				test.log(LogStatus.FAIL, "Requirment is not posted due to some issue");
				
				//updateResult(indexSI++, "Fill Property Requirment"," Issue in filling property requriment", "Fail", "Fill post reuqirmrnt details",true);
			}}
		} catch (Exception ex) {
			System.out.println("Exception is post req is" + ex.getMessage());
		}
		
	}

	@DataProvider
	public Object[][] EnquiryForm_Data() {
		Object[][] data = getData("Datasheet.xlsx", "Enquiry_Form");
		return data;
	}

	@Test(dataProvider = "EnquiryForm_Data", priority = 3)
	public void toValidate_EnquiryForm(String Name, String email, String Description, String Mobile, String runMode) {
		try {
			test = report.startTest("Validating Enquiry form");
			test.log(LogStatus.INFO, "Validating enquiry form");
		
			if (runMode.equals("N")) {
				test.log(LogStatus.SKIP, "Skip test case ");
				throw new SkipException("Skipping the test");
			}
			else
			{
			enquiry.To_Fill_Customer_Enquiry_Details(Name, email, Description, Mobile);
			boolean msg2 = enquiry.To_verify_Customer_Enquiry_form();
			if (msg2 == true) {
				Assert.assertTrue(true, "User has successfully Fill enquiry form");
				test.log(LogStatus.PASS, "User has successfully Fill enquiry form");
				//updateResult(indexSI++, "Fill Enquiry Details"," Enquiry details filled succusfully", "Pass", "Fill Enquiry details",true);
			} else {
				Assert.assertTrue(false, "User has facing issue while filling enquiry form");
				test.log(LogStatus.FAIL, "User has facing issue while filling enquiry form");
				//updateResult(indexSI++, "Fill Enquiry Details"," Issue while filling enquiry details", "Fail", "Fill Enquiry details",true);
			}
			}
		} catch (Exception es) {
			System.out.println("Exceptions in enquiry form is" + es.getMessage());
		}
	}

	@DataProvider
	public Object[][] PostPropertyData() {
		Object[][] data = getData("Datasheet.xlsx", "Post_Property");
		return data;
	}

	@Test(dataProvider = "PostPropertyData", priority = 6)
	public void toValidate_postpropertydetails(String property_type, String bathroom, String bedroom, String Furnished, String description, String first_name, String email_id, String password, String city, String mobile, String runMode) 
	{
		try {
			test = report.startTest("Validating Post property form form");
			test.log(LogStatus.INFO, "Validating Post property form");
			if (runMode.equals("N")) {

				test.log(LogStatus.SKIP, "Skipping test case");
				throw new SkipException("Skipping the test");
			}
			else
			{
			property.To_Fill_postproperty_details(property_type, bathroom, bedroom, Furnished, description, first_name, email_id, password, city, mobile);
			boolean msg3 = property.verifypostpropertyPage();
			if (msg3 == true) {
				test.log(LogStatus.PASS, "User has successfully post property details");
				//updateResult(indexSI++, "Fill Post Property Details","property details posted Succusfully", "Pass", "Fill Post Property details",true);
			} else {
				Assert.assertTrue(false, "issue while filling post property details");
				test.log(LogStatus.FAIL, "property is not posted due to some issue");
				
				//updateResult(indexSI++, "Fill Property Requirment","Issue while filling property details", "Fail", "Fill Post Property details",true);
			}
			}
		} catch (Exception ex) {
			System.out.println("Exception is " + ex.getMessage());
		}
	}
	@DataProvider
	public Object[][] HomeLoanData() {
		Object[][] data = getData("Datasheet.xlsx", "HomeLoan");
		return data;
	}
	@Test(dataProvider = "HomeLoanData", priority = 4)
	public void toValidateHomeLoagPage(String Loan_Amt, String Name , String Email,String Mobile,String Pre_Bank,String Bank_Name,String runMode)
	{
		System.out.println("in second method");
		
		test=report.startTest("To apply for HomeLoan");
		test.log(LogStatus.INFO, "Verifying details on Homeloan page");
		if(runMode.equals("N"))
		{
			throw  new SkipException("Test Case Skip");
		}
		else
		{
		loan.to_fill_Homeloan_Details(Loan_Amt,Name, Mobile, Email, Pre_Bank, Bank_Name);
		boolean msg= loan.To_verify_Homeloan_details();
		if(msg==true){
			test.log(LogStatus.PASS, "Home Loan Enquiry fill succussfully");}
		else{
			test.log(LogStatus.FAIL, "There is some issue while filling details");
			Assert.assertTrue(false,"Test Case failed");
			}
	}}
	
	@DataProvider
	public Object[][] AgentSearchData() {
		Object[][] data = getData("Datasheet.xlsx", "Agent_Search");
		return data;
	}
	@Test(dataProvider = "AgentSearchData", priority = 5)
	public void To_handle_Agent_Search(String ServiceType, String oprating_city , String Locality,String Dealing,String Property_Handle,String Agent_Name,String Agent_Code,String runMode) throws InterruptedException
	{

		test=report.startTest("To Perform Agent Search");
		if(runMode.equals("N"))
		{
			throw  new SkipException("Test Case Skip");
		}
		else
		{
		test.log(LogStatus.INFO, "To search Agent Details");
		agent_search.To_Perform_Agent_Search(ServiceType, oprating_city ,Locality,Dealing,Property_Handle);
		boolean msg= agent_search.To_verify_Agent_Search_Details(Agent_Name,Agent_Code);
		if(msg==true){
			test.log(LogStatus.PASS, "Agent Search page succussfully verified");} 
		else{
			test.log(LogStatus.FAIL, "There is some issue while Verifying details");
			Assert.assertTrue(false,"Test Case failed");}
		}
	}
	
	@Test( priority = 2)
	public void To_Verify_EMI_CalculatorPage()
	{
		test=report.startTest("Verify EMI Calculator Page");
		boolean msg=Emi_Cal.To_Verify_EMI_Details();
		if(msg==true){
			test.log(LogStatus.PASS, "EMI Calculation page succussfully verified");} 
		else{
			test.log(LogStatus.FAIL, "There is some issue while Verifying EMI Calculation details");
			Assert.assertTrue(false,"Test Case failed");}
	}
	

	
}

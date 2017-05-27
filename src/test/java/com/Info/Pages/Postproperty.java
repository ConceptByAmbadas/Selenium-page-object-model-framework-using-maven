package com.Info.Pages;

import java.io.IOException;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;
import org.testng.Assert;

import com.Info.TestBase.TestBase;

public class Postproperty extends TestBase{
	int indexSI = 1;
	final WebDriver driver;
	static Logger log = Logger.getLogger(Postproperty.class.getName());
	Screen src = new Screen();
	Random rand = new Random(); 

	public Postproperty(WebDriver driver) {
		// PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	By postpropertytab = By.xpath("//a[contains(text(),'Post Property')]");
	By verifypostpropertypage = By.xpath(".//*[@id='n']/center/font");
	By postpropertyfor = By.xpath("//*[@name='profor']");
	By propertyType = By.xpath(".//*[@id='propertyType']");
	By TransactionType = By.xpath("//*[@name='tratype']");
	By SelectpropertyCity = By.xpath("//*[@id='city' and @name='city']");
	By Selectpropertylocality = By.xpath("//*[@id='pune']");
	By selectbedroom = By.xpath("//*[@name='bedrooms']");
	By selectbathroom = By.xpath(".//*[@id='bathrooms']");
	By selectfurnishType = By.xpath(".//*[@id='furnished']");
	By entercoverarea = By.xpath("//*[@name='ca']");
	By enterBuildupArea = By.xpath("//input[@name='ca1']");
	By entercarperarea = By.xpath("//input[@name='carp']");
	By areaunit = By.xpath(".//*[@id='unt']");
	By entertotalPrice = By.xpath("//*[@name='tprice']");
	By enterPerunitprice = By.xpath("//*[@name='pup']");
	By isDisplayPrice = By.xpath("//*[@name='Seeker']");
	By FloorNo = By.xpath("//*[@name='flnum']");
	By totalFloor = By.xpath(".//*[@id='tfno']");
	By PropertyDescription = By.xpath("//*[@name='bdes']");
	By PropertyStatus = By.xpath("//*[@name='pstatus']");
	By SocietyName = By.xpath("//*[@name='proname']");
	By Societyaddress = By.xpath("//*[@name='address']");
	By pincode = By.xpath("//*[@name='pincode']");
	By Typeofownership = By.xpath("//*[@name='ownertype']");
	By ageofconstruction = By.xpath("//*[@name='ageofcons']");
	By Unitsavalible = By.xpath("//*[@name='aunit']");
	By PropertyLandmark = By.xpath("//*[@name='land']");
	By avaibleamenities = By.xpath("//*[@name='amenityInt']");
	By othercharges = By.xpath("//*[@name='other']");
	By hospitaldistance = By.xpath("//*[@name='hospital']");
	By bankdistance = By.xpath("//*[@name='bank']");
	By userprefrence = By.xpath("//*[@id='newUser2']");
	By userType = By.xpath("//*[@id='userType1']");
	By firstname = By.xpath(".//*[@name='fN']");
	By useremail = By.xpath("//*[@name='uname']");
	By userpassword = By.xpath("//*[@name='pass']");
	By usercity = By.xpath("//*[@name='cty']");
	By usermobile = By.xpath("//*[@name='mb']");
	By postpropertybutton = By.xpath("//*[@id='btn'and @value='POST PROPERTY']");
	By capchya_ans = By.xpath("//*[@name='answer']");
	By propimage=By.xpath("//input[@name='propimg']");

	public void clickOnPostpropertyTab() {
		log.info("User clicking on postproperty tab");
		driver.findElement(postpropertytab).click();

	}

	public boolean ToVerifypostpropertyPage() {
		boolean check = false;
		try {
			log.info("User is verifying postproperty page is load");
			check = driver.findElement(verifypostpropertypage).isDisplayed();
			if (check = true) {

				Assert.assertTrue(true, "post property Page load sucessfully");
			} else {
				Assert.assertTrue(false, " post property Page is not load sucessfully");
			}
		} catch (Exception ex) {
			System.out.println("Exception is" + ex.getMessage());
		}
		return check;
	}

	public void select_postpropertyfor() {
		log.info("User has clicking on property for radio button");
		driver.findElement(postpropertyfor).click();

	}

	public void select_propertyType(String property_type) {
		log.info("User has selecting property type dropdown");
		Select property_type1 = new Select(driver.findElement(propertyType));
		property_type1.selectByValue(property_type);

	}

	public void Select_TransactionType_Radio() {
		log.info("User has selecting Transaction type");
		driver.findElement(TransactionType).click();

	}

	public void SelectpropertyCity_locality(String city, String locality) {
		try {
			log.info("User has selecting property city and locality from dropdown");
			Select propertycity = new Select(driver.findElement(SelectpropertyCity));
			Select propertylocality = new Select(driver.findElement(Selectpropertylocality));
			propertycity.selectByValue("Mumbai");
			propertylocality.selectByValue(locality);

		} catch (Exception es) {
			System.out.println("Problem in selecting city is" + es.getMessage());
		}
	}

	public void Selectbedroom_And_bathroom(String bedroom, String bathroom) {
		log.info("User has selecting no of bedroom and bathrooms");
		Select beedrooms = new Select(driver.findElement(selectbedroom));
		Select bathrooms = new Select(driver.findElement(selectbathroom));
		beedrooms.selectByValue(bedroom);
		bathrooms.selectByValue(bathroom);
	}

	public void selectfurnishType(String furnishtype) {
		log.info("User has selecting Furnish type");
		Select furnish = new Select(driver.findElement(selectfurnishType));
		furnish.selectByValue(furnishtype);
	}

	public void entercoverarea(String coverarea) {
		log.info("User is entering cover area");
		driver.findElement(entercoverarea).sendKeys(coverarea);
	}

	public void enterBuildupArea(String builtuparea) {
		log.info("User is entering built up area");
		driver.findElement(enterBuildupArea).sendKeys(builtuparea);
	}

	public void entercarperarea(String carpetarea) {
		log.info("User is entering built up area");
		driver.findElement(entercarperarea).sendKeys(carpetarea);
	}

	public void entertotalPrice(String totalprice) {
		log.info("User is entering total price");
		driver.findElement(entertotalPrice).sendKeys(totalprice);
	}

	public void enterPerunitprice(String perunitprice) {
		log.info("User is entering  price per unit");
		driver.findElement(enterPerunitprice).sendKeys(perunitprice);
	}

	public void selectisDisplayPrice() {
		log.info("User is selecting display price");
		driver.findElement(isDisplayPrice).click();
	}

	public void FloorNo() {
		log.info("User is selecting No of floor");
		Select floorno = new Select(driver.findElement(FloorNo));
		floorno.selectByIndex(2);
	}

	public void totalFloor(String totalfloor) {
		log.info("User is entering total floor");
		driver.findElement(totalFloor).sendKeys(totalfloor);

	}

	public void TO_EnterPropertyDescription(String prop_decription) {
		log.info("User is entering property description");
		driver.findElement(PropertyDescription).sendKeys(prop_decription);

	}

	public void ToEnter_SocietyName(String societyname) {
		log.info("User is entering property status");
		driver.findElement(SocietyName).sendKeys(societyname);

	}

	public void TO_Select_PropertyStatus() {
		log.info("User is entering property status");
		driver.findElement(PropertyStatus).click();

	}

	public void ToEnter_Societyaddress(String societyadd) {
		log.info("User is entering Society address");
		driver.findElement(Societyaddress).sendKeys(societyadd);

	}

	public void ToEnter_Area_pincode(String Area_pincode) {
		log.info("User is entering pincode address");
		driver.findElement(pincode).sendKeys(Area_pincode);

	}

	public void Typeofownership(String typeof_ownership) {
		try {
			log.info("User is selecting type of ownership");
			Select ownershipType = new Select(driver.findElement(Typeofownership));
			ownershipType.selectByValue(typeof_ownership);

		} catch (Exception es) {
			System.out.println("Issue is" + es.getMessage());
		}
	}

	public void ToSelect_ageofConstruction(String construction_age) {
		log.info("User is selecting Age of construction");
		Select ageofConstruction = new Select(driver.findElement(ageofconstruction));
		ageofConstruction.selectByIndex(2);
	}

	public void To_Enter_Unitsavalible(String avaibleUnits) {
		log.info("User is selecting Avaible Units");
		driver.findElement(Unitsavalible).sendKeys(avaibleUnits);
	}

	public void To_Enter_LandmarkDetails(String Property_Landmark) {
		log.info("User is selecting property landmark");
		driver.findElement(PropertyLandmark).sendKeys(Property_Landmark);
	}

	public void ToSelect_avaibleAmenities() {
		log.info("User is selecting property amenities");
		driver.findElement(avaibleamenities).click();
	}

	public void To_Enter_OtherCharges(String charges) {
		log.info("User is Entering other charges");
		driver.findElement(othercharges).sendKeys(charges);
	}

	public void To_Enter_hospital_distance(String Hos_Distance) {
		log.info("User is Enterin ghospitaldistance");
		driver.findElement(hospitaldistance).sendKeys(Hos_Distance);
	}

	public void To_Enter_bankdistance(String bank_distance) {
		log.info("User is Entering bankdistance");
		driver.findElement(bankdistance).sendKeys(bank_distance);
	}

	public void To_Select_userprefrence() {
		log.info("User is selecting user prefrences");
		driver.findElement(userprefrence).click();
	}

	public void To_Select_userType() {
		log.info("User is selecting user Ttpe");
		driver.findElement(userType).click();
	}

	public void To_Enter_user_registration_details(String first_name, String email_id, String password, String city, String mobile) {
		try {
			int value = rand.nextInt(300);
			String Email = String.valueOf(value)+email_id;
			log.info("User is Entering registraion details");
			
			driver.findElement(firstname).sendKeys(first_name);
			driver.findElement(useremail).sendKeys(Email);
			driver.findElement(userpassword).sendKeys(password);
			Select cityname = new Select(driver.findElement(usercity));
			cityname.selectByIndex(2);
			driver.findElement(usermobile).sendKeys(mobile);
			driver.findElement(capchya_ans).sendKeys("10");
			//updateResult(indexSI++, "Fill Post Property Details","User has enter capchya details", "Pass","Fill Post Property details",true);
			
		} catch (Exception es) {
			System.out.println("Issue is+" + es.getMessage());
		}
	}

	public void To_Click_on_Registration_Button() {
		try {
			log.info("User is selecting user Ttpe");
			driver.findElement(postpropertybutton).click();
			waitFor(5);
			Alert alert=driver.switchTo().alert();
			String message=driver.switchTo().alert().getText();
			System.out.println("Alert Massage"+message);
			alert.accept();
			waitFor(5);

		} catch (Exception er) {
			System.out.println("Problem while clicking button is" + er.getMessage());
		}
	}

	public void To_Fill_postproperty_details(String property_type, String bathroom, String bedroom, String Furnished, String description, String first_name, String email_id, String password, String city, String mobile) {
		System.out.println("Property type" + property_type);
		clickOnPostpropertyTab();
		ToVerifypostpropertyPage();
		select_postpropertyfor();
		select_propertyType(property_type);
		Select_TransactionType_Radio();
		// SelectpropertyCity_locality("Mumbai", "Mumbai");
		Selectbedroom_And_bathroom(bathroom, bedroom);
		selectfurnishType(Furnished);
		entercoverarea("1100");
		enterBuildupArea("1320");
		entercarperarea("1120");
		entertotalPrice("650000");
		enterPerunitprice("5400");
		selectisDisplayPrice();
		totalFloor("12");
		FloorNo();
		TO_EnterPropertyDescription(description);
		ToEnter_SocietyName("Purple society");
		ToEnter_Societyaddress("Pimple gurav");
		TO_Select_PropertyStatus();
		ToEnter_Area_pincode("414502");
		Typeofownership("Freehold");
		ToSelect_ageofConstruction("5");
		To_Enter_Unitsavalible("2");
		To_Enter_LandmarkDetails("Near Dmart Shopping center,pune 31");
		ToSelect_avaibleAmenities();
		ToSelect_ageofConstruction("5");
		To_Enter_OtherCharges("No hidden charges");
		To_Enter_hospital_distance("5");
		To_Enter_bankdistance("12");
		To_Select_userprefrence();
		To_Select_userType();
		To_Enter_user_registration_details(first_name, email_id, password, city, mobile);
		To_file_upload();
		To_Click_on_Registration_Button();
	}

	public void To_file_upload() {
		try {
			driver.findElement(propimage).click();
			waitFor(5);
			Runtime.getRuntime().exec("E:\\StudyWorkpace\\com.automation.maven\\AutoIT\\FileUpload.exe");
			waitFor(5);
			
			
			
			//*******Below code use Sikuli script to upload file****/
			
			/*//Pattern browse = new Pattern("E:\\StudyWorkpace\\com.automation.maven\\images\\search.PNG");
			Pattern textfileinput = new Pattern("E:\\StudyWorkpace\\com.automation.maven\\images\\filepath.PNG");
			Pattern open = new Pattern("E:\\StudyWorkpace\\com.automation.maven\\images\\open.PNG");
			driver.findElement(propimage).click();
			//src.click(browse);
			src.type(textfileinput, "E:\\StudyWorkpace\\com.automation.maven\\images\\nature.jpg");
			src.click(open);*/

		} catch (Exception es) {
			System.out.println("file upload issue is" + es.getMessage());
		}

	}

	public boolean verifypostpropertyPage() throws IOException {
		String msg = driver.findElement(By.xpath(".//*[@id='n']/table/tbody/tr/td/form/fieldset/table/tbody/tr[1]/td/font/center")).getText();
		if (msg.contains("posted successfully")) {
			System.out.println("IN IF Message  post property verified is" + msg);
			//updateResult(indexSI++, "Fill Post Property Details","property details posted Succusfully", "Pass","Fill Post Property details",true);
			return true;
		} else {
			System.out.println("IN ELSE Message verified is" + msg);
			//updateResult(indexSI++, "Fill Post Property Details","Issue while posting property details", "Fail","Fill Post Property details",true);
			return false;
		}
		}

}

package pages;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.ButtonHelper;
import helper.DropdownHelper;
import helper.RadioButtonHelper;
import helper.TextBoxHelper;
import stepDefinations.SimpleFormDemoStepDef;

public class InputFormPage extends PageBase {
	
	private WebDriver inputDriver;
	private static Logger logs = LogManager.getLogger(SimpleFormDemoStepDef.class.getName());
	
	public InputFormPage(WebDriver driver) {
		super(driver);
		this.inputDriver = driver;		
	}
	
	@FindBy(how = How.NAME,using = "first_name")
	public WebElement first_name;
	@FindBy(how = How.NAME,using = "last_name")
	public WebElement last_name;
	@FindBy(how = How.NAME,using = "email")
	public WebElement email_ID;
	@FindBy(how = How.NAME,using = "phone")
	public WebElement phone_number;
	@FindBy(how = How.NAME,using = "city")
	public WebElement city;
	@FindBy(how = How.NAME,using = "state")
	public WebElement state_list;
	@FindBy(how = How.NAME,using = "website")
	public WebElement domain_name;
	@FindBy(how = How.XPATH,using = "//input[@value='yes']")
	public WebElement yes_radio;
	@FindBy(how = How.XPATH,using = "//input[@value='no']")
	public WebElement no_radio;
	@FindBy(how = How.XPATH,using = "//button[@innertext='Send ']")
	public WebElement send_button;
	
	public void setFirstName(String textToSet){
		if(!first_name.isDisplayed()&& !first_name.isEnabled()){
			logs.error("First name edit field display error");
		}
		first_name.clear();
		first_name.sendKeys(textToSet);
		String Fname = first_name.getText();
		if (!Fname.equalsIgnoreCase(textToSet))
			logs.error("Name entered :"+textToSet+ " is wrong");
		logs.debug("Text entered for first name: "+textToSet);
	}
	
	public void setLastName(String textToSet){
		if(!last_name.isDisplayed()&& !last_name.isEnabled()){
			logs.error("last name edit field display error");
		}
		last_name.clear();
		last_name.sendKeys(textToSet);
		String Lname = last_name.getText();
		if (!Lname.equalsIgnoreCase(textToSet))
			logs.error("Last Name entered :"+textToSet+ " is wrong");
		logs.debug("Text entered for last name: "+textToSet);
	}
	
	public void setEmail(String emailToSet){
		if(!email_ID.isDisplayed()&& !email_ID.isEnabled()){
			logs.error("Email edit field display error");
		}
		email_ID.clear();
		email_ID.sendKeys(emailToSet);
		logs.debug("Text entered for email id: "+emailToSet);
		String emailA = last_name.getText();
		if (!emailA.equalsIgnoreCase(emailToSet))
			logs.error("Last Name entered :"+emailToSet+ " is wrong");
		logs.debug("Email entered: "+emailToSet);
	}
	public void setPhoneNumber(String number){
		if(!phone_number.isDisplayed()&& !phone_number.isEnabled()){
			logs.error("phone number edit field display error");
		}
		phone_number.clear();
		phone_number.sendKeys(number);
		String phoneA = phone_number.getText();
		if (!phoneA.equalsIgnoreCase(number))
			logs.error("Number entered :"+number+ " is wrong");
		logs.debug("Text entered for phone number: "+number);
	}
	
	public void setCity(String cityText){
		if(!city.isDisplayed()&& !city.isEnabled()){
			logs.error("city edit field display error");
		}
		city.clear();
		city.sendKeys(cityText);
		String cityA = phone_number.getText();
		if (!cityA.equalsIgnoreCase(cityText))
			logs.error("City entered :"+cityText+ " is wrong");
		logs.debug("Text entered for city: "+cityText);
	}
	
	public void selectState(String statetoSelect){
		if(!state_list.isDisplayed()&& !state_list.isEnabled()){
			logs.error("state list field display error");
		}
		DropdownHelper dHelper = DropdownHelper.getInstance(inputDriver);
		dHelper.selectByVisibleText(state_list, statetoSelect);
		String stateA = state_list.getText();
		if (!stateA.equalsIgnoreCase(statetoSelect))
			logs.error("State selected :"+statetoSelect+ " is wrong");
		logs.debug("Selected value from state list: "+statetoSelect);
	}
	
	public void setRadioButton(String expRadio){
		switch (expRadio.toUpperCase()){
		case "YES":
			if(!yes_radio.isDisplayed()&& !yes_radio.isEnabled()){
				logs.error("Yes Radio field display error: "+expRadio.toString());
			}
			yes_radio.click();
			logs.debug("Radio selected: "+expRadio);
			break;
		case "NO":
			if(!no_radio.isDisplayed()&& !no_radio.isEnabled()){
				logs.error("No Radio field display error: "+expRadio.toString());
			}
			no_radio.click();
			logs.debug("Radio selected: "+expRadio);
			break;
		
		 default:
			logs.error("Wrong Radio selection provided");
		}
		
	}
	
}

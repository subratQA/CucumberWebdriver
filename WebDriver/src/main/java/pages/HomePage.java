package pages;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDefinations.SimpleFormDemoStepDef;

public class HomePage extends PageBase {
	
	private WebDriver driver;
	private static Logger logs = LogManager.getLogger(SimpleFormDemoStepDef.class.getName());
	
	public HomePage(WebDriver driver){
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH,using = "//*[@id='basic']/div/a[1]")
	public WebElement simple_form_demo;
	@FindBy(how = How.XPATH,using = "//?/a[@innertext='Check Box Demo']")
	public WebElement check_box_demo;
	@FindBy(how = How.CSS,using = "#navbar-brand-centered .navbar-nav:nth-of-type(1) .dropdown:nth-of-type(1) .dropdown-toggle")
	public WebElement input_form_header;
	@FindBy(how = How.XPATH,using = "///a[@innertext='Date pickers']")
	public WebElement date_pickers_header;
	@FindBy(how = How.XPATH,using = "///a[@innertext='Table']")
	public WebElement table_header;
	@FindBy(how = How.XPATH,using = "//a[@href='https://www.seleniumeasy.com/test/basic-first-form-demo.html']")
	public WebElement simple_form;
	@FindBy(how = How.XPATH,using = "//div[@id='navbar-brand-centered']/ul[@class='nav navbar-nav']/li[1]/ul[@class='dropdown-menu']//a[@href='./basic-checkbox-demo.html']")
	public WebElement checkbox_form;
	@FindBy(how = How.XPATH,using = "//div[#'navbar-brand-centered']/ul[1]//a[@innertext='Radio Buttons Demo']")
	public WebElement radio_btn_demo;
	@FindBy(how = How.XPATH,using = "//div[@id='navbar-brand-centered']/ul[@class='nav navbar-nav']/li[1]/ul[@class='dropdown-menu']//a[@href='./basic-select-dropdown-demo.html']")
	public WebElement select_drpdwn;
	@FindBy(how = How.XPATH,using = "//div[#'basic']/?/?/a[@innertext='Javascript Alerts']")
	public WebElement javasript_alerts;
	@FindBy(how = How.XPATH,using = "//div[#'basic']/?/?/a[@innertext='Window Popup Modal']")
	public WebElement winsows_popup;
	@FindBy(how = How.XPATH,using = "//div[#'basic']/?/?/a[@innertext='Bootstrap Alerts']")
	public WebElement bootstrap_alerts;
	@FindBy(how = How.XPATH,using = "//div[#'basic']/?/?/a[@innertext='Bootstrap Modals']")
	public WebElement bootsrap_modals;
	@FindBy(how = How.ID,using = "btn_inter_example")
	public WebElement procedd_nxt_btn;
	@FindBy(how = How.ID,using = "gi_oneway_label")
	public WebElement onway_radio;
	@FindBy(how = How.ID,using = "gi_multicity_label")
	public WebElement multiwaytrip_radio;
	

	
	public void clickArrowIcons(String btnName)	
	{
		switch(btnName.toUpperCase())
		{
		case "BASIC.*":
			basic_icon.click();
			break;
		case "INTER.*":
			inter_icon.click();
			break;
		case "ADVANCE.*":
			advance_icon.click();
			break;
		case "COMPLETED.*":
			completed_icon.click();
			break;

		}	
	}
	
	public void clickStartPractiseBtn(){
		start_parctising_btn.click();
	}
	
	public void clickProceedNextBtn(){
		procedd_nxt_btn.click();
	}
	
	public PageBase clickSimpleFormDemo(){
		SimpleFormPage inputfrom = new SimpleFormPage(driver);
		simple_form_demo.click();
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOf(inputfrom.enter_msg));		
		return inputfrom;
		
	}
	
	public PageBase clickCheckBoxDemo(){
		CheckboxDemoPage checkbox = new CheckboxDemoPage(driver);
		check_box_demo.click();
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOf(checkbox.simple_checkbox));		
		return checkbox;
		
	}
	
	public void selectHeaderDropdown(String listName){
		switch (listName.toUpperCase()){
			case "INPUT FORMS":			
				input_form_header.click();
				logs.debug("Input form header selected");
				break;
			case "DATE PICKERS":
				date_pickers_header.click();
				logs.debug("Date Picker header selected");
				break;
			case "TABLE":
				table_header.click();
				logs.debug("Table header selected");
				break;
			
				
			default :
				logs.error("Invalid header name provided!");
		}
		
	}
	
	public PageBase selectCheckboxFromInputForm() throws InterruptedException{
		
		selectHeaderDropdown("Input forms");
		Thread.sleep(2000);	
		CheckboxDemoPage check = new CheckboxDemoPage(driver);
		checkbox_form.click();
		logs.debug("checkbox demo selected from header list");
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOf(check.check_all_btn));
		return check;
	}
	public PageBase selectSimpleDemoFormFromInputForm() throws InterruptedException{
		selectHeaderDropdown("Input forms");
		Thread.sleep(2000);	
		SimpleFormPage simple = new SimpleFormPage(driver);
		simple_form.click();
		logs.debug("simple form demo selected from header list");
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOf(simple.enter_msg));	
		return simple;
	  }
	public PageBase selectDropdownFromInputForm() throws InterruptedException{
		selectHeaderDropdown("Input forms");
		Thread.sleep(2000);	
		DropdownPage drop = new DropdownPage(driver);
		select_drpdwn.click();
		logs.debug("Dropdown list selected from header list");
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOf(drop.demo_list));	
		return drop;
	  }
	
	public PageBase selectRadioFromInputForm() throws InterruptedException{
		selectHeaderDropdown("Input forms");
		Thread.sleep(2000);	
		RadioButtonsDemoPage drop = new RadioButtonsDemoPage(driver);
		radio_btn_demo.click();
		logs.debug("Radio Button option selected from header list");
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOf(drop.male_grp_radio));	
		return drop;
	  }
	}
	
	
	


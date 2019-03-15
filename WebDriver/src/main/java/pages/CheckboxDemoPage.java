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
import helper.TextBoxHelper;
import stepDefinations.SimpleFormDemoStepDef;

public class CheckboxDemoPage extends PageBase {
	
	private WebDriver checkBoxdriver;
	private static Logger logs = LogManager.getLogger(SimpleFormDemoStepDef.class.getName());
	
	public CheckboxDemoPage(WebDriver driver) {
		super(driver);
		this.checkBoxdriver = driver;
	}
	
	@FindBy(how = How.ID,using = "isAgeSelected")
	public WebElement simple_checkbox;
	@FindBy(how = How.XPATH,using = "///label[@innertext='Option 1']")
	public WebElement option1_checkbox;
	@FindBy(how = How.XPATH,using = "///label[@innertext='Option 2']")
	public WebElement option2_checkbox;
	@FindBy(how = How.XPATH,using = "///label[@innertext='Option 3']")
	public WebElement option3_checkbox;
	@FindBy(how = How.XPATH,using = "///label[@innertext='Option 4']")
	public WebElement option4_checkbox;
	@FindBy(how = How.ID,using = "check1")
	public WebElement check_all_btn;
	@FindBy(how = How.ID,using = "txtAge")
	public WebElement message_checkbox;
	
	
	public void clickFirstCheckbox(){
		//ButtonHelper clickCheck = ButtonHelper.getInstance(driver);
		simple_checkbox.click();
		logs.debug("clicked on first checkbox in checkbox page");
	}

	public void getCheckboxMessage(String textToCheck){
		//TextBoxHelper getText = TextBoxHelper.getInstance(driver);
		//String actText = getText.getText(locator);
		String actText = message_checkbox.getText();
		if(!actText.equalsIgnoreCase(textToCheck))
		{
			logs.error("Text mismtached : "+textToCheck);
		}
	}
	
	public void clickCheckAllBtn(){
		//ButtonHelper clickBtn = ButtonHelper.getInstance(driver);
		check_all_btn.click();
		logs.debug("Clicked on Check All button");
	}
	public void clickOptionOneCheckbox(){
		option1_checkbox.click();
	}
	public void clickOptionTwoCheckbox(){
		option2_checkbox.click();
	}
	
	

}

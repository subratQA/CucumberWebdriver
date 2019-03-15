package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

public class RadioButtonsDemoPage extends PageBase {
	
	private WebDriver rdriver;
	private static Logger logs = LogManager.getLogger(SimpleFormDemoStepDef.class.getName());
	
	public RadioButtonsDemoPage(WebDriver driver) {
		super(driver);
		this.rdriver = driver;
	}
	
	@FindBy(how = How.XPATH,using = "//label[@innertext='Female']/input[@name='optradio']")
	public WebElement female_radio;
	@FindBy(how = How.XPATH,using = "//label[@innertext='Male']/input[@name='optradio']")
	public WebElement male_radio;
	@FindBy(how = How.ID,using = "buttoncheck")
	public WebElement get_checked_btn;
	@FindBy(how = How.CSS,using = ".radiobutton")
	public WebElement msgText_single;
	@FindBy(how = How.XPATH,using = "//label[@innertext='Female']/input[@name='gender']")
	public WebElement female_grp_radio;
	@FindBy(how = How.XPATH,using = "//label[@innertext='Male']/input[@name='gender']")
	public WebElement male_grp_radio;
	@FindBy(how = How.XPATH,using = "///label[@innertext='0 to 5']")
	public WebElement age_grp_1;
	@FindBy(how = How.XPATH,using = "///label[@innertext='5 to 15']")
	public WebElement age_grp_2;
	@FindBy(how = How.XPATH,using = "///label[@innertext='15 to 50']")
	public WebElement age_grp_3;
	@FindBy(how = How.XPATH,using = "///button[@innertext='Get values']")
	public WebElement get_value_btn;
	
	
	public void clickMaleFemaleRadioButton(String expRadio){
		switch (expRadio.toUpperCase()) {
		case "MALE":
			clickRadioForMale();
			logs.debug("Clicked on Male Radio");
			break;
		case "FEMALE":
			clickRadioForFemale();
			logs.debug("Clicked on FeMale Radio");
			break;
		default:
			logs.error("Wrong input for radio button is provided : "+expRadio);
			break;
		}
	}
	public void clickRadioForMale(){
		ButtonHelper clickCheck = ButtonHelper.getInstance(rdriver);
		clickCheck.click(male_radio);
	}
	public void clickRadioForFemale(){
		ButtonHelper clickCheck = ButtonHelper.getInstance(rdriver);
		clickCheck.click(female_radio);
	}
	public void clickGetCheckedValueBtn(){
		ButtonHelper clickCheck = ButtonHelper.getInstance(rdriver);
		clickCheck.click( get_checked_btn);
	}
	public void clickRadioForMaleGrp(){
		ButtonHelper clickCheck = ButtonHelper.getInstance(rdriver);
		clickCheck.click(male_grp_radio);
	}
	public void clickRadioForAge0To5(){
		ButtonHelper clickCheck = ButtonHelper.getInstance(rdriver);
		clickCheck.click( age_grp_1);
	}
	
	public void clickRadioForAge5To15(){
		ButtonHelper clickCheck = ButtonHelper.getInstance(rdriver);
		clickCheck.click( age_grp_2);
	}
	public void clickRadioForAge15To50(){
		ButtonHelper clickCheck = ButtonHelper.getInstance(rdriver);
		clickCheck.click( age_grp_3);
	}
	public void clickRadioForFemaleGrp(){
		ButtonHelper clickCheck = ButtonHelper.getInstance(rdriver);
		clickCheck.click( female_grp_radio);
	}
	public void clickGetValueBtn(){
		ButtonHelper clickCheck = ButtonHelper.getInstance(rdriver);
		clickCheck.click(get_value_btn);
	}

	public void getRadioMessage(String textToCheck){
		TextBoxHelper getText = TextBoxHelper.getInstance(rdriver);
		String actText = getText.getText(msgText_single);
		if(!actText.equalsIgnoreCase(textToCheck))
		{
			System.out.println("Failed!!");
		}
	}
	
	public void getRadioMessageGrp(String textToCheck){
		TextBoxHelper getText = TextBoxHelper.getInstance(rdriver);
		String actText = getText.getText(msgText_single);
		if(!actText.equalsIgnoreCase(textToCheck))
		{
			System.out.println("Failed!!");
		}
	}
	
	public void selectRadioByName(String elementHead, String expRadio){
		if (GetHeaderObjectByText(elementHead)!=null){
		List<WebElement> oList = rdriver.findElements(By.xpath("//input[@type='radio']"));
		int count = oList.size();
		for (int i=0;i<count;i++){			
			String actText = oList.get(i).getAttribute("Value");
			if (actText.equalsIgnoreCase(expRadio)){
				oList.get(i).click();
				logs.debug("User selected radio: "+expRadio +" for header : "+elementHead);
				 break;
				 }
			else{
				logs.error("Object Not found");
			}
		  }	
		}
	}
		
	public WebElement GetHeaderObjectByText(String headerElement){
		List<WebElement> oEle = rdriver.findElements(By.className("panel-heading"));
		int count1 = oEle.size();
		int actIndex = 0;
		String headerFound = "";
		for (int i=0;i<count1;i++){
			if (headerElement.equals(oEle.get(i).getText())){
				logs.debug("Found the header :" +headerElement);
				actIndex = i;
				headerFound = "Matched";
				break;
			}
			if (headerFound != "Matched"){
				logs.error("Not found the header :" +headerElement);
				return null;
			}
		}
		return oEle.get(actIndex);
	}
	
	public void clickButton(String elementHead, String btnName){
		if (GetHeaderObjectByText(elementHead)!=null){
			List<WebElement> oList = rdriver.findElements(By.xpath("//input[@type='button']"));
			int count = oList.size();
			for (int i=0;i<count;i++){			
				String actText = oList.get(i).getAttribute("Value");
				if (actText.equalsIgnoreCase(btnName)){
					oList.get(i).click();
					logs.debug("User selected button: "+btnName +" for header : "+elementHead);
					 break;
					 }
				else{
					logs.error("Object Not found");
				}
			  }	
			}
		}
	}
	


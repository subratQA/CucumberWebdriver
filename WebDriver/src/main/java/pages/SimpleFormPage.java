package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.ButtonHelper;
import helper.TextBoxHelper;

public class SimpleFormPage extends PageBase{
	
	private WebDriver driver;
	
	@FindBy(how = How.XPATH,using = "//input[@id='user-message']")
	public WebElement enter_msg;
	@FindBy(how = How.XPATH,using = "//*[@id='get-input']/button")
	public WebElement show_msg_btn;
	@FindBy(how = How.ID,using = "sum1")
	public WebElement value1;
	@FindBy(how = How.XPATH,using = "//form[#'gettotal']/button[@innertext='Get Total']")
	public WebElement get_total_btn;
	@FindBy(how=How.ID,using="sum2")
	public WebElement value2;
	@FindBy(how=How.XPATH,using="//span[#'displayvalue']")
	public WebElement result;
	@FindBy(how=How.XPATH,using="//span[#'display']")
	public WebElement msg_display;
	@FindBy(how=How.ID,using="//a[@contains='Forgot Password']")
	public WebElement forgetpass_link;
	@FindBy(how=How.CSS,using="#display")
	public WebElement yourmessage_text;
	
	
	public SimpleFormPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
	}
	
	
	public void setTextInMessageField(String msgText){
		enter_msg.sendKeys(msgText);
	}
	public void setTextinValueField(String  a, String b) throws InterruptedException{
		TextBoxHelper value = TextBoxHelper.getInstance(driver);		
		value.setText(value1, a);
		value.setText(value2, b);
	}
	public String getTextFromTotalField(WebElement locator) throws InterruptedException{
		TextBoxHelper value = TextBoxHelper.getInstance(driver);
		ButtonHelper clickBtn = ButtonHelper.getInstance(driver);
		clickBtn.click(get_total_btn);
		Thread.sleep(1000);
		return value.getText(locator);
	}
	
	public String getMessagDisplay() {
		//TextBoxHelper Text = TextBoxHelper.getInstance(driver);
		return yourmessage_text.getText();
		
	}
	
	public void clickShowMsgBtn() {
		//ButtonHelper clickBtn = ButtonHelper.getInstance(driver);
		show_msg_btn.click();
	}	
		
	}


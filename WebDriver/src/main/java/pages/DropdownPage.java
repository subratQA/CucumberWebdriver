package pages;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import helper.ButtonHelper;
import helper.DropdownHelper;
import helper.TextBoxHelper;
import stepDefinations.SimpleFormDemoStepDef;

public class DropdownPage extends PageBase {
	
	private WebDriver driver;
	private static Logger logs = LogManager.getLogger(SimpleFormDemoStepDef.class.getName());
	
	public DropdownPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(how = How.ID,using = "select-demo")
	public WebElement demo_list;
	
	@FindBy(how=How.XPATH, using="//div[@class='panel-body'][2]/p[2]")
	public WebElement single_day_selected;
	
	public void selectItemFromDemoList(String ItemToSelect){
		
		DropdownHelper drop = DropdownHelper.getInstance(driver);
		drop.selectByValue(demo_list,ItemToSelect);		
		logs.debug("selected item from list : " +ItemToSelect);
	}
	
	public void getTextMessageCompared(String msg){
		if(!single_day_selected.isDisplayed()){
			WebDriverWait wait = getWait();
			wait.until(ExpectedConditions.visibilityOfElementLocated((By) single_day_selected));
		}	
		String text = single_day_selected.getText();
		if (!text.contains(msg))
			logs.error("Failed to validate the text : "+msg);
		logs.debug("Validation success: "+msg);
	}
	

}

package pages;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


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

	
	
	public void selectItemFromDemoList(String ItemToSelect){
		
		DropdownHelper drop = DropdownHelper.getInstance(driver);
		drop.selectByValue(demo_list,ItemToSelect);		
		logs.debug("selected item from list : " +ItemToSelect);
	}

	
	

}

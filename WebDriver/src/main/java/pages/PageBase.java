package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pagefactory.CustomFactory;
import pagefactory.PageName;


public class PageBase {
	
	private WebDriver driver;
	
	@FindBy(how = How.ID,using = "btn_basic_example")
	public WebElement start_parctising_btn;
	@FindBy(how = How.LINK_TEXT,using = "All Examples")
	public WebElement all_examples_link;
	@FindBy(how = How.LINK_TEXT,using = "Input Forms")
	public WebElement input_forms_link;
	@FindBy(how = How.LINK_TEXT,using = "Date pickers")
	public WebElement date_pickers_link;
	@FindBy(how = How.LINK_TEXT,using = "Table")
	public WebElement table_link;
	@FindBy(how = How.LINK_TEXT,using = "Progress Bars & Sliders")
	public WebElement progress_bars_sliders_link;
	@FindBy(how = How.LINK_TEXT,using = "Alerts & Modals")
	public WebElement alerts_modals_link;
	@FindBy(how = How.LINK_TEXT,using = "List Box")
	public WebElement list_box_link;
	@FindBy(how = How.LINK_TEXT,using = "Others")
	public WebElement others_link;
	@FindBy(how = How.CSS,using = ".two")
	public WebElement basic_icon;
	@FindBy(how = How.CSS,using = ".three")
	public WebElement inter_icon;
	@FindBy(how = How.CSS,using = ".four")
	public WebElement advance_icon;
	@FindBy(how = How.XPATH,using = ".five")
	public WebElement completed_icon;
	
	
	
	public PageBase(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	protected WebDriverWait getWait(){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		wait.ignoring(NoSuchElementException.class);
		return wait;
	}
	
	protected PageBase navigateTo(PageName name,WebDriver driver,WebElement element){
		WebDriverWait wait = getWait();
		wait.until(ExpectedConditions.visibilityOf(element));
		return CustomFactory.getInstance(name, driver);
		
	}
	



}

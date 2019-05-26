package stepDefinations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.*;

import cucumber.api.DataTable;
import cucumber.api.Transform;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import helper.BrowserHelper;
import helper.TextBoxHelper;
import pages.CheckboxDemoPage;
import pages.HomePage;
import pages.SimpleFormPage;
import services.DriverServices;
import utils.TestSettings;

public class SimpleFormDemoStepDef {

	private WebDriver driver;
	private WebDriver.Navigation navigate;
	private BrowserHelper browserHelper;
	private DriverServices services;
	private TestSettings testSettings;
	private CheckboxDemoPage loginText;
	private static TextBoxHelper headerText;
	private static Logger logs = LogManager.getLogger(SimpleFormDemoStepDef.class.getName());

	
	public SimpleFormDemoStepDef(DriverServices services, TestSettings testSettings) {
		this.services = services;
		this.driver = services.getDriver();
		this.testSettings = testSettings;
	}
	
/*	@Given("^User launches the application$")
	public void user_launches_the_application() throws Throwable {
		driver.get(services.getReader().getApplicationUrl());
		testSettings.homepage = new HomePage(driver);
		logs.info("User has launched ");
	}*/
	
	@Given("^User is in Simple Form Demo Page$")
	public void user_is_in_Simple_Form_Demo_Page() throws Throwable {		
		testSettings.home_page.clickStartPractiseBtn();
		Thread.sleep(2000);
		testSettings.simple_page = (SimpleFormPage) testSettings.home_page.clickSimpleFormDemo();
		logs.info("User is in Simple Form Demo Page");
	}

	@Given("^User enters text \"([^\"]*)\" in Enter Message text box$")
	public void user_enters_text_in_Enter_Message_text_box(String msgText) throws Throwable {
		testSettings.simple_page.setTextInMessageField(msgText);
		logs.info("User enters the text: " +msgText);
	}

	@Given("^User clicks on Show Message Button$")
	public void user_clicks_on_Show_Message_Button() throws Throwable {
		testSettings.simple_page.clickShowMsgBtn();
		logs.info("User clicked on Show Message Button");
	}

	@Then("^User should be able to see the message as \"([^\"]*)\"$")
	public void user_should_be_able_to_see_the_message_as(String expText) throws Throwable {
		String actText = testSettings.simple_page.getMessagDisplay();
		if(actText.equalsIgnoreCase(expText))
		{
			//System.out.println("Identified the expected text");
			logs.debug("Identified the expected text: "+expText);
			
		}else{
			//System.out.println("Failed to identify the text");
			logs.error("Failed to identify the text: "+expText);
		}
			
	}
	
	@Given("^User enters Two Input fields data text fields from \"([^\"]*)\"$")
	public void user_enters_Two_Input_fields_data_text_fields_from(@Transform(utils.ExcelDataToDataTable.class)DataTable table) throws Throwable {
		List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
		Map<String, String> dataMap = dataList.get(1);
		testSettings.simple_page.setTextinValueField(dataMap.get("value1"), dataMap.get("value2"));
		logs.debug("User entred value1 as :"+dataMap.get("value1") + "entered value2 as : "+dataMap.get("value2"));
	}

	@Given("^clicks Get Total Button$")
	public void clicks_Get_Total_Button() throws Throwable {
		testSettings.simple_page.get_total_btn.click();
		logs.debug("User clicked on get total button");
	}

	@Then("^User should see the message mentioned in \"([^\"]*)\"$")
	public boolean user_should_see_the_message_mentioned_in(@Transform(utils.ExcelDataToDataTable.class)DataTable table) throws Throwable {
		List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
		Map<String, String> dataMap = dataList.get(1);
		String getResult = testSettings.simple_page.getTextFromTotalField(testSettings.simple_page.result);
		//assert.assertEquals(getResult.contains(dataMap.get("sum")),"String mismatch"));
		return false;
	}


	
}

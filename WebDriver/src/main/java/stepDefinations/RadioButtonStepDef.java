package stepDefinations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import helper.BrowserHelper;
import helper.TextBoxHelper;
import pages.CheckboxDemoPage;
import pages.RadioButtonsDemoPage;
import services.DriverServices;
import utils.TestSettings;

public class RadioButtonStepDef {
	
	private WebDriver driver;
	private WebDriver.Navigation navigate;
	private DriverServices services;
	private TestSettings testSettings;
	private static TextBoxHelper headerText;
	private static Logger logs = LogManager.getLogger(RadioButtonStepDef.class.getName());

	
	public RadioButtonStepDef(DriverServices services, TestSettings testSettings) {
		this.services = services;
		this.driver = services.getDriver();
		this.testSettings = testSettings;
	}
	
	@Given("^User is in Radio Button Demo Page$")
	public void user_is_in_Radio_Button_Demo_Page() throws Throwable {
		testSettings.home_page.clickStartPractiseBtn();
		Thread.sleep(2000);
	    testSettings.radio_page =  (RadioButtonsDemoPage) testSettings.home_page.selectRadioFromInputForm();
	    logs.info("User is in Radio Button Demo Page");
	}

	@And("^User selects \"([^\"]*)\" radio button from \"([^\"]*)\"$")
	public void user_selects_radio_button(String header, String radio) throws Throwable {
		//testSettings.radio_page.clickMaleFemaleRadioButton(radio);
		testSettings.radio_page.selectRadioByName(header, radio);
	}

	@Given("^User clicks on Get Checked value Button$")
	public void user_clicks_on_Get_Checked_value_Button() throws Throwable {
		testSettings.radio_page.clickGetCheckedValueBtn();	
		logs.info("User clicked on GetCheckedValue Button");
	}
	
/*	@And("^User selects \"([^\"]*)\" radio button from \"([^\"]*)\"$")
	public void user_selects_radio_button_from_group_radio_demo(String header, String radio) throws Throwable {
	    testSettings.radio_page.selectRadioByName(header, radio);
	}*/

/*	@Given("^User selects \"([^\"]*)\" radio button from \"([^\"]*)\"$")
	public void user_selects_radio_button_for(String header, String radio) throws Throwable {
	   testSettings.radio_page.selectRadioByName(header, radio);
	}*/

	@And("^User clicks on \"([^\"]*)\" button from \"([^\"]*)\"$")
	public void user_clicks_on_Get_values_Button(String header, String btnname) throws Throwable {
	    testSettings.radio_page.clickButton(header, btnname);
	}

	@Then("^User should be able to see the message as \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_should_be_able_to_see_the_message_as_and(String arg1, String arg2) throws Throwable {
	    
	}


}

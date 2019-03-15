package stepDefinations;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.CheckboxDemoPage;
import pages.DropdownPage;
import services.DriverServices;
import utils.TestSettings;

public class DropdownStepDef {
	
	private WebDriver driver;
	private DriverServices dfnservices;
	private TestSettings dfntestSettings;
	private static Logger logs = LogManager.getLogger(CheckboxDemoStepDef.class.getName());
	
	public DropdownStepDef(DriverServices services, TestSettings testSettings) {
		this.dfnservices = services;
		this.driver = services.getDriver();
		this.dfntestSettings = testSettings;
	}
	
	@Given("^User is in Dropdown Page$")
	public void user_is_in_Dropdown_Page() throws Throwable {
		dfntestSettings.dropdown_page = (DropdownPage) dfntestSettings.homepage.selectDropdownFromInputForm();
		logs.debug("User is at Dropdown page");
	}

	@And("^User selects \"([^\"]*)\" from Select a Day Dropdown$")
	public void user_selects_from_Select_a_Day_Dropdown(String ItemToSelect) throws Throwable {
		dfntestSettings.dropdown_page.selectItemFromDemoList(ItemToSelect);

	}

	@Then("^User verifies message displayed \"([^\"]*)\" for Select List Demo$")
	public void user_verifies_message_displayed_for_Select_List_Demo(String arg1) throws Throwable {

	}

}

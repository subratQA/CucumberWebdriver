package stepDefinations;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import helper.BrowserHelper;
import helper.TextBoxHelper;
import pages.CheckboxDemoPage;
import pages.HomePage;
import pages.SimpleFormPage;
import services.DriverServices;
import utils.TestSettings;

public class CheckboxDemoStepDef {

	private WebDriver driver;
	private DriverServices services;
	private TestSettings deftestSettings;
	private static Logger logs = LogManager.getLogger(CheckboxDemoStepDef.class.getName());

	
	public CheckboxDemoStepDef(DriverServices services, TestSettings testSettings) {
		this.services = services;
		this.driver = services.getDriver();
		this.deftestSettings = testSettings;
	}
	
/*	@Given("^User launches the application$")
	public void user_launches_the_application() throws Throwable {
		driver.get(services.getReader().getApplicationUrl());
		deftestSettings.homepage = new HomePage(driver);
		logs.info("User has launched application");
	}*/
	@Given("^User is in Checkbox Demo Page$")
	public void user_is_in_Checkbox_Demo_Page() throws Throwable {
		deftestSettings.checkbox_page = (CheckboxDemoPage) deftestSettings.home_page.selectCheckboxFromInputForm();
		logs.debug("User is at checbox demo page");
	}

	@Given("^User selects Click on this check box field$")
	public void user_selects_Click_on_this_check_box_field() throws Throwable {
		deftestSettings.checkbox_page.clickFirstCheckbox();
		logs.debug("User clicked first checkbox");
	}

	@Then("^User verifies message displayed \"([^\"]*)\"$")
	public void user_verifies_message_displayed(String message) throws Throwable {
		deftestSettings.checkbox_page.getCheckboxMessage(message);
		logs.debug("User verified the message: "+message);
	}

	
}

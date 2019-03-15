package generichook;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import services.DriverServices;
import stepDefinations.SimpleFormDemoStepDef;

public class GeneralHook {
	
	private DriverServices services;
	private WebDriver driver;
	private static Logger logs = LogManager.getLogger(SimpleFormDemoStepDef.class.getName());
	
	public GeneralHook(DriverServices services) {
		this.services = services;
		this.driver = services.getDriver();
	}
	
	@BeforeMethod
	@Before(value="@regression",order = 2)
	public void setupForRegression(){
		System.out.println("This is regression suite");
	}
	
	@BeforeMethod
	@Before(value="@smoke")
	public void setupForSmoke(){
		System.out.println("This is smoke suite");
	}
	
	@BeforeMethod
	@Before(order = 1)
	public void setup() {
		//System.out.println(" This is normal hook");
	}
	
	@AfterMethod
	public void teardown(Scenario scenario) {
		if(scenario.isFailed()){
			captureScreenShot(scenario);
			
					}
		if(driver != null){
	    	driver.quit(); // it will close all the window and stop the web driver
	    }
		
	}

	private void captureScreenShot(Scenario scenario) {
		int random = (int)(Math.random() * 1000);
		services.getGenericHelper().takeScrenShot("Screenshot", scenario.getName() +"_"+ random+".png");
		scenario.embed(services.getGenericHelper().takeScrenShot(), "image/png");
	}

}

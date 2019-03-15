package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import customrunner.CustomAbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/test/java/features"},
		glue = {"stepDefinations","generichook"},
		tags={"@smoke1"},
		dryRun = false,
		monochrome = true,
		plugin = {"pretty","json:target/bugcreationrunner.json","html:target/HTMLReport"}
		)
public class Runner extends CustomAbstractTestNGCucumberTests {
//public class Runner extends AbstractTestNGCucumberTests {

}

/**
 * 1. To create a generic method that will navigate to corr page
 * 2. Use Factory design patter to get the instance of corr page after the navigation
 * */
 
package runner;

import cucumber.api.CucumberOptions;
import customrunner.CustomAbstractTestNGCucumberTests;

@CucumberOptions(
		features = {"src/test/java/features/RadioButton.feature"},
		glue = {"stepDefinations"},
		//tags={"@regression"},
		dryRun = false,
		monochrome = true,
		plugin = {"pretty","json:target/bugcreationrunner.json","html:target/HTMLReport"}
		)
/*public class radioRunner extends CustomAbstractTestNGCucumberTests {
//public class Runner extends AbstractTestNGCucumberTests {

}*/

public class radioRunner extends CustomAbstractTestNGCucumberTests {
	//public class Runner extends AbstractTestNGCucumberTests {

	}

/**
 * 1. To create a generic method that will navigate to corr page
 * 2. Use Factory design patter to get the instance of corr page after the navigation
 * */
 
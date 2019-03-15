package pagefactory;

import java.util.logging.SimpleFormatter;

import org.openqa.selenium.WebDriver;

import pages.CheckboxDemoPage;
import pages.DropdownPage;
import pages.HomePage;
import pages.PageBase;
import pages.RadioButtonsDemoPage;
import pages.SimpleFormPage;



public class CustomFactory {
	
	/*
	 * Factory design pattern is used when we have a super class with multiple sub-classes and based on input, we need to return one of the sub-class instance
	 * Super Class - PageBase -> HomePageClass, LoginPageClass, EnterBugClass so on
	 * Navigation --> Based on input we need to have intance of corr page class
	 * */
	
	public static PageBase getInstance(PageName name,WebDriver driver) {
		
		switch (name) {
			case HomePage:
				return new HomePage(driver);
			case Dropdown:
				return new DropdownPage(driver);
			case CheckBox:
				return new CheckboxDemoPage(driver);
			case RadioButtons:
				return new RadioButtonsDemoPage(driver);
			case SimpleForm:
				return new SimpleFormPage(driver);


		default:
			throw new RuntimeException("Invalid Page Name");
		}
		
	}

}

package helper;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioButtonHelper {
	
	private static RadioButtonHelper radioHelper;
	private static WebDriver wdDrvier;
	
	private RadioButtonHelper(WebDriver driver){
		wdDrvier = driver;
	}
	
	public static RadioButtonHelper getInstance(WebDriver driver){
		if(radioHelper == null || wdDrvier.hashCode() != driver.hashCode())
			radioHelper = new RadioButtonHelper(driver);
		return radioHelper;
	}
	

	

}

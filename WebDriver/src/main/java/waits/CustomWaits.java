package waits;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomWaits {
	private Function<WebDriver, Boolean> customWait(){
		Function<WebDriver, Boolean> wait = new Function<WebDriver, Boolean>() {

			@Override
			public Boolean apply(WebDriver t) {
				if( t.findElements(By.xpath("//input[@value='Log In']")).size() >= 1){
					System.err.println("WebElement Located");
					return true;
				}
				System.out.println("Waiting...");
				return false;
			}
		};
		
		return wait;
	}
	
	private Function<WebDriver, WebElement> customWaitOnElement(){
		Function<WebDriver, WebElement> wait = new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver t) {
				if( t.findElements(By.xpath("//input[@value='Log In']")).size() >= 1){
					System.err.println("WebElement Located");
					return t.findElement(By.xpath("//input[@value='Log In']"));
				}
				System.out.println("Waiting...");
				return null;
			}
		};
		
		return wait;
	}
	
	private Function<WebDriver, WebElement> customWaitWithParameter(By locator){
		Function<WebDriver, WebElement> wait = new Function<WebDriver, WebElement>() {

			@Override
			public WebElement apply(WebDriver t) {
				if( t.findElements(locator).size() >= 1){
					System.err.println("WebElement Located");
					return t.findElement(locator);
				}
				System.out.println("Waiting...");
				return null;
			}
		};
		return wait;
	}

}

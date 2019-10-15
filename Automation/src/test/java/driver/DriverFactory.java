package driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	private static WebDriver driver = null;
	
	public static WebDriver GetDriver() {
		if(driver == null) {
			driver = SetDriver();
		}
		
		return driver;
	}
	
	private static WebDriver SetDriver() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static void KillDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
}

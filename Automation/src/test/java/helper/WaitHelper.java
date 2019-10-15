package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static driver.DriverFactory.GetDriver;

public class WaitHelper {

	private WebDriverWait wait;
	private final int MAX_WAIT_SECONDS = 5;
	
	public WaitHelper() {
		this.wait = new WebDriverWait(GetDriver(), MAX_WAIT_SECONDS);
	
	}

	public WebElement WaitUntilClickable(By by) {
		return wait.until(ExpectedConditions.elementToBeClickable(by));		
	}
	
	public WebElement WaitUntilClickable(String XPath) {
		return wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPath)));		
	}
	
	public WebElement WaitUntilClickable(WebElement element) {	
		return wait.until(ExpectedConditions.elementToBeClickable(element));		
	}
	
	public WebElement WaitUntilVisible(By by) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public WebElement WaitUntilVisible(WebElement element) {
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void Sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

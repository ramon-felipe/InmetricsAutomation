package base;

import static driver.DriverFactory.GetDriver;

import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;

import helper.FileHelper;
import helper.WaitHelper;

public class DSL {
	
	private Actions actions;
	private WebElement element;
	public WaitHelper waitHelper;
	public FakeValuesService javaFaker;
	
	public DSL() {
		this.actions = new Actions(GetDriver());
		this.waitHelper = new WaitHelper();
		this.javaFaker = new FakeValuesService(new Locale("en-US"), new RandomService());
	}
	
	public void Click(By by) {
		try {
			waitHelper.WaitUntilClickable(by).click();
			FileHelper.TakeScreenShot();
		} catch (Exception e) {
			System.out.println("Erro ao enviar comando Click\n" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void Click(String XPath) {
		try {
			waitHelper.WaitUntilClickable(XPath).click();
			FileHelper.TakeScreenShot();
		} catch (Exception e) {
			System.out.println("Erro ao enviar comando Click\n" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void ClickOnRadioButton(String radioTitle) {		
		try {
			String XPath = "//div[contains(@class, 'radio-inline')]/*[text()[contains(.,'" + radioTitle + "')]]";
			
			this.Click(XPath);
			FileHelper.TakeScreenShot();
		} catch (Exception e) {
			System.out.println("Erro ao enviar comando ClickOnRadioButton\n" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void ClickOnButton(String buttonText) {
		try {
			String buttonXpath = "(//button | //a)[normalize-space(text())=" + "\"" + buttonText + "\"" + "]";
			
			Click(buttonXpath);
			FileHelper.TakeScreenShot();
		} catch (Exception e) {
			System.out.println("Erro ao enviar comando ClickOnButton\n" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void SendKeys(String fieldName, String text) {	
		try {
			waitHelper.WaitUntilVisible(By.xpath("//label[normalize-space(text())='" + fieldName + "']/following-sibling::input")).sendKeys(text);
			FileHelper.TakeScreenShot();
		} catch (Exception e) {
			System.out.println("Erro ao enviar comando SendKeys\n" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void SendKeys(By by, String text) {
		try {
			waitHelper.WaitUntilVisible(by).sendKeys(text);
			FileHelper.TakeScreenShot();
		} catch (Exception e) {
			System.out.println("Erro ao enviar comando SendKeys\n" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void MouseOver(By by) {
		try {
			this.element = waitHelper.WaitUntilClickable(by);
			
			actions.moveToElement(element).build().perform();
			FileHelper.TakeScreenShot();
		} catch (Exception e) {
			System.out.println("Erro ao enviar comando MouseOver\n" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public String GetElementText(By by) {
		String text = "";
		
		try {
			text = waitHelper.WaitUntilVisible(by).getText(); 
		} catch (Exception e) {
			System.out.println("Erro ao enviar comando GetElementText\n" + e.getMessage());
			e.printStackTrace();
		}
		
		return text;
	}
	
	public String GetElementText(WebElement element) {
		return waitHelper.WaitUntilVisible(element).getText();
	}
	
	public void SelectComboOption(String xpath) {
		waitHelper.WaitUntilClickable(By.xpath(xpath)).click();
		FileHelper.TakeScreenShot();
	}
}

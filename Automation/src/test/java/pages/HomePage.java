package pages;

import org.openqa.selenium.By;

import base.BasePage;
import enums.TagValues;

public class HomePage extends BasePage {

	public HomePage GoTo(String url) {
		super.GoTo(url);
		
		return this;
	}
	
	public HomePage ClickOnSignUpButton() {
		dsl.Click(By.id("signup"));
		
		return new HomePage();
	}
	
	public HomePage FillSignupFields(String name, String login, String password) {		
		if (name.startsWith(TagValues.RANDOM.getTagValue())) name = getRandomValue(name);
		if (login.startsWith(TagValues.RANDOM.getTagValue())) login = getRandomValue(login);
		if (password.startsWith(TagValues.RANDOM.getTagValue())) password = getRandomValue(password);
		
		dsl.SendKeys(By.xpath("//div[@id='signupbox']//input[@name='name']"), name);
		dsl.SendKeys(By.xpath("//div[@id='signupbox']//input[@name='login']"), login);
		dsl.SendKeys(By.xpath("//div[@id='signupbox']//input[@name='password']"), password);
		
		return this;
	}
	
	public HomePage ClickOnSaveButton() {
		dsl.Click(By.xpath("//div[@id='signupbox']//a[text()='Save']"));
		
		return new HomePage();
	}
	
	public TaskPage ClickOnAddSomeTaskButton() {
		dsl.ClickOnButton("Let's add some tasks!");
		
		return new TaskPage();
	}
	
	public HomePage CreateAccount(String name, String login, String password) {
		ClickOnSignUpButton()
		.FillSignupFields(name, login, password)
		.ClickOnSaveButton()
		;
		
		return this;
	}
}

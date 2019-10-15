package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pages.HomePage;

public class HomeStepDefs {
	private HomePage homePage = new HomePage();
	
	@Given("^I access the page (.*)$")
	public void GotoCreateAccountPage(String page) {
		homePage.GoTo(page);
	}
	
	@And("^I create a new account (.*), (.*), (.*)$")
	public void CreateNewAccount(String name, String login, String password) {
		homePage.CreateAccount(name, login, password);
	}
}

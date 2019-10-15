package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import pages.SwapiFilmesPage;

public class WebserviceStepDefs {
	private SwapiFilmesPage webservice = new SwapiFilmesPage();
	
	@Given("^I perform GET operation for URI (.*)$")
	public void SubmitGetRequest(String URI) {
		webservice.getWebserviceData(URI);
	}
	
	@And("^I show the titles returned that director is (.*) and producer contains (.*)$")
	public void ShowResponseResultTitles(String director, String producer) {
		webservice.ShowResponseResultTitles(director, producer);
	}
}

package pages;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.apache.http.HttpStatus;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SwapiFilmesPage {
	private Response response;
	
	public void getWebserviceData(String URI) {		
		response = given()
						.contentType(ContentType.JSON)
				   .when()
				   		.get(URI)
				   .then()
				   		.assertThat()
						.statusCode(HttpStatus.SC_OK)
						.extract().response()
		;
	}
	
	public void ShowResponseResultTitles(String director, String producer) {
		List<String> titles = response.getBody().jsonPath().getList("results.findAll { it.director == '" + director + "' && it.producer.contains('" + producer + "')}.title");
		
		titles.forEach(t -> System.out.println(t));
	}
}

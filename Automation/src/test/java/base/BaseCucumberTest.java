package base;
import java.util.Random;

import static driver.DriverFactory.KillDriver;
import cucumber.api.java.After;

public class BaseCucumberTest {
	
	public Random rnd;
	
	public BaseCucumberTest() {
		rnd = new Random();
	}

	@After
	public static void tearDown() {
		KillDriver();
    }
}

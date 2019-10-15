package base;
import static driver.DriverFactory.KillDriver;

import java.util.Random;

import org.junit.After;

public class BaseJunitTest {
	
	public Random rnd;
	
	public BaseJunitTest() {
		rnd = new Random();
	}
	
	@After
	public void tearDown() {
		KillDriver();
    }
}

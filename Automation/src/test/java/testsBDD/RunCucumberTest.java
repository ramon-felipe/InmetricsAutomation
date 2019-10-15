package testsBDD;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/automation.feature", 
                 plugin = {"pretty"},
                 glue = {"base","steps"})
public class RunCucumberTest {
}

package Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "/BddCucumberFramework/src/test/java/Features/Login.feature",
    glue = "stepDefinitions",
    dryRun = false,
    plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"},
    monochrome = true,
    publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}








		
	




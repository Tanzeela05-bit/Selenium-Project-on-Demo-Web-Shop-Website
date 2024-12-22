package Runner;



import org.junit.runner.RunWith;

import io.cucumber.testng.CucumberOptions;

//public class ShoppingCart {

	
		// TODO Auto-generated method stub
		@CucumberOptions(
		    features = "src/test/java/Features/Search.feature", // Update the path if necessary
		    glue = "stepDefinitions",
		    dryRun = false,
		    plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"},
		    monochrome = true,
		    publish = true
		)
		    public class ShppingCart {
		}
	




}

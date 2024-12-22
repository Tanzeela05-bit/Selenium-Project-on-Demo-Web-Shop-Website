package Runner;

import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "src/test/java/Features/PaymentGateway.feature", // Path to your feature file
    glue = "StepDefinitions", // Path to your step definitions
    dryRun = false,
    plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"},
    monochrome = true,
    publish = true
)
public class PaymentGatewayRunner {
}

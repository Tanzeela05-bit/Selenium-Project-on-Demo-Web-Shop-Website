package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.PaymentPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentGatewaySteps {

    WebDriver driver;
    PaymentPage paymentPage;

    @Given("User launches Chrome browser")
    public void user_launches_chrome_browser() {
        driver = new ChromeDriver();
        paymentPage = new PaymentPage(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @When("User enters valid card details with card number {string}, expiry date {string}, CVV {string}")
    public void user_enters_valid_card_details(String cardNumber, String expiryDate, String cvv) {
        paymentPage.enterCardDetails(cardNumber, expiryDate, cvv);
    }

    @When("User enters expired card details with card number {string}, expiry date {string}, CVV {string}")
    public void user_enters_expired_card_details(String cardNumber, String expiryDate, String cvv) {
        paymentPage.enterCardDetails(cardNumber, expiryDate, cvv);
    }

    @When("User enters invalid card details with card number {string}, expiry date {string}, CVV {string}")
    public void user_enters_invalid_card_details(String cardNumber, String expiryDate, String cvv) {
        paymentPage.enterCardDetails(cardNumber, expiryDate, cvv);
    }

    @When("Clicks the \"Pay\" button")
    public void clicks_the_pay_button() {
        paymentPage.clickPayButton();
    }

    @Then("Payment should be successfully processed and confirmation message should be displayed")
    public void payment_should_be_successfully_processed() {
        String confirmationMessage = paymentPage.getConfirmationMessage();
        Assert.assertTrue(confirmationMessage.contains("Payment successful"));
    }

    @Then("Payment should fail with an error message {string}")
    public void payment_should_fail_with_an_error_message(String expectedMessage) {
        String errorMessage = paymentPage.getErrorMessage();
        Assert.assertEquals(expectedMessage, errorMessage);
    }

    @Then("Close browser")
    public void close_browser() {
        driver.quit();
    }
}

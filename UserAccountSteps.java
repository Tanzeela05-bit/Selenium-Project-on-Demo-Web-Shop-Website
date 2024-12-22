package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.AccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserAccountSteps {

    WebDriver driver;
    AccountPage accountPage;

    @Given("User launches Chrome browser")
    public void user_launches_chrome_browser() {
        driver = new ChromeDriver();
        accountPage = new AccountPage(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @When("User enters new phone number {string}")
    public void user_enters_new_phone_number(String phoneNumber) {
        accountPage.enterPhoneNumber(phoneNumber);
    }

    @When("Clicks the \"Save\" button")
    public void clicks_the_save_button() {
        accountPage.clickSaveButton();
    }

    @Then("User's phone number should be updated to {string}")
    public void user_s_phone_number_should_be_updated_to(String expectedPhoneNumber) {
        String message = accountPage.getPhoneNumberUpdatedMessage();
        Assert.assertTrue(message.contains(expectedPhoneNumber));
    }

    @When("User enters current password {string}")
    public void user_enters_current_password(String currentPassword) {
        accountPage.enterCurrentPassword(currentPassword);
    }

    @When("User enters new password {string}")
    public void user_enters_new_password(String newPassword) {
        accountPage.enterNewPassword(newPassword);
    }

    @When("User confirms the new password {string}")
    public void user_confirms_the_new_password(String confirmPassword) {
        accountPage.confirmNewPassword(confirmPassword);
    }

    @When("Clicks the \"Change Password\" button")
    public void clicks_the_change_password_button() {
        accountPage.clickChangePasswordButton();
    }

    @Then("Password should be successfully changed to {string}")
    public void password_should_be_successfully_changed_to(String expectedPassword) {
        String successMessage = accountPage.getPasswordChangeSuccessMessage();
        Assert.assertTrue(successMessage.contains("Password successfully changed"));
    }

    @Then("Password change should fail with an error message {string}")
    public void password_change_should_fail_with_an_error_message(String expectedErrorMessage) {
        String errorMessage = accountPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, errorMessage);
    }

    @Then("Close browser")
    public void close_browser() {
        driver.quit();
    }
}

package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.ShoppingCartPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ShoppingCartStep {

    WebDriver driver;
    ShoppingCartPage cartPage;

    @Given("User launches Chrome browser and navigates to the shopping cart page")
    public void user_launches_chrome_browser_and_navigates_to_the_shopping_cart_page() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        cartPage = new ShoppingCartPage(driver);
    }

    @When("User adds an item to the cart")
    public void user_adds_an_item_to_the_cart() {
        cartPage.addItemToCart();
    }

    @When("User views the shopping cart")
    public void user_views_the_shopping_cart() {
        cartPage.goToCart();
    }

    @Then("The cart summary should display the added item")
    public void the_cart_summary_should_display_the_added_item() {
        String cartSummary = cartPage.getCartSummary();
        Assert.assertTrue(cartSummary.contains("Your cart total")); // Adjust validation text as per the actual site
    }

    @When("User updates the quantity of an item in the cart to {string}")
    public void user_updates_the_quantity_of_an_item_in_the_cart_to(String quantity) {
        cartPage.updateQuantity(quantity);
    }

    @Then("The cart should be empty")
    public void the_cart_should_be_empty() {
        String emptyMessage = cartPage.getEmptyCartMessage();
        Assert.assertTrue(emptyMessage.contains("Your Shopping Cart is empty!"));
    }

    @When("User logs out from the application")
    public void user_logs_out_from_the_application() {
        cartPage.logout();
    }

    @Then("The user should be logged out successfully")
    public void the_user_should_be_logged_out_successfully() {
        Assert.assertTrue(cartPage.isLoginButtonDisplayed());
    }

    @Then("The cart should retain the added item after logging back in")
    public void the_cart_should_retain_the_added_item_after_logging_back_in() {
        cartPage.goToCart();
        String cartSummary = cartPage.getCartSummary();
        Assert.assertTrue(cartSummary.contains("Your cart total")); // Adjust validation text as per the actual site
    }

    @Then("Close the browser")
    public void close_the_browser() {
        driver.quit();
    }
}

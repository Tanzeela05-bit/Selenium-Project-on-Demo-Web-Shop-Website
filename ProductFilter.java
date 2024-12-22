package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductFilter {

    WebDriver driver;
    PageObject.ProductFilter productFilterPage;

    @Given("User launches Chrome browser")
    public void user_launches_chrome_browser() {
        driver = new ChromeDriver();
        productFilterPage = new PageObject.ProductFilter(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @When("User enters minimum price {string} and maximum price {string} in the price filter")
    public void user_enters_minimum_and_maximum_price(String minPrice, String maxPrice) {
        productFilterPage.enterMinPrice(minPrice);
        productFilterPage.enterMaxPrice(maxPrice);
    }

    @When("Clicks the \"Filter\" button")
    public void clicks_the_filter_button() {
        productFilterPage.clickFilterButton();
    }

    @Then("Products should be displayed with prices between {string} and {string}")
    public void products_should_be_displayed_with_prices_between_and(String minPrice, String maxPrice) {
        String productPriceText = productFilterPage.getProductPriceText();
        double price = Double.parseDouble(productPriceText.replace("$", "").trim());
        Assert.assertTrue("Price should be between " + minPrice + " and " + maxPrice, 
            price >= Double.parseDouble(minPrice) && price <= Double.parseDouble(maxPrice));
    }

    @Then("No products should be displayed with prices greater than {string} and less than {string}")
    public void no_products_should_be_displayed_with_prices_greater_than_and_less_than(String minPrice, String maxPrice) {
        String noResultsMessage = productFilterPage.getNoResultsMessage();
        Assert.assertTrue("No products found message should appear", noResultsMessage.contains("No products found"));
    }

    @Then("Close browser")
    public void close_browser() {
        driver.quit();
    }
}

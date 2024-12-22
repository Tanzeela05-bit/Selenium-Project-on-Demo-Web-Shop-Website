package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PageObject.SearchPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStep {
    WebDriver driver;
    SearchPage searchPage;

    @Given("User Launch Chrome browser")
    public void user_launch_chrome_browser() {
        driver = new ChromeDriver();
        searchPage = new SearchPage(driver);
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @When("User enters {string} in the search field")
    public void user_enters_in_the_search_field(String keyword) {
        searchPage.enterSearchKeyword(keyword);
    }

    @When("Clicks the search button")
    public void clicks_the_search_button() {
        searchPage.clickSearchButton();
    }

    @Then("Search results should display products related to {string}")
    public void search_results_should_display_products_related_to(String keyword) {
        Assert.assertTrue(searchPage.getSearchResultsText().contains(keyword));
    }

    @Then("Search results should display {string}")
    public void search_results_should_display(String expectedMessage) {
        Assert.assertEquals(expectedMessage, searchPage.getNoResultsMessage());
    }

    @Then("Close browser")
    public void close_browser() {
        driver.quit();
    }
}

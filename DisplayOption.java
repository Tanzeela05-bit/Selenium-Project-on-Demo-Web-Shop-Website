package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DisplayOption {

    WebDriver driver;
    DisplayOption displayOptionsPage;

    @Given("User launches Chrome browser")
    public void user_launches_chrome_browser() {
        driver = new ChromeDriver();
        displayOptionsPage = new DisplayOption();
    }

    @When("User opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    @When("User clicks the {string} button")
    public void user_clicks_the_button(String viewType) {
        if ("Grid View".equals(viewType)) {
            displayOptionsPage.clickGridView();
        } else if ("List View".equals(viewType)) {
            displayOptionsPage.clickGridView();
        }
    }

    private void clickGridView() {
		// TODO Auto-generated method stub
		
	}

	@Then("Products should be displayed in {string} view")
    public void products_should_be_displayed_in_view(String viewType) {
        if ("grid".equals(viewType)) {
            Assert.assertTrue("Products should be displayed in grid view", displayOptionsPage.isGridViewDisplayed());
        } else if ("list".equals(viewType)) {
            Assert.assertTrue("Products should be displayed in list view", displayOptionsPage.isGridViewDisplayed());
        }
    }

    private boolean isGridViewDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Then("Products should be displayed in grid view by default")
    public void products_should_be_displayed_in_grid_view_by_default() {
        Assert.assertTrue("Products should be displayed in grid view by default", displayOptionsPage.isGridViewDisplayed());
    }

    @Then("Grid view should be displayed on larger screen sizes")
    public void grid_view_should_be_displayed_on_larger_screen_sizes() {
        Assert.assertTrue("Grid view should be displayed", displayOptionsPage.isGridViewDisplayed());
    }

    @Then("List view should be displayed on smaller screen sizes")
    public void list_view_should_be_displayed_on_smaller_screen_sizes() {
        Assert.assertTrue("List view should be displayed", displayOptionsPage.isGridViewDisplayed());
    }

    @Then("Close browser")
    public void close_browser() {
        driver.quit();
    }
}

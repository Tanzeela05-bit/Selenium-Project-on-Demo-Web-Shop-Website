package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    private WebDriver driver;

    // Constructor to initialize the WebDriver and WebElements
    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators for the search page elements
    @FindBy(id = "small-searchterms")
    private WebElement searchField;

    @FindBy(css = "input[type='submit'][value='Search']")
    private WebElement searchButton;

    @FindBy(css = ".search-results")
    private WebElement searchResults;

    @FindBy(css = ".no-result")
    private WebElement noResultsMessage;

    // Methods for interacting with the elements

    /**
     * Enter a keyword in the search field
     * 
     * @param keyword The keyword to be searched
     */
    public void enterSearchKeyword(String keyword) {
        searchField.clear();
        searchField.sendKeys(keyword);
    }

    /**
     * Clicks the search button
     */
    public void clickSearchButton() {
        searchButton.click();
    }

    /**
     * Gets the text of the search results
     * 
     * @return The text of the search results
     */
    public String getSearchResultsText() {
        return searchResults.getText();
    }

	public Object getNoResultsMessage() {
		// TODO Auto-generated method stub
		return null;
	}

}


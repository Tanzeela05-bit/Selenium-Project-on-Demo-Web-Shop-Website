package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductFilter {

    private WebDriver driver;

    // Constructor to initialize WebDriver and elements
    public ProductFilter(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators for the product filter page elements
    @FindBy(id = "minPrice")
    private WebElement minPriceField;

    @FindBy(id = "maxPrice")
    private WebElement maxPriceField;

    @FindBy(css = "button[type='submit'][value='Filter']")
    private WebElement filterButton;

    @FindBy(css = ".product-price")
    private WebElement productPrice;

    @FindBy(css = ".no-results-message")
    private WebElement noResultsMessage;

    // Methods for interacting with the elements

    /**
     * Enter minimum price in the price filter
     * 
     * @param minPrice The minimum price value
     */
    public void enterMinPrice(String minPrice) {
        minPriceField.clear();
        minPriceField.sendKeys(minPrice);
    }

    /**
     * Enter maximum price in the price filter
     * 
     * @param maxPrice The maximum price value
     */
    public void enterMaxPrice(String maxPrice) {
        maxPriceField.clear();
        maxPriceField.sendKeys(maxPrice);
    }

    /**
     * Click the "Filter" button
     */
    public void clickFilterButton() {
        filterButton.click();
    }

    /**
     * Get the price of the first product after filtering
     * 
     * @return The price text of the first product
     */
    public String getProductPriceText() {
        return productPrice.getText();
    }

    /**
     * Get the message when no products are found
     * 
     * @return The message text when no products are found
     */
    public String getNoResultsMessage() {
        return noResultsMessage.getText();
    }
}

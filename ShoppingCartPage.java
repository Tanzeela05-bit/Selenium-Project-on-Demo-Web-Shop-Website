package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    private WebDriver driver;

    // Constructor to initialize the WebDriver and WebElements
    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators for the shopping cart elements
    @FindBy(css = ".product-box-add-to-cart-button")
    private WebElement addToCartButton;

    @FindBy(css = ".cart-label")
    private WebElement shoppingCartLink;

    @FindBy(css = "input.qty-input")
    private WebElement quantityInput;

    @FindBy(css = "input[name='updatecart']")
    private WebElement updateCartButton;

    @FindBy(css = ".order-summary-content")
    private WebElement cartSummary;

    @FindBy(css = ".no-data")
    private WebElement emptyCartMessage;

    @FindBy(css = ".ico-logout")
    private WebElement logoutButton;

    @FindBy(css = ".ico-login")
    private WebElement loginButton;

    // Methods for interacting with the elements

    /**
     * Clicks the "Add to Cart" button for a product
     */
    public void addItemToCart() {
        addToCartButton.click();
    }

    /**
     * Navigates to the shopping cart page
     */
    public void goToCart() {
        shoppingCartLink.click();
    }

    /**
     * Updates the quantity of an item in the cart
     * 
     * @param quantity The desired quantity
     */
    public void updateQuantity(String quantity) {
        quantityInput.clear();
        quantityInput.sendKeys(quantity);
        updateCartButton.click();
    }

    /**
     * Gets the cart summary text
     * 
     * @return The cart summary text
     */
    public String getCartSummary() {
        return cartSummary.getText();
    }

    /**
     * Gets the empty cart message
     * 
     * @return The empty cart message
     */
    public String getEmptyCartMessage() {
        return emptyCartMessage.getText();
    }

    /**
     * Logs out from the application
     */
    public void logout() {
        logoutButton.click();
    }

    /**
     * Verifies if the login button is displayed (indicates successful logout)
     * 
     * @return true if login button is displayed, false otherwise
     */
    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }
}

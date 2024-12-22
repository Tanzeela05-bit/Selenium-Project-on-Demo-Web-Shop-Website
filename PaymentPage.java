package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage {

    private WebDriver driver;

    // Constructor to initialize WebDriver and elements
    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators for the payment page elements
    @FindBy(id = "cardNumber")
    private WebElement cardNumberField;

    @FindBy(id = "expiryDate")
    private WebElement expiryDateField;

    @FindBy(id = "cvv")
    private WebElement cvvField;

    @FindBy(css = "button[type='submit'][value='Pay']")
    private WebElement payButton;

    @FindBy(css = ".confirmation-message")
    private WebElement confirmationMessage;

    @FindBy(css = ".error-message")
    private WebElement errorMessage;

    // Methods for interacting with the elements

    /**
     * Enter card details for payment
     * 
     * @param cardNumber The card number
     * @param expiryDate The expiry date of the card
     * @param cvv        The CVV of the card
     */
    public void enterCardDetails(String cardNumber, String expiryDate, String cvv) {
        cardNumberField.clear();
        cardNumberField.sendKeys(cardNumber);
        expiryDateField.clear();
        expiryDateField.sendKeys(expiryDate);
        cvvField.clear();
        cvvField.sendKeys(cvv);
    }

    /**
     * Click on the "Pay" button
     */
    public void clickPayButton() {
        payButton.click();
    }

    /**
     * Get the confirmation message after a successful payment
     * 
     * @return Confirmation message text
     */
    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }

    /**
     * Get the error message when payment fails
     * 
     * @return Error message text
     */
    public String getErrorMessage() {
        return errorMessage.getText();
    }
}

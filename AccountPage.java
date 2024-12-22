package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    private WebDriver driver;

    // Constructor to initialize WebDriver and elements
    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators for the account page elements
    @FindBy(id = "phoneNumber")
    private WebElement phoneNumberField;

    @FindBy(css = "button[type='submit'][value='Save']")
    private WebElement saveButton;

    @FindBy(id = "currentPassword")
    private WebElement currentPasswordField;

    @FindBy(id = "newPassword")
    private WebElement newPasswordField;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPasswordField;

    @FindBy(css = "button[type='submit'][value='Change Password']")
    private WebElement changePasswordButton;

    @FindBy(css = ".phone-number-updated")
    private WebElement phoneNumberUpdatedMessage;

    @FindBy(css = ".password-change-success")
    private WebElement passwordChangeSuccessMessage;

    @FindBy(css = ".error-message")
    private WebElement errorMessage;

    // Methods for interacting with the elements

    /**
     * Enter new phone number in the profile
     * 
     * @param phoneNumber The new phone number
     */
    public void enterPhoneNumber(String phoneNumber) {
        phoneNumberField.clear();
        phoneNumberField.sendKeys(phoneNumber);
    }

    /**
     * Click the "Save" button
     */
    public void clickSaveButton() {
        saveButton.click();
    }

    /**
     * Enter current password in the password change form
     * 
     * @param currentPassword The current password
     */
    public void enterCurrentPassword(String currentPassword) {
        currentPasswordField.clear();
        currentPasswordField.sendKeys(currentPassword);
    }

    /**
     * Enter new password in the password change form
     * 
     * @param newPassword The new password
     */
    public void enterNewPassword(String newPassword) {
        newPasswordField.clear();
        newPasswordField.sendKeys(newPassword);
    }

    /**
     * Confirm new password in the password change form
     * 
     * @param confirmPassword The confirmed new password
     */
    public void confirmNewPassword(String confirmPassword) {
        confirmPasswordField.clear();
        confirmPasswordField.sendKeys(confirmPassword);
    }

    /**
     * Click the "Change Password" button
     */
    public void clickChangePasswordButton() {
        changePasswordButton.click();
    }

    /**
     * Get the success message after phone number update
     * 
     * @return The success message text
     */
    public String getPhoneNumberUpdatedMessage() {
        return phoneNumberUpdatedMessage.getText();
    }

    /**
     * Get the success message after password change
     * 
     * @return The success message text
     */
    public String getPasswordChangeSuccessMessage() {
        return passwordChangeSuccessMessage.getText();
    }

    /**
     * Get the error message after failed password change
     * 
     * @return The error message text
     */
    public String getErrorMessage() {
        return errorMessage.getText();
    }
}

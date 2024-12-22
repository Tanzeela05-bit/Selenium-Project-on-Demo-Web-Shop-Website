package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DisplayOptions {

    private WebDriver driver;

    // Constructor to initialize WebDriver and elements
    public DisplayOptions(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators for the display options elements
    @FindBy(id = "gridView")
    private WebElement gridViewButton;

    @FindBy(id = "listView")
    private WebElement listViewButton;

    @FindBy(css = ".product-item")
    private WebElement productItem;

    @FindBy(css = ".grid-view")
    private WebElement gridViewContainer;

    @FindBy(css = ".list-view")
    private WebElement listViewContainer;

    // Methods for interacting with the elements

    /**
     * Click the grid view button to switch to grid view
     */
    public void clickGridView() {
        gridViewButton.click();
    }

    /**
     * Click the list view button to switch to list view
     */
    public void clickListView() {
        listViewButton.click();
    }

    /**
     * Verify if the products are displayed in grid view
     * 
     * @return true if products are in grid view
     */
    public boolean isGridViewDisplayed() {
        return gridViewContainer.isDisplayed();
    }

    /**
     * Verify if the products are displayed in list view
     * 
     * @return true if products are in list view
     */
    public boolean isListViewDisplayed() {
        return listViewContainer.isDisplayed();
    }

    /**
     * Get the current display mode of the product items (grid or list)
     * 
     * @return "grid" if grid view is active, "list" if list view is active
     */
    public String getCurrentDisplayMode() {
        if (gridViewContainer.isDisplayed()) {
            return "grid";
        } else if (listViewContainer.isDisplayed()) {
            return "list";
        } else {
            return "unknown";
        }
    }
}

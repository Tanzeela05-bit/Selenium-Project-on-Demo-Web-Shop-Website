Feature: Shopping Cart Functionality

  Scenario: Verify adding an item to the cart
    Given User launches Chrome browser and navigates to the shopping cart page
    When User adds an item to the cart
    And User views the shopping cart
    Then The cart summary should display the added item
    And Close the browser

  Scenario: Verify updating the quantity of a cart item to 0
    Given User launches Chrome browser and navigates to the shopping cart page
    When User adds an item to the cart
    And User views the shopping cart
    And User updates the quantity of an item in the cart to "0"
    Then The cart should be empty
    And Close the browser

  Scenario: Verify the cart retains items after logging out and logging back in
    Given User launches Chrome browser and navigates to the shopping cart page
    When User adds an item to the cart
    And User views the shopping cart
    Then The cart summary should display the added item
    When User logs out from the application
    Then The user should be logged out successfully
    And User logs back into the application (this step should include login functionality)
    Then The cart should retain the added item after logging back in
    And Close the browser

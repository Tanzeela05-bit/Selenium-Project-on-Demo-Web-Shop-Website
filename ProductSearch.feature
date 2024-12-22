Feature: Product Search Functionality

Scenario: Search results for a valid product keyword
  Given User launches Chrome browser
  When User opens URL "https://demowebshop.tricentis.com/"
  And User enters "laptop" in the search field
  And Clicks the search button
  Then Search results should display products related to "laptop"

Scenario: Validate search functionality with a single character
  Given User launches Chrome browser
  When User opens URL "https://demowebshop.tricentis.com/"
  And User enters "a" in the search field
  And Clicks the search button
  Then Search results should display "No products were found that matched your criteria."

Scenario: Verify search functionality for an invalid keyword
  Given User launches Chrome browser
  When User opens URL "https://demowebshop.tricentis.com/"
  And User enters "invalidproduct123" in the search field
  And Clicks the search button
  Then Search results should display "No products were found that matched your criteria."

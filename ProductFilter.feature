Feature: Product Filter Functionality

Scenario: Verify products are filtered based on a valid price range
  Given User launches Chrome browser
  When User opens URL "https://demowebshop.tricentis.com/"
  And User enters minimum price "100" and maximum price "500" in the price filter
  And Clicks the "Filter" button
  Then Products should be displayed with prices between 100 and 500

Scenario: Verify products are filtered when the minimum price exceeds the maximum price
  Given User launches Chrome browser
  When User opens URL "https://demowebshop.tricentis.com/"
  And User enters minimum price "500" and maximum price "100" in the price filter
  And Clicks the "Filter" button
  Then No products should be displayed with prices greater than 100 and less than 500

Feature: Product Display Options

Scenario: Verify switching between grid view and list view
  Given User launches Chrome browser
  When User opens URL "https://demowebshop.tricentis.com/"
  And User clicks the "Grid View" button
  Then Products should be displayed in grid view
  When User clicks the "List View" button
  Then Products should be displayed in list view

Scenario: Verify default display mode when the user accesses the product listing page
  Given User launches Chrome browser
  When User opens URL "https://demowebshop.tricentis.com/"
  Then Products should be displayed in grid view by default

Scenario: Verify responsiveness of grid and list views across different screen sizes
  Given User launches Chrome browser
  When User opens URL "https://demowebshop.tricentis.com/"
  Then Grid view should be displayed on larger screen sizes
  When User resizes the browser window to a smaller size
  Then List view should be displayed on smaller screen sizes

Feature: Payment Gateway Functionality

Scenario: Verify successful payment with valid card details
  Given User launches Chrome browser
  When User opens URL "https://paymentgateway.example.com/"
  And User enters valid card details with card number "4111111111111111", expiry date "12/25", CVV "123"
  And Clicks the "Pay" button
  Then Payment should be successfully processed and confirmation message should be displayed

Scenario: Verify payment with an expired card
  Given User launches Chrome browser
  When User opens URL "https://paymentgateway.example.com/"
  And User enters expired card details with card number "4111111111111111", expiry date "12/20", CVV "123"
  And Clicks the "Pay" button
  Then Payment should fail with an error message "Card expired"

Scenario: Verify payment fails for invalid card details
  Given User launches Chrome browser
  When User opens URL "https://paymentgateway.example.com/"
  And User enters invalid card details with card number "1234567890123456", expiry date "12/25", CVV "000"
  And Clicks the "Pay" button
  Then Payment should fail with an error message "Invalid card details"

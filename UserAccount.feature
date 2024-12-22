Feature: User Account Management

Scenario: Verify updating the user’s phone number in their account profile
  Given User launches Chrome browser
  When User opens URL "https://example.com/user/account"
  And User enters new phone number "1234567890"
  And Clicks the "Save" button
  Then User's phone number should be updated to "1234567890"

Scenario: Verify changing the user’s password with valid current and new password
  Given User launches Chrome browser
  When User opens URL "https://example.com/user/account"
  And User enters current password "currentPassword123"
  And User enters new password "newPassword123"
  And User confirms the new password "newPassword123"
  And Clicks the "Change Password" button
  Then Password should be successfully changed to "newPassword123"

Scenario: Verify password change with incorrect current password
  Given User launches Chrome browser
  When User opens URL "https://example.com/user/account"
  And User enters current password "incorrectPassword"
  And User enters new password "newPassword123"
  And User confirms the new password "newPassword123"
  And Clicks the "Change Password" button
  Then Password change should fail with an error message "Incorrect current password"

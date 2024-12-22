
Feature: Register
  
  Scenario: Sucessful Register with Valid Credentials
    Given User Lanch Chrome browser
    When User open URL "https://demowebshop.tricentis.com/register"
    And User enters First name as "Tanzeela" and Last name as "Shaik" and Email as "shaiktanzeelas@gmail.com" and password "123456789" and Confirm password as "123456789" 
    And Click on Register button
    Then Page title Should be "Demo Web Shop"
    When User click on Log out link
    Then Page title after logout should be "demowebshop.tricentis.com/"
    And Close browser

  
      
      
      



Feature: Make a sing In on the site of supreme golf

 
  Scenario: Make a Sign In 
    Given Open the app Supreme Golf
    When Select the option MySG
    And Select the option SignIn
    Then Enter the data username and password
     |username                  |password |
     |eguerrero@codigodelsur.com|123456789|
     |test@mailinator.com       |123456   |
    And Click on button SignIn

Feature: Sign In in Supreme Golf site

  Scenario: Single Sign In registration
  Given I have valid set of data and access to Sign In
    When Sign In on page is selected
    And I enter valid data username and password
     |eguerrero@codigodelsur.com |123456789|
    Then Click on Sign In button
    And Sign In successful: should be displayed
    Then I enter valid data courses on the search field
    |Supreme Golf Demo Course|
    And User click on Search button
    Then Show the tee time

                                
     
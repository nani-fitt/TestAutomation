
Feature: Make a Booking on the site of supreme golf

 
  Scenario: Make a Booking
    Given Open the app Supreme Golf and made signIn
    |username                  |password |
    |eguerrero@codigodelsur.com|123456789|
    When Search a course for made the reservation
    And Select the tee time for made the booking
    Then Select the players and made click on checkbox button 
    And Click on button Booking

Feature: Search on the Barter tee times

  Background: 
    Given I have a valid the search

  #DataTable for UserDetails
  @Registration
  Scenario: Made a search successfull on Barter tee times
    When Enter on the functionality Barter tee times
    And Enter valid course and dateini and enddate
      | course                                        |dateini   |enddate   |
      |Supreme Golf Demo Course                       |2019-08-26|2019-09-05|
      |Supreme Golf - Supreme ForeUp Trade Test Course|2019-08-20|2019-08-30|
    Then Click on the Create Search
    And Show the result of the search
  
   
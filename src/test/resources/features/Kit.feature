Feature: Kit
  In order to navigate the Kit or not App
  As a user
  I want to click buttons and arrive at the correct screens

  Background:
    Given I am on the login screen

  @Navigation
  Scenario: Verify that User Home Activity has all elements
    Given test info id "1" and name "User_Home_Elements"
    Given I log in with user "Callie" and password "333"
    Then I am on the user home screen

  @Navigation
  Scenario: Verify that Rating Activity has all elements
    Given test info id "2" and name "Rating_Activity_Elements"
    Given I log in with user "Callie" and password "333"
    Then I am on the rating activity screen

  @Navigation
  Scenario: Verify that Rating Activity has all elements
    Given test info id "3" and name "TopCats_Activity_Elements"
    Given I log in with user "Callie" and password "333"
    Then I am on the top cats activity screen

  @Navigation
  Scenario: Verify the ability to add and delete images
    Given test info id "4" and name "Rating_Activity_Elements"
    Given I log in with user "ccc" and password "333"
    Then I can add and remove an image
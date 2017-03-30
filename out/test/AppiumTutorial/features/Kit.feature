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
    When I tap the rating activitiy button
    Then I am on the rating activity screen

  @Navigation
  Scenario: Verify that Top Cats Activity has all elements
    Given test info id "3" and name "TopCats_Activity_Elements"
    Given I log in with user "Callie" and password "333"
    When I tap the top cats activitiy button
    Then I am on the top cats activity screen

  @Navigation
  Scenario: Verify the ability to add and delete images
    Given test info id "4" and name "Rating_Activity_Elements"
    Given I log in with user "ccc" and password "333"
    When I tap the add cat image button
    Then I can add an image
    And I can remove an image

  @Navigation
  Scenario: Verify that Top Cats Details Activity has all elements
    Given test info id "4" and name "TopCatsDetails_Activity_Elements"
    Given I log in with user "Callie" and password "333"
    When I tap the top cats activitiy button
    And I tap a cat in the top cats list
    Then I am on the top cats details activity screen

  @Navigation
  Scenario: Verify that User Cat Details Activity has all elements
    Given test info id "5" and name "UserCatDetails_Activity_Elements"
    Given I log in with user "Callie" and password "333"
    When I tap a user cat image in the list
    Then I am on the user cat details activity screen


  @Navigation
  Scenario Outline: Verify the ability to login with non-alphabetic symbols
    Given test info id "<id>" and name "<name>"
    Given I log in with user "<username>" and password "<password>"
    Then I am on the user home screen

    Examples:
    | id | name          | username | password|
    |6   | Login_Numbers | 123      | 123     |
    |7   | Login_Symbols | *%#      | 123     |

  @Navigation
  Scenario Outline: Verify invalid credentials cannot login
    Given test info id "<id>" and name "<name>"
    Given I log in with user "<username>" and password "<password>"
    Then login fails

    Examples:
      | id | name               | username       | password|
      |8   | Login_InvalidCreds | asdfkj;lkjsadf | 123     |
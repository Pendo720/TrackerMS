
Feature: Login functionality

  Scenario: Check login is successful with valid credentials
    Given : Start login feature testing
    And : login page is visible
    When : user enters username and password
    And : clicks on the login button
    Then : navigate user to the landing page
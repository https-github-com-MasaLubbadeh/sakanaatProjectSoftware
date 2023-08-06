
Feature: view furniture

  Scenario: user wants to view furniture success
    Given the user type is "tenant"
    Then user can view furniture

  Scenario: user wants to view furniture fail
    Given the user type is not "tenant"
    Then user can't view furniture
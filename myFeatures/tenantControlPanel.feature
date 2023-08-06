#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: the tenant wants to view control panel 

  @tag1
  Scenario: user view control panel successfuly
    Given user with id 3 type is "tenant"
    Then owener control panel printed successfuly

@tag1
  Scenario: user can't view control panel 
    Given user has id 1 type is "owner"
    Then owener control panel not printed 

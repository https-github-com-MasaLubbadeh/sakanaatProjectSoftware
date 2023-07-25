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
Feature: showing control panel for the owner

  @tag1
  Scenario: owner with id 1 wants to see his housings
    Given the owner with id 1 has housings
    When the owner with id 1 enters one of his housing id 1
    Then number of floors and tenants in this housing will be given
    When the owner with id 1 enters floor number 1
    Then the apartments in this floor will be given 
    When the owner with id 1 enters apartment id 1
    Then  name of the tenant ,communication way,number of bathrooms,number of bedrooms,of this apartment will be given,and if it has a balcony 
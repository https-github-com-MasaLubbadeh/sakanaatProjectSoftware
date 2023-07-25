
Feature: The tenant wants to view the available housing

  Scenario: The tenant wants to view the available houses
    Given that the tenant is logged in now 1
    Then the tenant can view the available houses

  Scenario: The tenant fails to view the available houses
    Given that the tenant is not logged in now 0
    Then the tenant cannot view the available houses

   Scenario: The tenant wants to view information about the apartment
       Given that the tenant selected the apartment with id 1
       And their exist an apartment with this id
       Then the tenant can view information about the apartment
   
Feature: update information
  Scenario: user update information successfully
    Given selected house already exists where its id is 1
    When user id is 1
    And the user type is either an "Admin" or an "Owner"
    Then house is updated successfully
    
     Scenario: user update information failed
    Given selected house does not exist where its id is 1111
    Then house is not updated because of its id
    
    Scenario: user update information failed
    Given selected house already exists
    When id is 1
    And the user id is 2    
    And the user is neither an "Admin" nor an "Owner"
    Then house is not updated because of the user type
    
  
    


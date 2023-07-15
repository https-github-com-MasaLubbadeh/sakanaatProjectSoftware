Feature: logout Feature

  Scenario: logout succesfully as user
    Given user already logged in succefully
    Then  logut success
    
    Scenario: logout failed as user
    Given no user logged in 
    Then  logut failed
    



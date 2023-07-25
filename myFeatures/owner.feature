Feature:adding new housing

  Scenario:added successfully
    Given the owner wants to add new housing
    Then housing with id is greater than 0
    
  Scenario:updated successfully
    Given the owner wants to update existing housing
    Then housing with location is updated

  Scenario:housing already exists
    Given the owner requests to add new housing with id "1"
    When id "1" exists
    Then failed to add housing "1"
  

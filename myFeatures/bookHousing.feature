Feature:book acccomodation

  Scenario:tenant booked family housing succesfully
    Given the tenant with id 2 wants to book a family apartment in housing id 1, floor 1, apartment id 2 ,capacity 7
    When it's family housing
    And housing id 1, floor 1 ,apartment id 2 is available
    Then housing id 1, floor 1 ,apartment id 2 booked succesfully by tenant with id 2 
   
   Scenario:tenant booked student housing succesfully
    Given the tenant with id 2 wants to book a student apartment in housing id 2, floor 1, apartment id 2, capacity 3
    When it's student housing
    And there's a room in housing id 2, floor 1,apartment id 2
    Then housing id 2, floor 1, apartment id 2 is booked succesfully by tenant with id 2 
 
    
    Scenario:tenant failed to book family housing because it's already booked
    Given the tenant with id 2 wants to book an apartment in housing id 1, floor 1,apartment id 1, capacity 7
    When the housing is family housing
    And housing id 1, floor 1, apartment id 1 is not available
    Then failed to book housing id 1, floor 1, apartment id 1 
   
   Scenario:tenant failed to book student housing because it's full
    Given the tenant with id 2 requests to book an apartment in housing id 2, floor 1,apartment id 1, capacity 3
    When the housing is student housing
    And there is no spacing a room in housing id 2, floor 1 ,apartment id 1
    Then can't book housing id 2, floor 1, apartment id 1
     
 
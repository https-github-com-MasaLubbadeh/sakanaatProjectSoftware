
Feature:  login feature

  Scenario: login successfully as user
    Given that user is not logged in
    When username is "Masa" 
    And password is correct "IamAdmin"
    Then  logged in successfully
    
   Scenario: login failed as user
    Given that user is not logged in
    When username is "raghad" not found
    Then  log in faild    
       
    Scenario: login faild as user
    Given that user is not logged in
    When username is "Masa" 
    And password is false "wrong"
    Then  log in faild


	
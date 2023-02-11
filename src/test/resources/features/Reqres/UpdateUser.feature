Feature: PUT Update User

  @Tugas @Negative
  Scenario: PUT updata user wiht empty request body
    Given Put update user with empty request body
    When Send request put update user
    Then Status code should be 400
    
  @Tugas @Negative
    Scenario Outline: PUT update user with invalid paramter
    Given Update user valid json with invalid parameter id <id>
    When Send request put update user
    Then Status code should be 400
    Examples:
      | id    |
      | 300   |
      |       |
      | 40299 |
    

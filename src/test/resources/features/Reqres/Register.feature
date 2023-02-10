Feature: Register User

  @Tugas @Positive-Case
  Scenario: Register user with valid data
    Given Register user with valid json input
    When Send request register user
    Then Status code should be 200
    And Validate json schema success register user

  @Tugas @Negative-Case
  Scenario: Register user with invalid data
    Given Register user with valid username and blank password
    When Send request register user
    Then Status code should be 400
    And Validate json schema failed register user
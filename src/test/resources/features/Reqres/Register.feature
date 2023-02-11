Feature: POST Register User

  @Tugas @Positive
  Scenario: Register user with valid data
    Given Register user with valid json input
    When Send request register user
    Then Status code should be 200
    And Validate json schema success register user

  @Tugas @Negative
  Scenario: Register user with empty password
    Given Register user with valid email and empty password
    When Send request register user
    Then Status code should be 400
    And Validate json schema failed register user

  @Tugas @Negative
    Scenario: Register user with empty email
    Given Register user with empty email and valid password
    When Send request register user
    Then Status code should be 400
    And Validate json schema failed register user
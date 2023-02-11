Feature:POST Login User

  @Tugas @Positive
  Scenario: User login with valid data
    Given User login with valid email and password
    When Send request login user
    Then Status code should be 200
    And Validate json schema success login user

  @Tugas @Negative
  Scenario: User login with empty password
    Given User login with valid email and empty password
    When Send request login user
    Then Status code should be 400
    And  Response body name should be "Missing password"
    And Validate json schema failed login user

    @Tugas @Negative
    Scenario: User login with invalid email
      Given User login with empty email and valid password
      When Send request login user
      Then Status code should be 400
      And Response body name should be "Missing email or username"
      And Validate json schema failed login user
Feature: Login User

  @Tugas
  Scenario: User login with valid data
    Given User login with valid username and password
    When Send request login user
    Then Status code should be 200
    And Validate json schema success login user

  @Tugas
  Scenario: User login with empty password
    Given User login with valid username and blank password
    When Send request login user
    Then Status code should be 400
    And  Response body name should be "Missing password"
    And Validate json schema failed login user

    @Tugas
    Scenario: User login With invalid username
      Given User login with blank username and valid password
      When Send request login user
      Then Status code should be 400
      And Response body name should be "Missing email or username"
      And Validate json schema invalid blank username login user
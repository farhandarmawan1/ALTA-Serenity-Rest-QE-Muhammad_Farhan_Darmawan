Feature: Delete User

  @Tugas @Negative
  Scenario Outline: Delete User with parameter invalid
    Given Delete user with invalid parameter id <id>
    When Send request delete user
    Then Status code should be 404
    Examples:
      | id    |
      | 32323 |
      | 54535 |

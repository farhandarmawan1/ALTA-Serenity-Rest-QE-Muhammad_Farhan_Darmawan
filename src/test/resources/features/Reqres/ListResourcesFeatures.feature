Feature: Get List Resources

  @Tugas @Positive
  Scenario: Get list resources respones
    Given Get list resources with valid parameter
    When Send request get list resources
    Then Status code should be 200 OK
    And Validate list resources json schema

  @Tugas @Negative
  Scenario Outline: Get list resources with invalid parameter
    Given Get list resources with invalid parameter "<input>"
    When Send request get list resources
    Then  Status code should be 404
    Examples:
      | input |
      | ke2ko |
      | 2dsds |

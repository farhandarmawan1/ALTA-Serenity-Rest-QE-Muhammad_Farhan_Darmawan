Feature: GET Single Resources

  @Tugas @Positive
  Scenario: Get Single List Resources Responses
    Given Get single resources with valid parameter
    When Send request get single resources
    Then Status code should be 200 OK
    And Validate single resources json schema

  @Tugas @Negative
  Scenario Outline: Get Single List Resources Responses
    Given Get single resources with invalid parameter id <id>
    When Send request get single resources
    Then Status code should be 404
    Examples:
      | id  |
      | 23  |
      | 203 |
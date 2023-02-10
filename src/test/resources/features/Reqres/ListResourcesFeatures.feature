Feature: List Resources
@Tugas
  Scenario: Get List Resources respones
    Given Get list resources with valid parameter "unknown"
    When Send request get list resources
    Then Status code should be 200 OK
    And Validate list resources json schema

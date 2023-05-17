Feature: GET Method
  @Tugas @Positive-Case
  Scenario Outline: Get single user with valid parameter id should success then return 200 response code
    Given Get single user with id <id>
    When Send request get single user
    Then Should return status code 200 OK
    And Response body id should be <id>
    Examples:
      | id |
      | 1  |
      | 2  |
  @Tugas @Negative-Case
  Scenario Outline: Get single user with invalid parameter id should failed then return 404 response code
    Given Get single user with id <id>
    When Send request get single user
    Then Should return status code 404 Not Found
    Examples:
      | id  |
      | 789 |
      | 999 |
  @Tugas @Negative-Case
  Scenario Outline: Get single user with modified parameter should failed then return 404 response code
    Given Get single user with first name "<firstName>"
    When Send requests get single user
    Then Should return status code 404 Not Found
    Examples:
      | firstName |
      | Alphonso  |

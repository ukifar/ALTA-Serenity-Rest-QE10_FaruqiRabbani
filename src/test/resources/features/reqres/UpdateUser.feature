Feature: PUT Method
  @Tugas @Positive-Case
  Scenario Outline: Put update user with valid json and id should success then return 200 response code
    Given Put update user with valid json and id <id>
    When Send put update user
    Then Status code should be 200 OK
    Examples:
      | id |
      | 1  |
      | 2  |
  @Tugas @Negative-Case
  Scenario Outline: Put update user with invalid json should failed then return 400 response code
    Given Put update user with valid id <id> and invalid json
    When Send put update user
    Then Status code should be 400 Bad Request
    Examples:
      | id |
      | 1  |
      | 2  |
  @Tugas @Negative-Case
  Scenario: Put update user with empty json body should failed then return 400 response code
    Given Put update user with empty name and job with id 2
    When Send put update user
    Then Status code should be 400 Bad Request
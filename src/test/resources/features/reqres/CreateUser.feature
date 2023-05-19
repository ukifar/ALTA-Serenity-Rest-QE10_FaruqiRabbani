Feature: POST Create User
  @Tugas @Positive-Case
  Scenario: Post create new user with valid json should success then return 201 response code
    Given Post create user with valid json
    When Send post create user
    Then Status code should be 201 Created
    And Response body name was "Faruqi Rabbani" and job was "QA Engineer"
    And Validate post create user JSON Schema

  @Tugas @Negative-Case
  Scenario: Post create new user with blank name and blank password should failed then return 400 response code
    Given Post create user with blank name and blank password json
    When Send post create user
    Then Status code should be 400 Bad Request
    And Response body name was "" and job was ""
    And Validate post create user JSON Schema with blank name and blank password

  @Tugas @Negative-Case
  Scenario Outline: Post create new user with extra category should failed then return 400 response code
    Given Post create user with category name, job, and age
    When Send post create user
    Then Should return status code 400
    And Response body name should be "<name>", job "<job>" and age "<age>"
    And Validate json schema create user
    Examples:
      | name  | job         | age |
      | Kimmy | Entertainer | 1   |
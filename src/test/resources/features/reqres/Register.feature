Feature: Register User
  @Tugas @Positive-Case
  Scenario: User register with valid email and password should success then return 200 response code
    Given User register with valid email and password
    When Send request register user
    Then Status code should be 200 OK
    And Validate json schema success register user

  @Tugas @Negative-Case
  Scenario: User register with valid email and blank password should failed then return 400 response code
    Given User register with valid email and blank password
    When Send request register user
    Then Status code should be 400 Bad Request
    And Validate json schema failed register user with valid email and blank password
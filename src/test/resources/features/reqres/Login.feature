Feature: Login
  @Tugas @Positive-Case
  Scenario: User login with registered email and password should success then return 200 response code
    Given User login with valid username and password
    When Send request login user
    Then Should return status code 200
    And Validate json schema success login user
  @Tugas @Negatve-Case
  Scenario: User login with registered username and blank password should failed then return 400 response code
    Given User login with valid username and blank password
    When Send request login user
    Then Should return status code 400
    And Validate json schema failed login user
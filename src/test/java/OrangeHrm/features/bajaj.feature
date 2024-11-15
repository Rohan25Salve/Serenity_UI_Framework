@bajaj @regression

  Feature: To test Login Functionality

    @bajaj_01
    Scenario: Verify Login with respect to different Employees API
      Given User Login with "Username" and "password"
      When Check response
      Then Validate Response
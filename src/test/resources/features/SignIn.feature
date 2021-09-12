Feature: SignIn feature
  Description: SignIn feature

  @validLogin
  Scenario: Login with VALID credentials
    Given User has a valid login credentials
    When User enters credentials
    Then User is successfully logged in

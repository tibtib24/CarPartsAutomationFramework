Feature: SignIn feature
  Description: SignIn feature
  
  Background:
      Given User is in sign in page
  

  @ValidSignIn @SignIn @RegressionTest 
  Scenario Outline: Verify sign in with VALID credentials
    And User sign in using credentials "<Email>" and "<Password>"
    And User goes to My Account
    And User goes to sign in details
    When User verify email address
    Then User is successfully signed in

    Examples: 
      | Email              | Password  |
      | sbardies@gmail.com | Test1234$ |
    
   
  @InvalidSignIn @SignIn @RegressionTest
  Scenario Outline: Verify sign in without captcha verification
    When User sign in using credentials "<Email>" and "<Password>"
    Then User gets verification failed message

    Examples: 
      | Email                    | Password    |
      | validEmailPass@email.com | invalidPass |

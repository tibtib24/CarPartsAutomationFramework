Feature: Add to cart Feature
  Description: Add to cart

  Background: 
    Given that user is in carparts home page

  @AddToCart @RegressionTest 
  Scenario: Add one item to cart
    And user search for an item
    When clicks add to cart
    Then an item is added to cart

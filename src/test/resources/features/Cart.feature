Feature: Add to cart Feature
  Description: Add to cart

	@RegressionTest @AddToCart
  Scenario: Add one item to cart
    #Preconditions
    Given that user is in carparts home page
    #Actions
    When user search for an item
    #Additional Actions
    And clicks add to cart
    #Assertions
    Then an item is added to cart

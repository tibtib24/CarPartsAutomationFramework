Feature: Setup Search Criteria Feature
Description: Change Location 

	@RegressionTest @SetupShippigZipCode
  Scenario: Setup shipping to
    Given that user is in carparts home page
    When user clicks shipping to button
    And user selects zip code
    Then zip code location is displayed

  @RegressionTest @SelectVehicle
  Scenario: Select vehicle
  	Given user has not yet selected any vehicle
  	When user selects vehicle
  	Then vehicle is displayed in search bar
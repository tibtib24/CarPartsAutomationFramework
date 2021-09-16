Feature: Setup Search Criteria Feature
  Description: These are scenarios that relates to the search functionality

  Background: 
    Given that user is in carparts home page

  @SetupShippigZipCode @SearchFilter @RegressionTest
  Scenario: Setup shipping to
    And user clicks shipping to button
    When user selects zip code "85001"
    Then zip code location is displayed

  @SelectVehicle @SearchFilter @RegressionTest
  Scenario: Select vehicle
    Given user has not yet selected any vehicle
    When user selects initial vehicle
    Then vehicle is displayed in search bar

  #add cars from json file
  @AddVehicle @SearchFilter @RegressionTest
  Scenario Outline: Add vehicle in search filter
    Given user selects initial vehicle
    When user add cars in vehicle filter "<Year>" and "<Make>" and "<Model>" and "<SubModel>" and "<Engine>"
    Then vehicle is selected as filter
    And vehicle is added in vehicle filter

    Examples: 
      | Year | Make  | Model | SubModel | Engine |
      | 2007 | Honda | Civic | Si       |        |

 #add cars using datatable
  @AddMultipleVehicle @SearchFilter @RegressionTest
  Scenario: Add multiple vehicle in search filter
    Given user selects initial vehicle
    When user add multiple car in vehicle filter
      | Year | Make  | Model      | SubModel | Engine     |
      | 2007 | Honda | Civic      | Si       |            |
      | 2021 | Audi  | A4 allroad | Komfort  |            |
      | 2021 | Buick | Encore GX  | Essence  | 3 Cyl 1.2L |
    Then vehicles are added in vehicle filter

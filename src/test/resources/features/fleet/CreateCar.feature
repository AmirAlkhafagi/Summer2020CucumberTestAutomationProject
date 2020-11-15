Feature: As user, I want to be able to create new cars

  @add_car_s_o
  Scenario Outline: 1. Add some car with <role> role, <license plate> plate, <model year> year
    Given user is on the landing page
    And user logs in as "<role>"
    And user navigates to "Fleet" and "Vehicles"
    And user click on create car button
    When user adds new vehicle information
      | License Plate | <license plate> |
      | Model Year    | <model year>    |
    And user clicks on save and close button

    Examples: auto test data
      | license plate | model year | role          |
      | FLORIDA       | 2020       | store manager |
      | QA            | 2021       | store manager |
      | RAMAZAN       | 2030       | store manager |
      | SDET          | 1999       | store manager |
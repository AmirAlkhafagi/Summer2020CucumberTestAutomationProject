@login
Feature: As user, I want to be able to login using different account types

  #will be executed before every scenario in the particular feature file
  # same as @Before
  Background: common steps for all of our scenarios
    Given user is on the landing page

  @positive_login @smoke_test
  Scenario: Login as a sales manager
    When user logs in as sales manager
    Then user should be able to see dashboard page

  @parametrized_test @smoke_test
  Scenario: Parametrized login
    When user logs in as "sales manager"
    Then user should be able to see dashboard page
#"driver" - is a parameter

  @s_o
  Scenario Outline: Parametrized login as <role>
    When user logs in as "<role>"
    Then user should be able to see dashboard page
    Examples:
      | role          |
      | driver        |
      | sales manager |
      | store manager |

  @s_o @with_two_columns
  Scenario Outline: Parametrized login as <role>
    When user logs in as "<role>"
    Then user should be able to see "<page title>" page
    Examples:
      | role          | page title      |
      | driver        | Quick Launchpad |
      | sales manager | Dashboard       |
      | store manager | Dashboard       |


  @negative_login
  Scenario: Invalid Password
    When user logs in with "storemanager85" username and "wrong" password
    Then user verifies that "Invalid user name or password." message is displayed

  @negative_scenario_outline
  Scenario Outline: Invalid login
    When user logs in with "<username>" username and "<password>" password
    Then user verifies that "<message>" message is displayed
    Examples: data set
      | username  | password | message                        |
      | wrong     | bad      | Invalid user name or password. |
      | abc       | bad      | Invalid user name or password. |
      | amir      | bad      | Invalid user name or password. |
      | incorrect | bad      | Invalid user name or password. |
      | last      | bad      | Invalid user name or password. |





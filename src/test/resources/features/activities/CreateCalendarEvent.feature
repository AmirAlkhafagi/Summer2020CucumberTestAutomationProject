Feature: As user, I want to be able to create calendar events

  @add_calendarEvent
  Scenario: Create calendar event with default time
    Given user is on the landing page
    And user logs in as "store manager"
    And user navigates to "Activities" and "Calendar Events"
    And user clicks on create calendar event button
    When user adds new calendar event information
      | Title          | B20 Graduation Party                        |
      | Description    | All B20 friends are invited for this party! |
    And user clicks on save and close button
    Then user verifies that new calendar event is displayed:
      | Title          | B20 Graduation Party                        |
      | Description    | All B20 friends are invited for this party! |
package com.vytrack.step_definitions;

import com.vytrack.pages.BasePage;
import com.vytrack.pages.CreateCalendarEventPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jsoup.Connection;
import org.junit.Assert;

import java.util.Map;

public class CreateCalendarEventStepDefinitions {
    CreateCalendarEventPage createCalendarEventPage = new CreateCalendarEventPage();


    @Given("user clicks on create calendar event button")
    public void user_clicks_on_create_calendar_event_button() {
        createCalendarEventPage.clickOnCreateCalendarEventBtn();
    }

    @When("user adds new calendar event information")
    public void user_adds_new_calendar_event_information(Map<String, String> dataTable) {
        System.out.println("Title: " + dataTable.get("Title"));
        System.out.println("Description: " + dataTable.get("Description"));

        createCalendarEventPage.enterTitle(dataTable.get("Title"));
        createCalendarEventPage.enterDescription(dataTable.get("Description"));
    }

    @Then("user verifies that new calendar event is displayed:")
    public void user_verifies_that_new_calendar_event_is_displayed(Map<String, String> data) {
        String title = data.get("Title");
        String description = data.get("Description");

        Assert.assertEquals(title, createCalendarEventPage.getDataFromGeneralInfo("Title"));
        Assert.assertEquals(description, createCalendarEventPage.getDataFromGeneralInfo("Description"));
    }

}

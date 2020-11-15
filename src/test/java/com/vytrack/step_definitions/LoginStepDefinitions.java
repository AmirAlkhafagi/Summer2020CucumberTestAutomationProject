package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.utils.ConfigurationReader;
import com.vytrack.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage();

    @Given("user is on the landing page")
    public void user_is_on_the_landing_page() throws InterruptedException {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);
    }

    @When("user logs in as sales manager")
    public void user_logs_in_as_sales_manager() throws InterruptedException {
        loginPage.login();
        Thread.sleep(5000);
    }

    //when user logs in as "driver"
    //when user logs in as "sales manager"
    //when user logs in as "store manager"
    @When("user logs in as {string}")
    public void user_logs_in_as(String string) throws InterruptedException {
        loginPage.login(string);
        Thread.sleep(5000);
    }

    @Then("user should be able to see dashboard page")
    public void user_should_be_able_to_see_dashboard_page() {
        String expectedTitle = "Dashboard";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals("Title is not correct", expectedTitle,actualTitle);

    }

    // When user logs in with "storemanager85" username and "wrong" password
    @When("user logs in with {string} username and {string} password")
    public void user_logs_in_with_username_and_password(String string, String string2) {
        loginPage.login(string,string2);
    }

    //Then user verifies that "Invalid user name or password." message is displayed
    @Then("user verifies that {string} message is displayed")
    public void user_verifies_that_message_is_displayed(String expected) {
        String actualMessage = loginPage.getWarningMessageText();
        Assert.assertEquals(actualMessage,expected);
    }

    @Then("user should be able to see {string} page")
    public void user_should_be_able_to_see_page(String string) {
        String actual = loginPage.getPageSubTitleText().trim();
        Assert.assertEquals("Page title is not correct!", string, actual);
    }
}

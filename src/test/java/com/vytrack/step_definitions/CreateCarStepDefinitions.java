package com.vytrack.step_definitions;
import java.util.Map;

import com.vytrack.pages.CreateCarPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class CreateCarStepDefinitions {

    CreateCarPage createCarPage = new CreateCarPage();

    @Given("user click on create car button")
    public void user_click_on_create_car_button() {
        createCarPage.clickOnCreateCar();
    }

    /**
     *  When user adds new vehicle information
     *       | License Plate | SDET |
     *       | Model Year    | 2021 |
     *          key           value
     *      map it's data structure where every value is referenced by key
     *
     *      (in arraylist it's always index)
     *      dataTable = { License Plate = SDET,
     *                    Model Year = 2021 }
     *
     *      If you want to turn data table into map, it must be exactly 2 columns
     *
     *      If it's a 1 column, it can be just List:
     *
     *      Then user verifies following list:
     *          |10|
     *          |20|
     *          |50|
     *
     * @Then("user verifies following list:")
     * public void user_verifies_following_list(List<String> dataTable){}
     */

    @When("user adds new vehicle information")
    public void user_adds_new_vehicle_information(Map<String, String> dataTable) {
        System.out.println("License plate: "+ dataTable.get("License Plate"));
        System.out.println("Model Year: "+ dataTable.get("Model Year"));

        createCarPage.enterLicensePlate((dataTable.get("License Plate")));
        createCarPage.enterModelYear(dataTable.get("Model Year"));
    }


}

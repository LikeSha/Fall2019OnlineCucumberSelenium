package com.vytrack.step_definitions;

import com.vytrack.pages.fleet.VehiclesPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.tr.Ve;

public class CreateCarStepDefinitions {
     VehiclesPage vehiclesPage = new VehiclesPage();

     @Then("user click on create a car button")
    public void user_click_on_create_a_car_button() {
         System.out.println("User click on create a car button");
         VehiclesPage.clickToCreate
    }

    @Then("user creates a car with following info:")
    public void user_creates_a_car_with_following_info(List<Map<String,String>> dataTable) {

    }

}

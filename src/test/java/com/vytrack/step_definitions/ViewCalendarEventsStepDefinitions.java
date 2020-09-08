package com.vytrack.step_definitions;

import com.vytrack.pages.activities.CalendarEventsPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class ViewCalendarEventsStepDefinitions {

    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    @Then("View Per Page menu should have following options")
    public void view_Per_Page_menu_should_have_following_options(List<String> dataTable) {
        System.out.println("Expected value : " + dataTable);
        Assert.assertEquals(dataTable,calendarEventsPage.getViewPerPageOptions());
    }

    /*
     depend on size of data ,we can use proper data structure
     if it is only one column ,we can use List
     if it is two columns , we can use Map or List of Map
     if it is more than two columns, we can use List of Maps.
     */


}

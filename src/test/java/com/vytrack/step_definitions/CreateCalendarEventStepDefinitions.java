package com.vytrack.step_definitions;

import com.vytrack.pages.activities.CalendarEventsPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class CreateCalendarEventStepDefinitions {
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

    @Then("user clicks on create calendar event button")
    public void user_clicks_on_create_calendar_event_button() {
        System.out.println("User clicks on create calendar event button");
        calendarEventsPage.clickToCreateCalendarEvent();
    }

    @Then("user enters {string} as a title")
    public void user_enters_as_a_title(String string) {
        System.out.println("User enters title: " + string);
        calendarEventsPage.enterCalendarEventTitle(string);
    }

    @Then("user enters {string} as a description")
    public void user_enters_as_a_description(String string) {
        System.out.println("User enters description: " + string);
        calendarEventsPage.enterCalendarEventDescription(string);
    }

    @Then("user click on save and close button")
    public void user_click_on_save_and_close_button() {
        System.out.println("User click on save and close button");
        calendarEventsPage.clickOnSaveAndClose();
    }

    @Then("user verifies that description of new calendar event is {string}")
    public void user_verifies_that_description_of_new_calendar_event_is(String string) {
        Assert.assertEquals(string, calendarEventsPage.getGeneralInfoDescriptionText());
    }

    @Then("user verifies that title of new calendar event is {string}")
    public void user_verifies_that_title_of_new_calendar_event_is(String string) {
        Assert.assertEquals(string, calendarEventsPage.getGeneralInfoTitleText());
    }
//    And user enters new calendar event information:
//            | description | On this meeting we discuss what went well, what went wrong and what can be improved |
//            | title       | Sprint Retrospective                                                                |

    @Then("user enters new calendar event information:")
    public void user_enters_new_calendar_event_information(Map<String, String> dataTable) {
        calendarEventsPage.enterCalendarEventDescription(dataTable.get("description"));
        calendarEventsPage.enterCalendarEventTitle(dataTable.get("title"));
//        If you specified data type as a Map, use get("keyName") to read values:
//        dataTable.get("description");
//        dataTable.get("title");
    }

    @Then("user verifies new calendar event was created successfully")
    public void user_verifies_new_calendar_event_was_created_successfully(Map<String, String> dataTable) {
        Assert.assertEquals(dataTable.get("description"),calendarEventsPage.getGeneralInfoDescriptionText());
        Assert.assertEquals(dataTable.get("title"),calendarEventsPage.getGeneralInfoTitleText());
        // Expected data stored in the feature file , but actual data in the UI, actual result is in the database
    }

}
//    DataTable - data structure from Cucumber BDD.
//    Can be transformed into something more commonly used like: List, Map, List<Map>, etc..
//    depends on how many columns do you have in the data table.
//    Don't use DataTable, change it to something else....
//            if you specify non-existing key name, you will get - NULL.
//    make sure, that key name is correct.

/*
1 column - List<String>

2 columns - Map<String, String> - where keys will be always on the left, and values on the right.

2+ columns - List<Map<String, String>> - where keys will be always on the first row.

2+ columns - Map<String, List<String>>

If you specified data type as a Map, use get("keyName") to read values:
        dataTable.get("description");
        dataTable.get("title");
 */
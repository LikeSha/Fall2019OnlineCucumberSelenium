package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/vytrack/step_definitions",
        features = "src/test/resources/features/activities",
        dryRun = false,
        strict = false,
        tags = "", //  to run all tests in cucumber runner class, we can just set tags=""
        plugin = {
                "html:target/default-report",
                "json:target/cucumber2.json"//cucumber2.jason ,is because we have cucumber1.json at CucumberRunner class
        }

)
public class ActivitiesTestRunner {

}
// how to create new folder to group our tests ? lets say I wanna put all activities features together,
// we just right click "features" folder(directory), ---> new--> directory--> then give a name " activities. then
// move CreateCalendarEvents.feature and ViewCalendarEvents.feature into activities folder. Now all
//activities related features are under this folder.
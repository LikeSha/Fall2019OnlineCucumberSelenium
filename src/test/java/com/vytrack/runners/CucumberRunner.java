package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/vytrack/step_definitions",
        features = "src/test/resources",
        dryRun = false,
        strict = false,
        tags = "@sales_manager",
        plugin = {
                "html:target/default-report",// plugin= "html:target/cucumber-html-report"
                "json:target/cucumber1.json",
                "rerun:target/rerun.txt"
        }

)
public class CucumberRunner {


}
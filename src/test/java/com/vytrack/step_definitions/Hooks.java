
package com.vytrack.step_definitions;

import com.vytrack.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setup(){
        System.out.println("Test setup");
        Driver.getDriver().manage().window().maximize();
    }

    @Before("@driver")// this special tags before specific scenario is very useful, when is useful?
    public void specialSetup(){//when you have scenarios for database ,UI,API doing integration testing,
        System.out.println("Setup for driver only");//we are testing how data is coming from another
        //application,and we have to connect to another database besides our database. for this, we need
        //to set another hook,that was responsible for connection for another database.in this case,
        //the set up can configure only for specific test scenario. not for all scenarios, that specific
        //scenario require to some specific setup.
    }

    @After("@driver")
    public void specialTearDown(){
        System.out.println("Tear down for driver only");
    }

    @After
    public void tearDown(Scenario scenario){
        //how to check if scenario failed
        if(scenario.isFailed()){
            TakesScreenshot takeScreenshot = (TakesScreenshot) Driver.getDriver();
            byte[] image = takeScreenshot.getScreenshotAs(OutputType.BYTES);
            //attach screenshot to the report
            scenario.embed(image,"image/png",scenario.getName());
        }
        System.out.println("Test clean up");
        Driver.closeDriver();
    }
}
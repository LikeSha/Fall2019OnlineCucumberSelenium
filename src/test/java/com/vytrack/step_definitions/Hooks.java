package com.vytrack.step_definitions;

import org.junit.After;
import org.junit.Before;

public class Hooks {

    @Before
    public void setup(){

        System.out.println("Test setup");
    }
    @After
    public void tearDown(){
        System.out.println("Test clean up");
    }



}

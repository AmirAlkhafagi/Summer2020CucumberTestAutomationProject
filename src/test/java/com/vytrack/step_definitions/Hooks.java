package com.vytrack.step_definitions;

import com.vytrack.utils.Driver;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setup(Scenario scenario){
        System.out.println(scenario.getSourceTagNames());
        System.out.println(":::::::::: Starting Automation ::::::::::");
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }


    @Before("@smoke_test") //this hook will run only before scenarios with a tag @db
    public void smokeSetUp(){
        System.out.println("Smoke test scenario: ");
    }

    //@After import from cucumber not junit




    @After  //this is going execute after every scenario
    public void screenshot (Scenario scenario) throws IOException {
        scenario.isFailed(); //return boolean: true or false
        scenario.getName(); // return String: "whatever comes after scenario: "
        scenario.getSourceTagNames(); //return String: "@tagNames"

        if(scenario.isFailed()){

            byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }

        Driver.closeDriver();
        System.out.println("End of Test Execution");

    }



}

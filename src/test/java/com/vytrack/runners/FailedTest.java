package com.vytrack.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "@target/group15.txt",
        glue = "com/vytrack/step_definitions"
)
public class FailedTest {
    //should only run failed scenarios

}

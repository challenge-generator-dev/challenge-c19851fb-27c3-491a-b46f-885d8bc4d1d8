package com.pragma;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.pragma.integration.steps"},
    plugin = {"net.serenitybdd.cucumber.SerenityReporter"},
    tags = ""
)
public class RunCucumberTest {
}
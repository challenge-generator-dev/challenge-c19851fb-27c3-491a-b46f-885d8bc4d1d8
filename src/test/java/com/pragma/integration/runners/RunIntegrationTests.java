package com.pragma.integration.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/pedidos.feature",
    glue = {
        "com.pragma.integration.steps",
        "com.pragma.integration.tasks",
        "com.pragma.integration.questions",
        "com.pragma.integration.models",
        "com.pragma.integration.utils"
    },
    plugin = {
        "pretty",
        "html:target/serenity-reports/serenity-html-report.html",
        "json:target/serenity-reports/serenity-json-report.json",
        "junit:target/serenity-reports/serenity-junit-report.xml"
    },
    tags = "@integration",
    dryRun = false,
    strict = true,
    monochrome = false
)
public class RunIntegrationTests {
}
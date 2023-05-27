package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"html:target/cucumber-report_smoke.html",
                "json:target/json-reports/cucumber.json",
                "junit:target/xml-report/cucumber.xml",
                "pretty",
        },
        monochrome = true,
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@radiobutton",
        dryRun = false


)


public class Runners {
}

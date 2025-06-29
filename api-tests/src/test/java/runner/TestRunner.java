package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"step"},
        plugin = {
                "pretty",
                "summary",
                "html:target/cucumber-reports.html",
                "json:target/cucumber.json"
        },
        monochrome = true,
        tags = "@Create or @Read or @Update or @Delete"

)
public class TestRunner extends AbstractTestNGCucumberTests {
}
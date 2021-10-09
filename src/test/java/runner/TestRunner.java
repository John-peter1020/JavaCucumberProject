package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		dryRun=false,
		tags = "@tag",
        features="src/test/resources/features",
        glue="stepDefinition",
        plugin={"json:target/cucumber.json","pretty","html:target/cucumber-reports.html"}
)
public class TestRunner {

}

package cucumber.support;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\resources\\features",
        plugin={"pretty", "html:target/cucumber"},
        glue = {"cucumber.steps",
                "cucumber.support"},
        tags = {})
public class CucumberRunner {

}
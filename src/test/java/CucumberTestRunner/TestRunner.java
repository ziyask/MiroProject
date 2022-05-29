package CucumberTestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
                features = {"src/test/resources/MiroFeatures"},
                glue = {"StepDefinitionsFiles"},
                tags = "@All",
                plugin = {"pretty", "json:target/Reports/report.json"
                            ,"json:target/Reports/report.xml"},
                publish = true
)
public class TestRunner {


}

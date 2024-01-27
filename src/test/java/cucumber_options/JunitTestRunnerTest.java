package cucumber_options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", glue = {"step_definitions"}, dryRun = false,
        plugin = "json:target/jsonReports/cucumber-report.json"
//        tags = {"@AddPlaceAndGetPlace or @DeletePlace"} //OR

//        tags = {"@AddPlaceAndGetPlace and @DeletePlace"} //AND

//        tags = {"@AddPlaceAndGetPlace, @DeletePlace"} //OR
            //      Jan 27, 2024 2:30:23 PM cucumber.runtime.filter.TagExpressionOld isOldTagExpression
            //      WARNING: Found tags option '@AddPlaceAndGetPlace, @DeletePlace'.
            //      Support for '@tag1,@tag2' will be removed from the next release of Cucumber-JVM.
            //      Please use '@tag or @tag2' instead

//        tags = {"@DeletePlace", "@Regression"} //AND
//        tags = "@AddPlaceAndGetPlace or @DeletePlace"
)
public class JunitTestRunnerTest {
}

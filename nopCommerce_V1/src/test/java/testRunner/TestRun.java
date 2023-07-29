package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features=".//Features/Giftcard.feature",
		glue="stepDefinitions",
		dryRun=true,
		plugin= {"pretty","html:target/html-reports/reports.html"},
		monochrome=true
		
		
		)
public class TestRun {

}

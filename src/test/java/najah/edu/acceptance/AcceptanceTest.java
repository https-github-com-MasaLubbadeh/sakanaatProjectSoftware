package najah.edu.acceptance;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="myFeatures",
		plugin="html:target/cucumber/reports.html",
		monochrome=true,
		snippets=SnippetType.CAMELCASE,
		glue="najah.edu.acceptance"
		)
public class AcceptanceTest{

}
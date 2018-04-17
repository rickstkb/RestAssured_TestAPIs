package stepDefinitions;
 
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber; 

@RunWith(Cucumber.class) 
@CucumberOptions (
//		dryRun=true,
		monochrome=true,
		features = "src/test/resources/bdd/countries.feature", 
//		tags = "@interagecheckbox", 
		glue={"stepDefinitions"}
		)
public class runTest { }
package com.qa.logomedia.runners;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
	tags = "@smoke" ,
		
		features = "src/test/resources/com/logomedia/features",
		glue = "com/qa/logomedia/stepDefs",
		plugin = {"summary",
				 
				 
				 "rerun:target/failed.txt",
				 "html:target/builtInReport",
				 "json:target/Cucumber.json" // needed for pretty report
		
		}, // summary -> generate unimplemented step definitions in console
										// pretty -> more detailed output
		monochrome = true // fixes the ? on the console for windows users
   //  ,dryRun = true  // skips the step definition execution -> used to generate SDs quickly
		
		,snippets = SnippetType.CAMELCASE
		,stepNotifications = true
		)

public class CukeRunner {

}

package com.qa.logomedia.stepDefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.logomedia.utilities.ConfigReader;
import com.qa.logomedia.utilities.Driver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
//	@Before ("@ui")
//	public void setUp() {
//		Driver.getDriver().manage().timeouts().
//		implicitlyWait(Long.parseLong(ConfigReader.getProperty("implicitWait")), TimeUnit.SECONDS);
//		Driver.getDriver().manage().window().maximize();
//		Driver.getDriver().get(ConfigReader.getProperty("url"));
//		
//		
//	}
	
	
	
	@After  ("@ui")
	public void tearDown(Scenario scenario) {
		
		if(scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "screenshot");
					}

		
		
		
		Driver.quit();
		

	}
	


}

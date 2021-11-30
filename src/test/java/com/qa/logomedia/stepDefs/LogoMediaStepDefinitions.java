package com.qa.logomedia.stepDefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.qa.logomedia.pages.ContactPage;
import com.qa.logomedia.pages.LandingPage;

import com.qa.logomedia.utilities.BrowserUtilities;
import com.qa.logomedia.utilities.ConfigReader;
import com.qa.logomedia.utilities.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class LogoMediaStepDefinitions {
	
	
	@Given("Validate the user is on home page")
	public void validateTheUserIsOnHomePage() {
		Driver.getDriver().manage().timeouts().implicitlyWait(
				Long.parseLong(ConfigReader.getProperty("implicitWait")), TimeUnit.SECONDS);
		Driver.getDriver().manage().window().maximize();
		
		Driver.getDriver().get(ConfigReader.getProperty("url"));
		Assert.assertEquals("Home", Driver.getDriver().getTitle());
	    
	}

	@When("Validate the user clicks on Contact button and lands on Contact Page")
	public void validateTheUserClicksOnContactButtonAndLandsOnContactPage() {
		LandingPage lp = new LandingPage();
		lp.contactButton.click();
		
		Assert.assertEquals("Contact", Driver.getDriver().getTitle());
	   
	}

	@Then("Validate the user fills out the form and clicks on Submit button")
	public void validateTheUserFillsOutTheFormAndClicksOnSubmitButton() throws InterruptedException {
	 
	    BrowserUtilities.waitFor(2);
		Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@jsname='L5Fo6c']")));
		ContactPage cp = new ContactPage();
		cp.nameInputBox.sendKeys("Myname");
		cp.doYouWantToWorkForusyesRadioButton.click();
		BrowserUtilities.waitFor(2);
		
		cp.howDoYouPreferWorkDropDown.click();
		cp.howDoYouPreferWorkDropDownSelection.click();
		
		
		BrowserUtilities.waitFor(2);
		Driver.getDriver().switchTo().parentFrame();
		JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
		 
	js.executeScript("window.scrollBy(0,250)", "");
	
	
	Driver.getDriver().switchTo().frame(Driver.getDriver().findElement(By.xpath("//iframe[@jsname='L5Fo6c']")));

		Driver.getDriver().findElement(By.xpath("//input[@aria-labelledby='i19']")).sendKeys("hello ");
		cp.submitButton.click();
		
		boolean actual = Driver.getDriver().getPageSource().contains("Thank you for your time. We are appreciating this.");
		
		Assert.assertEquals(true, actual);
		
		
		
	}



	
	

}

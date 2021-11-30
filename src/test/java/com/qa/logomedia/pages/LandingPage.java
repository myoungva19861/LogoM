package com.qa.logomedia.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.logomedia.utilities.Driver;



public class LandingPage{

	public LandingPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	 
	
	
	@FindBy (xpath= "//a[contains(text(),'Contact')]")
	public WebElement contactButton;
	

	
}


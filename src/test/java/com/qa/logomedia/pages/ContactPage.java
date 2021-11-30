package com.qa.logomedia.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.logomedia.utilities.Driver;

public class ContactPage {
	
	
	public ContactPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	 
	
	
	@FindBy (xpath= "(//input[@class='quantumWizTextinputPaperinputInput exportInput'])[1]")
	public WebElement nameInputBox;
	
	
	@FindBy (xpath= "(//div[@class='appsMaterialWizToggleRadiogroupRadioButtonContainer'])[1]")
	public WebElement doYouWantToWorkForusyesRadioButton;
	
	
	
	
	
	@FindBy (xpath= "//div[@role='listbox']")
	public WebElement howDoYouPreferWorkDropDown;
	
	
	
	
	@FindBy (xpath= "(//span[@class='quantumWizMenuPaperselectContent exportContent'])[5]")
	public WebElement howDoYouPreferWorkDropDownSelection;
	
			
	
	@FindBy (xpath= "(//div[@class='quantumWizTextinputPaperinputMainContent exportContent'])[2]")
	public WebElement whyWorkForUsInputField;
					
		
		

	@FindBy (xpath= "(//span[@class='appsMaterialWizButtonPaperbuttonLabel quantumWizButtonPaperbuttonLabel exportLabel'])[1]")
	public WebElement submitButton;			
					
					
					
					
}

package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.crm.qa.base.TestBase;

public class NewContactPage extends TestBase {
	
	@FindBy(xpath="//div[text()='Create New Contact']//parent::div[@class='ui header item mb5 light-black']")
	//@CacheLookup
	WebElement createNewContactLabel;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement fName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lName;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveBtn;
	
	public NewContactPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean validateCreateNewContact() {
		return createNewContactLabel.isDisplayed();
	}
	
	public void createNewContact(String ftame,String ltName) {
		fName.sendKeys(ftame);
		lName.sendKeys(ltName);
		saveBtn.click();
	}
}

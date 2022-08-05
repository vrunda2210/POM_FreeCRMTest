package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//div[text()='Contacts']//parent::div[@class='ui header item mb5 light-black']")
	WebElement contactsLabel;
	
	@FindBy(xpath="//button[contains(text(),'Create')]")
	WebElement newContact;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifycontacstLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='']")).click();;
	}
	
	public NewContactPage createNewContactLink() {
		newContact.click();
		return new NewContactPage();
	}
}

package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;


	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		contactsPage = new ContactsPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabelTest() {
		Assert.assertTrue(contactsPage.verifycontacstLabel(),"contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest() {
		contactsPage.selectContactsByName("vrunda patel");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest() {
		contactsPage.selectContactsByName("vrunda patel");
		contactsPage.selectContactsByName("v patel");
	}
	
	@Test(priority=4)
	public void createNewContactTest() {
		contactsPage.createNewContactLink();
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
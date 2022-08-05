package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.NewContactPage;
import com.crm.qa.util.TestUtil;

public class NewContactPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	NewContactPage newContactPage;
	
	String sheetName = "contacts";
	
	public NewContactPageTest() {
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
		newContactPage=contactsPage.createNewContactLink();
		
	}
	
	@Test(priority=1)
	public void validateCreateNewContactTest() {
		Assert.assertTrue(newContactPage.validateCreateNewContact(), "Create New Contact label is missing from the page");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() {
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getCRMTestData")
	public void createNewContactTest(String ftName,String ltName) {
		newContactPage.createNewContact(ftName,ltName);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

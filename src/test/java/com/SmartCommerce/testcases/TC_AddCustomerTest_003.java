package com.SmartCommerce.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.SmartCommerce.pageobjects.AddcustomerPage;
import com.SmartCommerce.pageobjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{

	@Test
	public void addNewCustomer() throws Exception
	{
	driver.get(baseURL);
	
	LoginPage lp=new LoginPage(driver);
	lp.setUserName(username);
	logger.info("User name is provided");
	
	lp.setPassword(password);
	logger.info("password is provided");
	
	lp.clickLogin();
	
	logger.info("providing customer details....");
	
	AddcustomerPage addcust=new AddcustomerPage(driver);
	
	addcust.clickOnCustomersMenu();
	addcust.clickOnCustomersMenuItem();
	
	addcust.clickOnAddnew();
	
	String email = randomestring() + "@gmail.com";
	addcust.setEmail(email);
	
	addcust.setPassword("GSmartK@@10");
	
	//Registered - default
	//The customer cannot be in both 'Guests' and 'Registered' customer roles
	//Add the customer to 'Guests' or 'Registered' customer role
	addcust.setCustomerRoles("Guest");
	
	addcust.setManagerOfVendor("Vendor 2");
	
	addcust.setGender("Male");
	
	addcust.setFirstName("SmartGeek");
	
	addcust.setLastName("SmileyFish");
	
	addcust.setDob("2/14/1994"); // Format: M/DD/YYYY
	
	addcust.setCompanyName("NTT");
	addcust.setAdminContent("This is for testing........");
	
	addcust.clickOnSave();
	
	logger.info("validation started....");
	
	//String msg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
	
	String msg = driver.findElement(By.tagName("body")).getText();
	
	
	if(msg.contains("The new customer has been added successfully"))
	{
	Assert.assertTrue(true);
	logger.info("test case passed....");
	}
	else
	{
	captureScreen(driver,"addNewCustomer");
	Assert.assertTrue(false);
	}
	
	}
	


}
package com.SmartCommerce.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.SmartCommerce.pageobjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void loginTest() throws InterruptedException, IOException {
		driver.get(baseURL);
		Thread.sleep(2000);
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User provided"); //logger message
		lp.setPassword(password);
		logger.info("Password provided");//logger message
		lp.clickLogin();
		logger.info("Login in Clicked");//logger message
		Thread.sleep(5000);
		if (driver.getTitle().equals("Dashboard / nopCommerce administration")) {
		Thread.sleep(5000);
		lp.clickLogout();
		Assert.assertTrue(true);
		logger.info("Login Passed");//logger message
		} 
		else 
		{
			captureScreen(driver,"loginTest");
			logger.info("Login Failed");//logger message
		    Assert.assertTrue(false);
		}

		}

}

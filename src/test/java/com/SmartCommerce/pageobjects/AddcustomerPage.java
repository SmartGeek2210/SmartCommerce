package com.SmartCommerce.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;
public class AddcustomerPage {

	public WebDriver ldriver;
	
	public AddcustomerPage(WebDriver rdriver)
	{
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
	}
	
	By lnkCustomers_menu=By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By lnkCustomers_menuitem=By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	
	By btnAddnew=By.xpath("//a[@href='/Admin/Customer/Create']"); //Add new
	
	By txtEmail=By.xpath("//input[@id='Email']");
	By txtPassword=By.xpath("//input[@id='Password']");
	By txtcustomerRoles=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	
	By lstitemAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
	By lstitemRegistered=By.xpath("//li[contains(text(),'Registered')]");
	By lstitemGuests=By.xpath("//li[contains(text(),'Guests')]");
	By lstitemVendors=By.xpath("//li[contains(text(),'Vendors')]");
	
	
	By drpmgrOfVendor=By.xpath("//*[@id='VendorId']");
	By rdMaleGender=By.id("Gender_Male");
	By rdFeMaleGender=By.id("Gender_Female");
	
	By txtFirstName=By.xpath("//input[@id='FirstName']");
	By txtLastName=By.xpath("//input[@id='LastName']");
	
	By txtDob=By.xpath("//input[@id='DateOfBirth']");
	
	By txtCompanyName=By.xpath("//input[@id='Company']");
	
	By txtAdminContent=By.xpath("//textarea[@id='AdminComment']");
	
	By btnSave=By.xpath("//button[@name='save']");
	
	
	public void clickOnCustomersMenu() 
	{
	ldriver.findElement(lnkCustomers_menu).click();
	}
	
	
	
	public void clickOnCustomersMenuItem() 
	{
	ldriver.findElement(lnkCustomers_menuitem).click();
	}
	
	public void clickOnAddnew() 
	{
	ldriver.findElement(btnAddnew).click();
	}
	
	public void setEmail(String email) throws InterruptedException
	{
	ldriver.findElement(txtEmail).sendKeys(email);
    Thread.sleep(2000);
	}
	
	public void setPassword(String password) throws InterruptedException
	{
	ldriver.findElement(txtPassword).sendKeys(password);
	 Thread.sleep(2000);
	}
	
	
	public void setCustomerRoles(String role)
	{
	ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click();
	
	ldriver.findElement(txtcustomerRoles).click();
	
	WebElement listitem;
	
	switch(role)
	{
	case "Administrators":
	listitem=ldriver.findElement(lstitemAdministrators); break;
	case "Guests":
	listitem=ldriver.findElement(lstitemGuests); break;
	case "Registered":
	listitem=ldriver.findElement(lstitemRegistered); break;
	case "Vendors":
	listitem=ldriver.findElement(lstitemVendors); break;
	default:
	listitem=ldriver.findElement(lstitemGuests);
	}
	
	JavascriptExecutor js = (JavascriptExecutor)ldriver;
	js.executeScript("arguments[0].click();", listitem);
	
	}
	
	
	
	public void setManagerOfVendor(String value) throws InterruptedException
	{
	Select drp=new Select(ldriver.findElement(drpmgrOfVendor));
	drp.selectByVisibleText(value);
	 Thread.sleep(2000);
	}
	
	public void setGender(String gender)
	{
	if(gender.equals("Male"))
	{
	ldriver.findElement(rdMaleGender).click();
	}
	else if(gender.equals("Female"))
	{
	ldriver.findElement(rdFeMaleGender).click();
	}
	else
	{
	ldriver.findElement(rdMaleGender).click();//Default
	}
	
	}
	
	public void setFirstName(String fname) throws Exception
	{
	ldriver.findElement(txtFirstName).sendKeys(fname);
	 Thread.sleep(2000);
	}
	
	public void setLastName(String lname) throws InterruptedException
	{
	ldriver.findElement(txtLastName).sendKeys(lname);
	 Thread.sleep(2000);
	}
	
	public void setDob(String dob) throws InterruptedException
	{
	ldriver.findElement(txtDob).sendKeys(dob);
	 Thread.sleep(2000);
	}
	
	public void setCompanyName(String comname) throws InterruptedException
	{
	ldriver.findElement(txtCompanyName).sendKeys(comname);
	 Thread.sleep(2000);
	}
	
	public void setAdminContent(String content) throws InterruptedException
	{
	ldriver.findElement(txtAdminContent).sendKeys(content);
	 Thread.sleep(2000);
	}
	
	public void clickOnSave()
	{
	ldriver.findElement(btnSave).click();
	}
	}

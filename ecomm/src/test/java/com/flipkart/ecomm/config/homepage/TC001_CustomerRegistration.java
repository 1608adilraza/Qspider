package com.flipkart.ecomm.config.homepage;

import org.testng.annotations.Test;
import com.automation.ecommerce.basepage.BasePage;
import com.automation.ecommerce.pageui.LoginAccount;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class TC001_CustomerRegistration extends BasePage
{
	public static final Logger log= Logger.getLogger(TC001_CustomerRegistration.class);
	
	@BeforeMethod
  public void setUp() throws Exception 
  {
	  browserLaunch(getData("browser"),getData("url")); 
  }
  @Test
  public void customerRegistration() throws Exception 
  {
	  log.info("-----------------Starting TC001_CustomerRegistration----------------------");
	  LoginAccount login = new LoginAccount(driver);
	  login.customerRegistration();
	  log.info("-----------------Ending TC001_CustomerRegistration----------------------");
  }
  @AfterMethod
  public void killProcess() 
  {
	// driver.close();
  }
}
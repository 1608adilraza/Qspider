package com.flipkart.ecomm.basepage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public static WebDriver driver;
	public static final String path="./config.properties";
	public String log4jpath="log4j.properties";  ///HAVING DOUBT---------------------------------------------------------------------------
	
	public static String getData(String key) throws IOException 
	{
		File file=new File(path);
		FileInputStream fis= new FileInputStream(file) ;
		Properties p = new Properties();
		p.load(fis);
		return p.getProperty(key); ///DOUBT------------------------------------------------------------------------------------------------
	}
	
	public void browserLaunch(String browser, String url)
	{
		if(browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe//"); 
			   driver=new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")) 
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"//Drivers//geckodriver.exe//"); 
			   driver=new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("IE")) 
		{
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"//Drivers//IEDriverServer.exe//"); 
			   driver=new InternetExplorerDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		// PropertyConfigurator.configure("log4jpath"); ///doubt-----------------------------------------------------------------------------
		
	}
	 public static int randomNumber()
	 {
		 Random r =new Random();
		 int random=r.nextInt(9999);
		 return random;
	 }
	 
	 public void selectOption(WebElement element, int option) ////doubt---------------------
	 {
		 Select s = new Select(element);
		 s.selectByIndex(option);	
		}
	 
	 public void elementVisible(int time, WebElement element, String option) {
		 WebDriverWait wait = new WebDriverWait(driver, time);
		 wait.until(ExpectedConditions.visibilityOf(element));
	 }
}

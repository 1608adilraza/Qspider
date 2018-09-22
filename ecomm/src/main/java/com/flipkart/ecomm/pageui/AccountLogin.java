package com.flipkart.ecomm.pageui;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.automation.ecommerce.basepage.BasePage;
import com.automation.ecommerce.config.homepage.TC001_CustomerRegistration;

public class AccountLogin extends BasePage
{
	public static final Logger log= Logger.getLogger(AccountLogin.class.getName());
	@FindBy(linkText="Sign in") WebElement signIN;
	@FindBy(id= "email_create") WebElement emailId;
	@FindBy(id= "SubmitCreate") WebElement createAccountbutton;
	@FindBy(xpath="//h1[text()='Create an account']") WebElement createAccountPage;
	@FindBy(id="id_gender1") WebElement mrRadio;
	@FindBy(id="customer_firstname") WebElement firstName ;
	@FindBy(id="customer_lastname") WebElement lastName;
	@FindBy(id="passwd") WebElement password ;
	@FindBy(id="days") WebElement days;
	@FindBy(id="months") WebElement month ;
	@FindBy(id="years") WebElement  year ;
	@FindBy(id="address1") WebElement address1 ;
	@FindBy(id="city") WebElement city;
	@FindBy(id="id_state") WebElement state ;
	@FindBy(id="postcode") WebElement zipCode ;
	@FindBy(id="phone_mobile") WebElement mobile;
	@FindBy(id="submitAccount") WebElement submitAccount;
	@FindBy(xpath="//h1[text()='My account']") WebElement myeAccountPage;

	public AccountLogin(WebDriver driver) {
		PageFactory.initElements(driver,this); 
	}

	public void customerRegistration() throws Exception
	{
		signIN.click();
		log.info("Click on signIN with object:"+signIN);
		emailId.sendKeys(getData("firstName")+getData("lastname")+randomNumber()+getData("domainame"));
		log.info("Entering email address:"+emailId.getAttribute("value")+ "using object:"+ emailId.toString());
		createAccountbutton.click();
		Thread.sleep(4000);
		log.info("Clicked on create account button by using the object: +createAccountbutton.tostring()");
		
		// elementVisible(60,createAccountPage);
		assertTrue(createAccountPage.getText().equalsIgnoreCase("CREATE AN ACCOUNT"));
		//assertEquals(createAccountPage.getText(), "CREATE AN ACCOUNT");
		log.info("Varified customer personal info page by using object:" +createAccountPage.toString());
		mrRadio.click();
		log.info("selected gender by using object:"+mrRadio.toString());
		firstName.sendKeys("firstName");
		log.info("Entered first name by using object:"+lastName.toString());
		lastName.sendKeys("lastname");
		log.info("Entered last name by using object:"+firstName.toString());
		password.sendKeys("password");
		log.info("entered password using object:"+password.toString());
		
		selectOption(days,1);
		log.info("Selected  day using object:"+days.toString());
		selectOption(month,8);
		log.info("Selected  month using object:"+month.toString());
		selectOption(year,10);
		log.info("Selected  year using object:"+year.toString());
		
		address1.sendKeys(getData("address1"));
		log.info("Selected address using object:"+address1.toString());
		
		city.sendKeys(getData("city"));
		log.info("Selected address using object:"+address1.toString());
		
		selectOption(state,5);
		log.info("Selected city using object:"+city.toString());
		
		zipCode.sendKeys(getData("zipcode"));
		log.info("Selected zipCode using object:"+zipCode.toString());
		
		mobile.sendKeys(getData("mobileNumber"));
		log.info("Selected mobile using object:"+mobile.toString());
		
		submitAccount.click();
		log.info("Clicked on submitAccount using object:"+submitAccount.toString());
		
		assertEquals(myeAccountPage.getText(), "MY ACCOUNT");
		log.info("Varified successful registration by using object:" +myeAccountPage.toString());
	}
}


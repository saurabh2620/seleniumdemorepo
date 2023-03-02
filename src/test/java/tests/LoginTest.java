package tests;

import java.io.IOException;

import org.apache.logging.log4j.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.AccountInfo;
import pageobjects.LandingPage;
import pageobjects.LoginPage;
import resources.Base;

public class LoginTest extends Base{
	WebDriver driver;
	Logger log ;
	@Test
	public void login() throws Throwable {
		 log = LogManager.getLogger(LoginTest.class.getName());
		 log.info("working fine");
		
		LandingPage lp=new LandingPage(driver);
		lp.myaccount().click();
		lp.login().click();
		LoginPage loginpage=new LoginPage(driver);
		loginpage.email().sendKeys("heygaurav111@gmail.com");
		loginpage.password().sendKeys("12345");
		loginpage.button().click();
		AccountInfo de=new AccountInfo(driver);
		Assert.assertTrue(de.Accountdisplayed().isDisplayed());
		
	}
	@BeforeMethod()
	public void openApplication() throws IOException {
		 driver= initialDriver();
		// log.error("browser launched");
			driver.get("http://www.tutorialsninja.com/demo/");
		
	}
	
	
	@AfterMethod
	public void cloure() {
		driver.close();
		
	}

}

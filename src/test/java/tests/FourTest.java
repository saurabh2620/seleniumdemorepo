package tests;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import resources.Base;

public class FourTest extends Base{
	
	 WebDriver driver;
	@Test
	public void testfour() throws IOException {
		System.out.println("test four");
		 driver=initialDriver();
		driver.get("https://facebook.com");
		Assert.assertTrue(false);
	}

}

package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name ="email")
	WebElement email;

	@FindBy(name ="password")
	WebElement password;

	@FindBy(xpath = "//input[@value='Login']")
	WebElement button;

	public WebElement email() {
		return email;
	}

	public WebElement password() {
		return password;
	}

	public WebElement button() {
		return button;

	}

}

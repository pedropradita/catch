package ObjectRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	JavascriptExecutor js;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
	}

	@FindBy(id = "username")
	WebElement userNameField;
	@FindBy(id = "password")
	WebElement passwordField;
	@FindBy(css = "button[type='submit']")
	WebElement signInBtn;
	@FindBy(id = "user")
	WebElement userBtn;
	
	public WebElement userNameField() {
		return userNameField;
	}

	public WebElement passwordField() {
		return passwordField;
	}
	
	public WebElement signInBtn() {
		return signInBtn;
	}
}
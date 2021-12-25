package ObjectRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {

	public WebDriver driver;
	JavascriptExecutor js;

	public AdminPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
	}

	@FindBy(id = "user")
	WebElement userBtn;
	@FindBy(css = "a[href*='new']")
	WebElement createNewPostBtn;
	@FindBy(css = "div[role='alert']")
	WebElement messageAlert;	
	
	public WebElement userBtn() {
		return userBtn;
	}
	
	public WebElement createNewPostBtn() {
		return createNewPostBtn;
	}
	
	public WebElement messageAlert() {
		return messageAlert;
	}
}
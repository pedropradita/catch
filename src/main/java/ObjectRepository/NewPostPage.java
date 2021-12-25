package ObjectRepository;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewPostPage {

	public WebDriver driver;
	JavascriptExecutor js;

	public NewPostPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;
	}

	@FindBy(id = "post_title")
	WebElement titleField;
	@FindBy(id = "post_summary")
	WebElement summaryField;
	@FindBy(id = "post_content")
	WebElement contentField;
	@FindBy(id = "post_publishedAt")
	WebElement publishedAtField;
	@FindBy(css = "input[class='tt-input']")
	WebElement tagsField;
	@FindBy(css = "div[class='tt-suggestion tt-selectable']")
	WebElement suggestBtn;
	@FindBy(css = "button[class='btn btn-primary']")
	WebElement createPostBtn;
	
	public WebElement titleField() {
		return titleField;
	}
	
	public WebElement summaryField() {
		return summaryField;
	}
	
	public WebElement contentField() {
		return contentField;
	}
	
	public WebElement publishedAtField() {
		return publishedAtField;
	}
	
	public WebElement tagsField() {
		return tagsField;
	}
	
	public WebElement suggestBtn() {
		return suggestBtn;
	}
	
	public WebElement createPostBtn() {
		return createPostBtn;
	}
}
package script;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import ObjectRepository.AdminPage;
import ObjectRepository.HomePage;
import ObjectRepository.LoginPage;
import ObjectRepository.NewPostPage;
import resources.Base;
import resources.Helper;

public class AdminTest extends Base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	Helper he;
	LoginPage l;
	HomePage h;
	AdminPage a;
	NewPostPage np;
	JavascriptExecutor js;

	@BeforeMethod
	public void BefMet() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));

		he = new Helper(driver);
		l = new LoginPage(driver);
		h = new HomePage(driver);
		a = new AdminPage(driver);
		np = new NewPostPage(driver);
		js = (JavascriptExecutor) driver;

		h.backEndBtn().click();
	}

	@AfterMethod
	public void AfMet() {
		driver.close();
		driver.quit();
	}

	@Test(groups = "Regression")
	public void successCreatePost() {

		System.out.println("Case success create post");

		l.successLogin();

		String desc = "Success Create Post";
		String dTN = he.getCurrentDateTime("YYYY-MM-dd HH:mm:ss");
		String title = "title " + dTN;
		String summary = "summary " + dTN;
		String content = "content " + dTN;
		String date = he.getCurrentDate("YYYY-MM-dd");
		String time = he.getCurrentTime("HH:mm:ss");
		String tag = "a";
		String expected = "×                                        Post created successfully!";

		a.createNewPostBtn().click();
		np.titleField().sendKeys(title);
		np.summaryField().sendKeys(summary);
		np.contentField().sendKeys(content);
		np.publishedAtField().clear();
		np.publishedAtField().sendKeys(date + "T" + time);
		np.tagsField().sendKeys(tag);
		np.suggestBtn().click();
		js.executeScript("arguments[0].click();", np.createPostBtn());

		String actual = a.messageAlert().getAttribute("textContent").trim().replace("\n", "");

		Assert.assertTrue(he.checkAlert(desc, actual, expected));
	}
}
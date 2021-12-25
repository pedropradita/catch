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

public class LoginTest extends Base {

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
	public void successLogin() {

		System.out.println("Case success login");

		String desc = "Success Login";
		String userName = "jane_admin";
		String pass = "kitten";

		l.userNameField().clear();
		l.userNameField().sendKeys(userName);
		l.passwordField().clear();
		l.passwordField().sendKeys(pass);
		l.signInBtn().click();

		Assert.assertTrue(he.compareTrue(desc, a.userBtn().isDisplayed()));
	}
}
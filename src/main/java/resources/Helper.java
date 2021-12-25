package resources;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Helper {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(Base.class.getName());

	public Helper(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getCurrentDateTime(String format) {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String dateNow = formatter.format(currentDate.getTime());
		return dateNow;
	}

	public String getCurrentDate(String format) {
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String dateNow = formatter.format(currentDate.getTime());
		return dateNow;
	}

	public String getCurrentTime(String format) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		String currentTime = formatter.format(cal.getTime());
		return currentTime;
	}

	public String getRandomNumberString() {
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		return String.format("%06d", number);
	}

	public boolean compareTrue(String desc, boolean actual) {
		if (actual) {
			log.info("Verified '" + desc + "'");
			return true;
		} else {
			log.error("Failed to verify '" + desc + "'");
			return false;
		}
	}

	public boolean checkAlert(String desc, String actual, String expected) {
		if (actual.equals(expected)) {
			log.info(desc + " alert is verified '" + actual + "'");
			return true;
		} else {
			log.error(desc + " alert text is failed to verify '" + actual + "'");
			return false;
		}
	}

	public boolean checkImg(WebElement object, String desc) {
		boolean img = object.isDisplayed();

		if (img) {
			log.info(desc + " logo is enable " + object);
		} else {
			log.error(desc + " logo is disable " + object);
		}
		return img;
	}

	public String CheckUrl(WebDriver object, String desc, String urltab) {
		String url = object.getCurrentUrl();
		if (url.equals(urltab)) {
			log.info(desc + " URL is right " + url);
		} else {
			log.error(desc + " URL is wrong " + url);
		}
		return url;
	}
}
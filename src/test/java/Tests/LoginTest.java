package Tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;
import pageobject.AccountPage;
import pageobject.LandingPage;
import pageobject.LoginPage;

public class LoginTest extends Base {
	Logger log;
	WebDriver driver;

	@Test(dataProvider = "getlogindata")
	public void login(String email, String password, String expectedResult) throws IOException {

		LandingPage landingpage = new LandingPage(driver);
		landingpage.myAccountDropdown().click();
		log.debug("clicked on myaccountdropdown");
		landingpage.loginoption().click();
		log.debug("clicked on login option");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.emailaddressfield().sendKeys(email);
		log.debug("email got executed");
		loginpage.passwordfield().sendKeys(password);
		log.debug("password got executed");
		loginpage.loginpage().click();
		AccountPage accountpage = new AccountPage(driver);

		String actualResult = null;
		try {
			if (accountpage.editaccountinformationoption().isDisplayed()) {
				actualResult = "successful";
				log.debug("user got login");
			}
		} catch (Exception e) {
			actualResult = "Failure";
			log.debug("user didnt login");
		}
		Assert.assertEquals(actualResult, expectedResult);
		log.info("login test got passed");
	}

	@BeforeMethod
	public void openApplication() throws IOException {
		log = LogManager.getLogger(LoginTest.class.getName());
		driver = intializeDriver();
		log.debug("browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("navigated to the page");
	}

	@AfterMethod
	public void closure() {
		log.debug("browser got closed");
		driver.close();
	}

	@DataProvider
	public Object[][] getlogindata() {
		Object[][] data = { { "sethuram416@gmail.com", "Sethu@416", "successful" } };
		return data;
	}

}

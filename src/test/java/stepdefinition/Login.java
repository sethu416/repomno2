package stepdefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Resources.Base;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobject.AccountPage;
import pageobject.LandingPage;
import pageobject.LoginPage;

public class Login extends Base{
	
	WebDriver driver;
	LandingPage landingpage;
	LoginPage loginpage;
	@Given("^open any Browser$")
	public void open_any_Browser() throws IOException {
		driver = intializeDriver();
		
	}
	@And("^Navigate to loginpage$")
	public void Navigate_to_loginpage() throws InterruptedException {
		driver.get(prop.getProperty("url"));
		 landingpage=new LandingPage(driver);
		landingpage.myAccountDropdown().click();
		landingpage.loginoption().click();
		Thread.sleep(3000);
		
	}
	@When("^user enters username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_enters_username_as_something_and_password_as_something(String email,String password) {
		 loginpage=new LoginPage(driver);
		loginpage.emailaddressfield().sendKeys(email);
		loginpage.passwordfield().sendKeys(password);
	}
	@And("^User clicks on login button$")
	public void User_clicks_on_login_button() {
		loginpage.loginpage().click();
		
	}
	@Then("^ Verify user is able to successfully login$")
	public void  Verify_user_is_able_to_successfully_login() {
		AccountPage accountpage=new AccountPage(driver);
		
		
		Assert.assertTrue(accountpage.editaccountinformationoption().isDisplayed());
	}
	@After
	public void closebrowser() {
		driver.close();
	}

}

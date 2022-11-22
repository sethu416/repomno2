package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="input-email")
	 WebElement emailaddressfield;
	@FindBy(id="input-password")
 WebElement passwordfield;
	@FindBy(css="input[value='Login']")
	 WebElement loginpage;
	public WebElement emailaddressfield() {
		return emailaddressfield;
	}
	public WebElement passwordfield() {
		return passwordfield;
	}
public WebElement loginpage() {
	return loginpage;
}
}

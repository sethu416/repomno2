package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Resources.Base;

public class Test4 extends Base {
	public WebDriver driver;
	@Test
	public void test4() throws IOException, InterruptedException {
		System.out.println("testfour");
		 driver=intializeDriver();
		driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
		Thread.sleep(5000);
		Assert.assertTrue(false);
		
	}
	@AfterMethod
	public void closure() {
		driver.close();
	}
}

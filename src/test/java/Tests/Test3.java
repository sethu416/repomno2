package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Resources.Base;

public class Test3 extends Base {
	@Test
	public void test3() throws IOException, InterruptedException {
		System.out.println("testthree");
		WebDriver driver=intializeDriver();
		driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
		Thread.sleep(5000);
		driver.close();
	}
}

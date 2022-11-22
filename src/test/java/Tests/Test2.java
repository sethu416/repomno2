package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Resources.Base;

public class Test2 extends Base {
	@Test
	public void test2() throws IOException, InterruptedException {
		System.out.println("testtwo");
		WebDriver driver=intializeDriver();
		driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
		Thread.sleep(5000);
		driver.close();
	}

}

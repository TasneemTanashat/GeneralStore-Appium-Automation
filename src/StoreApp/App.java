package StoreApp;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.Assert;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class App {

	AndroidDriver driver;
	DesiredCapabilities caps = new DesiredCapabilities();

	@BeforeTest
	public void mySetup() {

		caps.setCapability("platformName", "Android");
		caps.setCapability("appium:automationName", "UiAutomator2");
		caps.setCapability("appium:deviceName", "HUAWEI 2019");

		File myapplication = new File("MyApp/General-Store.apk");

		caps.setCapability("appium:app", myapplication.getAbsolutePath());
		caps.setCapability("appium:noReset", false);
		caps.setCapability("appium:newCommandTimeout", 120);

	}

	@Test(priority = 1, enabled = true)
	public void LogIn() throws InterruptedException, IOException {

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(AppiumBy.id("com.androidsample.generalstore:id/nameField")))
				.sendKeys("Tasneem");

		Thread.sleep(3000);
		driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))"
				+ ".scrollIntoView(new UiSelector().text(\"Argentina\"))")).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		
		Date mydate = new Date();

		String filename = mydate.toString().replace(":", "-");

		TakesScreenshot ts = (TakesScreenshot) driver;

		File file = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("screenshots/" + filename + ".jpg"));

		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		Thread.sleep(1000);
		Assert.assertTrue(driver.findElement(By.xpath(
				"(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[1]"))
				.isDisplayed());

	}

	@Test(priority = 2, enabled = true)
	public void AddTheFirst2ProductsToTheCart() throws InterruptedException, IOException {
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(
				"(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[1]"))
				.click();

		driver.findElement(By.xpath(
				"(//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"])[2]"))
				.click();
		Date mydate = new Date();

		String filename = mydate.toString().replace(":", "-");

		TakesScreenshot ts = (TakesScreenshot) driver;

		File file = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("screenshots/" + filename + ".jpg"));
	
		
		}
		
		
	
	@Test(priority = 3, enabled = true)
	public void Done() throws InterruptedException, IOException {

		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath(
				"//android.widget.CheckBox[@text=\"Send me e-mails on discounts related to selected products in future\"]"))
				.click();
		Date mydate = new Date();

		String filename = mydate.toString().replace(":", "-");

		TakesScreenshot ts = (TakesScreenshot) driver;

		File file = ts.getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(file, new File("screenshots/" + filename + ".jpg"));

		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

		Thread.sleep(4000);

		if (driver != null) {
			driver.quit();
		}

	}

}

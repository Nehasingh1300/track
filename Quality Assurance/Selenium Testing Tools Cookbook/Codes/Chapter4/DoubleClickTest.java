package com.secookbook.examples.chapter4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
public class DoubleClickTest {
	 @Test
	 public void testDoubleClick() throws Exception {
		 System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Neha\\\\Documents\\\\sem4\\\\BRM\\\\chromedriver_win32\\\\chromedriver.exe");
		 WebDriver driver = new ChromeDriver();
		 driver.get("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");
		 try {
			 WebElement message = driver.findElement(By.id("message"));
			 // Verify color is Blue
			 assertEquals("rgba(0, 0, 255, 1)",message.getCssValue("background-color"));
			 driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS); //just to make things visible
			 Actions builder = new Actions(driver);
			 builder.doubleClick(message).perform();
			 driver.manage().timeouts().implicitlyWait(7000, TimeUnit.SECONDS);
			 // Verify Color is Yellow
			 assertEquals("rgba(255, 255, 0, 1)",
			 message.getCssValue("background-color"));
			 driver.manage().timeouts().implicitlyWait(700, TimeUnit.SECONDS);
		 } finally {
			 driver.quit();
		 }
	 }
}

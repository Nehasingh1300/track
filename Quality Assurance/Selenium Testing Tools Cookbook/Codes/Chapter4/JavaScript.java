package com.secookbook.examples.chapter4;	
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;
import static org.junit.Assert.*;
public class testContextMenu {
	 private WebDriver driver;
	 @Before
	 public void setUp() {
		 System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Neha\\\\Documents\\\\sem4\\\\BRM\\\\chromedriver_win32\\\\chromedriver.exe");
		 // Launch Chrome
		 driver = new ChromeDriver();
		 // Maximize the browser window
		 driver.manage().window().maximize();
		 // Navigate to Google
		 driver.get("http://www.google.com");
	 }
	 @Test
	 public void testJavaScriptCalls() throws Exception {
	  WebDriver driver = new ChromeDriver();
	  driver.get("http://www.google.com");
	  try {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  String title = (String) js.executeScript("return document.title");
	  assertEquals("Google", title);
	  long links = (Long) js.executeScript("var links = document.getElementsByTagName('A'); return links.length");
	  assertEquals(30, links);
	  } finally {
	  driver.quit();
	  }
	 }
	 
	 @After
	 public void tearDown() throws Exception {
		 // Close the browser
		 driver.quit();
	 }
}

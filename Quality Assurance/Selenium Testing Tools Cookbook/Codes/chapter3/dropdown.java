package com.secookbook.examples.chapter3;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.List;
public class dropdown {
	 private WebDriver driver;
	 @Before
	 public void setUp() {
		 System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Neha\\\\Documents\\\\sem4\\\\BRM\\\\chromedriver_win32\\\\chromedriver.exe");
		 // Launch Chrome
		 driver = new ChromeDriver();
		 // Maximize the browser window
		 driver.manage().window().maximize();
		 // Navigate to webfx
		 driver.get("https://elastic-curie-c5e57f.netlify.app/");
	 }
	 @Test
	 public void testDropdown() {
	  // Get the Dropdown as a Select using it's name attribute
	  Select make = new Select(driver.findElement(By.xpath("/html/body/div/select")));
	  // Verify Dropdown does not support multiple selection
	  assertFalse(make.isMultiple());
	  // Verify Dropdown has four options for selection
      //assertEquals(3, make.getOptions().size());
	  List<WebElement> l = make.getOptions();
	  System.out.println(l.size());
//	  // With Select class we can select an option in Dropdown using 	 Visible text
	  make.selectByVisibleText("Home");
	  assertEquals("Home", make.getFirstSelectedOption().getText());
	   // or we can select an option in Dropdown using value attribute
	  make.selectByValue("About");
	  assertEquals("About", make.getFirstSelectedOption().getText());
	  // or we can select an option in Dropdown using index
	  make.selectByIndex(0);
	  assertEquals("Home", make.getFirstSelectedOption().getText());
	 }
	 
	 @After
	 public void tearDown() throws Exception {
		 // Close the browser
		 driver.quit();
	 }
}

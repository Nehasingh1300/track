// Setting up with Selenium WebDriver -> Check this video -> https://medium.com/learn-together/testing-with-selenium-webdriver-cc9af9196b79)
// It had all absic things that you can learn from the above link
package com.secookbook.examples.chapter1;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.*;
import static org.junit.Assert.*;
public class GoogleSearchTestOnChrome {
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
 public void testGoogleSearch() {
 // Find the text input element by its name
 WebElement element = driver.findElement(By.name("q"));
 // Enter something to search for
 element.sendKeys("Selenium testing tools cookbook");
 // Now submit the form. WebDriver will find
 // the form for us from the element
 element.submit();
 // Google's search is rendered dynamically with JavaScript.
 // Wait for the page to load, timeout after 10 seconds
 new WebDriverWait(driver, 10).until(new ExpectedCondition<Boolean>() {
	 public Boolean apply(WebDriver d) {
	 return d.getTitle().toLowerCase().startsWith("selenium testing tools cookbook");
	 }
 });
 assertEquals("Selenium testing tools cookbook - Google Search", driver.getTitle());
 }
 
 @After
 public void tearDown() throws Exception {
 // Close the browser
 driver.quit();
 }
}

// This chapter has various connections but I prefer Google Chrome
